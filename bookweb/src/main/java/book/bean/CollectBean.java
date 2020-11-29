package book.bean;

import java.util.Date;

public class CollectBean
{
	private int BK_ID;
	private int MB_ID;
  
  public CollectBean()
  {
  }
  
  public CollectBean(int bk_id, int mb_id)
  {
    this.BK_ID = bk_id;
    this.MB_ID = mb_id;
  }

public int getBK_ID() {
	return BK_ID;
}

public void setBK_ID(int bK_ID) {
	BK_ID = bK_ID;
}

public int getMB_ID() {
	return MB_ID;
}

public void setMB_ID(int mB_ID) {
	MB_ID = mB_ID;
}
  


}