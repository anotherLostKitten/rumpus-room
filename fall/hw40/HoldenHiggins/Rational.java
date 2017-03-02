/*
Holden Higgins
APCS1 pd3
HW37 -- Be More Rational
2016-12-01
*/

public class Rational implements Comparable{
    private int numer;
    private int denom;
    
    //default constructor
    public Rational(){
	numer=0;
	denom=1;
    }
    //overloaded constructor
    public Rational(int n, int d){
	numer=n;
	if(d==0){
	    denom=1;
	    System.out.println("Invalid denominator. Denominator set to 1");
	}
	else{ 
	    denom=d;
	}
    }
    
    public String toString(){
	return numer+"/"+denom;
    }
    
    public float floatValue(){
	return (float)(1.0*numer/denom);
    }
    
    public void multiply(Rational r){
	numer*=r.numer;
	denom*=r.denom;
    }
//fractional division is the same as multiplying by the inverse
    public void divide(Rational r){
	if(r.numer==0){
	    int x=1/0;
	}
	numer*=r.denom;
	denom*=r.numer;
    }
//addition puts numbers over a common denominator before adding
    public void add(Rational r){
	int a=denom;
	numer*=r.denom;
	denom*=r.denom;
	numer+=r.numer*a;
    }
//same concept as adding
    public void subtract(Rational r){
	int a=denom;
	numer*=r.denom;
	denom*=r.denom;
	numer-=r.numer*a;
    }
//just a wrapper function to call the static elucidian gcd
    public int gcd(){
	return gcdER(Math.abs(numer), Math.abs(denom));
    }
    public static int gcdER(int a, int b){
	int x = Math.max(a,b);
	int y = Math.min(a,b); // easier to work with and recurse
	if (x%y==0){
	    return y;
	}
	else {
	    return gcdER(x-y,y);
	}
    }

    public void reduce(){
	int gcd=gcd();
	numer/=gcd;
	denom/=gcd;
    }
//returns positive when local is greater than r, 0 when equal, neg when less than r

//==============================================================
//HW40 section

    
    public int compareTo(Object a){
	Rational r=(Rational)a;
	return (numer*r.denom)-(r.numer*denom);
    }

    public boolean equals(Object a){
	Rational r;
	if(a instanceof Rational){
	    r=(Rational)a;
	}
	else{
	    return false;
	}
	return compareTo(r)==0;
	
    }
//==============================================================    
    //test cases
    public static void main(String[] args){
	Rational foo=new Rational(1,2);
	Rational boo=new Rational(1,2);
	Rational woo=new Rational(2,4);
	System.out.println(foo.equals(boo));//t
	System.out.println(foo.equals(foo));//t
	System.out.println(foo.equals(woo));//f
	System.out.println(woo.equals(foo));//f
    }
}
