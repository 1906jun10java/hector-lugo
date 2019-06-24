
public class Driver {

	public static void main(String[] args) {
		String start="AACCGGTT";
		String end="AAACGGTA";
		
		//AAACGGTA
		String[] bank= {"AACCGGTA","AACCGCTA","AACCGGTA"};
		
		System.out.println(Utility.validCheck(start, end, bank));
		
	}

}
