package com.DemoSpring.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DemoSpring.Model.Role;
import com.DemoSpring.Model.User;
import com.DemoSpring.Respository.RoleResponsity;
import com.DemoSpring.Respository.UserRespository;

@Controller
@RequestMapping("/admin")
public class CCController {
	@Autowired
	RoleResponsity responsity;
	
	PasswordEncoder passwordEncoder;
	public CCController() {
		passwordEncoder = new BCryptPasswordEncoder();
	}
	
	@Autowired
	UserRespository userRespository;
	
	@GetMapping("/add")
	public String add() {
		
		return "add";
	}
	@PostMapping("/add")	
	public String add_(@ModelAttribute("user") User user,@ModelAttribute("rolecc") String roleName) 
	{
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		Role role = responsity.findOneByName(roleName);
		user.setRole(role);
		userRespository.save(user);
		return "index";
	}
	@GetMapping("/{id}") // Form admin
	public String update(@PathVariable("id") int id,Model model) {
		User user = userRespository.findById(id).get();
		model.addAttribute("user", user);
		return "update";
	}
	
}
