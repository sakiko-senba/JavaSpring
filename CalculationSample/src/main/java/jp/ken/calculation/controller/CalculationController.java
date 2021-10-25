package jp.ken.calculation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.ken.calculation.exception.NegativeException;
import jp.ken.calculation.model.CalculationModel;

@Controller
public class CalculationController {
	@RequestMapping(value = "/sample", method = RequestMethod.GET)
	public String toCalculation(Model model) {

		model.addAttribute("message", "整数を入力してください");
		model.addAttribute("calculationModel", new CalculationModel());

		return "calculation";

	}

	@RequestMapping(value = "/sample", method = RequestMethod.POST)
	public String calculate(@ModelAttribute CalculationModel calculationModel, Model model) throws NumberFormatException, NegativeException ,ArithmeticException{

		int value1 = Integer.parseInt(calculationModel.getValue1());
		int value2 = Integer.parseInt(calculationModel.getValue2());
		int operator = Integer.parseInt(calculationModel.getOperator());

		if (value1 < 0 || value2 < 0) {
			throw new NegativeException();
		}

		int answer;
		switch (operator) {
		case 1:
			answer = value1 + value2;
			break;

		case 2:
			answer = value1 - value2;
			break;

		case 3:
			answer = value1 * value2;
			break;

		case 4:
			answer = value1 / value2;
			break;

		default:
			answer = 0;

		}

		model.addAttribute("answer", answer);
		model.addAttribute("message", "計算結果");

		return "calculation";

	}

	public ModelAndView toError(String message) {
		ModelAndView model = new ModelAndView("error");
		model.addObject("error", message);
		model.addObject("url", "sample");
		return model;

	}

	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView handleException(NumberFormatException e) {
		return toError("未入力もしくは整数以外の値では計算できません。");

	}
	@ExceptionHandler(NegativeException.class)
	public ModelAndView handleException(NegativeException e) {
		return toError("マイナスの整数は計算対象外です。");

	}
	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView handleException(ArithmeticException e) {
		return toError("０で割算することはできません。");

	}

}
