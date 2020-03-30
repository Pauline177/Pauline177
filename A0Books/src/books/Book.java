package books;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Book {
	private String title;
	private String author;
	private int year;
	public static final Comparator<Book>BY_DATE =  new ByDate();
	public static final Comparator<Book>BY_AUTHOR = new ByAuthor();
	
	
//	List<Book> booksList = new LinkedList<>();

	public Book(String title, String author, int year) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
	}
	
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
		
	}
	public int getYear() {
		return year;
	}
	@Override
	public String toString() {
		return String.format("%s by %s (%d)", title, author, year);
	}
	/////// creates the list of books, the total number of books and the file input 
	// and the pattern for the string to compare

	public static ArrayList<Book> getList(String file) {
		
		ArrayList<Book> MyBooks = new ArrayList<Book>();
		int numberOfBooks = 0;
		File readIn = new File(file);
		
		/////// dontunderstand this line
		///parse the date to check against the following pattern 	
		String pattern = "[^,]*,[^,]*,\\d{4}";
		
		
		
		try {
			Scanner inputStream = new Scanner(readIn);
			while(inputStream.hasNext()) 
			{
				
				String data = inputStream.nextLine();
				if(Pattern.matches(pattern, data)) {
						numberOfBooks++;
						String[] newString = data.split(",");
						Book newBook = new Book(newString[0], newString[1], Integer.parseInt(newString[2]));
						MyBooks.add(newBook);
						
					}  else {
						System.err.println("couldn't read: " + data);
					}
				}
			System.out.println("Number of read in Books: " +  numberOfBooks);
			}
		 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return MyBooks;
	}
	
	/////// comparing books 
	public int compareTo(Book o) {
		return this.getTitle().compareTo(o.getTitle());
	}
	
	/////comparing by the author
	private static class ByAuthor implements Comparator<Book>{
		
		public int compare(Book v, Book w) {
			return v.author.compareTo(w.author);
		}
	}
	
	/////comparing by date
	private static class ByDate implements Comparator<Book>{
		public int compare(Book v, Book w) {
			return v.year - w.year;
		}
	}
	
}

