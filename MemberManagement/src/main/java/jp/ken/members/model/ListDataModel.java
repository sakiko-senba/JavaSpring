package jp.ken.members.model;

public class ListDataModel {
	
	private String label;
	private String data;
	
	
	public ListDataModel(String label, String data) {
		super();
		this.label = label;
		this.data = data;
	}
	
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	

}
