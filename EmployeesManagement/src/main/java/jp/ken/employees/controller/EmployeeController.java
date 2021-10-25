package jp.ken.employees.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.ken.employees.groups.GroupOrder;
import jp.ken.employees.model.EmployeeModel;
import jp.ken.employees.model.ListDataModel;

@Controller
public class EmployeeController {





	private List<ListDataModel> getNumberList(int start, int end) {

		List<ListDataModel> numberList = new ArrayList<ListDataModel>();
		for (int i = start; i <= end; i++) {
			numberList.add(new ListDataModel(Integer.toString(i), Integer.toString(i)));
		}

		return numberList;

	}



	private Map<String, String>getPostMap(){
		Map<String, String>postMap = new LinkedHashMap<String, String>();

	//部署リスト作成
	postMap.put("dev", "開発部");
	postMap.put("jinji", "人事部");
	postMap.put("eigyo", "営業部");
	postMap.put("soumu", "総務部");
	postMap.put("keiri", "経理部");
	postMap.put("other", "その他");
	//model.addAttribute("postMap", postMap);
	return postMap;
	}


	private Map<String, String> getCapacitiesMap(){
		Map<String, String>capacitiesMap = new LinkedHashMap<String, String>(); //保有資格マップ



	//保有資格リスト作成
	capacitiesMap.put("it", "ITパスポート");
	capacitiesMap.put("fe", "基本情報技術者試験");
	capacitiesMap.put("ap", "応用情報技術者試験");
	capacitiesMap.put("other", "その他");
	//model.addAttribute("capacitiesMap", capacitiesMap);


	return capacitiesMap;
	}


	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String regist(Model model) {

		// Modelを生成する
		EmployeeModel employeeModel = new EmployeeModel();

		// フォームにModelを関連付ける
		model.addAttribute("employeeModel", employeeModel);

		employeeModel.setBirthYear("2000");
		Calendar calender = Calendar.getInstance();
		model.addAttribute("birthYear", getNumberList(1970, calender.get(Calendar.YEAR)));
		model.addAttribute("birthMonth", getNumberList(1, 12));
		model.addAttribute("birthDay", getNumberList(1, 31));

		employeeModel.setEmpYear("2000");
		calender = Calendar.getInstance();
		model.addAttribute("empYear", getNumberList(2000, calender.get(Calendar.YEAR)));
		model.addAttribute("empMonth",getNumberList(1,12));
		model.addAttribute("empDay",getNumberList(1,31));
		model.addAttribute("postMap",getPostMap());
		model.addAttribute("capacitiesMap",getCapacitiesMap());
		return "employeeRegistration";






	}

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String confirm(@Validated(GroupOrder.class)@ModelAttribute EmployeeModel employeeModel,BindingResult result, Model model) {
		//@ModelAttribute属性はモデルクラスにパラメータをバインドさせる

		// TODO:後で以下のコメント箇所は削除する
		//バインドされていることを確認
		//System.out.println( employeeModel.getGender());

		//パラメータは"men" or "women"なので表示文字を変換する

		if(result.hasErrors()) {
			Calendar cal = Calendar.getInstance();
			model.addAttribute("birthYear", getNumberList(1970,cal.get(Calendar.YEAR)));
			model.addAttribute("birthMonth", getNumberList(1,12));
			model.addAttribute("birthDay", getNumberList(1,31));
			model.addAttribute("empYear", getNumberList(2000,cal.get(Calendar.YEAR)));
			model.addAttribute("empMonth", getNumberList(1,12));
			model.addAttribute("empDay", getNumberList(1,31));
			model.addAttribute("postMap",getPostMap());
			model.addAttribute("capacitiesMap", getCapacitiesMap());

			return "employeeRegistration";

		}







		String gender = employeeModel.getGender();
		if (gender.equals("men")) {
			model.addAttribute("gender", "男");

		} else {
			model.addAttribute("gender", "女");
		}

		//部署
		String post = employeeModel.getPost();
		Map<String,String>postMap = getPostMap();
		model.addAttribute("post", postMap.get(post));


		//保有資格
		String capacities = "";
		Map<String,String>capacitiesMap = getCapacitiesMap();
		if (employeeModel.getCapacities().length == 0) {
			capacities = "無し";
		} else {

			for (String capacity : employeeModel.getCapacities()) {
				if(capacities.length() > 0) {
					capacities += "<br />";
				}
				 capacities += capacitiesMap.get(capacity);
			}
		}

		model.addAttribute("capacities", capacities);

		return "employeeConfirm";
	}




}
