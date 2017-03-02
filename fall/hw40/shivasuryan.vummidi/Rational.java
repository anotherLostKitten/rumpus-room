/*Shivasuryan Vummidi
APCS1 pd 3
HW 40 -- Rational.java, return a string of rational numbers, implements comparable
2016-12-06*/
//USES THE INTERFACE COMPARABLE
public class Rational implements Comparable{
    int numerator;
    int denominator;
    String retStr;
    //Instantizes variables
    public Rational(){
	numerator = 0;
	denominator = 1;
    }
    //Accepts the inputs and instantizes them, but prevents the denominator from becoming 0
    public Rational(int numerator, int denominator){
	try{
	    this.numerator = numerator;
	    this.denominator = denominator;
	    if(this.denominator == 0){
		this.denominator = 1;
		System.out.println("The denominator cannot be 0!!!");
	    }
	}
	catch(IllegalArgumentException e){
	    System.out.println("Your inputs are invalid.");
	    numerator = 0;
	    denominator = 1;
	}
    }
    //Returns a string of numerator over denominator
    public String toString(){
	retStr = numerator + "/" + denominator;
	return retStr;
    }
    //Floats the numerator and the divides by the denominator
    public double floatValue(){
	double numerator_d = numerator * 1.0;
	return numerator_d / denominator;
    }
    //Multiples the numerators and denominators of different instances of Rational
    public void multiply(Rational a){
	this.numerator *= a.numerator;
	this.denominator *= a.denominator;
    }
    //Divides the numerators and the denominators of different instances of Rational, but prevents either numerator from being 0
    public void divide(Rational a){
	if(a.numerator == 0){
	    a.numerator = 1;
	}
	if(numerator == 0){
	    numerator = 1;
	}
	numerator /= a.numerator;
	denominator /= a.denominator;
    }
    /*public void add(Rational a){
	numerator 
	}*/
    public static int min(int a, int b){
	if(a < b){
	    return a;
	}
	else{
	    return b;
	}
    }
    public static int gcd(int a, int b){
	int retGCD = 1;
	int divisor = 1;
	while(divisor <= min(a, b)){
	    if (a % divisor == 0 && b % divisor == 0){
		retGCD = divisor;
	    }
	    divisor += 1;
	}
	return retGCD;
    }
    public int gcd(){
	return gcd(numerator, denominator);
    }
    public void add(Rational b){
	numerator = (numerator * b.denominator) + (b.numerator * denominator);
	denominator *= b.denominator;
    }
    public void subtract(Rational b){
	numerator = (numerator * b.denominator) - (b.numerator * denominator);
	denominator *= b.denominator;
    }
    public void reduce(){
	int greatestCD = gcd();
	numerator /= greatestCD;
	denominator /= greatestCD;
    }
    public void oxidize(){
	int factor = (int)(Math.random() * 40);
	numerator *= factor;
	denominator *= factor;
    }
    //defines the equality of a
    //Checks whether a is not an instance of Rational. If this is false, then a will be converted into a Rational object and will then check for the truth value of the fractions being equal or not.
    public int compareTo(Object a){
	if(!(a instanceof Rational)){
	    throw new ClassCastException("\n Object a is not a Rational object.");
	}
	Rational b = (Rational)a;
	if(numerator == b.numerator && denominator == b.denominator){
	    return 0;
	}
	if((numerator * 1.0) / denominator > (b.numerator * 1.0) / b.denominator){
	    return 1;
	}
	else{
	    return -1;
	}
    }
    //Checks whether a is a Rational object and whether this instance is equal to a.
    public boolean equals(Object a){
	if(a instanceof Rational && compareTo(a) == 0){
	    return true;
	}
	else{
	    return false;
	}
	
    }
    //Tests the methods, 100% success
    public static void main(String[] args){
	Rational TBM = new Rational(3, 8934);
	Rational PChan = new Rational(1, 4);
	Rational Shiva = new Rational(3, 6);
	System.out.println(TBM);
	System.out.println(PChan);
	TBM.multiply(PChan);
	System.out.println(TBM);
	System.out.println(TBM.floatValue());
	System.out.println(Shiva);
	Shiva.reduce();
	System.out.println(Shiva);
	Shiva.add(PChan);
	System.out.println(Shiva);
	Shiva.subtract(PChan);
	System.out.println(Shiva);
	Shiva.oxidize();
	System.out.println(Shiva);
	System.out.println(Shiva.compareTo(Shiva));
	System.out.println(Shiva.compareTo(TBM));
	System.out.println(Shiva.equals(TBM));
	System.out.println(Shiva.equals(Shiva));
    }
}
