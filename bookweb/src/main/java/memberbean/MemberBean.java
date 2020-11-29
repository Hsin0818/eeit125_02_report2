package memberbean;

import java.io.Serializable;
import java.sql.Date;




public class MemberBean implements Serializable {
	private int MB_ID;
	private String MB_Account;
	private String MB_Password;
	private String MB_Sex;
	private Date MB_Birthday;
	private String MB_Name;
	private String MB_Mail;
	private String MB_Tel;
	private String MB_Address;
	private String MB_Date;
	private int MB_Lv;
	private String MB_type;

	public MemberBean()
	  {
	  }
	
	public MemberBean(String MB_Account, String MB_Password, String MB_Sex, Date MB_Birthday,
            String MB_Name, String MB_Mail, String MB_Tel, String MB_Address,String MB_Date,int MB_Lv, String MB_type)
	{
		this.MB_Account = MB_Account;
		this.MB_Password = MB_Password;
		this.MB_Sex = MB_Sex;
		this.MB_Birthday = MB_Birthday;
		this.MB_Name = MB_Name;
		this.MB_Mail = MB_Mail;
		this.MB_Tel = MB_Tel;
		this.MB_Address = MB_Address;
		this.MB_Date = MB_Date;
		this.MB_Lv = MB_Lv;
		this.MB_type = MB_type;
	}

	public MemberBean(String MB_Account) {
		this.MB_Account=MB_Account;
	}

	public String getMB_Account() {
		return MB_Account;
	}

	public void setMB_Account(String mB_Account) {
		MB_Account = mB_Account;
	}

	public String getMB_Password() {
		return MB_Password;
	}

	public void setMB_Password(String mB_Password) {
		MB_Password = mB_Password;
	}

	public String getMB_Sex() {
		return MB_Sex;
	}

	public void setMB_Sex(String mB_Sex) {
		MB_Sex = mB_Sex;
	}

	public Date getMB_Birthday() {
		return MB_Birthday;
	}

	public void setMB_Birthday(Date mB_Birthday) {
		MB_Birthday = mB_Birthday;
	}

	public String getMB_Name() {
		return MB_Name;
	}

	public void setMB_Name(String mB_Name) {
		MB_Name = mB_Name;
	}

	public String getMB_Mail() {
		return MB_Mail;
	}

	public void setMB_Mail(String mB_Mail) {
		MB_Mail = mB_Mail;
	}

	public String getMB_Tel() {
		return MB_Tel;
	}

	public void setMB_Tel(String mB_Tel) {
		MB_Tel = mB_Tel;
	}

	public String getMB_Address() {
		return MB_Address;
	}

	public void setMB_Address(String mB_Address) {
		MB_Address = mB_Address;
	}

	public String getMB_Date() {
		return MB_Date;
	}

	public void setMB_Date(String mB_Date) {
		MB_Date = mB_Date;
	}

	public int getMB_Lv() {
		return MB_Lv;
	}

	public void setMB_Lv(int mB_Lv) {
		MB_Lv = mB_Lv;
	}

	public String getMB_type() {
		return MB_type;
	}

	public void setMB_type(String mB_type) {
		MB_type = mB_type;
	}
	public int getMB_ID() {
		return MB_ID;
	}

	public void setMB_ID(int mB_ID) {
		MB_ID = mB_ID;
	}

}

	
