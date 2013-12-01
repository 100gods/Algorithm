import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*

Mr. Road Runner bought a piece of land in the middle of a desert for a nominal amount. 
It turns out that the piece of land is now worth millions of dollars as it has an oil reserve under it. 
Mr. Road Runner contacts the ACME corp to set up the oil wells on his land. Setting up oil wells is a costly affair 
and the charges of setting up oil wells are as follows.

The rectangular plot bought by Mr. Road Runner is divided into r * c blocks. 
Only some blocks are suitable for setting up the oil well and these blocks have been marked. 
ACME charges nothing for building the first oil well. For every subsequent oil well built, 
the cost would be the maximum ACME distance between the new oil well and the existing oil wells.

If (x,y) is the position of the block where a new oil well is setup and (x1, y1) is the position of the block of
an existing oil well, the ACME distance is given by

max(|x-x1|, |y-y1|)
the maximum ACME distance is the maximum among all the ACME distance between existing oil wells and new wells.

If the distance of any two adjacent blocks (horizontal or vertical) is considered 1 unit, what is the
minimum cost (E) in units it takes to set up oil wells across all the marked blocks?
*/
public class Solution {

	static int golbalCost = Integer.MAX_VALUE;
	static int localCost = Integer.MAX_VALUE;
	static LinkedList<String> matrix = new LinkedList<String>();
	static LinkedList<String> minMatrix = new LinkedList<String>();
	static LinkedList<String> copyMatrix = new LinkedList<String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		String line = (scanner.nextLine().trim());
		int i, j;
		String[] num = line.split("\\ ");
		i = Integer.parseInt(num[0]);
		j = Integer.parseInt(num[1]);
        if (j <=0) {
			System.out.println(0);
			System.exit(-1);
		}
		String tmp = null;
		for (int k = 1; k <= i; k++) {
			line = scanner.nextLine();
			num = line.split("\\ ");
			for (int k2 = 1; k2 <= j; k2++) {
				if (Integer.parseInt(num[k2 - 1]) == 1) {
					tmp = k + "-" + k2;
					matrix.add(tmp);
				}

			}
		}
		Iterator<String> iterator = matrix.descendingIterator();
		while (iterator.hasNext()) {
			copyMatrix.removeAll(matrix);
			minMatrix = new LinkedList<String>();
			String map = iterator.next();
			minMatrix.add(map);
			copyMatrix.addAll(matrix);
			copyMatrix.remove(map);
			localCost = 0;
			min();
		//	System.out.println(localCost + " for selected matrix=" + minMatrix);
			golbalCost = localCost < golbalCost ? localCost : golbalCost;

		}
		System.out.println(golbalCost);

	}

	static boolean min() {
		if (copyMatrix.isEmpty() ) {
			return true;
		} else {
			String nextSelected = new String();
			int includeMin = Integer.MAX_VALUE;
			for (String copy : copyMatrix) {
				//String map : minMatrix
				int maxCostOfNext=Integer.MIN_VALUE;
				for (String map : minMatrix) { //String copy : copyMatrix
					int value = Math.max(
							Math.abs(Integer.parseInt(map.split("\\-")[0])
									- Integer.parseInt(copy.split("\\-")[0])),
							Math.abs(Integer.parseInt(map.split("\\-")[1])
									- Integer.parseInt(copy.split("\\-")[1])));
					if (value >= maxCostOfNext) {
						maxCostOfNext = value;
					}
				}
				// check with other nextNodes
				if(maxCostOfNext < includeMin){
					nextSelected=copy;
					includeMin=maxCostOfNext;
				}

			}
			minMatrix.add(nextSelected);
			localCost += includeMin;
			copyMatrix.remove(nextSelected);
			if (localCost > golbalCost) {
				return false;
			}
			min();
			return false;
		}

	}



}
