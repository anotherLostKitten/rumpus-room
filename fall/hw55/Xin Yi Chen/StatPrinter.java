//Xin Yi Chen
//APCS1 pd4
//HW55 -- His Toe Grammar
//2017-01-05

/***
    An AP-style question, for practice...

    Write the StatPrinter class below. The StatPrinter Object receives an
    ArrayList of nonnegative integers, then builds a frequency ArrayList where
    the index values are the data and the entry at the index is the frequency.
    For example, if the received data is : 2,3,2,5,1,3 then the frequency 
    list would be [0,1,2,2,0,1]. This is read as 0 zeroes, 1 one, 2 twos,
    2 threes, 0 fours, 1 five. The size of the frequency list is the equal to
    the maximum value of the data.

    A capability of the class is to calculate local modes from the frequency 
    list. A local mode is a value that is greater than the value at index - 1 
    and greater than the value at index + 1. A local mode is never at the end
    points of the list. For example if the frequency list is [1,2,1,4,2,3,5] 
    then the local modes are: 2 and 4.



    This class is also capable of printing a histogram of the frequencies, using
    ‘*’ to indicate a frequency amount. To print a histogram, the user specifies
    the longest sequence of ‘*’s used and then all other values are printed in 
    proportion to this value. For example, if longest bar is 10 and the frequency
    list is [1,2,1,4,2,3,5] then the histogram printed looks like this:

    0 : **
    1 : ****
    2 : **
    3 : ********
    4 : ****
    5 : ******
    6 : **********

    For each method, state the run time efficiencies using Big O notation.
    =======================================
    Tip:
    * Develop 1 fxn at a time, test it, then move to next.
    * Look over all, think a bit, decide which to tackle first.
    ( Simplest?  Prerequisite? . . . )
    * Coding today, what extra code do you need to get past Mr. Compiler?
    ***/

import java.util.ArrayList;

public class StatPrinter 
{

    // instance variable for frequencies of each integer in input ArrayList
    private ArrayList <Integer> _frequency;


    //*************** QUESTION 02 **************************
    //precond:  data.size() > 0, each entry b/t 0,100 inclusive
    //postcond: _frequency.size() set to max(data) + 1
    //          _frequency.get(i) returns frequency of i in data
    //eg, for data [2,3,2,5,2,3]
    //  _frequency would be [0,0,3,2,0,1]
    //O(n)
    public StatPrinter( ArrayList <Integer> data ) 
    {
	_frequency = new ArrayList <Integer> ();
	for (int i = 0; i < max(data)+1; i ++){
	    _frequency.add(0);
	}
	for (int x = 0; x < data.size(); x ++){
	    _frequency.set(data.get(x), _frequency.get(data.get(x)) +1);
	}
    }


    //*************** QUESTION 01 **************************
    //precond:  data.size() > 0
    //postcond: returns largest integer in data
    //O(n)
    public static Integer max( ArrayList <Integer> data ) 
    {
	int maxNum = 0;
	for (int i = 0; i < data.size(); i++){
	    if (data.get(i) > maxNum){
		maxNum = data.get(i);
	    }
	}
	return maxNum;
    }
 
    //*************** QUESTION 03 **************************
    //postcond: returns true if i > 0 and i < _frequency.size() - 1
    //          and _frequency.get( i - 1 ) < _frequency.get( i )
    //          and _frequency.get( i + 1 ) < _frequency.get( i )
    //          Otherwise, returns false
    //eg, for _frequency [1,2,1,5,5,8,2,4]
    //    2 and 8 are local modes, so
    //    isLocalMode(0) -> false
    //    isLocalMode(1) -> true
    //    isLocalMode(5) -> true
    // O(1)
    public boolean isLocalMode( int i ) 
    {
	boolean case1= i>0;
	boolean case2= i<_frequency.size()-1;
	if (case1 && case2){
	    boolean case3= _frequency.get(i-1) < _frequency.get(i);
	    boolean case4= _frequency.get(i+1) < _frequency.get(i);
	    if (case3 && case4){
		return true;
	    }
	}
	return false;
    }

    
    //*************** QUESTION 04 **************************
    //postcond: returns list of modes in _frequency
    public ArrayList <Integer> getLocalModes() 
    {
	ArrayList <Integer> modes = new ArrayList <Integer> ();
	for (int i = 0; i< _frequency.size(); i++){
	    if (isLocalMode(i)){
		modes.add(i);
	    }
	}
	return modes;
    }//O(?)
    //ans: linear O(n) because this method is dependable on the number of elements in the ArrayList _frequency
    

    //*************** QUESTION 05 **************************
    //precond:  longestBar > 0
    public void printHistogram( int longestBar ) 
    {
	//finds the largest mode 
	int mode = 0;
	for(int i = 0; i < _frequency.size(); i++){
	    if (_frequency.get(i) > mode){
		mode = _frequency.get(i);
	    }
	}
	
	int multiple = longestBar/mode;
	
	String printStr = "";
	for (int x = 0; x < _frequency.size(); x++){
	    printStr +=  x+": ";
	    printStr += getStars((_frequency.get(x))*multiple) +"\n";
	}
	System.out.println(printStr);
    }//O(?)
    //ans: quadratic O(n^2) because the dominate operation in this method is the second loop, which is O(n^2). The first loop is O(n), and the second loop is O(n^2) because there is a loop inside a loop. 

    
    //returns i amount of stars in a string
    //O(n)
    public String getStars(int i)
    {
	String retStr ="";
	for (int x = 0; x < i; x++){
	    retStr += "*";
	}
	return retStr;
    }
    
    public static void main(String[] args)
    {
	ArrayList glen = new ArrayList<Integer>();
        glen.add(2);
	glen.add(3);
	glen.add(1);
	glen.add(3);
	glen.add(5);
	glen.add(6);
	glen.add(1);
        System.out.println(glen);
	System.out.println(max(glen)); //6
	
	StatPrinter coco = new StatPrinter(glen);
	System.out.println(coco._frequency); //[0,2,1,2,0,1,1]
	System.out.println(coco.isLocalMode(0));//false
	System.out.println(coco.isLocalMode(1));//true
	System.out.println(coco.isLocalMode(2));//false
	System.out.println(coco.isLocalMode(3));//true
	System.out.println(coco.getLocalModes()); //[1,3]
        coco.printHistogram(6);
	/*[0:
	  1: ******
	  2: ***
	  3: ******
	  4:
	  5: ***
	  6: ***
	*/

    }
 
}//end class StatPrinter
