package mathengine.matrix;

public class TransformationMatrices {
    private TransformationMatrices() {

    }

    public static IMatrix sckew2d(double k) {
        double[][] data = { { 1, k, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
        return new Matrix(data);
    }

    public static IMatrix scale2d(double kx, double ky) {
        double[][] data = { { kx, 0, 0 }, { 0, ky, 0 }, { 0, 0, 1 } };
        return new Matrix(data);
    }

    public static IMatrix scale2dX(double k) {
        return TransformationMatrices.scale2d(k, 1);
    }

    public static IMatrix scale2dY(double k) {
        return TransformationMatrices.scale2d(1, k);
    }

    public static IMatrix squeeze2dX(double k) {
        return TransformationMatrices.scale2d(k, 1.0 / k);
    }

    public static IMatrix squeeze2dY(double k) {
        return TransformationMatrices.scale2d(1.0 / k, k);
    }

    public static IMatrix rotate2d(double theta) {
        var cosTheta = Math.cos(theta);
        var sinTheta = Math.sin(theta);
        double[][] data = { { cosTheta, sinTheta, 0 }, { -sinTheta, cosTheta, 0 }, { 0, 0, 1 } };
        return new Matrix(data);
    }

    public static IMatrix reverseRotate2d(double theta) {
        var cosTheta = Math.cos(theta);
        var sinTheta = Math.sin(theta);
        double[][] data = { { cosTheta, -sinTheta, 0 }, { sinTheta, cosTheta, 0 }, { 0, 0, 1 } };
        return new Matrix(data);
    }

    public static IMatrix shear2d(double kx, double ky) {
        double[][] data = { { 1, kx, 0 }, { ky, 1, 0 }, { 0, 0, 1 } };
        return new Matrix(data);
    }

    public static IMatrix shear2dX(double k) {
        return TransformationMatrices.shear2d(k, 0);
    }

    public static IMatrix shear2dY(double k) {
        return TransformationMatrices.shear2d(0, k);
    }

    public static IMatrix translate2d(double tx, double ty) {
        double[][] data = { { 1, 0, tx }, { 0, 1, ty }, { 0, 0, 1 } };
        return new Matrix(data);
    }
}
