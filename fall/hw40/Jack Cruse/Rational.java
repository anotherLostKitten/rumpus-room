/*
Jack Cruse
APCS pd4
HW40 -- Rational Equality
2016-12-6
*/

public class Rational implements Comparable {
    int p;
    int q;

    /*
      PRE: none
      POST: a new Object Rational with value 0/1 is created
    */
    public Rational() {
	p = 0;
	q = 1;
    }
    
    /*
      PRE: n and d are integers
      POST: a new Object Rational with value n/d is created
    */
    public Rational(int n, int d) {
	if (d == 0) {
	    System.out.println("Zero is not allowed in the denominator\nValue was set to 0/1");
	    p = 0;
	    q = 1;
	}
	else {
	    p = n;
	    q = d;
	}
    }//end overloaded constructor

    /*
      PRE: none
      POST: returns a String of the fractional value of the Rational
    */    
    public String toString() {
	return p + "/" + q;
    }

    /*
      PRE: q is not 0
      POST: returns float value of Rational
    */        
    public double floatValue() {
	return (p * 1.0) / q;
    }

    /*
      PRE: a is a Rational, q is not 0
      POST: Rational calling multiply is multiplied by Rational a
      Rational a is not modified
    */    
    public void multiply(Rational a) {
	p *= a.p;
	q *= a.q;
    }
    
    /*
      PRE: a is a Rational, q is not 0
      POST: Rational calling divide is divided by Rational a
      Rational a is not modified
    */    
    public void divide(Rational a) {
	if (a.p == 0) {
	    System.out.println("Cannot divide by 0");
	}
	else {
	    p *= a.q;
	    q *= a.p;
	}
    }

    /*    public void sameD(Rational a) {
	int c = q;
	p *= a.q;
	q *= a.q;
	a.p *= c;
	a.q *= c;
    }
Realized how extra this function was
    */
    
    /*
      PRE: a.q != 0 && q != 00, a is a rational
      POST: rational calling function is increased by a
    */    
    public void add(Rational a) {
	p = (p * a.q) + (a.p * q);
	q *= a.q;
    }

    /*
      PRE: a.q != 0 && q != 00, a is a rational
      POST: rational calling function is decreased by a
    */    
    public void substract(Rational a) {
	p = (p * a.q) - (a.p * q);
	q *= a.q;
    }

    public static int gcdER(int a, int b) {
	/*	if (b > a) {//same reversal technique as in gcd
	    int c = b;
	    b = a;
	    a = c;
	    } this be extra too*/
	
	int c = a % b;//init var q to implement in algorithm, new q will be generated upon each iteration
	
	if (c == 0) {//checks if current b is gcd
	    return b;
	}
	
	return gcdER(b, c);//if q != 0 run through func again with b as a, q as b
    }

    public int gcd() {
	return gcdER(q, p);
    }

    public void reduce() {
	int g = this.gcd();
	p /= g;
	q /= g;
    }

    /*
      Takes a Rational as input and compares it
      to Rational calling the function. Returns -1
      if Rational calling the function is less
      than the one inputted to the function, 0 if 
      equal, and 1 if greater. Throws an error if 
      the input is not a Rationl
    */
    public int compareTo(Object aa) {
	if (!(aa instanceof Rational)) {
	    throw new ClassCastException("\ncompareTo() input not a Rational");
	}
	
	Rational a = (Rational) aa;//typecast Object to Rational
	if ((p * a.q) == (a.p * q)) {
	    return 0;
	}
	else if ((p * a.q) > (a.p * q)) {
	    return 1;
	}
	else {
	    return -1;
	}
    }

    /*
      Takes a Rational as input and checks if it
      is equal to the Rational calling the function. Calls
      function comapreTo() and sees if it returns 0 
      which means the two fractions have equal value.
      Throws an error if given anything other than 
      a Rational.
    */
    public boolean equals(Object aa) {
	return (this.compareTo(aa) == 0);
    }
   
    
	
	

    public static void main(String[] args) {
	System.out.println("####################################");
	Rational a = new Rational();
	System.out.println(a);
	System.out.println(a.floatValue());
	System.out.println(a.p);
	System.out.println(a.q);
	
	System.out.println("####################################");
	Rational b = new Rational(5, 0);
	System.out.println(b);
	System.out.println(b.floatValue());
	System.out.println(b.p);
	System.out.println(b.q);

	System.out.println("####################################");
	Rational c = new Rational(1, 2);
	System.out.println(c);
	System.out.println(c.floatValue());
	System.out.println(c.p);
	System.out.println(c.q);

	System.out.println("####################################");
	System.out.println(b);
	System.out.println(c);
	b.multiply(c);
	System.out.println(b);
	System.out.println(c);
	c.divide(b);
	System.out.println(b);
	System.out.println(c);

	System.out.println("####################################");
	Rational d = new Rational(2, 3);
	System.out.println(d);
	System.out.println(d.floatValue());
	System.out.println(d.p);
	System.out.println(d.q);

	System.out.println("####################################");
	System.out.println(c);
	System.out.println(d);
	c.multiply(d);
	System.out.println(c);
	System.out.println(d);	
	c.divide(d);
	System.out.println(c);
	System.out.println(d);

	System.out.println("####################################");
	System.out.println(4 % 9);
	System.out.println(9 % 4);
	
	System.out.println("####################################");
	Rational l = new Rational(2,4);
	Rational lI = new Rational(4,2);
	Rational m = new Rational(64,48);
	Rational mI = new Rational(48,64);
	Rational n = new Rational(-2,3);
	Rational nI = new Rational(3,-2);
	Rational o = new Rational(-2,-3);
	Rational oI = new Rational(-3,-2);
	Rational p = new Rational(4,8);
	Rational pI = new Rational(8,4);
	System.out.println(l.gcd());
	System.out.println(lI.gcd());
	System.out.println(m.gcd());
	System.out.println(mI.gcd());
	System.out.println(n.gcd());
	System.out.println(nI.gcd());
	System.out.println(o.gcd());
	System.out.println(oI.gcd());
	System.out.println(l);
	System.out.println(lI);
	System.out.println(m);
	System.out.println(mI);
	l.reduce();
	lI.reduce();
	m.reduce();
	mI.reduce();
	System.out.println(l);
	System.out.println(lI);
	System.out.println(m);
	System.out.println(mI);
	System.out.println("####################################");
	Object aa = new Object();
	System.out.println(l.compareTo(lI));
	System.out.println(l.compareTo(l));
	System.out.println(l.compareTo(m));
	System.out.println(l.compareTo(mI));
	System.out.println(m.compareTo(l));
	//	System.out.println(l.equals(aa));

	System.out.println("####################################");
	System.out.println(l.equals(lI));
	System.out.println(l.equals(l));
	System.out.println(l.equals(m));
	System.out.println(l.equals(mI));
	System.out.println(m.equals(l));
	//System.out.println(l.equals(aa));
	
	
	
	
    }//end main
	
	


	

}//end class rational

    
