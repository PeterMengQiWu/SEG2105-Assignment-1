
public interface Point {
	public double getX();
	public double getY();
	public double getRho();
	public double getTheta();
	public PointCP2 convertStorageToPolar();
	public double getDistance(Point pointB);
	public Point rotatePoint(double rotation);
}
