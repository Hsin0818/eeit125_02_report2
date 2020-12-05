package DAO;

import Bean.ArticleBean;

public interface ArticleDAOInterface {

	//新增貼文DAO
	boolean insertArticle(ArticleBean articleData);

	//修改貼文DAO
	boolean editArticle(ArticleBean articleData, int id);

	//刪除貼文DAO
	boolean deleteArticle(int id);

}