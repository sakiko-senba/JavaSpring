package jp.saki.subject.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class MemberModel implements Serializable {

	@NotEmpty(message = "会員IDを入力してください")
	private String id;

	@NotEmpty(message = "氏名を入力してください")
	private String name;
	private String gender = "man";
	private String birthday;
	private String address;
	private int old;



	public int getOld() {
		return old;
	}

	public void setOld(int old) {
		this.old = old;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
