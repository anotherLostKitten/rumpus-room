// Eugene Thomas
// APCS1 pd3
// HW37 -- Be More Rational (A revision of HW36)  
// Date Created: 2016-11-28
// Date of Revision: 2016-11-30


// Objective: To create a class Rational that implements methods to work with rational numbers in the form p/q. 

public class Rational { 

    // Declaration of Instependence 

    private int numerator; 
    private int denominator; 

    // Default Constructor: Sets numerator to 0 and denominator to 1. 

    Rational () { 
	numerator = 0; 
	denominator = 1; 
    } 

    // Overloaded Constructor: Set your own numerator and denominator!

    Rational (int p, int q) { 
	numerator = p; 
	denominator = q; 
    } 
    
    // Overwriting toString(): A string representation of an instance of Rational 

    public String toString() { 
	return numerator + "/" + denominator; 
    } 

    // floatValue(): returns a floating point that approximates the p/q given. 

    public float floatValue() { 
	float num; 
	num = (float) (numerator); 
	return num/denominator; 
    } 

    // multiply(Rational a): multiplies an instance of rational by another Rational a (does not return the product). 

    public void multiply (Rational a) { 
        numerator *= a.numerator; 
	denominator *= a.denominator; 
    } 

    // divide(Rational a): divides an instance of rational by another Rational a (does not return the product). 
    
    public void divide (Rational a) { 
	numerator *= a.denominator;
	if (a.numerator == 0) {System.out.println("ERROR: DIVISON BY 0"); } 
	else {denominator *= a.numerator;} 
    } 

    // add(Rational a): Adds a Rational to an inputted rational a. 

    public void add (Rational a) { 
	
	numerator = a.denominator * numerator + denominator * a.numerator; 
	denominator *= a.denominator; 
    } 

    // subtract(Rational a): Subtracts a Rational a from the given Rational. 

    public void subtract (Rational a) { 
	a.numerator *= -1; 
	add(a); 
    } 
    
    // Taken from HW20 (GCD Three Ways). 
    // GCD: a method that compares two integers and returns their gcd. 

    public int gcd() { 
	
	int x; 
	numerator = Math.abs(numerator); 
	denominator = Math.abs(denominator); 

	if (numerator > denominator){x = denominator; }
	else { x = numerator;  }
	while (x > 0) {
	    if (numerator%x == 0 && denominator%x == 0) { break; } 
	    else {x -= 1;} }
	return x; 

    } 

    // reduce(): A method that reduces a given Rational into simplest form 

    public void reduce () {
	int g = this.gcd();
	numerator /= g; 
	denominator /= g; 
    } 

    public static int gcd(int a, int b) {

	int x; 
	a = Math.abs(a); 
	b = Math.abs(b); 

	if (a > b){x = b; }
	else { x = a;  }
	while (x > 0) {
	    if (a%x == 0 && b%x == 0) { break; } 
	    else {x -= 1;} }
	return x; 

    } 
    
    public int compareTo(Rational a) { 
	if (numerator*a.denominator == a.numerator * denominator) {return 0;} 
	else if (numerator*a.denominator > a.numerator * denominator) {return 1;} 
	else {return -1;} 
    } 

    // MAIN 

    public static void main (String[] args) { 
	
	// Tests the default constructor: 

	Rational mike = new Rational(); 
	System.out.println(mike.numerator); // 0 
	System.out.println(mike.denominator); // 1
	System.out.println(mike); // "0/1" 

	// Tests the Overloaded Constructor: 

	Rational TBM = new Rational(3, 4); 
	Rational Pbrooks = new Rational(5, 7);
	Rational RickyP = new Rational(50, 60); 
	System.out.println(TBM.numerator); // 3
	System.out.println(Pbrooks.denominator); // 7
	System.out.println(TBM); // "3/4"
	System.out.println(Pbrooks); // "5/7"
	System.out.println(TBM.floatValue()); // .75
	System.out.println(Pbrooks.floatValue()); // .714285
        TBM.multiply(Pbrooks); 
	System.out.println(TBM); // "15/28"
        TBM.divide(Pbrooks); 
	System.out.println(TBM); // "105/140"
	TBM.divide(mike); // This should print: "ERROR: DIVISION BY 0"
	System.out.println(gcd(12, 20)); // 4
	TBM.reduce();
	System.out.println(TBM); // "3/4"
	TBM.add(RickyP); 
	System.out.println(TBM); // "380/240"
	TBM.subtract(Pbrooks); 
	System.out.println(TBM); // "1460/1680"
	TBM.reduce(); 
	System.out.println(TBM); // "73/84" 
	System.out.println(TBM.compareTo(Pbrooks)); // 1
    }

} // end class 
