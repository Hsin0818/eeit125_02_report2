package book.bean;

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
	private Integer BK_ID;
	private String BK_Name;
	private String BK_BookType;
	private String BK_Writer;
	private String BK_Translator;
	private String BK_Publish;
	private String BK_ISBN;
	private Date BK_Time;
	private String BK_Pic;
	private String BK_Lan;
	private Integer BK_Price;
	private Integer BK_Page;
	private String BK_Publisher_Place;
	private String BK_Content;
	
	public BookBean() {
		super();
	}

	public BookBean(Integer bK_ID, String bK_Name, String bK_BookType, String bK_Writer, String bK_Translator,
			String bK_Publish, String bK_ISBN, Date bK_Time, String bK_Pic, String bK_Lan, Integer bK_Price,
			Integer bK_Page, String bK_Publisher_Place, String bK_Content) {
		super();
		BK_ID = bK_ID;
		BK_Name = bK_Name;
		BK_BookType = bK_BookType;
		BK_Writer = bK_Writer;
		BK_Translator = bK_Translator;
		BK_Publish = bK_Publish;
		BK_ISBN = bK_ISBN;
		BK_Time = bK_Time;
		BK_Pic = bK_Pic;
		BK_Lan = bK_Lan;
		BK_Price = bK_Price;
		BK_Page = bK_Page;
		BK_Publisher_Place = bK_Publisher_Place;
		BK_Content = bK_Content;
	}

	public Integer getBK_ID() {
		return BK_ID;
	}

	public void setBK_ID(Integer bK_ID) {
		BK_ID = bK_ID;
	}

	public String getBK_Name() {
		return BK_Name;
	}

	public void setBK_Name(String bK_Name) {
		BK_Name = bK_Name;
	}

	public String getBK_BookType() {
		return BK_BookType;
	}

	public void setBK_BookType(String bK_BookType) {
		BK_BookType = bK_BookType;
	}

	public String getBK_Writer() {
		return BK_Writer;
	}

	public void setBK_Writer(String bK_Writer) {
		BK_Writer = bK_Writer;
	}

	public String getBK_Translator() {
		return BK_Translator;
	}

	public void setBK_Translator(String bK_Translator) {
		BK_Translator = bK_Translator;
	}

	public String getBK_Publish() {
		return BK_Publish;
	}

	public void setBK_Publish(String bK_Publish) {
		BK_Publish = bK_Publish;
	}

	public String getBK_ISBN() {
		return BK_ISBN;
	}

	public void setBK_ISBN(String bK_ISBN) {
		BK_ISBN = bK_ISBN;
	}

	public Date getBK_Time() {
		return BK_Time;
	}

	public void setBK_Time(Date bK_Time) {
		BK_Time = bK_Time;
	}

	public String getBK_Pic() {
		return BK_Pic;
	}

	public void setBK_Pic(String bK_Pic) {
		BK_Pic = bK_Pic;
	}

	public String getBK_Lan() {
		return BK_Lan;
	}

	public void setBK_Lan(String bK_Lan) {
		BK_Lan = bK_Lan;
	}

	public Integer getBK_Price() {
		return BK_Price;
	}

	public void setBK_Price(Integer bK_Price) {
		BK_Price = bK_Price;
	}

	public Integer getBK_Page() {
		return BK_Page;
	}

	public void setBK_Page(Integer bK_Page) {
		BK_Page = bK_Page;
	}

	public String getBK_Publisher_Place() {
		return BK_Publisher_Place;
	}

	public void setBK_Publisher_Place(String bK_Publisher_Place) {
		BK_Publisher_Place = bK_Publisher_Place;
	}

	public String getBK_Content() {
		return BK_Content;
	}

	public void setBK_Content(String bK_Content) {
		BK_Content = bK_Content;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookBean [BK_ID=");
		builder.append(BK_ID);
		builder.append(", BK_Name=");
		builder.append(BK_Name);
		builder.append(", BK_BookType=");
		builder.append(BK_BookType);
		builder.append(", BK_Writer=");
		builder.append(BK_Writer);
		builder.append(", BK_Translator=");
		builder.append(BK_Translator);
		builder.append(", BK_Publish=");
		builder.append(BK_Publish);
		builder.append(", BK_ISBN=");
		builder.append(BK_ISBN);
		builder.append(", BK_Time=");
		builder.append(BK_Time);
		builder.append(", BK_Pic=");
		builder.append(BK_Pic);
		builder.append(", BK_Lan=");
		builder.append(BK_Lan);
		builder.append(", BK_Price=");
		builder.append(BK_Price);
		builder.append(", BK_Page=");
		builder.append(BK_Page);
		builder.append(", BK_Publisher_Place=");
		builder.append(BK_Publisher_Place);
		builder.append(", BK_Content=");
		builder.append(BK_Content);
		builder.append("]");
		return builder.toString();
	}
}