package game.renderer;

import game.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SingleImageRenderer extends Renderer {
    public BufferedImage image;

    public SingleImageRenderer(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void render(Graphics g, GameObject master) {
        Renderer.drawImage(image, g, master);
    }
}
