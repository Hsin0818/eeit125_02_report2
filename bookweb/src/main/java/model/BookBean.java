package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class BookBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bk_ID;
	private String bk_Name;
	private String bk_BookType;
	private String bk_Writer;
	private String bk_Translator;
	private String bk_Publish;
	private String bk_ISBN;
	private Date bk_Time;
	private String bk_Pic;
	private String bk_Lan;
	private Integer bk_Price;
	private Integer bk_Page;
	private String bk_Publisher_Place;
	private String bk_Content;

	public BookBean() {
		super();
	}

	public BookBean(Integer bk_ID, String bk_Name, String bk_BookType, String bk_Writer, String bk_Translator,
			String bk_Publish, String bk_ISBN, Date bk_Time, String bk_Pic, String bk_Lan, Integer bk_Price,
			Integer bK_Page, String bk_Publisher_Place, String bk_Content) {
		super();
		this.bk_ID = bk_ID;
		this.bk_Name = bk_Name;
		this.bk_BookType = bk_BookType;
		this.bk_Writer = bk_Writer;
		this.bk_Translator = bk_Translator;
		this.bk_Publish = bk_Publish;
		this.bk_ISBN = bk_ISBN;
		this.bk_Time = bk_Time;
		this.bk_Pic = bk_Pic;
		this.bk_Lan = bk_Lan;
		this.bk_Price = bk_Price;
		this.bk_Page = bK_Page;
		this.bk_Publisher_Place = bk_Publisher_Place;
		this.bk_Content = bk_Content;
	}

	public Integer getBk_ID() {
		return bk_ID;
	}

	public void setBk_ID(Integer bk_ID) {
		this.bk_ID = bk_ID;
	}

	public String getBk_Name() {
		return bk_Name;
	}

	public void setBk_Name(String bk_Name) {
		this.bk_Name = bk_Name;
	}

	public String getBk_BookType() {
		return bk_BookType;
	}

	public void setBk_BookType(String bk_BookType) {
		this.bk_BookType = bk_BookType;
	}

	public String getBk_Writer() {
		return bk_Writer;
	}

	public void setBk_Writer(String bk_Writer) {
		this.bk_Writer = bk_Writer;
	}

	public String getBk_Translator() {
		return bk_Translator;
	}

	public void setBk_Translator(String bk_Translator) {
		this.bk_Translator = bk_Translator;
	}

	public String getBk_Publish() {
		return bk_Publish;
	}

	public void setBk_Publish(String bk_Publish) {
		this.bk_Publish = bk_Publish;
	}

	public String getBk_ISBN() {
		return bk_ISBN;
	}

	public void setBk_ISBN(String bk_ISBN) {
		this.bk_ISBN = bk_ISBN;
	}

	public Date getBk_Time() {
		return bk_Time;
	}

	public void setBk_Time(Date bk_Time) {
		this.bk_Time = bk_Time;
	}

	public String getBk_Pic() {
		return bk_Pic;
	}

	public void setBk_Pic(String bk_Pic) {
		this.bk_Pic = bk_Pic;
	}

	public String getBk_Lan() {
		return bk_Lan;
	}

	public void setBk_Lan(String bk_Lan) {
		this.bk_Lan = bk_Lan;
	}

	public Integer getBk_Price() {
		return bk_Price;
	}

	public void setBk_Price(Integer bk_Price) {
		this.bk_Price = bk_Price;
	}

	public Integer getBk_Page() {
		return bk_Page;
	}

	public void setBk_Page(Integer bk_Page) {
		this.bk_Page = bk_Page;
	}

	public String getBk_Publisher_Place() {
		return bk_Publisher_Place;
	}

	public void setBk_Publisher_Place(String bk_Publisher_Place) {
		this.bk_Publisher_Place = bk_Publisher_Place;
	}

	public String getBk_Content() {
		return bk_Content;
	}

	public void setBk_Content(String bk_Content) {
		this.bk_Content = bk_Content;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookBean [bk_ID=");
		builder.append(bk_ID);
		builder.append(", bk_Name=");
		builder.append(bk_Name);
		builder.append(", bk_BookType=");
		builder.append(bk_BookType);
		builder.append(", bk_Writer=");
		builder.append(bk_Writer);
		builder.append(", bk_Translator=");
		builder.append(bk_Translator);
		builder.append(", bk_Publish=");
		builder.append(bk_Publish);
		builder.append(", bk_ISBN=");
		builder.append(bk_ISBN);
		builder.append(", bk_Time=");
		builder.append(bk_Time);
		builder.append(", bk_Pic=");
		builder.append(bk_Pic);
		builder.append(", bk_Lan=");
		builder.append(bk_Lan);
		builder.append(", bk_Price=");
		builder.append(bk_Price);
		builder.append(", bk_Page=");
		builder.append(bk_Page);
		builder.append(", bk_Publisher_Place=");
		builder.append(bk_Publisher_Place);
		builder.append(", bk_Content=");
		builder.append(bk_Content);
		builder.append("]");
		return builder.toString();
	}

}