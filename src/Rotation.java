public class Rotation extends Matrix22 {
    private final double angle;

    public Rotation(double a) {
        super(Math.sin(Math.toRadians(a)), Math.cos(Math.toRadians(a)),
                -1 * Math.cos(Math.toRadians(a)), Math.sin(Math.toRadians(a)));
        this.angle = a;
    }

    public double getAngle() {
        return angle;
    }
}
