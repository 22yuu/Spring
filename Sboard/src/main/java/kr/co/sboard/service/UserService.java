package kr.co.sboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sboard.dao.UserDao;
import kr.co.sboard.vo.MemberVo;
import kr.co.sboard.vo.TermsVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public void insertUser(MemberVo vo) {
		userDao.insertUser(vo);
	}
	
	public List<MemberVo> selectUsers(){
		return userDao.selectUsers();
	}
	
	public MemberVo selectUser(MemberVo vo) {
		return userDao.selectUser(vo);
	}
	
	public void updateUser(String uid) {
		userDao.updateUser(uid);
	}
	
	public void deleteUser(String uid) {
		userDao.deleteUser(uid);
	}
	
	public TermsVo selectTerms() {
		return userDao.selectTerms();
	}
	
	// 회원가입 유효성 검사 관련
	public int selectMemberCount(String uid) {
		return userDao.selectMemberCount(uid);
	} // 아이디 중복 체크
	
	public int selectMemberNick(String nick) {
		// 닉네임 중복체크
		return userDao.selectMemberNick(nick);
	} 
	public int selectMemberEmail(String email) {
		// 이메일 중복체크
		return userDao.selectMemberEmail(email);
	}
	public int selectMemberHp(String hp) {
		// 전화번호 중복체크
		return userDao.selectMemberHp(hp);
	}
	
}
