package Basic;

import java.util.*;

class basic_program {
    public static void main(String args[]) {
       Scanner in = new Scanner(System.in);
       System.out.print("Enter your age : ");
       int age = in.nextInt();
       if (age>=18) {
           System.out.println("You are of legal age! ");
       } else {
           System.out.println("You are not of legal age yet!");
       }
       in.close();
    }
}