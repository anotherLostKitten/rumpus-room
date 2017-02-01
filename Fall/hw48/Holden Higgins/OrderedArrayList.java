/*
Holden Higgins
APCS1 pd 03
hw48 -- Halving the Halves
2016-12-20
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
	_data= new ArrayList<Comparable>();
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

    
    
    public void addBinary(int newVal){
	addBinaryHelper(newVal,0,_data.size());
    }
    public void addBinaryHelper(int newVal, int low, int high){
	//saves index of middle and value of middle
	int ind=(low+high)/2;
	int mid=(int)_data.get(ind);
	//if data fits in 1 below middle value, insert and index of middle
	if(mid>=newVal&&(int)_data.get(ind-1)<newVal){
	    _data.add(ind, newVal);
        }
	//recurses with appropriate range
	else{
	    if(mid>newVal){
		addBinaryHelper(newVal,low,ind);
	    }
	    else{
		if(mid<newVal){
		    addBinaryHelper(newVal,ind,high);
		}
	    }
	}
    }


    
    // addLinear takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a linear search to find appropriate index
    public void addLinear( Comparable newVal ) { 
	boolean added=false;
	for(int i=0;i<_data.size();i++){
	    if(newVal.compareTo(_data.get(i))<0){
		_data.add(i,newVal);
		added=true;
		break;
	    }
	}
	if(!added)
	    _data.add(newVal);
    }


    // main method solely for testing purposes
    public static void main( String[] args ) {

	OrderedArrayList Franz = new OrderedArrayList();

	// testing linear search
	for( int i = 0; i < 15; i++ ) {
	    int valToAdd = (int)( 50 * Math.random() );
	    Franz.addLinear( valToAdd );
	}
	System.out.println("\nafter population via addLinear() calls:");
	System.out.println( Franz );
	System.out.println();

	Franz.addBinary(25);
	System.out.println("after adding 25:");
	System.out.println(Franz);
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class OrderedArrayList
 
