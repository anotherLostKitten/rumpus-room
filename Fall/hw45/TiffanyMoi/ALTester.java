//Tiffany Moi
//APCS1 pd 5
//HW45 -- Al<B> Sorted!
//2016-12--13
import java.util.ArrayList;

public class ALTester{
    public static boolean sorted(ArrayList<Integer> arr){
	for (int i = 0; i + 1 < arr.size(); i+=1){
	    if (arr.get(i) > arr.get(i+1)){
		return false;
	    }
	}
	return true;
    }
    public static void main(String[] args){
	ArrayList<Integer> a = new ArrayList<Integer>();
	for (int x = 0; x < 23; x+=1){
	    a.add(x);
	}
	System.out.println(a);
	System.out.println(sorted(a));
	ArrayList<Integer> b = new ArrayList<Integer>();
	for (int x = 0; x < 23; x+=1){
	    b.add((int)(Math.random()*100));
	}
        System.out.println(b);
	System.out.println(sorted(b));	
    }
	
}
