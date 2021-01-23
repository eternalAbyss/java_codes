package Entropy;

import java.util.*;

public class entropy {
    
    public static double log2(double N){
        double result = Math.log(N)/Math.log(2); 
        return result;
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.print("Number of variables in the system : ");
        int t = in.nextInt();
        double[] values = new double[100];
        double result = 0,sum=0,p=0;
        System.out.println("Please enter the variables one by one : ");
        for (int i=0; i<t; i++) values[i] = in.nextInt();
        for (int i=0; i<t; i++) sum += values[i];
        for (int i=0; i<t; i++){
            p = values[i]/sum;
            result += p * log2(p);
        }
        result = -result;
        System.out.println(result);
        in.close();
    }

}
