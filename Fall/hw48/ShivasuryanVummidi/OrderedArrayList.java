/*Shivasuryan Vummidi
APCS1 pd3
HW 46: Create a Wrapper Class for ArrayList to make use of its methods more automatic.
2016-12-14

MAJOR CREDIT FOR HELPING GOES TO DAWEI HUANG OF PERIOD 4
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
		String retStr = "";
		for(int x = 0; x < _data.size(); x++){
			retStr += _data.get(x) + " ";
		}
		return retStr;
	}

    public Comparable remove( int index ) { 
		Comparable a = _data.get(index);
		_data.remove(index);
		return a;
    }


    public int size() { 
		return _data.size();
    }

    
    public Comparable get( int index ) { 
		return _data.get(index);
    }

    public boolean max(int a, int b){
		if(b > a){
			return true;
		}
		return false;
    }
    // addLinear takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a linear search to find appropriate index
    public void addLinear( Comparable newVal ) { 
		int final_index = 0;
		int newVal1 = (int)newVal;
		if(size() == 0){_data.add(newVal);} //automatically adds newVal if the size is 0
		if(0 > newVal1){_data.add(0, newVal);} //replaces 0 with newVal if the first Comparable is greater;
		if((int)_data.get(_data.size() - 1) < newVal1){_data.add(newVal);} //if newVal is greater than the largest Comparable, then we just append it to the ArrayList. 
		else{
			for(int x = 0; x < _data.size() - 1; x++){
				int firstPos = (int)_data.get(x);
				int secondPos = (int)_data.get(x);
				if(!max(firstPos, secondPos)){
					_data.add(newVal);
					break;
				}
				final_index++;
			}
		}
    }

	public void addBinary(Comparable newVal){
		int final_index = _data.size();
		int initial_index = 0;
		int newVal1 = (int)newVal;
		int mean;
		boolean target = false;
		if(_data.size() < 2){
			_data.add(newVal);
			target = true;
		}
		else{target = false;}
		final_index = _data.size();
		while(target == false){
			mean = (initial_index + final_index) / 2;
			if(newVal1 < (int)_data.get(initial_index)){
				_data.add(0, newVal);
				target = true;
			}
			else if (newVal1 > (int)_data.get(final_index - 1)){
				_data.add(newVal);
				target = true;
			}
			if(newVal1 < (int)_data.get(mean)){
				final_index = mean;
			}
			else{
				initial_index = mean;
			}
		}
	}
    // main method solely for testing purposes
    public static void main( String[] args ) {
	

	OrderedArrayList Franz = new OrderedArrayList();
	OrderedArrayList Helga = new OrderedArrayList();
	//System.out.println("\nValues to add via addLinear() calls:");

	// testing linear search
	for( int i = 0; i < 15; i++ ) {
	    int valToAdd = (int)( 50 * Math.random() );
	    System.out.println( valToAdd );
	    Franz.addLinear( valToAdd );
		Helga.addBinary( valToAdd );
	}
	System.out.println("\nafter population via addLinear() calls:");
	System.out.println( Franz );
	System.out.println(Helga);
	System.out.println();
/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class OrderedArrayList
 
