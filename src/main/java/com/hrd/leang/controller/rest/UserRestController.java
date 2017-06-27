package com.hrd.leang.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrd.leang.model.User;
import com.hrd.leang.services.UserService;


@Controller
public class UserRestController {
	
	private UserService userService;
	@Autowired
	public UserRestController(UserService userService){
		this.userService = userService;
	}
	@RequestMapping("/admin/select")
	public String findAll(ModelMap model){
		model.addAttribute("user", userService.findAll());
		return "/admin/dashboard";
	}
	@RequestMapping("/admin/user")
	public String list(ModelMap model){
		model.addAttribute("user", userService.findAll());
		return "/admin/user";
	}
	
	/**
	 * insert user to database
	 * @param user
	 * @param model
	 * @return
	 */
	
	
	@RequestMapping("/admin/user-cu")
	public String user_cu(ModelMap model){
		model.addAttribute("user", new User());
		model.addAttribute("addStatus", true);
		return "/admin/user-cu";
	}
	
	
	/**
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@PostMapping(value ="/admin/save")
	public String userlist(@ModelAttribute User user, ModelMap model){
		userService.save(user);
		return "redirect:/admin/user";
		
	}
	@GetMapping(value = "/admin/edit")
	public String edit(ModelMap model, @RequestParam("user_hash") String user_hash) {
		User user=userService.find(user_hash);
		System.out.println("find User Hash" + user.getUser_hash());
		model.addAttribute("user", user);
		
		return "/admin/user-cu";
	}
	
	@PostMapping(value = "/admin/update")
	public String update(@ModelAttribute("user") User user) {
		System.out.println("user_hash "+ user.getUser_hash()  );
		if(userService.update(user)){
			System.out.println("updated!!");
		}
		return "redirect:/admin/select";
	}
	@RequestMapping(value = "/admin/remove")
	public String remove(@RequestParam String user_hash) {
//		int confirm=JOptionPane.showConfirmDialog(null, "Are You Sure", "Delete", JOptionPane.YES_NO_OPTION);
//		if(confirm==JOptionPane.YES_OPTION){
//			
//			userserivce.delete(user_hash);
//		}
		if(userService.delete(user_hash)){
			System.out.println("Success");
		}
		return "redirect:/admin/select";
	}
	@RequestMapping(value = "/user/aid")
	public String detailpage(ModelMap model, @RequestParam("user_hash") String user_hash) {

		User user = userService.find(user_hash);
		model.addAttribute("user", user);

		return "/admin/userdetail";
	}
}
