package game.player;

import game.GameObject;
import game.GameWindow;
import game.Settings;
import game.physics.BoxCollider;

import java.awt.*;
import java.util.Set;

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
        playerLimit();
    }

    private void playerLimit() {
        double offsetWidth = anchor.x * Settings.PLAYER_WIDTH;
        double offsetHeight = anchor.x * Settings.PLAYER_HEIGHT;

        if(position.x < offsetWidth) {
            position.x = offsetWidth;
        }
        if(position.x > Settings.BACKGROUND_WIDTH/2 - offsetWidth) {
            position.x = Settings.BACKGROUND_WIDTH/2 - offsetWidth;
        }
        if(position.y < offsetHeight) {
            position.y = offsetHeight;
        }
        if(position.y > Settings.BACKGROUND_HEIGHT - offsetHeight) {
            position.y = Settings.BACKGROUND_HEIGHT - offsetHeight;
        }
    }

    private void playerMove() {
        if(GameWindow.isJumpPress) {
            position.y -= 10;
        } else {
            position.y +=4;
        }
    }
}
