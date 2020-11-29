package member;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

import memberbean.MemberBean;

public class ModifyDAO {

	private Connection conn;

	// �غc�l
	public ModifyDAO(Connection conn) {
		this.conn = conn;
	}
	public ModifyDAO() {
		// TODO Auto-generated constructor stub
	} 
		
	
	// �s�W�ǥ͸��
	public boolean update(MemberBean data) {
		try {
			String sqlString = "UPDATE BookDB " + "SET  = '" + data.getMB_Password() + "'" + "WHERE MB_Account ="
					+ data.getMB_Account();

			Statement stmt = conn.createStatement();
			int updatecount = stmt.executeUpdate(sqlString);
			stmt.close();
			if (updatecount >= 1)
				return true;
			else
				return false;
		} catch (Exception e) {
			System.err.println("更新部門資料時發生錯誤:" + e);
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

}
