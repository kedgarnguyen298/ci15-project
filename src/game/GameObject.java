package game;

import game.player.Player;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class GameObject {
    // static: quan li doi tuong
    public static ArrayList<GameObject> objects = new ArrayList<>();

    // Nhiem vu: Tra ra 1 gameObject
    // 1. tim trong objects, neu co phan tu thoa man > reset phan tu do
    // roi tra ra
    // 2. neu khong tim thay phan tu thoa man thi tao moi roi tra ra

    public static <E extends GameObject> E recycle(Class<E> cls) {
        // 1.
        E result = findInactive(cls);
        if(result != null) {
            result.reset();
            return result;
        }
        // 2.
//        return new E();
        try {
            return cls.getConstructor().newInstance();
        } catch(Exception ex) {
            return null;
        }
    }

    public static <E extends GameObject> E findInactive(Class<E> cls) {
        E result = null;
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if(!object.active
                    && object.getClass().isAssignableFrom(cls)) {
                result = (E) object;
            }
        }
        return result;
    }

    public static <E extends GameObject> E find(Class<E> cls) {
//        E ~ Player;
//        cls ~ Player.class;
        E result = null;
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if(object.active
//                    && object instanceof E
                    && object.getClass().isAssignableFrom(cls)) {
                result = (E) object;
            }
        }
        return result;
    }

    // non-static: dinh nghia doi tuong
    public BufferedImage image;
    public ArrayList<BufferedImage> images;
    public int currentImageIndex;
    public int changeImageCount;
    public Vector2D position;
    public Vector2D velocity;
    public boolean active;

    public GameObject() {
        this.currentImageIndex = 0;
        this.changeImageCount = 0;
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.active = true;
        objects.add(this);
    }

    public void render(Graphics g) {
        if(this.image != null) {
            this.renderSingleImage(g);
        } else if(this.images != null) {
            this.renderAnimation(g);
        }
    }

    private void renderAnimation(Graphics g) {
        BufferedImage currentImage = images.get(currentImageIndex);
        g.drawImage(
                currentImage,
                (int) position.x,
                (int) position.y,
                null
        );

        changeImageCount++;
        if(changeImageCount > 10) {
            currentImageIndex++;
            if(currentImageIndex >= images.size()) {
                currentImageIndex = 0;
            }
            changeImageCount = 0;
        }
    }

    private void renderSingleImage(Graphics g) {
        g.drawImage(
                this.image,
                (int) this.position.x,
                (int) this.position.y,
                null
        );
    }

    public void run() {
        this.position.add(this.velocity.x, this.velocity.y);
    }

    public void deactive() {
        this.active = false;
    }

    public void reset() {
        this.active = true;
    }
}
