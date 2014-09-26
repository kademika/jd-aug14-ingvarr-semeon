package lesson4.library;

public class Lib {
		Book book1 = new Book("Java Programming 24-Hour Trainer", "Yakov Fain", Genre.PROGRAMMING);
		Book book2 = new Book("Thinking in Java", "Bruce Eckel", Genre.PROGRAMMING);
		Book book3 = new Book("Nineteen Eighty-Four", "George Orwell", Genre.FICTION);
		Book book4 = new Book("Eat Move Sleep", "Tom Rath", Genre.FOOD);
		Book book5 = new Book("Stalingrad: The Fateful Siege", "Antony Beevor", Genre.HISTORY);
		Book book6 = new Book("The Fellowship of the Ring", "J.R.R. Tolkien", Genre.FANTASY);
		
		Book[] books = {book1, book2, book3, book4, book5, book6};
}
