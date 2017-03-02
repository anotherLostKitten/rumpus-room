//James Smith
//APCS1 pd5
//HW44 -- In America, the Driver Sits on the Left
//2016-12-12

public class SuperArray implements List 
{
    private Object[] _data;  //underlying container structure
    private int _lastPos; //marker for last meaningful value
    private int _size;    //number of meaingful values

    //default constructor
    //initializes 10-item array
    public SuperArray() 
    { 
	_data = new Object[10];
	_lastPos = -1;
	_size = 0;	
    }


    //output array in [a,b,c] format
    //eg, for int[] a = {1,2,3} ...
    //toString() -> "[1,2,3]"
    public String toString() 
    { 
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	if ( foo.length() > 1 )
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }


    //double capacity of this instance of SuperArray 
    private void expand() 
    { 
	Object[] temp = new Object[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }


    //accessor method -- return value at specified index
    public Object get( int index ) 
    {
	if (index < 0 || index >=size()){
	    throw new IndexOutOfBoundsException("Index out of range");
	}
	return _data[index];
    }


    //mutator method -- set index to newVal, return old value at index
    public Object set( int index, Object newVal ) 
    {
	if (index < 0 || index >=size()){
	    throw new IndexOutOfBoundsException("Index out of range");
	}
	Object temp = _data[index];
	_data[index] = newVal;
	return temp;
    }



    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public boolean add(Object newVal ) 
    { 
	//first expand if necessary
	if ( _size >= _data.length )
	    expand(); 
	_data[_lastPos+1] = newVal;
	_lastPos++;
	_size++;
	return true;
    }


    //inserts an item at index
    //shifts existing elements (starting at index) right 1 slot
    public void add( int index, Object newVal )
    {
	if (index < 0 || index >=size()){
	    throw new IndexOutOfBoundsException("Index out of range");
	}
	//first expand if necessary
	if ( _size >= _data.length )
	    expand();
	else {
	    for( int i = _size; i > index; i-- ) {
		_data[i] = _data[i-1]; 
	    } 
	    _data[index] = newVal;
	    _lastPos++;
	    _size++;
	}
    }
	    


    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public Object remove( int index ) 
    { 
	if (index < 0 || index >=size()){
	    throw new IndexOutOfBoundsException("Index out of range");
	}
	Object ret = _data[index];
	for( int i=index; i < _size - 1; i++ ) {
	    _data[i] = _data[i+1];
	}
	_data[_size-1] = 0; //unnecessary
	_size--;
	_lastPos--;
	return ret;
    }


    //return number of meaningful items in _data
    public int size() 
    { 
	return _size;
    }


    //main method for testing
    public static void main( String[] args ) 
    {
	SuperArray sausage = new SuperArray();
	List bratwurst = new SuperArray();

	//SuperArray Tests
	System.out.println("Printing SuperArray Test Cases:");
	System.out.println("Printing SuperArray's empty array:");
	System.out.println(sausage);
	System.out.println("Populating SuperArray with an Object. Should return true:");
	System.out.println(sausage.add("sauerkraut"));
	System.out.println(sausage);
	System.out.println("Adding an Object before the 1st:");
	sausage.add(0, 7);
	System.out.println(sausage);
	System.out.println("Size should be 2:");
	System.out.println(sausage.size());
	System.out.println("Get should return 7");
	System.out.println(sausage.get(0));
	System.out.println("Should replace 7 with 14 and return 7:");
	System.out.println(sausage.set(0,14));
	System.out.println(sausage);
	System.out.println("Should remove the string sauerkraut and return it:");
	System.out.println(sausage.remove(1));
	System.out.println(sausage);

	//List Tests
	System.out.println("Printing List Test Cases:");
	System.out.println("Printing List's empty array:");
	System.out.println(bratwurst);
	System.out.println("Populating bratwurst with Objects. Should return true:");
	System.out.println(bratwurst.add("Mustard"));
	System.out.println(bratwurst.add(false));
	System.out.println(bratwurst);
	System.out.println("Should return false:");
	System.out.println(bratwurst.get(1));
	System.out.println("Should replace false with true and return false:");
	System.out.println(bratwurst.set(1, true));
	System.out.println(bratwurst);
	System.out.println("Should return 2");
	System.out.println(bratwurst.size());
    }//end main()

}//end class SuperArray
