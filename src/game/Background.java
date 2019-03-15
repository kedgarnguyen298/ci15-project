package game;

import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.util.Set;

public class Background extends GameObject {

    public Background() {
        this.renderer = new SingleImageRenderer(
                SpriteUtils.loadImage("assets/sprites/background.png")
        );
        this.position.set(0, Settings.BACKGROUND_HEIGHT);
        this.velocity.set(0, Settings.BACKGROUND_SPEED);
        this.anchor.set(0, 0);
    }

//    @Override
//    public void run() {
//        super.run();
//        for(int y=0; y < Settings.BACKGROUND_HEIGHT; y++)
//        {
//            for(int x = 0; x < Settings.BACKGROUND_WIDTH; x++)
//            {
//                this.renderer = new SingleImageRenderer(
//                        SpriteUtils.loadImage("assets/sprites/background.png")
//                );
//            }
//        }
//    }
}
