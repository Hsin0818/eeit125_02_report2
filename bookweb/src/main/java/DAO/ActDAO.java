package DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import BookReport.HibernateUtils;
import model.ActBean;

@Repository
public class ActDAO implements IActDao {

	SessionFactory factory = HibernateUtils.getSessionFactory();

	// 判斷活動名稱是否重複
	@SuppressWarnings("unchecked")
	@Override
	public boolean isDup(String Act_Name) { 
		boolean result = false;
		String hql = "FROM ACT_Records a WHERE a.ACT_Name = :ACT_Name0";
		Session session = factory.getCurrentSession();

		Query<ActBean> query = session.createQuery(hql); // 留意選哪個import
		List<ActBean> list = query.setParameter("Act_Name0", Act_Name).getResultList();
		if (list.size() > 0) {
			return true;
		}
		return result;
	}

	//新增活動
	@Override
	public int save(ActBean ab) {
		int count = 0;
		Session session = factory.getCurrentSession();
		session.save(ab);
		count++;
		return count;
	}

	//查詢所有活動
	@SuppressWarnings("unchecked")
	@Override
	public List<ActBean> getAllActs() {
		List<ActBean> list = new ArrayList<>();
		String hql = "FROM ActBean a";
		Session session = factory.getCurrentSession();

		Query<ActBean> query = session.createQuery(hql);
		list = query.getResultList();
		return list;
	}

	//查詢單筆活動
	@Override
	public ActBean getAct(Integer Act_ID) {
		ActBean ab = null;
		Session session = factory.getCurrentSession();
		ab = session.get(ActBean.class, Act_ID);

		return ab;
	}

	//修改活動
	@Override
	public int updateActBean(ActBean ab) {
		int count = 0;
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(ab);
		count++;

		return count;
	}

	//刪除活動
	@Override
	public int deleteActBean(Integer Act_ID) {
		int count = 0;
		Session session = factory.getCurrentSession();

		ActBean ab = new ActBean();
		ab.setACT_ID(Act_ID);
		System.out.println(ab);
		session.delete(ab);
		count++;

		return count;
	}

}
