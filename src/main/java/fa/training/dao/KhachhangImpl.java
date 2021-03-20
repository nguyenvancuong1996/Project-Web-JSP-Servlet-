package fa.training.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.entities.Khachhang;
import fa.training.entities.May;
import fa.training.utils.HibernateUtils;

public class KhachhangImpl implements KhachhangDao {

	@Override
	public boolean save(Khachhang khachhang) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Serializable result = session.save(khachhang);
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
	public Khachhang getKhachhang(String maKh) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Khachhang khachhang = session.get(Khachhang.class, maKh);

			return khachhang;

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
	public boolean update(Khachhang khachhang) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(khachhang);
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
	public void deleteByID(String maKH) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Khachhang khachhang = session.get(Khachhang.class, maKH);
			session.delete(khachhang);
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
	public void delete(Khachhang khachhang) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(khachhang);
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
	public List<Khachhang> getAllKhachhang() {
		Session session = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			String hql = "FROM Khachhang";
			Query<Khachhang> query = session.createQuery(hql);

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}

	
	}
}
