package rando;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	
	private Item[] itemList;	// array of items
	private int size = 0;		// number of elements in array
	private int first = 0;		// index of first element 
    private int last  = 0;
	   
    @SuppressWarnings("unchecked")
	public RandomizedQueue() {				// construct an empty randomized queue
    	itemList = (Item[]) new Object[2];
	}    
    
	public boolean isEmpty() {				 // is the queue empty?
		 return size == 0;
	} 
	
	public int size() {		   				 // return the number of items on the queue
		return size;   
	}
	
	public void enqueue(Item item)  {		 // add the item
		if (item == null) throw new NullPointerException();
		
		if (size == itemList.length) resizeArray(2 * itemList.length);
		
		itemList[last++] = item;
		
		if (last == itemList.length) last = 0;
		
		size++;
	}         
	   
	private void resizeArray(int multiplier) {
		
		@SuppressWarnings("unchecked")
		Item[] copyItemList = (Item[]) new Object[multiplier];
		
		for (int i = 0; i < size; i++) {
			copyItemList[i] = itemList[i];
		}
		
		itemList = copyItemList;
		first = 0;
		last = size;
		
	}

	public Item dequeue()  {				// delete and return a random item
		if (isEmpty()) throw new NoSuchElementException();
		
		int deleteRandomItem = StdRandom.uniform(size);
		Item item = itemList[deleteRandomItem];
		itemList[deleteRandomItem] = itemList[--size];
		itemList[size] = null; 				// to avoid loitering
		
		// resize array if needed
		if (size > 0 && size == itemList.length/4) 
			resizeArray(itemList.length/2);
		return item;	  
	 } 
	
	 public Item sample() {                    // return (but do not delete) a random item
		 if (isEmpty()) throw new NoSuchElementException();
		 int randomItem = StdRandom.uniform(size);
			
		 return itemList[randomItem]; 
	 }

	   
	   public Iterator<Item> iterator() {			// return an independent iterator over items in random order
			return new RandomizedQueueIterator();
		}
		
		private class RandomizedQueueIterator implements Iterator<Item> {
			private int i = size;
			private Item[] shuffleArray;
			
			@SuppressWarnings("unchecked")
			public RandomizedQueueIterator() {
				shuffleArray = (Item[]) new Object[size];
				System.arraycopy(itemList, first, shuffleArray, 0, size);
				StdRandom.shuffle(shuffleArray);
			}
			
			/**
			 * @return true if size is greater than 0
			 */
			@Override
			public boolean hasNext() {
				return i > 0;
			}
			
			// remove is not needed
			public void remove () {
				throw new UnsupportedOperationException();
			}

			@Override
			public Item next() {
				if (!hasNext()) 
					throw new NoSuchElementException();
				return shuffleArray[--i];
			}
		}
	   public static void main(String[] args) {}  // unit testing
	}