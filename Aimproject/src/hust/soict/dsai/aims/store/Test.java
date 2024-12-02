package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Test {
	public static void main(String[] args) {
		List<Media> list = new ArrayList<Media>();
		Media dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		list.add(dvd);
		Media cd = new CompactDisc("Bat out of Hell", "Hard Rock", "Todd Rundgren", 24.95f);
		list.add(cd);
		Media book = new Book("Harry Potter", "Fiction", 18.99f);
		list.add(book);
		for (Media media : list) {

		}
	}
}
