package com.android.dto;

import java.util.List;

import com.google.android.maps.GeoPoint;

public class State {
	private String quotacode;
	private String name;
	private String picturequota;
	private String plotid;
	private String plotcode;
	private String canename;
	private String plotdatecut;
	private String canetypename;
	private String locationmainname;
	private String locationname;
	private String codestaff;
	private String satffname;
	private String color;
	private String strokecolor;
	private List<GeoPoint>listPoint;
	
	public List<GeoPoint> getListPoint() {
		return listPoint;
	}
	public void setListPoint(List<GeoPoint> listPoint) {
		this.listPoint = listPoint;
	}
	public String getQuotacode() {
		return quotacode;
	}
	public void setQuotacode(String quotacode) {
		this.quotacode = quotacode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPicturequota() {
		return picturequota;
	}
	public void setPicturequota(String picturequota) {
		this.picturequota = picturequota;
	}
	public String getPlotid() {
		return plotid;
	}
	public void setPlotid(String plotid) {
		this.plotid = plotid;
	}
	public String getPlotcode() {
		return plotcode;
	}
	public void setPlotcode(String plotcode) {
		this.plotcode = plotcode;
	}
	public String getCanename() {
		return canename;
	}
	public void setCanename(String canename) {
		this.canename = canename;
	}
	public String getPlotdatecut() {
		return plotdatecut;
	}
	public void setPlotdatecut(String plotdatecut) {
		this.plotdatecut = plotdatecut;
	}
	public String getCanetypename() {
		return canetypename;
	}
	public void setCanetypename(String canetypename) {
		this.canetypename = canetypename;
	}
	public String getLocationmainname() {
		return locationmainname;
	}
	public void setLocationmainname(String locationmainname) {
		this.locationmainname = locationmainname;
	}
	public String getLocationname() {
		return locationname;
	}
	public void setLocationname(String locationname) {
		this.locationname = locationname;
	}
	public String getCodestaff() {
		return codestaff;
	}
	public void setCodestaff(String codestaff) {
		this.codestaff = codestaff;
	}
	public String getSatffname() {
		return satffname;
	}
	public void setSatffname(String satffname) {
		this.satffname = satffname;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getStrokecolor() {
		return strokecolor;
	}
	public void setStrokecolor(String strokecolor) {
		this.strokecolor = strokecolor;
	}
}
