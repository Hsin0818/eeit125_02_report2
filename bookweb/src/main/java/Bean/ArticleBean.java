package Bean;
import java.io.Serializable;

public class ArticleBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	String article_title;
	String article_content;
	
	
	public ArticleBean() {
	}
	
	public ArticleBean(String article_title, String article_content) {
		this.article_title = article_title;
		this.article_content = article_content;
	}

	public String getArticle_title() {
		return article_title;
	}

	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}

	public String getArticle_content() {
		return article_content;
	}

	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}
	
	
}
