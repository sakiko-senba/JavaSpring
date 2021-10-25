package jp.saki.subject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jp.saki.subject.model.MemberModel;

@Controller
@RequestMapping("regist")
@SessionAttributes({ "loginModel", "memberModel" })

public class RegistController {

	@ModelAttribute("memberModel")
	public MemberModel setupMemberModel() {
		return new MemberModel();

	}
	
	
	

	@RequestMapping(method = RequestMethod.GET)
	public String toRegist() {
		return "registForm";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String toConfirm(@Validated @ModelAttribute MemberModel mModel, BindingResult result) {

		if (result.hasErrors()) {
			return "registForm";

		} else {
			return "confirmForm";

		}
	}

	@RequestMapping(method = RequestMethod.POST, params = "back")
	public String toregist() {

		return "registForm";
	}

	@RequestMapping(method = RequestMethod.POST, params = "forward")
	public String toFinish(Model model,SessionStatus status) {

		status.setComplete();

		 return "finishForm";
	}

	@RequestMapping(method = RequestMethod.POST, params = "logout")
	public String tohome(Model model,SessionStatus status) {

		status.setComplete();

		 return "home1Form";
	}

}
