package BookReport;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Service.ActService;
import Service.ActServiceImpl;
import model.ActBean;
import model.BookBean;
import model.MemberBean;

//import book.bean.BookBean;
//import memberbean.MemberBean;

public class TestMain {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			//tx = session.beginTransaction();
			ActService as = new ActServiceImpl();
			List <ActBean>list = as.getAllActs();
			System.out.println(list.size());
			//tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(false);
		}

	}

}
