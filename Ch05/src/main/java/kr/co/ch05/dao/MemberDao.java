package kr.co.ch05.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ch05.vo.MemberVo;

@Repository // Dao
public class MemberDao {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertMember(MemberVo vo) {
		mybatis.insert("mapper.member.INSERT_MEMBER", vo);
	}
	
	public MemberVo selectMember(String uid) {
		return mybatis.selectOne("mapper.member.SELECT_MEMBER", uid);
		
	}
	
	public List<MemberVo> selectMembers() {
		return mybatis.selectList("mapper.member.SELECT_MEMBERS");
	}
	
	public void updateMember(MemberVo vo) {
		mybatis.update("mapper.member.UPDATE_MEMBER", vo);
	}
	
	public void deleteMember(String uid) {
		mybatis.delete("mapper.member.DELETE_MEMBER", uid);
	}
}
