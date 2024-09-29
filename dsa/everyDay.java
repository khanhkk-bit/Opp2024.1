package dsa;

import java.util.Scanner;

public class everyDay {
	public static void main(String[] agrs) {
		Scanner scanner = new Scanner(System.in);
		int year = -1;
		String monthInput;
		int month = -1;
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		int[] dayInmonths = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		while (year < 0) {
			System.out.println("Vui long nhap so hop le (so khong am)");
			String yearInput = scanner.nextLine();
			try {
				year = Integer.parseInt(yearInput);
				if (year < 0) {
					System.out.println("nam nhap vao phai la mot so khong am. Vui long nhap lai.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Khong hop le. Vui long nhap nam hop le.");
			}
		}

		while (month == -1) {
			System.out.print("Nhap thang hop le de tinh toan (co the nhap bang chu day du; ba ky tu dau; bang so ) ");
			monthInput = scanner.nextLine().trim().toLowerCase();

			try {
				int monthNumber = Integer.parseInt(monthInput);
				if (monthNumber >= 1 && monthNumber <= 12) {
					month = monthNumber - 1;
					break;
				} else {
					System.out.println("So nhap vao khong hop le. Vui long nhap so trong khoang 1 den 12");
				}
			} catch (NumberFormatException e) {

				monthInput = monthInput.replace(".", "").toLowerCase();

				for (int i = 0; i < months.length; i++) {
					String monthFullName = months[i].toLowerCase();
					String monthAbbreviation = monthFullName.substring(0, 3).toLowerCase();

					if (monthInput.equals(monthFullName) || monthInput.equals(monthAbbreviation)) {
						month = i;
						break;
					}
				}

				if (month == -1) {
					System.out.println("Thang khong hop le vui long thu lai!!!");
				}
			}
		}

		// Check for leap year
		boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

		// Adjust days for February in a leap year
		if (isLeapYear && month == 1) {
			System.out.println("February " + year + " co 29 ngay (nam nhuan).");
		} else {
			System.out.println(months[month] + " " + year + " co " + dayInmonths[month] + " ngay.");
		}

		scanner.close();
	}
}
