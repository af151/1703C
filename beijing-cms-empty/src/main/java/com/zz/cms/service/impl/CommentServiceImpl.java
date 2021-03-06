package com.zz.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.cms.dao.CommentMapper;
import com.zz.cms.domain.Comment;
import com.zz.cms.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;

	@Override
	public void save(Comment comment) {
		commentMapper.save(comment);
	}
}
