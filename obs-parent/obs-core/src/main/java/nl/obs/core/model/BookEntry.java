package nl.obs.core.model;

import nl.obs.core.db.entity.Book;

public class BookEntry {
    
    private Book book;
    private int amount;

    /**
     * @return the book
     */
    public Book getBook() {
	return book;
    }

    /**
     * @param book
     *            the book to set
     */
    public void setBook(Book book) {
	this.book = book;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
	return amount;
    }

    /**
     * @param amount
     *            the amount to set
     */
    public void setAmount(int amount) {
	this.amount = amount;
    }

	@Override
	public String toString() {
		return book.toString() + " (" +amount+")";
	}
    
    
}
