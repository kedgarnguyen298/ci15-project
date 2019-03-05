package game.enemy;

import game.GameObject;
import game.player.Player;
import game.Settings;
import game.Vector2D;
import tklibs.SpriteUtils;

public class Enemy extends GameObject {
    int fireCount;

    public Enemy() {
        image = SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png");
        position.set(-50, -50);
        velocity.set(2, 2);
        velocity.setAngle(Math.PI / 18);
        velocity.setLength(Settings.ENEMY_SPEED);
        fireCount = 0;
    }

    @Override
    public void run() {
        super.run();
        changeVelocity();
        fire();
    }

    private void fire() {
        fireCount++;
        if(fireCount > 10) {
            // 1. Tao ra vien dan
            EnemyBullet bullet = GameObject.recycle(EnemyBullet.class);
            bullet.position.set(this.position);

            // 2. Tinh toan vector tro tu Enemy >> den Player
            Player player = GameObject.find(Player.class);
            Vector2D enemyToPlayer = player.position.clone();
            enemyToPlayer.minus(this.position);
            enemyToPlayer.setLength(4);

            // 3. Dat bullet velocity = vector vua tinh toan
            bullet.velocity.set(enemyToPlayer);

            fireCount = 0;
        }
    }

    private void changeVelocity() {
        if(position.x > Settings.BACKGROUND_WIDTH - Settings.ENEMY_WIDTH
                && velocity.x > 0) {
            velocity.set(-velocity.x, velocity.y);
        }
        if(position.x < 0 && velocity.x < 0) {
            velocity.set(-velocity.x, velocity.y);
        }
        if(position.y > Settings.GAME_HEIGHT - Settings.ENEMY_HEIGHT
                && velocity.y > 0) {
            velocity.set(velocity.x, -velocity.y);
        }
        if(position.y < 0 && velocity.y < 0) {
            velocity.set(velocity.x, -velocity.y);
        }
    }
}
