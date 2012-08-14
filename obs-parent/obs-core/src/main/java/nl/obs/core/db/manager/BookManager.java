package nl.obs.core.db.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transaction;

import nl.obs.core.db.entity.Book;

public class BookManager {

	private EntityManagerFactory emf;
	
	public BookManager() {
		emf = javax.persistence.Persistence.createEntityManagerFactory("tibri");
	    
	}	
	
	public Book getBook(String title) {
		return null;
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
