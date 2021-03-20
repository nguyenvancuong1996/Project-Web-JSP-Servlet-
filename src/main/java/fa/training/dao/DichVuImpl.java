package fa.training.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.entities.DichVu;
import fa.training.utils.HibernateUtils;

public class DichVuImpl implements DichVuDao {

	@Override
	public boolean save(DichVu dichvu) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Serializable result = session.save(dichvu);
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
	public DichVu getDichVu(String maDv) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			DichVu dichvu = session.get(DichVu.class, maDv);

			return dichvu;

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
	public boolean update(DichVu dv) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(dv);
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
	public void deleteByID(String maDv) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			DichVu dichvu = session.get(DichVu.class, maDv);
			session.delete(dichvu);
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
	public void delete(DichVu dichvu) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(dichvu);
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
	public List<DichVu> getAllDichVu() {
		Session session = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			String hql = "FROM DichVu";
			Query<DichVu> query = session.createQuery(hql);

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}

	}
}
