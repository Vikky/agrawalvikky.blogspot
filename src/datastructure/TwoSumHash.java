/**
 * TwoSumHash.java
 *
 */
package datastructure;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author vikky.agrawal
 *
 */
public class TwoSumHash {

	Set<Long> valueSet;
	static int count = 0;

	public static void main(String[] args) {
		TwoSumHash obj = new TwoSumHash();
		obj.initialize();

	}

	public void initialize() {

		valueSet = new HashSet<Long>();
		try {
			readLargerTextFile("/Users/viagrawal/learning/algo1-programming_prob-2sum.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		double starttime = System.currentTimeMillis();
		for (long i = -10000; i <= 10000; i++) {
			findTwoSum(valueSet, i);
		}
		// findTwoSum(valueSet, 9965l);
		System.out.println("Total pairs : " + count);
		double endtime = System.currentTimeMillis();
		System.out.println("Total time :" + (endtime - starttime));
	}

	void readLargerTextFile(String aFileName) throws IOException {
		Path path = Paths.get(aFileName);

		try (Scanner scanner = new Scanner(path)) {
			while (scanner.hasNextLong()) {
				Long value = scanner.nextLong();
				valueSet.add(value);
			}
		}
	}

	public void findTwoSum(Set<Long> inputArray, Long sum) {

		Iterator<Long> loopIterator = inputArray.iterator();
		while (loopIterator.hasNext()) {
			Long value = loopIterator.next();
			Long subtractValue = sum - value;

			if (valueSet.remove(subtractValue)) {
				count++;
				/*
				 * System.out.println("For sum : " + sum + " Found a pair : [" +
				 * value + "," + subtractValue + " ]");
				 */
				break;
			}
		}

	}

}
