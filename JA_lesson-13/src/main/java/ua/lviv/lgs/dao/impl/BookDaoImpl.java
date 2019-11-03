package ua.lviv.lgs.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ua.lviv.lgs.dao.BookDao;
import ua.lviv.lgs.domain.Book;
import ua.lviv.lgs.shared.FactoryManager;

public class BookDaoImpl implements BookDao {

	private EntityManager em = FactoryManager.getEntityManager();

	@Override
	public Book create(Book book) {
		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			em.persist(book);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return book;
	}

	@Override
	public Book read(int id) {
		Book book = null;
		try {
			book = em.find(Book.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public Book update(Book book) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public void delete(int id) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> readAll() {
		Query query = null;
		try {
			query = em.createQuery("SELECT e FROM Book e ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (List<Book>) query.getResultList();
	}

}
