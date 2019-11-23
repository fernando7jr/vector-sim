package mathengine.vector;

public class Vector2D extends Vector {
    private float x;
    private float y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(Vector vector) {
        this.x = vector.getX();
        this.y = vector.getY();
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public final float getZ() {
        return 0;
    }

    public Vector2D setX(float x) {
        this.x = x;
        return this;
    }

    public Vector2D setY(float y) {
        this.y = y;
        return this;
    }

    @Override
    protected final Vector setNew(float x, float y, float z) {
        return new Vector2D(x, y);
    }

    public void set(float x, float y, float z) {
        x = Float.isNaN(x) ? 0 : this.x;
        y = Float.isNaN(y) ? 0 : this.y;
        this.setX(x).setY(y);
    }

    public void set(float x, float y) {
        this.set(x, y, this.getZ());
    }

    public static Vector2D Zero() {
        return new Vector2D(0, 0);
    }

    public static Vector2D One() {
        return new Vector2D(1, 1);
    }

    public Vector sum(float x, float y) {
        return this.sum(x, y, 0);
    }

    public Vector subtract(float x, float y) {
        return this.subtract(x, y, 0);
    }
}
