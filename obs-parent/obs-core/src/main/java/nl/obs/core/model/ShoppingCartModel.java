package nl.obs.core.model;

import java.util.List;
import java.util.Vector;

import nl.obs.core.db.entity.Book;
import nl.obs.core.db.entity.OrderedBook;

public class ShoppingCartModel {

	private List<BookEntry> booksInCart = new Vector<>();

	public void addBook(Book book, int amount) {

		// we hebben een aantal boeken in ons wagentje
		List<BookEntry> books = this.booksInCart;

		BookEntry currentBookEntry = null; // hij is nu leeg, of we vullen hem
		// met een bestaande entry, of we
		// maken een nieuwe

		for (BookEntry bookEntry : books) {
			// een voor een bekijken we de boeken in ons wagentje
			Book currentBook = bookEntry.getBook(); // het boek
			int currentAmount = bookEntry.getAmount(); // hoeveel we er van
			// hebbenn

			if (currentBook.equals(book)) { // checken of we het boek wat we toe
				// willen voegen al hebben
				currentBookEntry = bookEntry; // dus setten we dat op
				// bovengenoemde var
				break; // en we stoppen de loop, we hebben gevonden wat we
						// zochten
			}
		}
		if (currentBookEntry == null) { // hebben we nooit het boek gevonden?
			// dan maken we hem nieuw aan

			currentBookEntry = new BookEntry();
			currentBookEntry.setBook(book);
			currentBookEntry.setAmount(amount);
			this.booksInCart.add(currentBookEntry); // en hier voegen we het
			// object aan de lijst in
			// het andere geval zit hij
			// al in de lijst.
		} else { // is ie er wel? dan gaan we alleen het aantal aanpassen
			int oldAmount = currentBookEntry.getAmount();
			int newAmount = oldAmount + amount; // we voegen het oude amount en
			// het amount zoals meegegeven
			// aan de functie samen
			currentBookEntry.setAmount(newAmount); // en setten dit op het
			// object
		}

		// klaar, duidelijk! Ok, dan mag je nu de functie removebook gaan maken
		// let wel, ook daar kan het zijn dat je er 3 in je mandje hebt... en er
		// 2 weg wil
		// knikkeren... veel plezier :P
	}

	public void removeBook(Book book, int amount) {
		List<BookEntry> books = this.booksInCart;

		for (BookEntry bookEntry : books) {
			Book bookInCart = bookEntry.getBook();
			int amountInCart = bookEntry.getAmount();

			if (bookInCart.equals(book)) {

				int newAmountInCart = amountInCart - amount;

				if (newAmountInCart <= 0) { // idd!
					this.booksInCart.remove(bookEntry);

				} else {
					bookEntry.setAmount(newAmountInCart);

				}

			}
		}

	}

	public int getTotalAmount() {
		int total = 0;
		for (BookEntry bookEntry : this.booksInCart) {
			total = total + bookEntry.getAmount();
		}
		return total;

	}

	public void addBook(Book book) {
		this.addBook(book,1);
	}

	public List<BookEntry> getBookEntries() {
		return booksInCart;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (BookEntry bookEntry : this.booksInCart) {
			builder.append(bookEntry.toString());
			builder.append('\n');
		}
		return builder.toString();
	}
	
	

}
