package jp.ken.exam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jp.ken.exam.dao.QuestionsDao;
import jp.ken.exam.entity.Questions;
import jp.ken.exam.model.ExamModel;
import jp.ken.exam.model.QuestionsOptionModel;
import jp.ken.exam.model.ResultModel;

@Controller
@SessionAttributes("examModel")
public class ExamController {
	@Autowired
	private QuestionsDao questionsDao;

	@ModelAttribute("examModel")
	public ExamModel setUpExamModel() {
		return new ExamModel();

	}

	@RequestMapping(value = "/top", method = RequestMethod.GET)
	public String toTop() {
		return "top";

	}

	@RequestMapping(value = "/top", method = RequestMethod.POST)
	public String top(@Validated @ModelAttribute ExamModel examModel, BindingResult result) {
		if (result.hasErrors()) {
			return "top";
		}
		return "redirect:/exam1";
	}


	private List<QuestionsOptionModel> createQuestionsOptionList(Questions questions){
		QuestionsOptionModel option;
		List<QuestionsOptionModel> questionsOptionList = new ArrayList<QuestionsOptionModel>();

		option = new QuestionsOptionModel();
		option.setPath("answer" + questions.getQuestionroorrrt_id());
		option.setLabel(questions.getOption1_value() + "." + questions.getOption1_label());
		option.setValue(questions.getOption1_value());
		questionsOptionList.add(option);

		option = new QuestionsOptionModel();
		option.setPath("answer" + questions.getQuestionroorrrt_id());
		option.setLabel(questions.getOption2_value() + "." + questions.getOption2_label());
		option.setValue(questions.getOption2_value());
		questionsOptionList.add(option);

		option = new QuestionsOptionModel();
		option.setPath("answer" + questions.getQuestionroorrrt_id());
		option.setLabel(questions.getOption3_value() + "." + questions.getOption3_label());
		option.setValue(questions.getOption3_value());
		questionsOptionList.add(option);

		option = new QuestionsOptionModel();
		option.setPath("answer" + questions.getQuestionroorrrt_id());
		option.setLabel(questions.getOption4_value() + "." + questions.getOption4_label());
		option.setValue(questions.getOption4_value());
		questionsOptionList.add(option);


		return questionsOptionList;

	}








	@RequestMapping(value = "/exam1", method = RequestMethod.GET)
	public String toExam1(@ModelAttribute ExamModel examModel, Model model) {

		Questions questions = questionsDao.getQuestionsById(1);
		List<QuestionsOptionModel> questionsOptionList = createQuestionsOptionList(questions);
		model.addAttribute("questionsOptionList", questionsOptionList);
		model.addAttribute("questionSentence", questions.getQuestion_sentence());
		model.addAttribute("mainHeader", "問題1");
		model.addAttribute("submitValue", "問題2へ");

		return "question";

	}

	@RequestMapping(value = "/exam1", method = RequestMethod.POST)
	public String exam1(@ModelAttribute ExamModel examModel) {
		return "redirect:/exam2";
	}

	@RequestMapping(value = "/exam2", method = RequestMethod.GET)
	public String toExam2(Model model) {

		Questions questions = questionsDao.getQuestionsById(2);
		List<QuestionsOptionModel> questionsOptionList = createQuestionsOptionList(questions);
		model.addAttribute("questionsOptionList", questionsOptionList);
		model.addAttribute("questionSentence", questions.getQuestion_sentence());
		model.addAttribute("mainHeader", "問題2");
		model.addAttribute("submitValue", "問題3へ");

		return "question";

	}

	@RequestMapping(value = "/exam2", method = RequestMethod.POST)
	public String exam2(@ModelAttribute ExamModel examModel) {
		return "redirect:/exam3";
	}

	@RequestMapping(value = "/exam3", method = RequestMethod.GET)
	public String toExam3(Model model) {

		Questions questions = questionsDao.getQuestionsById(3);
		List<QuestionsOptionModel> questionsOptionList = createQuestionsOptionList(questions);
		model.addAttribute("questionsOptionList", questionsOptionList);
		model.addAttribute("questionSentence", questions.getQuestion_sentence());
		model.addAttribute("mainHeader", "問題3");
		model.addAttribute("submitValue", "結果確認");

		return "question";

	}

	@RequestMapping(value = "/exam3", method = RequestMethod.POST)
	public String exam3(@ModelAttribute ExamModel examModel) {
		return "redirect:/result";
	}

	@RequestMapping(value = "result", method = RequestMethod.GET)
	public String toResult(@ModelAttribute ExamModel examModel, Model model, SessionStatus status) {
		List<Questions> questionsList = questionsDao.getList();
		String[] answers = {
				examModel.getAnswer1(), examModel.getAnswer2(), examModel.getAnswer3()
		};

		List<ResultModel> resultModelList = new ArrayList<ResultModel>();

		int numberOfRightAnswers = 0;
		for (int i = 0; i < answers.length; i++) {
			Questions questions = questionsList.get(i);
			String rightAnswer = questions.getRight_answer();

			ResultModel resultModel = new ResultModel();
			resultModel.setQuestionId("問題" + questions.getQuestionroorrrt_id());
			resultModel.setAnswer(answers[i]);
			resultModel.setRightAnswer(rightAnswer);

			if (rightAnswer.equals(answers[i])) {
				numberOfRightAnswers++;
				resultModel.setResult(true);

			}
			resultModelList.add(resultModel);

		}
		model.addAttribute("resultModelList", resultModelList);
		model.addAttribute("numberOfRightAnswers", numberOfRightAnswers);

		status.setComplete();
		return "result";

	}

}
