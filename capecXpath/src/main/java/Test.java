import java.util.Scanner;

import xpath.CapecXPath;

public class Test {
    public static void main(String[]args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("What is the title of the use case");
        String x=sc.next();
        CapecXPath.display(x);
    }
}
