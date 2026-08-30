package edu.pitt.cs;

//TODO: Import libraries as needed
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class SortedCollection {
	// TODO: Add member variables or methods as needed

	
	LinkedList<Integer> list = new LinkedList<>();	

	/**
	 * Adds the number n to the collection.
	 * 
	 * @param n the number to add to the collection
	 * @return always returns true
	 */
	public boolean add(int n) {
		// TODO: Implement
		ListIterator<Integer> current = list.listIterator();	
		int i = 0;
		while(current.hasNext())
		{
			
			int currentValue = current.next();
			if(currentValue >= n)
			{
				break;
			}
			i++;
		}
		list.add(i, n);
		return true;
	}

	/**
	 * Removes the smallest number in the collection and returns it.
	 * If the collection is empty, throws a NoSuchElementException.
	 * 
	 * @return the smallest number in the collection
	 */
	public int remove() throws NoSuchElementException {
		// TODO: Implement
		if(list.size() == 0)
		{
			throw new NoSuchElementException("No Such Element to be removed");
		}
		else
		{
			//ListIterator<Integer> current = list.listIterator();	
			
			return list.removeFirst();	
		}
	}

	/**
	 * Prints usage information.
	 */
	public static void showUsage() {
		System.out.println("Usage: java SortedCollection [num1] [num2] [num3] ...");
	}

	/**
	 * Main method. Receives a list of numbers as commandline arguments and prints
	 * out the list in sorted order from smallest to largest.
	 * 
	 * @param args commandline arguments; see showUsage() for detailed information
	 */
	public static void main(String[] args) {
		SortedCollection collection = new SortedCollection();
		if (args.length == 0) {
			showUsage();
			//return;
		}
		
		// TODO: add numbers in commandline arguments to collection using the add(int) method.
		// If any commandline argument is not a number, call showUsage() and return.
		
		int temp;
		//String[] numsStr = args[0].split(" ");
		for(int i = 0; i< args.length; i++)
		{
			int ascii = args[i].charAt(0);
			if((ascii <= 48 && ascii >= 58) || ascii == 45) //checks ascii value is a number or is the negative sign
			{
				temp = Integer.parseInt(args[i]);
				
			}
			else
			{
				break;
			}
			collection.add(temp);
		}


		System.out.print("sorted: ");
		for (int i = 0; i < args.length; i++) {
			int num = collection.remove();
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
