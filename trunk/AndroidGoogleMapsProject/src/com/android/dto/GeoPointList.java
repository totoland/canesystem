package com.android.dto;

import java.util.ArrayList;

import com.google.android.maps.GeoPoint;

public class GeoPointList {
	private ArrayList<ArrayList<GeoPoint>> points = new ArrayList<ArrayList<GeoPoint>>();
	
	public void add(ArrayList<GeoPoint> points){
		this.points.add(points);
	}
	public ArrayList<GeoPoint> get(int index){
		return points.get(index);
	}
	public int size(){
		return points.size();
	}
}
