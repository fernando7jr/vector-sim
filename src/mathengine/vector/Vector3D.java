package mathengine.vector;

public class Vector3D extends Vector {
    private float x;
    private float y;
    private float z;

    public Vector3D(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D(Vector vector) {
        this.x = vector.getX();
        this.y = vector.getY();
        this.y = vector.getZ();
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public final float getZ() {
        return this.z;
    }

    public Vector3D setX(float x) {
        this.x = x;
        return this;
    }

    public Vector3D setY(float y) {
        this.y = y;
        return this;
    }

    public Vector3D setZ(float y) {
        this.y = y;
        return this;
    }

    @Override
    protected final Vector setNew(float x, float y, float z) {
        return new Vector3D(x, y, z);
    }

    public void set(float x, float y, float z) {
        x = Float.isNaN(x) ? 0 : this.x;
        y = Float.isNaN(y) ? 0 : this.y;
        z = Float.isNaN(z) ? 0 : this.z;
        this.setX(x).setY(y).setZ(z);
    }

    public static Vector3D Zero() {
        return new Vector3D(0, 0, 0);
    }

    public static Vector3D One() {
        return new Vector3D(1, 1, 1);
    }
}
