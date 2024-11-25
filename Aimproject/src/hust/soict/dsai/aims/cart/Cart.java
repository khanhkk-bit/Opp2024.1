package hust.soict.dsai.aims.cart;

import hust.soict.dsai.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered <= MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc with name " + disc.getTitle() + "has been added");
		} else {
			System.out.println("The cart is almost full");
		}
	}

//	Overloading by differing types of parameter

	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		if (qtyOrdered <= MAX_NUMBERS_ORDERED) {
			for (int i = 0; i < dvdList.length; i++) {
				itemsOrdered[qtyOrdered] = dvdList[i];
				qtyOrdered++;
				System.out.println("The disc with name " + dvdList[i].getTitle() + "has been added");
			}
		} else {
			System.out.println("The cart is almost full");
		}
	}

//	Overloading by differing the number of parameters	

	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		DigitalVideoDisc[] dvdList = { dvd1, dvd2 };
		addDigitalVideoDisc(dvdList);
	}

	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int index = -1;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].equals(disc)) {
				index = i;
			}
		}
		if (index == -1) {
			System.out.println("Can't not found disc to remove");
			return;
		}
		DigitalVideoDisc newListDVD[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
		System.arraycopy(itemsOrdered, 0, newListDVD, 0, index);
		System.arraycopy(itemsOrdered, index + 1, newListDVD, index, qtyOrdered - index - 1);
		itemsOrdered = newListDVD;
		qtyOrdered--;
		System.out.println("The disc has been remove");
	}

//	public void totalCost() {
//		float sum = 0;
//		for (int i = 0; i < qtyOrdered; i++) {
//			sum += itemsOrdered[i].getCost();
//		}
//		System.out.println("Total Cost is: " + sum);
//	}

	public void searchByID(int id) {
		boolean found = false;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getId() == id) {
				System.out.println("Found" + itemsOrdered[i]);
				found = true;
			}
		}
		if (!found) {
			System.out.println("Sorry, no DVDs were found that match the ID provided!");
		}
	}

	public void searchByTitle(String keyword) {
		boolean matchFound = false;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].isMatch(keyword)) {
				System.out.println("Found" + itemsOrdered[i]);
				matchFound = true;
			}
		}
		if (!matchFound) {
			System.out.println("Sorry, no DVDs were found with \"" + keyword + "\" in the title!");
		}
	}

	public float totalCost() {
		float totalCost = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			totalCost += itemsOrdered[i].getCost();
		}
		return totalCost;
	}

	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println(i + 1 + ". " + itemsOrdered[i]);
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
	}

}
