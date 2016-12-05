//Shaikat Islam
//APCS1 pd04
//HW39 -- Put It Together
//2016-12-02


//*********************************************************************************************************************************************************************************************************
// This program uses a random string generator that I made using the StringBuilder object, just to be thorough. You can even set the length of the random strings.
//
// It uses  a 2D populateArr method based on the one that we were supposed to make when Mr. Brown was out and gave us classwork. It populates an array with random strings from method RandomString.
//
// Also uses print1, a method created in HW38, to print the 2D Array.
//
// The actual swapping occurs in the main method of the function. Using the library cs1.Keyboard (and it's .readInt() and .readBoolean() methods), the main method makes a copy of the strings from
// the users determined array. The user inputs four integers to represent the locations of the two strings they want to swap. The main method copies those strings into vars swapString1 and swapString2
// and the string at the first defined location becomes swapString2, and the string at the second location becomes swapString1.
//
//The swapping is simple.
//
//Also added a lot of extras for robustification and aesthetic purposes. In the main method, there are try and catch blocks that pauses the thread in terminal. It's neat.
//*********************************************************************************************************************************************************************************************************


//packages I used
import cs1.Keyboard;
import java.io.*; //for the error handling for the thread sleep in the main method. (aesthetic purposes)

public class Swapper{

    //random string generator with range of length from min to max (this can be very useful!)
    //used Stringbuilder objects
    public static String RandomString(int min, int max){ //string of this range for the purpose of this program. you'd basically input 3 and 4.
	String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890~!@#$%^&*()-=_+,./;\'\"{}:<>?";
	StringBuilder sb = new StringBuilder(min + (int)(Math.random() * ((max - min) + 1)));
	for (int x = 0; x < min + (int)(Math.random() * ((max - min) + 1)); x++){
	    int randomRangeS = 0 + (int)(Math.random() * ((88 - 0) + 1)); //random num based on length of the string s
	    sb.append(s.charAt(randomRangeS)); //since I use the charAt method, the line above has to account for the indices of the master string s. The actual length is 89.
	}
	String sp = sb.toString();
	return sp;
        //System.out.println(sp);
    }
	

