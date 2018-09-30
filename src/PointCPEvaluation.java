import java.math.RoundingMode;
import java.text.DecimalFormat;

public class PointCPEvaluation {

	private static final char[] TYPE = {'P', 'C'};
	private static final int NUMBER_OF_INSTANCES = 5000;
	private static final int NUMBER_OF_TESTS = 20000;
	private static final int NUMBER_OF_METHODS = 8;

	private static PointCP2[] pointCP2 = new PointCP2[NUMBER_OF_INSTANCES];
	private static PointCP3[] pointCP3 = new PointCP3[NUMBER_OF_INSTANCES];
	private static PointCP6[] pointCP6 = new PointCP6[NUMBER_OF_INSTANCES];

	public static void main(String[] args) {

		double[] runningTimeD2 = new double[NUMBER_OF_METHODS];
		double[] runningTimeD3 = new double[NUMBER_OF_METHODS];
		double[] runningTimeD6 = new double[NUMBER_OF_METHODS];

		double methodTimeD2 = 0;
		double methodTimeD3 = 0;
		double methodTimeD6 = 0;

		DecimalFormat df = new DecimalFormat("#.####");
		df.setRoundingMode(RoundingMode.CEILING);

		long startTime = System.nanoTime();
		for(int i = 0; i < NUMBER_OF_INSTANCES; i++) {
			char type = TYPE[(int)(Math.random()*(2))];
			int design = (int)Math.random()*((3-2)+1)+2;

			double x = Double.parseDouble(df.format(Math.random()*((9-0)+1)));
			double y = Double.parseDouble(df.format(Math.random()*((9-0)+1)));
			double rho = Math.random()*((90-0)+1);
			double theta = Math.random()*((90-0)+1);

			pointCP2[i] = (PointCP2) PointCPConstruction(2, type, rho, theta);
			pointCP3[i] = (PointCP3) PointCPConstruction(3, type, x, y);
			if (design == 2) {
				pointCP6[i] = PointCPConstruction(design, type, rho, theta);
			}
			else {
				pointCP6[i] = PointCPConstruction(design, type, x, y);
			}


			methodTimeD2 += TestGetX(pointCP2[i]);
			methodTimeD3 += TestGetX(pointCP3[i]);
			methodTimeD6 += TestGetX(pointCP6[i]);
			runningTimeD2[0] += methodTimeD2;
			runningTimeD3[0] += methodTimeD3;
			runningTimeD6[0] += methodTimeD6;

			methodTimeD2 = methodTimeD3 = methodTimeD6 = 0;

			methodTimeD2 += TestGetY(pointCP2[i]);
			methodTimeD3 += TestGetY(pointCP3[i]);
			methodTimeD6 += TestGetY(pointCP6[i]);
			runningTimeD2[1] += methodTimeD2;
			runningTimeD3[1] += methodTimeD3;
			runningTimeD6[1] += methodTimeD6;

			methodTimeD2 = methodTimeD3 = methodTimeD6 = 0;

			methodTimeD2 += TestGetRho(pointCP2[i]);
			methodTimeD3 += TestGetRho(pointCP3[i]);
			methodTimeD6 += TestGetRho(pointCP6[i]);

			runningTimeD2[2] += methodTimeD2;
			runningTimeD3[2] += methodTimeD3;
			runningTimeD6[2] += methodTimeD6;
			methodTimeD2 = methodTimeD3 = methodTimeD6 = 0;

			methodTimeD2 += TestGetTheta(pointCP2[i]);
			methodTimeD3 += TestGetTheta(pointCP3[i]);
			methodTimeD6 += TestGetTheta(pointCP6[i]);

			runningTimeD2[3] += methodTimeD2;
			runningTimeD3[3] += methodTimeD3;
			runningTimeD6[3] += methodTimeD6;
			methodTimeD2 = methodTimeD3 = methodTimeD6 = 0;
			
			methodTimeD2 += TestConvertStorageToPolar(pointCP2[i]);
			methodTimeD3 += TestConvertStorageToPolar(pointCP3[i]);
			methodTimeD6 += TestConvertStorageToPolar(pointCP6[i]);

			runningTimeD2[4] += methodTimeD2;
			runningTimeD3[4] += methodTimeD3;
			runningTimeD6[4] += methodTimeD6;
			methodTimeD2 = methodTimeD3 = methodTimeD6 = 0;
			
			methodTimeD2 += TestConvertStorageToCartesian(pointCP2[i]);
			methodTimeD3 += TestConvertStorageToCartesian(pointCP3[i]);
			methodTimeD6 += TestConvertStorageToCartesian(pointCP6[i]);

			runningTimeD2[5] += methodTimeD2;
			runningTimeD3[5] += methodTimeD3;
			runningTimeD6[5] += methodTimeD6;
			methodTimeD2 = methodTimeD3 = methodTimeD6 = 0;

			if(i == 0) {
				methodTimeD2 += TestGetDistance(pointCP2[i], PointCPConstruction(2, 'P', Math.random()*((90-0)+1), Math.random()*((90-0)+1)));
				methodTimeD3 += TestGetDistance(pointCP3[i], PointCPConstruction(3, 'C', Double.parseDouble(df.format(Math.random()*((9-0)+1))), Double.parseDouble(df.format(Math.random()*((9-0)+1)))));
				methodTimeD6 += TestGetDistance(pointCP6[i], pointCP6[i] instanceof PointCP2 ?  PointCPConstruction(2, 'P', Math.random()*((90-0)+1), Math.random()*((90-0)+1)) : PointCPConstruction(3, 'C', Double.parseDouble(df.format(Math.random()*((9-0)+1))), Double.parseDouble(df.format(Math.random()*((9-0)+1)))));
			}
			else {
				methodTimeD2 += TestGetDistance(pointCP2[i], pointCP2[i-1]);
				methodTimeD3 += TestGetDistance(pointCP3[i], pointCP3[i-1]);
				methodTimeD6 += TestGetDistance(pointCP6[i], pointCP6[i-1]);
			}
			runningTimeD2[6] += methodTimeD2;
			runningTimeD3[6] += methodTimeD3;
			runningTimeD6[6] += methodTimeD6;

			methodTimeD2 = methodTimeD3 = methodTimeD6 = 0;

			methodTimeD2 += TestRotatePoint(pointCP2[i], Math.random()*((360-0)+1));
			methodTimeD3 += TestRotatePoint(pointCP3[i], Math.random()*((360-0)+1));
			methodTimeD6 += TestRotatePoint(pointCP6[i], Math.random()*((360-0)+1));
			runningTimeD2[7] += methodTimeD2;
			runningTimeD3[7] += methodTimeD3;
			runningTimeD6[7] += methodTimeD6;
		}
		long endTime = System.nanoTime();

		System.out.println("Design 2 getX() method time: " + runningTimeD2[0]/NUMBER_OF_INSTANCES);
		System.out.println("Design 3 getX() method time: " + runningTimeD3[0]/NUMBER_OF_INSTANCES); 
		System.out.println("Design 6 getX() method time: " + runningTimeD6[0]/NUMBER_OF_INSTANCES); 
		System.out.println();

		System.out.println("Design 2 getY() method time: " + runningTimeD2[1]/NUMBER_OF_INSTANCES);
		System.out.println("Design 3 getY() method time: " + runningTimeD3[1]/NUMBER_OF_INSTANCES); 
		System.out.println("Design 6 getY() method time: " + runningTimeD6[1]/NUMBER_OF_INSTANCES); 
		System.out.println();

		System.out.println("Design 2 getRho() method time: " + runningTimeD2[2]/NUMBER_OF_INSTANCES);
		System.out.println("Design 3 getRho() method time: " + runningTimeD3[2]/NUMBER_OF_INSTANCES); 
		System.out.println("Design 6 getRho() method time: " + runningTimeD6[2]/NUMBER_OF_INSTANCES); 
		System.out.println();

		System.out.println("Design 2 getTheta() method time: " + runningTimeD2[3]/NUMBER_OF_INSTANCES);
		System.out.println("Design 3 getTheta() method time: " + runningTimeD3[3]/NUMBER_OF_INSTANCES); 
		System.out.println("Design 6 getTheta() method time: " + runningTimeD6[3]/NUMBER_OF_INSTANCES); 
		System.out.println();
		
		System.out.println("Design 2 convertStorageToPolar() method time: " + runningTimeD2[4]/NUMBER_OF_INSTANCES);
		System.out.println("Design 3 convertStorageToPolar() method time: " + runningTimeD3[4]/NUMBER_OF_INSTANCES); 
		System.out.println("Design 6 convertStorageToPolar() method time: " + runningTimeD6[4]/NUMBER_OF_INSTANCES); 
		System.out.println();
		
		System.out.println("Design 2 convertStorageToCartesian() method time: " + runningTimeD2[5]/NUMBER_OF_INSTANCES);
		System.out.println("Design 3 convertStorageToCartesian() method time: " + runningTimeD3[5]/NUMBER_OF_INSTANCES); 
		System.out.println("Design 6 convertStorageToCartesian() method time: " + runningTimeD6[5]/NUMBER_OF_INSTANCES); 
		System.out.println();

		System.out.println("Design 2 getDistance() method time: " + runningTimeD2[6]/NUMBER_OF_INSTANCES);
		System.out.println("Design 3 getDistance() method time: " + runningTimeD3[6]/NUMBER_OF_INSTANCES); 
		System.out.println("Design 6 getDistance() method time: " + runningTimeD6[6]/NUMBER_OF_INSTANCES); 
		System.out.println();

		System.out.println("Design 2 rotatePoint() method time: " + runningTimeD2[7]/NUMBER_OF_INSTANCES);
		System.out.println("Design 3 rotatePoint() method time: " + runningTimeD3[7]/NUMBER_OF_INSTANCES); 
		System.out.println("Design 6 rotatePoint() method time: " + runningTimeD6[7]/NUMBER_OF_INSTANCES); 
		System.out.println();

		System.out.println("Total Running Time: " + (endTime-startTime)/1000000000.0);
		System.out.println("Total Memory Used: " + java.lang.Runtime.getRuntime().totalMemory());
	}

