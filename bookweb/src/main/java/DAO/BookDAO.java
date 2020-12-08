package DAO;
// DAO: Database Access Object
// �M�d�PDept Table���s�W,�ק�,�R���P�d��

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.BookBean;

public class BookDAO {

  private static Connection conn;

  public BookDAO(Connection conn) {
		BookDAO.conn = conn;
  }

  
public static Connection getConnection(){  

	Connection conn=null;  
	    try {		
	    	
	    String url="jdbc:sqlserver://localhost:1433;databaseName=BookDB";
	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    conn=DriverManager.getConnection(url, "sa", "Mm142325094");
	    
//	    InitialContext ctxt = new InitialContext();
//		DataSource ds = ( DataSource ) ctxt.lookup("java:comp/env/jdbc/EmployeeDB");
		System.out.println(0);
		
	    }catch(Exception e){System.out.println(e);}  
	    return conn;  
	}  
  


  public BookDAO() {
  } 
  
  
  
  //查詢方法
  
  public static List<BookBean> searchBook(String name) {

	List<BookBean> list = new ArrayList<>();
	
    try {
    	Connection conn =getConnection(); 
        Statement stmt = conn.createStatement();
        name = "'%" + name + "%'";
        String sqlString = "SELECT * FROM BOOK WHERE BK_Name like " + name;
        ResultSet rs = stmt.executeQuery(sqlString);
        
        while (rs.next()) {
        	BookBean dep = new BookBean();
        	
        	dep.setBk_ID(rs.getInt("BK_ID"));
        	dep.setBk_Name(rs.getString("BK_Name"));
        	dep.setBk_Writer(rs.getString("BK_Writer"));
        	dep.setBk_Publish(rs.getString("BK_Publish"));
        	dep.setBk_Time(rs.getDate("BK_Time"));
        	dep.setBk_Pic(rs.getString("BK_Pic"));
        	dep.setBk_Content(rs.getString("BK_Content"));
        	//dep.setURL(rs.getString("URL"));
        	list.add(dep);
        }
  	  rs.close();
  	  stmt.close();
    	

	  } catch (Exception e) {
	    System.err.println("尋找時發生錯誤" + e);
    }
    return list;
	
  }


  
  
  
  //詳細書訊
  
  public BookBean getBook(int b) {

	  BookBean dep = new BookBean();
	  
    try {
    	System.out.println(000);
    	Connection conn =getConnection(); 
        Statement stmt = conn.createStatement();
        String sqlString = "SELECT * FROM BOOK WHERE BK_ID="+b;
        ResultSet rs = stmt.executeQuery(sqlString);
        System.out.println(1);
        
        while (rs.next()) {
        	
        	dep.setBk_ID(rs.getInt("BK_ID"));
        	dep.setBk_Name(rs.getString("BK_Name"));
        	dep.setBk_Writer(rs.getString("BK_Writer"));
        	dep.setBk_Publish(rs.getString("BK_Publish"));
        	dep.setBk_Time(rs.getDate("BK_Time"));
        	dep.setBk_Pic(rs.getString("BK_Pic"));
        	dep.setBk_Content(rs.getString("BK_Content"));
        }
        System.out.println(3);
  	  rs.close();   	

	  } catch (Exception e) {
	    System.err.println("尋找時發生錯誤" + e);
	  }
    
    System.out.println(4);
    return dep;
  }
  
  
  
  
  
  
  
  
  
//會員收藏清單  
  
  public static List<BookBean> getCollect(int MB_ID) {

	  	List<BookBean> list2 = new ArrayList<>();
		BookBean dep = null;
	    try {
	 
//	        Statement stmt = conn.createStatement();
//	        String sqlString = "SELECT * FROM (BOOK1 A LEFT JOIN BOOK_COLLECT B ON A.BK_ID=B.BK_ID)" + 
//	        		"WHERE MB_ID="+account;
	    	Connection conn =getConnection(); 
	    	PreparedStatement ps=conn.prepareStatement("SELECT DISTINCT * FROM (BOOK A LEFT JOIN BOOK_COLLECT B ON A.BK_ID=B.BK_ID) WHERE MB_ID = ?;");
	        ps.setInt(1,MB_ID);

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {

	        	dep = new BookBean();
	        	dep.setBk_ID(rs.getInt("BK_ID"));
	        	dep.setBk_Name(rs.getString("BK_Name"));
	        	dep.setBk_Writer(rs.getString("BK_Writer"));
	        	dep.setBk_Publish(rs.getString("BK_Publish"));
	        	dep.setBk_Time(rs.getDate("BK_Time"));
	        	dep.setBk_Pic(rs.getString("BK_Pic"));
	        	dep.setBk_Content(rs.getString("BK_Content"));
	        	//dep.setURL(rs.getString("URL"));
	        	list2.add(dep);
	        }

	  	  rs.close();
	    	

		  } catch (Exception e) {
		    System.err.println("尋找時發生錯誤" + e);
		  }
	    return list2;
	    
	  }
  
  
  //刪除
  
  public static int delete(int a, int b){  
	    int status=0;
	    try{  
	    	Connection conn =getConnection();      
	        PreparedStatement ps=conn.prepareStatement("DELETE FROM BOOK_COLLECT WHERE BK_ID = ? and MB_ID = ?;");  
	        ps.setInt(1,a);
	        ps.setInt(2,b);

	        status=ps.executeUpdate();  
	        
	    }catch(Exception e){System.out.println(e);}  
	  
	    return status;  
	}  
  
  
  
  //新增
  public static int create(int a, int b){  
	    int status=0;
	    try{  
	    	Connection conn =getConnection(); 
	        PreparedStatement ps=conn.prepareStatement("INSERT INTO BOOK_COLLECT(BK_ID,MB_ID,BC_Time,BC_Tag) VALUES(?,?,getdate(),null)");  
	        ps.setInt(1,a);
	        ps.setInt(2,b);

	        status=ps.executeUpdate();  
	        
	    }catch(Exception e){System.out.println(e);}  
	  
	    return status;  
	}
  //修改
	public static boolean update(int id, String name, String writer, String publish, Date booktime, String bookcontent){  
	    int status=0;
	    try{  
	    	Connection conn =getConnection(); 

	        String sqlString = "UPDATE BOOK SET BK_Name='"+name+"', BK_Writer='"+writer+"', BK_Publish='"+publish+"', BK_Time='"+booktime+"', BK_Content='"+bookcontent+"' WHERE BK_ID='"+id+"'";
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sqlString);

	        if (status >= 1) return true;
	        else                  return false;
	        
	    }catch(Exception e){System.out.println(e); return false;}  
	  
	   
	} 
}