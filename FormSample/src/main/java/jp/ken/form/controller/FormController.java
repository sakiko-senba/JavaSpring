package jp.ken.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.ken.form.model.FormModel;

@Controller
public class FormController {

	@RequestMapping(value="/sample",method=RequestMethod.GET)
	public String form (Model model) {
		FormModel formModel = new FormModel();
		model.addAttribute("formModel",formModel);
		return "disp";
	}



	@RequestMapping(value="/sample",method=RequestMethod.POST)
	public String display(@ModelAttribute FormModel formModel,Model model) {
		model.addAttribute("message",formModel.getName()+"さん、こんにちは。");
	return "disp";
}

}
