package ua.lviv.lgs.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ua.lviv.lgs.dao.CustomerDao;
import ua.lviv.lgs.domain.Customer;
import ua.lviv.lgs.shared.FactoryManager;

public class CustomerDaoImpl implements CustomerDao {
	private EntityManager em = FactoryManager.getEntityManager();

	@Override
	public Customer create(Customer customer) {
		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			em.persist(customer);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return customer;
	}

	@Override
	public Customer read(int id) {
		Customer customer = null;
		try {
			customer = em.find(Customer.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public Customer update(Customer customer) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public void delete(int id) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Customer> readAll() {
		List<Customer> customerRecords = new ArrayList<>();
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerRecords;
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		Customer customer = null;
		try {
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Customer> criteria = builder.createQuery(Customer.class);
			Root<Customer> from = criteria.from(Customer.class);
			criteria.select(from);
			criteria.where(builder.equal(from.get("email"), email));
			TypedQuery<Customer> typed = em.createQuery(criteria);
			customer = typed.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		return customer;
	}

}
