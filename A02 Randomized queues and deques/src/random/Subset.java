/**
 * @author paulinemakoma
 *Assignment: A02 Randomized Queues and Deque	
 *Date: 02/29/2020
 */

package random;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Subset {
	
	public static void main(String args[]){

		int k = Integer.parseInt(args[0]);

		RandomizedQueue<String> randomizedQueue = new RandomizedQueue<String>();

		while (!StdIn.isEmpty()){
			randomizedQueue.enqueue(StdIn.readString());
		}

		for (int i = 0; i < k; i++){
			System.out.println(randomizedQueue.dequeue());

		}

	}

}
