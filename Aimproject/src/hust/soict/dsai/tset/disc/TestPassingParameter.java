package hust.soict.dsai.tset.disc;

import hust.soict.dsai.disc.DigitalVideoDisc;

public class TestPassingParameter {
	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("CinderellaDVD");
		wrapDvD afjungleDVD = new wrapDvD(jungleDVD);
		wrapDvD afcinderellaDVD = new wrapDvD(cinderellaDVD);
		swap(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

		swap(afjungleDVD, afcinderellaDVD);
		System.out.println("Correct swapped jungle dvd title: " + afjungleDVD.dvd.getTitle());
		System.out.println("Correct swapped cinderella dvd title: " + afcinderellaDVD.dvd.getTitle());
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}

	public static void swap(Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}

	public static void swap(wrapDvD vd1, wrapDvD vd2) {
		DigitalVideoDisc tmp = vd1.dvd;
		vd1.dvd = vd2.dvd;
		vd2.dvd = tmp;
	}

	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
}
