module GUIProject {
	requires java.desktop;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;

	exports hust.soict.dsai.javafx;

	opens hust.soict.dsai.swing to javafx.graphics, javafx.fxml;
	opens hust.soict.dsai.javafx to javafx.fxml;
}