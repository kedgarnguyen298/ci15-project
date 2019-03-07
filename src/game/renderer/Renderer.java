package game.renderer;

import game.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Renderer {
    public static void drawImage(BufferedImage image
            , Graphics g, GameObject master) {
        g.drawImage(
                image,
                (int) (master.position.x - master.anchor.x * image.getWidth()),
                (int) (master.position.y - master.anchor.y * image.getHeight()),
                null
        );
    }

    public void render(Graphics g, GameObject master) {

    }
}
