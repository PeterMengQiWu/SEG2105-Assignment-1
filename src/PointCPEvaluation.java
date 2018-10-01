import java.math.RoundingMode;
import java.text.DecimalFormat;

public class PointCPEvaluation {

	private static final char[] TYPE = {'P', 'C'};
	private static final int NUMBER_OF_INSTANCES = 200000;
	private static final int NUMBER_OF_CALLS = 20;
	private static final int NUMBER_OF_TESTS = 10;
	private static final int NUMBER_OF_METHODS = 8;
	private static final String[] METHODS = {"getX()", "getY()", "getRho()", "getTheta()", "convertStorageToPolar()", "convertStorageToCartesian()", "getDistance()", "rotatePoint()"};

	private static PointCP2[] pointCP2 = new PointCP2[NUMBER_OF_INSTANCES];
	private static PointCP3[] pointCP3 = new PointCP3[NUMBER_OF_INSTANCES];
	private static PointCP6[] pointCP6 = new PointCP6[NUMBER_OF_INSTANCES];

	public static void main(String[] args) {

		double[] runningTimeD2 = new double[NUMBER_OF_METHODS];
		double[] runningTimeD3 = new double[NUMBER_OF_METHODS];
		double[] runningTimeD6 = new double[NUMBER_OF_METHODS];
		double[] minRunningTimeD2 = new double[NUMBER_OF_METHODS];
		double[] minRunningTimeD3 = new double[NUMBER_OF_METHODS];
		double[] minRunningTimeD6 = new double[NUMBER_OF_METHODS];
		double[] maxRunningTimeD2 = new double[NUMBER_OF_METHODS];
		double[] maxRunningTimeD3 = new double[NUMBER_OF_METHODS];
		double[] maxRunningTimeD6 = new double[NUMBER_OF_METHODS];


		double methodTimeD2 = 0;
		double methodTimeD3 = 0;
		double methodTimeD6 = 0;
		

		DecimalFormat df = new DecimalFormat("#.####");
		df.setRoundingMode(RoundingMode.CEILING);

		
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
		}
			
		long startTime = System.nanoTime();
		for(int i = 0; i < NUMBER_OF_INSTANCES; i++) {
			for(int j = 0; j < NUMBER_OF_TESTS; j++) {
				methodTimeD2 += TestGetX(pointCP2[i]);
				runningTimeD2[0] += methodTimeD2;
				
				if(minRunningTimeD2[0] > methodTimeD2) {
					minRunningTimeD2[0] = methodTimeD2;
				}
				
				if(maxRunningTimeD2[0] < methodTimeD2) {
					maxRunningTimeD2[0] = methodTimeD2;
				}
				
				methodTimeD2 = 0;
				
				methodTimeD2 += TestGetY(pointCP2[i]);
				runningTimeD2[1] += methodTimeD2;
				
				if(minRunningTimeD2[1] > methodTimeD2) {
					minRunningTimeD2[1] = methodTimeD2;
				}
				
				if(maxRunningTimeD2[1] < methodTimeD2) {
					maxRunningTimeD2[1] = methodTimeD2;
				}
				
				methodTimeD2 = 0;
				
				methodTimeD2 += TestGetRho(pointCP2[i]);
				runningTimeD2[2] += methodTimeD2;
				
				if(minRunningTimeD2[2] > methodTimeD2) {
					minRunningTimeD2[2] = methodTimeD2;
				}
				
				if(maxRunningTimeD2[2] < methodTimeD2) {
					maxRunningTimeD2[2] = methodTimeD2;
				}
				
				methodTimeD2 = 0;
				
				methodTimeD2 += TestGetTheta(pointCP2[i]);
				runningTimeD2[3] += methodTimeD2;
				
				if(minRunningTimeD2[3] > methodTimeD2) {
					minRunningTimeD2[3] = methodTimeD2;
				}
				
				if(maxRunningTimeD2[3] < methodTimeD2) {
					maxRunningTimeD2[3] = methodTimeD2;
				}
				
				methodTimeD2 = 0;
				
				methodTimeD2 += TestConvertStorageToPolar(pointCP2[i]);
				runningTimeD2[4] += methodTimeD2;
				
				if(minRunningTimeD2[4] > methodTimeD2) {
					minRunningTimeD2[4] = methodTimeD2;
				}
				
				if(maxRunningTimeD2[4] < methodTimeD2) {
					maxRunningTimeD2[4] = methodTimeD2;
				}
				
				methodTimeD2 = 0;
				
				methodTimeD2 += TestConvertStorageToCartesian(pointCP2[i]);
				runningTimeD2[5] += methodTimeD2;
				
				if(minRunningTimeD2[5] > methodTimeD2) {
					minRunningTimeD2[5] = methodTimeD2;
				}
				
				if(maxRunningTimeD2[5] < methodTimeD2) {
					maxRunningTimeD2[5] = methodTimeD2;
				}
				
				methodTimeD2 = 0;
				
				if(i == 0) {
					methodTimeD2 += TestGetDistance(pointCP2[i], PointCPConstruction(2, 'P', Math.random()*((90-0)+1), Math.random()*((90-0)+1)));
				}
				else {
					methodTimeD2 += TestGetDistance(pointCP2[i], pointCP2[i-1]);
				}
				runningTimeD2[6] += methodTimeD2;
				
				if(minRunningTimeD2[6] > methodTimeD2) {
					minRunningTimeD2[6] = methodTimeD2;
				}
				
				if(maxRunningTimeD2[6] < methodTimeD2) {
					maxRunningTimeD2[6] = methodTimeD2;
				}
				
				methodTimeD2 = 0;
				
				methodTimeD2 += TestRotatePoint(pointCP2[i], Math.random()*((360-0)+1));
				runningTimeD2[7] += methodTimeD2;
				
				if(minRunningTimeD2[7] > methodTimeD2) {
					minRunningTimeD2[7] = methodTimeD2;
				}
				
				if(maxRunningTimeD2[7] < methodTimeD2) {
					maxRunningTimeD2[7] = methodTimeD2;
				}
			}
		}
		long endTime = System.nanoTime();
		System.out.println("Design 2 test running time: " + (double)(endTime-startTime)/1000000000.0);
		
