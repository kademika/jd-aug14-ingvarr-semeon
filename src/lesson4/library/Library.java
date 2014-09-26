package lesson4.library;

public class Library {
	private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	// 1st index is capital letter of title, 2nd index is array books
	public Book[][] booksByTitle;

	// 1st index is capital letter of author, 2nd index is array books
	private Book[][] booksByAuthor;

	// 1st index is genre id, 2nd index is array books
	private Book[][] booksByGenre;

	public Library() {
		booksByTitle = new Book[26][];
		fillDictionary(booksByTitle);

		booksByAuthor = new Book[26][];
		fillDictionary(booksByAuthor);

		booksByGenre = new Book[5][];
		fillDictionary(booksByGenre);

		createBooks();
	}
	
	public Book searchByTitle(String title) throws Exception { // TASK 1
		int letterIdx = alphabet.indexOf(title.charAt(0));

		for (int bookIdx = 0; bookIdx < booksByTitle.length; bookIdx++) {
			if (booksByTitle[letterIdx][bookIdx].getTitle().equals(title)) {
				return booksByTitle[letterIdx][bookIdx];
			}
		}
		return null;
	}
	
	public Book[] searchByAuthor(String author) throws Exception { // TASK 2
		int letterIdx = alphabet.indexOf(author.charAt(0));
		Book[] bookBuffer = new Book[5];
		
		for(int bookIdx = 0, bufferIdx = 0; bookIdx < booksByAuthor.length; bookIdx++) {
			if (booksByAuthor[letterIdx][bookIdx].getAuthor().equals(author)) {
				bookBuffer[bufferIdx] = booksByAuthor[letterIdx][bookIdx];
				bufferIdx++;
			}
		}
		return bookBuffer;
	}

	public Book[] searchByGenre(Genre genre) { // TASK 3 (5 books)
		return booksByGenre[genre.getId()];
	}

	private void fillDictionary(Book[][] dictionary) {
		for (int i = 0; i < dictionary.length; i++) {
			dictionary[i] = new Book[10];
		}
	}

	private void addToLibrary(Book book) {
		int position = alphabet.indexOf(book.getTitle().charAt(0));
		addToStorage(booksByTitle[position], book);

		position = alphabet.indexOf(book.getAuthor().charAt(0));
		addToStorage(booksByAuthor[position], book);

		addToStorage(booksByGenre[book.getGenre().getId()], book);
	}

	private void addToStorage(Book[] storage, Book book) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] == null) {
				storage[i] = book;
				return;
			}
		}
	}

	private void createBooks() {
		Book book = new Book();
		book.setTitle("Java Programming 24-Hour Trainer");
		book.setAuthor("Yakov Fain");
		book.setGenre(Genre.PROGRAMMING);
		addToLibrary(book);

		book = new Book();
		book.setTitle("Thinking in Java");
		book.setAuthor("Bruce Eckel");
		book.setGenre(Genre.PROGRAMMING);
		addToLibrary(book);

		book = new Book();
		book.setTitle("Nineteen Eighty-Four");
		book.setAuthor("George Orwell");
		book.setGenre(Genre.FICTION);
		addToLibrary(book);

		book = new Book();
		book.setTitle("Great Gatsby");
		book.setAuthor("F. Scott Fitzgerald");
		book.setGenre(Genre.FICTION);
		addToLibrary(book);

		book = new Book();
		book.setTitle("Girl with the Dragon Tattoo");
		book.setAuthor("Stieg Larsson");
		book.setGenre(Genre.FICTION);
		addToLibrary(book);

		book = new Book();
		book.setTitle("Eat Move Sleep");
		book.setAuthor("Tom Rath");
		book.setGenre(Genre.FOOD);
		addToLibrary(book);

		book = new Book();
		book.setTitle("Stalingrad: The Fateful Siege");
		book.setAuthor("Antony Beevor");
		book.setGenre(Genre.HISTORY);
		addToLibrary(book);

		book = new Book();
		book.setTitle("Battle Of Britain: Myth and Reality");
		book.setAuthor("Richard Overy");
		book.setGenre(Genre.HISTORY);
		addToLibrary(book);

		book = new Book();
		book.setTitle("Why the Allies Won");
		book.setAuthor("Richard Overy");
		book.setGenre(Genre.HISTORY);
		addToLibrary(book);

		book = new Book();
		book.setTitle("Fellowship of the Ring");
		book.setAuthor("J.R.R. Tolkien");
		book.setGenre(Genre.FANTASY);
		addToLibrary(book);

		book = new Book();
		book.setTitle("Hobbit");
		book.setAuthor("J.R.R. Tolkien");
		book.setGenre(Genre.FANTASY);
		addToLibrary(book);
	}

}
