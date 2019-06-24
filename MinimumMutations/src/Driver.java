import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		String start="AACCGGTT";
		String end="AACAGGTA";
		
		//AAACGGTA
		String[] bank= {"AACCGGTA","AACAGGTA","AACCGGTA","AACAGGTA"};
		
		
		
		//File file =new File("newFile.txt");
		//System.out.println(file.canRead());
		
		//Scanner scan = new Scanner((file));		
		
		//System.out.println("Input the starting pattern");
		//String start=scan.next();
		//System.out.println("Input the ending pattern");
		//String end=scan.next();
		//System.out.println("Input bank length");
		/*
		while(!scan.hasNextInt()) {
			System.out.println("Invalid input");
			scan.next();
		}
		int len=scan.nextInt();
		String[] bank= new String[len];
		
		for (int i=0;i<len;i++) {
			System.out.println("Input bank pattern i="+i);
			bank[i]=scan.next();
		}
		
		scan.close();
		System.out.println(Arrays.toString(bank));
		
		System.out.println(Utility.validCheck(start, end, bank));
		*/
		//scan.close();
		//System.out.println(start);
		
		System.out.println(Utility.validCheck(start, end, bank));
	}

}
