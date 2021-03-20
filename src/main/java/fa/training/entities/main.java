package fa.training.entities;

import java.util.List;

import org.hibernate.Session;

import fa.training.dao.MayDao;
import fa.training.dao.MayDaoImpl;
import fa.training.utils.HibernateUtils;

public class main {

	public static void main(String[] args) {
//	MayDao dao = new MayDaoImpl();
//	List <May> dlist = dao.getAllMay();
//	for (May may : dlist) {
//		System.out.println(may);
//	}
		Session session = HibernateUtils.getSessionFactory().openSession();
	}

}
