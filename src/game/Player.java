package game;

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
        this.image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        this.position.set(200, 500);
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

    private void playerFire() {
        fireCount++;
        if(GameWindow.isFirePress && fireCount > 10) {
            for (int i = 0; i < 1 ; i++) {
                PlayerBullet bullet1 = new PlayerBullet();
                bullet1.loadImageByType(bulletType);
                bullet1.position.set(this.position.x, this.position.y);
                bullet1.velocity.setAngle(-Math.PI * 0.5);
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

    private void playerLimit() {
        if(position.x < 0) { // limit player
            position.x = 0;
        }
        if(position.x > Setting.BACKGROUND_WIDTH - Setting.PLAYER_WIDTH) {
            position.x = Setting.BACKGROUND_WIDTH - Setting.PLAYER_WIDTH;
        }
        if(position.y < 0) {
            position.y = 0;
        }
        if(position.y > Setting.GAME_HEIGHT - Setting.PLAYER_HEIGHT) {
            position.y = Setting.GAME_HEIGHT - Setting.PLAYER_HEIGHT;
        }
    }

    private void playerMove() {
        int vX = 0;
        int vY = 0;

        if(GameWindow.isUpPress) {
            vY-=2;
        }
        if(GameWindow.isRightPress) {
            vX+=2;
        }
        if(GameWindow.isDownPress) {
            vY+=2;
        }
        if(GameWindow.isLeftPress) {
            vX-=2;
        }

        this.velocity.set(vX, vY);
        this.velocity.setLength(2);
    }
}
