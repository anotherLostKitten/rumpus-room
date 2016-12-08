//Tiffany Moi
//APCS1 pd5
//HW40 -- Rational Equality
//2016-12-6

//uses some methods in Comparable
public class Rational implements Comparable{
    private int p;
    private int q;
    //initializing
    public Rational(){
	p=0;
	q=1;
    }
    /*overloaded constructor that allows the user to set the numerator and 
      denominator. Also checks for division by zero.*/
    
    public Rational(int P, int Q){
	this();
	if (Q==0){
	    System.out.println("Error: division by zero");
	}
	else {
	    q=Q;
	    p=P;
	}
    }
    public String toString(){
	return p + "/" + q;
    }
    public double floatValue(){
	return (p*1.0)/(q*1.0);
    }
    public void multiply(Rational x){
	int num = x.p;
	int den = x.q;
	p = num * p;
	q = den * q;
    }
    public void divide(Rational x){
	int num = x.p;
	int den = x.q;
	p = p / num;
	q = q / den;
    }
    public void add(Rational x){
	int num = x.p;
	int den = x.q;
	p = (p * den) + (num * q);
	q = q * den;
    }
    public void subtract(Rational x){
	int num = x.p;
	int den = x.q;
	p = (p * den) - (num * q);
	q = q * den;
    }
    
    public int gcd(){
	int a = p;
	int b = q;
        int retint=1;
        int x=1;
        while (x < (Math.min(a,b))){
            x+=1;
            if (a%x == 0 && b%x == 0) {
                retint=x;
            }
        }
        return retint;
    }
    public void reduce(){
	p = p / gcd();
	q = q / gcd();
    }
    public static int statGcd(int a, int b){
        int retint=1;
        int x=1;
        while (x < (Math.min(a,b))){
            x+=1;
            if (a%x == 0 && b%x == 0) {
                retint=x;
            }
        }
        return retint;
    }
    
    /* compareTo: Takes an Object and typecasts it to a Rational in order to 
       comare values. Throws an exception when the Object is not a Rational.
       (Note: you don't want to use a try catch block here because it will only
       cause more errors with the return type.*/
    
    public int compareTo(Object x){
	if (x instanceof Rational){
	    Rational l = (Rational) x;
	    int a = l.p;
	    int b = l.q;
	    int c = p;
	    int d = q;
	    if (a*d == b*c){
		return 0;
	    }
	    else if (a*d > b*c){
		return 1;
	    }
	    return -1;
	}
	else{
	    throw new ClassCastException("\ncompareTo() input not a Rational");
	}
    }
    
    // equals: uses compareTo(Obejct) to check for the same value and same class

    public boolean equals(Object x){
	return this.compareTo(x) == 0;
    }
    
    public static void main(String[] args){
	Rational r = new Rational(2,3); //Stores the rational number 2/3
	Rational s = new Rational(1,2); //Stores the rational number 1/2
	Rational t = new Rational(4,6); //Stores the rational number 4/18
	Object x = new Object();
	
	/* the try catch blocks here tell me exactly which examples are
	   producing errors and will tell me what is the issue.*/
	
	try {
	    System.out.println(r.compareTo(s));
	}
	catch(ClassCastException e){
	    System.out.println("You didn't give me a Rational!!");
	}
	try {
	    System.out.println(r.compareTo(x));
	}
	catch(ClassCastException e){
	    System.out.println("You didn't give me a Rational!!");
	}
	try {
	    System.out.println(r.equals(s));
	}
	catch(ClassCastException e){
	    System.out.println("You didn't give me a Rational!!");
	}
	try {
	    System.out.println(r.equals(x));	
	}
	catch(ClassCastException e){
	    System.out.println("You didn't give me a Rational!!");
	}
    }
}
