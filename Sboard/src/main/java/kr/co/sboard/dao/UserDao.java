package kr.co.sboard.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.sboard.vo.MemberVo;
import kr.co.sboard.vo.TermsVo;

@Repository
public interface UserDao {

	public void insertUser(MemberVo vo);
	public List<MemberVo> selectUsers();
	public MemberVo selectUser(MemberVo vo);
	public void updateUser(String uid);
	public void deleteUser(String uid);
	public TermsVo selectTerms();
	
	// 회원가입 체크
	public int selectMemberCount(String uid); // 아이디 중복 체크
	public int selectMemberNick(String nick); // 아이디 중복 체크
	public int selectMemberEmail(String email); // 아이디 중복 체크
	public int selectMemberHp(String hp); // 아이디 중복 체크
}
