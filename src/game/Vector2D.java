package game;

public class Vector2D {
    public double x;
    public double y;

    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D clone() {
        return new Vector2D(this.x, this.y);
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void set(Vector2D other) {
        this.set(other.x, other.y);
    }

    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void add(Vector2D other) {
        this.add(other.x, other.y);
    }

    public void minus(double x, double y) {
        this.x -= x;
        this.y -= y;
    }

    public void minus(Vector2D other) {
        this.minus(other.x, other.y);
    }

    public void scale(double rate) {
        this.x *= rate;
        this.y *= rate;
    }

    public double getLength() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public void setLength(double length) {
        double currentLength = this.getLength();
        if(currentLength != 0) {
            this.x = this.x * length / currentLength;
            this.y = this.y * length / currentLength;
        }
    }

    public double getAngle() {
        return Math.atan(this.y / this.x);
    }

    public void setAngle(double angle) {
        double length = this.getLength();
        if(length != 0) {
            this.x = length * Math.cos(angle);
            this.y = length * Math.sin(angle);
        }
    }
}