		startTime = System.nanoTime();
		for(int i = 0; i < NUMBER_OF_INSTANCES; i++) {
			for(int j = 0; j < NUMBER_OF_TESTS; j++) {
				methodTimeD3 += TestGetX(pointCP2[i]);
				runningTimeD2[0] += methodTimeD3;
				
				if(minRunningTimeD2[0] > methodTimeD3) {
					minRunningTimeD3[0] = methodTimeD3;
				}
				
				if(maxRunningTimeD3[0] < methodTimeD3) {
					maxRunningTimeD3[0] = methodTimeD3;
				}
				
				methodTimeD3 = 0;
				
				methodTimeD3 += TestGetY(pointCP2[i]);
				runningTimeD3[1] += methodTimeD3;
				
				if(minRunningTimeD3[1] > methodTimeD3) {
					minRunningTimeD3[1] = methodTimeD3;
				}
				
				if(maxRunningTimeD3[1] < methodTimeD3) {
					maxRunningTimeD3[1] = methodTimeD3;
				}
				
				methodTimeD3 = 0;
				
				methodTimeD3 += TestGetRho(pointCP2[i]);
				runningTimeD3[2] += methodTimeD3;
				
				if(minRunningTimeD3[2] > methodTimeD3) {
					minRunningTimeD3[2] = methodTimeD3;
				}
				
				if(maxRunningTimeD3[2] < methodTimeD3) {
					maxRunningTimeD3[2] = methodTimeD3;
				}
				
				methodTimeD3 = 0;
				
				methodTimeD3 += TestGetTheta(pointCP2[i]);
				runningTimeD3[3] += methodTimeD3;
				
				if(minRunningTimeD3[3] > methodTimeD3) {
					minRunningTimeD3[3] = methodTimeD3;
				}
				
				if(maxRunningTimeD3[3] < methodTimeD3) {
					maxRunningTimeD3[3] = methodTimeD3;
				}
				
				methodTimeD3 = 0;
				
				methodTimeD3 += TestConvertStorageToPolar(pointCP2[i]);
				runningTimeD3[4] += methodTimeD3;
				
				if(minRunningTimeD3[4] > methodTimeD3) {
					minRunningTimeD3[4] = methodTimeD3;
				}
				
				if(maxRunningTimeD3[4] < methodTimeD3) {
					maxRunningTimeD3[4] = methodTimeD3;
				}
				
				methodTimeD3 = 0;
				
				methodTimeD3 += TestConvertStorageToCartesian(pointCP2[i]);
				runningTimeD3[5] += methodTimeD3;
				
				if(minRunningTimeD3[5] > methodTimeD3) {
					minRunningTimeD3[5] = methodTimeD3;
				}
				
				if(maxRunningTimeD3[5] < methodTimeD3) {
					maxRunningTimeD3[5] = methodTimeD3;
				}
				
				methodTimeD3 = 0;
				
				if(i == 0) {
					methodTimeD3 += TestGetDistance(pointCP2[i], PointCPConstruction(2, 'P', Math.random()*((90-0)+1), Math.random()*((90-0)+1)));
				}
				else {
					methodTimeD3 += TestGetDistance(pointCP2[i], pointCP2[i-1]);
				}
				runningTimeD3[6] += methodTimeD3;
				
				if(minRunningTimeD3[6] > methodTimeD3) {
					minRunningTimeD3[6] = methodTimeD3;
				}
				
				if(maxRunningTimeD3[6] < methodTimeD3) {
					maxRunningTimeD3[6] = methodTimeD3;
				}
				
				methodTimeD3 = 0;
				
				methodTimeD3 += TestRotatePoint(pointCP2[i], Math.random()*((360-0)+1));
				runningTimeD3[7] += methodTimeD3;
				
				if(minRunningTimeD3[7] > methodTimeD3) {
					minRunningTimeD3[7] = methodTimeD3;
				}
				
				if(maxRunningTimeD3[7] < methodTimeD3) {
					maxRunningTimeD3[7] = methodTimeD3;
				}
			}
		}
		endTime = System.nanoTime();
		System.out.println("Design 3 test running time: " + (double)(endTime-startTime)/1000000000.0);

