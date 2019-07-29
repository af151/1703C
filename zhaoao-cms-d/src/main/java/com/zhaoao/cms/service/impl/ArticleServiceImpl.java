/**
 * 
 */
package com.zhaoao.cms.service.impl;

import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhaoao.cms.core.Page;
import com.zhaoao.cms.dao.ArticleMapper;
import com.zhaoao.cms.domain.Article;
import com.zhaoao.cms.service.ArticleService;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年4月21日 下午9:06:07
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	@Resource
	ArticleMapper articleMapper;

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<Article> gets(Article conditions, Page page, LinkedHashMap<String, Boolean> orders) {
		List<Article> articles = articleMapper.selects(conditions, orders, page);
		if(page != null && page.getPageCount() == 0){
			int totalCount = articleMapper.count(conditions);
			page.setTotalCount(totalCount);
		}
		return articles;
	}

	@Override
	public void increaseHit(Integer id) {
		articleMapper.increaseHit(id);
		
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		articleMapper.remove(id);
	}

	@Override
	public int count(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.count(article);
	}

	@Override
	public List<Article> selects(Article article, Object object, Page pageinfo) {
		// TODO Auto-generated method stub
		return articleMapper.selects(article, null, pageinfo);
	}

	@Override
	public List<Article> searchblog(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.searchblog(article);
	}
	
	
}
