package lesson4.library;

public class LibraryDemo {

	public static void main(String[] args) throws Exception {
		Library lib = new Library();
		
		for (Book book : lib.searchByGenre(Genre.FANTASY)) {
			if (book != null) {
				System.out.print(book.getTitle() + " by " + book.getAuthor() + " (" + book.getGenre() + ")");
				System.out.println();
			}
		}

		try {
			Book bookSearchRequest1 = lib.searchByTitle("Girl with the Dragon Tattoo"); //search request 1
			System.out.println();
			System.out.print("[Result1]: " + bookSearchRequest1.getTitle() + " by "
					+ bookSearchRequest1.getAuthor() + " (" + bookSearchRequest1.getGenre() + ")");
		} catch (NullPointerException e) {
			System.out.println();
			System.out.println("[Result1]: There is no such book in the library");
		}
		
		try {
			Book[] bookSearchRequest2 = lib.searchByAuthor("J.R.R. Tolkien"); //search request 2
			System.out.println();
			for (int i = 0; i < bookSearchRequest2.length; i++) {
				System.out.print("[Result1]: " + bookSearchRequest2[i].getTitle() + " by "
						+ bookSearchRequest2[i].getAuthor() + " (" + bookSearchRequest2[i].getGenre() + ")");
			}
		} catch (NullPointerException e) {
			System.out.println();
			System.out.println("[Result2]: There is no such book in the library");
		}

	}
}
