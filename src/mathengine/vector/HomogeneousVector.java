package mathengine.vector;

public class HomogeneousVector extends Vector3D {
    private double w;

    public HomogeneousVector(double x, double y, double z, double w) {
        super(x, y, z);
        this.w = w;
    }

    public HomogeneousVector(double x, double y, double z) {
        super(x, y, z);
        this.w = 1.0f;
    }

    public HomogeneousVector(Vector vector, double w) {
        super(vector);
        this.w = 1.0f;
    }

    public double getW() {
        return this.w;
    }

    public Vector getVector() {
        var x = this.getX();
        var y = this.getY();
        var z = this.getZ();
        var w = this.getW();
        return new Vector3D(x / w, y / w, z / w);
    }
}