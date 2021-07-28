package kr.co.ch05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch05.dao.MemberDao;
import kr.co.ch05.dao.UserDao;
import kr.co.ch05.vo.MemberVo;
import kr.co.ch05.vo.UserVo;

@Service
public class MemberService {

	@Autowired
	private MemberDao dao;
	
	public void insertUser(MemberVo vo) {
		dao.insertMember(vo);
	}
	
	public MemberVo selectUser(String uid) {
		return dao.selectMember(uid);
	}
	
	
	public List<MemberVo> selectUsers() {
		return dao.selectMembers();
	}
	
	public void updateUser(MemberVo vo) {
		dao.updateMember(vo);
	}
	
	public void deleteUser(String uid) {
		dao.deleteMember(uid);
	}
}
