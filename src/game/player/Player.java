package game.player;

import game.GameObject;
import game.GameWindow;
import game.Settings;
import game.physics.BoxCollider;

import java.awt.*;

public class Player extends GameObject {

    public Player() {
        collider = new BoxCollider(this, Settings.PLAYER_WIDTH, Settings.PLAYER_HEIGHT);
        renderer = new PlayerRenderer();
        position.set(50, 300);
    }

    @Override
    public void render(Graphics g) {
        renderer.render(g, this);
    }

    @Override
    public void run() {
        super.run();
        playerMove();
    }

    private void playerMove() {
        if(GameWindow.isJumpPress) {
            position.y -= 10;
        } else {
            position.y +=4;
        }
    }
}
