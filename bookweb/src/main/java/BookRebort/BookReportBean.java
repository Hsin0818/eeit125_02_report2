package BookRebort;

import java.util.Date;

public class BookReportBean{

	private int br_ID;
	private int mb_ID;
	private int bk_ID;
	private String bk_Name;
	private String bk_Writer;
	private String bk_Publish;
	private String bk_Pic;
	private int br_score;
	private String br_content;
	private Date br_dateTime;
	
	public int getBr_ID() {
		return br_ID;
	}
	public void setBr_ID(int br_ID) {
		this.br_ID = br_ID;
	}
	public int getMb_ID() {
		return mb_ID;
	}
	public void setMb_ID(int mb_ID) {
		this.mb_ID = mb_ID;
	}
	public int getBk_ID() {
		return bk_ID;
	}
	public void setBk_ID(int bk_ID) {
		this.bk_ID = bk_ID;
	}
	public String getBk_Name() {
		return bk_Name;
	}
	public void setBk_Name(String bk_Name) {
		this.bk_Name = bk_Name;
	}
	public String getBk_Writer() {
		return bk_Writer;
	}
	public void setBk_Writer(String bk_Writer) {
		this.bk_Writer = bk_Writer;
	}
	public String getBk_Publish() {
		return bk_Publish;
	}
	public void setBk_Publish(String bk_Publish) {
		this.bk_Publish = bk_Publish;
	}
	public String getBk_Pic() {
		return bk_Pic;
	}
	public void setBk_Pic(String bk_Pic) {
		this.bk_Pic = bk_Pic;
	}
	public int getBr_score() {
		return br_score;
	}
	public void setBr_score(int br_score) {
		this.br_score = br_score;
	}
	public String getBr_content() {
		return br_content;
	}
	public void setBr_content(String br_content) {
		this.br_content = br_content;
	}
	public Date getBr_dateTime() {
		return br_dateTime;
	}
	public void setBr_dateTime(Date br_dateTime) {
		this.br_dateTime = br_dateTime;
	}
	
	
}
