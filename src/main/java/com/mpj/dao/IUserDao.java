package com.mpj.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.mpj.pojo.L_User;

/**
 * hzmpj 2017年7月6日
 */
public interface IUserDao {
	int deleteByPrimaryKey(Integer id);

	int insert(L_User record);

	int insertSelective(L_User record);

	L_User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(L_User record);

	int updateByPrimaryKey(L_User record);

	L_User findByLogin(L_User user);

	List<L_User> findByParams(L_User u, RowBounds rowBound);

	int findAllCount(L_User u);

	List<L_User> findHotUser();

	List<L_User> findAllByQuery(L_User user);

	List<L_User> list(Map<String, Object> map);

	Long getTotal(Map<String, Object> map);

	L_User findUserByUsername(String username);
}
