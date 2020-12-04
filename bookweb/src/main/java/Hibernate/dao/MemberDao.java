package Hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import BookReport.HibernateUtils;
import Hibernate.model.MemberBean;

@Repository
public class MemberDao implements IMemberDao {

	SessionFactory factory = HibernateUtils.getSessionFactory();

	@Override
	public boolean insertMember(MemberBean memberData) {
		Session session = factory.getCurrentSession();
		session.save(memberData);
		return true;
	}

	@Override
	public boolean Login(String account , String pwd) {	
		boolean result = false;	
		String hql = "FROM MemberBean WHERE mB_Account =:account";
		Session session =factory.getCurrentSession();
		
		Query<MemberBean> query = session.createQuery(hql);
		List<MemberBean> list = query.setParameter("account", account).getResultList();
		if(list.size()>0) {
		result = true;	
	}
		return result;
	}

	@Override
	public boolean update(MemberBean mb) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(mb);		
		return true;		
	}


	@Override
	public MemberBean select(String account) {
			MemberBean mb = null;
			Session session = factory.getCurrentSession();
			mb = session.get(MemberBean.class,account);

		return mb;
	}

	@Override
	public List<MemberBean> adminselect() {
		List<MemberBean> dep = new ArrayList<>();
		String hql = "FROM MemberBean";
		Session session = factory.getCurrentSession();
		
		Query<MemberBean> query = session.createQuery(hql);
		dep = query.getResultList();
		
		return dep;
	}

	@Override
	public boolean delete(int id) {
		Session session = factory.getCurrentSession();
		
		MemberBean mb = new MemberBean();
		mb.setmB_ID(id);
		session.delete(mb);
		
		return true;
	}

}
