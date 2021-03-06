/**
 * 
 */
package sort;

import java.util.Collections;
import java.util.Random;

import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.Selection;

/**
 * @author paulinemakoma
 *
 */
public class QuickSort {
	
	public static void main(String[] args) {
		for(int i =0; i < 7; i++) {
		Integer[] numbersArr = randomIntegers(30000,2);
		long startTime = System.nanoTime();
		//doing stuff here
		
		Selection.sort(numbersArr.clone());
		
		long endTime = System.nanoTime();
		long sduration = (endTime - startTime); 
//		for(int i = 0; i < numbersArr.length-1; i++) {
//			System.out.println(numbersArr[i]);
		startTime = System.nanoTime();
		//doing stuff here
		
		Quick.sort(numbersArr.clone());
		
		endTime = System.nanoTime();
		long qduration = (endTime - startTime); 
//		}
		
		System.out.println(sduration/1000000+ "Nanoseconds");
		System.out.println(qduration/1000000+ "Nanoseconds");
		}
		
	}

	public static int generateRandomDigits(int n) {
		int m = (int) Math.pow(10, n-1);
		return m + new Random().nextInt(9*m);
	}
	
	private static Integer[] randomIntegers(int n, int numberOfDigits) {
		Integer[] list = new Integer[n];
		for(int i= 0; i< n; i++) {
			list[i] =  generateRandomDigits(numberOfDigits);
		}
		return list;
	}
	
	 public static void selectionSort(Integer[] numbersArr) {
		    for (int out = 0; out < numbersArr.length - 1; out++) {
		      int min = out;
		      for (int in = out + 1; in < numbersArr.length; in++)
		        if (numbersArr[in] < numbersArr[min])
		          min = in;
		      swap(numbersArr, out, min);
		    }
		  }

		  private static void swap(Integer[] numbersArr, int one, int two) {
		    int temp = numbersArr[one];
		    numbersArr[one] = numbersArr[two];
		    numbersArr[two] = temp;
		  }
	
}

