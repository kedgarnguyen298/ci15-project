package game.player;

import game.GameObject;
import game.Settings;
import game.enemy.Enemy;
import game.physics.BoxCollider;
import game.renderer.AnimationRenderer;
import game.renderer.Renderer;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject {
    static SingleImageRenderer type1Image = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png"));
    static SingleImageRenderer type2Image = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/enemies/bullets/cyan.png"));
    static SingleImageRenderer type3Image = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/enemies/bullets/green.png"));

    public int damage;

    public PlayerBullet() {
        velocity.set(1, 1);
        velocity.setLength(Settings.PLAYER_BULLET_SPEED);
        collider = new BoxCollider(this, 10, 10);
        damage = 1;
    }

    @Override
    public void run() {
        super.run();
        deactiveIfNeeded();
        checkIntersects();
    }

    private void checkIntersects() {
        Enemy enemy = GameObject.findIntersects(Enemy.class, collider);
        if(enemy != null) {
            deactive();
            enemy.takeDamage(damage);
        }
    }

    private void deactiveIfNeeded() {
        if(this.position.y < -30) {
            this.deactive();
        }
    }

    public void loadImageByType(int type) {
        switch (type) {
            case 1:
                this.renderer = type1Image;
                break;
            case 2:
                this.renderer = type2Image;
                break;
            case 3:
                this.renderer = type3Image;
                break;
            default:
                this.renderer = type1Image;
        }
    }

}
