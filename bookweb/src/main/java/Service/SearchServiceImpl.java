package Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import BookReport.HibernateUtils;
import model.MemberBean;
import DAO.BookHibernateDaoImpl;
import DAO.SearchBookDAO;
import model.BookBean;
import model.Book_COLLECTBean;

@Service
public class SearchServiceImpl implements SearchService {

	SessionFactory factory = HibernateUtils.getSessionFactory();
	SearchBookDAO dao = new BookHibernateDaoImpl();
	
	
	//查詢書籍關鍵字
	@Override
	public List<BookBean> searchBook(String name){
		List<BookBean> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			list = dao.searchBook(name);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return list;	
	}
	
	
	
	//取得單一本書的詳細資訊
	@Override
	public BookBean getBook(int id) {
		BookBean result = new BookBean();
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			result = dao.getBook(id);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return result;	
	}
	
	
	// 會員收藏清單
	@Override
	public List<Book_COLLECTBean> gotoCollect(int id) {
		List<Book_COLLECTBean> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			list = dao.getCollect(id);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return list;	
	}
	
	
	
	
	
	
	
	// 刪除收藏項目
	@Override
	public int delete(int bcid) {
		int count = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.deletebc(bcid);
			count++;
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return count;
	}
	
	
	
	
	
	
	
	// 新增收藏項目
	@Override
	public int savebc(int bk_ID, int mb_ID) {
		int count = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		
//		Date date = new Date();
		LocalDate d = LocalDate.now();
		java.sql.Date sqlDate = java.sql.Date.valueOf(d) ;

		
		try {
			tx = session.beginTransaction();
			MemberBean member = session.get(MemberBean.class, mb_ID);
			BookBean book = session.get(BookBean.class, bk_ID);
			Book_COLLECTBean bkc=new Book_COLLECTBean(1, sqlDate, null, book, member);
			dao.savebc(bkc);
			count++;
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return count;
	}
	
	
	
	
	// 新增書本
	@Override
	public int savebk(BookBean bkc) {
		int count = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.savebk(bkc);
			count++;
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return count;
	}
	
	
	
	
	
	
	
	// 修改書本
	@Override
	public int updatebk(BookBean mb) {
		int count = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.updatebk(mb);
			count++;
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}	
		return count;
	}
		

}
