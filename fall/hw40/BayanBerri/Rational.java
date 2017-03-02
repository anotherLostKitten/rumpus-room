//Bayan Berri
//APCS1 pd5
//Hw40-- Rational Equality
//2016-12-07
public class Rational implements Comparable{
    private int numerator;
    private int denominator;
    public Rational(){
	numerator=0;
	denominator=1;
    }
  
    public Rational(int numer, int denom){
	if(denom==0){
	    System.out.println("invalid denominator value");
	    numerator=0;
	    denominator= 1;
	}
	else{
	    numerator= numer;
	    denominator= denom;
	}
    }
    public String toString(){
	String retstr="";
	retstr= numerator + "/" + denominator;
	return retstr;
    }
    public double floatValue(){
	double n=(double)numerator;
	double d= (double)denominator;
	return n / d;
    }
    public void multiply(Rational rat){
	numerator*=rat.numerator;
    	denominator*= rat.denominator;
    }
    public void divide(Rational rat){
	numerator*= rat.denominator;
	denominator*= rat.numerator;
    } 
    public void add(Rational rat){
	int oldd=denominator;
	rat.numerator= (rat.denominator*numerator)+ (oldd*rat.numerator);
	rat.denominator= rat.denominator*oldd;
	//denominator+=rat.denominator;
    }
    public void subtract(Rational rat){
	int oldn= numerator;
	int oldd=denominator;
	rat.numerator= (rat.denominator*numerator)- (oldd*rat.numerator);
	rat.denominator= rat.denominator*oldd;
	//denominator-=rat.denominator;
    }
    public int gcd() {
	int a = numerator;
	int b = denominator;
	int c = (a % b);
	while( c != 0 ) {
	    a = b;
	    b = c;
	    c = (a % b);
	} 
	return b;
    } 

    public static int gcd( int num, int den) {
	Rational r = new Rational(num,den);
	return r.gcd();
    }
    public void reduce() {
	int gcd = gcd( numerator,denominator );
	numerator= numerator / gcd ;
	denominator=denominator / gcd ;
    }
    //===================Homework 40=========================
    public int compareTo( Object r ) {
	if (r instanceof Rational){
	    Rational t = (Rational)r;//typecasting so that it can implement Comparable.java
	    if( this.numerator * t.denominator > t.numerator * this.denominator )
		return 1;
	    else if( this.numerator * t.denominator == t.numerator * this.denominator )
		return 0;
	    else
		return -1;
	}//used cross multiplying
	else{
	    throw new ClassCastException("\ncompareTo() input not a Rational");
	}//refer to first if statement... if r is not of instance Rational it returns this error. 
    }
    public boolean equals(Object x){
	boolean sameclass= false;//set the original value of this var to false
	boolean sameval= false;//sets the original value of this var to false
	if (x instanceof Rational){// if x is a Rational instance
	    sameclass= true;// set the sameclass value from false to true
	    if( this.compareTo(x)==0){// if its an instance and the compareto of x is equal to zero
		sameval= true;// sameval would become zero 
	    }
	}

	return sameval && sameclass;//true if both are true

    }
    public static void main(String[] args){
	int a = 5;
	Rational r= new Rational(4,5);
	Rational b= new Rational(8,10);
	System.out.println(r.equals(b));//true
	System.out.println(r.equals(a)); //false
	System.out.println(r.compareTo(a));//error
    }
	
}
