package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject {
    static BufferedImage type1Image = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
    static BufferedImage type2Image = SpriteUtils.loadImage("assets/images/enemies/bullets/green.png");
    static BufferedImage type3Image = SpriteUtils.loadImage("assets/images/enemies/bullets/white.png");

    public PlayerBullet() {
        this.velocity.set(3, 3);
        velocity.setLength((3));
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
