import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		String start="AACCGGTT";
		String end="AACAGGTA";
		
		//AAACGGTA
		String[] bank= {"AACCGGTA","AACAGGTA","AACCGGTA","AACAGGTA"};
		
		
		
		
		System.out.println(Utility.validCheck(start, end, bank));
	}

}
