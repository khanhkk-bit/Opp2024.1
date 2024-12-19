package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddBookController {
	@FXML
	private TextField nameField;

	@FXML
	private TextField categoryField;

	@FXML
	private TextField authorsField;

	@FXML
	private TextField costField;

	private Store store;

	public AddBookController(Store store) {
		this.store = store;
	}

	@FXML
	private void handleAddBook() {
		String name = nameField.getText();
		String category = categoryField.getText();
		String authors = authorsField.getText();
		String costText = costField.getText();

		if (name.isEmpty() || category.isEmpty() || authors.isEmpty() || costText.isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Please fill in all fields.");
			alert.showAndWait();
			return;
		}

		try {
			int id = store.getItemsInStore().size();
			float cost = Float.parseFloat(costText);
			Book book = new Book(name, category, cost);
			store.addMedia(book);
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText("Book added successfully.");
			alert.showAndWait();

			// Close the window after adding the book
			Stage stage = (Stage) nameField.getScene().getWindow();
			stage.close();
		} catch (NumberFormatException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Invalid cost value.");
			alert.showAndWait();
		}
	}
}
