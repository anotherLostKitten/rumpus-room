//Edwin Mok
//APCS1 pd3
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
public class OrderedArrayList {
    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private ArrayList<Comparable> _data;
    // default constructor initializes instance variable _data
    public OrderedArrayList() {
	_data = new ArrayList<Comparable>(); 
    }
    public String toString() { 
        String r = "["; 
	for (Comparable i: _data) { 
	    r += i.toString() + ", "; 
	}
	if (r.length() > 1){
	    r = r.substring(0, r.length() - 2) + "]";
	}
	return r; 
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
	// Cases: Size = 0 / Bookends
	if (_data.size() == 0) {_data.add(newVal);} 
	else { 
	    if (newVal.compareTo(_data.get(0)) == -1) {_data.add(0, newVal);}
	    else if (newVal.compareTo(_data.get(_data.size()-1)) == 1) {_data.add(newVal);} 
	    else { 
		for (int i = 0; i < _data.size() - 1; i++) { 
		    boolean b1 = newVal.compareTo(_data.get(i)) > -1; 
		    boolean b2 = newVal.compareTo(_data.get(i+1)) < 1;
		    if (b1 && b2) {_data.add(i+1, newVal); break;}
		    else if (_data.get(i).compareTo(newVal) == 0 || _data.get(i+1).compareTo(newVal) == 0){
			throw new ClassCastException("Error: input cannot be equal to any value in the ArrayList");
		    }
		}     
	}        
	}}

    //-----------------------HW48 Part---------------------------------
    //addBinary takes as input any comparable object
    //inserts newVal at the appropriate index
    //use a binary search to find appropriate index
    public void addBinary( Comparable newVal) {
	if (_data.size() == 0) {_data.add(newVal);}
	else {
	    int first = 0;
	    int last = _data.size();
	    if (last - first == 1 && newVal.compareTo(_data.get(0)) < 0){
		_data.add(0,newVal);
		return;
	    }
	    while (last - first != 0){
		if (newVal.compareTo(_data.get((first+last)/2)) >= 0 && last - first == 1){
		    first = (first+last)/2 + 1;
		}
		else if (newVal.compareTo(_data.get((first+last)/2)) >= 0){
		    first = (first+last)/2;
		}
		else if (newVal.compareTo(_data.get((first+last)/2)) < 0){
		    last = (first+last)/2;
		}
	    }
	    _data.add(last,newVal);
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
	System.out.println();
    }
}//end class OrderedArrayList
