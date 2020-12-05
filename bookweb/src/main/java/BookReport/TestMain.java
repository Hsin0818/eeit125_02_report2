package BookReport;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
			tx = session.beginTransaction();
			BookBean bk = session.get(BookBean.class, 20);
			MemberBean mebeber = new MemberBean(null, "aaa111", "aaa111", null, null, null, null, null, null, null, null, null, null);
			session.save(mebeber);
			System.out.println(bk);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(false);
		}

	}

}
