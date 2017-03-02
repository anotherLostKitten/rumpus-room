/*Karina Ionkina
  APCS Period04
  HW 48 - Halving the Halves
  2016-12-19 */

/*============================================
   class OrderedArrayList
   Wrapper class for ArrayList.
   Imposes the restriction that stored items 
   must remain sorted in ascending order
   ============================================*/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;


public class OrderedArrayList 
{
    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private ArrayList<Comparable> _data;


    // default constructor initializes instance variable _data
    public OrderedArrayList() 
    {
	_data = new ArrayList<Comparable>();
    }


    public String toString() 
    { 
	return _data.toString(); 
    }


    public Comparable remove( int index ) 
    { 
	return _data.remove(index); 
    }


    public int size() 
    { 
	return _data.size();
    }

    
    public Comparable get( int index ) 
    { 
	return _data.get(index); 
    }

    // helper function finds index for insertation 
    public int Binary(Comparable newVal, int low, int high){
	
	int mean = (low + high)/2;
	// when low & high are equal to each other, index is found
	// if the value at the index == newVal, it can be added there
	if (low >= high){
	    return low;
	}
	if (newVal.compareTo(this.get(mean)) == 0){
	    return mean;
	}
	//mean + 1 becomes new low value if the number at the index is less than newVal
	if (newVal.compareTo(this.get(mean)) > 0){
	    
	    return Binary(newVal, mean + 1, high);
	}
	
	else { 
	    return  Binary(newVal, low, mean);
	}
    }

    // uses Binary(newVal, 0, size()) to find index for insertation
    // uses index to add the newVal
    public void addBinary(Comparable newVal){
	int index =  Binary(newVal, 0, this.size() - 1);
	if (index == this.size() - 1){
	    _data.add(newVal);
		return;
	}
       _data.add(index, newVal);
    }


    // addLinear takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a linear search to find appropriate index
    public void addLinear( Comparable newVal ) 
    { 
    for( int p = 0; p < _data.size(); p++ ) {
	    if ( newVal.compareTo( _data.get(p) ) < 0 ) { 
		//newVal < oal[p]
		_data.add( p, newVal );
		return; //Q:why not break?
	    }
	}
	_data.add( newVal ); //newVal > every item in oal, so add to end
    }


    // main method solely for testing purposes
    public static void main( String[] args ) {

	OrderedArrayList Franz = new OrderedArrayList();

	// testing linear search
	for( int i = 0; i < 15; i++ )
	    Franz.addLinear( (int)( 50 * Math.random() ) );
	System.out.println( Franz );
	
	Franz.addBinary(13);
	System.out.println( Franz );
        Franz.addBinary(23);
	System.out.println( Franz );
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class OrderedArrayList
