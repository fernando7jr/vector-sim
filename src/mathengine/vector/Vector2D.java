package mathengine.vector;

public class Vector2D extends Vector {
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(Vector vector) {
        this.x = vector.getX();
        this.y = vector.getY();
    }

    public final double getX() {
        return this.x;
    }

    public final double getY() {
        return this.y;
    }

    public final double getZ() {
        return 0;
    }

    public Vector2D setX(double x) {
        this.x = x;
        return this;
    }

    public Vector2D setY(double y) {
        this.y = y;
        return this;
    }

    @Override
    protected final Vector setNew(double x, double y, double z) {
        return new Vector2D(x, y);
    }

    public void set(double x, double y, double z) {
        x = Double.isNaN(x) ? 0 : this.x;
        y = Double.isNaN(y) ? 0 : this.y;
        this.setX(x).setY(y);
    }

    public void set(double x, double y) {
        this.set(x, y, this.getZ());
    }

    public static Vector2D Zero() {
        return new Vector2D(0, 0);
    }

    public static Vector2D One() {
        return new Vector2D(1, 1);
    }

    public Vector sum(double x, double y) {
        return this.sum(x, y, 0);
    }

    public Vector subtract(double x, double y) {
        return this.subtract(x, y, 0);
    }
}
