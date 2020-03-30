/**
 * 
 */
package sort;

/**
 * @author paulinemakoma
 *
 */
import java.util.Random;
public class QuickSort {
  public static void main(String[] args) {
     System.out.println("ArraySize\tSelection sort\t quicksort\t time taken");
     int size=4;
     for(int i=0;i<7;i++){
        
        int ar[]=getRandomNumberArray(size,3);
        long startTime = System.nanoTime();
        doSelectionSort(ar);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.print(ar.length+" "+ timeElapsed+" in NanoSec for Selection sort ");
        startTime = System.nanoTime();
        sort(ar, 0, ar.length-1);
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        System.out.print(" "+ timeElapsed+" in NanoSec for Quick sort");
        size*=2;
        System.out.println();
     }
  }
  public static int[] getRandomNumberArray(int arraySize ,int numberOfDigits ){
     int ar[]=new int[arraySize];
     Random rnd = new Random();
     int n = numberOfDigits + rnd.nextInt(numberOfDigits);
     for(int i=0;i<ar.length;i++){
        ar[i]=numberOfDigits + rnd.nextInt(numberOfDigits);
     }
     return ar;
  }
  public static int[] doSelectionSort(int[] placer){
  for (int index=0;index<placer.length;index++)
  {
     int smallerNumber = placer[index]; //make current element as smallest
     int smallerIn=-1; //initialize smallest index as -1
     int i=index; //define i out so that it remain accessible out side of loop
  for(;i<placer.length;i++){ //find smallest element in ar[i.....n]
       
     if(smallerNumber>placer[i]){  
        smallerNumber=placer[i];
        smallerIn=i; //remember index of smallest
     }
       
  }
  if(smallerIn!=-1){ //if smallest found
  int temp=placer[index]; //swap it
  placer[index]=smallerNumber;
  placer[smallerIn] = temp;
  }
  }
    
  return placer;
  }
  
  public static int part(int ar[], int l, int h)
  {
  int p = ar[l]; //to first element for array as pivote  
  int j=h; //j as highest
  int i = (h+1); //after highest index
  while (j>l) //run loop j greater the low
  {
     
  if (ar[j]>= p) { //if jth element greater then p
  
  i--; //swap ith and jth element
  int t = ar[i];
  ar[i] = ar[j];
  ar[j] = t;
  }
  j--; //go to lower element
  }  
  
  int t = ar[i-1]; //swap pivot if it is not at right place
  ar[i-1] = ar[l];
  ar[l] = t;
  return i-1;
  }
  
  public static void sort(int ar[], int l, int h)
  {
  if (l < h)
  {
     //using divide and concor
  int pi = part(ar, l, h); //find pivote index
  sort(ar, l, pi-1); //sort array before pivot
  sort(ar, pi+1, h); //after pivot
  }
  }
  
}
