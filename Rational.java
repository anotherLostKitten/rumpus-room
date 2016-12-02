/* Kevin Bao
   APCS1 pd1
   HW36 -- Be More  Rational
   2016-11-30 */

public class Rational {
    private int n; //numerator
    private int d; //denominator

    public Rational() {
	n = 0;
	d = 1;
    }
    public Rational(int numerator , int denominator) {
	n = numerator;
	d = denominator;
	if (d == 0) { //if denominator is 0 (undefined number)
	    System.out.println("Denominator CANNOT BE 0");
	    //rational number is set to 0/1
	    n = 0;
	    d = 1;
	}
    }
    public String toString() {
	return this.n + "/" + this.d;
    }
    public double floatValue(int n , int d) {
	return (float)n/d;
    }
    public void multiply(Rational num) {
	n = this.n * num.n;
	d = this.d * num.d;
    }
    //multiply by reciprocal 
    public void divide(Rational num) {
	n = this.n * num.d;
	d = this.d * num.n;
    }
    public void add(Rational num) {
        if (this.d == num.d) { //checks if there is a common denominator
	    n = this.n + num.n;
	}
	else {
	    n = (this.n * num.d) + (num.n * this.d);
	    d = this.d * num.d;
	}
    }
    public void subtract(Rational num) {
        if (this.d == num.d) { //checks if there is a common denominator
	    n = this.n - num.n;
	}
	else {
	    n = (this.n * num.d) - (num.n * this.d);
	    d = this.d * num.d;
	}
    }
        public int gcd() {
	int a = this.n;
	int b = this.d;
	int counter = 1;
	int GCD = 1;
	while (counter <= a && counter <= b) {
	    //if counter is a common denominator(not necessarily the greatest) 
	    if ((a % counter == 0) && (b % counter == 0)) {
		//assign value of counter to GCD
		GCD = counter;
	    }
	    //increments counter
	    counter += 1;
	}
	return GCD;
    }
    public void reduce() {
	int gcd = this.gcd();
	n = n / gcd;
	d = d / gcd;
    }
    public static int gcd(int a , int b) {
	int counter = 1;
	int GCD = 1;
	while (counter <= a && counter <= b) {
	    //if counter is a common denominator(not necessarily the greatest) 
	    if ((a % counter == 0) && (b % counter == 0)) {
		//assign value of counter to GCD
		GCD = counter;
	    }
	    //increments counter
	    counter += 1;
	}
	return GCD;
    }	
    public int compareTo(Rational num) {
	//reduce rational numbers
	this.reduce(); 
	num.reduce();
	//if the two rational numbers are the same
	if (n == num.n && d == num.d) {
	    return 0;
	}
	//subtract parameter from calling number
	this.subtract(num);
	//if numerator is greater than 0, then calling number is greater than parameter
	if (n > 0) {
	    //adds back the parameter to the calling number to set calling
	    //number back to its original reduced value
	    this.add(num);
	    return 1;
	}
	//adds back the parameter to the calling number to set calling number
	//back to its original reduced value
	this.add(num);
	return -1;
    } 
    public static void main(String[] args) {
	Rational r = new Rational(2,3); 
	Rational s = new Rational(1,2);
	Rational t = new Rational(20,30);
	Rational q = new Rational(7,8);
	r.multiply(s);
	System.out.println(r);//2/6
	System.out.println(s);//1/2
	r.divide(s);
	System.out.println(r);//4/6
	System.out.println(s);//1/2
	r.add(s);
	System.out.println(r);//14/12
	System.out.println(s);//1/2
	r.subtract(s);
	System.out.println(r);//16/24
	System.out.println(s);//1/2
	System.out.println(r.gcd());//8
	r.reduce();
	System.out.println(r);//2/3
	System.out.println(r.compareTo(s));//1
	System.out.println(r.compareTo(t));//0
	System.out.println(r.compareTo(q));//-1
    }
}
    
