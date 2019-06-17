package com.revature.weekAChallenge;

public class FizzBuzz {

	boolean a;
	String b="";
	public void fizzBuzzBasic() {
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("FizzBuzz");
			} 
			else if (i % 3 == 0) {
				System.out.println("Fizz");
			} 
			else if (i % 5 == 0) {
				System.out.println("Buzz");
			}
			else {
				System.out.println(i);
			}
		}
	}
	
	
	public void fizzBuzzAdvanced(int m, int n, int[] numbers, String[] terms) {
		if(m>n) {
			System.out.println("Not valid perameter range. The order of perameters will be"
					+ " reversed");
			int x=m;
			m=n;
			n=x;
		}
		for (int i=m;i<=n;i++) {
			for (int j=0; j < numbers.length; j++) {
				if(i%numbers[j]==0) {
					a=true;
					
					b=b+terms[j];
					
					}
					
				}
			if(!a) {
				System.out.println(i);
				a=false;
			}
			if(a) {
				System.out.println(b);
				b="";
				
				a=false;
			}
				
			}
		}	
	}
		
	
	
	


