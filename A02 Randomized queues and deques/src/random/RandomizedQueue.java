/**
 * @author paulinemakoma
 *Assignment: A02 Randomized Queues and Deque	
 *Date: 02/29/2020
 */
package random;

public class RandomizedQueue<Item> implements Iterable<Item> {

	private Item[] items;

	private int firstItem;

	private int lastItem;

	private int size;

	private class RandomQueueIterator implements Iterator<Item> {

		private int iter;

		public boolean hasNext()

		{

			return iter < size;

		}

		public void remove()

		{

			throw new UnsupportedOperationException();

		}

		public Item next()

		{

			if (!hasNext())

				throw new NoSuchElementException();

			Item item = items[(iter + firstItem) % items.length];

			iter++;

			return item;

		}

	}

	private void resize(int maximumSize)

	{

		assert maximumSize >= size;

		Item[] temp = (Item[]) new Object[maximumSize];

		for (int i = 0; i < size; i++)

		{

			temp[i] = items[(firstItem + i) % items.length];

		}

		items = temp;

		firstItem = 0;

		lastItem = size;

	}

	private void swap(int i, int j)

	{

		Item t = items[j];

		items[j] = items[i];

		items[i] = t;

	}

	public RandomizedQueue() // construct an empty randomized queue

	{

		items = (Item[]) new Object[10];

	}

	public boolean isEmpty() // is the queue empty?

	{

		return size == 0;

	}

	public int size() // return the number of items on the queue

	{

		return size;

	}

	public void enqueue(Item item) // add the item

	{

		if (item == null)

			throw new NullPointerException();

		if (size == items.length)
			resize(2 * items.length);

		items[lastItem++] = item;

		if (lastItem == items.length)
			lastItem = 0;

		size++;

		if (size > 2) {

			int choosen = StdRandom.uniform(size);

			int index = (firstItem + choosen) % items.length;

			if (lastItem == 0)

				swap(items.length - 1, index);

			else

				swap(lastItem - 1, index);

		}

	}

	public Item dequeue() // delete and return a random item

	{

		if (isEmpty())

			throw new NoSuchElementException();

		Item item = items[firstItem];

		items[firstItem] = null; // to avoid loitering

		size--;

		firstItem++;

		if (firstItem == items.length)
			firstItem = 0; // wrap-around

		// shrink size of array if necessary

		if (size > 0 && size == items.length / 4)
			resize(items.length / 2);

		return item;

	}

	public Item sample() // return (but do not delete) a random item

	{

		int choosen = StdRandom.uniform(size);

		int index = (firstItem + choosen) % items.length;

		return items[index];

	}

	public Iterator<Item> iterator() // return an independent iterator over items in random order

	{

		return new RandomQueueIterator();

	}

	public static void main(String[] args) // unit testing

	{

		RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<Integer>();

		System.out.println(randomizedQueue.isEmpty());

		randomizedQueue.enqueue(1);

		randomizedQueue.enqueue(2);

		randomizedQueue.dequeue();

		System.out.println(randomizedQueue.isEmpty());

		System.out.println(randomizedQueue.size());

		Iterator<Integer> iterator = randomizedQueue.iterator();

		while (iterator.hasNext())

		{

			System.out.println(iterator.next());

		}

	}

}
