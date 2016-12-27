//Dawei Huang
//APCS1 pd4
//HW50 -- Selection, Natch
//12/22/16

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
	int currentPos = data.size() - 1;
	int maxPos;
	/* YOUR IMPLEMENTATION HERE */
	while (currentPos > 0){
		maxPos = currentPos;
	    for (int i = currentPos - 1; i >= 0; i--){
		if (data.get(currentPos).compareTo(data.get(i)) < 0){
		    if (data.get(i).compareTo(data.get(maxPos)) > 0){
			maxPos = i;
		    }
		}
	    }
	    if (maxPos != currentPos){
		Comparable data1 = data.get(currentPos);
		Comparable data2 = data.get(maxPos);
		data.set(maxPos, data1);
		data.set(currentPos, data2);
	    }
	    // System.out.println(data);
		currentPos -= 1;
	}
}//end selectionSort


    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input ) 
{
	/* YOUR IMPLEMENTATION HERE */
    ArrayList<Comparable> bert = input;
    selectionSortV(bert);
    return bert;

}//end selectionSort 


    public static void main( String [] args ) 
{

	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	selectionSortV(glen);
	System.out.println( "ArrayList glen after sorting:\n" + glen );


	System.out.println("\nTest for VOID methods");
	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	selectionSortV(coco);
	System.out.println( "ArrayList coco after sorting:\n" + coco );



	System.out.println("\nTest for AL-returning methods");
    	ArrayList glen1 = new ArrayList<Integer>();
	glen1.add(7);
	glen1.add(1);
	glen1.add(5);
	glen1.add(12);
	glen1.add(3);
	System.out.println( "ArrayList glen1 before sorting:\n" + glen1 );
	ArrayList glenSorted = selectionSort( glen1 );
	System.out.println( "sorted version of ArrayList glen1:\n" 
			    + glenSorted );
	System.out.println( "ArrayList glen1 after sorting:\n" + glen1 );

      	ArrayList coco1 = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco1 before sorting:\n" + coco1 );
	ArrayList cocoSorted = selectionSort( coco1 );
	System.out.println( "sorted version of ArrayList coco1:\n" 
			    + cocoSorted );
	System.out.println( "ArrayList coco1 after sorting:\n" + coco1 );
	System.out.println( coco1 );


    }//end main

}//end class SelectionSort