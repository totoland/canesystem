package com.nu.dto;

public class Field {
	
	public Field(String acivityName,String label,String type,int column,boolean disable,boolean request,int id,String defaultData){
		this.acivityName = acivityName;
		this.label = label;
		this.type = type;
		this.defaultData = defaultData;
		this.column = column;	
		this.disable = disable;
		this.request = request;
		this.id = id;
		
		
	}
	private String acivityName;
	private String label;
    private String type;
    private String defaultData;
    private int column;
    private boolean disable;
    private boolean request;
    private int id;
    
	public String getAcivityName() {
		return acivityName;
	}
	public void setAcivityName(String acivityName) {
		this.acivityName = acivityName;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public boolean isDisable() {
		return disable;
	}
	public void setDisable(boolean disable) {
		this.disable = disable;
	}
	public boolean isRequest() {
		return request;
	}
	public void setRequest(boolean request) {
		this.request = request;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDefaultData() {
		return defaultData;
	}
	public void setDefaultData(String defaultData) {
		this.defaultData = defaultData;
	}
    
    
    
}
