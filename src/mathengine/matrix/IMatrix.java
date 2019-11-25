package mathengine.matrix;

public interface IMatrix {
    int getWidth();

    int getHeight();

    double getAt(int x, int y);

    void setAt(int x, int y, double value);

    IMatrix transpose();

    IMatrix negative();

    IMatrix multiply(MatrixLike matrix);

    IMatrix multiply(IMatrix matrix);

    IMatrix sum(MatrixLike matrix);

    IMatrix sum(IMatrix matrix);

    IMatrix subtract(MatrixLike matrix);

    IMatrix subtract(IMatrix matrix);
}
