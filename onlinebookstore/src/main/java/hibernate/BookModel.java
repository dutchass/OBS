package hibernate;

public class BookModel {
	
	private Book book;
	
	public BookModel(Book book) {
		this.book = book;		
	}

	public BookModel() {
		this.book = new Book();
	}
	
	
}
