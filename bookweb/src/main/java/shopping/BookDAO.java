package shopping;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
import java.util.List;

//import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.BookBean;
import utils.HibernateUtils;

public class BookDAO {

//	private Connection conn;
//	DataSource ds = null;

	private SessionFactory factory = HibernateUtils.getSessionFactory();
	private Session session = null;
	Transaction tx = null;

//	public BookDAO() {
//
//	}
//
//	public BookDAO(Connection conn) {
//		this.conn = conn;
//	}
	
	@SuppressWarnings("unchecked")
	public BookBean selectBookID(int id) {
		try {
			session = factory.getCurrentSession();
			tx = session.beginTransaction();
			String hql = "FROM BookBean a WHERE a.bk_ID = :bkid";
			Query<BookBean> query = session.createQuery(hql);
			BookBean data = query.setParameter("bkid", id).getSingleResult();
			tx.commit();
			System.out.println("Success");
			return data;
		} catch (Exception e) {
			tx.rollback();
			System.out.println(false);
		}
		return null;

//		try {
//			Statement stmt = conn.createStatement();
//			String sql = "select BK_ID, BK_Name, BK_Writer, BK_Publish, BK_Content, BK_Pic from BOOK where BK_ID = "
//					+ data.getBookid();
//			ResultSet rs = stmt.executeQuery(sql);
//			if (rs.next()) {
//				data.setBookid(rs.getInt("BK_ID"));
//				data.setBookname(rs.getString("BK_Name"));
//				data.setBookauthor(rs.getString("BK_Writer"));
//				data.setBookpublish(rs.getString("BK_Publish"));
//				data.setContent(rs.getString("BK_Content"));
//				data.setUrl(rs.getString("BK_Pic"));
//				data = new BookData(data.getBookid(), data.getBookname(), data.getBookauthor(), data.getBookpublish(),
//						data.getBookprice(), data.getBookqty(), data.getUrl(), data.getContent());
//			}
//			rs.close();
//			stmt.close();
//			return data;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return null;
	}

	public void insertBook(int BS_Num, int BS_price, int BK_ID, int BS_ID) {

		try {
			session = factory.getCurrentSession();
			tx = session.beginTransaction();
			Book_Store book_Store = new Book_Store(null, BS_Num, BS_price, BK_ID, BS_ID);
			session.save(book_Store);
			tx.commit();
			System.out.println("Success");
		} catch (Exception e) {
			tx.rollback();
			System.out.println(false);
		}

//		try {
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(3, data.getBookid());
//			ps.setInt(2, data.getBookprice());
//			ps.setInt(1, data.getBookqty());
//			ps.executeUpdate();
//			data = new BookData(data.getBookid(), data.getBookname(), data.getBookauthor(), data.getBookpublish(),
//					data.getBookprice(), data.getBookqty(),data.getUrl(), data.getContent());
//			ps.close();
//			return data;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
	}

	public void updateBook(int BS_Num, int BS_price, int BK_ID) {

		try {
			session = factory.getCurrentSession();
			tx = session.beginTransaction();
			Book_Store book_Store = session.get(Book_Store.class, BK_ID);
			book_Store.setBS_Num(BS_Num);
			book_Store.setBS_price(BS_price);
			tx.commit();
			System.out.println("Success");
		} catch (Exception e) {
			tx.rollback();
			System.out.println(false);
		}

//		String sql = "update BOOK_STORE set BS_Num=?, BS_price=? where BK_ID =?";
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, data.getBookqty());
//			ps.setInt(2, data.getBookprice());
//			ps.setInt(3, data.getBookid());
//			ps.executeUpdate();
//			data = new BookData(data.getBookid(), data.getBookname(), data.getBookauthor(), data.getBookpublish(),
//					data.getBookprice(), data.getBookqty(),data.getUrl(), data.getContent());
//			ps.close();
//			return data;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return null;
	}

	public void deleteBook(int BKS_ID) {
		try {
			session = factory.getCurrentSession();
			tx = session.beginTransaction();
			Book_Store book_Store = session.load(Book_Store.class, BKS_ID);
			session.delete(book_Store);
			tx.commit();
			System.out.println("Success");
		} catch (Exception e) {
			tx.rollback();
			System.out.println(false);
		}
		

//		try {
//			Statement ps = conn.createStatement();
//			String sql = "delete from BOOK_STORE where BKS_ID =" + data.getBookid();
//			ResultSet rs = ps.executeQuery(sql);
//			data = new BookData(data.getBookid(), data.getBookname(), data.getBookauthor(), data.getBookpublish(),
//					data.getBookprice(), data.getBookqty(),data.getUrl(), data.getContent());
//			ps.close();
//			return data;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return null;
	}

	// List<BookData> listBookData()
	@SuppressWarnings("unchecked")
	public List<BookBean> listBookData(String Bookname) {
		
		
		List<BookBean> list = null;
		try {
			session = factory.getCurrentSession();
			tx = session.beginTransaction();
			String hql = "From BookBean a Where a.bk_Name like :bkname";
			Query<BookBean> query = session.createQuery(hql);
			list = query.setParameter("bkname", "%" + Bookname + "%").getResultList();
			tx.commit();
			System.out.println("Success");
			return list;
		} catch (Exception e) {
			tx.rollback();
			System.out.println(false);
		}
		return null;
 
		
//		try {
//			List<BookData> list = new ArrayList<>();
//			Statement stmt = conn.createStatement();
//			String sql = "select * from BOOK where BK_Name like '%" + data.getBookname() + "%' ";
//			ResultSet rs = stmt.executeQuery(sql);
//			while (rs.next()) {
//				data.setBookid(rs.getInt("BK_ID"));
//				data.setBookname(rs.getString("BK_Name"));
//				data.setBookauthor(rs.getString("BK_Writer"));
//				data.setBookpublish(rs.getString("BK_Publish"));
//				data.setContent(rs.getString("BK_Content"));
//				data.setUrl(rs.getString("BK_Pic"));
//				data = new BookData(data.getBookid(), data.getBookname(), data.getBookauthor(), data.getBookpublish(),
//						data.getBookprice(), data.getBookqty(), data.getUrl(), data.getContent());
//				list.add(data);
//			}
//			rs.close();
//			stmt.close();
//			return list;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return null;
	}

}
