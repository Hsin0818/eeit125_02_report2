package Service;

import java.util.List;


import model.ActBean;

public interface ActService {

	//確認活動名稱是否重複
		boolean isDup(String Act_Name);
		
		//新增
		int save(ActBean ab);
		
		//查詢所有資料
		List<ActBean> getAllActs();
		
		//經由活動名稱查詢單筆資料
		ActBean getAct(Integer Act_ID);
		
		//更新活動
		int updateActBean(ActBean ab);
		
		//刪除活動
		int deleteActBean(Integer Act_ID);

}
