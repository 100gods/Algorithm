import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Isaac has to buy a new HackerPhone for his girlfriend Amy. 
He is exploring the shops in the town to compare the prices whereupon he finds a shop located on the first floor of a building, 
that has a unique pricing policy. There are N steps leading to the shop. A numbered ball is placed on each of the steps.
The shopkeeper gives Isaac a fair coin and asks him to toss the coin before climbing each step.
If the result of the toss is a ‘Heads’, Isaac should pick up the ball, else leave it and proceed to the next step.
The shopkeeper then asks Isaac to find the sum of all the numbers he has picked up (let’s say S). 
The price of the HackerPhone is then the expected value of S. Help Isaac find the price of the HackerPhone.
*/
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine().trim());
		int max=0;
		for (int i = 0; i < n; i++) {
			int value = Integer.parseInt(scanner.nextLine().trim());
			max+=value;
		}
		DecimalFormat format=new DecimalFormat(".#");
		System.out.println(format.format(max/2.0));

	
    }
}
