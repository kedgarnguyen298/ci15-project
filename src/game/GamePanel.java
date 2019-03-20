package game;

import game.background.Background;
import game.background.BackgroundManager;
import game.player.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    BackgroundManager backgroundManager;
    Player player;

    public GamePanel() {
        backgroundManager = new BackgroundManager();
        player = new Player();
    }

    public void gameLoop() {
        long lastTime = 0;
        long delay = 1000 / 60;
        while(true) {
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastTime >= delay) {
                runAll();
                renderAll();
                lastTime = currentTime;
            }
        }
    }

    private void renderAll() {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        // ve anh
        g.fillRect(0, 0, Settings.BACKGROUND_WIDTH, Settings.BACKGROUND_HEIGHT);
        for(int i = 0; i < GameObject.objects.size(); i++) {
            GameObject object = GameObject.objects.get(i);
            if(object.active) {
                object.render(g);
            }
        }
    }

    private void runAll() {
        for(int i = 0; i < GameObject.objects.size(); i++) {
            GameObject object = GameObject.objects.get(i);
            if(object.active) {
                object.run();
            }
        }
        System.out.println(GameObject.objects.size());
    }
}
