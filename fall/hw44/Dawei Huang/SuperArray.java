//Dawei Huang
//APCS1 pd4
//HW44 --  In America, the Driver Sits on the Left
//2016-12-12

/*==================================================
  class SuperArray version 2.0
  Wrapper class for array. Facilitates resizing, 
  expansion, and read/write capability on elements.
  ==================================================*/

public class SuperArray implements List {

    private Object[] _data;  //underlying container structure
    private int _lastPos; //marker for last meaningful value
    private int _size;    //number of meaingful values

    //default constructor
    //initializes 10-item array
    public SuperArray() 
    { 
	/* YOUR IMPLEMENTATION HERE */
	_data = new Object[10];
	_lastPos = -1;
	_size = 0;
    }

    //output array in [a,b,c] format
    //eg, for Object[] a = {1,2,3} ...
    //toString() -> "[1,2,3]"
    public String toString() 
    { 
	/* YOUR IMPLEMENTATION HERE */
	String retrStr = "[";
	for(int i = 0; i < _data.length - 1; i += 1){
		retrStr += _data[i] + ",";
	}
	retrStr = retrStr.substring( 0, retrStr.length()-1 ) + "]"; 
	return retrStr;
	}

    //double capacity of this instance of SuperArray 
    private void expand() 
    { 
	/* YOUR IMPLEMENTATION HERE */
	Object[] newArray = new Object[2*_data.length];
	for (int a = 0; a < _data.length; a++) {
	    newArray[a] = _data[a];
	}
	_data = newArray;
    }

    //accessor method -- return value at specified index
    public Object get ( int index ) throws IndexOutOfBoundsException 
    {
	/* YOUR IMPLEMENTATION HERE */
	return _data[index];
    }

    //mutator method -- set index to newVal, return old value at index
    public Object set( int index, Object newVal ) throws IndexOutOfBoundsException
    {
	/* YOUR IMPLEMENTATION HERE */
	Object a = _data[index];
	_data[index] = newVal;
	return a;
    }

    //adds an item after the last item
    public boolean add(Object newVal) {
	if (_lastPos == _data.length-1) {
	    expand();
	}
	_data[_lastPos+1] = newVal;
	_lastPos += 1;
	_size += 1;
	return true;
    }

    //inserts an item at index
    //shifts existing elements to the right
    public void add(int index, Object newVal) throws IndexOutOfBoundsException {
	while (index >= _data.length || _lastPos == _data.length-1) {
	    expand();
	}
	for (int a = _data.length-2; a >= index; a--) {
	    _data[a+1] = _data[a];
	}
	_data[index] = newVal;
	if (index > _lastPos) {
	    _lastPos = index;
	}
	else {
	    _lastPos += 1;
	}
	_size = _lastPos+1;
    }

    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public Object remove(int index) throws IndexOutOfBoundsException {
	Object removeObj = _data[index];
	for( int a = index; a <= _lastPos - 1; a++ ) {
	    _data[a] = _data[a+1];
	}
	_data[_lastPos] = 0;
	_lastPos -= 1;
	_size -= 1;
	return removeObj;
    }

    //return number of meaningful items in _data
    public int size() {
	return _size;
    }

    //main method for testing
    public static void main( String[] args ) 
    {

	List curtis = new SuperArray();
	System.out.println("Printing empty SuperArray curtis...");
	System.out.println(curtis);

	for( int i = 0; i < ((SuperArray)curtis)._data.length; i++ ) {
	    ((SuperArray)curtis).set(i,i*2);
	    ((SuperArray)curtis)._size++;
	}

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(curtis);

	List mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.add(5);
	mayfield.add(4);
	mayfield.add(3);
	mayfield.add(2);
	mayfield.add(1);

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);

	mayfield.add(3,99);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	//===========================================*/
    }//end main()

}//end class SuperArray
