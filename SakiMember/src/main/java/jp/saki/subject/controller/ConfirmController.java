package jp.saki.subject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("comfirm")
@SessionAttributes("memberModel")
public class ConfirmController {



	@RequestMapping(method = RequestMethod.GET)
	public String toConfirm() {
		return "confirmForm";

	}

	@RequestMapping(method = RequestMethod.POST, params = "back")
	public String toregist() {

		return "redirect:/regist";
	}

	@RequestMapping(method = RequestMethod.POST, params = "forward")
	public String toFinish(Model model,SessionStatus status) {

		status.setComplete();

		 return "finishForm";
	}






}
