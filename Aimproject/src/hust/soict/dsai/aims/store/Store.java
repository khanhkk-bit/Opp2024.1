package hust.soict.dsai.aims.store;

import hust.soict.dsai.disc.DigitalVideoDisc;

public class Store {
	public static final int MAX_DVDS_STORE = 20;
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_DVDS_STORE];
	public int numberDVD = 0;

	public void addDVD(DigitalVideoDisc dvd) {
		if (numberDVD >= MAX_DVDS_STORE) {
			System.out.println("The store is almost full !");
		} else {
			itemsInStore[numberDVD] = dvd;
			numberDVD++;
			System.out.println("The disc has been added");
		}
	}

	public void removeDVD(DigitalVideoDisc disc) {
		if (numberDVD == 0) {
			System.out.println("The store is empty !");
		} else {
			int index = -1;
			for (int i = 0; i < numberDVD; i++) {
				if (itemsInStore[i].equals(disc)) {
					index = i;
				}
			}
			if (index != -1) {
				for (int i = index; i < numberDVD; i++) {
					itemsInStore[i] = itemsInStore[i + 1];
				}
				System.out.println("The disc has been remove");
				numberDVD--;
			} else {
				System.out.println("Can not find the disc !");
			}
		}
	}
}
