package game.renderer;

import game.GameObject;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class AnimationRenderer extends Renderer{
    public ArrayList<BufferedImage> images;
    public int currentImageIndex;
    public int changeImageCount;
    public int frameChange;

    public AnimationRenderer(ArrayList<BufferedImage> images
            , int frameChange) {
        this.images = images;
        this.currentImageIndex = 0;
        this.changeImageCount = 0;
        this.frameChange = frameChange;
    }

    public AnimationRenderer(String directoryPath, int frameChange) {
        File folder = new File(directoryPath);
        ArrayList<BufferedImage> images = new ArrayList<>();
        for(String fileName : folder.list()) {
            images.add(SpriteUtils.loadImage(directoryPath + "/" + fileName));
        }
        this.images = images;
        this.currentImageIndex = 0;
        this.changeImageCount = 0;
        this.frameChange = frameChange;
    }

    @Override
    public void render(Graphics g, GameObject master) {
        BufferedImage currentImage = images.get(currentImageIndex);
        g.drawImage(
                currentImage,
                (int) (master.position.x - master.anchor.x * currentImage.getWidth()),
                (int) (master.position.y - master.anchor.y * currentImage.getHeight()),
                null
        );

        changeImageCount++;
        if(changeImageCount > frameChange) {
            currentImageIndex++;
            if(currentImageIndex >= images.size()) {
                currentImageIndex = 0;
            }
            changeImageCount = 0;
        }
    }
}
