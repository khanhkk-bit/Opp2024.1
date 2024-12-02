package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Store {
	public static final int MAX_DVDS_STORE = 20;
//	
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	public int numberDVD = 0;

	public void addMedia(Media media) {
		if (itemsInStore.contains(media)) {
			System.out.println("The media " + media.getTitle() + " is already in the store!");
		} else {
			itemsInStore.add(media);
			System.out.println("The media " + media.getTitle() + " has been added to the store.");
		}
	}

	public void removeMedia(Media media) {
		if (itemsInStore.remove(media)) {
			System.out.println("The media " + media.getTitle() + " has been removed from the store.");
		} else {
			System.out.println("The media " + media.getTitle() + " is not in the store!");
		}
	}

	public Media search(String title) {
		for (Media media : itemsInStore) {
			if (media.getTitle().equals(title)) {
				return media;
			}
		}
		return null;
	}

	public void print() {
		if (itemsInStore.size() == 0) {
			System.out.println("The store is empty!");
		} else {
			System.out.println("********************STORE INVENTORY********************");
			for (Media media : itemsInStore) {
				System.out.println(media);
			}
			System.out.println("********************************************************");
		}
	}

//	public void addDVD(DigitalVideoDisc dvd) {
//		if (numberDVD >= MAX_DVDS_STORE) {
//			System.out.println("The store is almost full !");
//		} else {
//			itemsInStore[numberDVD] = dvd;
//			numberDVD++;
//			System.out.println("The disc has been added");
//		}
//	}
//
//	public void removeDVD(DigitalVideoDisc disc) {
//		if (numberDVD == 0) {
//			System.out.println("The store is empty !");
//		} else {
//			int index = -1;
//			for (int i = 0; i < numberDVD; i++) {
//				if (itemsInStore[i].equals(disc)) {
//					index = i;
//				}
//			}
//			if (index != -1) {
//				for (int i = index; i < numberDVD; i++) {
//					itemsInStore[i] = itemsInStore[i + 1];
//				}
//				System.out.println("The disc has been remove");
//				numberDVD--;
//			} else {
//				System.out.println("Can not find the disc !");
//			}
//		}
//	}
}
