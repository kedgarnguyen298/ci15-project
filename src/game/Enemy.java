package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy extends GameObject {

    int fireCount;

    public Enemy() {
        this.image = SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png");
        this.position.set(-50, -50);
        this.velocity.set(2, 2);
        this.velocity.setAngle(Math.PI / 18);
        this.velocity.setLength(3);
        fireCount = 0;
    }

    @Override
    public void run() {
        super.run();
        changeVelocity();
        enemyFire();
    }

    private void enemyFire() {
        fireCount++;
        if(fireCount > 20) {
            for (int i = 0; i < 1 ; i++) {
                EnemyBullet bullet = new EnemyBullet();
                bullet.position.set(this.position.x, this.position.y);
                bullet.velocity.setAngle(Math.PI * 0.5);
            }

            fireCount = 0;
        }
    }

    private void changeVelocity() {
        if(position.x > Setting.BACKGROUND_WIDTH - 28 && velocity.x > 0) {
            velocity.set(-velocity.x, velocity.y);
        }
        if(position.x < 0 && velocity.x < 0) {
            velocity.set(-velocity.x, velocity.y);
        }
        if(position.y > Setting.GAME_HEIGHT - 28 && velocity.y > 0) {
            velocity.set(velocity.x, -velocity.y);
        }
        if(position.y < 0 && velocity.y < 0) {
            velocity.set(velocity.x, -velocity.y);
        }
    }
}
