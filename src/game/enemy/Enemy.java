package game.enemy;

import game.GameObject;
import game.physics.BoxCollider;
import game.player.Player;
import game.Settings;
import game.Vector2D;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;

public class Enemy extends GameObject {
    int fireCount;
    int hp;

    public Enemy() {
        renderer = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png"));
        position.set(-50, -50);
        velocity.set(2, 2);
        velocity.setAngle(Math.PI / 18);
        velocity.setLength(Settings.ENEMY_SPEED);
        fireCount = 0;
        collider = new BoxCollider(this, 28, 28);
        hp = 3;
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
//            EnemyBullet bullet = new EnemyBullet();
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
        double offsetWidth = anchor.x * Settings.ENEMY_WIDTH;
        double offsetHeight = anchor.y * Settings.ENEMY_HEIGHT;
        if(position.x > Settings.BACKGROUND_WIDTH - offsetWidth
                && velocity.x > 0) {
            velocity.set(-velocity.x, velocity.y);
        }
        if(position.x < offsetWidth && velocity.x < 0) {
            velocity.set(-velocity.x, velocity.y);
        }
        if(position.y > Settings.GAME_HEIGHT - offsetHeight
                && velocity.y > 0) {
            velocity.set(velocity.x, -velocity.y);
        }
        if(position.y < offsetHeight && velocity.y < 0) {
            velocity.set(velocity.x, -velocity.y);
        }
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if(hp <= 0) {
            this.deactive();
            hp = 0;
        }
    }

    static Font font = new Font("Verdana", Font.BOLD, 40);
    @Override
    public void render(Graphics g) {
        super.render(g);
        g.setColor(Color.GREEN);
        g.drawRect((int) collider.left(), (int) collider.top()
                , (int) collider.width, (int) collider.height);

        g.setFont(font);
        g.drawString(hp + ""
                , (int) collider.left()
                , (int) collider.top());
    }
}
