package game;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {
    public static boolean isJumpPress;
    public static boolean isFirePress;

    public GameWindow() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    isJumpPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    isFirePress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    isJumpPress = false;
                }

            }
        });
    }

    public void setTitle(java.lang.String game_touhou) {
    }
}
