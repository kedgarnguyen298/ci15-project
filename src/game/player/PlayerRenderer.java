package game.player;

import game.GameObject;
import game.GameWindow;
import game.renderer.AnimationRenderer;
import game.renderer.Renderer;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;

public class PlayerRenderer extends Renderer {
    SingleImageRenderer jumpAnimation;
    SingleImageRenderer flyAnimation;
    AnimationRenderer deadAnimation;

    public PlayerRenderer() {
        jumpAnimation = new SingleImageRenderer(SpriteUtils.loadImage("assets/sprites/bluebird-midflap.png"));
        flyAnimation = new SingleImageRenderer(SpriteUtils.loadImage("assets/sprites/bluebird-upflap.png"));
    }

    @Override
    public void render(Graphics g, GameObject master) {
        Player player = (Player) master;
        if(GameWindow.isJumpPress) {
            jumpAnimation.render(g, master);
        } else {
            flyAnimation.render(g, master);
        }
    }
}
