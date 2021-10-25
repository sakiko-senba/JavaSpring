package jp.ken.calculation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.ken.calculation.exception.NegativeException;
import jp.ken.calculation.model.CalculationModel;


@Controller
public class AnotherCalculationController {


	@RequestMapping(value = "/another",method = RequestMethod.GET)
	public String toCalculation(Model model) {
		model.addAttribute("message", "整数を入力してください");
		model.addAttribute("calculationModel", new CalculationModel());
		return "calculation";
	}


	@RequestMapping(value = "/another",method = RequestMethod.POST)
	public String culatite(@ModelAttribute CalculationModel calculationModel,Model model) throws NumberFormatException, NegativeException ,ArithmeticException {

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

}
