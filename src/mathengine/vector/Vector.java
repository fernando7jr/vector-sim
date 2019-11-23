package mathengine.vector;

public abstract class Vector {
    protected abstract Vector setNew(float x, float y, float z);

    public abstract float getX();

    public abstract float getY();

    public abstract float getZ();

    public abstract void set(float x, float y, float z);

    public void set(float value) {
        this.set(value, value, value);
    }

    public void set(Vector vector) {
        this.set(vector.getX(), vector.getY(), vector.getZ());
    }

    public float getSquaredSum() {
        var x = this.getX();
        var y = this.getY();
        var z = this.getZ();
        return x * x + y * y + z * z;
    }

    public float getMagnitude() {
        var squaredSum = this.getSquaredSum();
        if (squaredSum == 0.0) {
            return 0.0f;
        }
        return (float) Math.sqrt(squaredSum);
    }

    public Vector normalize() {
        var magnitude = this.getMagnitude();
        var x = this.getX() / magnitude;
        var y = this.getY() / magnitude;
        var z = this.getZ() / magnitude;
        return this.setNew(x, y, z);
    }

    public boolean equals(float x, float y, float z) {
        return this.getX() == x && this.getY() == y && this.getZ() == z;
    }

    public boolean equals(float x, float y) {
        return this.equals(x, y, this.getZ());
    }

    public boolean equals(Vector vector) {
        return this.equals(vector.getX(), vector.getY(), vector.getZ());
    }

    public boolean equals(Object object) {
        if (object instanceof Vector) {
            return this.equals((Vector) object);
        }
        return false;
    }

    public Vector negative() {
        return this.setNew(-this.getX(), -this.getY(), -this.getZ());
    }

    public Vector sum(float x, float y, float z) {
        return this.setNew(this.getX() + x, this.getY() + y, this.getZ() + z);
    }

    public Vector sum(float value) {
        return this.sum(value, value, value);
    }

    public Vector sum(Vector vector) {
        return this.sum(vector.getX(), vector.getY(), vector.getZ());
    }

    public Vector subtract(float x, float y, float z) {
        return this.setNew(this.getX() - x, this.getY() - y, this.getZ() - z);
    }

    public Vector subtract(float value) {
        return this.subtract(value, value, value);
    }

    public Vector subtract(Vector vector) {
        return this.subtract(vector.getX(), vector.getY(), vector.getZ());
    }

    public Vector multiply(float x, float y, float z) {
        return this.setNew(this.getX() * x, this.getY() * y, this.getZ() * z);
    }

    public Vector multiply(float value) {
        return this.multiply(value, value, value);
    }

    public Vector multiply(Vector vector) {
        return this.multiply(vector.getX(), vector.getY(), vector.getZ());
    }

    public Vector divide(float x, float y, float z) {
        return this.setNew(this.getX() / x, this.getY() / y, this.getZ() / z);
    }

    public Vector divide(float value) {
        return this.divide(value, value, value);
    }

    public Vector divide(Vector vector) {
        return this.divide(vector.getX(), vector.getY(), vector.getZ());
    }

    public Vector distanceVector(Vector vector) {
        var distanceVector = vector.subtract(this);
        var x = distanceVector.getX();
        var y = distanceVector.getY();
        var z = distanceVector.getZ();
        return this.setNew(x, y, z);
    }

    public float distance(Vector vector) {
        return this.distanceVector(vector).getMagnitude();
    }

    public Vector direction(Vector vector) {
        return this.distanceVector(vector).normalize();
    }

    /*
     * The result of a dot product on two vectors is a sum of the products of the
     * matching components of each vector. Dot products are defined on vectors of
     * all dimensions, but both vectors must have the same dimension (same number of
     * components) to calculate a valid dot product. The result of a dot product is
     * always a scalar.
     */
    public float dot(Vector vector) {
        var x = this.getX() * vector.getX();
        var y = this.getY() * vector.getY();
        var z = this.getZ() * vector.getZ();
        return x + y + z;
    }

    /*
     * The angle in rads between the two vectors
     */
    public float angle(Vector vector) {
        var dotProduct = this.dot(vector);
        var cos = Math.cos(dotProduct);
        return (float) Math.pow(cos, -1);
    }

    /**
     * It is sometimes useful to know how much of one vector is parallel to another,
     * and how much of a vector is perpendicular to another. The part of the vector
     * v that is parallel to vector n is denoted v∥ and the part that is
     * perpendicular to n is denoted v⊥.
     * 
     * Check https://www.3dgep.com/wp-content/uploads/2011/02/VectorProjection.png
     * for a better example.
     * 
     * v⊥=v−n((v⋅n)/∥n∥^2)
     *
     * @param vector the vector to project this one
     * @return the projected vector between this and vector
     * 
     * @see Vector
     */
    public Vector project(Vector vector) {
        var dotProduct = this.dot(vector);
        var vectorMagnitude = vector.getMagnitude();
        float vectorMagnitudeSquared = vectorMagnitude == 1 ? 1 : (float) Math.pow(vectorMagnitude, 2);
        var vector2 = vector.multiply(dotProduct / vectorMagnitudeSquared);
        return this.subtract(vector2);
    }

    /*
     * a x b x c =
     * 
     * | _x _y _z |
     * 
     * | ax ay az |
     * 
     * | bx by bz |
     * 
     * | cx cy cz |
     */
    public Vector cross(Vector vector) {
        var thisX = this.getX();
        var thisY = this.getY();
        var thisZ = this.getZ();
        var vectorX = vector.getX();
        var vectorY = vector.getY();
        var vectorZ = vector.getZ();

        float x = thisY * vectorZ + thisZ * vectorY;
        float y = thisZ * vectorX + thisX * vectorZ;
        float z = thisX * vectorY + thisY * vectorX;
        return this.setNew(x, y, z);
    }
}