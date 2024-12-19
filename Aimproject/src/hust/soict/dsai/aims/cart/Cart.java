package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
//	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	private int qtyOrdered = 0;

	public void addMedia(Media media) {
		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full!");
		} else if (itemsOrdered.contains(media)) {
			System.out.println(media.getTitle() + " is already in the cart!");
		} else {
			itemsOrdered.add(media);
			System.out.println(media.getTitle() + " has been added!");
			qtyOrdered += 1;
		}
	}

	public int addMedia1(Media media) {
		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full!");
		} else if (itemsOrdered.contains(media)) {
			System.out.println(media.getTitle() + " is already in the cart!");
		} else {
			itemsOrdered.add(media);
			System.out.println(media.getTitle() + " has been added!");
			qtyOrdered += 1;
		}
		return qtyOrdered;
	}

	public void removeMedia(Media media) {
		if (itemsOrdered.size() == 0) {
			System.out.println("Nothing to remove!");
		} else {
			if (itemsOrdered.remove(media)) {
				System.out.println(media.getTitle() + " has been removed from the cart.");
				qtyOrdered -= 1;
			} else {
				System.out.println("Media not found in cart!");
			}
		}
	}

	public Media searchToRemove(String title) {
		for (Media media : itemsOrdered) {
			if (media.getTitle().equals(title)) {
				return media;
			}
		}
		return null;
	}

	public float totalCost() {
		float totalCost = 0;
		for (Media media : itemsOrdered) {
			totalCost += media.getCost();
		}
		return totalCost;
	}

	public void empty() {
		if (itemsOrdered.size() == 0) {
			System.out.println("Nothing to remove!");
		} else {
			qtyOrdered = 0;
			itemsOrdered.clear();
			System.out.println("Order created.");
			System.out.println("Now your current cart will be empty!");
			System.out.println();
		}
	}

	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (Media media : itemsOrdered) {
			System.out.println(media);
		}
		System.out.println("Total items: " + qtyOrdered);
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
	}

	public void searchByID(int id) {
		boolean found = false;
		for (Media media : itemsOrdered) {
			if (media.getId() == id) {
				System.out.println("Found " + media);
				found = true;
			}
		}
		if (!found) {
			System.out.println("Sorry, no media were found that match the ID provided!");
		}
	}

	public void searchByTitle(String keyword) {
		boolean matchFound = false;
		for (Media media : itemsOrdered) {
			if (media.isMatch(keyword)) {
				System.out.println("Found " + media);
				matchFound = true;
			}
		}
		if (!matchFound) {
			System.out.println("Sorry, no media were found with \"" + keyword + "\" in the title!");
		}
	}

	public void sortMediaByTitle() {
		Collections.sort((List<Media>) itemsOrdered, Media.COMPARE_BY_TITLE_COST);
		Iterator<Media> iterator = itemsOrdered.iterator();
		iterator = itemsOrdered.iterator();

		while (iterator.hasNext()) {
			System.out.println(((Media) iterator.next()).toString());
		}
	}

	public void sortMediaByCost() {
		Collections.sort((List<Media>) itemsOrdered, Media.COMPARE_BY_COST_TITLE);
		Iterator<Media> iterator = itemsOrdered.iterator();
		iterator = itemsOrdered.iterator();

		while (iterator.hasNext()) {
			System.out.println(((Media) iterator.next()).toString());
		}
	}

	public String placeOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public ObservableList<Media> getItemsOrdered() {
		// TODO Auto-generated method stub
		return (ObservableList<Media>) itemsOrdered;
	}

}
