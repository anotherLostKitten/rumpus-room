//Tiffany Moi
//APCS1 pd5
//HW44 -- In America, the Driver Sits on the Left
//2016-12-12
/*==================================================
  class SuperArray version 4.0
  Wrapper class for array. Facilitates resizing, 
  expansion, and read/write capability on elements.
  ==================================================*/

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
    //eg, for Object[] a = {1,2,3} ...
    //toString() -> "[1,2,3]"
    public String toString() 
    { 
        String retstr = "[";
        for (Object x : _data){
            retstr += x + ",";
        }
        retstr = retstr.substring(0,retstr.length() - 1) + "]";
        return retstr;
    }

    //double capacity of this instance of SuperArray 
    private void expand() 
    {
        int i = 2 * _data.length;
        Object[] b = new Object[i];
        for (int c = 0; c < _data.length; c+=1){
            b[c] = _data[c];
        }
        _lastPos = _data.length - 1;
        _data=b;
    }

    //accessor method -- return value at specified index
    public Object get( int index ) 
    {	
	if (index < 0 || index >= size()){
	    throw new java.lang.IndexOutOfBoundsException("Bad Index: No meaningful value there");
	}
        return _data[index];
    }

    //mutator method -- set index to newVal, return old value at index
    public Object set( int index, Object newVal ) 
    {
	if (index < 0 || index >= size()){
	    throw new java.lang.IndexOutOfBoundsException("Bad Index: No meaningful value there");
	}
        Object a = get(index);
	_data[index] = newVal;
        return a;
    }


    //adds an item after the last item
    //updates _lastPos
    public void add( Object newVal ) 
    { 
        if (_size == _data.length) {
            expand();
        }
        _lastPos += 1;
        _data[_lastPos] = newVal;
	_size = _lastPos + 1;
    }

    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, Object newVal ) 
    {
	if (_size == _data.length){
	    expand();
	}
	if (index < 0 || index >= size()){
	    throw new java.lang.IndexOutOfBoundsException("Bad Index: No meaningful value there");
	}
	//creates new array to hold new values
        Object[] newArr = new Object[_data.length]; 
        for (int x = 0; x < index; x += 1) {
            newArr[x] = _data[x];
        } //copy over all values preceding the given index
        newArr[index] = newVal; //add new value
        for (int x = index + 1; x < _data.length; x += 1) {
            newArr[x] = _data[x - 1]; 
        } //copy over the rest of the values after the given index
	_lastPos += 1;
	_size = _lastPos + 1;
        _data = newArr; //update
    }

    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    //copies all of the values except the one at the index
    public void remove( int index ) 
    {
	   
	if (index < 0 || index >= size()){
	    throw new java.lang.IndexOutOfBoundsException("Bad Index: No meaningful value there");
	}
        Object[] newArr = new Object[_data.length]; //new array to store values
        for (int x = 0; x < index; x += 1) {
            newArr[x] = _data[x];
        } 
        for (int x = index + 1; x < newArr.length; x += 1) {
            newArr[x - 1] = _data[x]; 
        }
        _data = newArr; //update
	_lastPos -= 1;
	_size = _lastPos + 1;
    }

    //return number of meaningful items in _data
    public int size() 
    {
        return _size;
    }


    //main method for testing
    public static void main( String[] args ) 
    {
        List mayfield = new SuperArray();
        System.out.println("Printing empty ListInt mayfield...");
        System.out.println(mayfield);
        mayfield.add(5);
        mayfield.add(4);
        mayfield.add(3);
        mayfield.add(2);
        mayfield.add(1);
        System.out.println("Printing populated ListInt mayfield...");
        System.out.println(mayfield);
	try{
	    mayfield.remove(3);
	    System.out.println("Printing ListInt mayfield post-remove...");
	    System.out.println(mayfield);
	}
	catch(IndexOutOfBoundsException e){
	    System.out.println("Give me a better index");
	}
	try{
	    mayfield.remove(4); // Index out of bounds
	    System.out.println("Printing List Int mayfield post-remove...");
	    System.out.println(mayfield);
	}
	catch(IndexOutOfBoundsException e){
	    System.out.println("Give me a better index");
	}
	try{
	    mayfield.add(2,99);
	    System.out.println("Printing ListInt mayfield post-insert...");
	    System.out.println(mayfield);
	}
	catch(IndexOutOfBoundsException e){
	    System.out.println("Give me a better index");
	}
	try{
	    mayfield.add(5,88); // Index out of bounds
	    System.out.println("Printing ListInt mayfield post-insert...");
	    System.out.println(mayfield);
	}
	catch(IndexOutOfBoundsException e){
	    System.out.println("Give me a better index");
	}
	try{
	    mayfield.add(1,77);
	    System.out.println("Printing ListInt  mayfield post-insert...");
	    System.out.println(mayfield);
	}
	catch(IndexOutOfBoundsException e){
	    System.out.println("Give me a better index");
	}
	
    }//end main()

}//end class SuperArray
