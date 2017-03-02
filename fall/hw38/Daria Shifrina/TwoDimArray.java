/*
	Daria Shifrina
	APCS pd4
	HW38: Arrays of Arrays
	2016-12-01
	*/

// skeleton file for 
// class TwoDimArray
// ...practice working with 2D arrays

public class TwoDimArray {

    //postcond: prints each row of 2D integer array a on its own line
    //          uses a FOR loop
    public static void print1( int[][] a ) {
	for(int s = 0; s < a.length; s++){
		for (int x = 0; x < a[s].length; x++){
			//prints out int at row s and column x. since we go by row first, we complete a row before moving 
				//on to next column.
			System.out.print(a[s][x] + " ");
		}
		System.out.println();
	}
	}


    //postcond: prints each row of 2D integer array a on its own line
    //          uses a FOREACH loop
    public static void print2( int[][] a ) 
    { 
	//goes to row num.
	for(int[] num: a){
		//for each row num, prints every value in num. then loops back to num and looks at the next row num.
	    for(int nummer: num){
		System.out.print(nummer + " ");
		}
	    System.out.println();
    }
   }


    //postcond: returns sum of all items in 2D integer array a
	public static int sum1( int[][] a )
    { 
	//holds final sum
	int sum = 0;
	for(int[] num: a){
		//adds value in row num and column nummer to total sum.
	    for(int nummer: num){
		sum += nummer;
		}
    }
	return sum;
   }


    //postcond: returns sum of all items in 2D integer array a
    //          * uses helper fxn sumRow
    public static int sum2( int [][] m ) 
    { 
	//holds total sum
	int sum = 0;
	//adds up all the rows as x is the counter for rows.
	for(int x = 0; x < m.length; x++){
		sum += sumRow(x,m);
	}
	return sum;
    }


    //postcond: returns sum of all items on row r of 2D integer array 
    //          uses a FOR loop
    public static int sumRow( int r, int[][] a ) 
	{ 
	int sum = 0;
	for(int x = 0; x < a[r].length; x++){
		sum += a[r][x];	
	}
	return sum;
    }


    //postcond: returns sum of all items on row r of 2D integer array 
    //          uses a FOREACH loop
    public static int sumRow2( int r, int[][] m ) 
   { 
	int sum = 0;
		for(int nummer: m[r]){
			sum += nummer;
		}
		return sum;
   }


    //postcond: returns sum of all items in column c of 2D integer array 
	public static int sumCol( int c, int[][] m ) 
    { 
	int sum = 0;
		for(int x = 0; x < m.length; x++){
			if(m[x].length-1 < c){
				sum += 0;
			}
			else{
			sum+= m[x][c];
			}
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
	System.out.print("testing sumRow...\n");
	
	System.out.println("sum of row 0 in m3 : " + sumRow(0, m3));
	System.out.println("sum of row 1 in m3 : " + sumRow(1, m3));
	System.out.println("sum of row 2 in m3 : " + sumRow(2, m3));
	System.out.print("testing sumRow2...\n");
	
	System.out.println("sum of row 0 in m3 : " + sumRow2(0, m3));
	System.out.println("sum of row 1 in m3 : " + sumRow2(1, m3));
	System.out.println("sum of row 2 in m3 : " + sumRow2(2, m3));
	
	System.out.print("testing sum2...\n");
	System.out.println("sum m1 : " + sum2(m1));
	System.out.println("sum m2 : " + sum2(m2));
	System.out.println("sum m3 : " + sum2(m3));

	System.out.print("testing sumCol...\n");	
	System.out.println("sum of column 1 in m3 : " + sumCol(0, m3));
	System.out.println("sum of column 2 in m3 : " + sumCol(1, m3));
	System.out.println("sum of column 3 in m3 : " + sumCol(2, m3));

	/*
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }

}//end class TwoDimArray