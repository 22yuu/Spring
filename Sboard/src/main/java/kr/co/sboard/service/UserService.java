package kr.co.sboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sboard.dao.UserDao;
import kr.co.sboard.vo.MemberVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public void insertUser(MemberVo vo) {
		
	};
	
	public List<MemberVo> selectUsers(){
		return userDao.selectUsers();
	};
	
	public MemberVo selectUser(MemberVo vo) {
		return userDao.selectUser(vo);
	};
	
	public void updateUser(String uid) {
		
	};
	
	public void deleteUser(String uid) {
		
	};
}
