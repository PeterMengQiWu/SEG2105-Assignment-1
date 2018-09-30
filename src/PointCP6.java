
public interface PointCP6 {
	public double getX();
	public double getY();
	public double getRho();
	public double getTheta();
	public PointCP2 convertStorageToPolar();
	public PointCP3	convertStorageToCartesian();
	public double getDistance(PointCP6 pointB);
	public PointCP6 rotatePoint(double rotation);
}
