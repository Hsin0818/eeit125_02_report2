package shopping;
import java.io.Serializable;

public class BookData implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bookid;
	private String bookname;
	private String bookauthor;
	private String bookpublish;
	private int bookprice;
	private int bookqty;
	private String url;
	private String content;
	
	public BookData() {
		
	}
	
	public BookData(int bookid, String bookname, String bookauthor, String bookpublish, int bookprice, int bookqty, String url,String content) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.bookauthor = bookauthor;
		this.bookpublish = bookpublish;
		this.bookprice = bookprice;
		this.bookqty = bookqty;
		this.url = url;
		this.content = content;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookauthor() {
		return bookauthor;
	}
	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}
	public String getBookpublish() {
		return bookpublish;
	}
	public void setBookpublish(String bookpublish) {
		this.bookpublish = bookpublish;
	}
	public int getBookprice() {
		return bookprice;
	}
	public void setBookprice(int bookprice) {
		this.bookprice = bookprice;
	}

	public int getBookqty() {
		return bookqty;
	}

	public void setBookqty(int bookqty) {
		this.bookqty = bookqty;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
