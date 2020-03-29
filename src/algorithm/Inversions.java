package algorithm;

import utils.ResourcesReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Inversions {

	private static final String FILE_PATH = "/algo1/input.txt";

	public static void main(String[] args) {
		ArrayList<Long> input = new ArrayList<>();
		BufferedReader reader;
		ResourcesReader resourcesReader = new ResourcesReader();
		try {
			reader = resourcesReader.readFile(FILE_PATH);
			String line = reader.readLine();
			while (line != null) {
				input.add(Long.parseLong(line));
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		SortedArray result = countInversions(input);

		System.out.println("Sorted array: " + result.getSortedList());
		System.out.println(isSorted(result.getSortedList()));
		System.out.println(result.getSortedList().size());
		System.out.println(input.size());
		System.out.println("Inversions: " + result.getInversionsNumber());
	}

	private static SortedArray countInversions(ArrayList<Long> input) {
//		input.stream().forEach(System.out::println);
//		System.out.println(input.size());
		int n = input.size();

		if(n<=1) {
			return new SortedArray(input,0L);
		}
		else {
			int splitIndex = Math.max(n/2,0);
			SortedArray left = countInversions((new ArrayList<>(input.subList(0,splitIndex))));
			SortedArray right = countInversions(new ArrayList<>(input.subList(splitIndex,n)));
			SortedArray all = mergeAndCountSplitInv(left, right);

			return new SortedArray(all.getSortedList(),
					left.getInversionsNumber() + right.getInversionsNumber() + all.getInversionsNumber());
		}
	}

	private static SortedArray mergeAndCountSplitInv(SortedArray left, SortedArray right) {
		Long inversions = 0L;
		ArrayList<Long> sortedList = new ArrayList<Long>();
		int leftLeftSize = left.getSortedList().size();
		int rightLeftSize = right.getSortedList().size();

		int sortedListSize =  leftLeftSize + rightLeftSize;

		int i = 0;
		int j = 0;

		for(int k=0; k<sortedListSize; k++) {

			if(!isInInRange(i, left)) {
				sortedList.add(right.getSortedList().get(j));
				j++;
			} else if(!isInInRange(j, right)) {
				sortedList.add(left.getSortedList().get(i));
				i++;
			}
			else {
				if (left.getSortedList().get(i) < right.getSortedList().get(j)) {
					sortedList.add(left.getSortedList().get(i));
					i++;
					leftLeftSize -= 1;
				} else {
					sortedList.add(right.getSortedList().get(j));
					j++;
					rightLeftSize -= 1;
					inversions = inversions + leftLeftSize;
				}
			}
		}
		return new SortedArray(sortedList, inversions);
	}

	private static boolean isInInRange(int index, SortedArray array) {
		return array.getSortedList().size()-1 >= index;
	}

	public static <T extends Comparable<? super T>>
	boolean isSorted(Iterable<T> iterable) {
		Iterator<T> iter = iterable.iterator();
		if (!iter.hasNext()) {
			return true;
		}
		T t = iter.next();
		while (iter.hasNext()) {
			T t2 = iter.next();
			if (t.compareTo(t2) > 0) {
				return false;
			}
			t = t2;
		}
		return true;
	}

}