import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
The city of Hackerland has formed a new football club and wants to participate in the upcoming Football League of their country.
The coach is worried that they will not be able to qualify because they don’t have a famous footballer in their team. 
The assistant coach suggests that the team should buy Cristiano Ronaldo as he can single-handedly get their team qualified.

On day 1, today, the club has to pay ‘A’ HackerCoins in order to buy Ronaldo. After each passing day,
the price of buying Ronaldo becomes A times the price on the previous day. Any normal person would buy him 
on the 1st day itself as the price will be the lowest but since the coach always failed in high school Mathematics, 
he wants ‘B’ days to think before making him an offer.

As the coach doesn’t know how to calculate the price of Ronaldo on the Bth day, he has asked for your help.

Your task is to tell the price of Ronaldo on the Bth day. Since, the price can be a very large number, 
please tell him the price modulo 109 + 7.
*/
public class Solution {


	static BigInteger modulo=new BigInteger("1000000007");

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine().trim());
		int max=0;
		for (int i = 0; i < n; i++) {
			String line=scanner.nextLine();
			String[] numerbs=line.split("\\ ");
         //   System.out.println(new BigInteger(numerbs[0]).modPow(new BigInteger(numerbs[1]), modulo));
			System.out.println(expMod(new BigInteger(numerbs[0]), new BigInteger(numerbs[1])));
			
		}


	}
	static BigInteger expMod(BigInteger x,BigInteger y){
		BigInteger prev=BigInteger.valueOf(1);
		while (!(y.equals(BigInteger.valueOf(0)))) {
			if (y.testBit(0)) {
				//prev=((prev.mod(modulo)).multiply((x.mod(modulo)))).mod(modulo);
				prev=prev.multiply(x).mod(modulo);
			}			
			y=y.shiftRight(1);
			//BigInteger tmp=x.mod(modulo);
			//x=(tmp).multiply(tmp).mod(modulo);
			x=x.modPow(BigInteger.valueOf(2), modulo);
		}
		return prev;
	}

}
