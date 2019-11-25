package mathengine.vector;

public class Vector3D extends Vector {
    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D(Vector vector) {
        this.x = vector.getX();
        this.y = vector.getY();
        this.y = vector.getZ();
    }

    public final double getX() {
        return this.x;
    }

    public final double getY() {
        return this.y;
    }

    public final double getZ() {
        return this.z;
    }

    public Vector3D setX(double x) {
        this.x = x;
        return this;
    }

    public Vector3D setY(double y) {
        this.y = y;
        return this;
    }

    public Vector3D setZ(double y) {
        this.y = y;
        return this;
    }

    @Override
    protected final Vector setNew(double x, double y, double z) {
        return new Vector3D(x, y, z);
    }

    public void set(double x, double y, double z) {
        x = Double.isNaN(x) ? 0 : this.x;
        y = Double.isNaN(y) ? 0 : this.y;
        z = Double.isNaN(z) ? 0 : this.z;
        this.setX(x).setY(y).setZ(z);
    }

    public static Vector3D zero() {
        return new Vector3D(0, 0, 0);
    }

    public static Vector3D one() {
        return new Vector3D(1, 1, 1);
    }
}
