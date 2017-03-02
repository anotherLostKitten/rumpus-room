/*============================================
  class OrderedArrayList
  Wrapper class for ArrayList.
  Imposes the restriction that stored items 
  must remain sorted in ascending order
  ============================================*/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;


public class OrderedArrayList {

    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private ArrayList<Comparable> _data;


    // default constructor initializes instance variable _data
    public OrderedArrayList() {
	_data = new ArrayList<Comparable>();
    }


    public String toString() { 
	return _data.toString();
    }


    public Comparable remove( int index ) { 
	return _data.remove(index);
    }


    public int size() { 
	return _data.size();
    }

    
    public Comparable get( int index ) { 
	return _data.get(index);
    }


    // addLinear takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a linear search to find appropriate index
    public void addLinear( Comparable newVal ) { 
        for (int i = 0; i < size(); i++) {
	    if ( get(i).compareTo( newVal ) > 0) {
		_data.add(i, newVal);
	        return;
	    }
	}
	_data.add(newVal);
    }

    // inserts newVal at the appropriate index
    // uses a binary search to find appropriate index
    public void addBinary( Comparable newVal ) {
	int insertPos = binHelp( newVal, 0, size() );
	// newVal greater than all values in _data
	if (insertPos == size() ) {
	    _data.add(newVal);
	}
	// newVal less than (or equal to) value at pos insertPos
	// binary search removes the posibility of newVal being inserted anywhere else
	else if ( newVal.compareTo( get(insertPos) ) <= 0 ) {
	    _data.add(insertPos, newVal);
	}
	// newVal greater than value at pos insertPos
	// insert newVal at the location after insertPos
	else {
	    _data.add(insertPos+1, newVal);
	}
    }

    // helper function to addBinary()
    // utilizes tail recursion
    // returns insertion point
    public int binHelp( Comparable newVal, int lower, int upper )
    {
	int midPt = 0;
	// base case
	if (lower == upper) {
	    midPt = (lower + upper) / 2; // update insertion point one last time
	    return midPt;
	}
	else {
	    // System.out.println("Upper: " + upper); // print statements are for debugging, uncomment as needed
    	    // System.out.println("Lower: " + lower);
    	    midPt = (lower + upper) / 2;
	    // System.out.println("MidPt: " + midPt);
    	    if ( newVal.compareTo( get(midPt) ) > 0 ) {
    	        return binHelp( newVal, midPt+1, upper); // shift the lower bound up
    	    }
    	    else if ( newVal.compareTo( get(midPt) ) < 0 ) {
    	        return binHelp( newVal, lower, midPt ); // shift the upper bound up
    	    }
    	    else { // newVal equals value at pos index
    	        return midPt;
    	    }
	}
    }

    // main method solely for testing purposes
    public static void main( String[] args ) {


	OrderedArrayList Franz = new OrderedArrayList();

	System.out.println("\nValues to add via addBinary() calls:");

	// testing binary search
	for( int i = 0; i < 15; i++ ) {
	    int valToAdd = (int)( 50 * Math.random() );
	    System.out.println( valToAdd );
	    // Franz.addLinear( valToAdd );
	    Franz.addBinary( valToAdd );
	}

	System.out.println("\nafter population via addBinary() calls:");
	System.out.println( Franz );
	System.out.println();

        // Franz.addBinary(30);
	// System.out.println( Franz );
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class OrderedArrayList
