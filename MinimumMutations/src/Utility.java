
public class Utility {
	
	public static int validCheck(String s,String e,String[] b) {
		
		if(s==e) {
			return 0;
		}
		for (int i=0;i<b.length;i++) {
			int counter=0;
			b[i]=b[i].replaceAll("([^ACGT])", "");
			if(s.length()!=b[i].length()) {
				return -1;
			}
			
			if (s.length()!=e.length()) {
				return -1;
			}
			
			for(int j=0;j<s.length();j++) {
				if(i==0) {
					
					
					if(s.charAt(j)!=b[i].charAt(j)) {
						counter++;
						System.out.println("is b[0] valid?"+counter+" "+i+" "+j);
					}
				}
				else if(i>0) {
					
					if(b[i-1].charAt(j)!=b[i].charAt(j)) {
						counter++;
						System.out.println("is b[i] valid?"+counter+" "+"i="+i+" "+"j="+j);
					}
				}
			}
			if (counter>1) {
				return -1;
			}
		}
		
		return b.length-1;
	
	}
	
	
	
	

}
