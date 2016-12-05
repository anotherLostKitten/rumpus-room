/*
 Daria Shifrina
APCs1 pd4
HW#37: Be More Rational
2016-11-30
*/

public class Rational{
	//instance variables
    public int numerator;
    public int denominator;
	//default constructor
    public Rational(){
	numerator = 0;
	denominator = 1;
    }
	//overloaded constructor. if denominator is a 0, then the num and denom make the fraction 0/1 and an error is printed. else it works.
    public Rational(int num, int den){
	if(den == 0){
	    numerator = 0;
	    denominator = 1;
	    System.out.println("You attempted an invalid denominator. The value "
			       + "of your rational number has been set to 0/1. " +
			       "Please try again.");
	}
	else{
	    numerator = num;
	    denominator = den;
	}
    }
	//overwritten toString. function: return the string version of the fraction formed by the numerator and denominator
    public String toString(){
	String stringHere = "";
	stringHere += numerator;
	stringHere += "/";
	stringHere += denominator;
	return stringHere;
    }
	//floatValue() is similar to toString(), except it returns the floating point number instead of a String fraction.
    public double floatValue(){
	return (numerator * 1.0)/denominator;
    }
	//multiply fxn: Takes 1 Rational object as a parameter and multiplies it by this Rational object.
    public void multiply(Rational rationalNum){
	this.numerator = this.numerator * rationalNum.numerator;
	this.denominator = this.denominator * rationalNum.denominator;
    }
	//divide fxn: Takes 1 Rational object as a parameter and divides it by this Rational object.
    public void divide (Rational rationalNum){
	this.numerator = this.numerator * rationalNum.denominator;
	this.denominator = this.denominator * rationalNum.numerator;
    }
    //add fxn: Takes 1 Rational object as a parameter and adds it by this Rational object.
    public void add(Rational rationalNum){
	this.numerator = (this.numerator * rationalNum.denominator) + (rationalNum.numerator * this.denominator);
	this.denominator = this.denominator * rationalNum.denominator;
    }
    //subtract fxn: Takes 1 Rational object as a parameter and subtracts it by this Rational object.
    public void subtract(Rational rationalNum){
	this.numerator = (this.numerator * rationalNum.denominator) - (rationalNum.numerator * this.denominator);
	this.denominator = this.denominator * rationalNum.denominator;
    }
	//the following 3 methods are pasted here to see how my gcdEW works. I originally had them in the same directory so 
	//I could just use their methods.
    //finds max of two ints
    public static int max(int a, int b){
      if ( a > b ) {
        return a;
    } else {
        return b;
    }
    }    
    //finds min of two ints
    public static int min(int a, int b){
        if ( a > b ) {
        return b;
    } else {
        return a;
    }
    } 
	//finds gcd using euclid's theorem.
  public static int gcdEW( int a, int b ) {
    int maxInt = max( a, b );
    int minInt = min( a, b );
    //answer
    int retInt = 1;
    //for holding value of maxInt after changing it
    int temp = 0;
    //changes any negatives to positive
    if ( maxInt < 0 ) {
        maxInt = maxInt * -1;
    }
    if ( minInt < 0 ) {
        minInt = minInt * -1;
    }
    //if any are 0 return the other
    if ( a == 0 || b == 0 ) {
        return max( a, b );
    }
    //if equal return either
    if ( a == b ) {
        return a;
    }       
    while( minInt != 0 ) {
        //holds value of maxInt
        temp = maxInt;
        //max becomes higher of difference between the two ints, and the smaller original int
        maxInt = max( minInt, maxInt - minInt );
        //min becomes lower of above
        minInt = min( minInt, temp - minInt );
        retInt = maxInt;
    }
    return retInt;
    }
	//finds gcd of a Rational object
    public int gcd(){
	return gcdEW(this.numerator,this.denominator);
    }
	//using gcd, reduces fraction to simplest form.
    public void reduce(){
		//holder holds gcd
	int holder = this.gcd();
	this.numerator = this.numerator / holder;
	this.denominator = this.denominator / holder;
    }
	//takes 2 ints as inputs and returns the greatest common divisor.
    public static int gcd(int numerator, int denominator){
	return gcdEW(numerator,denominator);
    }
	//compares 2 Rational objects. If the one in the input is smaller, 1 is returned. if its larger then -1 is returned. if they're equal then 0.
	//uses cross-multiplication and using .equals for the toString() value of the 2 cases.
    public int compareTo(Rational stuff){
	if (this.toString().equals(stuff.toString())){
	    return 0;
	}
	if( this.numerator * stuff.denominator > this.denominator * stuff.numerator){
	    return 1;
	}
	else{return -1;}
    }

