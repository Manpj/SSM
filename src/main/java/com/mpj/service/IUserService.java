package com.mpj.service;

import java.util.List;
import java.util.Map;

import com.mpj.pojo.L_User;
import com.mpj.util.Page;

/**
 * hzmpj 2017年7月5日
 */
public interface IUserService {

	public L_User getUserById(int userId);

	public int createUser(L_User user);

	public L_User findByLogin(L_User user);

	public Page<L_User> findByParams(L_User u, int pageNo, int limit);

	int deleteByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(L_User record);

	int findAllCount(L_User u);

	List<L_User> findHotUser();
	
	List<L_User> findAllByQuery(L_User user);
	
	/**
	 * 分页查询
	 * 
	 * @param map
	 * @return
	 */
	public List<L_User> list(Map<String, Object> map);

	public Long getTotal(Map<String, Object> map);

	/**
	 * Shiro的登录验证，通过用户名查询用户信息
	 * 
	 * @param username
	 * @return
	 */
	public L_User findUserByUsername(String username);

}
