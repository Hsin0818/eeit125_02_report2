package member;


import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import memberbean.MemberBean;



public class MemberDAO {

	private Connection conn;

	public MemberDAO(Connection conn) {
		this.conn = conn;
	}

	public boolean insertMember(MemberBean memberData) {
		try {
			String sql = "insert into MEMBERS values('" + memberData.getMB_Account() + "','"
					+ memberData.getMB_Password() + "','" + memberData.getMB_Sex() + "','" + memberData.getMB_Birthday()
					+ "','" + memberData.getMB_Name() + "','" + memberData.getMB_Mail() + "','" + memberData.getMB_Tel()
					+ "','" + memberData.getMB_Address()+ "','" + null + "','" + 0 + "','" + memberData.getMB_type() + "')";

			Statement stmt = conn.createStatement();
			System.out.println(sql);
			int updatecount = stmt.executeUpdate(sql);
			stmt.close();
			if (updatecount >= 1)
				return true;
			else
				return false;
		} catch (Exception e) {
			System.err.println("�s�W�ǥ͸�Ʈɵo�Ϳ��~:" + e);
			return false;
		}
	}
	public boolean Login(String account , String pwd) {	
		try {
			String sql = "select * from MEMBERS where MB_Account = '"+account+"'and MB_Password= '"+pwd+"'";
			
			Statement stmt = conn.createStatement();	
			ResultSet a = stmt.executeQuery(sql);
			return a.next();
		} catch (Exception e) {
			System.err.println("�s�W�ǥ͸�Ʈɵo�Ϳ��~:" + e);
			return false;
		}
	}
	public boolean update(String account,String pwd) {
		try {
			String sqlString = "UPDATE MEMBERS SET MB_Password='"+pwd+"' "+ "WHERE MB_Account ='"+account+"'";
			Statement stmt = conn.createStatement();
			int updatecount = stmt.executeUpdate(sqlString);
			stmt.close();
			if (updatecount >= 1)
				return true;
			else
				return false;
		} catch (Exception e) {
			System.err.println("更新資料時發生錯誤:" + e);
			return false;
		}
	}

	public MemberBean select(String data) {
		try {
			Statement stmt = conn.createStatement();
			String sqlString = "SELECT * FROM MEMBERS WHERE MB_Account ='"+data+"'";

			ResultSet rs = stmt.executeQuery(sqlString);
			MemberBean dep = null;
			String Account;
			String Password;
			String Sex;
			Date Birthday;
			String Name;
			String Mail;
			String Tel;
			String Address;
			String type;
			while (rs.next()) {
				Account = rs.getString("MB_Account");
				Password = rs.getString("MB_Password");
				Sex = rs.getString("MB_Sex");
				Birthday = Date.valueOf(rs.getString("MB_Birthday"));
				Name = rs.getString("MB_Name");
				Mail = rs.getString("MB_Mail");
				Tel = rs.getString("MB_Tel");
				Address = rs.getString("MB_Address");
				type = rs.getString("MB_type");
				dep = new MemberBean(Account, Password,Sex,Birthday,Name,Mail,Tel,Address, null, 0, type);
			}
			System.out.println(1);
			return dep;
			
		} catch (Exception e) {
			System.err.println("錯誤" + e);
		}
		return null ;
	}

	public List<MemberBean> adminselect(){
		List<MemberBean> dep = new ArrayList<MemberBean>();
		try {
			Statement stmt = conn.createStatement();
			String sqlString = "SELECT * FROM MEMBERS ";
			ResultSet rs = stmt.executeQuery(sqlString);
//			String Account;
//			String Password;
//			String Sex;
//			Date Birthday;
//			String Name;
//			String Mail;
//			String Tel;
//			String Address;
//			String Dates;
//			int Lv;
//			String type;
			while (rs.next()) {
				MemberBean a = new MemberBean();
				a.setMB_ID(rs.getInt("MB_ID"));
				a.setMB_Account(rs.getString("MB_Account"));
				a.setMB_Password(rs.getString("MB_Password"));
				a.setMB_Sex(rs.getString("MB_Sex"));
				a.setMB_Birthday(Date.valueOf(rs.getString("MB_Birthday")));
				a.setMB_Name(rs.getString("MB_Name"));
				a.setMB_Mail(rs.getString("MB_Mail"));
				a.setMB_Tel(rs.getString("MB_Tel"));
				a.setMB_Address(rs.getString("MB_Address"));
				a.setMB_Date(rs.getString("MB_Date"));
				a.setMB_Lv(rs.getInt("MB_Lv"));
				a.setMB_type(rs.getString("MB_type"));
				dep.add(a);
			}
			System.out.print(dep);
			return dep;
		} catch (Exception e) {
			System.err.println("錯誤" + e);
		}
		return null ;
	}
	public boolean delete(int data) {
		try {
			Statement stmt = conn.createStatement();
			String sqlInt = "delete from MEMBERS where MB_ID ="+data ;
			int deletecount = stmt.executeUpdate(sqlInt);
			stmt.close();
		      if (deletecount >= 1) return true;				
		} catch (Exception e) {
			System.err.println("錯誤" + e);
		}
		return false;
	}
	
}
