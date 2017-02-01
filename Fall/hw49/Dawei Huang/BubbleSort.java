//Dawei Huang
//APCS1 pd4
//HW49 -- Dat Bubbly Tho
//2016-21-12

/*======================================
  class BubbleSort -- implements bubblesort algorithm (vanilla version)
  ======================================*/

import java.util.ArrayList;

public class BubbleSort 
{

    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	int randomIndex;
	//setup for traversal fr right to left
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSortV( ArrayList<Comparable> data ) 
    {
	/* YOUR IMPLEMENTATION HERE */
	boolean testSorted = true;
	while (testSorted == true){
	    for(int index = 0; index < data.size() - 1; index++){
		if(data.get(index).compareTo(data.get(index + 1)) > 0){
		    Comparable save1 = data.get(index);
		    Comparable save2 = data.get(index + 1);
		    data.set(index, save2);
		    data.set(index + 1, save1);
		    testSorted = false;
		}
	    }
	    if (testSorted == true){
		return;
	    }
	    testSorted = true;
	}
    }//end bubbleSortV


    // ArrayList-returning bubbleSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input ) 
    {
	/* YOUR IMPLEMENTATION HERE */
	boolean testSorted = true;
	while (testSorted == true){
	    for(int index = 0; index < input.size() - 1; index++){
		if(input.get(index).compareTo(input.get(index + 1)) > 0){
		    Comparable save1 = input.get(index);
		    Comparable save2 = input.get(index + 1);
		    input.set(index, save2);
		    input.set(index + 1, save1);
		    testSorted = false;
		}
	    }
	    if (testSorted == true){
		return input;
	    }
	    testSorted = true;
	}
	return input;
    }


    public static void main(String [] args)
    {
	  System.out.println("\nTest for void method");
	  ArrayList glen = new ArrayList<Integer>();
	  glen.add(7);
	  glen.add(1);
	  glen.add(5);
	  glen.add(12);
	  glen.add(3);
	  System.out.println( "ArrayList glen before sorting:\n" + glen );
	  bubbleSortV(glen);
	  System.out.println( "ArrayList glen after sorting:\n" + glen );

	  ArrayList coco = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco );
	  bubbleSortV(coco);
	  System.out.println( "ArrayList coco after sorting:\n" + coco );

	  System.out.println("\nTest for return method");
	  ArrayList glen1 = new ArrayList<Integer>();
	  glen1.add(7);
	  glen1.add(1);
	  glen1.add(5);
	  glen1.add(12);
	  glen1.add(3);
	  System.out.println( "ArrayList glen before sorting:\n" + glen1 );
	  ArrayList glenSorted = bubbleSort( glen1 );
	  System.out.println( "sorted version of ArrayList glen:\n" 
	  + glenSorted );
	  System.out.println( "ArrayList glen after sorting:\n" + glen1 );

	  ArrayList coco1 = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco1 );
	  ArrayList cocoSorted = bubbleSort( coco1 );
	  System.out.println( "sorted version of ArrayList coco:\n" 
	  + cocoSorted );
	  System.out.println( "ArrayList coco after sorting:\n" + coco1 );

    }//end main

}//end class BubbleSort
