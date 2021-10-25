package jp.saki.subject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.saki.subject.model.LoginModel;


@Controller
@RequestMapping("login")
@SessionAttributes("loginModel")

public class LoginController {




	@ModelAttribute("loginModel")
	public LoginModel setupLoginForm() {
		return new LoginModel();
	}


	@RequestMapping(method = RequestMethod.GET)
	public String toRegist() {
		return "home1";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String toRegist(@Validated @ModelAttribute LoginModel sModel, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "home1";
		} else if (sModel.getUser().equals("saki") && sModel.getPassword().equals("sakiko")) {
			return "redirect:/regist";
		} else {
			model.addAttribute("errorMessage", "ログインIDもしくはパスワードが間違っています。");
			return "home1";
		}
	}



}
