package com.mpj.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mpj.pojo.User;

@Controller
@RequestMapping("/")
public class UserController {

	@RequestMapping("/loginAdmin.do")
	public String login(User user, Model model) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
		try {
			subject.login(token);
			return "../admin";
		} catch (Exception e) {
			model.addAttribute("error", "用户名或密码错误");
			return "../login";
		}
	}
}
