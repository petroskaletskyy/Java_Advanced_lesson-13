package ua.lviv.lgs.service.impl;

import java.util.List;

import ua.lviv.lgs.dao.BucketOrderDao;
import ua.lviv.lgs.dao.impl.BucketOrderDaoImpl;
import ua.lviv.lgs.domain.BucketOrder;
import ua.lviv.lgs.service.BucketOrderService;

public class BucketOrderServiceImpl implements BucketOrderService {

	private static BucketOrderService bucketOrderServiceImpl;

	private BucketOrderDao bucketOrderDao;

	private BucketOrderServiceImpl() {
		bucketOrderDao = new BucketOrderDaoImpl();
	}

	public static BucketOrderService getBucketOrderService() {
		if (bucketOrderServiceImpl == null) {
			bucketOrderServiceImpl = new BucketOrderServiceImpl();
		}
		return bucketOrderServiceImpl;
	}

	@Override
	public BucketOrder create(BucketOrder t) {
		return bucketOrderDao.create(t);
	}

	@Override
	public BucketOrder read(int id) {
		return bucketOrderDao.read(id);
	}

	@Override
	public BucketOrder update(BucketOrder t) {
		return bucketOrderDao.update(t);
	}

	@Override
	public void delete(int id) {
		bucketOrderDao.delete(id);
	}

	@Override
	public List<BucketOrder> readAll() {
		return bucketOrderDao.readAll();
	}

}
