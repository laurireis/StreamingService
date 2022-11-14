package hh.swd20.musicapp.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hh.swd20.musicapp.domain.SignupForm;
import hh.swd20.musicapp.domain.User;
import hh.swd20.musicapp.domain.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@GetMapping(value = "/signup")
	public String addUser(Model model) {
		model.addAttribute("signupform", new SignupForm());
		return "signup";
	}
	
	@PostMapping(value = "/saveuser")
	public String save(@Valid @ModelAttribute("signupform") SignupForm signupForm, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			if (signupForm.getPassword().equals(signupForm.getPasswordCheck())) {
				String password = signupForm.getPassword();
				BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
				String hashPassword = bc.encode(password);
				
				User newUser = new User();
				newUser.setPasswordHash(hashPassword);
				newUser.setUsername(signupForm.getUsername());
				newUser.setRole("USER");
				if (repository.findByUsername(signupForm.getUsername()) == null) {
					repository.save(newUser);
				} else {
					bindingResult.rejectValue("username", "err.username", "Username already exists");
					return "signup";
				}
			} else {
				bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords do not match");
				return "signup";
			}
		} else {
			return "signup";
		}
		return "redirect:/login";
	}
	
}
