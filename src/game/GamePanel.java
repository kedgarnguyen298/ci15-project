package game;

import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    Background background;
    Player player;
    Enemy enemy;

    public GamePanel() {
        background = new Background();
        player = new Player();
        enemy = new Enemy();
    }

    @Override
    public void paint(Graphics g) {
        // ve anh
        background.render(g);
        player.render(g);
        enemy.render(g);
    }

    public void gameLoop() {
        long lastTime = 0;
        long delay = 1000 / 60;
        while(true) {
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastTime >= delay) {
                // ve anh + chay logic
                runAll();
                renderAll();
                lastTime = currentTime;
            }
        }
    }

    private void renderAll() {
        repaint();
    }

    private void runAll() {
        background.run();
        player.run();
        enemy.run();
    }
}
