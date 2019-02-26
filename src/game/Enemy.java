package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy {
    BufferedImage image;
    Vector2D position;
    Vector2D velocity;

    public Enemy() {
        image = SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png");
        position = new Vector2D(-50, -50);
        velocity = new Vector2D(2, 2);
        velocity.setAngle(Math.PI / 18);
        velocity.setLength(3);
    }

    public void render(Graphics g) {
        g.drawImage(
                image,
                (int) position.x,
                (int) position.y,
                null
        );
    }

    public void run() {
        position.add(velocity.x, velocity.y);
        changeVelocity();
    }

    private void changeVelocity() {
        if(position.x > 384 - 28 && velocity.x > 0) {
            velocity.set(-velocity.x, velocity.y);
        }
        if(position.x < 0 && velocity.x < 0) {
            velocity.set(-velocity.x, velocity.y);
        }
        if(position.y > 600 - 28 && velocity.y > 0) {
            velocity.set(velocity.x, -velocity.y);
        }
        if(position.y < 0 && velocity.y < 0) {
            velocity.set(velocity.x, -velocity.y);
        }
    }
}
