package com.revature.wednesday;

public class Wednesday {

	public static void main(String[] args) {

		//palandrome("tacocat");
		
		//System.out.println(recursionReverse("Test"));
		
		
		//System.out.println(palandromeRecursion("racecars"));
		
	
	}

	public static String reverse(String string) {

		String a = "";
		for (int i = string.length() - 1; i >= 0; i--) {

			a = a + string.charAt(i);

		}

		System.out.println(a);
		return a;
	}

	public static boolean palandrome(String string) {
		boolean a = false;

		if (string.length() > 1) {

			for (int i = 0; i < string.length() / 2; i++) {

				if (string.charAt(i) == string.charAt(string.length() - 1 - i)) {
					a = true;
				}

				else {
					a = false;
				}

			}

		}
		System.out.println(a);
		return a;
	}
	
	public static String recursionReverse(String string) {
		
		if(string.length()==0||string.length()==1) {
			return string;
		}
		
		String a= Character.toString(string.charAt(string.length()-1));
		return a+recursionReverse(string.substring(0, string.length()-1));
		
	}
	
	public static boolean palandromeRecursion(String string) {
		
		if(string.length()==0||string.length()==1) {
			return true;
		}
		boolean a= string.charAt(0)==string.charAt(string.length()-1);
		
		return a&&palandromeRecursion(string.substring(1, string.length()-1));
		
	
	}

}
