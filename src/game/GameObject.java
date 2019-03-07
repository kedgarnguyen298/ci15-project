package game;

import game.physics.BoxCollider;
import game.player.Player;
import game.renderer.Renderer;

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
                break;
            }
        }
        return result;
    }

    public static <E extends GameObject> E findIntersects(Class<E> cls
            , BoxCollider collider) {
        E result = null;
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if(object.active
                && object.getClass().isAssignableFrom(cls)
                && object.collider != null
                && object.collider.intersects(collider)) {
                result = (E) object;
                break;
            }
        }
        return result;
    }

    // non-static: dinh nghia doi tuong
    public Renderer renderer; // = null
    public Vector2D position;
    public Vector2D velocity;
    public Vector2D anchor;
    public boolean active;
    public BoxCollider collider; // = null

    public GameObject() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.anchor = new Vector2D(0.5, 0.5);
        this.active = true;
        objects.add(this);
    }

    public void render(Graphics g) {
        if(renderer != null) {
            renderer.render(g, this);
        }
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
