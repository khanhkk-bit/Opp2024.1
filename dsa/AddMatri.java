package dsa;

import java.util.Scanner;

public class AddMatri {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of rows");
		int n = scanner.nextInt();
		System.out.println("Enter the number of colums");
		int m = scanner.nextInt();
		int[][] arr1 = new int[n][m];
		int[][] arr2 = new int[n][m];
		int[][] total = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr1[i][j] = scanner.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr2[i][j] = scanner.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				total[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(total[i][j] + " ");
			}
			System.out.println("");
		}
		scanner.close();
	}
}
