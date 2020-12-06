package Service;

import java.sql.PreparedStatement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Bean.ArticleBean;
import DAO.ArticleDAO;
import DAO.ArticleDAOInterface;

@Service
public class ArticleService implements ArticleServiceInterface {
	
	@Autowired
	SessionFactory factory;
	@Autowired
	ArticleDAOInterface dao;
	
	//insert Service
	@Transactional
	@Override
	public boolean insertArticle(ArticleBean articleData) {
		return dao.insertArticle(articleData);
	}

	//edit Service
	@Transactional
	@Override
	public boolean editArticle(ArticleBean articleData, int id) {
		return dao.editArticle(articleData, id);
	}

	//刪除貼文DAO
	@Transactional
	@Override
	public boolean deleteArticle(int id) {
		return dao.deleteArticle(id);
	}
}
