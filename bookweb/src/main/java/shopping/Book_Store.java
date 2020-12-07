package shopping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK_STORE")
public class Book_Store {
//BKS_ID BS_Num BS_price BK_ID BS_ID
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer BKS_ID;
	private Integer BS_Num;
	private Integer BS_price;
	private Integer BK_ID;
	private Integer BS_ID;
		
	public Book_Store() {
		super();
	}
	public Book_Store(Integer bKS_ID, Integer bS_Num, Integer bS_price, Integer bK_ID, Integer bS_ID) {
		super();
		BKS_ID = bKS_ID;
		BS_Num = bS_Num;
		BS_price = bS_price;
		BK_ID = bK_ID;
		BS_ID = bS_ID;
	}
	public Integer getBKS_ID() {
		return BKS_ID;
	}
	public void setBKS_ID(Integer bKS_ID) {
		BKS_ID = bKS_ID;
	}
	public Integer getBS_Num() {
		return BS_Num;
	}
	public void setBS_Num(Integer bS_Num) {
		BS_Num = bS_Num;
	}
	public Integer getBS_price() {
		return BS_price;
	}
	public void setBS_price(Integer bS_price) {
		BS_price = bS_price;
	}
	public Integer getBK_ID() {
		return BK_ID;
	}
	public void setBK_ID(Integer bK_ID) {
		BK_ID = bK_ID;
	}
	public Integer getBS_ID() {
		return BS_ID;
	}
	public void setBS_ID(Integer bS_ID) {
		BS_ID = bS_ID;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book_Store [BKS_ID=");
		builder.append(BKS_ID);
		builder.append(", BS_Num=");
		builder.append(BS_Num);
		builder.append(", BS_price=");
		builder.append(BS_price);
		builder.append(", BK_ID=");
		builder.append(BK_ID);
		builder.append(", BS_ID=");
		builder.append(BS_ID);
		builder.append("]");
		return builder.toString();
	}
	
}
