import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
The Utopian tree goes through 2 cycles of growth every year. The first growth cycle of the tree is during the monsoon season when it doubles in height. The second growth cycle is during the summer when it increases in height by 1 meter. If a new Utopian tree sampling of height 1 meter is planted just before the onset of the monsoon season, can you find the height of the tree after N cycles?
*/
public class Solution {

	static Map<Integer, Integer> cycleValue = new HashMap<Integer, Integer>();
	static LinkedList<Integer> cyles = new LinkedList<Integer>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine().trim());
		int max=0;
		for (int i = 0; i < n; i++) {
			int value = Integer.parseInt(scanner.nextLine().trim());
			cycleValue.put(value, 0);
			cyles.add(value);
			max=value<max?max:value;
		}
		cycleValue(max);
		for (Integer cycle : cyles) {
			System.out.println(cycleValue.get(cycle));
		}

	}

	static int cycleValue(int n) {
		int value;
		if (n == 0) {
			value = 1;
		} else if (n % 2 == 0) {
			value = cycleValue(n - 1) + 1;

		} else {
			value = cycleValue(n - 1) * 2;
		}
		cycleValue.put(n, value);
		return value;
	}

}
