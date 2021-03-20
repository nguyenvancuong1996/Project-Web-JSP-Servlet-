package fa.training.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.entities.May;
import fa.training.utils.HibernateUtils;

public class MayDaoImpl implements MayDao {
	public boolean save(May one) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Serializable result = session.save(one);
			// trong hibernate sau khi thuc hien dua xuong data phai co commit day la luu
			// xuong data
			transaction.commit();
			return (result != null);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return false;
	}

	@Override
	public May getMay(String maMay) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			May may = session.get(May.class, maMay);

			return may;

		} catch (Exception e) {
			e.printStackTrace();

			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}


	@Override
	public boolean update(May may) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(may);
			transaction.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return false;
	}

	@Override
	public boolean deleteByID(String maMay) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			May may = session.get(May.class, maMay);
			session.delete(may);
			transaction.commit();
			System.out.println("delete thanh cong");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("k xoa duoc");
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return false;
	}
	@Override
	public void delete(May may) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(may);
			transaction.commit();
			System.out.println("delete thanh cong");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("k xoa duoc");
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	@Override
	public List<May> getAllMay() {
		Session session = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			String hql = "FROM May";
			Query<May> query = session.createQuery(hql);

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}

	}
}
