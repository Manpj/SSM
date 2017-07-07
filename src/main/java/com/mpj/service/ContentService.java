package com.mpj.service;

import java.util.List;

import com.mpj.pojo.Content;


/**
 * hzmpj 2017年7月5日
 */
public interface ContentService {
	List<Content> findContentList();

	int insertSelective(Content content);
}
