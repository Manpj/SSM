package com.mpj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mpj.dao.ContentDao;
import com.mpj.pojo.Content;
import com.mpj.service.ContentService;

/**
 * hzmpj 2017年7月6日
 */
@Service("contentService")
public class ContentServiceImpl implements ContentService {

	@Resource
	public ContentDao contentDao;

	@Override
	public List<Content> findContentList() {
		return contentDao.findContentList();
	}

	@Override
	public int insertSelective(Content content) {
		return contentDao.insertSelective(content);
	}

}
