package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK_REPORT")
public class BookReportBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer BR_ID;
	private Integer BR_Score;
	private String BR_Content;
	private Date BR_DateTime;
	
	@ManyToOne
	@JoinColumn(name = "bk_ID")
	private BookBean book;
	
	@ManyToOne
	@JoinColumn(name = "mB_ID")
	private MemberBean member;
	
	public BookReportBean() {
		super();
	}

	public BookReportBean(Integer bR_ID, Integer bR_Score, String bR_Content, Date bR_DateTime, BookBean book,
			MemberBean member) {
		super();
		BR_ID = bR_ID;
		BR_Score = bR_Score;
		BR_Content = bR_Content;
		BR_DateTime = bR_DateTime;
		this.book = book;
		this.member = member;
	}

	public Integer getBR_ID() {
		return BR_ID;
	}

	public void setBR_ID(Integer br_ID) {
		this.BR_ID = br_ID;
	}

	public Integer getBR_Score() {
		return BR_Score;
	}

	public void setBR_Score(Integer br_score) {
		this.BR_Score = br_score;
	}

	public String getBR_Content() {
		return BR_Content;
	}

	public void setBR_Content(String br_content) {
		this.BR_Content = br_content;
	}

	public Date getBR_DateTime() {
		return BR_DateTime;
	}

	public void setBR_DateTime(Date br_dateTime) {
		this.BR_DateTime = br_dateTime;
	}

	public BookBean getBook() {
		return book;
	}

	public void setBook(BookBean book) {
		this.book = book;
	}

	public MemberBean getMember() {
		return member;
	}

	public void setMember(MemberBean member) {
		this.member = member;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookReportBean [BR_ID=");
		builder.append(BR_ID);
		builder.append(", BR_Score=");
		builder.append(BR_Score);
		builder.append(", BR_Content=");
		builder.append(BR_Content);
		builder.append(", BR_DateTime=");
		builder.append(BR_DateTime);
		builder.append(", book=");
		builder.append(book);
		builder.append(", member=");
		builder.append(member);
		builder.append("]");
		return builder.toString();
	}

	

}
