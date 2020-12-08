package DAO;

import java.util.List;

import model.MemberBean;

public interface IMemberDao {

	boolean insertMember(MemberBean memberData);

	boolean Login(String account, String pwd);

	boolean update(MemberBean mb);

	MemberBean select(String account);

	List<MemberBean> adminselect();

	boolean delete(int id);

}