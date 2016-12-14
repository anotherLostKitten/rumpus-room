// Marcus Ng
// APCS1 pd4
// HW #45: Al<B> Sorted!
// 2016-12-13

import java.util.ArrayList;

public class ALTester {

    // Populate ArrayList ascending
    public static void populate(ArrayList<Integer> a) {
	// Add 23 elements
	for (int i = 0; i < 23; i += 1) {
	    a.add(i);
	}
    }
    
    // Checks if array is in ascending order by comparing values at adjacent indexes - return true if acsending, false otherwise
    public static boolean sorted(ArrayList<Integer> a) {
	for (int i = 1; i < a.size(); i += 1) {
	    if (a.get(i - 1) > a.get(i)) {
		return false;	
	    }
	}
	return true;
	
    }
    
    public static void main(String[] args) {

	ArrayList<Integer> objArray = new ArrayList<Integer>();
	populate(objArray);
	System.out.println(sorted(objArray)); // true
	System.out.println(objArray); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22]

	objArray.set(4,200);
	System.out.println(sorted(objArray)); // false
	System.out.println(objArray); // [0, 1, 2, 3, 200, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22]
	
	objArray.set(4,0);
	System.out.println(sorted(objArray)); // false
	System.out.println(objArray); // [0, 1, 2, 3, 0, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22]
	
    }
    
}
