package BookRebort;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Types;

public class BookRebortDAO {
	
	private DataSource ds = null;
	private InitialContext ctxt = null;
	private Connection conn = null;
	
	public Connection getConn() throws NamingException, SQLException {
		
		ctxt = new InitialContext();
		ds = ( DataSource ) ctxt.lookup("java:comp/env/jdbc/BookDB");
		conn = ds.getConnection();
		return conn;
	}
	
	public List<BookReportBean> bookReportList(int i){
		List<BookReportBean> list = new ArrayList<BookReportBean>();
		try (Connection connection = getConn();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT br.BK_ID, BR_ID, MB_ID, BR_Score, BR_Content, BR_DateTime, BK_Name ,BK_Writer, BK_Publish ,BK_Time ,BK_Pic "
						+ "FROM BOOK b JOIN BOOK_REPORT br  ON b.BK_ID = br.BK_ID where br.MB_ID = " + i
						);){
			
			while( rs.next() ) {
				
				BookReportBean db = new BookReportBean();
				db.setBk_ID(rs.getInt("BK_ID"));
				db.setBk_Name(rs.getString("BK_Name"));
				db.setBk_Pic(rs.getString("BK_Pic"));
				db.setBk_Publish(rs.getString("BK_Publish"));
				db.setBk_Writer(rs.getString("BK_Writer"));
				db.setBr_content(rs.getString("BR_Content"));
				db.setBr_dateTime(rs.getDate("BR_DateTime"));
				db.setBr_ID(rs.getInt("BR_ID"));
				db.setBr_score(rs.getInt("BR_Score"));
				db.setMb_ID(rs.getInt("MB_ID"));
				db.setBk_ID(rs.getInt("BK_ID"));
				list.add(db);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		System.out.println("Success Select Book Report Data");
		return list;
	}
	
	public List<BookReportBean> bookReportBKList(int i){
		List<BookReportBean> list = new ArrayList<BookReportBean>();
		try (Connection connection = getConn();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT br.BK_ID, BR_ID, MB_ID, BR_Score, BR_Content, BR_DateTime, BK_Name ,BK_Writer, BK_Publish ,BK_Time ,BK_Pic "
						+ "FROM BOOK b JOIN BOOK_REPORT br  ON b.BK_ID = br.BK_ID where br.BK_ID = " + i
						);){
			
			while( rs.next() ) {
				
				BookReportBean db = new BookReportBean();
				db.setBk_ID(rs.getInt("BK_ID"));
				db.setBk_Name(rs.getString("BK_Name"));
				db.setBk_Pic(rs.getString("BK_Pic"));
				db.setBk_Publish(rs.getString("BK_Publish"));
				db.setBk_Writer(rs.getString("BK_Writer"));
				db.setBr_content(rs.getString("BR_Content"));
				db.setBr_dateTime(rs.getDate("BR_DateTime"));
				db.setBr_ID(rs.getInt("BR_ID"));
				db.setBr_score(rs.getInt("BR_Score"));
				db.setMb_ID(rs.getInt("MB_ID"));
				db.setBk_ID(rs.getInt("BK_ID"));
				list.add(db);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		System.out.println("Success Select Book Report Data");
		return list;
	}
	
	public void deleteBookReport(String br_ID) {
		try ( Connection connection = getConn();
				PreparedStatement pstmt = connection.prepareStatement("Delete From BOOK_REPORT Where BR_ID = ?")){
			
			pstmt.setString(1, br_ID);
			pstmt.executeUpdate();
			System.out.println("Success Insert Book Report Data");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
		System.out.println("Success Delete Book Report Data");
	}
	
	public  void upDateBookReportData(int br_ID, int br_Score, String br_Content ) {
		try (Connection connection = getConn();
				PreparedStatement pstmt = connection.prepareStatement("UPDATE BOOK_REPORT "
						+ "SET BR_Score=?, BR_Content= ? ,BR_DateTime= GETDATE() WHERE BR_ID = ?")){
				
			pstmt.setInt(1, br_Score);
			pstmt.setNString(2,  br_Content);
			pstmt.setInt(3, br_ID);
			pstmt.executeUpdate();
			System.out.println("Success UpDate Book Report Data");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
		
		
	}
	
	
	public void insertBookReport(int mb_ID, int bk_ID, int bk_score, String br_Content) {
		try (Connection connection = getConn();
				PreparedStatement pstmt = connection.prepareStatement("Insert into BOOK_REPORT values( ?, ?, ?, ?, GETDATE())")){
			
			pstmt.setInt(1, mb_ID);
			pstmt.setInt(2, bk_ID);
			pstmt.setInt(3, bk_score);
			pstmt.setString(4, br_Content);
			pstmt.executeUpdate();
			System.out.println("Success Insert Book Report Data");
			
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	
}
