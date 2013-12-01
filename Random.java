import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Given an array ‘D’ with n elements: d[0], d[1], …, d[n-1], 
you can perform the following two steps on the array.
1. Randomly choose two indexes (l, r) with l < r, swap (d[l], d[r]) 
2. Randomly choose two indexes (l, r) with l < r, reverse (d[l…r]) (both inclusive)

After you perform the first operation a times and the second operation b times, 
you randomly choose two indices l & r with l < r and calculate the S = sum(d[l…r]) (both inclusive).

Now, you are to find the expected value of S.
*/
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
	Scanner scanner=new Scanner(System.in);
	String line=scanner.nextLine();
	int n=Integer.parseInt(line.split("\\ ")[0]);
	line=scanner.nextLine();
	String[] arrayvalue=line.split("\\ ");
	int count=0;
	int sum=0;
	for (int i = 1; i < n; i++) {
	    for (int j = 0; j < i; j++) {
		count+=1;
		for (int j2 = j; j2 <=i; j2++) {
		    sum+=Integer.parseInt(arrayvalue[j2]);
		}
		
	    }
	}
	System.out.print(sum*1.0/count);

    
    }
}
