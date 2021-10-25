package jp.ken.calculation.model;

import java.io.Serializable;

public class CalculationModel implements Serializable {

	private String value1;
	private String value2;
	private String operator;


	public String getValue1() {
		return value1;
	}
	public void setValue1(String value1) {
		this.value1 = value1;
	}
	public String getValue2() {
		return value2;
	}
	public void setValue2(String value2) {
		this.value2 = value2;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}







}