	public static PointCP6 PointCPConstruction(int design, char type, double xOrRho, double yOrTheta) {
		if(design == 2) {
			return new PointCP2(type, xOrRho, yOrTheta);
		}
		else {
			return new PointCP3(type, xOrRho, yOrTheta);
		}
	}

	public static double TestGetX(PointCP6 point) {
		long startTime = System.nanoTime();
		for(int i = 0; i < NUMBER_OF_TESTS; i++) {
			point.getX();
		}
		long endTime = System.nanoTime();
		return (double)(endTime-startTime)/1000000.0;
	}

	public static double TestGetY(PointCP6 point) {
		long startTime = System.nanoTime();
		for(int i = 0; i < NUMBER_OF_TESTS; i++) {
			point.getY();
		}
		long endTime = System.nanoTime();
		return (double)(endTime-startTime)/1000000.0;
	}

	public static double TestGetRho(PointCP6 point) {
		long startTime = System.nanoTime();
		for(int i = 0; i < NUMBER_OF_TESTS; i++) {
			point.getRho();
		}
		long endTime = System.nanoTime();
		return (double)(endTime-startTime)/1000000.0;
	}

	public static double TestGetTheta(PointCP6 point) {
		long startTime = System.nanoTime();
		for(int i = 0; i < NUMBER_OF_TESTS; i++) {
			point.getTheta();
		}
		long endTime = System.nanoTime();
		return (double)(endTime-startTime)/1000000.0;
	}
	
