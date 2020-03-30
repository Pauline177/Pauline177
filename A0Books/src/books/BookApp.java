package books;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//import javax.sound.sampled.Line;

public class BookApp {
	
	
	public static void main(String args[]) {
		
		ArrayList<Book> MyBooks = Book.getList("books.csv");
		
		
		/////sorting by date 
		Collections.sort(MyBooks, Book.BY_DATE);
		
		////sorting  by year
//		Collections.sort(MyBooks, Book.BY_AUTHOR);
		
		System.out.println("\nSorted book list: ");
		
		for(Book b: MyBooks) {
			System.out.println(b);
		}

		System.out.println("\nReverse order: ");
		Collections.reverse(MyBooks);
		for(Book b: MyBooks) {
			System.out.println(b);
		}
	}
}
