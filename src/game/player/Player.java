package game.player;

import game.GameObject;
import game.GameWindow;
import game.Settings;
import game.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Player extends GameObject {
    int fireCount;
    int bulletType;
    int changeBulletCount;
    Random random;

    public Player() {
//        image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
//        images = new ArrayList<>();
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/0.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/1.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/2.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/3.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/4.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/5.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/6.png"));
        renderer = new AnimationRenderer(
                "assets/images/players/straight",
                10
        );
        position.set(200, 500);
        fireCount = 0;
        bulletType = 1;
        changeBulletCount = 0;
        random = new Random();
    }

    @Override
    public void run() {
        super.run();
        playerMove();
        playerLimit();
        playerFire();
        changeBulletType();
    }

    private void playerMove() {
        int vX = 0;
        int vY = 0;

        if(GameWindow.isUpPress) { // player move
            vY--;
        }
        if(GameWindow.isRightPress) {
            vX++;
        }
        if(GameWindow.isDownPress) {
            vY++;
        }
        if(GameWindow.isLeftPress) {
            vX--;
        }

        this.velocity.set(vX, vY);
        this.velocity.setLength(1);
    }

    private void playerLimit() {
        double offsetWidth = anchor.x * Settings.PLAYER_WIDTH;
        double offsetHeight = anchor.y * Settings.PLAYER_HEIGHT;
        if(position.x < offsetWidth) { // limit player
            position.x = offsetWidth;
        }
        if(position.x > Settings.BACKGROUND_WIDTH - offsetWidth) {
            position.x = Settings.BACKGROUND_WIDTH - offsetWidth;
        }
        if(position.y < offsetHeight) {
            position.y = offsetHeight;
        }
        if(position.y > Settings.GAME_HEIGHT - offsetHeight) {
            position.y = Settings.GAME_HEIGHT - offsetHeight;
        }
    }

    private void playerFire() {
        fireCount++;
        if(GameWindow.isFirePress && fireCount > 20) {
            for (int i = 0; i < 1; i++) {
//                PlayerBullet bullet = new PlayerBullet();
                PlayerBullet bullet = GameObject.recycle(PlayerBullet.class);
                bullet.loadImageByType(bulletType);
                bullet.position.set(this.position.x, this.position.y);
                bullet.velocity.setAngle(-Math.PI * 0.5);
            }

            fireCount = 0;
        }
    }

    private void changeBulletType() {
        changeBulletCount++;
        if(changeBulletCount > 300) {
            bulletType = 1 + random.nextInt(3);
            changeBulletCount = 0;
        }
    }
}
