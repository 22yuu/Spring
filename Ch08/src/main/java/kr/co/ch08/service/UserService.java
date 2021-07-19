package kr.co.ch08.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch08.dao.UserDao;
import kr.co.ch08.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	public void insertUser(UserVo vo) {
		userDao.insertUser(vo);
	};
	
	public List<UserVo> selectUsers() {
		return userDao.selectUsers(); 
	};
	
	public UserVo selectUser(String uid) {
		return userDao.selectUser(uid);
	};
	
	public void updateUser(UserVo vo) {
		userDao.updateUser(vo);
	};
	
	public void deleteUser(String uid) {
		userDao.deleteUser(uid);
	};
	
}
