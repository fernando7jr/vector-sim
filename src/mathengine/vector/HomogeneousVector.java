package mathengine.vector;

import mathengine.matrix.MatrixLike;
import mathengine.matrix.IMatrix;
import mathengine.matrix.Matrix;

public class HomogeneousVector extends Vector3D implements MatrixLike {
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

    public IMatrix asMatrix() {
        double[][] data = { { this.getX(), this.getY(), this.getZ(), this.getW() } };
        return new Matrix(data);
    }
}