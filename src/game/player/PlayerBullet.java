package game.player;

import game.GameObject;
import game.Settings;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject {
    static BufferedImage type1Image = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
    static BufferedImage type2Image = SpriteUtils.loadImage("assets/images/enemies/bullets/cyan.png");
    static BufferedImage type3Image = SpriteUtils.loadImage("assets/images/enemies/bullets/green.png");

    public PlayerBullet() {
        velocity.set(1, 1);
        velocity.setLength(Settings.PLAYER_BULLET_SPEED);
    }

    @Override
    public void run() {
        super.run();
        deactiveIfNeeded();
    }

    private void deactiveIfNeeded() {
        if(this.position.y < -30) {
            this.deactive();
        }
    }

    public void loadImageByType(int type) {
        switch (type) {
            case 1:
                this.image = type1Image;
                break;
            case 2:
                this.image = type2Image;
                break;
            case 3:
                this.image = type3Image;
                break;
            default:
                this.image = type1Image;
        }
    }

}
