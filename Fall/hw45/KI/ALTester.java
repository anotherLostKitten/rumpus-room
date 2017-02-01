/*Karina Ionkina
APCS Peiod04
HW 45--Al<B> Sorted! 
2016-12-14 */
import java.util.ArrayList;

public class ALTester<T>{

    //------------------------------------------------------------------
    //ALTester populates ArrayList with 23 integers
    //Tests whether the ArrayList is sorted or not (in ascending order)
    //------------------------------------------------------------------

    public static void main(String[] args){
	//new ArrayList tom, generically typed to Integer.
	ArrayList<Integer> tom = new ArrayList<Integer>();
	
	//tom is populated through add from ArrayList
        for (int i=0; i<23; i++)
	  tom.add(i); 
	System.out.println(tom);
	//[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22]

	//parses through tom and checks to see if index is greater than the next one
	//prints out "not sorted" if it is larger and breaks
	//prints out "sorted!!" otherwise
	for (int i = 0; i < tom.size() - 1; i+=1){  
	    if (tom.get(i) > tom.get(i + 1)) { System.out.println("not sorted!!"); break; }
	    System.out.println("sorted!!"); break;
	}
    }
}

	
