package com.mpj.dao;

import java.util.List;

import com.mpj.pojo.Content;

/**
 * hzmpj 2017年7月6日
 */
public interface ContentDao {
	List<Content> findContentList();

	int insertSelective(Content content);

}
