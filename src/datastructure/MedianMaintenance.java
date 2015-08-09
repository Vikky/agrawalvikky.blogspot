/**
 * MedianMaintenance.java
 *
 */
package datastructure;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author vikky.agrawal
 *
 */
public class MedianMaintenance {

	PriorityQueue<Integer> inputArray;
	List<Integer> inputList;
	List<Integer> medianList;

	public static void main(String[] args) {
		MedianMaintenance obj = new MedianMaintenance();
		obj.initialize();
	}

	public void initialize() {
		inputArray = new PriorityQueue<Integer>();
		inputList = new ArrayList<Integer>();
		medianList = new ArrayList<Integer>();

		try {
			readLargerTextFile("/Users/viagrawal/learning/Median.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		long modulo = 0;
		Iterator<Integer> listIterator = medianList.iterator();
		while (listIterator.hasNext()) {
			modulo = modulo + listIterator.next();
		}
		System.out.println("Twosum : " +(100390/2));
		System.out.println("modulo : " + modulo + " % 10000 = "
				+ (modulo % 10000));

	}

	void readLargerTextFile(String aFileName) throws IOException {
		Path path = Paths.get(aFileName);

		try (Scanner scanner = new Scanner(path)) {

			while (scanner.hasNextInt()) {
				int value = scanner.nextInt();
				inputList.add(value);
				Collections.sort(inputList);
				int size = inputList.size();

				if (size % 2 != 0 || size == 0) {
					medianList.add(inputList.get(size / 2));
				} else {
					medianList.add(inputList.get((size / 2) - 1));
				}
			}
		}
	}

}
