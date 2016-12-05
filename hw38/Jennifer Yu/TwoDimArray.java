/*
Jennifer Yu
APCS1 Period 3
2016-12-01
HW #38: 
*/
public class TwoDimArray {

    //postcond: prints each row of 2D integer array a on its own line
    //          uses a FOR loop
    public static void print1( int[][] a )
    {
        for (int x = 0; x < a.length; x ++){
			for (int y = 0; y < a[x].length; y++){
				System.out.print(a[x][y] + " ");
			}
			System.out.println();
		}
    }


    //postcond: prints each row of 2D integer array a on its own line
    //          uses a FOREACH loop
    public static void print2( int[][] a )
    {
		for (int[] i : a){
			for (int p : i){
				System.out.print(p + " ");
			}
			System.out.println();
		}
    }


    //postcond: returns sum of all items in 2D integer array a
    public static int sum1( int[][] a )
    {
		int sum = 0; 
		for (int[] i : a){
			for (int p : i){
				sum += p;
			}
		}
		return sum;
    }

    //postcond: returns sum of all items in 2D integer array a
    //          * uses helper fxn sumRow
	
    public static int sum2( int [][] m )
    {	int sum = 0;
		for (int x = 0; x < m.length; x ++){
			sum += sumRow(x, m);
		}
		return sum;
    }

    //postcond: returns sum of all items on row r of 2D integer array
    //          uses a FOR loop
    public static int sumRow( int r, int[][] a )
    {
		int sum = 0; 
		for (int y = 0; y < a[r].length; y ++){
			sum += a[r][y];
		}
		return sum;
    }


    //postcond: returns sum of all items on row r of 2D integer array
    //          uses a FOREACH loop
    public static int sumRow2( int r, int[][] m )
    {
		int sum = 0; 
		for (int i: m[r]){
			sum += i;
		}
		return sum;
    }


    //postcond: returns sum of all items in column c of 2D integer array
    public static int sumCol( int c, int[][] m )
    {
		int sum = 0; 
		for (int i = 0; i < m.length; i ++){
			sum += m[i][c];
		}
		return sum;
    }


    public static void main( String [] args )
    {
        
        int [][] m1 = new int[4][2];
        int [][] m2 = { {2,4,6}, {3,5,7} };
        int [][] m3 = { {2}, {4,6}, {1,3,5} };
		/*
		System.out.println(sumCol(1, m2));
		System.out.println(sumRow2(1, m2));
		System.out.println(sumRow2(2, m3));
		System.out.println(sumRow(0, m2));*/
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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
		  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        System.out.println("sum m1 : " + sum2(m1));
        System.out.println("sum m2 : " + sum2(m2));
        System.out.println("sum m3 : " + sum2(m3));
      

    }

}//end class TwoDimArray
