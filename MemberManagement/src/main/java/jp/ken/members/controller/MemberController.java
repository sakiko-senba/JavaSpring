package jp.ken.members.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.ken.members.model.ListDataModel;
import jp.ken.members.model.MemberModel;

@Controller
public class MemberController {

	private List<ListDataModel> getNumberList(int start, int end) {

		List<ListDataModel> numberList = new ArrayList<ListDataModel>();
		for (int i = start; i <= end; i++) {
			numberList.add(new ListDataModel(Integer.toString(i), Integer.toString(i)));
		}

		return numberList;

	}

	private Map<String, String> getMagazineMap() {
		Map<String, String> magazineMap = new LinkedHashMap<String, String>();

		magazineMap.put("made", "Javaってなにができちゃうの");
		magazineMap.put("worry", "Javaお悩み相談");
		magazineMap.put("technique", "Java裏ワザテク");
		magazineMap.put("case", "Springフレームワーク導入事例");
		magazineMap.put("strange", "Springフレームワークの七不思議");
		magazineMap.put("other", "その他のフレームワークについて");

		return magazineMap;
	}

	@RequestMapping(value = "/form",method = RequestMethod.GET)
	public String form(Model model) {

		MemberModel memberModel = new MemberModel();
		memberModel.setBirthYear("2000");
		model.addAttribute("memberModel", memberModel);
		Calendar calender = Calendar.getInstance();
		model.addAttribute("years", getNumberList(1900, calender.get(Calendar.YEAR)));
		model.addAttribute("months", getNumberList(1, 12));
		model.addAttribute("days", getNumberList(1, 31));
		model.addAttribute("magazineMap", getMagazineMap());

		return "memberRegistration";

	}

	@RequestMapping(value = "/form",method = RequestMethod.POST)
	public String confirm(@ModelAttribute MemberModel memberModel,Model model) {

		String tmpGender = memberModel.getGender();
		if(tmpGender.equals("men")) {
			model.addAttribute("gender", "男");

		}else {
			model.addAttribute("gender", "女");
		}

		String mailMagazines = "";
		Map<String,String>magazineMap = getMagazineMap();

		for(String mailMagazine:memberModel.getMailMagazines()){

			if(mailMagazines.length() > 0) {
				mailMagazines += "<br/>";
			}
			mailMagazines += magazineMap.get(mailMagazine);
			}
		model.addAttribute("mailMagazines", mailMagazines);
		String comment = memberModel.getComment();
		comment = comment.replaceAll("\n", "<br/>");
		model.addAttribute("comment", comment);

		return "memberConfirm";

	}

}
