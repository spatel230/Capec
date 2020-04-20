package demo;
import java.util.Scanner;
import xpath.*;
public class main {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("What is the title of the use case\n");
		String x=sc.next();
		CapecXPath.display(x);
	}

}
