import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
You are given a square grid of size N, with rows numbered from 0 to N - 1 
starting from the top and columns numbered from 0 to N - 1 starting from the left.

A cell (u, v) refers to the cell that is on the uth row and the vth column.
Each cell contains an integer - 0 or 1. You can pick any cell and flip the number 
in all the cells (including the picked cell) within the Manhattan distance D from the picked cell.
A flip here means changing the number from 0 to 1 and vice-versa. The manhattan distance from the cell (u, v) 
to the cell (x, y) is equal to |u - x| + |v - y| where |i| is the absolute value of i.

Your mission is to change all values in the grid to zero without using more than N×N flips.
*/
public class Solution {

	static int count = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean digFlag=true;
		int countZero=0;
		String line = scanner.nextLine().trim();
		String words[] = line.split("\\ ");
		int n = Integer.parseInt(words[0]);
		int d = Integer.parseInt(words[1]);
		int[][] matrix = new int[n][n];
		int tmp = 0;
		for (int i = 0; i < n; i++) {
			line = scanner.nextLine().trim();
			words = line.split("\\ ");
			for (int j = 0; j < n; j++) {
				tmp = Integer.parseInt(words[j]);
				if (tmp == 1)
				{
					if ((i+j)==(n-1)) {
						count++;
					}else{
						digFlag=false;
					}
					
				}else{
					countZero++;
				}
					
				matrix[i][j] = tmp;
			}
		}
		if (digFlag && count == n) {
			System.out.println("Possible" + "\n"+n);
			if (matrix[0][0]==1) {
				for (int i = 0; i < matrix.length; i++) {
					for (int j = 0; j < matrix.length; j++) {
						if ((i+j)==(n-1)) {
							System.out.println(i+" "+j);
						}
						
					}
				}
			}else{
				for (int i = 0; i < matrix.length; i++) {
					for (int j = n-1; j >=0; j--) {
						if ((i+j)==(n-1)) {
							System.out.println(i+" "+j);
						}
					}
				}
			}
			System.exit(1);
		}
		if (countZero == n*n) {
			System.out.println("Possible" + "\n0");
			System.exit(1);
		}
		// slove
		int factor = 0;
		int op = 0;
		int flip=0;
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < matrix.length; i++) {
			factor = 0;
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] == 1) {
					factor += 1;
					// find all elem at dis=D . If 0 factor -1 if 1 factor 1
					for (int j2 = 1; j2 <= d; j2++) {

						if (i - j2 >= 0) {
							factor += matrix[i - j2][j] == 1 ? 1 : -1;
							for (int k = 1; k <=d - j2; k++) {
								if (j - k >= 0) {
									factor+= matrix[i - j2][j
											- k] == 1 ? 1 : -1;
								}
								if (j + k < n) {
									factor+= matrix[i - j2][j
											+ k] == 1 ? 1 : -1;
								}
							}
						}
						if (i + j2 < n) {
							factor += matrix[i + j2][j] == 1 ? 1 : -1;
							// right left or left
							for (int k = 1; k <= d - j2; k++) {
								if (j - k >= 0) {
									factor+= matrix[i + j2][j
											- k] == 1 ? 1 :- 1;
								}
								if (j + k < n) {
									factor+= matrix[i + j2][j
											+ k] == 1 ? 1: -1;
								}
							}
						}
						// System.out.println(j + j2 < n);
						if (j - j2 >= 0) {
							factor += matrix[i][j - j2] == 1 ? 1 : -1;
						}
						if (j + j2 < n) {
							// System.out.println("here");
							factor += matrix[i][j + j2] == 1 ? 1 : -1;
						}
					}
					if (factor > 0) {
						// flip
						for (int j2 = 1; j2 <= d; j2++) {
							if (i - j2 >= 0) {
								matrix[i - j2][j] = matrix[i - j2][j] == 1 ? 0
										: 1;
								flip++;
								for (int k = 1; k <= d - j2; k++) {
									if (j - k >= 0) {
										matrix[i - j2][j - k] = matrix[i - j2][j
												- k] == 1 ? 0 : 1;
										flip++;
									}
									if (j + k < n) {
										matrix[i - j2][j + k] = matrix[i - j2][j
												+ k] == 1 ? 0 : 1;
										flip++;
									}
								}
							}
							if (i + j2 < n) {

								matrix[i + j2][j] = matrix[i + j2][j] == 1 ? 0
										: 1;
								flip++;
								// right left or left
								for (int k = 1; k <=d - j2; k++) {
									if (j - k >= 0) {
										matrix[i + j2][j - k] = matrix[i + j2][j
												- k] == 1 ? 0 : 1;
										flip++;
									}
									if (j + k < n) {
										matrix[i + j2][j + k] = matrix[i + j2][j
												+ k] == 1 ? 0 : 1;
										flip++;
									}
								}
							}
							if (j - j2 >= 0) {
								matrix[i][j - j2] = matrix[i][j - j2] == 1 ? 0
										: 1;
								flip++;
							}
							if (j + j2 < n) {
								matrix[i][j + j2] = matrix[i][j + j2] == 1 ? 0
										: 1;
								flip++;
							}
						}
						matrix[i][j] = 0;
						flip++;
						op++;
						ans.append(i + " " + j + "\n");
						count--;
					}
				}

			}
		}
		if (flip > n*n) {
			System.out.println("Impossible");
			System.exit(0);
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] == 1) {
					System.out.println("Impossible");
					System.exit(0);
				}
			}
		}
		ans=ans.replace(ans.length()-1, ans.length(), "");
		System.out.println("Possible");
		System.out.println(op);
		System.out.println(ans);

	}




}