	public static double TestConvertStorageToPolar(PointCP6 point) {
		long startTime = System.nanoTime();
		for(int i = 0; i < NUMBER_OF_TESTS; i++) {
			point.convertStorageToPolar();
		}
		long endTime = System.nanoTime();
		return (double)(endTime-startTime)/1000000.0;
	}
	
	public static double TestConvertStorageToCartesian(PointCP6 point) {
		long startTime = System.nanoTime();
		for(int i = 0; i < NUMBER_OF_TESTS; i++) {
			point.convertStorageToCartesian();
		}
		long endTime = System.nanoTime();
		return (double)(endTime-startTime)/1000000.0;
	}

	public static double TestGetDistance(PointCP6 point, PointCP6 point2) {
		long startTime = System.nanoTime();
		for(int i = 0; i < NUMBER_OF_TESTS; i++) {
			point.getDistance(point2);
		}
		long endTime = System.nanoTime();
		return (double)(endTime-startTime)/1000000.0;
	}

	public static double TestRotatePoint(PointCP6 point, double angle) {
		long startTime = System.nanoTime();
		for(int i = 0; i < NUMBER_OF_TESTS; i++) {
			point.rotatePoint(angle);
		}
		long endTime = System.nanoTime();
		return (double)(endTime-startTime)/1000000.0;
	}

}
