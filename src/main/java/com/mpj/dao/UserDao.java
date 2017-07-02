package com.mpj.dao;

import java.util.Set;

import com.mpj.pojo.User;

/**
 * hzmpj 2017年6月30日
 */
public interface UserDao {
	/**
	 * Shiro的登录验证，通过用户名查询用户信息
	 */
	public User findUserByUsername(String username);

	/**
	 * 根据帐号查询角色名称
	 */
	public Set<String> findRoles(String username);

	/**
	 * 根据帐号查询权限
	 */
	public Set<String> findPermissions(String username);
}
