package com.android.utils;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.android.dto.State;
import com.android.googlemaps.xml.XMLParser;
import com.google.android.maps.GeoPoint;

public class XMLUti {
	static final String KEY_STATES = "states";
	static final String KEY_STATES_STATE = "state";
	static final String KEY_STATES_STATE_QUOTACODE = "quotacode";
	static final String KEY_STATES_STATE_NAME = "name";
	static final String KEY_STATES_STATE_PICTUREQUOTA = "picturequota";
	static final String KEY_STATES_STATE_PLOTID = "plotid";
	static final String KEY_STATES_STATE_PLOTCODE = "plotcode";
	static final String KEY_STATES_STATE_CANENAME = "canename";
	static final String KEY_STATES_STATE_PLOTDATECUT = "plotdatecut";
	static final String KEY_STATES_STATE_CANETYPENAME = "canetypename";
	static final String KEY_STATES_STATE_LOCATIONNAME = "locationname";
	static final String KEY_STATES_STATE_CODESTAFF = "codestaff";
	static final String KEY_STATES_STATE_SATFFNAME = "satffname";
	static final String KEY_POINT_LAT  = "lat";
	static final String KEY_POINT_LNG  = "lng";
	static final String KEY_PLOTDATECUT = "plotdatecut";
	static final String KEY_CANETYPENAME = "canetypename";
	static final String KEY_LOCATIONMAINNAME = "locationmainname";
	static final String KEY_LOCATIONNAME = "locationname";
	public XMLUti(){
		
	}
	
	public List<State> getXMLElement(){
		System.out.println("getXMLElement");
		XMLParser parser = new XMLParser();
		String xml = parser.getXmlFromUrl(AndroidConstant.URL_XML_POLYGON); // getting XML
		Document doc = parser.getDomElement(xml); // getting DOM element
		 
		NodeList nl = doc.getElementsByTagName(KEY_STATES_STATE);
		List<State>listState = new ArrayList<State>(); 
		// looping through all item nodes <item>
		for (int i = 0; i < nl.getLength(); i++) {
            Element e = (Element) nl.item(i);
            State state = new State();
            state.setQuotacode(nl.item(i).getAttributes().getNamedItem(KEY_STATES_STATE_QUOTACODE).getNodeValue());
            state.setName(nl.item(i).getAttributes().getNamedItem(KEY_STATES_STATE_NAME).getNodeValue());
            NodeList nPoint = e.getElementsByTagName("point");
            state.setListPoint(new ArrayList<GeoPoint>());
            for(int j=0;j<nPoint.getLength();j++){
            	int lat = (int)((Double.parseDouble(nPoint.item(j).getAttributes().getNamedItem(KEY_POINT_LAT).getNodeValue())*1e6));
            	int lng = (int)((Double.parseDouble(nPoint.item(j).getAttributes().getNamedItem(KEY_POINT_LNG).getNodeValue())*1e6));
            	state.getListPoint().add(new GeoPoint(lat, lng));
            }
            state.setPlotcode(nl.item(i).getAttributes().getNamedItem(KEY_STATES_STATE_PLOTCODE).getNodeValue());
            state.setCanetypename(nl.item(i).getAttributes().getNamedItem(KEY_CANETYPENAME).getNodeValue());
            state.setPlotdatecut(nl.item(i).getAttributes().getNamedItem(KEY_STATES_STATE_PLOTDATECUT).getNodeValue());
            state.setLocationmainname(nl.item(i).getAttributes().getNamedItem(KEY_LOCATIONNAME).getNodeValue());
            state.setLocationname(nl.item(i).getAttributes().getNamedItem(KEY_LOCATIONNAME).getNodeValue());
            listState.add(state);
		}
		System.out.println("listState.size");
		System.out.println("listState.size : "+listState.size());
		return listState;
	}
}
