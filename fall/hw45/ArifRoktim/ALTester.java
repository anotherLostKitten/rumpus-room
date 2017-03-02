//Arif Roktim
//APCS1 pd4
//HW45 -- Al<B> Sorted!
//2016-12-14

import java.util.ArrayList;
public class ALTester{
    
    //Returns true if ArrayList of Integers is sorted in ascending order
    public static boolean isAscending( ArrayList<Integer> a ){
        Integer x, y;
        for( int i = 1; i < a.size(); i++ ){ 
            x = a.get(i);
            y = a.get(i - 1);
            if ( x.compareTo(y) < 0 ){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
	    
        ArrayList<Integer> bob = new ArrayList();

        for( int i = 0; i <= 23; i++ ){
            bob.add( i );
        }
        System.out.println( isAscending(bob) ); //true

        for( int i = 0; i <= 23; i++){
            bob.set( i, -1 * i );
        }
        System.out.println( isAscending(bob) ); //false
        
        
    }
}
