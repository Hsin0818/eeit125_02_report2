package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Book")
public class BookBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer bk_ID;
	String bk_Name;
	String bk_Transname;
	String bk_Author;
	String bk_Editor;
	String bk_Translator;
	String bk_Publish;
	String bk_ISBN;
	Date bk_Date;
	String bk_Pic;
	String bk_Language;
	String bk_Content;
	Integer bk_Page;
	String bk_Reader;
	
	public BookBean() {
		super();
	}

	public BookBean(Integer bk_ID, String bk_Name, String bk_Transname, String bk_Author, String bk_Editor,
			String bk_Translator, String bk_Publish, String bk_ISBN, Date bk_Date, String bk_Pic, String bk_Language,
			String bk_Content, Integer bk_Page, String bk_Reader) {
		super();
		this.bk_ID = bk_ID;
		this.bk_Name = bk_Name;
		this.bk_Transname = bk_Transname;
		this.bk_Author = bk_Author;
		this.bk_Editor = bk_Editor;
		this.bk_Translator = bk_Translator;
		this.bk_Publish = bk_Publish;
		this.bk_ISBN = bk_ISBN;
		this.bk_Date = bk_Date;
		this.bk_Pic = bk_Pic;
		this.bk_Language = bk_Language;
		this.bk_Content = bk_Content;
		this.bk_Page = bk_Page;
		this.bk_Reader = bk_Reader;
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

	public String getBk_Transname() {
		return bk_Transname;
	}

	public void setBk_Transname(String bk_Transname) {
		this.bk_Transname = bk_Transname;
	}

	public String getBk_Author() {
		return bk_Author;
	}

	public void setBk_Author(String bk_Author) {
		this.bk_Author = bk_Author;
	}

	public String getBk_Editor() {
		return bk_Editor;
	}

	public void setBk_Editor(String bk_Editor) {
		this.bk_Editor = bk_Editor;
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

	public Date getBk_Date() {
		return bk_Date;
	}

	public void setBk_Date(Date bk_Date) {
		this.bk_Date = bk_Date;
	}

	public String getBk_Pic() {
		return bk_Pic;
	}

	public void setBk_Pic(String bk_Pic) {
		this.bk_Pic = bk_Pic;
	}

	public String getBk_Language() {
		return bk_Language;
	}

	public void setBk_Language(String bk_Language) {
		this.bk_Language = bk_Language;
	}

	public String getBk_Content() {
		return bk_Content;
	}

	public void setBk_Content(String bk_Content) {
		this.bk_Content = bk_Content;
	}

	public Integer getBk_Page() {
		return bk_Page;
	}

	public void setBk_Page(Integer bk_Page) {
		this.bk_Page = bk_Page;
	}

	public String getBk_Reader() {
		return bk_Reader;
	}

	public void setBk_Reader(String bk_Reader) {
		this.bk_Reader = bk_Reader;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookBean [bk_ID=");
		builder.append(bk_ID);
		builder.append(", bk_Name=");
		builder.append(bk_Name);
		builder.append(", bk_Transname=");
		builder.append(bk_Transname);
		builder.append(", bk_Author=");
		builder.append(bk_Author);
		builder.append(", bk_Editor=");
		builder.append(bk_Editor);
		builder.append(", bk_Translator=");
		builder.append(bk_Translator);
		builder.append(", bk_Publish=");
		builder.append(bk_Publish);
		builder.append(", bk_ISBN=");
		builder.append(bk_ISBN);
		builder.append(", bk_Date=");
		builder.append(bk_Date);
		builder.append(", bk_Pic=");
		builder.append(bk_Pic);
		builder.append(", bk_Language=");
		builder.append(bk_Language);
		builder.append(", bk_Content=");
		builder.append(bk_Content);
		builder.append(", bk_Page=");
		builder.append(bk_Page);
		builder.append(", bk_Reader=");
		builder.append(bk_Reader);
		builder.append("]");
		return builder.toString();
	}

	
	
}
