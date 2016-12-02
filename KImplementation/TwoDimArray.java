// Karina Ionkina
// APCS1 pd04
// HW 38 -- practice working with 2D arrays
// 2016-12-01

public class TwoDimArray {

    //postcond: prints each row of 2D integer array a on its own line
    //          uses a FOR loop
    public static void print1( int[][] a ) 
    {   String str = "";
	int r = a.length;
	for (int x = 0; x < r; x++){
	    for (int y = 0 ; y < a[x].length; y ++){
		str += a[x][y];
	    }
	    str += "\n";
	   
	}
	System.out.println(str.substring(0, str.length() - 1));
    }


    public static void print2( int[][] a ) 
    { String str = "";
	for (int[]i : a ){
	    for (int x : i){
		str += x;
		    }
	    str += "\n";
	}
	System.out.println(str.substring(0, str.length() - 1));
	 
    }


    //postcond: returns sum of all items in 2D integer array a
     public static int sum1( int[][] a )
     {
	 int sum = 0;
	 for(int[]i : a) {
	     for (int x : i){
		 sum += x;
	     }
	 }
	 return sum;
    }


    //postcond: returns sum of all items in 2D integer array a
    //          * uses helper fxn sumRow
    public static int sum2( int [][] m ) 
    { int sum = 0;
	for (int r = 0; r < m.length; r ++){
	    // sum += sumRow(r,  m);
	    sum += sumRow2(r, m);
	}
	return sum;
	    
    }


    //postcond: returns sum of all items on row r of 2D integer array 
    //          uses a FOR loop
    public static int sumRow( int r, int[][] a ) 
     {
	 int sum = 0;
	 for (int x = 0; x < a[r].length; x ++){
	     sum += a[r][x];
	 }
	 return sum;
    }


    //postcond: returns sum of all items on row r of 2D integer array 
    //          uses a FOREACH loop
     public static int sumRow2( int r, int[][] m ) 
     { 
	 int sum = 0;
	 for (int x : m[r]){
	     sum += x;
	 }
	 return sum;
	     
     }


    //postcond: returns sum of all items in column c of 2D integer array 
     public static int sumCol( int c, int[][] m ) 
     { 
	 int sum = 0;
	 for (int r = 0; r < m.length; r++){
	     sum += m[r][c] ;
	 }
	 return sum;
     }

    public static void main( String [] args ) 
    {

	int [][] m1 = new int[4][2];
	int [][] m2 = { {2,4,6}, {3,5,7} };
	int [][] m3 = { {2}, {4,6}, {1,3,5} };
	print1(m1);
	print1(m2);
	print1(m3);
	print2(m1);
	print2(m2);
	print2(m3);
       
	System.out.print("testing sum1...\n");

	System.out.println("sum m1 : " + sum1(m1));
	System.out.println("sum m2 : " + sum1(m2));
	System.out.println("sum m3 : " + sum1(m3));
	
	
	System.out.print("testing sum2...\n");
	System.out.println("sum m1 : " + sum2(m1));
	System.out.println("sum m2 : " + sum2(m2));
	System.out.println("sum m3 : " + sum2(m3));
	//sumCols
	System.out.println("sumCol column 2 of m2 : " +  sumCol(2, m2));

    }

}//end class TwoDimArray
