//Edwin Mok
//APCS1 pd3
//HW40 -- Rational Equality
//2016-12-06

public class Rational implements Comparable {
    //Phase1-------------------------------------------------------------

    //Instance variables
    private int p;//numerator
    private int q;//denominator

    //Default constructor
    public Rational() {
        p = 0;
	q = 1;
    }

    //Overwritten constructor
    public Rational(int num,int denom){
	p = num;
	q = denom;
    }

    //Overwritten toString
    public String toString() {
	return p + "/" + q;
    }

    //Returns a floating point value of the number
    public float floatValue(){
	double num = p;
	double denom = q;
	float ans = (float) (num/denom);
	return ans;
    }

    //Multiply a Rational object by the Rational object r
    public void multiply(Rational r){
	p = p * r.p;
	q = q * r.q;
    }

    //Divide a Rational object by the Rational object r
    public void divide(Rational r){
	p = p * r.q;
	if (r.p == 0){
	    System.out.println("Error: denominator cannot be 0");
	}
	q = q * r.p;
    }

    //Phase2-------------------------------------------------------------

    //Add a Rational object by the Rational object r
    public void add(Rational r){
	p = (p * r.q) + (r.p * q);
	q = r.q * q;
    }

    //Subtract a Rational object by the Rational object r
    public void subtract(Rational r){
	p = (p * r.q) - (r.p * q);
	q = r.q * q;
    }

    //Euclid's algorithm for finding gcd (From previous HW)
    public int gcd(){
	int a = p;
	int b = q;
	if (a > b) {
	    return this.gcd();} // rearranges numbers to (smaller,larger)
	while (b % a != 0){
	    int remainder = b % a; // to keep track of b % a
	    b = a;
	    a = remainder;
	}
	return a;       
    }

    //Reduces a Rational object by the gcd
    public void reduce(){
	int a = this.gcd();
	p = p / a;
	q = q / a;
    }

    //Phase3-------------------------------------------------------------

    //static gcd method that takes two parameters, numerator and denominator
    public static int gcdS(int num, int denom){
	int a = num;
	int b = denom;
	if (a > b) {
	    return gcdS(b, a);} // rearranges numbers to (smaller,larger)
	while (b % a != 0){
	    int remainder = b % a; // to keep track of b % a
	    b = a;
	    a = remainder;
	}
	return a;	
    }

    //HW40 part-------------------------------------------------------------

    //compare the calling Rational object with Rational object r
    //if equal, return 0
    //if calling number > r, return 1
    //if r > calling number, return -1
    public int compareTo( Object a ){
	if (! (a instanceof Rational)){
	    throw new ClassCastException("\ncompareTo() input is not of class Rational");
	}
	Rational b = (Rational) a;
	return this.p * b.q - this.q * b.p; 
    }

    public boolean equals(Object a){
	boolean b2 = false;
	boolean b1 = a instanceof Rational;
	if (b1){
	    b2 = (this.compareTo(a) == 0);
	}
	return b1 && b2;
    }

    //Main method for testing purposes
    public static void main(String[] args){
	Rational r = new Rational(2,3);//Stores the rational number 2/3
	Rational s = new Rational(1,2);//Stores the rational number 1/2

	//Phase 1 Test Cases
	/*	
		System.out.println(r);// 2/3
		System.out.println(s);// 1/2
		System.out.println(r.floatValue());// 0.6666667
		System.out.println(s.floatValue());// 0.5
		r.multiply(s);
		System.out.println(r);// 2/6
		System.out.println(s);// 1/2
		s.multiply(r);
		System.out.println(r);// 2/6
		System.out.println(s);// 2/12
		r.divide(s);
		System.out.println(r);// 24/12
		System.out.println(s);// 2/12
		s.divide(r);
		System.out.println(r);// 24/12
		System.out.println(s);// 24/288
	*/

	//Phase 2 Test Cases
	/*
	  System.out.println(r);// 2/3
	  System.out.println(s);// 1/2
	  r.add(s);
	  System.out.println(r);// 7/6
	  System.out.println(s);// 1/2
	  r.subtract(s);
	  System.out.println(r);// 8/12
	  System.out.println(s);// 1/2
	  System.out.println(r.gcd());// 4
	  System.out.println(s.gcd());// 1
	  r.reduce();
	  System.out.println(r);// 2/3
	*/

	//Phase 3 Test Cases
	/*
	  Rational g = new Rational(1,2);
	  System.out.println(gcdS(50,60));//10
	  System.out.println(s.compareTo(g));//0
	  System.out.println(r.compareTo(g));//1
	  System.out.println(g.compareTo(r));//-1
	*/

	//Equals Test Cases
	Rational g = new Rational(1,2);
	String z = new String("1/2");
	System.out.println(g.equals(r));//false
	System.out.println(g.equals(s));//true
	System.out.println(g.equals(z));//false
	System.out.println(z.equals(g));//false
    }

}
