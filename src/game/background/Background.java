package game.background;

import game.GameObject;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.util.Set;

public class Background extends GameObject {

    public Background() {
        this.renderer = new SingleImageRenderer(
                SpriteUtils.loadImage("assets/sprites/background.png")
        );
        this.position.set(0, 0);
        this.velocity.set(-5, 0);
        this.anchor.set(0, 0);

    }

//    @Override
//    public void run() {
//        super.run();
//        for(int i=0; i < Settings.BACKGROUND_WIDTH; i++)
//        {
//            this.renderer = new SingleImageRenderer(
//                    SpriteUtils.loadImage("assets/sprites/background.png")
//            );
//        }
//    }
}
//    @Override
//    public void run() {
//        super.run(); // == this.position.add(this.velocity.x, this.velocity.y);
////        if(position.y > 0) { // limit background
////            position.y = 0;
////        }
//    }

