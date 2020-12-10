package shopping;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "BOOK")
public class BookData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer BK_ID;
	private String BK_Name;
	private String BK_Publish;
	private String BK_Writer;
	private Date BK_Time;
	private String BK_Content;	
	private String BK_Pic;
	private String URL;
	
	public BookData() {
		super();
	}
	
	public BookData(Integer bK_ID, String bK_Name, String bK_Publish, String bK_Writer, Date bK_Time, String bK_Content,
			String bK_Pic, String uRL) {
		super();
		BK_ID = bK_ID;
		BK_Name = bK_Name;
		BK_Publish = bK_Publish;
		BK_Writer = bK_Writer;
		BK_Time = bK_Time;
		BK_Content = bK_Content;
		BK_Pic = bK_Pic;
		URL = uRL;
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
	public String getBK_Publish() {
		return BK_Publish;
	}
	public void setBK_Publish(String bK_Publish) {
		BK_Publish = bK_Publish;
	}
	public String getBK_Writer() {
		return BK_Writer;
	}
	public void setBK_Writer(String bK_Writer) {
		BK_Writer = bK_Writer;
	}
	public Date getBK_Time() {
		return BK_Time;
	}
	public void setBK_Time(Date bK_Time) {
		BK_Time = bK_Time;
	}
	public String getBK_Content() {
		return BK_Content;
	}
	public void setBK_Content(String bK_Content) {
		BK_Content = bK_Content;
	}
	public String getBK_Pic() {
		return BK_Pic;
	}
	public void setBK_Pic(String bK_Pic) {
		BK_Pic = bK_Pic;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookData [BK_ID=");
		builder.append(BK_ID);
		builder.append(", BK_Name=");
		builder.append(BK_Name);
		builder.append(", BK_Publish=");
		builder.append(BK_Publish);
		builder.append(", BK_Writer=");
		builder.append(BK_Writer);
		builder.append(", BK_Time=");
		builder.append(BK_Time);
		builder.append(", BK_Content=");
		builder.append(BK_Content);
		builder.append(", BK_Pic=");
		builder.append(BK_Pic);
		builder.append(", URL=");
		builder.append(URL);
		builder.append("]");
		return builder.toString();
	}
	
}
