package jp.ken.employees.model;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import jp.ken.employees.groups.Group1;

public class EmployeeModel implements Serializable {

	@NotEmpty(message = "名前は必須入力です")
	private String name;
	@NotEmpty(message = "フリガナは必須入力です")
	private String kana;
	private String gender;
	private String birthYear;
	private String birthMonth;
	private String birthDay;
	@NotEmpty(message = "郵便番号は必須入力です")
	@Pattern(regexp = "^[0-9]{3}-[0-9]{4}$", message = "郵便番号ではありません", groups = Group1.class)
	private String zip;
	@NotEmpty(message = "住所は必須入力です")
	private String address;
	@NotEmpty(message = "携帯番号は必須入力です")
	@Pattern(regexp = "^[0-9]{3}-[0-9]{4}-[0-9]{4}$", message = "電話番号ではありません", groups = Group1.class)
	private String phone;
	@NotEmpty(message = "メールアドレスは必須入力です")
	@Email(groups = Group1.class, message = "メールアドレスではありません")
	private String mail;
	private String empYear;
	private String empMonth;
	private String empDay;
	private String post;
	private String[] capacities;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKana() {
		return kana;
	}

	public void setKana(String kana) {
		this.kana = kana;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getBirthMonth() {
		return birthMonth;
	}

	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getEmpYear() {
		return empYear;
	}

	public void setEmpYear(String empYear) {
		this.empYear = empYear;
	}

	public String getEmpMonth() {
		return empMonth;
	}

	public void setEmpMonth(String empMonth) {
		this.empMonth = empMonth;
	}

	public String getEmpDay() {
		return empDay;
	}

	public void setEmpDay(String empDay) {
		this.empDay = empDay;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String[] getCapacities() {
		return capacities;
	}

	public void setCapacities(String[] capacities) {
		this.capacities = capacities;
	}

}
