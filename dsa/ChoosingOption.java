package dsa;

import javax.swing.JOptionPane;

public class ChoosingOption {
	public static void main(String[] ars) {
		int option = JOptionPane.showConfirmDialog(null, "Do your want to change to the first class ticket?");
		JOptionPane.showMessageDialog(null, "You've chosen: " + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
		System.exit(0);
	}
}