    //populate array of whatever dimensions with a random string of lengths 3 to 4
    //using a for loop
    public static String[][] populateArr(int r, int c){
	String[][] sArr = new String[r][c]; //instantiate the 2d array
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                sArr[i][j]=RandomString(3,4);//just change this for different string lengths
            }
        }
        return sArr;
    }//end populateArr


    // slightly modified print1 method from the hw. the modification is in the parameter; change it from Int[][] to String[][]
        public static void print1( String[][] a ){
	for (int r = 0; r < a.length; r++){
	    String s = "{ "; //imp. for this to exist in the for loop or else you'd get repetitive addition of rows in each string
	    for (int c = 0; c < a[r].length; c++){ // not a[0].length, or else this code would not work for jagged arrays. Use r.
		s+= a[r][c];
		if (c != (a[r].length - 1)){ //conditional for adding commas
		    s+= ", ";
		}
	    }
	    s += " }";
	    System.out.println(s);
	    System.out.print("\n");
	}
	}

	
       		
    //where the swapping actually happens
    //made it robust
    public static void main(String [] args){
	
	//choosing the specifications of the array
	System.out.println("Please specify the number of rows you would like in your ideal array. You may choose any integer on the interval (0, infinity +).Try not to break your terminal, though.");
	int rowChoose = Keyboard.readInt();
	
	System.out.println("Please specify the number of columns you would like in the same ideal array. You may choose any integer on the interval (0, infinity +). Again, don't break your terminal");
	int columnChoose = Keyboard.readInt();
	System.out.println("Thank you. Here is the array you have chosen, populated with random strings. Every row is on a newline.");
	
	String [][] theArraytheUserHasCreated = populateArr(rowChoose, columnChoose);
	System.out.println("{ ");//this is because my print1 function, that prints out rows, does not have the initial curly brace
	print1(theArraytheUserHasCreated);
       	System.out.println(" }");
	
	//choosing the first string to swap
	System.out.println("The function of this program is to swap a random string in the determined array with another string in the same array. Please choose the row of the desired string to be swapped. It must be an integer less than or equal to " + (rowChoose - 1)  + ". It can't be less than zero either.");
	int rowSwap1 = Keyboard.readInt();	
	if (rowSwap1 > (rowChoose - 1) || rowSwap1 < 0){//if they make a mistake 
	    System.out.println("One like = one prayer.");//xD
	    System.exit(0);
	}
	
	System.out.println("Please choose the column of the desired string to be swapped. It can't be less than zero or greater than " + (columnChoose - 1) + ".");
       	int columnSwap1 = Keyboard.readInt();	
	//if statement for the user's second error
	if (columnSwap1  > (columnChoose - 1) || columnSwap1 < 0){
	    System.out.println("Honestly.");
	    System.exit(0);
	}
	
	//just confirming with the user
	System.out.println("Ok. You've made it this far. It seems that the string that you want to swap is:");
	String word1 = "\"" + theArraytheUserHasCreated[rowSwap1][columnSwap1] + "\"";
	System.out.println(word1);	
	System.out.println("Is this correct? True/False:");
	boolean checkfortf = Keyboard.readBoolean();
	if (checkfortf){
	    System.out.println( "Now you will have to choose the second string to swap with " + word1 + ".");
	}
	else{
	    System.out.println("Try again!");
	}
	
	//choosing the second string to swap
        System.out.println("Please choose the row of the second string that you want to swap. It can't be less than zero or greater than " + (rowChoose - 1) + ".");
	int rowSwap2 = Keyboard.readInt();
	//if statement for the user's error
	if (rowSwap2 > (rowChoose - 1) || rowSwap2 < 0){
	    System.out.println("wE WaRnEd Youuu....");
	    System.exit(0);
	}
	System.out.println("Please choose the column of the second string that you want to swap. It can't be less than zero or greater than " + (columnChoose - 1) + ".");
	int columnSwap2 = Keyboard.readInt();
       	if (columnSwap2 > (columnChoose - 1) || columnSwap2 < 0){
	    System.out.println("You made a mistake!");
	    System.exit(0);
	}
	
	//confirming with the user again
	System.out.println("Ok. You've made it this far, again. It seems that the second string that you want to swap is:");
	String word2 = "\"" + theArraytheUserHasCreated[rowSwap2][columnSwap2] + "\"";
	System.out.println(word2);	
	System.out.println("Is this correct? True/False:");
	boolean checkfortf2 = Keyboard.readBoolean();
	if (checkfortf2){
	    System.out.println("Here is the same array, with strings " + word1 + " and " + word2 + " swapped." );
	}
	else{
	    System.out.println("Try again!");
	}

	//the actual swap, using temporary string variables
	String swapString1 = theArraytheUserHasCreated[rowSwap1][columnSwap1];
	String swapString2 = theArraytheUserHasCreated[rowSwap2][columnSwap2];
	theArraytheUserHasCreated[rowSwap1][columnSwap1] = swapString2;
	theArraytheUserHasCreated[rowSwap2][columnSwap2] = swapString1;

	//the aesthetic wait ...(this is totally unnecessary for the function of the program, but I wanted to have fun
	System.out.print("Calculating");
	try{
	    Thread.sleep(1000);
	}
	catch(InterruptedException ex)
	    {
	    }
	System.out.print(" .");
       	try{
	    Thread.sleep(1000);
	}
	catch(InterruptedException ex)
	    {
	    }
	System.out.print(" .");
      	try{
	    Thread.sleep(1000);
	}
	catch(InterruptedException ex)
	    {
	    }
	System.out.print(" .");
  	try{
	    Thread.sleep(1000);
	}
	catch(InterruptedException ex)
	    {
	    }
	System.out.print(" .");
	      	try{
	    Thread.sleep(1000);
	}
	catch(InterruptedException ex)
	    {
	    }
	System.out.print(" .");
  	try{
	    Thread.sleep(1000);
	}
	catch(InterruptedException ex)
	    {
	    }
	System.out.print(" .");


	//and finally returning the array
	System.out.println("{ ");
	print1(theArraytheUserHasCreated);
	System.out.println("} ");
       	System.out.println(" Done!");


    }//end main
   
}//end Swapper
    
