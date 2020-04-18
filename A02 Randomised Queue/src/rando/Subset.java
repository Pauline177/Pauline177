package rando;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

public class Subset {
	public static void main(String[] args) {
		
		RandomizedQueue<String> input = new RandomizedQueue<>();
		
		input.enqueue("AA");
		input.enqueue("BB");
		input.enqueue("CC");
		input.enqueue("DD");
		input.enqueue("EE");
		input.enqueue("FF");
		input.enqueue("GG");
		input.enqueue("HH");
		
		StdOut.println("Elements in queue:");
		Iterator<String> iterator = input.iterator();
		
		//printing random elements from queue, changes everytime you run it
		for (String s : input) {
			StdOut.println(s);
		}
		
		
		StdOut.println();
		StdOut.println();
		
		
		/// printing out specified number of elements from randomized queue
		int num = 3;
		StdOut.printf("Print only %d elements from the queue: \n", num);
		for (int i = 0; i < num; i++) {
			StdOut.println(iterator.next());
		}
	}
}
	