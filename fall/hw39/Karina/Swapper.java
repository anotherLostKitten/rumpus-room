//Karaina Ionkina
//APCS1 period04
//HW #39 -- Put it together
//2016-12-04 

//----------------------------------------------------------------------------------
//An array 'o random 3/4 char strings is displayed to th' user. Th' user then enters th' locations 
//(sentence number 'n word number) and specifies  'o a pair words that will be switched. 
//It be then switched 'n displayed. Switch() switches by printin' 'n Switch2() 
//switches by modifyin' th' arrrrray... 
//-----------------------------------------------------------------------------------
import cs1.Keyboard;
public class Swapper{


    private static String karakters = "abcdefghijklmnopqrstuvwxyz";
    private static String Words[][] = populate();
    public static String genSentence(){
	String str = "";
	int a = 0;
	if (Math.random() < 0.5)
	    { for (int i = 0; i < 3; i++){
		    int b = (int)(Math.random()*26);
		    str += karakters.substring(b, b+1);}
	    }
	else { 
	    for (int i = 0; i< 4; i++){
		int b = (int)(Math.random()*26);
		str += karakters.substring(b, b+1);}
	}
	return str;
    }

    
    public static String[][] populate(){
	String[][] Words = new String[5 + (int)(Math.random() * 10)][3 + (int)(Math.random()* 5)];
	for (int s = 0; s < Words.length; s++){
	    for (int w = 0; w < Words[s].length; w++){
		Words[s][w] = genSentence();
	    }
	}
	return Words;
    }
		

 
    public static void print1(String[][] ar){
	String str = "";
	String retStr = "";
	for (int s = 0; s < ar.length; s++){
	    for (int x= 0; x < ar[s].length; x++){
		System.out.print(" " + ar[s][x]);
	}
	    System.out.println("\n");
	}
    }

    //===================="SWITCHING" JUST BY PRINTING======================
    //Prints arrays line by line but prints location of the other word 
    //when the iteration reaches a location that being switched -- doesn't
    //change the actual array.
   //========================================================================

    public static void Switch(int a1, int a2, int b1, int b2, String[][] ar){
	String newb = Words[a1][a2];
	String newa = Words[b1][b2];
	for (int i=0; i< ar.length; i++){
	    for (int x=0; x < ar[i].length; x++){
		if ( i== a1 && x==a2 || i==b1 && x==b2){
		    if (i == a1){
			System.out.print(" " + newa);
			x += 1;
		    }
		    else {
			System.out.print(" " + newb);
			x += 1;
		    }
		}
		System.out.print(" " + ar[i][x]);
	    }
	    System.out.println("\n");
	}
    }
   

   //================SWITCHING BY REARRAGING ACTUAL ARRAY=====================
   // Takes "row and column" of two words and switches them
  //===========================================================================
    public static void Switch2(int a1, int a2, int b1, int b2, String [][] ar){
	String olda = ar[a1][a2];
	String oldb = ar[b1][b2];
	ar[a1][a2] = oldb;
	ar[b1][b2] = olda;
	System.out.println("==============YER NEW TEXT==============");
	print1(ar);
    }
    
    //=============================MAIN METHOD===================================
    //Displays sentences and asks user to pick two locations (sentence# and word#
    //of two words. Then calls Switch function with user's answers parameters 
    //===========================================================================

    public static void main(String[] args){
	print1(Words);
   
	System.out.println("Would ye like to switch some words around? (Type yarr or no)");
	String answer = Keyboard.readWord();
	if (answer.equals("yarr")){
	    System.out.println("What be th' location 'o ye first word?");
	    System.out.println("Sentence number: (0, 1, 2, or 3)");
	    int a1 = Keyboard.readInt();
	    System.out.println("Word's location in the sentence?: (must be less than " + Words[a1].length +")");
	    int a2 = Keyboard.readInt(); 
	    System.out.println("And ye second word?");
	    System.out.println("Sentence number: ");
	    int b1 = Keyboard.readInt();
	    System.out.println("Word number: " + "must be less than " + Words[b1].length + ")");
	    int b2 = Keyboard.readInt();
	    System.out.println("switching " + Words[a1][a2] + " and " + Words[b1][b2] + "...");
	    System.out.println("SWITCHED!");
	    Switch2(a1, a2, b1, b2, Words);
	}
	else {
	    System.out.println("Yo-ho-ho! Then move along ye landlubber!");
	}
    }// ends main method
}//ends Swapper class
    
