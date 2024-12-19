package hust.soict.dsai.aims.screen;

import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionEvent;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;

public class ItemController {
	@FXML
	private Node btnAddToCart;

	@FXML
	private Button btnPlay;

	@FXML
	private Label lblTitle;

	@FXML
	private Label lblCost;

	private Media media;
	private Cart cart;

	public ItemController(Cart cart) {
		this.cart = cart;
	}

	@FXML
	void btnAddToCartClicked(ActionEvent event) throws LimitExceededException {
		int numAdded;
		numAdded = cart.addMedia1(media);
	}

	@FXML
	void btnPlayClicked(ActionEvent event) throws PlayerException {
		Alert alert = new Alert(Alert.AlertType.INFORMATION, ((Playable) media).play().toString());
		alert.showAndWait();

	}

	public void setData(Media media) {
		this.media = media;
		lblTitle.setText(media.getTitle());
		lblCost.setText(media.getCost() + " $");
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		} else {
			btnPlay.setVisible(false);
			HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
		}
	}
}
