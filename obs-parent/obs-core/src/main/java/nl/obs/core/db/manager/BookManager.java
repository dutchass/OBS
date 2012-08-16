package nl.obs.core.db.manager;

import java.util.List;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import nl.obs.core.db.entity.Book;

public class BookManager {

	private EntityManagerFactory emf;

	public BookManager() {
		emf = javax.persistence.Persistence.createEntityManagerFactory("tibri");

	}

	public List<Book> getAllBooks() {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		@SuppressWarnings("unchecked")
		List<Book> l = em.createQuery("select b from Book b").getResultList();
		tx.commit();

		return l;
		// return books;
	}

	public Book getBook(String title) {
		return null;
	}

	public Book getBookByTitle(String title) {
		Book b = new Book();
		b.setTitle(title);
		b.setId((int) (Math.random() * 10));
		b.setImagebookurl("HeadfirstJava.jpg");
		b.setISBNnumber((int) (Math.random() * 16120));
		return b;
	}

	public Book getBook(int id) {
		Book b = new Book();
		b.setTitle("Head First Java");
		b.setId(0);
		b.setImagebookurl("HeadfirstJava.jpg");
		b.setISBNnumber(123456789);

		return b;
	}

	public Book saveBook(Book book) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.persist(book);
		tx.commit();

		return book;
	}

}
