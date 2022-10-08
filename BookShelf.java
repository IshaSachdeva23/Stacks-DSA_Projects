package CSE214_Homework1;
import java.util.Arrays;
/**
 * This is a class named BookShelf which contains the number of books,
 * maximum capacity
 * @author ishas
 *         SBU ID: 114427973
 *         Email: isha.sachdeva@stonybrook.edu
 */
public class BookShelf {
	private Book[] books;
	private int count;
	final int CAPACITY = 20;

	public BookShelf() {
	this.books = new Book[CAPACITY];
	this.count = 0;
	}
	/**
	 * This is a method named BookShelf
	 * @param books
	 * @param count
	 */
	public BookShelf(Book[] books, int count) {
	this.books = books;
	this.count = count;
	}
	/**
	 * This is a method named numBooks
	 * @return
	 * It returns the number of books
	 */
	public int numBooks() {
	return count;
	}
	/**
	 * This is a method named getBook and exception is thrown below
	 * @param index
	 * @return
	 * It returns the index
	 */
	public Book getBook(int index) {
	if (count > index) {
	return books[index];
	} else {
	throw new ArrayIndexOutOfBoundsException();
	}
	}
	/**
	 * This is a class EmptyShelfException that extends Exception
	 * @author ishas
	 *         SBU ID: 114427973
	 *         Email: isha.sachdeva@stonybrook.edu
	 */
	public class EmptyShelfException extends Exception {

	}
    /**
     * 
     * @param index
     * @return
     * @throws EmptyShelfException
     */
	public Book removeBook(int index) throws EmptyShelfException {
	if (count == 0) {
	throw new EmptyShelfException();
	} else if (count <= index) {
	throw new ArrayIndexOutOfBoundsException();
	} else {
	Book b = books[index];
	for (int i = index; i < count; i++) {
	books[i] = books[i + 1];
	}
	count--;
	return b;
	}
	}
	/**
	 * This is a class FullShelfException that extends Exception
	 * @author ishas
	 *         SBU ID: 114427973
	 *         Email: isha.sachdeva@stonybrook.edu
	 */
	public class FullShelfException extends Exception {

	}
    /**
     * Method for adding the book
     * @param index
     * @param book
     * @throws FullShelfException
     */
	public void addBook(int index, Book book) throws FullShelfException {
	if (count == CAPACITY) {
	throw new FullShelfException();
	} else if (count < index) {
	throw new IllegalArgumentException();
	} else {
	for (int i = count; i >= index; i--) {
	if (count == index) {
	books[count] = book;
	} else {
	books[count] = books[count - 1];
	}
	}
	count++;
	}
	}
    /**
     * Method for swapping book, throws exception
     * @param index1
     * @param index2
     */
	public void swapBooks(int index1, int index2) {
	if (index1 < count && index2 < count) {
	Book b = books[index1];
	books[index1] = books[index2];
	books[index2] = b;
	} else {
	throw new IllegalArgumentException();
	}
	}
	/**
	 * Clone method
	 * @return
	 * new BookShelf
	 */
	public Object clone() {
	Book[] clonedBooks = new Book[CAPACITY];
	for (int i = 0; i < count; i++) {
	clonedBooks[i] = books[i].clone();
	}
	return new BookShelf(clonedBooks, clonedBooks.length);
	}
	/**
	 * Equals method
	 */
	public boolean equals(Object obj) {
	if (this == obj)
	return true;
	if (obj == null)
	return false;
	if (getClass() != obj.getClass())
	return false;
	BookShelf other = (BookShelf) obj;
	if (CAPACITY != other.CAPACITY)
	return false;
	if (!Arrays.equals(books, other.books))
	return false;
	if (count != other.count)
	return false;
	return true;
	}
	/**
	 * toString() method
	 */
	public String toString() {
	StringBuilder s = new StringBuilder("No. of Books: " + count);
	for (int i = 0; i < count; i++) {
	s.append(books[i].toString());
	s.append("\n");
	}
	return s.toString();
	}

	
}
