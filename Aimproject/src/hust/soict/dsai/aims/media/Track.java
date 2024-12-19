package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.screen.PlayerException;

public class Track implements Playable {
	private String title;
	private int length;

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public boolean equals(Track o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof Track)) {
			return false;
		}
		Track t = o;
		return this.title.equals(t.getTitle()) && this.length == t.getLength();
	}

	@Override
	public String play() throws PlayerException {
		String log = "";
		if (this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
			log += "Playing track " + this.getTitle() + "\n" + "Track length: " + this.getLength() + "\n";
		} else {
			throw new PlayerException("Error! The track length is not positive");
		}

		return log;
	}

}

//public class Track implements Playable {
//	private String title;
//	private int length;
//
//	public Track(String title, int length) {
//		this.title = title;
//		this.length = length;
//	}
//
//	public String play() {
//		System.out.println("Playing track: " + this.getTitle());
//		System.out.println("Track length: " + this.getLength());
//		return title;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public int getLength() {
//		return length;
//	}
//
//	public boolean equals(Object obj) {
//		if (this == obj) {
//			return true;
//		}
//		if (!(obj instanceof Track)) {
//			return false;
//		}
//		return ((Track) obj).getTitle() == this.getTitle() && ((Track) obj).getLength() == this.getLength();
//	}
//
//}
