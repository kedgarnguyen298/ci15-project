package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Set;

public class Background extends GameObject {
    public Background() {
        this.image = SpriteUtils.loadImage("assets/images/background/0.png");
//        position = new Vector2D(0, 600 - 3109);
        this.position.set(0, Setting.GAME_HEIGHT - Setting.BACKGROUND_HEIGHT);
        this.velocity.set(0, 1);
    }

    @Override
    public void run() {
        super.run(); // == this.position.add(this.velocity.x, this.velocity.y);
        if(position.y > 0) { // limit background
            position.y = 0;
        }
    }
}
