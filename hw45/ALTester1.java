//Michael Ruvinshteyn
//APCS1 pd 1
//HW 45 -- Sorted
//2016 - 12 - 13

import java.util.ArrayList;

public class ALTester1{

    private ArrayList<Integer> _data = new ArrayList<Integer>();

    public String toString(){ 
        String res = "[" + _data.get(0); //To allow easy insertion of commas, the first value is already included
	for (int x = 1; x < 23; x += 1){ //Starts from the second value of the array if there is one
	    res += "," + _data.get(x);
	}
	res += "]";
	return res;
    }
    
    public void populate(){ //Populates the ArrayList with 23 random Integers
	int x = 0;
	while (x < 23){
	    _data.add((int)(Math.random() * 10));
	    x += 1;
	}
    }

    public boolean checkSort(){ //Returns whether the ArrayList is sorted or not
	int current = 1;
	int previous = 0;
	while (current < 23){
	    if (_data.get(current) < _data.get(previous)){
		System.out.println("Unsorted between positions " + previous + " and " + current + "."); //Prints where the disorder is found
		return false; //Will break the loop if disorder is found
	    }
	    current += 1;
	    previous += 1;
	}
	return true; //Returns true if no disorder was found
    }

    public static void main(String[] args){
	ALTester1 curtis = new ALTester1();

	curtis.populate();
	System.out.println("Printing curtis... ");
	System.out.println(curtis);
	System.out.println();

	if (curtis.checkSort()){
	    System.out.println("This ArrayList is sorted.");
	}
    }
}
