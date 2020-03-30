package comp;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class Rectangle implements Comparable<Rectangle> {

	Double width;
	Double height;
	
	public Rectangle(Double w, Double h) {
		this.width = w;
		this.height = h;			
	}
	
	
	public static void main(String args[]) {
		List <Rectangle> Rects = new ArrayList<Rectangle>();
		
		Rects.add(new Rectangle (20.5, 10.3));
		Rects.add(new Rectangle (25.5, 6.3));
		Rects.add(new Rectangle (5.5, 5.3));
		Rects.add(new Rectangle (10.5, 5.3));
		Rects.add(new Rectangle (15.5, 8.9));
		

		System.out.println(Rects);
		Collections.sort(Rects);
		System.out.println("Sorted \n"  + Rects);
		Collections.sort(Rects,  Collections.reverseOrder());
	
		
		System.out.println("Reversed order \n"  + Rects);
	}
	
	@Override
	public String toString() {
		return String.format(" width %.1f height %.1f diagnal of %.1f \n", width, height, 
				Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2)));

	}


	@Override
	public int compareTo(Rectangle r) {
		int diag1 = (int) Math.sqrt(Math.pow(this.width, 2) + Math.pow(this.height, 2));
		int diag2 = (int) Math.sqrt(Math.pow(r.width, 2) + Math.pow(r.height, 2));
		
		return diag1 = diag2;
	}
	
}

