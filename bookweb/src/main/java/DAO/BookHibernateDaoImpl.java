package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import BookReport.HibernateUtils;
import model.BookBean;
import model.Book_COLLECTBean;

//實作介面或繼承父類別,程式使用時直接寫父類別/介面名稱
public class BookHibernateDaoImpl implements SearchBookDAO {
	SessionFactory factory = HibernateUtils.getSessionFactory();

	// 查詢書籍關鍵字
	// 缺一個判斷list=0就顯示查無此書的判斷式
	@Override
	@SuppressWarnings("unchecked")
	public List<BookBean> searchBook(String name) {
		List<BookBean> list = new ArrayList<>();
		String hql = "FROM BookBean b WHERE b.bk_Name like :searchkw";
		Session session = factory.getCurrentSession();
		Query<BookBean> query = session.createQuery(hql);
		list = query.setParameter("searchkw","%"+ name +"%").getResultList();
		return list;
	}

	// 取得單一本書的詳細資訊
	@Override
	@SuppressWarnings("unchecked")
	public BookBean getBook(int id) {
		BookBean result = new BookBean();
		String hql = "FROM BookBean b WHERE b.bk_ID = :bkid";
		Session session = factory.getCurrentSession();
		Query<BookBean> query = session.createQuery(hql);
		result = query.setParameter("bkid", id).getSingleResult();
		return result;
	}

	// 會員收藏清單
	@Override
	@SuppressWarnings("unchecked")
	public List<Book_COLLECTBean> getCollect(int MB_ID) {
		List<Book_COLLECTBean> list = new ArrayList<>();
		String hql = "From Book_COLLECTBean bc Where bc.member = :mbid";
		Session session = factory.getCurrentSession();
		Book_COLLECTBean bc=session.load(Book_COLLECTBean.class, MB_ID);
		Query<Book_COLLECTBean> query = session.createQuery(hql);
		list = query.setParameter("mbid", bc).getResultList();
		return list;
	}	
	
	// 刪除收藏項目
	@Override
	public int deletebc(int bcid) {
		int count = 0;
		Session session = factory.getCurrentSession();
		Book_COLLECTBean result = session.load(Book_COLLECTBean.class, bcid);		
		session.delete(result);
		count++;
		return count;
	}

	// 新增收藏項目
	@Override
	public int savebc(Book_COLLECTBean bkc) {
		int count = 0;
		Session session = factory.getCurrentSession();
		session.save(bkc);
		count++;
		return count;
	}

	// 新增書本
	@Override
	public int savebk(BookBean bkc) {
		int count = 0;
		Session session = factory.getCurrentSession();
		session.save(bkc);
		count++;
		return count;
	}

	// 修改書本
	@Override
	public int updatebk(BookBean mb) {
		int count = 0;
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(mb);
		count++;
		return count;
	}

}
