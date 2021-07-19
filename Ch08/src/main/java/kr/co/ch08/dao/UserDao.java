package kr.co.ch08.dao;

import org.springframework.stereotype.Repository;

import kr.co.ch08.vo.UserVo;

@Repository
public interface UserDao {

	public void insertUser(UserVo vo);
}
