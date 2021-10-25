package jp.ken.exam.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class ExamModel implements Serializable {

	@NotEmpty(message = "名前は省略できません")
	private String name;

	private String answer1;
	private String answer2;
	private String answer3;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}


}
