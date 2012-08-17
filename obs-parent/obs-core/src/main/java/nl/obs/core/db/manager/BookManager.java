package nl.obs.core.db.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import nl.obs.core.db.entity.Book;

public class BookManager {

	public static List<Book> getAllBooks() {
		
		EntityManager em = DBUtils.ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		@SuppressWarnings("unchecked")
		List<Book> l = em.createQuery("select b from Book b").getResultList();
		tx.commit();

		return l;
	}
	
	public static Book getBook(int id) {
				
		EntityManager em = DBUtils.ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		Book b;
		try {
			tx.begin();		
			b = (Book)em.createQuery("select b from Book b where b.id = :bookId").setParameter("bookId", id).getSingleResult();
			tx.commit();
		} catch (NoResultException e) {
			return null;
		}
		
		return b;
	}

	public static Book saveBook(Book book) {
		EntityManager em = DBUtils.ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.persist(book);
		tx.commit();

		return book;
	}

}
