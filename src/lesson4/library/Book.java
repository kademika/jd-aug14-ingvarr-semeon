package lesson4.library;

public class Book {
	private String title;
	private String author;
	private Genre genre;
	
	public Book() {}
	
	public Book(String title, String author, Genre genre) {
		this.title = title;
		this.author = author;
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
}
