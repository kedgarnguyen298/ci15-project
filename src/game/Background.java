package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background extends GameObject {

    public Background() {
        this.image = SpriteUtils.loadImage("assets/images/background/0.png");
        this.position.set(0, Settings.GAME_HEIGHT - Settings.BACKGROUND_HEIGHT);
        this.velocity.set(0, Settings.BACKGROUND_SPEED);
    }

    @Override
    public void run() {
        super.run(); // == this.position.add(this.velocity.x, this.velocity.y);
        if(position.y > 0) { // limit background
            position.y = 0;
        }
    }
}
