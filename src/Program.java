import game.GamePanel;
import game.GameWindow;
import game.Setting;
import game.Vector2D;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
    public static void main(String[] args) {
        GameWindow window = new GameWindow();
        window.setTitle("Game Touhou");
//        window.setSize(800, 600);
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GamePanel panel = new GamePanel();
        panel.setPreferredSize(new Dimension(Setting.GAME_WIDTH, Setting.GAME_HEIGHT));
        window.add(panel);
        window.pack();
        panel.setBackground(Color.CYAN);

        window.setVisible(true);

        panel.gameLoop();

   }
}
