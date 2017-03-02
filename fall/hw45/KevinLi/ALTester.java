//Kevin Li
//APCS1 pd3
//HW45 --  Al<B> Sorted!.
//2016-12-13

import java.util.ArrayList;
public class ALTester{
    
    public static boolean sorted(ArrayList<Integer> x){
	boolean retVal = true;
	for (int i = 0; i < x.size() - 1; i ++){
	    retVal = (x.get(i) <= x.get(i + 1));
	    if (retVal == false){
		return retVal;
	    }
	}
	return retVal;
    }
    public static void main(String[] args){
	ArrayList<Integer> test = new ArrayList<Integer>();
 
	for (int i = 0; i < 23; i ++){
	    test.add(i);
	}

	System.out.println(sorted(test));

	ArrayList<Integer> test1 = new ArrayList<Integer>();

	for (int i = 22; i > -1; i --){
	    test1.add(i);
	}
	System.out.println(sorted(test1));
	
    }
    
} 
    
