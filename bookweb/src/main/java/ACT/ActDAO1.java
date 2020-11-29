package ACT;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.classfile.StackMapType;

import ACT.ActBean;
import sun.security.util.Password;

public class ActDAO1 {

	private static Connection conn;

	public ActDAO1(Connection conn) {
		ActDAO1.conn = conn;
	}

	public static Connection getConnection() {

		Connection conn = null;
		try {

			String url = "jdbc:sqlserver://localhost:1433;databaseName=BookDB";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, "sa", "Mm142325094");

			System.out.println(0);

		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
	}

	// 新增活動
	public static int createAct(ActBean act) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into Member_ACTrecord(MB_ID,ACT_Name,ACT_Theme,ACT_Date,ACT_Loc,ACT_Intro,ACT_Guest,ACT_Pax,ACT_Rule,ACT_Tag,ACT_Place) values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, act.getMB_ID());
			ps.setString(2, act.getACT_Name());
			ps.setString(3, act.getACT_Theme());
			ps.setString(4, act.getACT_Date());
			ps.setString(5, act.getACT_Loc());
			ps.setString(6, act.getACT_Intro());
			ps.setString(7, act.getACT_Guest());
			ps.setString(8, act.getACT_Pax());
			ps.setString(9, act.getACT_Rule());
			ps.setString(10, act.getACT_Tag());
			ps.setString(11, act.getACT_Place());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	// 修改活動
	public static int updateAct(ActBean act) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update Member_ACTrecord set ACT_Name=?,ACT_Theme=?,ACT_Date=?,ACT_Loc=?,ACT_Intro=?,ACT_Guest=?,ACT_Pax=?,ACT_Rule=?,ACT_Tag=?,ACT_Place=? where MB_ID=?");

			ps.setString(1, act.getACT_Name());
			ps.setString(2, act.getACT_Theme());
			ps.setString(3, act.getACT_Date());
			ps.setString(4, act.getACT_Loc());
			ps.setString(5, act.getACT_Intro());
			ps.setString(6, act.getACT_Guest());
			ps.setString(7, act.getACT_Pax());
			ps.setString(8, act.getACT_Rule());
			ps.setString(9, act.getACT_Tag());
			ps.setString(10, act.getACT_Place());
			ps.setInt(11, act.getMB_ID());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	// 刪除活動

	public static int deleteAct(String ACT_Name) {
		int status = 0;
		try {
			String sql = "DELETE FROM Member_ACTrecord where ACT_Name=?";
			Connection con = ActDAO1.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			//ps.setInt(1, MB_ID);
			ps.setNString(1, ACT_Name);
			status = ps.executeUpdate();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	/*
	 * //刪除活動方式2 public static boolean deleteAct(int MB_ID, String ACT_Name) {
	 * 
	 * Connection conn = null; Statement stmt = null;
	 * 
	 * try {
	 * 
	 * Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); conn =
	 * DriverManager.getConnection(
	 * "jdbc:sqlserver://localhost:1433;databaseName=BookDB", "user=scott",
	 * "password=tiger"); stmt = conn.createStatement(); String sql
	 * ="DELETE FROM Member_ACTrecord where "+"MB_ID='" +
	 * MB_ID+"'and ACT_Name='"+ACT_Name+"'"; int status = stmt.executeUpdate(sql);
	 * 
	 * System.out.println(status); if(status>0) { System.out.println("刪除成功"); return
	 * true; }else { System.out.println("刪除失敗"); return false; }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }finally{ try { stmt.close(); }
	 * catch (SQLException e) { e.printStackTrace(); } try { conn.close(); } catch
	 * (SQLException e) { e.printStackTrace(); } }
	 * 
	 * return false; }
	 * 
	 */

	// 查詢所有活動
	public static List<ActBean> getAllRecords() {
		List<ActBean> list = new ArrayList<ActBean>();

		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Member_ACTrecord");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ActBean act = new ActBean();
				act.setMB_ID(rs.getInt("MB_ID"));
				act.setACT_Name(rs.getString("ACT_Name"));
				act.setACT_Theme(rs.getString("ACT_Theme"));
				act.setACT_Date(rs.getString("ACT_Date"));
				act.setACT_Loc(rs.getString("ACT_Loc"));
				act.setACT_Intro(rs.getString("ACT_Intro"));
				act.setACT_Guest(rs.getString("ACT_Guest"));
				act.setACT_Pax(rs.getString("ACT_Pax"));
				act.setACT_Rule(rs.getString("ACT_Rule"));
				act.setACT_Tag(rs.getString("ACT_Tag"));
				act.setACT_Place(rs.getString("ACT_Place"));
				list.add(act);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 查詢自己的活動
	public static ActBean getRecordById(int MB_ID) {
		ActBean act = new ActBean();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Member_ACTrecord where MB_ID=?");
			ps.setInt(1, MB_ID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				act = new ActBean();
				act.setMB_ID(rs.getInt("MB_ID"));
				act.setACT_Name(rs.getString("ACT_Name"));
				act.setACT_Theme(rs.getString("ACT_Theme"));
				act.setACT_Date(rs.getString("ACT_Date"));
				act.setACT_Loc(rs.getString("ACT_Loc"));
				act.setACT_Intro(rs.getString("ACT_Intro"));
				act.setACT_Guest(rs.getString("ACT_Guest"));
				act.setACT_Pax(rs.getString("ACT_Pax"));
				act.setACT_Rule(rs.getString("ACT_Rule"));
				act.setACT_Tag(rs.getString("ACT_Tag"));
				act.setACT_Place(rs.getString("ACT_Place"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return act;
	}

}
