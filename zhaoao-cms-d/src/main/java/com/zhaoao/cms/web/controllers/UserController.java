/**
 * 
 */
package com.zhaoao.cms.web.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaoao.cms.domain.Article;
import com.zhaoao.cms.domain.Picture;
import com.zhaoao.cms.domain.User;
import com.zhaoao.cms.service.ArticleService;
import com.zhaoao.cms.service.UserService;
import com.zhaoao.cms.utils.FileUploadUtil;
import com.zhaoao.cms.utils.PageHelpUtil;
import com.zhaoao.cms.web.Constant;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2018年1月10日 下午2:40:38
 */
@Controller
@RequestMapping("/my")
public class UserController {

	@Autowired
	ArticleService articleService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping({"/", "/index", "/home"})
	public String home(){
		
		
		return "user-space/home";
	}
	
	@RequestMapping({"/profile"})
	public String profile(){
		return "user-space/profile";
	}
	
	@RequestMapping({"/profile/avatar"})
	public String avatar(HttpServletRequest request,Model model){
		
		
		return "user-space/avatar";
	}
	
	@RequestMapping({"/profile/avatarsave"})
	public String avatarsave(HttpServletRequest request,MultipartFile file,Model model){
		User loginUser = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
		String upload = FileUploadUtil.upload(request, file);
		if(!upload.equals("")){
			loginUser.setAvapath(upload);
		}
		userService.updateById(loginUser);
		
		request.getServletContext().setAttribute("avatarpath", upload);
				
		return "redirect:/my/profile/avatar";
	}
	

	
	//删除文章
	@RequestMapping("/blog/remove")
	public String remove(Integer id){
		
		articleService.remove(id);
		
		return "redirect:/my/blogs";
	}
		
	
	//用户信息完善或修改
	@RequestMapping("/user/save")
	public String usersave(User user,Model model){
		
		userService.updateById(user);	
		return "redirect:/my/userInfo";
	}
	
	//查询用户信息
	@RequestMapping("/userInfo")
	public String userInfo(HttpServletRequest request,Model model){
		User loginUser = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
		
		User user = userService.selectById(loginUser.getId());
		
		model.addAttribute("user", user);
		return "user-space/useredit";
	}
	
	@RequestMapping("/comments")
	public String comments(){
			
		return null;
	}
	

	
	@RequestMapping("/searchblog")
	public String searchblog(Article article,HttpSession session,Model model,
			@RequestParam(value="page",defaultValue="1")Integer page){
		User user = (User) session.getAttribute(Constant.LOGIN_USER);
		article.setAuthor(user);		
		
		PageHelper.startPage(page,3);
		//当前用户发布的所有文章
		List<Article> articles = articleService.searchblog(article);
		//分页信息
		PageInfo<Article> pageInfo = new PageInfo<Article>(articles,3);
		String pageList = PageHelpUtil.page("/my/blogs", pageInfo);
		
		
		model.addAttribute("blogs", articles);
		model.addAttribute("pageList",pageList);
		
		return "user-space/blog_list";
		
	}
	
}
