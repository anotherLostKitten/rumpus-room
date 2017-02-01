/*======================================
  class BubbleSort -- implements bubblesort algorithm (EXIT EARLY version)

                      ..------..                          
               /~~-.-~__-'`-__  ~-.  .-~-.                
              |   /~~~\     / ~~---\|     |               
              |  ||| * |   | | |  * |     |               
              /_-|\ \ /     \ \ \__.|\.  |                
              ~   \~~   |_|   ~~~~ /   ~-.\               
                   ~-.._      _.-~~                       
                     .--~~~~~~--.                         
                    |  |______|  |                        
                     ~-|______|-~                         
                       |      |                           
                       |______|                           
                       |  |   |                           
                       |__|___|                           
                       |_|| _||                        
                       `--'`--'                           
		       ======================================*/

import java.util.ArrayList;

public class BubbleSort 
{

    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	int randomIndex;
	//setup for traversal fr right to left
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSortV( ArrayList<Comparable> data ) 
    {
	boolean swapUsed = true; //default so it would at least pass through once to check sortedness

	while (swapUsed == true) {
    
	    swapUsed = false;//has this "pass" swapped any elements? (at this point, the answer is no)
	        
	    //the following is essentially one "pass":
	    for (int slot = 1; slot < data.size(); slot += 1) {
		int check = data.get(slot).compareTo(data.get(slot - 1)); //compare me to whoever's behind me 
		if (check < 0) { //if im less than them (oof), swap us
		    Comparable currVal = data.get(slot);
		    Comparable behindVal = data.get(slot - 1);
		    data.set(slot, behindVal);
		    data.set(slot - 1, currVal);
		    swapUsed = true;
		}
	    }
	}

    }//end bubbleSortV


    // ArrayList-returning bubbleSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input ) 
    {
	ArrayList<Comparable> sortedCopy = input;
	bubbleSortV(sortedCopy);
	return sortedCopy;
	
    }//end bubbleSort


    public static void main(String [] args)
    {
	/*===============for VOID methods=============
	         
	      ArrayList glen = new ArrayList<Integer>();
	            glen.add(7);
		            glen.add(1);
			      glen.add(5);
			          glen.add(12);
				        glen.add(3);
					        System.out.println( "ArrayList glen before sorting:\n" + glen );

						  bubbleSortV(glen);
						      System.out.println( "ArrayList glen after sorting:\n" + glen );

						            ArrayList coco = populate( 10, 1, 1000 );
							            System.out.println( "ArrayList coco before sorting:\n" + coco );
								      bubbleSortV(coco);
								          System.out.println( "ArrayList coco after sorting:\n" + coco );
									    
									  ============================================*/
	/*==========for AL-returning methods==========
	  
	      ArrayList glen = new ArrayList<Integer>();
	            glen.add(7);
		            glen.add(1);
			      glen.add(5);
			          glen.add(12);
				        glen.add(3);
					        System.out.println( "ArrayList glen before sorting:\n" + glen );

						ArrayList glenSorted = bubbleSort( glen );
						    System.out.println( "sorted version of ArrayList glen:\n" 
						          + glenSorted );
							          System.out.println( "ArrayList glen after sorting:\n" + glen );

								    ArrayList coco = populate( 10, 1, 1000 );
								        System.out.println( "ArrayList coco before sorting:\n" + coco );
									      ArrayList cocoSorted = bubbleSort( coco );
									              System.out.println( "sorted version of ArrayList coco:\n" 
										        + cocoSorted );
											    System.out.println( "ArrayList coco after sorting:\n" + coco );
											          System.out.println( coco );

												    
												  ============================================*/

    }//end main

}//end class BubbleSort



/***
Bulbasaur by Maija Haavisto
                                           /
                        _,.------....___,.' ',.-.
                     ,-'          _,.--"        |
                   ,'         _.-'              .
                  /   ,     ,'                   `
                 .   /     /                     ``.
                 |  |     .                       \.\
       ____      |___._.  |       __               \ `.
     .'    `---""       ``"-.--"'`  \               .  \
    .  ,            __               `              |   .
    `,'         ,-"'  .               \             |    L
   ,'          '    _.'                -._          /    |
  ,`-.    ,".   `--'                      >.      ,'     |
 . .'\'   `-'       __    ,  ,-.         /  `.__.-      ,'
 ||:, .           ,'  ;  /  / \ `        `.    .      .'/
 j|:D  \          `--'  ' ,'_  . .         `.__, \   , /
/ L:_  |                 .  "' :_;                `.'.'
.    ""'                  """""'                    V
 `.                                 .    `.   _,..  `
   `,_   .    .                _,-'/    .. `,'   __  `
    ) \`._        ___....----"'  ,'   .'  \ |   '  \  .
   /   `. "`-.--"'         _,' ,'     `---' |    `./  |
  .   _  `""'--.._____..--"   ,             '         |
  | ." `. `-.                /-.           /          ,
  | `._.'    `,_            ;  /         ,'          .
 .'          /| `-.        . ,'         ,           ,
 '-.__ __ _,','    '`-..___;-...__   ,.'\ ____.___.'
 `"^--'..'   '-`-^-'"--    `-^-'`.''"""""`.,^.`.--' mh

***/