		startTime = System.nanoTime();
		for(int i = 0; i < NUMBER_OF_INSTANCES; i++) {
			for(int j = 0; j < NUMBER_OF_TESTS; j++) {
				methodTimeD2 += TestGetX(pointCP2[i]);
				runningTimeD2[0] += methodTimeD6;
				
				if(minRunningTimeD6[0] > methodTimeD6) {
					minRunningTimeD6[0] = methodTimeD6;
				}
				
				if(maxRunningTimeD6[0] < methodTimeD6) {
					maxRunningTimeD6[0] = methodTimeD6;
				}
				
				methodTimeD6 = 0;
				
				methodTimeD6 += TestGetY(pointCP2[i]);
				runningTimeD6[1] += methodTimeD6;
				
				if(minRunningTimeD6[1] > methodTimeD6) {
					minRunningTimeD6[1] = methodTimeD6;
				}
				
				if(maxRunningTimeD6[1] < methodTimeD6) {
					maxRunningTimeD6[1] = methodTimeD3;
				}
				
				methodTimeD6 = 0;
				
				methodTimeD6 += TestGetRho(pointCP2[i]);
				runningTimeD6[2] += methodTimeD6;
				
				if(minRunningTimeD6[2] > methodTimeD6) {
					minRunningTimeD6[2] = methodTimeD6;
				}
				
				if(maxRunningTimeD6[2] < methodTimeD6) {
					maxRunningTimeD6[2] = methodTimeD6;
				}
				
				methodTimeD6 = 0;
				
				methodTimeD6 += TestGetTheta(pointCP2[i]);
				runningTimeD6[3] += methodTimeD6;
				
				if(minRunningTimeD6[3] > methodTimeD6) {
					minRunningTimeD6[3] = methodTimeD6;
				}
				
				if(maxRunningTimeD6[3] < methodTimeD6) {
					maxRunningTimeD6[3] = methodTimeD6;
				}
				
				methodTimeD6 = 0;
				
				methodTimeD6 += TestConvertStorageToPolar(pointCP2[i]);
				runningTimeD6[4] += methodTimeD6;
				
				if(minRunningTimeD6[4] > methodTimeD6) {
					minRunningTimeD6[4] = methodTimeD6;
				}
				
				if(maxRunningTimeD6[4] < methodTimeD6) {
					maxRunningTimeD6[4] = methodTimeD6;
				}
				
				methodTimeD6 = 0;
				
				methodTimeD6 += TestConvertStorageToCartesian(pointCP2[i]);
				runningTimeD6[5] += methodTimeD6;
				
				if(minRunningTimeD6[5] > methodTimeD6) {
					minRunningTimeD6[5] = methodTimeD6;
				}
				
				if(maxRunningTimeD6[5] < methodTimeD6) {
					maxRunningTimeD6[5] = methodTimeD6;
				}
				
				methodTimeD6 = 0;
				
				if(i == 0) {
					methodTimeD6 += TestGetDistance(pointCP2[i], PointCPConstruction(2, 'P', Math.random()*((90-0)+1), Math.random()*((90-0)+1)));
				}
				else {
					methodTimeD6 += TestGetDistance(pointCP2[i], pointCP2[i-1]);
				}
				runningTimeD6[6] += methodTimeD6;
				
				if(minRunningTimeD6[6] > methodTimeD6) {
					minRunningTimeD6[6] = methodTimeD6;
				}
				
				if(maxRunningTimeD6[6] < methodTimeD6) {
					maxRunningTimeD6[6] = methodTimeD6;
				}
				
				methodTimeD6 = 0;
				
				methodTimeD6 += TestRotatePoint(pointCP2[i], Math.random()*((360-0)+1));
				runningTimeD6[7] += methodTimeD6;
				
				if(minRunningTimeD6[7] > methodTimeD6) {
					minRunningTimeD6[7] = methodTimeD6;
				}
				
				if(maxRunningTimeD6[7] < methodTimeD6) {
					maxRunningTimeD6[7] = methodTimeD6;
				}
			}
		}				
		endTime = System.nanoTime();
		System.out.println("Design 6 test running time: " + (double)(endTime-startTime)/1000000000.0);

