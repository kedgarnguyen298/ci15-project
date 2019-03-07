package game.physics;

import game.GameObject;
import game.Vector2D;

public class BoxCollider {
    public Vector2D position;
    public Vector2D anchor;
    public double width;
    public double height;

    public BoxCollider(GameObject master, double width, double height) {
        this.position = master.position;
        this.anchor = master.anchor;
        this.width = width;
        this.height = height;
    }

    public double top() {
        return this.position.y - anchor.y * height;
    }

    public double bot() {
        return this.top() + this.height;
    }

    public double left() {
        return this.position.x - anchor.x * width;
    }

    public double right() {
        return this.left() + this.width;
    }

    public boolean intersects(BoxCollider other) {
        return other.right() >= this.left()
                && other.left() <= this.right()
                && other.bot() >= this.top()
                && other.top() <= this.bot();
    }
}
