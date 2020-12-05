package Service;

import Bean.ArticleBean;

public interface ArticleServiceInterface {

	//insert Service
	boolean insertArticle(ArticleBean articleData);

	//修改貼文DAO
	boolean editArticle(ArticleBean articleData, int id);

	//刪除貼文DAO
	boolean deleteArticle(int id);

}