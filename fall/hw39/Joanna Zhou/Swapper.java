//Joanna Zhou
//APCS1 pd5
//HW39 -- Put it together
//2016-12-03

/* This will be able to make an array of random Strings, display it,and 
   allow the user to swap at chosen locations, as prompted by the terminal*/

import cs1.Keyboard;

public class Swapper {
    
    //This method will return a random string of 3 or 4 letters
    //Takes nothing
    //Returns a string
    public static String randString(){
	String[] alpha = {"a","b","c","d","e","f","g","h","i","j","k","l","m",
			  "n","o","p","q","r","s","t","u","v","w","x","y","z"};
	String retStr = "";
	retStr = alpha[(int) (Math.random() * 26)]
	    + alpha[(int) (Math.random() * 26)]
	    + alpha[(int) (Math.random() * 26)];
	if (Math.random() >= 0.5) {
	    retStr += alpha[(int) (Math.random() * 26)];
	}
	return retStr;
    }

    //This makes a random array of arrays of Strings
    //Also takes nothing
    //Returns an array with arrays of randomly made Strings. Max size: 5 x 5.
    public static String[][] maker() {
	int rowNum = (int) (Math.random() * 5) + 1;
	int colNum = (int) (Math.random() * 5) + 1;
	String[][] retArr = new String[rowNum][colNum];
	for (int x = 0; x < rowNum; x +=1) {
	    for (int y = 0; y < colNum; y += 1){
		retArr[x][y] = randString();
	    }
	}
	return retArr;
    }

    //Displays an array of arrays.
    //Takes an array
    //Returns a string
    public static String display(String[][] arr) {
	String bwop = "";
	for (int init = 0; init < arr[0].length; init += 1) {
	    bwop += "\t" + init;
	}
	bwop += "\n";
	for (int x = 0; x < arr.length; x += 1) {
	    bwop += x + "\t";
	    for (int y = 0; y < arr[x].length; y += 1) {
		bwop += arr[x][y] + "\t";
	    }
	    bwop += "\n";
	}
	return bwop;
    }

    //Swappy! Swap swap swap. Uses Keyboard.readInt()
    //Takes an array.
    //Returns nothing
    public static void swappy(String[][] arr){
	int rowNum = 0;
	int colNum = 0;
	int rowNum2 = 0;
	int colNum2 = 0;
	String hold = "";
	/*rowNum = Integer.parseInt(formatted.substring(1,
					      formatted.indexOf(",")));
	formatted = formatted.substring(formatted.indexOf(",") + 1);
	colNum = Integer.parseInt(formatted.substring(0,
					      formatted.indexOf(")")));
	formatted = formatted.substring(formatted.indexOf("(") + 1);
	rowNum2 = Integer.parseInt(formatted.substring(0,
					       formatted.indexOf(",")));
	formatted = formatted.substring(formatted.indexOf(",") + 1);
	colNum2 = Integer.parseInt(formatted.substring(0,
	formatted.indexOf(")")));*/ // Test code
	rowNum = Keyboard.readInt();
	colNum = Keyboard.readInt();
	rowNum2 = Keyboard.readInt();
	colNum2 = Keyboard.readInt();
	hold = arr[rowNum][colNum];
	arr[rowNum][colNum] = arr[rowNum2][colNum2];
	arr[rowNum2][colNum2] = hold;
    }

    public static void main(String[] args){
	String[][] windowPiece = maker();
	System.out.println(display(windowPiece));
	System.out.println("Want to swap?" + "\n" +
			   "Type in the row of the first thing you want to swap"
			   + ",\n then its column,\n then the row of the next"
			   + ",\n and the column of that."
			   + "\n" + "And remember, hit enter after each input");
	/*swappy(windowPiece, "(1,1),(0,0)"); //test code
	System.out.println(display(windowPiece));*/
	while (true) {
	swappy(windowPiece); //test code
	System.out.println(display(windowPiece));
	}
    }
}
