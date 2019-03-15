package game.player;

import game.GameObject;
import game.Settings;
import game.physics.BoxCollider;

import java.awt.*;

public class Player extends GameObject {

    public Player() {
        collider = new BoxCollider(this, Settings.PLAYER_WIDTH, Settings.PLAYER_HEIGHT);
        renderer = new PlayerRenderer();
        position. set(300, 50);
    }

    @Override
    public void render(Graphics g) {
        renderer.render(g, this);
    }

    @Override
    public void run() {
        super.run();
    }
}
