/*************
 * Adris Jautakas
 * APCS pd1
 * HW #45: Al<B> Sorted!. 
 * 2016-12-14
 ************/

import java.util.ArrayList;
import java.lang.IndexOutOfBoundsException;
import java.lang.IllegalArgumentException;
public class ALTester {

    // Populates an inputted arr with 23 random integers between 0 and 9
    public static void populateIntRandom(ArrayList<Integer> arr) {
        for(int i = 0; i < 23; i++) {
            arr.add((int) (Math.random() * 10));
        }
    }

    // Populates an inputted arr with a list of integers linearly from 1 to 23
    public static void populateIntLinear(ArrayList<Integer> arr) {
        for(int i = 0; i < 23; i++) {
            arr.add(i);
        }
    }

    public static boolean isSorted(ArrayList<?> arr) {
        if (arr.size() < 1) 
            throw new IndexOutOfBoundsException();
        if (! (arr.get(0) instanceof Comparable)) 
	    throw new IllegalArgumentException("ArrayList does not have Comparable objects!");
        Comparable lastObj = null;
        for(Object obj : arr) {
            Comparable current = (Comparable) obj;
            if (lastObj != null && current.compareTo(lastObj) == -1) return false;
            lastObj = current;
        }
        return true;
    }

    private static String testPrint(ArrayList<?> arr) {
        String result = "";
        result += "{";
        for(int i = 0; i < arr.size(); i++) {
            result += arr.get(i);
            if (i != arr.size() - 1)
                result += ",";
            else
                result += "}";
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("Hello there! \n\n");
	ArrayList<Integer> arr = new ArrayList<Integer>();
        populateIntRandom(arr);
        System.out.println("Populated Random ArrayList: \n" + testPrint(arr));
        System.out.println("Is it sorted? " + isSorted(arr));
        
        System.out.println("\n\n");
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        populateIntLinear(arr2);
        System.out.println("Populated Linear ArrayList: \n" + testPrint(arr2));
        System.out.println("Is it sorted? " + isSorted(arr2));
    }
}
