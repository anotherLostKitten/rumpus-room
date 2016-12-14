//Nikita Borisov
//APCS1 pd01
//HW #45: Al<B> Sorted!
//due: 2016-12-14
import java.util.ArrayList;
public class ALTester{
    public static void main(String[] args){
    //creating/ testing random ArrayList
	ArrayList<Integer> blarg = new ArrayList<Integer>();
	for(int i = 0; i < 23; i += 1){
	    blarg.add((int)(Math.random()*50));
	}
	System.out.println(blarg);
	System.out.println(sortedQ(blarg)); //false
	//creating/ testing ordered ArrayList
	ArrayList<Integer> clarg = new ArrayList<Integer>();
	for(int i = 0; i < 23; i += 1){
	    clarg.add(i);
	}
	System.out.println(clarg);
	System.out.println(sortedQ(clarg)); //true
    }
    //sortedQ checks if an ArrayList<Integer> is sorted
    public static boolean sortedQ(ArrayList<Integer> ali){
	for(int i = 0; i < ali.size() - 1; i += 1){
	    if(ali.get(i) > ali.get(i+1)){
		return false;
	    }
	}
	return true;
    }

}
