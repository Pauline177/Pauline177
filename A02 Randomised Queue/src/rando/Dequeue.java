package rando;

import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;

public class Dequeue<Item> implements Iterable<Item> {
	private int N;
	private Node first;
	private Node last;
	
	private class Node {
		private Item item;
		private Node next;
		private Node previous;
	}
	
	
	public Dequeue() {									// construct an empty dequeue
		N = 0;
		first = null;
		last = null;
	}
	
	
    public boolean isEmpty() {							// is the dequeue empty?
		return N == 0;
    }
    
    
    public int size() {									// return the number of items on the dequeue
		return N;
    }
    
    
    public void addFirst(Item item) {					// insert the item at the front
    	if (item == null) throw new NullPointerException("item can't be null");
    	
    	Node oldFirst = first;
    	first = new Node();
    	first.item = item;
    	first.previous = null;
    	
    	if (isEmpty()) {
    		last = first;
    		first.next = null;
    		last.next = null;
    		last.previous = null;
    		
    	} else {
    		oldFirst.previous = first;
    		first.next = oldFirst;
    	}
    	N++;
    }
    
    
    public void addLast(Item item) {					// insert the item at the end
    	if (item == null) throw new NullPointerException("item can't be null");
    	
    	Node oldLast = last;
    	last = new Node();
    	last.item = item;
    	last.next = null;
    	
    	if (isEmpty()) first = last;
    	else {
    		oldLast.next = last;
    		last.previous = oldLast;
    	}
    	N++;
    }
    
   
    public Item removeFirst() {							// delete and return the item at the front
    	if (isEmpty()) throw new NoSuchElementException("Deque underflow");
    	
    	Item removeItem = first.item;
    	first = first.next;
    	
    	if (first != null) first.previous = null;
    	
    	N--;
    	
    	if (isEmpty()) last = null;
    	
    	return removeItem;
    }
    
    public Item removeLast() {							 // delete and return the item at the end
    	if (isEmpty()) throw new NoSuchElementException("Deque underflow");
    	
    	Item removeItem = last.item;
    	last = last.previous;
    	
    	if (last != null) last.next = null;
    	
    	N--;
    	
    	if (isEmpty()) first = null;
    	
    	return removeItem;
    }
	
	
    @Override
    public Iterator<Item> iterator() {						// return an iterator over items in order from front to end
		return new DequeIterator();
	}
	
	private class DequeIterator implements Iterator<Item> {
		private Node current = first;
		
		
		@Override
		public void remove() { throw new UnsupportedOperationException(); }

		
		@Override
		public boolean hasNext() { return current != null; }

		
		@Override
		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}
	
    public static void main(String[] args) {		// unit testing
    	Dequeue<String> myDeque = new Dequeue<>();
    	myDeque.addFirst("Lionel");
    	myDeque.addFirst("Paul");
    	myDeque.addFirst("Laurien");
    	myDeque.addLast("Darcin");
    	myDeque.addLast("Domy");
    	
    	StdOut.println("\nSize of the queue: " + myDeque.size());
    	
    	///print elements in the queue
    	for (String text : myDeque) 
    		StdOut.print(text + " ");
    	System.out.println("\n-------------------------------");
    	
    	StdOut.println("\n" + myDeque.removeFirst());
    	StdOut.println(myDeque.removeFirst());
    	StdOut.println(myDeque.removeLast());
    	StdOut.println(myDeque.removeFirst());
    	StdOut.println(myDeque.removeFirst() + "\n");
    	
    	myDeque.addFirst("first");
    	myDeque.addFirst("second");
    	myDeque.addFirst("third");
    	myDeque.addLast("fourth");
    	myDeque.addLast("fifth");
    	
    	StdOut.println("\nSize of the queue: " + myDeque.size());
    	
    	for (String text : myDeque) {
    		StdOut.print(text + " ");
    	}
    	System.out.println("\n-------------------------------");
    	
    	////testing iterator
    	Iterator<String> iterator = myDeque.iterator();
    	
    	StdOut.println();
    	
    	StdOut.println(iterator.next());
    	StdOut.println(iterator.next());
    	StdOut.println(iterator.next());
    	StdOut.println(iterator.hasNext());
    	
    	StdOut.println("\n" + myDeque.removeLast());
    	StdOut.println(myDeque.removeLast());
    	StdOut.println(myDeque.removeFirst());
//    	StdOut.println(myDeque.removeLast());
    	StdOut.println(myDeque.removeLast());
    	
    	
    	StdOut.println("\nSize: " + myDeque.size());
    	
    }
}