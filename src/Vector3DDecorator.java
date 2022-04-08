public class Vector3DDecorator implements IVector {
    private final IVector srcVector;
    private final double z;

    public Vector3DDecorator(double x, double y, double z) {
        this.srcVector = new Vector2D(x, y);
        this.z = z;
    }

    @Override
    public double abs() {
        double[] coords = srcVector.getComponents();
        return Math.sqrt((coords[0] * coords[0]) + (coords[1] * coords[1]) + (z * z));
    }

    @Override
    public double cdot(IVector vector) {
        double[] thisCoords = this.getComponents();
        double[] coords = vector.getComponents();
        return thisCoords[0] * coords[0] + thisCoords[1] * coords[1] + thisCoords[2] * coords[2];
    }

    @Override
    public double[] getComponents() {
        double[] coords = srcVector.getComponents();

        return new double[]{coords[0], coords[1], this.z};
    }

    public Vector3DDecorator cross(IVector vector) {
        double[] thisCoords = this.getComponents();
        double[] coords = vector.getComponents();

        double x = thisCoords[1] * coords[2] - thisCoords[2] * coords[1];
        double y = thisCoords[2] * coords[0] - thisCoords[0] * coords[2];
        double z = thisCoords[0] * coords[1] - thisCoords[1] * coords[0];
        return new Vector3DDecorator(x, y, z);
    }

    public IVector getSrcV() {
        return srcVector;
    }
}
