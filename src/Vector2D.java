public class Vector2D implements IVector {
    private final double x;
    private final double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double abs() {
        return Math.sqrt((x * x) + (y * y));
    }

    @Override
    public double cdot(IVector vector) {
        double[] coords = vector.getComponents();
        return x * coords[0] + y * coords[1];
    }

    @Override
    public double[] getComponents() {
        return new double[]{x, y, 0};
    }
}
