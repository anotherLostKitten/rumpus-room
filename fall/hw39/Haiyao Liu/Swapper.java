//Haiyao Liu
//APCS1 pd3
//HW39 -- Put it together;
//2016-12-5

import cs1.Keyboard; 
import static java.lang.Math.*;

/*

methods used:

fill( none ):                            fills the string[][] strs with "unique 3- or 4-character Strings"
swap( none ):                            checks if the user wants to continue swapping by reading stdin with Keyboard
print( none ):                           foreach print of strs[][]
print( string ):                         contraction of System.out.print(string)

getInt( prompt message, maximum val ):   prints prompt, then reads stdin with Keyboard to get an int until 0 < int < max

swap( row1, col1, row2, col2 ):          swaps (r2,c1) and (r2,c2) in strs[][]
print( row1, col1, row2, col2 ):         prints strs[][] with starred (r2,c1) and (r2,c2)

general summary/trace

1 - strs[][] filled with fill(), a string at [i][j] being the ith and jth letter of the alphabet and either '3' or '-4'
2 - simple print() of the array for user to see
3 - ask whether user wants to swap with swap(), continue if y, quit if n (not y)
4 - takes the coords of the points to be swapped (doesn't end until numbers are legal)
5 - swaps the coords, *print() the array to mark swapped points
6 - repeat 3 to 5

*/

public class Swapper {
    private static String chars = "abcdefghijklmnopqrstuvwxyz";
    private static String[][] strs;

    public static String[][] fill(String c) {
	String[][] strs = new String[(int)(random()*26)+1][(int)(random()*26)+1];
	for(int i = 0; i < strs.length; i++) {
	    for(int j = 0; j < strs[i].length; j++) {
		strs[i][j] = c.substring(i,i+1) + c.substring(j,j+1) + ((int)(random()*2) > 0 ? "-4" : "3");
	    }
	}
	return strs;
    }

    public static int getInt(String m, int max) {
	print(m);
	int in = Keyboard.readInt();
	if(in == Integer.MIN_VALUE || in >= max || in < 0) {
	    print("\nTry again" + (in >= max ? ", integer out of range" : "")  + ":\n");
	    return getInt(m,max);
	}
	return in;
    }

    public static boolean swap() {
	    print("====================\nSwap values? y/n: ");
	    return Keyboard.readString().equals("y") ? true : false;
    }

    public static void print() {
	for(String[] i : strs) {
	    for(String j : i) {
		print(j + "\t");
	    }
	    print("\n");
	}
    }

    public static void print(int x1, int y1, int x2, int y2) {
	for(int i = 0; i < strs.length; i++) {
	    for(int j = 0; j < strs[i].length; j++) {
		print( (((i == x1 && j == y1) || (i == x2 && j == y2)) ? "*  " : "") + strs[i][j] + "\t");
	    }
	    print("\n");
	}
    }

    public static void print(String s) {
	System.out.print(s);
    }

    public static void swap(int x1,int y1,int x2,int y2) {
	String temp = strs[x1][y1];
	strs[x1][y1] = strs[x2][y2];
	strs[x2][y2] = temp;
    }

    public static void main(String[] args) {
	strs = fill(chars);
	print();
	while(swap()) {

	    print("Select two points to swap, (row1,col1) and (row2,col2) in a " + strs.length  + " by " + strs[0].length + "array \n");
	    	
	    int x1 = getInt("row1 = ",strs.length);
	    int y1 = getInt("col1 = ",strs[0].length);
	    int x2 = getInt("row2 = ",strs.length);
	    int y2 = getInt("col2 = ",strs[0].length);
	    
	    print("==========================================================\n");	    
	    print("Swapping (" + x1 + "," + y1 + ") and (" + x2 + "," + y2 + ")\n");
	    print("New array with swapped points marked:\n");
	    swap(x1,y1,x2,y2);
	    print(x1,y1,x2,y2);
	}
    }
}
