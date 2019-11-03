package ua.lviv.lgs.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ua.lviv.lgs.dao.BucketOrderDao;
import ua.lviv.lgs.domain.BucketOrder;
import ua.lviv.lgs.shared.FactoryManager;

public class BucketOrderDaoImpl implements BucketOrderDao {

	private EntityManager em = FactoryManager.getEntityManager();

	@Override
	public BucketOrder create(BucketOrder bucketOrder) {
		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			em.persist(bucketOrder);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bucketOrder;
	}

	@Override
	public BucketOrder read(int id) {

		BucketOrder bucketOrder = null;
		try {
			bucketOrder = em.find(BucketOrder.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bucketOrder;
	}

	@Override
	public BucketOrder update(BucketOrder t) {
		throw new IllegalStateException("No update for bucket_order");
	}

	@Override
	public void delete(int id) {
		try {
			BucketOrder bucket = read(id);
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			em.remove(bucket);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BucketOrder> readAll() {
		Query query = null;
		try { 
			query = em.createQuery("SELECT e FROM BucketOrder e");
			if (!query.getResultList().isEmpty()) {
				return query.getResultList();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
