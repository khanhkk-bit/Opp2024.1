package hust.soict.dsai.aims.media;

import java.util.Comparator;

class MediaComparatorByCostTitle implements Comparator<Media> {

	@Override
	public int compare(Media o1, Media o2) {
		// Compare by cost
		int costComparison = Double.compare(o2.getCost(), o1.getCost());
		if (costComparison != 0) {
			return costComparison;
		}
		// Compare by title
		return o1.getTitle().compareTo(o2.getTitle());
	}
}

class MediaComparatorByTitleCost implements Comparator<Media> {
	@Override
	public int compare(Media o1, Media o2) {
		// Compare by title
		int titleComparison = o1.getTitle().compareTo(o2.getTitle());
		if (titleComparison != 0) {
			return titleComparison;
		}
		// Compare by cost
		return Double.compare(o2.getCost(), o1.getCost());
	}

}

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;

	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	private static int nbMedia = 0;

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public Media(String title) {
		this.title = title;
		this.id = ++nbMedia;
	}

	public Media(String title, String category) {
		this.title = title;
		this.category = category;
		this.id = ++nbMedia;
	}

	public Media(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = ++nbMedia;
	}

	public String toString() {
		return "Media: " + this.getTitle() + " - Category: " + this.getCategory() + " - Cost: " + this.getCost() + "$";
	}

	public boolean isMatch(String title) {
		return this.getTitle().toLowerCase().contains(title.toLowerCase());
	}

	public void play() {
		System.out.println("Playing media");
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Media)) {
			return false;
		}
		return ((Media) obj).getTitle() == this.getTitle();
	}

	public int compareTo(Media other) {
		int titleComparison = this.getTitle().compareTo(other.getTitle());
		if (titleComparison != 0) {
			return titleComparison;
		} else {
			return Double.compare(this.getCost(), other.getCost());
		}
	}

}
