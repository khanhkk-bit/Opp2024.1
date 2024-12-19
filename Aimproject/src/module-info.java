/**
 * 
 */
/**
 * 
 */
module Aimproject {
	requires java.desktop;
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.swing;
	requires javafx.graphics;

	exports hust.soict.dsai.aims.screen;

	opens hust.soict.dsai.aims.screen to javafx.fxml;
}