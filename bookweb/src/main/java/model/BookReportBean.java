package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Book_Report")
public class BookReportBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer br_ID;
	private Integer br_Score;
	private String br_Content;
	private Date br_DateTime;
	
	@ManyToOne
	@JoinColumn(name = "bk_ID")
	private BookBean book;
	
	@ManyToOne
	@JoinColumn(name = "mb_ID")
	private MemberBean member;
	
	public BookReportBean() {
		super();
	}

	public BookReportBean(Integer bR_ID, Integer bR_Score, String bR_Content, Date bR_DateTime, BookBean book,
			MemberBean member) {
		super();
		br_ID = bR_ID;
		br_Score = bR_Score;
		br_Content = bR_Content;
		br_DateTime = bR_DateTime;
		this.book = book;
		this.member = member;
	}

	public Integer getBr_ID() {
		return br_ID;
	}

	public void setBr_ID(Integer br_ID) {
		this.br_ID = br_ID;
	}

	public Integer getBr_Score() {
		return br_Score;
	}

	public void setBr_Score(Integer br_score) {
		this.br_Score = br_score;
	}

	public String getBr_Content() {
		return br_Content;
	}

	public void setBr_Content(String br_content) {
		this.br_Content = br_content;
	}

	public Date getBr_DateTime() {
		return br_DateTime;
	}

	public void setBr_DateTime(Date br_dateTime) {
		this.br_DateTime = br_dateTime;
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
		builder.append(br_ID);
		builder.append(", BR_Score=");
		builder.append(br_Score);
		builder.append(", BR_Content=");
		builder.append(br_Content);
		builder.append(", BR_DateTime=");
		builder.append(br_DateTime);
		builder.append(", book=");
		builder.append(book);
		builder.append(", member=");
		builder.append(member);
		builder.append("]");
		return builder.toString();
	}

	

}
