
public class PointCP2 implements PointCP6{
	//Instance variables ************************************************
	/**
	 * Contains the current value of RHO depending on the type
	 * of coordinates.
	 */
	private double rho;

	/**
	 * Contains the current value of THETA value depending on the
	 * type of coordinates.
	 */
	private double theta;


	//Constructors ******************************************************

	/**
	 * Constructs a coordinate object, with a type identifier.
	 */
	public PointCP2(char type, double rho, double theta)
	{
		if(type != 'C' && type != 'P')
			throw new IllegalArgumentException();
		this.rho = rho;
		this.theta = theta;
		if(type == 'C') {
			rho = Math.sqrt(Math.pow(rho, 2) + Math.pow(theta, 2));
			theta = Math.toDegrees(Math.atan2(theta, rho));
		}	
	}

	public double getX()
	{
		return (Math.cos(Math.toRadians(theta)) * rho);
	}

	public double getY()
	{
		return (Math.sin(Math.toRadians(theta)) * rho);
	}

	public double getRho()
	{
		return rho;
	}

	public double getTheta()
	{
		return theta;
	}

	/**
	 * Converts Cartesian coordinates to Polar coordinates.
	 */
	public PointCP2 convertStorageToPolar()
	{
		return new PointCP2('P', rho, theta);
	}

	/**
	 * Converts Polar coordinates to Cartesian coordinates.
	 */
	public PointCP3 convertStorageToCartesian() {
		return new PointCP3('C', getX(), getY());
	}

	/**
	 * Calculates the distance in between two points using the Pythagorean
	 * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
	 *
	 * @param pointA The first point.
	 * @param pointB The second point.
	 * @return The distance between the two points.
	 */
	public double getDistance(PointCP6 pointB)
	{
		// Obtain differences in X and Y, sign is not important as these values
		// will be squared later.
		double deltaX = getX() - pointB.getX();
		double deltaY = getY() - pointB.getY();

		return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
	}

	/**
	 * Rotates the specified point by the specified number of degrees.
	 * Not required until E2.30
	 *
	 * @param point The point to rotate
	 * @param rotation The number of degrees to rotate the point.
	 * @return The rotated image of the original point.
	 */
	public PointCP6 rotatePoint(double rotation)
	{
		double radRotation = Math.toRadians(rotation);
		double X = getX();
		double Y = getY();

		return new PointCP2('C',
				(Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
				(Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
	}

	/**
	 * Returns information about the coordinates.
	 *
	 * @return A String containing information about the coordinates.
	 */
	public String toString()
	{
		return "Stored as " + "Polar [" + rho + "," + theta + "]" + "\n";
	}

}
