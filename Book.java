package CSE214_Homework1;
/**
 * This is class named Book, which contains Title name, Borrower's name
 * , Author's name and condition
 * @author ishas
 *         SBU ID: 114427973
 *         Email: isha.sachdeva@stonybrook.edu
 */
public class Book {
	private String title;
	private String author;
	private String borrower;
	private int condition;
	public Book(String title, String author, int condition) {
		this.title=title;
		this.author=author;
		this.condition=condition;
		borrower=null;
	}
	/**
	 * This is a getter method
	 * @return 
	 * it returns Title
	 */
	private String getTitle() {
		return title;
	}
	/**
	 * This is a getter method
	 * @return 
	 * it returns author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * This is a getter method
	 * @return 
	 * it returns borrower
	 */
	public String getBorrower() {
		return borrower;
	}
	/**
	 * This is a getter method
	 * @return 
	 * it returns condition
	 */
	public int getCondition() {
		return condition;
	}
	/**
	 * This is a setter method 
	 * @param title
	 * Title of the book
	 */
	public void setTitle(String title) {
		this.title=title;
	}
	/**
	 * This is a setter method
	 * @param author
	 * The name of the author
	 */
	public void setAuthor(String author) {
		this.author=author;
	}
	/**
	 * This is a setter method
	 * @param borrower
	 * The name of the borrower
	 */
	public void setBorrower(String borrower) {
		this.borrower=borrower;
	}
	/**
	 * This is a setter method
	 * @param condition
	 * the condition 
	 */
	public void setCondition(int condition) {
		this.condition=condition;
	}
	
	/**
	 * This is an equals method
	 * It is used for comparing objects and returns a boolean value
	 */
	public boolean equals(Object obj) {
		if (this == obj)
		return true;
		if (obj == null)
		return false;
		if (getClass() != obj.getClass())
		return false;
		Book other = (Book) obj;
		if (author == null) {
		if (other.author != null)
		return false;
		} else if (!author.equals(other.author))
		return false;
		if (condition != other.condition)
		return false;
		if (title == null) {
		if (other.title != null)
		return false;
		} else if (!title.equals(other.title))
		return false;
		return true;
		}
		/**
		 * This is a clone method
		 * It returns a new Book
		 */
		public Book clone() {
		return new Book(this.title, this.author, this.condition);
		}
		/**
		 * This is toString() method
		 */
		public String toString() {
		return "Title: " + this.title + ", Author: " + this.author + ", Condition: " + this.condition + ", Borrower: "
		+ this.borrower;
		}

		
	

}
