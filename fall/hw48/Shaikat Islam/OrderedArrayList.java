// Shaikat Islam
// APCS1 pd04
// HW48 -- Halving the Halves
// 2016-12-19




/*============================================
   OrderedArrayList
  Wrapper class for ArrayList.
  Imposes the restriction that stored items 
  must remain sorted in ascending order

  Methods addLinear() and addBinary() return an 
  ArrayList of ascending elements, via linear 
  and binary search, respectively.
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

    //overloaded toString 
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


	// addLinear takes as input any comparable object 
	// (i.e., any object of a class implementing interface Comparable, i.e. Integers, Doubles, and even Strings (lexographically speaking)
	// inserts newVal at the appropriate index
	// maintains ascending order of elements
	// uses a linear search to find appropriate index

        public void addLinear( Comparable newVal ) {
	    int temp = size();

	    //searching through entire _data
	    for (int i = 0 ; i < size() ; i++){
		//if newVal is equal to or less than _data at indice i
		if ((newVal.compareTo(_data.get(i)) == 0) ||(newVal.compareTo(_data.get(i)) < 0)){ //you can reverse this to get descending order
		    temp = i;
		    i = size() + 1;
		}
	    }


	    //assuming size() is zero, add newVal to _data (accounts for empty ArrayList)
	    //if a value fails the conditional in the for statement, it is added to _data
	    _data.add(temp, newVal);
	}


    public void addBinary(Comparable newVal){
	int hi = (_data.size()-1);//num of meaningful elements minus one
	int lo = 0; //the first element of the arraylist
	while ( lo <= hi){ //while lo is less than or equal to hi
	    int mid = (int)(hi + lo)/2; //set the mid value to an int
	    int val = newVal.compareTo(_data.get(mid)); //use compareTo to get an integer val for comparison
	    if (val == 0){ //if this is true the method found the correct index to place the newVal
		_data.add(mid, newVal);
		return; //get out of the function because you're done
	    }
	    else if (val > 0){
		lo = mid + 1; //lo becomes the mid value plus one because the search space is now the upper half
		mid = (int)(lo + hi)/2; //have to redeclare the mid value
	    }
	    else if (val < 0){
		hi = mid - 1;//hi becomes the mid value minus one because the search space is now the lower half
		mid = (int)(lo + hi)/2; //have to redeclare the mid value
	    }
	}
	//only runs if the the while loop fails
	//also works as a way to solve the zero element ArrayList because the preceding code will fail, and executing this adds a value to the empty ArrayList anyway
	_data.add(lo, newVal);
    }

	
	      
    // main method solely for testing purposes
    //tests ints, doubles, and strings for both addLinear() and addBinary()
    public static void main( String[] args ) {
		//====================================================================================LINEAR SEARCH=======================================================================================================//


	OrderedArrayList Franz = new OrderedArrayList();

	System.out.println("\nValues to add via addLinear() calls:");

	// testing linear search
	for( int i = 0; i < 15; i++ ) {
	    int valToAdd = (int)( 50 * Math.random() );
	    System.out.println( valToAdd );
	    Franz.addLinear( valToAdd );
	}

	System.out.println("\nafter population via addLinear() calls:");
	System.out.println( Franz );
	//test to check if all the elements made it in
	System.out.println( Franz.size() );

	System.out.println();

	//this should also work with Strings and Doubles

	//Doubles
	OrderedArrayList Dumbledore = new OrderedArrayList();

	System.out.println("\nValues to add via addLinear() calls:");

	for( int i = 0; i < 15; i++ ) {
	    double valToAdd = ( 50 * Math.random() );
	    System.out.println( valToAdd );
	    Dumbledore.addLinear( valToAdd );
	}

	System.out.println("\nafter population via addLinear() calls:");
	System.out.println( Dumbledore );
	//test to check if all the elements made it in
	System.out.println( Dumbledore.size() );

	System.out.println();


	//and Strings (alphabetize!! :) )
       	OrderedArrayList Shakespeare = new OrderedArrayList();
	String[] characters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","!","@","#","$","%","^","&","*","(",")"};
       	System.out.println(characters.length);
	System.out.println("Random strings to add to an ArrayList via addLinear():" + "\n");
       	for( int i = 0; i < 15 ; i++ ) {
	    String valToAdd = characters[0 + (int)(Math.random() * ((35 - 0) + 1))] + characters[0 + (int)(Math.random() * ((35 - 0) + 1))] + characters[0 + (int)(Math.random() * ((35 - 0) + 1))] + characters[0 + (int)(Math.random() * ((35 - 0) + 1))];
	    System.out.println( valToAdd );
	    Shakespeare.addLinear(valToAdd);
	}
	System.out.println("\nafter population via addLinear() calls:");
	System.out.println( Shakespeare );
	//test to check if all the elements made it in
	System.out.println( Shakespeare.size() );

	System.out.println();
	//====================================================================================BINARY SEARCH=======================================================================================================//
	OrderedArrayList Twoface = new OrderedArrayList();
       	// testing binary search with ints
	for( int i = 0; i < 15; i++ ) {
	    int valToAdd = (int)( 50 * Math.random() );
	    System.out.println( valToAdd );
	    Twoface.addBinary( valToAdd );
	}

	System.out.println("\nafter population via addBinary() calls:");
	System.out.println( Twoface );
	//test to check if all the elements made it in
	System.out.println( Twoface.size() );

	System.out.println();

       	//this should also work with Strings and Doubles

	//Doubles via addBinary()
	OrderedArrayList LexLuthor = new OrderedArrayList();

	System.out.println("\nValues to add via addBinary() calls:");

	for( int i = 0; i < 15; i++ ) {
	    double valToAdd = ( 50 * Math.random() );
	    System.out.println( valToAdd );
	    LexLuthor.addBinary( valToAdd );
	}

	System.out.println("\nafter population via addBinary() calls:");
	System.out.println( LexLuthor );
	//test to check if all the elements made it in
	System.out.println( LexLuthor.size() );

	System.out.println();


	//and Strings via addBinary() (alphabetize!! :) )
       	OrderedArrayList theRiddler = new OrderedArrayList();
	String[] characters1 = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","!","@","#","$","%","^","&","*","(",")"};
       	System.out.println(characters1.length);
	System.out.println("Random strings to add to an ArrayList via addBinary():" + "\n");
       	for( int i = 0; i < 15 ; i++ ) {
	    String valToAdd = characters1[0 + (int)(Math.random() * ((35 - 0) + 1))] + characters[0 + (int)(Math.random() * ((35 - 0) + 1))] + characters[0 + (int)(Math.random() * ((35 - 0) + 1))] + characters[0 + (int)(Math.random() * ((35 - 0) + 1))];
	    System.out.println( valToAdd );
	    theRiddler.addBinary(valToAdd);
	}
	System.out.println("\nafter population via addBinary() calls:");
	System.out.println( theRiddler );
	//test to check if all the elements made it in
	System.out.println( theRiddler.size() );

	System.out.println();
	//add some words to theRiddler :
	String[]  words = {"endeavor", "incredulous", "indulgence", "entree", "extricate", "nonchalantly", "fervent", "foray", "chagrin", "inimitable", "audible", "antagonize", "esoteric", "abide", "avert", "mutual", "condescend", "tirade", "incorrigible", "catastrophe", "bolster", "lament", "palatable", "gargantuan", "lurch", "musty", "profess", "nostalgia", "pretentious", "insubordination", "aloof", "fumble", "ostensibly", "ambiguity", "glib", "oppression", "inevitable", "parched", "torrent", "perpetual", "inscribe", "ingenious", "coax", "harrowing", "cadence", "brackish", "coincide", "contraband", "inordinate", "dilapidated"};
	System.out.println("Words to add to the previous ArrayList of random strings:" + "\n");
	for (int y = 0; y < words.length; y++){
	    System.out.println(words[y]);
	    theRiddler.addBinary(words[y]);
	}
	System.out.println("\nafter population via addBinary() calls:");
	System.out.println(theRiddler);
	System.out.println(theRiddler.size());
    }//end main+

}//end class OrderedArrayList
 
