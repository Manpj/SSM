package com.mpj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.mpj.dao.IUserDao;
import com.mpj.pojo.L_User;
import com.mpj.service.IUserService;
import com.mpj.util.Page;

/**
 * hzmpj 2017年7月6日
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao dao;

	public L_User getUserById(int userId) {
		return this.dao.selectByPrimaryKey(userId);
	}

	public int createUser(L_User user) {
		return this.dao.insertSelective(user);
	}

	public L_User findByLogin(L_User user) {
		return dao.findByLogin(user);
	}

	/**
	 * 分页查询
	 */
	public Page<L_User> findByParams(L_User u, int pageNo, int limit) {
		Page<L_User> page = new Page<L_User>();
		page.setPageNo(pageNo);
		page.setLimit(limit);

		int offset = page.getOffsets();
		RowBounds rowBound = new RowBounds(offset, limit);

		List<L_User> users = dao.findByParams(u, rowBound);
		page.setRows(users);
		int total = dao.findAllCount(u);
		page.setTotal(total);
		if (offset >= page.getTotal()) {
			page.setPageNo(page.getTotalPages());
		}
		return page;
	}

	public int deleteByPrimaryKey(Integer id) {
		return dao.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(L_User record) {
		return dao.updateByPrimaryKeySelective(record);
	}

	public int findAllCount(L_User u) {
		// TODO Auto-generated method stub
		return dao.findAllCount(u);
	}

	public List<L_User> findHotUser() {
		return dao.findHotUser();
	}

	@Override
	public List<L_User> findAllByQuery(L_User user) {
		return dao.findAllByQuery(user);
	}

	@Override
	public List<L_User> list(Map<String, Object> map) {
		return dao.list(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return dao.getTotal(map);
	}

	@Override
	public L_User findUserByUsername(String username) {
		return dao.findUserByUsername(username);
	}
}
