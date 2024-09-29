package dsa;

import java.util.Scanner;

public class Triangle {
	public static void main(String[] agrs) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the height of the triangle: ");
		int n = scanner.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= (2 * i - 1); k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		scanner.close();
	}
}
