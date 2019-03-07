package game.enemy;

import game.GameObject;
import game.Settings;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

public class EnemyBullet extends GameObject {
    public EnemyBullet() {
        renderer = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/enemies/bullets/red.png"));
        this.velocity.set(0, 4);
    }

    @Override
    public void run() {
        super.run();
        this.deactiveIfNeeded();
    }

    private void deactiveIfNeeded() {
        if(this.position.y < -30
            || this.position.y > Settings.GAME_HEIGHT + 30
            || this.position.x < -30
            || this.position.x > Settings.BACKGROUND_WIDTH + 30) {
            this.deactive();
        }
    }
}
