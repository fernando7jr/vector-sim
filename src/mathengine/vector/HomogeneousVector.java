package mathengine.vector;

public class HomogeneousVector extends Vector3D {
    private float w;

    public HomogeneousVector(float x, float y, float z, float w) {
        super(x, y, z);
        this.w = w;
    }

    public HomogeneousVector(float x, float y, float z) {
        super(x, y, z);
        this.w = 1.0f;
    }

    public HomogeneousVector(Vector vector, float w) {
        super(vector);
        this.w = 1.0f;
    }

    public float getW() {
        return this.w;
    }

    public Vector getVector() {
        return new Vector3D(this);
    }
}