package CSE214_Homework1;
import java.util.Scanner;
import CSE214_Homework1.BookShelf.EmptyShelfException;
import CSE214_Homework1.BookShelf.FullShelfException;
/**
 * This is a class named RipOffRental that contains different Booksehlfs
 * @author ishas
 *		   SBU ID: 114427973
 *         Email: isha.sachdeva@stonybrook.edu
 */
public class RipOffRental {
	private static BookShelf shelfA;
	private static BookShelf shelfB;
	private static BookShelf shelfC;
	/**
	 * This is the main method, it contains a while loop
	 * and switch case for calling of all other methods
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("A-Add book");

		System.out.println("S-swap books");
		
		System.out.println("L-Loan Books");

		System.out.println("R-remove book");
		
		System.out.println("D-duplicate book");

		System.out.println("C-change shelf");

		System.out.println("O-overwrite other bookshelfwith clone of the current bookshelf");

		System.out.println("E-check for bookshelf eqality");

		System.out.println("Q-quit");

		int n = 0;
		while (n == 0) {
			System.out.println("Please select an option: ");
			Scanner value = new Scanner(System.in);
			char input = value.next().charAt(0);

			switch (input) {
			case 'A':
						addBook();
						break;

			case 'S': 
						swapBooks();
						break;
			case 'L': 
						loanBook();
						break;
			case 'R': 
						removeBook();
						break;
			case 'D': 
						duplicateBook();
						break;
			case 'C': 
						changeShelf();
						break;
			case 'O': 
						overwriteBookShelf();
						break;
			case 'E': 
						isBookShelfEqual();
						break;

			case 'P': 
						printShelf();
						break;
			case 'Q': 
						n = 1;
						System.out.println("exiting the program");
						break;
			default: 
						System.out.println("error, try again");
						break;
			}
		}
	}
	
	private static BookShelf selectShelf(char name) {
		BookShelf shelf = null;
		switch (name) {
		case 'a':
				shelf = shelfA;
		case 'b':
				shelf = shelfB;
		case 'c':
				shelf = shelfC;
		default:
			System.out.println("Please enter valid input for BookShelf");
		}
		return shelf;
	}
	/**
	 * This is a method named addBook
	 * It asks the user to enter all the information about the book
	 * that is to be added
	 */
	private static void addBook() {
		System.out.println("	Please enter shelf: a, b or c: ");
		Scanner value = new Scanner(System.in);
		char shelfName = value.next().charAt(0);
		BookShelf shelf = selectShelf(shelfName);

		System.out.println(" Please enter the title");
		value = new Scanner(System.in);
		String title = value.next();

		System.out.println("	Please enter the Author");
		value = new Scanner(System.in);
		String author = value.next();

		System.out.println("	Enter the condition");
		value = new Scanner(System.in);
		int condition = value.nextInt();

		System.out.println("	Enter the index");
		value = new Scanner(System.in);
		int index = value.nextInt();

		Book b = new Book(title, author, condition);

		try {
			shelf.addBook(index, b);
		} catch (FullShelfException e) {
			System.out.printf("Shelf - %s is full", shelfName).println();
		}
	}
	/**
	 * This is the method named swapBooks
	 * It asks the user about index of both the books that are need to
	 * be swapped, and then swaps them.
	 */
	private static void swapBooks() {
		System.out.println("	Please enter shelf: a, b or c: ");
		Scanner value = new Scanner(System.in);
		char shelfName = value.next().charAt(0);
		BookShelf shelf = selectShelf(shelfName);

		System.out.println("enter index 1");
		value = new Scanner(System.in);
		int index1 = value.nextInt() - 1;

		System.out.println("entern index2");
		value = new Scanner(System.in);
		int index2 = value.nextInt() - 1;

		shelf.swapBooks(index1, index2);
	}
	/**
	 * This is a method named loanBook
	 * 
	 */
	private static void loanBook() {

		System.out.println("	Please enter shelf: a, b or c: ");
		Scanner value = new Scanner(System.in);
		char shelfName = value.next().charAt(0);
		BookShelf shelf = selectShelf(shelfName);

		System.out.println(" Enter index");
		value = new Scanner(System.in);
		int index2 = value.nextInt();

		System.out.println("Enter borrower");
		value = new Scanner(System.in);
		String borrower = value.next();

		System.out.println("	Enter condition");
		value = new Scanner(System.in);
		int condition = value.nextInt();

		// UI - shelf
		// UI - index
		// UI - borrower
		// UI - condition
		Book b = shelf.getBook(index2);
		b.setBorrower(borrower);
		b.setCondition(condition);
	}
	/**
	 * This is a method named removeBook
	 * It removes book from the entered shelf
	 */
	private static void removeBook() {

		System.out.println("	Please enter shelf: a, b or c: ");
		Scanner value = new Scanner(System.in);
		char shelfName = value.next().charAt(0);
		BookShelf shelf = selectShelf(shelfName);

		System.out.println("	Enter index");
		value = new Scanner(System.in);
		int index1 = value.nextInt();
		// UI - shelf
		// UI - position of book to remove - index
		try {
			shelf.removeBook(index1);
		} catch (EmptyShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This is a method named duplicateBook
	 */
	private static void duplicateBook() {

		System.out.println("	Please enter shelf: a, b or c: ");
		Scanner value = new Scanner(System.in);
		char shelfName = value.next().charAt(0);
		BookShelf shelf = selectShelf(shelfName);

		System.out.println("Enter index");
		value = new Scanner(System.in);
		int index1 = value.nextInt();
		// UI - shelf
		// UI - position of book to duplicate - index
		Book b = shelf.getBook(index1);
		Book clonedBook = b.clone();
	}
	/**
	 * This method is named changeShelf
	 */
	private static void changeShelf() {

		System.out.println("	Please enter shelf: a, b or c: ");
		Scanner value = new Scanner(System.in);
		char shelfName = value.next().charAt(0);
		BookShelf shelf = selectShelf(shelfName);

		System.out.println("	Please enter shelf: a, b or c: ");
		value = new Scanner(System.in);
		char shelfName2 = value.next().charAt(0);
		BookShelf shelf2 = selectShelf(shelfName2);

		System.out.println(" Enter index");
		value = new Scanner(System.in);
		int index1 = value.nextInt();

		// UI - shelf1 to shelf2
		// UI - book position - index
		Book b = shelf.getBook(index1);
		try {
			shelf.removeBook(index1);
		} catch (EmptyShelfException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			shelf2.addBook(index1, b);
		} catch (FullShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// (index1, b)
	}
	/**
	 * This is a method named overwriteBookShelf 
	 */
	private static void overwriteBookShelf() {
		System.out.println("	Please enter shelf: a, b or c: ");
		Scanner value = new Scanner(System.in);
		char shelfName = value.next().charAt(0);
		BookShelf shelf = selectShelf(shelfName);
		// UI - shelf
		BookShelf shelf1 = (BookShelf) shelf.clone();
		shelf = shelf1;
	}
	/**
	 * This is method named printShelf
	 * This prints the selected shelf 
	 */
	private static void printShelf() {
		// UI shelf

		System.out.println("	Please enter shelf: a, b or c: ");
		Scanner value = new Scanner(System.in);
		char shelfName = value.next().charAt(0);
		BookShelf shelf = selectShelf(shelfName);
		System.out.println(shelf.toString());
	}
	/**
	 * This is equals method
	 * Used for comparing two shelfs
	 */
	private static void isBookShelfEqual() {

		System.out.println("	Please enter shelf: a, b or c: ");
		Scanner value = new Scanner(System.in);
		char shelfName = value.next().charAt(0);
		BookShelf shelf = selectShelf(shelfName);

		System.out.println("	Please enter shelf: a, b or c: ");
		value = new Scanner(System.in);
		char shelfName2 = value.next().charAt(0);
		BookShelf shelf2 = selectShelf(shelfName2);
		// enter bookshelves to compare
		// UI - shelf 1
		// UI - shelf 2
		boolean check = shelf.equals(shelf2);
		if (check) {
			System.out.println("They are equal");
		} else {
			System.out.println("They are not equal");
		}
	}
}
