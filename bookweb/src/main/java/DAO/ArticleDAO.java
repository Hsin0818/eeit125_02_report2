package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import SetConnection.HibernateUtils;
import model.ArticleBean;

public class ArticleDAO implements ArticleDAOInterface {

	SessionFactory factory = HibernateUtils.getSessionFactory();


	//新增貼文DAO
	@Override
	public boolean insertArticle(ArticleBean articleData) {
		boolean result = false;
		Session session = factory.getCurrentSession();
		Object savefunc = session.save(articleData);
		if (savefunc!=null) {
			result = true;
		}		
		return result;
	}

	//修改貼文DAO
	@Override
	public boolean editArticle(ArticleBean articleData, int id) {
		boolean result = false;
		Session session = factory.getCurrentSession();
		String hql = "update ArticleBean set Title=:article_title,Content=:article_content where ID=:id";
		int editcount = session.createQuery(hql)
				.setParameter("article_title", articleData.getArticle_title())
				.setParameter("article_content", articleData.getArticle_content())
				.setParameter("id", id)
				.executeUpdate();
		if (editcount>0) {
			result = true;
		}
			return result;
	}

	//刪除貼文DAO
	@Override
	public boolean deleteArticle(int id) {
		boolean result = false;
		Session session = factory.getCurrentSession();
		String hql = "delete from ArticleBean  where ID=:id";
		int deletecount = session.createQuery(hql)
				.setParameter("id", id)
				.executeUpdate();
		if (deletecount>0) {
			result = true;
		}
			return result;
	}

}
