package BookReport;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import book.bean.BookBean;
import memberbean.MemberBean;

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
			String hql = "From BookReportBean br Where br.member = :member";
			Query<BookReportBean> query = session.createQuery(hql);
			MemberBean member = session.load(MemberBean.class, 5);
			List<BookReportBean> list = query.setParameter("member", member).getResultList();
			System.out.println(list.get(1).getBR_ID());
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(false);
		}

	}

}
