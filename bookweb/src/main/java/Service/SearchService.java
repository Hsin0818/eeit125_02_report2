package Service;

import java.util.List;

import model.BookBean;
import model.Book_COLLECTBean;

public interface SearchService {

	//查詢書籍關鍵字
	List<BookBean> searchBook(String name);

	//取得單一本書的詳細資訊
	BookBean getBook(int id);

	// 會員收藏清單
	List<Book_COLLECTBean> gotoCollect(int id);

	// 刪除收藏項目
	int delete(int bcid);

	// 新增收藏項目
	int savebc(int bk_ID, int mb_ID);

	// 新增書本
	int savebk(BookBean bkc);

	// 修改書本
	int updatebk(BookBean mb);

}