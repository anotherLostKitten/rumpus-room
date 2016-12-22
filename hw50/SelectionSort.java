/*======================================
  class SelectionSort -- implements SelectionSort algorithm
  ======================================*/
  /*
  Jennifer Yu 
  APCS1 Period 3
  HW #50: Selection
  2016-12-21
  */

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

	public static int findMin (ArrayList<Comparable> data, int index){
		Comparable min = data.get(index);
		int ind = index;
		for (int i = index; i < data.size(); i ++){
			if ((data.get(i)).compareTo(min) < 0){
				min = data.get(i);
				ind= i;
			}
		}
		return ind;
	}

    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV( ArrayList<Comparable> data ) 
{
	//note: this version places greatest value at rightmost end,
	//maxPos will point to position of SELECTION (greatest value)
	int maxPos;
	for (int i = 0; i < data.size(); i ++){
		//System.out.println(data.get(findMin(data, i)));
		//System.out.println("Index: " + i);
		//System.out.println("Value: " + data.get(i));
		data.set( i, data.set(findMin(data, i),data.get(i)) );
		//System.out.println(data);
		//System.out.println("Index: " + i);
		//System.out.println("Value: " + data.get(i));
	}
    }//end selectionSort

	public static ArrayList<Comparable> copyArr(ArrayList<Comparable> arrL){
		ArrayList<Comparable> a = new ArrayList<Comparable>();
		for (int i = 0; i < arrL.size(); i++){
			a.add(arrL.get(i));
		}
		return a;
	}

    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input ) 
{
		ArrayList<Comparable> a = new ArrayList<Comparable>();
		a = copyArr(input);
		selectionSortV(a);
		return a;
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
	//System.out.println(findMin(glen));
	selectionSortV(glen);
	System.out.println( "ArrayList glen after sorting:\n" + glen );

	
	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	selectionSortV(coco);
	System.out.println( "ArrayList coco after sorting:\n" + coco );
	
	  ============================================*/

	
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
	/*==========for AL-returning methods==========
	  ============================================*/

    }//end main

}//end class SelectionSort