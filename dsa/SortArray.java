package dsa;

import java.util.Scanner;

public class SortArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter size of Array");
		int n = scanner.nextInt();
		int[] ArraySort = new int[n];
		for (int i = 0; i < n; i++) {
			ArraySort[i] = scanner.nextInt();
		}
		for (int i = 1; i < n; ++i) {
			int key = ArraySort[i];
			int j = i - 1;

			while (j >= 0 && ArraySort[j] > key) {
				ArraySort[j + 1] = ArraySort[j];
				j = j - 1;
			}
			ArraySort[j + 1] = key;
		}
		int sum = 0;
		double average = 0;
		for (int i = 0; i < n; i++) {
			sum += ArraySort[i];
		}
		average = (double) sum / n;
		System.out.print(sum);
		System.out.println("");
		System.out.print(average);
		System.out.println("");
		for (int i = 0; i < n; i++) {
			System.out.print(ArraySort[i] + " ");
		}
		scanner.close();
	}
}
