package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import Bean.ArticleBean;

public class ArticleDAO implements ArticleDAOInterface {

	private Connection conn;

	public ArticleDAO(Connection conn) {
		this.conn = conn;}

	public ArticleDAO() {}

	//新增貼文DAO
	@Override
	public boolean insertArticle(ArticleBean articleData) {

		String sql = "insert into NOVEL_ARTICLE values(?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, articleData.getArticle_title());
			stmt.setString(2, articleData.getArticle_content());
			boolean insertcount = stmt.execute();
			//判斷是否insert成功
			if (insertcount)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	//修改貼文DAO
	@Override
	public boolean editArticle(ArticleBean articleData, int id) {

		String sql = "update NOVEL_ARTICLE set Title=?,Content=? where ID=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, articleData.getArticle_title());
			stmt.setString(2, articleData.getArticle_content());
			stmt.setInt(3, id);
			int updatecount = stmt.executeUpdate();
			//判斷是否update成功
			if (updatecount >= 1)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	//刪除貼文DAO
	@Override
	public boolean deleteArticle(int id) {

		String sql = "delete from NOVEL_ARTICLE  where ID=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			int updatecount = stmt.executeUpdate();
			//判斷是否delete成功
			if (updatecount >= 1)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
