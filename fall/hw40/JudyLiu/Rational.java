//Judy Liu
//APCS1 pd3
//HW40: Rational Equality
//2016-12-6

public class Rational implements Comparable{
    private int numerator;
    private int denominator;

    //Default constructor
    public Rational(){
	numerator = 0;
	denominator = 1;
	Rational rat = new Rational(numerator, denominator);	
    }

    //Constructor
    public Rational(int num,int den){

	//invalid denominator
	if (den == 0){
	    System.out.println("Invalid denominator is attempted. Number is set to 0/1.");
	    numerator = 0;
	    denominator = 1;
	}
	
	else{
	    numerator = num;
	    denominator = den;
	}
	
    }

    //toString
    public String toString(){
	String retStr = "";
	retStr += numerator;
	retStr += "/";
	retStr += denominator;
	return retStr;
    }

    //float Value
    public float floatValue(){
	return (float) numerator/denominator;
    }

    public void multiply(Rational n){
	numerator *= n.numerator;
	denominator *=  n.denominator;
    }

    public void divide(Rational n){
	numerator *= n.denominator;
	denominator *= n.numerator;
    }

    public void add(Rational n){
	if (denominator == n.denominator){
	    numerator += n.numerator;
	}
	else{
	    numerator = (numerator * n.denominator) + (n.numerator * denominator);
	    denominator *= n.denominator;
	}
     }

    public void subtract(Rational n){
	if (denominator == n.denominator){
	    numerator += n.numerator;
	}
	else{
	    numerator = (numerator * n.denominator) - (n.numerator * denominator);
	    denominator *= n.denominator;
	}
     }

    public int gcdER(int a,int b){
	if (b > a){
	    gcdER(b,a);
	}
	if (b == 0){
	    return a;
	}
	else {
	    return gcdER(b, a%b);
	}
    }
    
    public int gcd(){
	return gcdER(numerator,denominator);
    }

    public void reduce(){
	int GCD = gcd();
	numerator = numerator / GCD;
	denominator = denominator / GCD;
    }

    public static int statGCD(int num, int den){
	if (num > den){
	    return statGCD(den, num);
	}
	if (num == 0){
	    return den;
	}
	else{
	    return statGCD(num, den%num);
	}
    }

    /*If Object a is a Rational return int
     */
    public int compareTo(Object a){
	if (a instanceof Rational){
	    Rational b = (Rational) a;
	    return numerator * b.denominator -
		denominator *b.numerator;
	}
	else{
	    throw new ClassCastException("\ncompareTo() input not Rational");
	}
	  
    }

    /*If Object a is a Rational, compare it to a Rational and returns true when      comparedTo(a) equals 0. Returns false otherwise.
    */
    public boolean equals(Object a){
	if (a instanceof Rational){
	    return (compareTo(a)==0);
	}
	else{
	    return false;
	}
    }
    
    public static void main(String[] args){
	Rational r = new Rational(2,3); //Stores the rational number 2/3

	Rational s = new Rational(1,2); //Stores the rational number 1/2

	Rational t = new Rational(4,18); //Stores the rational number 4/18

	Rational u = new Rational(4,6);

	Object v = new Object();

	System.out.println(r.equals(u));
	System.out.println(r.equals(v));

	System.out.println("\n Compare to");
	System.out.println(s.compareTo(r));
	System.out.println(s.compareTo(v));


    }
}
