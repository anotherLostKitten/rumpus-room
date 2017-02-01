/*
Datian Zhang
APCS2 pd1
HW00 -- Warm It Up
2017-02-01
*/

// Did testing on codingbat so no test cases.

public class Recursion{
    public int factorial(int n) {
	if(n == 1){
	    return 1;
	}
	return factorial(n-1) * n;
    }
  public int bunnyEars(int bunnies) {
	if(bunnies == 0 ){
	    return 0;
	}
	return 2 + bunnyEars(bunnies-1);
  }
    public int fibonacci(int n) {
	if(n == 0){
	    return 0;
	}
	if(n == 1){
	    return 1;
	}
	return fibonacci(n-1) + fibonacci(n-2);
	// assuming non-negative parameters
    }
  public int bunnyEars2(int bunnies) {
      // base case first 
      if(bunnies == 0 ){
	  return 0;
      }
      if(bunnies % 2 == 1){
	  return 2 + bunnyEars2(bunnies-1);
      }
      else{ // if not odd then even
	  return 3 + bunnyEars2(bunnies-1);
      }
  }
    
}

