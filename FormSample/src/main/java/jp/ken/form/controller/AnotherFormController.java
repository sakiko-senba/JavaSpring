package jp.ken.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.ken.form.model.FormModel;

	@Controller
public class AnotherFormController {




		@RequestMapping(value="/another",method=RequestMethod.GET)
		public ModelAndView form () {
			ModelAndView modelAndView = new ModelAndView ("disp");
			FormModel formModel = new FormModel();

			modelAndView.addObject("formModel",formModel);
			return modelAndView;
		}

		@RequestMapping(value="/another",method=RequestMethod.POST)
		public ModelAndView display(@ModelAttribute FormModel formModel) {
			ModelAndView modelAndView = new ModelAndView("disp");
			modelAndView.addObject("message",formModel.getName() + "さん、こんにちは。");
			return modelAndView;
		}

}
