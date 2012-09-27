package com.android.googlemaps.ws;

import geotransform.coords.Gdc_Coord_3d;
import geotransform.coords.Utm_Coord_3d;
import geotransform.transforms.Gdc_To_Utm_Converter;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import com.android.utils.AndroidConstant;

import ws.TBLTacGpsPoint;

import android.util.Log;

public class WebServices {
	private final String NAMESPACE = "http://tempuri.org/";
    private final String URL = AndroidConstant.URL_WS_TAGGING;
    private final String SOAP_ACTION = "http://tempuri.org/addPoint";
    private final String METHOD_NAME = "addPoint";
    
    public String ws(String key,String lat,String lon,String timeStamp){
    	SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
       

        /***
        <s:element minOccurs="0" maxOccurs="1" name="Gps_lat" type="s:string"/>
        <s:element minOccurs="0" maxOccurs="1" name="Gps_long" type="s:string"/>
        <s:element minOccurs="0" maxOccurs="1" name="Gps_timestamp" type="s:string"/>
        <s:element minOccurs="0" maxOccurs="1" name="Gps_key" type="s:string"/>
        <s:element minOccurs="0" maxOccurs="1" name="Gps_status" type="s:string"/>
        <s:element minOccurs="1" maxOccurs="1" name="Gps_datetime" nillable="true" type="s:dateTime"/>
        <s:element minOccurs="0" maxOccurs="1" name="Gps_utm_lat" type="s:string"/>
        <s:element minOccurs="0" maxOccurs="1" name="Gps_utm_long" type="s:string"/>
         ***/
    	

    	
        TBLTacGpsPoint obj = new TBLTacGpsPoint();
        obj.setGps_key("abc");
        obj.setGps_lat(lat);
        obj.setGps_long(lon);
        obj.setGps_status("1");
        obj.setGps_timestamp(timeStamp);
        obj.setGps_datetime(null);
        Gdc_Coord_3d gdc_point = new Gdc_Coord_3d();
    	Utm_Coord_3d utm_point = new Utm_Coord_3d();
    	gdc_point.latitude = Double.valueOf(lat).doubleValue();
        gdc_point.longitude = Double.valueOf(lon).doubleValue();
        gdc_point.elevation = 100.00;
    	
    	Gdc_To_Utm_Converter.Convert(gdc_point,utm_point);
  	  	
  	  	Log.d("TAG","x : "+utm_point.x+"");
  	  	Log.d("TAG","y : "+utm_point.y+"");
  	  	
  	  	obj.setGps_utm_lat(utm_point.x+"");
  	  	obj.setGps_utm_long(utm_point.y+"");
  	  	
        PropertyInfo pi = new PropertyInfo();
        pi.setName("obj");
        pi.setValue(obj);
        pi.setType(obj.getClass());
        request.addProperty(pi);
        
        
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);
        envelope.addMapping(NAMESPACE, "TBL_Tac_gps_point",new TBLTacGpsPoint().getClass());
        
        HttpTransportSE androidHttpTransport = new HttpTransportSE (URL);
        androidHttpTransport.debug = true;

        try {
            androidHttpTransport.call(SOAP_ACTION, envelope);
            SoapPrimitive response = (SoapPrimitive)envelope.getResponse();
            Log.i("myApp", response.toString());
            return response.toString();
        } catch (Exception e) {
        	Log.e("TAG", e.toString());
        	System.out.println(e.toString());
            return null;
        }
    }
}