    public static void main(String[] args){
	Rational r = new Rational(2,3);
	Rational s = new Rational(1,2);

	System.out.println("~~~~~~~~~~~~~~~~~Testing toString~~~~~~~~~~~~~~~~");
	System.out.println("expecting: 2/3. testing: r's value is: " + r.toString());
	System.out.println("expecting: 1/2. testing: s's value is: " + s.toString());

	System.out.println("~~~~~~~~~~~~~~~~~Testing Default Constructor Denominator Error~~~~~~~~~~~~~~~~");
	Rational q = new Rational(23,0);
	System.out.println("rational q = new Rational(23,0). expected: 1/0. testing: q's value is: " + q.toString());

	System.out.println("~~~~~~~~~~~~~~~~~Testing floatValue~~~~~~~~~~~~~~~~");
	System.out.println("expecting: 0.6666666667. testing: r's value is: " + r.floatValue());
	System.out.println("expecting: 0.5.  testing: s's value is: " + s.floatValue());
	System.out.println("expecting: 0.0.  testing: q's value is: " + q.floatValue());


	System.out.println("~~~~~~~~~~~~~~~~~Testing Multiply~~~~~~~~~~~~~~~~");
	r.multiply(s);
	System.out.println("expecting: r's new value: 2/6. s's new value: 1/2." + "\ntesting: r's new value: " + r.toString() 
			   + ". s's new value: " + s.toString() + ".");
	System.out.println("~~~~~~~~~~~~~~~~~Testing Divide~~~~~~~~~~~~~~~~");
	r.divide(s);
	System.out.println("expecting: s's new value: 4/6. s's new value: 1/2." + "\ntesting: r's new value: " + r.toString() 
			   + ". s's new value: " + s.toString() + ".");
	System.out.println("~~~~~~~~~~~~~~~~~Testing Add~~~~~~~~~~~~~~~~");
	Rational m = new Rational(1,2);
	Rational l = new Rational(3,4);
	m.add(l);
	System.out.println("expecting: m's new value: 10/8. l's new value: 3/4." + "\ntesting: m's new value: " + m.toString() 
			   + ". l's new value: " + l.toString() + ".");
	System.out.println("~~~~~~~~~~~~~~~~~Testing Subract~~~~~~~~~~~~~~~~");
	Rational h = new Rational(1,2);
	Rational t = new Rational(3,4);
	h.subtract(t);
	System.out.println("expecting: h's new value: -2/8. l's new value: 3/4." + "\ntesting: h's new value: " + h.toString() 
			   + ". t's new value: " + t.toString() + ".");
	System.out.println("~~~~~~~~~~~~~~~~~Testing gcd~~~~~~~~~~~~~~~~");
	System.out.println("expecting: h's gcd: 2." + "\ntesting: h's gcd: " + h.gcd());
	System.out.println("expecting: s's gcd: 1." + "\ntesting: s's gcd:" + s.gcd());
	System.out.println("~~~~~~~~~~~~~~~~~Testing reduce~~~~~~~~~~~~~~~~");
	h.reduce();
	System.out.println("expecting: h's new value: -1/4." + "\ntesting: h's new value: " + h.toString());
	System.out.println("~~~~~~~~~~~~~~~~~Testing static gcd~~~~~~~~~~~~~~~~");
	System.out.println("number: 6/8. expecting: 2. testing: " + gcd(6,8));
	System.out.println("number: 5/10. expecting: 5. testing: " + gcd(5,10));
	System.out.println("~~~~~~~~~~~~~~~~~Testing compareTo~~~~~~~~~~~~~~~~");
	Rational no = new Rational(1,2);
	Rational no2 = new Rational(1,2);
	Rational no3 = new Rational(5,6);
	System.out.println(no.compareTo(no2));
	System.out.println(no3.compareTo(no));
	System.out.println(no.compareTo(no3));
    }
}

