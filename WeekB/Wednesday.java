package com.revature.wednesday;

public class Wednesday {

	public static void main(String[] args) {

		palandrome("tacocat");

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

}
