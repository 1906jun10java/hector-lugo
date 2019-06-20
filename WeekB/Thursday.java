package com.revature.wednesday;

public class Thursday {
	
	public static boolean subString(String str,String str2) {
		boolean a=false;
		
		if (str2.length()>str.length()) {
			a=false;
		}
		else {
			for(int i=0;i<=(str.length()-str2.length());i++) {
				if (str2.equals(str.substring(i, i+str2.length()))) {
					a=true;
					return true;
				}
				else {
					a=false;
				}
			}
		}
		return a;
	}
	
	public static int triangle(int rows) {
		
		
		
		if(rows==1) {
			return 1;
		} 
		
		return rows+triangle(rows-1);
		
		
		
		
		
	}
}
