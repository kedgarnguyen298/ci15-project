package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player {
    BufferedImage image;
    Vector2D position;
    ArrayList<PlayerBullet> bullets;
    int fireCount;
    BufferedImage bulletType2Image;
    BufferedImage bulletType3Image;
    BufferedImage bulletType4Image;
    BufferedImage bulletType5Image;

    public Player() {
        image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        position = new Vector2D(200, 500);
//        bulletImage = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
//        bulletPositions = new ArrayList<>();
        bullets = new ArrayList<>();
        fireCount = 0;
        bulletType2Image = SpriteUtils.loadImage("assets/images/enemies/bullets/red.png");
        bulletType3Image = SpriteUtils.loadImage("assets/images/enemies/bullets/pink.png");
        bulletType4Image = SpriteUtils.loadImage("assets/images/enemies/bullets/yellow.png");
        bulletType5Image = SpriteUtils.loadImage("assets/images/enemies/bullets/white.png");
    }

    public void render(Graphics g) {
        g.drawImage(
                image,
                (int) position.x,
                (int) position.y,
                null
        );
//        for(int i = 0; i < bulletPositions.size(); i++) {
//            Vector2D bulletPosition = bulletPositions.get(i);
//            g.drawImage(
//                    bulletImage,
//                    (int) bulletPosition.x,
//                    (int) bulletPosition.y,
//                    null
//            );
//        }
        for (int i = 0; i < bullets.size(); i++) {
            PlayerBullet bullet = bullets.get(i);
            bullet.render(g);
        }
    }

    private void bulletsRun() {
//        for(int i = 0; i < bulletPositions.size(); i++) {
//            Vector2D bulletPosition = bulletPositions.get(i);
//            bulletPosition.y -= 3;
//        }
        for (int i = 0; i < bullets.size(); i++) {
            PlayerBullet bullet = bullets.get(i);
            bullet.run();
        }
    }

    public void run() {
        playerMove();
        playerLimit();
        playerFire();
        bulletsRun();
    }

    private void playerFire() {
        fireCount++;
        if(GameWindow.isFirePress && fireCount > 20) {
//            Vector2D bulletPosition = new Vector2D(position.x, position.y);
//            bulletPositions.add(bulletPosition);
            PlayerBullet bullet1 = new PlayerBullet();
            bullet1.position.set(this.position.x, this.position.y);
            bullet1.velocity.setAngle(-Math.PI * 0.5);
            bullets.add(bullet1);

            PlayerBullet bullet2 = new PlayerBullet();
            bullet2.image = bulletType2Image;
            bullet2.position.set(this.position.x, this.position.y);
            bullet2.velocity.setAngle(-Math.PI * 0.6);
            bullets.add(bullet2);

            PlayerBullet bullet3 = new PlayerBullet();
            bullet3.image = bulletType3Image;
            bullet3.position.set(this.position.x, this.position.y);
            bullet3.velocity.setAngle(-Math.PI * 0.4);
            bullets.add(bullet3);

            PlayerBullet bullet4 = new PlayerBullet();
            bullet4.image = bulletType4Image;
            bullet4.position.set(this.position.x, this.position.y);
            bullet4.velocity.setAngle(-Math.PI * 0.3);
            bullets.add(bullet4);

            PlayerBullet bullet5 = new PlayerBullet();
            bullet5.image = bulletType5Image;
            bullet5.position.set(this.position.x, this.position.y);
            bullet5.velocity.setAngle(-Math.PI * 0.7);
            bullets.add(bullet5);

            fireCount = 0;
        }
    }

    private void playerLimit() {
        if(position.x < 0) { // limit player
            position.x = 0;
        }
        if(position.x > 384 - 32) {
            position.x = 384 - 32;
        }
        if(position.y < 0) {
            position.y = 0;
        }
        if(position.y > 600 - 48) {
            position.y = 600 - 48;
        }
    }

    private void playerMove() {
        if(GameWindow.isUpPress) { // player move
            position.y--;
        }
        if(GameWindow.isRightPress) {
            position.x++;
        }
        if(GameWindow.isDownPress) {
            position.y++;
        }
        if(GameWindow.isLeftPress) {
            position.x--;
        }
    }
}
