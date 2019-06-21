
public class Logic {
	
	
	
	

	public static boolean oppRecursion(String string) {
		char opp = 0;
		
		if (string.length() == 0 || string.length() == 1) {
			return false;
		}
		
		if(string.charAt(0)=='[') {
			opp=']';
		}
		else if(string.charAt(0)=='{') {
			opp='{';
		}
		else if(string.charAt(0)=='(') {
			opp=')';
		}
		
		
		boolean a = opp == string.charAt(string.length() - 1);

		return a || oppRecursion(string.substring(1, string.length() - 1));

	}
}
