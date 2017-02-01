//Dawei Huang
//Due: 12/05/2016
//Period 4 APCS w/ Mr. Brown Mykolyk
//HW #39 -- Put it together

/**
	This program allows to generate a String array of length ten with each slot containing a random
	String of either length 3 or length 4 and then prompts the user to change the contents of the array
	at two slot locations. After the String array is generated, each slot will be printed in the terminal 
	as strings seperated by an indent to represent the contents of the array. The program will prompt the 
	user to enter in the first location and then the second location of the swtich. The prompt will only
	accept a one character string containing a number from a 0 to 9 range for both locations since the
	array has only length 10. For all other inputs, the program will terminate immediately and request the
	user to rerun the program in order to re-input acceptable values. If the program were to run smoothly
	given that the inputs are correct, the program would switch the array content at those two locations
	and print out the new String array.
**/

import cs1.Keyboard;
import java.io.*;
import java.util.*;

public class Swapper{
	//static class variables
	static String[] arr = new String[10];
	static int location1 = 0;
	static int location2 = 0;
	
	//main method that is run in the terminal.
	public static void main(String[] args){
		System.out.println("Welcome the game Swapper");
		System.out.println("Instructions: Enter the number into specified location between 0 and 9");
		System.out.println("The items in the specified locations will be swapped");
		popStrArray();
		System.out.println("\nHere is your randomly generated array: ");
		arrPrint();
		
		//location 1
		System.out.println("\n\nEnter Location1:");
		try {
			location1 = Integer.parseInt(cs1.Keyboard.readWord());
		}
		catch (Exception e) {
			System.out.println("You had entered an invalid location so the program has been terminated. Please try again.");
			System.exit(0);
		}
		if (location1 > 9 || location1 < 0){
			System.out.println("You had entered an invalid location so the program has been terminated. Please try again.");
			System.exit(0);
		}
		
		//location 2
		System.out.println("\n\nEnter Location2:");
		try {
			location2 = Integer.parseInt( cs1.Keyboard.readWord() );
		}
		catch (Exception e) {
			System.out.println("You had entered an invalid location so the program has been terminated. Please try again.");
			System.exit(0);
		}
		if (location2 > 9 || location2 < 0){
			System.out.println("You had entered an invalid location so the program has been terminated. Please try again.");
			System.exit(0);
		}
		
		posSwap(location1, location2);
		System.out.println("\nHere is your new string array:");
		arrPrint();
	}
		
	//populates the stringArray with random Strings of either length 3 or length 4
	public static void popStrArray(){
		for (int i = 0; i < arr.length; i += 1){
			arr[i] = randomStrGen();
		}
	}
	
	//generates a random String of either length 3 or length 4
	//50% possibility String is of length 3
	//50% possibility String is of length 4
	public static String randomStrGen(){
		String strLine = "";
		int repetitions = (int)(Math.random() * 2) + 3;
		while (repetitions > 0){
			strLine += ((char)((Math.random() * 26) + 65));
			repetitions -= 1;
		}
		return strLine;
	}
	
	//acceses the String array and swaps the contents of the array at the two specified locations.
	public static void posSwap(int a, int b){
		String location1Data = arr[a];
		String location2Data = arr[b];
		arr[a] = location2Data;
		arr[b] = location1Data;
	}
	
	//prints the contents of the String array as Strings of each slot seperated by an indent
	public static void arrPrint(){
		String printStr = "";
		for(String x : arr){
			printStr += x + "\t";
		}
		System.out.print(printStr);
	}
}