/*
Jack Cruse
APCS1 pd4
HW48 -- Halving the Halves
2016-12-19
*/ 

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
	Comparable temp = _data.get(index);
	_data.remove(index);
	return temp;
    }


    public int size() {
	return _data.size();
    }

    
    public Comparable get( int index ) {
	return _data.get(index);
    }


    public static boolean sorted(OrderedArrayList L) {
	boolean bool = true;//instantiate bool
	int i = 1;//instantiate counter
	while (bool && (i < L.size())) {
	    //while bool is true and not all indices have been
	    //looped through
	    //will short circuit if bool is false
	    bool = (L.get(i - 1)).compareTo(L.get(i)) <= 0;
	    //bool remains true if lower index element
	    //is less than higher index element
	    i += 1;//increment
	}
	return bool;//return boolean
    }
    
    // addLinear takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a linear search to find appropriate index
    public void addLinear( Comparable newVal ) {
	boolean bool = true;//instantiate bool
	int i = 0;//instantiate counter
	while (bool && (i < _data.size())) {
	    //while bool is true and not all indices have been
	    //looped through
	    //will short circuit if bool is false
	    bool = newVal.compareTo(_data.get(i)) > 0;
	    //bool remains true if newVal
	    //is greater than _data element
	    if (bool) {
	    i += 1;//increment
	    }
	}
	/*	if (bool) {
	    _data.add(newVal);//if loop through without
	    //finding an item > self
	    //add at end
     	}

	else {*/
	_data.add(i, newVal);//add newVal at index found
	    //	} for some reason only one line works
    }

    public void addBinary( Comparable newVal ) {
	addBinaryH(newVal, this.size(), 0);
    }

    public void addBinaryH( Comparable newVal, int high, int low ) {
	int mid = (high + low) / 2;

	if (low == high) {//if the low and high
	    //have converged, insert there
	    _data.add(low, newVal);
	}
	
	else if (newVal.compareTo(_data.get(mid)) > 0) {
	    //if newVal > midVal, low = mid + 1
	    //this works because I always floor
	    addBinaryH(newVal, high, mid + 1);
	}
	
	else if (newVal.compareTo(_data.get(mid)) < 0) {
	    //if newVal < midVal, high = mid
	    //don't have to subtract 1 since I
	    //always floor
	    addBinaryH(newVal, mid, low);
	}
	
	else {
	    //newVal == midVal, add at mid
	    _data.add(mid, newVal);
	}
    }
	
    

    // main method solely for testing purposes
    public static void main( String[] args ) {

	OrderedArrayList Franz = new OrderedArrayList();

	System.out.println("\nValues to add via addLinear() calls:");

	// testing linear search
	for( int i = 0; i < 15; i++ ) {
	    int valToAdd = (int)( 50 * Math.random() );
	    System.out.println( valToAdd );
	    Franz.addBinary( valToAdd );
	}
	System.out.println("\nafter population via addBinary() calls:");
	System.out.println( Franz );
	System.out.println( sorted(Franz) );//use sorted
	//to check if it works since we have working code
	System.out.println();
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class OrderedArrayList
 
