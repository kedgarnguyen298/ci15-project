package game.enemy;

import game.GameObject;
import game.Settings;
import tklibs.SpriteUtils;

public class EnemyBullet extends GameObject {
    public EnemyBullet() {
        this.image = SpriteUtils.loadImage("assets/images/enemies/bullets/red.png");
        this.velocity.set(0, 4);
    }

    @Override
    public void run() {
        super.run();
        deactiveIfNeeded();
    }

    private void deactiveIfNeeded() {
        if (this.position.x < -10 || this.position.x >= Settings.BACKGROUND_WIDTH - 11 || this.position.y < -30 || this.position.y > Settings.GAME_HEIGHT) {
            this.deactive();
        }
    }
}

