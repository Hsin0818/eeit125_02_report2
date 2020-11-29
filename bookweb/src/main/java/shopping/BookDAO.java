package shopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class BookDAO {

	private Connection conn;

	DataSource ds = null;

	public BookDAO() {

	}

	public BookDAO(Connection conn) {
		this.conn = conn;
	}

	public BookData selectBookID(BookData data) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "select BK_ID, BK_Name, BK_Writer, BK_Publish, BK_Content, BK_Pic from BOOK where BK_ID = "
					+ data.getBookid();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				data.setBookid(rs.getInt("BK_ID"));
				data.setBookname(rs.getString("BK_Name"));
				data.setBookauthor(rs.getString("BK_Writer"));
				data.setBookpublish(rs.getString("BK_Publish"));
				data.setContent(rs.getString("BK_Content"));
				data.setUrl(rs.getString("BK_Pic"));
				data = new BookData(data.getBookid(), data.getBookname(), data.getBookauthor(), data.getBookpublish(),
						data.getBookprice(), data.getBookqty(), data.getUrl(), data.getContent());
			}
			rs.close();
			stmt.close();
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public BookData insertBook(BookData data) {
		String sql = "insert into BOOK_STORE (BS_Num, BS_price, BK_ID, BS_ID)\r\n" + 
				"values(?, ?, ?, 1);";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(3, data.getBookid());
			ps.setInt(2, data.getBookprice());
			ps.setInt(1, data.getBookqty());
			ps.executeUpdate();
			data = new BookData(data.getBookid(), data.getBookname(), data.getBookauthor(), data.getBookpublish(),
					data.getBookprice(), data.getBookqty(),data.getUrl(), data.getContent());
			ps.close();
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public BookData updateBook(BookData data) {

		String sql = "update BOOK_STORE set BS_Num=?, BS_price=? where BK_ID =?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, data.getBookqty());
			ps.setInt(2, data.getBookprice());
			ps.setInt(3, data.getBookid());
			ps.executeUpdate();
			data = new BookData(data.getBookid(), data.getBookname(), data.getBookauthor(), data.getBookpublish(),
					data.getBookprice(), data.getBookqty(),data.getUrl(), data.getContent());
			ps.close();
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public BookData deleteBook(BookData data) {

		try {
			Statement ps = conn.createStatement();
			String sql = "delete from BOOK_STORE where BKS_ID =" + data.getBookid();
			ResultSet rs = ps.executeQuery(sql);
			data = new BookData(data.getBookid(), data.getBookname(), data.getBookauthor(), data.getBookpublish(),
					data.getBookprice(), data.getBookqty(),data.getUrl(), data.getContent());
			ps.close();
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	//List<BookData> listBookData()
	public List<BookData> listBookData(BookData data) {
		try {
			List<BookData> list = new ArrayList<>();
			Statement stmt = conn.createStatement();
			String sql = "select * from BOOK where BK_Name like '%"+data.getBookname()+"%' ";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				data.setBookid(rs.getInt("BK_ID"));
				data.setBookname(rs.getString("BK_Name"));
				data.setBookauthor(rs.getString("BK_Writer"));
				data.setBookpublish(rs.getString("BK_Publish"));
				data.setContent(rs.getString("BK_Content"));
				data.setUrl(rs.getString("BK_Pic"));
				data = new BookData(data.getBookid(), data.getBookname(), data.getBookauthor(), data.getBookpublish(),
						data.getBookprice(), data.getBookqty(), data.getUrl(), data.getContent());
				list.add(data);
			}
			rs.close();
			stmt.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
