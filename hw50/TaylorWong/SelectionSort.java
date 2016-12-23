/*======================================
  class SelectionSort -- implements SelectionSort algorithm
  ======================================*/

import java.util.ArrayList;

public class SelectionSort 
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
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV( ArrayList<Comparable> data ) 
    {
	//note: this version places greatest value at rightmost end,

	//maxPos will point to position of SELECTION (greatest value)
	int maxPos;
	for (int slot = data.size() - 1; slot >= 0; slot -= 1) {
	    maxPos = slot;
	    for (int below = slot - 1; below >= 0; below -= 1) {
		int check = data.get(below).compareTo(data.get(maxPos));
		if (check == 1) {
		    maxPos = below;
		}
	    }
	    Comparable currVal = data.get(slot);
	    Comparable biggerVal = data.get(maxPos);
	    data.set(slot, biggerVal);
	    data.set(maxPos, currVal);
	    //print state of the data after this swap
	    // System.out.println(data);
	}
    }//end selectionSort


    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input ) 
    {
	ArrayList<Comparable> copy = input;
	selectionSortV(copy);
	return copy;
    }//end selectionSort 


    public static void main( String [] args ) 
    {
	/*===============for VOID methods=============

	  ArrayList glen = new ArrayList<Integer>();
	  glen.add(7);
	  glen.add(1);
	  glen.add(5);
	  glen.add(12);
	  glen.add(3);
	  System.out.println( "ArrayList glen before sorting:\n" + glen );
	  selectionSortV(glen);
	  System.out.println( "ArrayList glen after sorting:\n" + glen );

	    ArrayList coco = populate( 10, 1, 1000 );
	      System.out.println( "ArrayList coco before sorting:\n" + coco );
	        selectionSortV(coco);
		  System.out.println( "ArrayList coco after sorting:\n" + coco );
		  ============================================*/
	/*==========for AL-returning methods==========
	    
	    ArrayList glen = new ArrayList<Integer>();
	      glen.add(7);
	        glen.add(1);
		  glen.add(5);
		    glen.add(12);
		      glen.add(3);
		        System.out.println( "ArrayList glen before sorting:\n" + glen );
			  ArrayList glenSorted = selectionSort( glen );
			    System.out.println( "sorted version of ArrayList glen:\n" 
			          + glenSorted );
				        System.out.println( "ArrayList glen after sorting:\n" + glen );

					      ArrayList coco = populate( 10, 1, 1000 );
					            System.out.println( "ArrayList coco before sorting:\n" + coco );
						          ArrayList cocoSorted = selectionSort( coco );
							        System.out.println( "sorted version of ArrayList coco:\n" 
								          + cocoSorted );
									    System.out.println( "ArrayList coco after sorting:\n" + coco );
									      System.out.println( coco );

									      ============================================*/

    }//end main

}//end class SelectionSort
