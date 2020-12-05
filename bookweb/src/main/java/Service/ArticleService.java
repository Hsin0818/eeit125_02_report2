package Service;

import java.sql.PreparedStatement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import DAO.ArticleDAO;
import DAO.ArticleDAOInterface;
import SetConnection.HibernateUtils;
import model.ArticleBean;

public class ArticleService implements ArticleServiceInterface {
	
	SessionFactory factory = HibernateUtils.getSessionFactory();
	ArticleDAOInterface dao = new ArticleDAO();
	
	//insert Service
	@Override
	public boolean insertArticle(ArticleBean articleData) {
		boolean result = false;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			result = dao.insertArticle(articleData);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return result;
	}

	//edit Service
	@Override
	public boolean editArticle(ArticleBean articleData, int id) {
		boolean result = false;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			result = dao.editArticle(articleData, id);
			tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			}
			return result;
	}

	//刪除貼文DAO
	@Override
	public boolean deleteArticle(int id) {
		boolean result = false;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			result = dao.deleteArticle(id);
			tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			}
			return result;
	}
}
