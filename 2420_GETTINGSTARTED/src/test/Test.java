package test;

import java.util.Random;

import edu.princeton.cs.algs4.QuickFindUF;
import edu.princeton.cs.algs4.QuickUnionUF;
import edu.princeton.cs.algs4.StdOut;

public class Test {

	public static void main(String[] args) {
		Random r = new Random();
		int n = 100;
		QuickFindUF uf1 = new QuickFindUF(n);
		//--write code here --
		/*This should loop through a random number
		of n times and union two point if they are not unioned
		r.nextInt(n)
		*/
		
		int number1 = r.nextInt(n);
		int number2 = r.nextInt(n);
		uf1.union(number1, number2);
		
		long startTimeuf1 = System.nanoTime();
		StdOut.println(uf1.connected(number1, number2) + " " + number1 + " and " + number2 + " are connected");
		long endTimeuf1 = System.nanoTime();

		QuickUnionUF uf2 = new QuickUnionUF(n);
		//--write code here--
		/*This should loop through a random number
		of n times and union two point if they are not unioned
		r.nextInt(n)
		*/
		
		int number3 = r.nextInt(n);
		int number4 = r.nextInt(n);
		uf2.union(number3, number4);
		
		long startTimeuf2 = System.nanoTime();
		StdOut.println(uf2.connected(number3, number4) + " " + number3 + " and " + number4 + " are connected");
		long endTimeuf2 = System.nanoTime();

		long durationuf1 = (endTimeuf1 - startTimeuf1)/1000;
		long durationuf2 = (endTimeuf2 - startTimeuf2)/1000;

		StdOut.println(durationuf1 + " QuickFindUF, "+ durationuf2 +" QuickUnionUF");
		}


}
