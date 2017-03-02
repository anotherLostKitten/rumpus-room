/*
Jennifer Yu 
APCS1 Period 3
2016-12-19
HW #48: Halving the Halves
*/
import java.util.ArrayList;
public class OrderedArrayList{

    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private ArrayList<Comparable> _data;
	/*Comparable lo = 0; 
	Comparable hi;
	Comparable middle;*/

    // default constructor initializes instance variable _data
    public OrderedArrayList() {
		//will expand on demand!!
		_data = new ArrayList();
    }

	//returns a string of the Comparables in _data
    public String toString() { 
		String s = "";
		for (Comparable i : _data){
			s += i + " ";
			System.out.println(i + " ");
		}
		return s;
    }

	//Removes the value at the specified index (utilizes method in ArrayList)
    public Comparable remove( int index ) { 
		Comparable a = _data.get(index);
		_data.remove(index);
		return a;
    }

	//Returns # of elements in _data (utilizes ArrayList method)
    public int size() { 
		return _data.size();
    }

    //Returns Comparable at specified index (utilizes ArrayList method)
    public Comparable get( int index ) { 
		return _data.get(index);
    }
	


    // addLinear takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a linear search to find appropriate index
    public void addLinear( Comparable newVal ) { 
		//if _data has no elements, then just add element 0. 
		if (_data.size() == 0){ 
			_data.add(newVal);
		}
		else{
			for (int i = 0; i < _data.size(); i ++){
				//if the Comparable at index i in data is greater than or equal to the newVal, then add at the index i (will shift right)
				if (_data.get(i).compareTo(newVal) >= 0){
					_data.add( i, newVal);
					//I inserted this break, as my code would go on running forever without it. 
					break;
				}
			}
		}

    }
	
	public void addBinary(Comparable newVal){
		addBinaryHelp(0, _data.size()-1, newVal);
	}
	
	
	public void addBinaryHelp(int lo, int hi, Comparable newVal){
		if (lo > hi){
			_data.add(lo, newVal);
			return;
		}
		else{
			int middle = (lo + hi)/2;
			if (newVal.compareTo(_data.get(middle)) < 0){
				addBinaryHelp(lo, middle-1, newVal);
				//return;
			}
			else if (newVal.compareTo(_data.get(middle)) > 0){
				addBinaryHelp(middle+1, hi, newVal);
				//return;
			}
			else{
				_data.add(middle, newVal);
				return;
			}
		}
	}


    // main method solely for testing purposes
    public static void main( String[] args ) {
	

	OrderedArrayList Franz = new OrderedArrayList();

	System.out.println("\nValues to add via addBinary() calls:");
	// testing linear search
	for( int i = 0; i < 4; i++ ) {
	    int valToAdd = (int)( 50 * Math.random() );
	    System.out.println( valToAdd );
	    Franz.addBinary( valToAdd );
	}

	System.out.println("\nafter population via addBinary() calls:");
	System.out.println( Franz );
	System.out.println((-1+0)/2);
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class OrderedArrayList
