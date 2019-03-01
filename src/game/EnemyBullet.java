package game;

import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject {

    public EnemyBullet() {
        image = SpriteUtils.loadImage("assets/images/enemies/bullets/red.png");
        this.velocity.set(3, 3);
        velocity.setLength(3);
    }
}
