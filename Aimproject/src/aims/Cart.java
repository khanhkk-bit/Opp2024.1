package aims;

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

	public void totalCost() {
		float sum = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			sum += itemsOrdered[i].getCost();
		}
		System.out.println("Total Cost is: " + sum);
	}
}
