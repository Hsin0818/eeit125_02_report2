package BookReport;


import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Hibernate.model.MemberBean;
import book.bean.BookBean;

public class BookRebortDAO {
	
//	private DataSource ds = null;
//	private InitialContext ctxt = null;
//	private Connection conn = null;
	
	private SessionFactory factory = HibernateUtils.getSessionFactory();
	private Session session = null;
	Transaction tx = null;

	@SuppressWarnings("unchecked")
	public List<BookReportBean> bookReportList(int i){
		List<BookReportBean> list = null;
		try {
			session = factory.getCurrentSession();
			tx = session.beginTransaction();
			String hql = "From BookReportBean br Where br.member = :member";
			Query<BookReportBean> query = session.createQuery(hql);
			MemberBean member = session.load(MemberBean.class, i);
			list = query.setParameter("member", member).getResultList();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(false);
		}
//		try (Connection connection = getConn();
//				Statement stmt = connection.createStatement();
//				ResultSet rs = stmt.executeQuery("SELECT br.BK_ID, BR_ID, MB_ID, BR_Score, BR_Content, BR_DateTime, BK_Name ,BK_Writer, BK_Publish ,BK_Time ,BK_Pic "
//						+ "FROM BOOK b JOIN BOOK_REPORT br  ON b.BK_ID = br.BK_ID where br.MB_ID = " + i
//						);){
//			
//			while( rs.next() ) {
//				
//				BookReportBean db = new BookReportBean();
//				db.setBK_ID(rs.getInt("BK_ID"));
//				db.setBK_Name(rs.getString("BK_Name"));
//				db.setBk_Pic(rs.getString("BK_Pic"));
//				db.setBk_Publish(rs.getString("BK_Publish"));
//				db.setBk_Writer(rs.getString("BK_Writer"));
//				db.setBR_Content(rs.getString("BR_Content"));
//				db.setBR_DateTime(rs.getDate("BR_DateTime"));
//				db.setBR_ID(rs.getInt("BR_ID"));
//				db.setBR_Score(rs.getInt("BR_Score"));
//				db.setMB_ID(rs.getInt("MB_ID"));
//				db.setBK_ID(rs.getInt("BK_ID"));
//				list.add(db);
//				
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
		
		System.out.println("Success Select Book Report Data");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<BookReportBean> bookReportBKList(int i){
		List<BookReportBean> list = null;
		try {
			session = factory.getCurrentSession();
			tx = session.beginTransaction();
			String hql = "From BookReportBean br Where br.book = :book";
			Query<BookReportBean> query = session.createQuery(hql);
			BookBean book = session.load(BookBean.class, i);
			list = query.setParameter("book", book).getResultList();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(false);
		}
//		try (Connection connection = getConn();
//				Statement stmt = connection.createStatement();
//				ResultSet rs = stmt.executeQuery("SELECT br.BK_ID, BR_ID, MB_ID, BR_Score, BR_Content, BR_DateTime, BK_Name ,BK_Writer, BK_Publish ,BK_Time ,BK_Pic "
//						+ "FROM BOOK b JOIN BOOK_REPORT br  ON b.BK_ID = br.BK_ID where br.BK_ID = " + i
//						);){
//			
//			while( rs.next() ) {
//				
//				BookReportBean db = new BookReportBean();
//				db.setBK_ID(rs.getInt("BK_ID"));
//				db.setBK_Name(rs.getString("BK_Name"));
//				db.setBk_Pic(rs.getString("BK_Pic"));
//				db.setBk_Publish(rs.getString("BK_Publish"));
//				db.setBk_Writer(rs.getString("BK_Writer"));
//				db.setBR_Content(rs.getString("BR_Content"));
//				db.setBR_DateTime(rs.getDate("BR_DateTime"));
//				db.setBR_ID(rs.getInt("BR_ID"));
//				db.setBR_Score(rs.getInt("BR_Score"));
//				db.setMB_ID(rs.getInt("MB_ID"));
//				db.setBK_ID(rs.getInt("BK_ID"));
//				list.add(db);
//				
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
		
		System.out.println("Success Select Book Report Data");
		return list;
	}
	
	public void deleteBookReport(String br_ID) {
		
		try {
			session = factory.getCurrentSession();
			tx = session.beginTransaction();
			Integer br_id = Integer.valueOf(br_ID);
			BookReportBean bookReport = session.load(BookReportBean.class, br_id);
			session.delete(bookReport);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(false);
		}
//		try ( Connection connection = getConn();
//				PreparedStatement pstmt = connection.prepareStatement("Delete From BOOK_REPORT Where BR_ID = ?")){
//			
//			pstmt.setString(1, br_ID);
//			pstmt.executeUpdate();
//			System.out.println("Success Insert Book Report Data");
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (NamingException e1) {
//			e1.printStackTrace();
//		}
		System.out.println("Success Delete Book Report Data");
	}
	
	public  void upDateBookReportData(int br_ID, int br_Score, String br_Content ) {
		try {
			session = factory.getCurrentSession();
			tx = session.beginTransaction();
			BookReportBean bookReport = session.get(BookReportBean.class, br_ID);
			bookReport.setBR_Score(br_Score);
			bookReport.setBR_Content(br_Content);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(false);
		}
//		try (Connection connection = getConn();
//				PreparedStatement pstmt = connection.prepareStatement("UPDATE BOOK_REPORT "
//						+ "SET BR_Score=?, BR_Content= ? ,BR_DateTime= GETDATE() WHERE BR_ID = ?")){
//				
//			pstmt.setInt(1, br_Score);
//			pstmt.setNString(2,  br_Content);
//			pstmt.setInt(3, br_ID);
//			pstmt.executeUpdate();
//			System.out.println("Success UpDate Book Report Data");
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (NamingException e1) {
//			e1.printStackTrace();
//		}
		
		
	}
	
	
	public void insertBookReport(int mb_ID, int bk_ID, int br_Score, String br_Content) {
		try {
			session = factory.getCurrentSession();
			tx = session.beginTransaction();
			Date date = new Date();
			MemberBean member = session.get(MemberBean.class, mb_ID);
			BookBean book = session.get(BookBean.class, bk_ID);
			BookReportBean bookReport = new BookReportBean(null, br_Score, br_Content, date, book, member);
			session.save(bookReport);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(false);
		}
		
		System.out.println("Success Insert Book Report Data");
//		try (Connection connection = getConn();
//				PreparedStatement pstmt = connection.prepareStatement("Insert into BOOK_REPORT values( ?, ?, ?, ?, GETDATE())")){
//			
//			pstmt.setInt(1, mb_ID);
//			pstmt.setInt(2, bk_ID);
//			pstmt.setInt(3, bk_score);
//			pstmt.setString(4, br_Content);
//			pstmt.executeUpdate();
//			
//			
//		}catch(SQLException e) {
//			e.printStackTrace();
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
	}

	
}
