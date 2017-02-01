/*Truc Dao
APCS1 pd4
HW40 -- Rational Equality
2016-12-07*/

public class Rational implements Comparable {

    private int numerator, denominator;

    public Rational(){
	numerator = 0;
	denominator = 1;
    }

    public Rational(int num, int denom){
	this();
	if (denom != 0){
	    numerator = num;
	    denominator = denom;
	}
	else{
	    System.out.println("Invalid denominator, rational number = 0/1");
	}
    }

    public String toString(){
	return numerator + "/" + denominator;
    }

    public float floatValue(){
	return (this.numerator * 1.0f)/this.denominator;
    }

    public void multiply(Rational x){
        this.numerator *= x.numerator;
	this.denominator *= x.denominator;
    }

    public void divide(Rational x){
	this.numerator *= x.denominator;
        this.denominator *= x.numerator;
    }

    //Phase II

    public void add(Rational x){
	int thisDenom = this.denominator;
	int xDenom = x.denominator;
	int newDenom;
    }

    public void subtract(Rational x){
	int thisDenom = this.denominator;
	int xDenom = x.denominator;
	int newDenom;
    }

    public int gcd(){
	int smaller, greater, difference;
	if (this.numerator == this.denominator){
	    return this.numerator;
	}
	else{
	    if (this.numerator > this.denominator){
		smaller = this.denominator;
		greater = this.numerator;
	    }
	    else{
		smaller = this.numerator;
		greater = this.denominator;
	    }
	}
        while (greater % smaller != 0){
	    difference = greater - smaller;
	    if (difference > smaller){
		greater = difference;
	    }
	    else{
		greater = smaller;
		smaller = difference;
	    }
	}
	return smaller;
    }

    public void reduce(){
        this.numerator = this.numerator / this.gcd();
	this.denominator = this.denominator / this.gcd();
    }

    //Phase III

    public static int gcd(int num, int denom){
	int smaller, greater, difference;
        if (num % denom == 0){
	    return denom;
	}
	else{
	    if (num < denom){
		smaller = num;
		greater = denom;
	    }
	    else{
		smaller = denom;
		greater = num;
	    }
	}
        while (greater % smaller != 0){
	    difference = greater - smaller;
	    if (difference > smaller){
		greater = difference;
	    }
	    else{
		greater = smaller;
		smaller = difference;
	    }
	}
	return smaller;
    }	

    public int compareTo(Object o){
	Rational x = (Rational)o;
	double thisRational = this.numerator * x.denominator;
	double xRational = x.numerator * this.denominator;
	if (thisRational == xRational){
	    return 0;
	}
	else{
	    if (thisRational > xRational){
		return 1;
	    }
	    else{
		return -1;
	    }
	}
    }

    public boolean equals(Object o){
	boolean ret = false;
	if (o instanceof Rational && this.compareTo(o) == 0){
	    ret = true;
	}
	return ret;
    }

    public static void main(String[] args){
	Rational test1 = new Rational();
	Rational test2 = new Rational(1,2);
	System.out.println("test1 = " + test1); // 0/1
	System.out.println("test2 = " + test2); // 1/2
	System.out.println("test1 float Value = " + test1.floatValue()); // 0.0
	System.out.println("test2 float Value = " + test2.floatValue()); // 0.5
	Rational test3 = new Rational(2,3);
	test3.multiply(test2);
	System.out.println("multiply test3 by test2");
	System.out.println("test 2 = " + test2); // 1/2
	System.out.println("test 3 = " + test3); // 2/6
	Rational test4 = new Rational(2,3);
	test4.divide(test2);
	System.out.println("divide test4 by test2");
	System.out.println("test 2 = " + test2); // 1/2
	System.out.println("test 4 = " + test4); // 4/3
	Rational test5 = new Rational(8,0); // error msg
	System.out.println("test5 = " + test5); // 0/1
	Rational test6 = new Rational(2,3);
	System.out.println("test6 = " + test6); // 2/3
	Rational test7 = new Rational(1,2);
	System.out.println("test7 = " + test7); // 1/2
	Rational test8 = new Rational(4,18);
	System.out.println("test8 = " + test8); // 4/18
	System.out.println("add test7 to test6");
	test6.add(test7);
	System.out.println("test6 = " + test6); // 7/6
	System.out.println("test7 = " + test7); // 1/2
	test6.subtract(test7);
	System.out.println("subtract test7 from test6");
	System.out.println("test 6 = " + test6); // 4/6
	System.out.println("test 7 = " + test7); // 1/2
	System.out.println("gcd of test8 = " + test8.gcd());
	test8.reduce();
	System.out.println("test8 reduced"); 
	System.out.println("test8 = " + test8); // 2/9
	Rational test9 = new Rational(12,4);
	System.out.println("test9 = " + test9); // 12/4
	System.out.println("compare test9 to test8 : " + test9.compareTo(test8)); // 1
	System.out.println("compare test1 to test5 : " + test1.compareTo(test5)); // 0
	System.out.println("compare test1 to test2 : " + test1.compareTo(test2)); // -1
	System.out.println("gcd(8,12) = " + gcd(8,12)); // 4

	Rational test10 = new Rational(10,50);
	System.out.println("test10 = " + test10);
	String str = "10/50";
	System.out.println("str = " + str);
	System.out.println("test10.equals(str) : " + test10.equals(str)); // false
	Rational test11 = new Rational(10,50);
	System.out.println("test11 = " + test11);
	System.out.println("test10.equals(test11) : " + test10.equals(test11)); // true
        Rational test12 = new Rational(1,5);
	System.out.println("test12 = " + test12);
	System.out.println("test10.equals(test12) : " + test10.equals(test12)); // true
        Rational test13 = new Rational(4,5);
	System.out.println("test13 = " + test13);
	System.out.println("test10.equals(test13) : " + test10.equals(test13)); // false
    }

}
