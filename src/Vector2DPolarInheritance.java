public class Vector2DPolarInheritance extends Vector2D {
    public Vector2DPolarInheritance(double x, double y) {
        super(x, y);
    }

    public double getAngle() {
        double[] coords = this.getComponents();
        return Math.toDegrees(Math.atan(coords[1] / coords[0]));
    }
}
