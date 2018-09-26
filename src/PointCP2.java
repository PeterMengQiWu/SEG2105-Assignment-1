
public class PointCP2 extends PointCP{
	//Instance variables ************************************************

	/**
	 * Contains C(artesian) or P(olar) to identify the type of
	 * coordinates that are being dealt with.
	 */
	private char typeCoord;

	/**
	 * Contains the current value of X or RHO depending on the type
	 * of coordinates.
	 */
	private double xOrRho;

	/**
	 * Contains the current value of Y or THETA value depending on the
	 * type of coordinates.
	 */
	private double yOrTheta;


	//Constructors ******************************************************

	/**
	 * Constructs a coordinate object, with a type identifier.
	 */
	public PointCP2(char type, double xOrRho, double yOrTheta)
	{
		super(type, xOrRho, yOrTheta);
	}
	
	@Override
	public double getRho()
	{
		if(typeCoord == 'P') 
			return xOrRho;
		else 
			xOrRho = Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2));
			return xOrRho;
	}

	public double getTheta()
	{
		if(typeCoord == 'P')
			return yOrTheta;
		else 
			yOrTheta = Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
			return Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
	}

}
