//Dawei Huang
//Due: 12/07/2016
//Period 4 APCS w/ Mr. Brown Mykolyk
//HW #40 -- Rational Equality

public class Rational implements Comparable {
    public int numerator;
    public int denominator;

    //default constructor, sets numerator to 0 and denominator to 1
    public Rational(){
		numerator = 0;
		denominator = 1;
    }

    //overloaded constructor, sets numerator and denominator according to parameters
    public Rational(int numer, int denomin){
		if (numerator < 0 ^ denominator < 0){
		    System.out.println("Please enter a positive fraction, negatives are not accepted here");
		}
		else{
		    numerator = numer;
		    if (denomin == 0){
			System.out.println("Invalid denominator input, denominator is set to 1");
			denominator = 1;
		    }
		    else{
			denominator = denomin;
		    }
			this.reduce();
		}
    }

    //toString Method, returns string representation numerator/dnominator
    public String toString(){
		this.reduce();
		return (numerator + "/" + denominator);
    }

    //floatValue method, returns the float of the numerator divided by the denominator
    public double floatValue(){
		this.reduce();
		return ((double)numerator / (double)denominator);
    }

    //add method, takes Rational object a, sets this object to the sum of this object and object a
    public void add(Rational a){
	this.numerator = this.numerator * a.denominator + a.numerator * this.denominator;
	this.denominator = this.denominator * a.denominator;
	this.reduce();
    }

    //subtract method, takes Rational object a, sets this object to the difference of this object and object a
    public void subtract(Rational a){
	this.numerator = this.numerator * a.denominator - a.numerator * this.denominator;
	this.denominator *= a.denominator;
	this.reduce();
    }

    //multiply method, takes Rational object a, sets this object to the product of this object and object a
    public void multiply(Rational a){
		this.numerator *= a.numerator;
		this.denominator *= a.denominator;
		this.reduce();
    }

    //divide method, takes Rational object a, sets this object to the quotient of this object and object a
    public void divide(Rational a){
    	if (numerator < 0 ^ denominator < 0){
			System.out.println("Error: Negative Fractions are not accepted");
		}
		else{
			this.numerator *= a.denominator;
			this.denominator *= a.numerator;
			this.reduce();
		}
	}	    

    //reduce method, reduces a fraction to its lowest terms
    public void reduce(){
		int GCD;
		GCD = gcd(this.numerator, this.denominator);
		this.numerator /= GCD;
		this.denominator /= GCD;
    }

    //GCD method, finds the greatest common denominator between two positive numbers
    public static int gcd (int a, int b){
		if (a % b == 0){
			return b;
		}
		if (b % a == 0){
			return a;
		}
		while (a != 0 && b !=0){
			if (a > b){
				a -= b;
			}
			else {
				b -= a;
			}
		}
		if (a == 0){
			return b;
		}
		else {
			return a;
		}
	}
	
	//Overriden compareTo method from class Comparable
	//1) Returns 0 if the two numbers are equal
	//2) Returns 1 if the calling number is larger than the parameter
	//3) Returns -1 if the calling number is smaller than the parameter
	//4) Returns -2 if there is any error (not possible)
	
	public int compareTo(Object z){
	    Rational bob = (Rational) z;
		bob.reduce();
		if(this.floatValue() == bob.floatValue()){
			return 0;
		}
		else if(this.floatValue() > bob.floatValue()){
			return 1;
		}
		else if(this.floatValue() < bob.floatValue()){
			return -1;
		}
		else{
			System.out.println("There is either a problem with either the calling object or the parameters provided");
			return -2;
		}
	}

	//equals method checks to see if a given Object is an instance of class Rational
	// and that it is equivalent in value to the referanced object of the same class. 
	// If so, return true. Otherwise, return false.
    public boolean equals(Object z){
		return (z instanceof Rational && compareTo(z) == 0);
    }

} // end of Rational Class

class Driver{
    public static void main(String[] args){
		//tests for defualt and overloaded constructors and toString method
		System.out.println("\ntests for defualt and overloaded constructors and toString method");
		Rational a = new Rational();
		System.out.println(a.toString()); // 0/1
		Rational s = new Rational(1,2);
		System.out.println(s.toString()); // 1/2
		Rational r = new Rational(2,3);
		System.out.println(r.toString()); // 2/3

		//test for floatValue method
		System.out.println("\ntest for floatValue method");
		System.out.println(r.floatValue()); //0.666666666666666
		
		//test for multiply method
		System.out.println("\ntest for multiply method");
		r.multiply(s);
		System.out.println(s.toString()); // 1/2
		System.out.println(r.toString()); // 2/3
		
		//test for divide method
		System.out.println("\ntest for divide method");
		r.divide(s);
		System.out.println(s.toString()); // 1/2
		System.out.println(r.toString()); // 2/3
		
		//test for gcd method
		System.out.println("\ntest for gcd method");
		Rational e = new Rational(3214,4128);
		e.reduce();
		System.out.println(e.toString()); // 1607/2064
		
		//test for static gcd method
		System.out.println("\ntest for static gcd method");
		System.out.println(Rational.gcd(3214,4128)); // 2
		
		// test for compareTo
		System.out.println("\ntest for compareTo");
		Rational f = new Rational(1607,2064);
		Rational x = new Rational(1608,2064);
		Rational v = new Rational(1606,2064);
		System.out.println(e.compareTo(f)); // 0
		System.out.println(e.compareTo(x)); // -1
		System.out.println(e.compareTo(v)); // 1

		// test for overriden equals method
		Rational bob = new Rational(5,10);
		Rational Geo = new Rational(5,10);
		Rational xxx = new Rational();
		System.out.println(bob.equals(Geo));
		System.out.println(bob.equals(xxx));
	}
}
