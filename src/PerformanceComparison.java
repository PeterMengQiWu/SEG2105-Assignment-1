import java.util.ArrayList;
import java.util.Vector;
import java.util.Iterator;

public class PerformanceComparison {
	
	private static final int SIZE = 150000000;
	private static ArrayList<Integer> list = new ArrayList<Integer>();
	private static Vector<Integer> vector = new Vector<Integer>();
	private static int[] array = new int[SIZE];
	private static long startTime;
	private static long endTime;
	
	public static void main(String[] args) {
		
		final int NUMBER_OF_TESTS = 3;
		double sum = 0;
		
		for(int i = 0; i < NUMBER_OF_TESTS; i++) {
			sum += ArrayTest();
		}
		System.out.println("Array test time: " + sum/NUMBER_OF_TESTS);
		
		sum = 0;
		for(int i = 0; i < NUMBER_OF_TESTS; i++) {
			sum += VectorTest();
		}
		System.out.println("Vector test time: " + sum/NUMBER_OF_TESTS);

		sum = 0;
		for(int i = 0; i < NUMBER_OF_TESTS; i++) {
			sum += ArrayListTest();
		}
		System.out.println("ArrayList test time: " + sum/NUMBER_OF_TESTS);
		
		vector = new Vector<Integer>(SIZE);
		sum = 0;
		for(int i = 0; i < NUMBER_OF_TESTS; i++) {
			sum += VectorTest();
		}
		System.out.println("Vector test time with size declared: " + sum/NUMBER_OF_TESTS);
		
		list = new ArrayList<Integer>(SIZE);
		sum = 0;
		for(int i = 0; i < NUMBER_OF_TESTS; i++) {
			sum += ArrayListTest();
		}
		System.out.println("ArrayList test time with size declared: " + sum/NUMBER_OF_TESTS);
		
		sum = 0;
		for(int i = 0; i < NUMBER_OF_TESTS; i++) {
			sum += ArraySumTest();
		}
		System.out.println("Array sum test time: " + sum/NUMBER_OF_TESTS);
		
		sum = 0;
		for(int i = 0; i < NUMBER_OF_TESTS; i++) {
			sum += VectorSumTest();
		}
		System.out.println("Vector sum test time: " + sum/NUMBER_OF_TESTS);
		
		sum = 0;
		for(int i = 0; i < NUMBER_OF_TESTS; i++) {
			sum += ArrayListSumTest();
		}
		System.out.println("ArrayList sum test time: " + sum/NUMBER_OF_TESTS);
	}
	
	public static double ArrayTest() {
		startTime = System.nanoTime();
		for(int i = 0; i < SIZE; i++) {
			array[i] = (int)(Math.random()*((9-0)+1));
		}
		long endTime = System.nanoTime();
		return (double)(endTime-startTime)/1000000000.0;
	}
	
	public static double VectorTest() {
		startTime = System.nanoTime();
		for(int i = 0; i < SIZE; i++) {
			vector.add((int)(Math.random()*((9-0)+1)));
		}
		endTime = System.nanoTime();
		return (double)(endTime-startTime)/1000000000.0;
	}
	
	public static double ArrayListTest() {
		startTime = System.nanoTime();
		for(int i = 0; i < SIZE; i++) {
			list.add((int)(Math.random()*((9-0)+1)));
		}
		endTime = System.nanoTime();
		return (double)(endTime-startTime)/1000000000.0;
	}
	
	public static double ArraySumTest() {
		int sum = 0;
		startTime = System.nanoTime();
		for(int i = 0; i < SIZE; i++) {
			sum += array[i];
		}
		endTime = System.nanoTime();
		return (double)(endTime-startTime)/1000000000.0;
	}
	
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
