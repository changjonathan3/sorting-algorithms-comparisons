/**
 * @author Jonathan Chang
 * Assig 4 RandQuick
 * Sherif Khattab
 * CS 445 Fall 17
 */
import java.util.concurrent.ThreadLocalRandom;
public class RandQuick
{
	public static final int MIN_SIZE = 5;
	public static <T extends Comparable<? super T>>
		   void quickSort(T[] array, int n)
	{
		quickSort(array, 0, n-1);
	} // end quickSort

	public static <T extends Comparable<? super T>>
		   void quickSort(T[] array, int first, int last)
	{
		//for base case, do insertion sort (< 5 size)
		if (last - first + 1 < MIN_SIZE)
		{
			insertionSort(array, first, last);
		}
		//otherwise do random pivot
		else{
			int left=first; int right=last;
			if(last>first){
				int pivotIndex = ThreadLocalRandom.current().nextInt(first, last+1);  // RANDOM PIVOT INDEX, inclusive
				T pivot = array[pivotIndex];
				//check until cross
				while(right > left)
				{
					//find value on left > pivot
					while(array[left].compareTo(pivot) < 0 && left<last)
					{
						left++;
					}
					//find value on right < pivot
					while(array[right].compareTo(pivot) > 0 && right>first)
					{
						right--;
					}
					//swap here
					if(left <= right)
					{
						swap(array,left,right);
						left++;
						right--;
					}
				}
				//recurse the two array parts
				quickSort(array,first,right);
				quickSort(array,left,last);
			}
		}
	}  // end quickSort

	private static void swap(Object [] a, int i, int j)
	{
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp; 
	} // end swap

	//INSERTION SORT (3) (FOR BASE CASE)
	public static <T extends Comparable<? super T>>
	void insertionSort(T[] a, int n)
	{
		insertionSort(a, 0, n - 1);
	} // end insertionSort

	public static <T extends Comparable<? super T>>
	void insertionSort(T[] a, int first, int last)
	{
		int unsorted, index;

		for (unsorted = first + 1; unsorted <= last; unsorted++)
		{   // Assertion: a[first] <= a[first + 1] <= ... <= a[unsorted - 1]

			T firstUnsorted = a[unsorted];

			insertInOrder(firstUnsorted, a, first, unsorted - 1);
		} // end for
	} // end insertionSort

	private static <T extends Comparable<? super T>>
	void insertInOrder(T element, T[] a, int begin, int end)
	{
		int index;

		for (index = end; (index >= begin) && (element.compareTo(a[index]) < 0); index--)
		{
			a[index + 1] = a[index]; // make room
		} // end for

		// Assertion: a[index + 1] is available
		a[index + 1] = element;  // insert
	} // end insertInOrder
}