package model;


import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table; 

@Entity
@Table(name="MEMBERS")
public class MemberBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mB_ID;
	private String mB_Account;
	private String mB_Password;
	private String mB_Sex;
	private Date mB_Birthday;
	private String mB_Name;
	private String mB_Mail;
	private String mB_Tel;
	private String mB_Address;
	private Timestamp mB_Date;
	private Integer mB_Lv;
	private String mB_type;
	private Blob mB_pic;
	
	public MemberBean() {
		super();
	}
	
	
	public MemberBean(Integer mB_ID, String mB_Account, String mB_Password, String mB_Sex, Date mB_Birthday,
			String mB_Name, String mB_Mail, String mB_Tel, String mB_Address, Timestamp mB_Date, Integer mB_Lv,
			String mB_type,Blob mB_pic) {
		super();
		this.mB_ID = mB_ID;
		this.mB_Account = mB_Account;
		this.mB_Password = mB_Password;
		this.mB_Sex = mB_Sex;
		this.mB_Birthday = mB_Birthday;
		this.mB_Name = mB_Name;
		this.mB_Mail = mB_Mail;
		this.mB_Tel = mB_Tel;
		this.mB_Address = mB_Address;
		this.mB_Date = mB_Date;
		this.mB_Lv = mB_Lv;
		this.mB_type = mB_type;
		this.mB_pic=mB_pic;
	}

	public Blob getmB_pic() {
		return mB_pic;
	}

	public void setmB_pic(Blob mB_pic) {
		this.mB_pic = mB_pic;
	}

	
	public int getmB_ID() {
		return mB_ID;
	}

	public void setmB_ID(Integer mB_ID) {
		this.mB_ID = mB_ID;
	}

	public String getmB_Account() {
		return mB_Account;
	}

	public void setmB_Account(String mB_Account) {
		this.mB_Account = mB_Account;
	}

	public String getmB_Password() {
		return mB_Password;
	}

	public void setmB_Password(String mB_Password) {
		this.mB_Password = mB_Password;
	}

	public String getmB_Sex() {
		return mB_Sex;
	}

	public void setmB_Sex(String mB_Sex) {
		this.mB_Sex = mB_Sex;
	}

	public Date getmB_Birthday() {
		return mB_Birthday;
	}

	public void setmB_Birthday(Date mB_Birthday) {
		this.mB_Birthday = mB_Birthday;
	}

	public String getmB_Name() {
		return mB_Name;
	}

	public void setmB_Name(String mB_Name) {
		this.mB_Name = mB_Name;
	}

	public String getmB_Mail() {
		return mB_Mail;
	}

	public void setmB_Mail(String mB_Mail) {
		this.mB_Mail = mB_Mail;
	}

	public String getmB_Tel() {
		return mB_Tel;
	}

	public void setmB_Tel(String mB_Tel) {
		this.mB_Tel = mB_Tel;
	}

	public String getmB_Address() {
		return mB_Address;
	}

	public void setmB_Address(String mB_Address) {
		this.mB_Address = mB_Address;
	}

	public Timestamp getmB_Date() {
		return mB_Date;
	}

	public void setmB_Date(Timestamp mB_Date) {
		this.mB_Date = mB_Date;
	}

	public Integer getmB_Lv() {
		return mB_Lv;
	}

	public void setmB_Lv(Integer mB_Lv) {
		this.mB_Lv = mB_Lv;
	}

	public String getmB_type() {
		return mB_type;
	}

	public void setmB_type(String mB_type) {
		this.mB_type = mB_type;
	}
	
	
	
	
}
