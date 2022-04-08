public class Vector3DInheritance extends Vector2D {
    private double z;

    public Vector3DInheritance(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double abs() {
        double[] coords = this.getComponents();
        return Math.sqrt(coords[0] * coords[0] + coords[1] * coords[1] + this.z * this.z);
    }

    public double cdot(IVector vector) {
        double[] thisCoords = this.getComponents();
        double[] coords = vector.getComponents();
        double x = coords[0];
        double y = coords[1];
        if (coords.length > 2) {
            double z = coords[2];
        } else z = 0;
        return thisCoords[0] * coords[0] + thisCoords[1] * coords[1] + thisCoords[2] * coords[2];
    }

    public double[] getComponents() {
        double[] coords = super.getComponents();
        return new double[]{coords[0], coords[1], this.z};
    }

    public Vector3DInheritance cross(IVector vector) {
        double[] thisCoords = this.getComponents();
        double[] coords = vector.getComponents();

        double x = thisCoords[1] * coords[2] - thisCoords[2] * coords[1];
        double y = thisCoords[2] * coords[0] - thisCoords[0] * coords[2];
        double z = thisCoords[0] * coords[1] - thisCoords[1] * coords[0];
        return new Vector3DInheritance(x, y, z);
    }

    public IVector getSrcV() {
        double[] thisCoords = super.getComponents();
        return new Vector2D(thisCoords[0], thisCoords[1]);
    }
}
