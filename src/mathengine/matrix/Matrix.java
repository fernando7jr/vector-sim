package mathengine.matrix;

public class Matrix implements IMatrix {
    protected double[][] data;

    public Matrix(double[][] data) {
        this.data = data;
    }

    public Matrix(int width, int height) {
        this.data = new double[width][height];
    }

    public Matrix(Matrix matrix) {
        var width = matrix.getWidth();
        var height = matrix.getHeight();
        this.data = new double[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.data[i][j] = matrix.data[i][j];
            }
        }
    }

    public Matrix(MatrixLike matrixLike) {
        var matrix = matrixLike.asMatrix();
        var width = matrix.getWidth();
        var height = matrix.getHeight();
        this.data = new double[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.data[i][j] = matrix.getAt(i, j);
            }
        }
    }

    public static Matrix matrix2x2(double n) {
        double[][] data = { { n, n }, { n, n }, };
        return new Matrix(data);
    }

    public static Matrix matrix2x2() {
        return Matrix.matrix2x2(0);
    }

    public static Matrix matrix3x3(double n) {
        double[][] data = { { n, n, n }, { n, n, n }, { n, n, n }, };
        return new Matrix(data);
    }

    public static Matrix matrix3x3() {
        return Matrix.matrix3x3(0);
    }

    public static Matrix matrix4x4(double n) {
        double[][] data = { { n, n, n, n }, { n, n, n, n }, { n, n, n, n }, { n, n, n, n } };
        return new Matrix(data);
    }

    public static Matrix matrix4x4() {
        return Matrix.matrix4x4(0);
    }

    public static Matrix identity2x2() {
        double[][] data = { { 1, 0 }, { 0, 1 }, };
        return new Matrix(data);
    }

    public static Matrix identity3x3() {
        double[][] data = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 }, };
        return new Matrix(data);
    }

    public static Matrix identity4x4() {
        double[][] data = { { 1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } };
        return new Matrix(data);
    }

    protected static double getSafeAt(IMatrix matrix, int x, int y) {
        var width = matrix.getWidth();
        var height = matrix.getHeight();
        if (x >= width || x < 0) {
            return 0;
        } else if (y >= height || y < 0) {
            return 0;
        }
        return matrix.getAt(x, y);
    }

    private double getSafeAt(int x, int y) {
        return Matrix.getSafeAt(this, x, y);
    }

    public int getWidth() {
        return this.data.length;
    }

    public int getHeight() {
        return this.data[0].length;
    }

    public double getAt(int x, int y) {
        x = x < 0 ? this.data.length - x : x;
        var valuesX = this.data[x];
        y = y < 0 ? valuesX.length - y : y;
        return valuesX[y];
    }

    public void setAt(int x, int y, double value) {
        x = x < 0 ? this.data.length - x : x;
        var valuesX = this.data[x];
        y = y < 0 ? valuesX.length - y : y;
        valuesX[y] = value;
    }

    public IMatrix transpose() {
        var width = this.getWidth();
        var height = this.getHeight();
        var data = new double[height][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                data[j][i] = this.data[i][j];
            }
        }
        return new Matrix(data);
    }

    public IMatrix negative() {
        var width = this.getWidth();
        var height = this.getHeight();
        var data = new double[height][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                data[i][j] = -this.data[i][j];
            }
        }
        return new Matrix(data);
    }

    public IMatrix multiply(IMatrix matrix) {
        var thisWidth = this.getWidth();
        var thisHeight = this.getHeight();
        var matrixWidth = matrix.getWidth();
        var matrixHeight = matrix.getHeight();

        if (thisWidth == 0 || thisHeight != matrixWidth)
            return null; // invalid dims

        int n = thisHeight;
        int m = thisWidth;
        int p = matrixHeight;

        double data[][] = new double[m][p];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    data[i][j] += this.getAt(i, k) * matrix.getAt(k, j);
                }
            }
        }
        return new Matrix(data);
    }

    public IMatrix multiply(MatrixLike matrixLike) {
        return this.multiply(matrixLike.asMatrix());
    }

    public IMatrix sum(IMatrix matrix) {
        var width = Math.max(this.getWidth(), matrix.getWidth());
        var height = Math.max(this.getHeight(), matrix.getHeight());
        var data = new double[height][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                data[j][i] = this.getSafeAt(i, j) + Matrix.getSafeAt(matrix, i, j);
            }
        }
        return new Matrix(data);
    }

    public IMatrix sum(MatrixLike matrixLike) {
        return this.sum(matrixLike.asMatrix());
    }

    public IMatrix subtract(IMatrix matrix) {
        var width = Math.max(this.getWidth(), matrix.getWidth());
        var height = Math.max(this.getHeight(), matrix.getHeight());
        var data = new double[height][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                data[j][i] = this.getSafeAt(i, j) - Matrix.getSafeAt(matrix, i, j);
            }
        }
        return new Matrix(data);
    }

    public IMatrix subtract(MatrixLike matrixLike) {
        return this.subtract(matrixLike.asMatrix());
    }
}
