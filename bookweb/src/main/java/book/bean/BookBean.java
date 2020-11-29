package book.bean;

import java.util.Date;

public class BookBean
{
  private int BK_ID;
  private String BK_Name;
  private String BK_Publish;
  private String BK_Writer;
  private Date BK_Time;
  private String BK_Content;
  private String BK_Pic;
  private String URL;
  
  public BookBean()
  {
  }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
  
  public BookBean(int id, String name, String publish, String writer, Date time, String content,String pic, 
                 String url)
  {
	this.BK_ID=id;
    this.BK_Name = name;
    this.BK_Publish = publish;
    this.BK_Writer = writer;
    this.BK_Time = time;
    this.BK_Content = content;  
    this.BK_Pic = pic;
    this.URL = url;
  }

public int getBK_ID() {
	return BK_ID;
}

public void setBK_ID(int bK_ID) {
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

}