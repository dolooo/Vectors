public class Polar2DAdapter implements IVector, IPolar2D {
    private final Vector2D srcVector;

    public Polar2DAdapter(Vector2D vector) {
        this.srcVector = vector;
    }

    @Override
    public double getAngle() {
        double[] coords = srcVector.getComponents();
        return Math.toDegrees(Math.atan(coords[1] / coords[0]));
    }

    @Override
    public double abs() {
        return this.srcVector.abs();
    }

    @Override
    public double cdot(IVector param) {
        return this.srcVector.cdot(param);
    }

    @Override
    public double[] getComponents() {
        return this.srcVector.getComponents();
    }
}
