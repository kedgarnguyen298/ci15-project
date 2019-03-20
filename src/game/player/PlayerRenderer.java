package game.player;

import game.GameObject;
import game.GameWindow;
import game.renderer.AnimationRenderer;
import game.renderer.Renderer;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;

public class PlayerRenderer extends Renderer {
    AnimationRenderer upAnimation;
    AnimationRenderer headAnimation;
    AnimationRenderer downAnimation;

    public PlayerRenderer() {
        upAnimation = new AnimationRenderer("assets/sprites/bluebird-upflap", 10);
        headAnimation = new AnimationRenderer("assets/sprites/bluebird-midflap", 10);
        downAnimation = new AnimationRenderer("assets/sprites/bluebird-downflap", 10);
    }

    int renderCount;
    @Override
    public void render(Graphics g, GameObject master) {
        Player player = (Player) master;
        renderCount++;
        if(renderCount % 2 == 0) {
            return;
        }
        if(master.velocity.y < 0) {
            downAnimation.render(g, master);
        } else if(master.velocity.y > 0) {
            upAnimation.render(g, master);
        } else {
            headAnimation.render(g, master);
        }
    }

//    @Override
//    public void render(Graphics g, GameObject master) {
//        Player player = (Player) master;
//        if(GameWindow.isJumpPress) {
//            jumpAnimation.render(g, master);
//        } else {
//            fallAnimation.render(g, master);
//        }
//    }
}
