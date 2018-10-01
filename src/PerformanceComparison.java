import java.util.ArrayList;
import java.util.Vector;
import java.util.Iterator;

public class PerformanceComparison {
	
	private static final int SIZE = 100000;
	private static ArrayList<Integer> list = new ArrayList<Integer>();
	private static Vector<Integer> vector = new Vector<Integer>();
	private static int[] array = new int[SIZE];
	private static long startTime;
	private static long endTime;
	
	public static void main(String[] args) {
		
		final int NUMBER_OF_TESTS = 3000;
		double sum = 0;
		
		//Array Construction Test
		for(int i = 0; i < NUMBER_OF_TESTS; i++) {
			sum += ArrayTest();
		}
		System.out.println("Array test time on average of " + NUMBER_OF_TESTS + " tests: " + sum/NUMBER_OF_TESTS + " seconds.");
		
		//Vector Construction Test
		sum = 0;
		for(int i = 0; i < NUMBER_OF_TESTS; i++) {
			sum += VectorTest();
		}
		System.out.println("Vector test timeon average of " + NUMBER_OF_TESTS + " tests: " + sum/NUMBER_OF_TESTS + " seconds.");

		//ArrayList Construction Test
		sum = 0;
		for(int i = 0; i < NUMBER_OF_TESTS; i++) {
			sum += ArrayListTest();
		}
		System.out.println("ArrayList test time: on average of " + NUMBER_OF_TESTS + " tests: " + sum/NUMBER_OF_TESTS + " seconds.");
		
		//Vector Construction Test with size predefined
		vector = new Vector<Integer>(SIZE);
		sum = 0;
		for(int i = 0; i < NUMBER_OF_TESTS; i++) {
			sum += VectorTest();
		}
		System.out.println("Vector test time with size declared on average of " + NUMBER_OF_TESTS + " tests: " + sum/NUMBER_OF_TESTS + " seconds.");
		
		//ArrayList Construction Test with size predefined
		list = new ArrayList<Integer>(SIZE);
		sum = 0;
		for(int i = 0; i < NUMBER_OF_TESTS; i++) {
			sum += ArrayListTest();
		}
		System.out.println("ArrayList test time with size declared on average of " + NUMBER_OF_TESTS + " tests: " + sum/NUMBER_OF_TESTS + " seconds.");
		
		//Array Sum Test
		sum = 0;
		for(int i = 0; i < NUMBER_OF_TESTS; i++) {
			sum += ArrayTest();
			sum += ArraySumTest();
		}
		System.out.println("Array sum test time on average of " + NUMBER_OF_TESTS + " tests: " + sum/NUMBER_OF_TESTS + " seconds.");
		
		//Vector Sum Test
		sum = 0;
		vector = new Vector<Integer>(SIZE);
		VectorTest();
		for(int i = 0; i < NUMBER_OF_TESTS; i++) {
			sum += VectorSumTest();
		}
		System.out.println("Vector sum test time on average of " + NUMBER_OF_TESTS + " tests: " + sum/NUMBER_OF_TESTS + " seconds.");
		
		//ArrayList Sum Test
		sum = 0;
		ArrayListTest();
		list = new ArrayList<Integer>(SIZE);
		for(int i = 0; i < NUMBER_OF_TESTS; i++) {
			sum += ArrayListSumTest();
		}
		System.out.println("ArrayList sum test time on average of " + NUMBER_OF_TESTS + " tests: " + sum/NUMBER_OF_TESTS + " seconds.");
	}
	
	/**
	 * Constructs the array and assigns random numbers from 0 to 9 to the array
	 * @return running time of this method
	 */
	public static double ArrayTest() {
		startTime = System.nanoTime();
		for(int i = 0; i < SIZE; i++) {
			array[i] = (int)(Math.random()*((9-0)+1));
		}
		long endTime = System.nanoTime();
		return (double)(endTime-startTime)/1000000000.0;
	}
	
	/**
	 * Constructs the Vector and assigns random numbers from 0 to 9 to the Vector
	 * @return running time of this method
	 */
	public static double VectorTest() {
		startTime = System.nanoTime();
		for(int i = 0; i < SIZE; i++) {
			vector.add((int)(Math.random()*((9-0)+1)));
		}
		endTime = System.nanoTime();
		return (double)(endTime-startTime)/1000000000.0;
	}
	
	/**
	 * Constructs the ArrayList and assigns random numbers from 0 to 9 to the ArrayList
	 * @return running time of this method
	 */
	public static double ArrayListTest() {
		startTime = System.nanoTime();
		for(int i = 0; i < SIZE; i++) {
			list.add((int)(Math.random()*((9-0)+1)));
		}
		endTime = System.nanoTime();
		return (double)(endTime-startTime)/1000000000.0;
	}
	
	/**
	 * Constructs the array, assigns random numbers from 0 to 9 to the array and adds all entries
	 * @return running time of this method
	 */
	public static double ArraySumTest() {
		int sum = 0;
		startTime = System.nanoTime();
		for(int i = 0; i < SIZE; i++) {
			sum += array[i];
		}
		endTime = System.nanoTime();
		return (double)(endTime-startTime)/1000000000.0;
	}
	
	/**
	 * Constructs the Vector, assigns random numbers from 0 to 9 to the Vector and adds all entries
	 * @return running time of this method
	 */
	public static double VectorSumTest() {
		int sum = 0;
		Iterator<Integer> it = vector.iterator();
		startTime = System.nanoTime();
		while(it.hasNext()) {
			sum += (int)it.next();
		}
		endTime = System.nanoTime();
		return (double)(endTime-startTime)/1000000000.0;
	}
	
	/**
	 * Constructs the ArrayList, assigns random numbers from 0 to 9 to the ArrayList and adds all entries
	 * @return running time of this method
	 */
	public static double ArrayListSumTest() {
		int sum = 0;
		Iterator<Integer> it = list.iterator();
		startTime = System.nanoTime();
		while(it.hasNext()) {
			sum += (int)it.next();
		}
		endTime = System.nanoTime();
		return (double)(endTime-startTime)/1000000000.0;
	}

}
