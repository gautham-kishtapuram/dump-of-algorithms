package org.implementations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(70, 50, 51, 50, 0, -1, -2, 30, 10, 20, 40, 60);
		var sortedArray = mergesort(arr, 0, arr.size() - 1);
		System.out.println(sortedArray);
	}

	private static List<Integer> mergesort(List<Integer> data, int head, int tail) {
		if (head == tail) {
			List<Integer> br = new ArrayList<>(1);
			br.add(data.get(head));
			return br;
		}

		int mid = (head + tail) / 2;

		var copyOfData = new ArrayList<>(data);

		List<Integer> firstHalf = mergesort(copyOfData, head, mid);
		List<Integer> secondHalf = mergesort(copyOfData, mid + 1, tail);

		return sortGivenList(firstHalf, secondHalf);
	}

	public static List<Integer> sortGivenList(List<Integer> firstHalf, List<Integer> secondHalf) {
		int i = 0;
		int j = 0;

		List<Integer> list = new ArrayList<>(firstHalf.size() + secondHalf.size());
		while (i < firstHalf.size() && j < secondHalf.size()) {
			if (firstHalf.get(i) < secondHalf.get(j)) {
				list.add(firstHalf.get(i));
				i++;

			} else {
				list.add(secondHalf.get(j));
				j++;
			}
		}
		if (i < firstHalf.size()) {
			while (i < firstHalf.size()) {
				list.add(firstHalf.get(i));
				i++;
			}
		}
		if (j < secondHalf.size()) {
			while (j < secondHalf.size()) {
				list.add(secondHalf.get(j));
				j++;
			}
		}

		return list;
	}

}