		for(int i = 0; i < NUMBER_OF_METHODS; i++) {
			printTestResults(2, runningTimeD2[i], METHODS[i]);
			printTestResults(3, runningTimeD3[i], METHODS[i]);
			printTestResults(6, runningTimeD6[i], METHODS[i]);
			System.out.println();
		}
		System.out.println("Total Running Time: " + (endTime-startTime)/1000000000.0);
		System.out.println("Total Memory Used: " + java.lang.Runtime.getRuntime().totalMemory());
	}
	
	public static void printTestResults(int design, double runningTime, String method) {
		System.out.println("Design " + design + " " + method + " method time: " + runningTime/NUMBER_OF_INSTANCES*NUMBER_OF_TESTS); 
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
		for(int i = 0; i < NUMBER_OF_CALLS; i++) {
			point.getX();
		}
		long endTime = System.nanoTime();
		return (double)(endTime-startTime)/1000000.0;
	}

	public static double TestGetY(PointCP6 point) {
		long startTime = System.nanoTime();
		for(int i = 0; i < NUMBER_OF_CALLS; i++) {
			point.getY();
		}
		long endTime = System.nanoTime();
		return (double)(endTime-startTime)/1000000.0;
	}

	public static double TestGetRho(PointCP6 point) {
		long startTime = System.nanoTime();
		for(int i = 0; i < NUMBER_OF_CALLS; i++) {
			point.getRho();
		}
		long endTime = System.nanoTime();
		return (double)(endTime-startTime)/1000000.0;
	}

	public static double TestGetTheta(PointCP6 point) {
		long startTime = System.nanoTime();
		for(int i = 0; i < NUMBER_OF_CALLS; i++) {
			point.getTheta();
		}
		long endTime = System.nanoTime();
		return (double)(endTime-startTime)/1000000.0;
	}
	
	public static double TestConvertStorageToPolar(PointCP6 point) {
		long startTime = System.nanoTime();
		for(int i = 0; i < NUMBER_OF_CALLS; i++) {
			point.convertStorageToPolar();
		}
		long endTime = System.nanoTime();
		return (double)(endTime-startTime)/1000000.0;
	}
	
	public static double TestConvertStorageToCartesian(PointCP6 point) {
		long startTime = System.nanoTime();
		for(int i = 0; i < NUMBER_OF_CALLS; i++) {
			point.convertStorageToCartesian();
		}
		long endTime = System.nanoTime();
		return (double)(endTime-startTime)/1000000.0;
	}

	public static double TestGetDistance(PointCP6 point, PointCP6 point2) {
		long startTime = System.nanoTime();
		for(int i = 0; i < NUMBER_OF_CALLS; i++) {
			point.getDistance(point2);
		}
		long endTime = System.nanoTime();
		return (double)(endTime-startTime)/1000000.0;
	}

	public static double TestRotatePoint(PointCP6 point, double angle) {
		long startTime = System.nanoTime();
		for(int i = 0; i < NUMBER_OF_CALLS; i++) {
			point.rotatePoint(angle);
		}
		long endTime = System.nanoTime();
		return (double)(endTime-startTime)/1000000.0;
	}

}
