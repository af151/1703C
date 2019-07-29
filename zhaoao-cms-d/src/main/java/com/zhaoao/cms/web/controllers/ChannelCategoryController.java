package com.zhaoao.cms.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhaoao.cms.domain.Category;
import com.zhaoao.cms.domain.Channel;
import com.zhaoao.cms.service.ChannelCategoryService;

@Controller
public class ChannelCategoryController {
	
	@Autowired
	private ChannelCategoryService channelCategoryService;
	
	
	@RequestMapping("queryAllChannel")
	@ResponseBody
	public List<Channel> queryAllChannel(){
		return channelCategoryService.getChannels();
	}
	
	@RequestMapping("queryCategoryByChannelId")
	@ResponseBody
	public List<Category> queryCategoryByChannelId(Integer channel){
		return channelCategoryService.getCategories(channel);
	}
	
}
