//James Smith
//APCS1 pd5
//HW48 -- Halving the Halves
//2016-12-19

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

    public void addBinary(Comparable newVal){
	int min = 0;
	int max = size();
	int index = (max + min)/2;
	while(min != max){
	    if (newVal.compareTo(get(index)) < 0){
		max = index;
	    }
	    else{
		min = index+1;
	    }
	    index = (max + min)/2;
	}
	_data.add(index, newVal);
    }
    
    // main method solely for testing purposes
    public static void main( String[] args ) {

	OrderedArrayList Franz = new OrderedArrayList();

	// testing linear search
	for( int i = 0; i < 15; i++ )
	    Franz.addBinary( (int)( 50 * Math.random() ) );
	System.out.println( Franz );

	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class OrderedArrayList
