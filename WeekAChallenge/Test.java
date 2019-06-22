package com.revature.weekAChallenge;



import java.util.Scanner;



public class Test {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FizzBuzz f=new FizzBuzz();
		f.fizzBuzzBasic();
		
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Give me an int for the min range, fam");
		while (!scan.hasNextInt()) {
			System.out.println("Not valid");
			scan.next();
		}
		int a= scan.nextInt();
		
		System.out.println("Give me the max range");
		while (!scan.hasNextInt()) {
			System.out.println("Not valid");
			scan.next();
		}
		int b=scan.nextInt();
		
		System.out.println("How many elements do you want in your arrays? Type an int");
		while (!scan.hasNextInt()) {
			System.out.println("Not valid");
			scan.next();
		}
		int c=scan.nextInt();
		
		int[] newList=new int[c];
		
		for (int i=0;i<c;i++) {
			System.out.println("Type an int");
			while (!scan.hasNextInt()) {
				System.out.println("Not valid");
				scan.next();
			}
			int d=scan.nextInt();
			newList[i]=d;
		}
		String[] stringList=new String[c];
		for (int i=0;i<c;i++) {
			System.out.println("Type the string you want to use, lol. Must type the same number"
					+ " of strings as input integers,lol");
			String e=scan.next();
			stringList[i]=e;
		}
		
		scan.close();
		
		
		
		
		
		
		f.fizzBuzzAdvanced(a,b,newList,stringList);
	}

}
