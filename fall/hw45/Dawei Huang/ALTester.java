//Dawei Huang
//APCS1 pd4
//HW45 --  Al<B> Sorted!. 
//2016-14-12

import java.util.ArrayList;

public class ALTester <T> extends ArrayList{
    public static void main(String[] args){
	// Test 1
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		for (int i = 0; i <= 23; i++){
			arr1.add(i);
		}
		System.out.println(testSorted(arr1));
		
	// Test 2
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		for (int i = 0; i <= 23; i++){
			arr2.add(23 - i);
		}
		System.out.println(testSorted(arr2));
    }
	
    public static boolean testSorted(ArrayList<Integer> arr){
	for(int i = 0; i < 22; i++){
	    if (arr.get(i) != arr.get(i+1) - 1){
			return false;
	    } 
	}
	return true;
    }
	
	// public String toString(){
		
	// }
}
