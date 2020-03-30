/**
 * @author paulinemakoma
 *Assignment: A02 Randomized Queues and Deque	
 *Date: 02/29/2020
 */
package random;

public class Deque<Item> implements Iterable<Item> {

	private class Node<Item> {

		private final Item item;

		public Node<Item> leftNode, rightNode;

		public Node(Item item) {

			if (item == null) {
				throw new NullPointerException();
			}

			this.item = item;

		}

		public void joinrightNode(Node<Item> other) {

			this.rightNode = other;

			other.leftNode = this;

		}

	}

	private class DequeIterator implements Iterator<Item> {

		private Node<Item> currentNode = head;

		public boolean hasNext() {

			return currentNode != null;

		}

		public void remove() {

			throw new UnsupportedOperationException();

		}

		public Item next() {

			if (!hasNext())

			{

				throw new NoSuchElementException();

			}

			Item item = currentNode.item;

			currentNode = currentNode.rightNode;

			return item;

		}

	}

	private Node<Item> head, tail;

	private int size;

	public Deque() // construct an empty deque

	{

	}

	public boolean isEmpty() // is the deque empty?

	{

		return size() == 0;

	}

	public int size() // return the number of items on the deque

	{

		return size;

	}

	public void addFirst(Item item) // insert the item at the front

	{

		Node<Item> prevHead = head;

		Node<Item> newHead = new Node<Item>(item);

		if (prevHead != null) {

			newHead.joinrightNode(prevHead);

		} else {

			tail = newHead;

		}

		head = newHead;

		size++;

	}

	public void addLast(Item item) // insert the item at the end

	{

		Node<Item> newTail = new Node<Item>(item);

		Node<Item> prevTail = tail;

		if (prevTail != null) {

			prevTail.joinrightNode(newTail);

		} else {

			head = newTail;

		}

		tail = newTail;

		size++;

	}

	public Item removeFirst() // delete and return the item at the front

	{

		if (isEmpty()) {

			throw new java.util.NoSuchElementException();

		}

		size--;

		Node<Item> prevHead = head;

		head = prevHead.rightNode;

		prevHead.rightNode = null;

		if (head != null) {

			head.leftNode = null;

		}

		return prevHead.item;

	}

	public Item removeLast() // delete and return the item at the end

	{

		if (isEmpty()) {

			throw new java.util.NoSuchElementException();

		}

		size--;

		Node<Item> prevTail = tail;

		tail = prevTail.leftNode;

		prevTail.leftNode = null;

		if (tail != null)

			tail.rightNode = null;

		return prevTail.item;

	}

	public Iterator<Item> iterator() // return an iterator over items in order from front to end

	{

		return new DequeIterator();

	}

	public static void main(String[] args) // unit testing

	{

		Deque<Integer> deque = new Deque<Integer>();

		System.out.println("Is deque empty: " + deque.isEmpty());

		deque.addFirst(2);

		System.out.println("Is deque empty: " + deque.isEmpty());

		System.out.println("Size of dequeue:" + deque.size());

		deque.addLast(4);

		Iterator<Integer> iter = deque.iterator();

		while (iter.hasNext())

		{

			System.out.print(iter.next() + " ");

		}

		System.out.println();

		deque.removeFirst();

		System.out.println("Size of dequeue:" + deque.size());

		deque.removeLast();

		System.out.println("Size of dequeue:" + deque.size());

		deque.removeLast();

	}

}
