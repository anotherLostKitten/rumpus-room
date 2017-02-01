/* 
Queenie Xiang
APCS1 pd1
HW38 -- Arrays of Arrays 
2016-12-01  
*/ 

public class TwoDimArray {
    //postcond: prints each row of 2D integer array a on its own line
    //          uses a FOR loop
    public static void print1( int[][] a ) { 
        for (int x = 0; x < a.length; x += 1) {
	    for (int y = 0; y < a[x].length; y += 1) {
		System.out.print(a[x][y] + " ");
	    }
	    System.out.println("\n");
	}   
    }

    //postcond: prints each row of 2D integer array a on its own line
    //          uses a FOREACH loop
    public static void print2( int[][] a ) { 
        for (int[] x : a) {
	    int i = 0; 
	
	    while (i < x.length) {
		System.out.print(x[i] + " ");
		i += 1;
	    }
	    System.out.println("\n"); 
	}
    }
	    
    //postcond: returns sum of all items in 2D integer array a
    public static int sum1( int[][] a ) { 
	int sum = 0;
	for (int x = 0; x < a.length; x += 1) {
	    for (int y = 0; y < a[x].length; y += 1) {
		sum += a[x][y];
	    }
	}
	return sum; 
    }

    //postcond: returns sum of all items in 2D integer array a
    //          * uses helper fxn sumRow
    public static int sum2( int [][] m ) { 
	int sum = 0;
	for (int x = 0; x < m.length; x += 1) {
	    sum += sumRow(x, m);
	}
	return sum;
    }

    //postcond: returns sum of all items in 2D integer array a
    //          * uses helper fxn sumRow
    public static int sum2WithHelper( int [][] m ) 
    { 
	int sum = 0;
	for (int x = 0; x < m.length; x += 1) {
	    sum += sumRow2(x, m);
	}
	return sum;
    }

    //postcond: returns sum of all items on row r of 2D integer array 
    //          uses a FOR loop
    public static int sumRow( int r, int[][] a ) {
	int sum = 0; 
	for (int x = 0; x < a[r].length; x += 1) {
	    sum += a[r][x];
	}
	return sum;    
    }

    //postcond: returns sum of all items on row r of 2D integer array 
    //          uses a FOREACH loop
    public static int sumRow2( int r, int[][] m ) {
	int sum = 0;
	for (int x : m[r]) {
	    sum += x;
	}
	return sum;
    }

    //postcond: returns sum of all items in column c of 2D integer array 
    public static int sumCol( int c, int[][] m ) { 
	int sum = 0;
	for (int x = 0; x < m.length; x += 1) {
	    if (c < m[x].length) {
		sum += m[x][c];
	    }
	}
	return sum; 
    }

    public static void main( String [] args ) {
	int [][] m1 = new int[4][2];
	int [][] m2 = { {2,4,6}, {3,5,7} };
	int [][] m3 = { {2}, {4,6}, {1,3,5} };
	
	print1(m1);
	System.out.print("====================================" + "\n");
	print1(m2);
	System.out.print("====================================" + "\n");
	print1(m3);

	System.out.print("====================================" + "\n");
	print2(m1);
	System.out.print("====================================" + "\n");
	print2(m2);
	System.out.print("====================================" + "\n");
	print2(m3);

	System.out.print("====================================" + "\n");
	System.out.print("testing sum1...\n");
	System.out.println("sum m1 : " + sum1(m1));
	System.out.println("sum m2 : " + sum1(m2));
	System.out.println("sum m3 : " + sum1(m3));

	System.out.print("====================================" + "\n");
	System.out.print("testing sum2...\n");
	System.out.println("sum m1 : " + sum2(m1));
	System.out.println("sum m2 : " + sum2(m2));
	System.out.println("sum m3 : " + sum2(m3));

	System.out.print("====================================" + "\n");
	System.out.print("testing sum2WithHelper...\n");
	System.out.println("sum m1 : " + sum2WithHelper(m1));
	System.out.println("sum m2 : " + sum2WithHelper(m2));
	System.out.println("sum m3 : " + sum2WithHelper(m3));

	System.out.print("====================================" + "\n");
	System.out.print("testing sumCol...\n");
	System.out.println("sum m1 : " + sumCol(0, m1));
	System.out.println("sum m2 : " + sumCol(0, m2));
	System.out.println("sum m3 : " + sumCol(0, m3));
	System.out.println("sum m1 : " + sumCol(1, m1));
	System.out.println("sum m2 : " + sumCol(3, m2));
	System.out.println("sum m3 : " + sumCol(1, m3));
    }
}//end class TwoDimArray
