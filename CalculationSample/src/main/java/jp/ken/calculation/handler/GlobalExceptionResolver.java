package jp.ken.calculation.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import jp.ken.calculation.exception.NegativeException;

@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {

		ModelAndView model = new ModelAndView("error");
		if(ex.getClass() == NumberFormatException.class) {
			model.addObject("error","未入力もしくは数値以外の値では計算ができません。");

		}else if(ex.getClass() == NegativeException.class) {
			model.addObject("error","マイナスの数値は計算対象外です。");
		}else if(ex.getClass() == ArithmeticException.class) {
			model.addObject("error","0で割算するこはができません。");
		}else {
			model.addObject("error","エラー("+ ex +")が発生しました。");
		}
		model.addObject("url", "another");

		return model;
	}

}
