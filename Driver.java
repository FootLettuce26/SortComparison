package SortComparison;
import java.util.Random;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) 
	{
		while(true)
		{
			Scanner myScanner = new Scanner(System.in);
			System.out.println("How big is the array?");
			int size = myScanner.nextInt();
			
			//creating an array at size 50, maybe change it later to a Scanner
			int[] sourceArray = new int[size];
			int[] destArray;
			Random rand = new Random();
			
			for(int j = 0; j < sourceArray.length; j++)
			{
				//random numbers 1-1000
				sourceArray[j] = rand.nextInt(1000 + 1);
				//System.out.println(sourceArray[i]);
			}
			//System.out.println("NEW ARRAY");
			destArray = sourceArray.clone(); //cloning the first array to the second array
			
			SelectionSort(sourceArray);
			BubbleSort(destArray);

		}
			
	}
	
	public static void SelectionSort(int[] ar)
	{
		int smallest;
		int temp;
		
		long start = System.nanoTime();
		
		for(int i = 0; i < ar.length - 1; i++)
		{
			smallest = i;
			
			for(int j = i + 1; j < ar.length; j++)
			{
				if(ar[j] < ar[smallest]) //if ar[1] is less than ar[0]
				{
					smallest = j; //setting smallest to the index of j
				}
			}
			
			temp = ar[i]; //storing ar[i] into temp
			ar[i] = ar[smallest]; //then replacing ar[i] with ar[i+1]
			ar[smallest] = temp; //ar[i+1] is replaced by ar[i]
			
		}
		long finish = System.nanoTime();
		long timeElapsed = finish - start;
		
		
		System.out.println("SelectionSort sorted an array of " + ar.length + " in " + timeElapsed + "ns.");
	}
	
	public static void BubbleSort(int[] ar) //literally takes forever to run
	{
		int temp;
		boolean swapped;
		
		long start = System.nanoTime();
		
		for (int i = 0; i < ar.length - 1; i++) //going through entire length of list - 1
		{
            swapped = false; //resets to false 
            
            for (int j = 0; j < ar.length - 1; j++) //
            {
                if (ar[j] > ar[j + 1]) 
                {
                    temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                    swapped = true; //sees if a swap is made
                }
            }

            if (!swapped) //program ends if no swaps were made
            {
                break;
            }
        }
		long finish = System.nanoTime();
		long timeElapsed = finish - start;
		System.out.println("BubbleSort sorted an array of " + ar.length + " in " + timeElapsed + "ns.");

	}
	
	

}
