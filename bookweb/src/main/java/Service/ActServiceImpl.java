package Service;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import DAO.ActDAO;
import DAO.IActDao;

import model.ActBean;
import BookReport.*;

@Service
public class ActServiceImpl implements ActService {
	
	SessionFactory factory = HibernateUtils.getSessionFactory();
	IActDao dao = new ActDAO();
	
	// 判斷活動名稱是否重複
	@Override
	public boolean isDup(String ACT_Name) {
		boolean result = false;
		Session session = factory.getCurrentSession();
		Transaction tx = null; 
		try {
			tx = session.beginTransaction();
			result = dao.isDup(ACT_Name);
			tx.commit();
		}catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return result;
		
		}
	
	//新增活動
	@Override
	public int save(ActBean ab) {
		int count = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null; //留意選哪個Transaction
		try {
			tx = session.beginTransaction();
			dao.save(ab);
			count++;
			tx.commit();
		}catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return count;
	}
	
	


	//查詢所有活動
	@Override
	public List<ActBean> getAllActs() {
		List<ActBean> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		Transaction tx = null; 
		try {
			tx = session.beginTransaction();
			list = dao.getAllActs();
			tx.commit();
		}catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		
		return list;
		
	}

	//查詢單筆活動
	@Override
	public ActBean getAct(Integer Act_ID) {
		ActBean ab = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			ab = dao.getAct(Act_ID);
			tx.commit();
		}catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return ab;
	}

	//修改活動
	@Override
	public int updateActBean(ActBean ab) {
		int count = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.updateActBean(ab);
			tx.commit();
		}catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	return count;
	}


	//刪除活動
	@Override
	public int deleteActBean(Integer Act_ID) {
		int count = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null; //留意選哪個Transaction		
		try {
			tx = session.beginTransaction();
			dao.deleteActBean(Act_ID);

			tx.commit();
		}catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return count;
	}

}
