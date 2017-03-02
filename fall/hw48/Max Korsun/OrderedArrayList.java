//Max Korsun
//APCS1 PD4
//HW 48 - Halving the Halves
//2016-19-16


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
	return _data.toString();//same as ArrayList
    }


    public Comparable remove( int index ) {
	return _data.remove(index);// returns the value and removes it at the same time
    }


    public int size() {
	return _data.size();//same as in AL
    }

    
    public Comparable get( int index ) {
	return _data.get(index);//same as AL
    }


    // addLinear takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a linear search to find appropriate index
    public  void addLinear( Comparable newVal ) {
	if(_data.size() == 0 || newVal.compareTo( _data.get(_data.size() -1)) >= 0 ){
	    _data.add(newVal);
	    return;
	    
	}

	int addTo = 0;
	for(int i=0; i<_data.size();i++){	    
	    if(newVal.compareTo(_data.get(i))<0){
		addTo = i;
		break;
	    }	   
	}
	_data.add(addTo,newVal);
    }

    //=======================AddBinary for HW48=================================
     public boolean addBinaryHelper(Comparable newVal, int min, int max){
	 // boolean done = false;
	 int mid = (min + max)/2;
	 if(size() == 0){// a special base case, not sure if still needed but would rather not risk breaking everything again
       	    _data.add(newVal);	    
       	}else
	     if((mid == max && mid == min)|| newVal.compareTo(get(mid)) == 0 ){// The first part of this must come first to shirt circuit the loop. In the case where the first part is true, it is possible that the second one will return an out of bounds error. can most likely be writen better but why fix what aint broke
	    _data.add(mid, newVal);
	    done = true;
	}else
		 if( newVal.compareTo(get(mid)) <0){//self-expl
	    addBinaryHelper(newVal,min,mid);
	}else
		     if( newVal.compareTo(get(mid)) >0){//self-expl
	    addBinaryHelper(newVal,mid+1,max);
	}
	return done;
    }
    
    public void addBinary(Comparable newVal){
       	addBinaryHelper(newVal,0,size());
    }

    /* public void addBinary(Comparable newVal){
	int min = 0;
	int max = _data.size()-1;
	if(_data.size()==0){
	    add(newVal);
	}
	while(*/
      


    // main method solely for testing purposes
    public static void main( String[] args ) {


	OrderedArrayList Franz = new OrderedArrayList();

	System.out.println("\nValues to add via addBinary() calls:");

	// testing linear search
	for( int i = 0; i < 15; i++ ) {
	    int valToAdd = (int)( 50 * Math.random() );
	    System.out.println( valToAdd );
	    Franz.addBinary( valToAdd );
	    System.out.println(Franz);
	}

	System.out.println("\nafter population via addLinear() calls:");
	System.out.println( Franz );
	System.out.println();

	 
    }
 
}//end class OrderedArrayList 
 
