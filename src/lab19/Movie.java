package lab19;

public class Movie implements Comparable<Movie>{
	String title;
	String category;
	int stars;
	
	public Movie(String t, String c)
	{
		title = t;
		category = c;
	}
	
	
	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
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


	@Override
	public int compareTo(Movie o) {
		return (this.getTitle().compareTo(o.getTitle()));
	}

}
