import game.GamePanel;
import game.GameWindow;
import game.Settings;
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
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GamePanel panel = new GamePanel();
        panel.setPreferredSize(
                new Dimension(Settings.GAME_WIDTH, Settings.GAME_HEIGHT)
        );
        window.add(panel);
        window.pack();
        panel.setBackground(Color.CYAN);

        window.setVisible(true);

        panel.gameLoop();

//        ArrayList<Vector2D> vectors = new ArrayList<>();
//        vectors.add(new Vector2D(1, 2));
//        vectors.add(new Vector2D(3, 3));
//        vectors.add(new Vector2D(2, 2));
//        vectors.add(new Vector2D(4, 1));
//
//        //TODO: tim vector co tong (x + y) lon nhat va in ra man hinh
//
//        double max = 0;
//        int maxIndex = 0;
//        for(int i = 0; i < vectors.size(); i++) {
//            Vector2D vector = vectors.get(i);
//            if(vector.x + vector.y > max) {
//                max = vector.x + vector.y;
//                maxIndex = i;
//            }
//        }
//
//        Vector2D vectorMax = vectors.get(maxIndex);
//        System.out.println(vectorMax.x + " " + vectorMax.y);
    }
}
