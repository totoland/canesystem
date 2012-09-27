
package ws;

import android.annotation.SuppressLint;
import java.util.Hashtable;

import javax.xml.datatype.XMLGregorianCalendar;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class TBLTacGpsPoint implements KvmSerializable{
	private static final long serialVersionUID = -1166006770093411055L;

    protected String Gps_lat;
    protected String Gps_long;
    protected String Gps_timestamp;
    protected String Gps_key;
    protected String Gps_status;
    protected XMLGregorianCalendar Gps_datetime;
    protected String Gps_utm_lat;
    protected String Gps_utm_long;
    
    public String getGps_lat() {
		return Gps_lat;
	}
	public void setGps_lat(String gps_lat) {
		Gps_lat = gps_lat;
	}
	public String getGps_long() {
		return Gps_long;
	}
	public void setGps_long(String gps_long) {
		Gps_long = gps_long;
	}
	public String getGps_timestamp() {
		return Gps_timestamp;
	}
	public void setGps_timestamp(String gps_timestamp) {
		Gps_timestamp = gps_timestamp;
	}
	public String getGps_key() {
		return Gps_key;
	}
	public void setGps_key(String gps_key) {
		Gps_key = gps_key;
	}
	public String getGps_status() {
		return Gps_status;
	}
	public void setGps_status(String gps_status) {
		Gps_status = gps_status;
	}
	public String getGps_utm_lat() {
		return Gps_utm_lat;
	}
	public void setGps_utm_lat(String gps_utm_lat) {
		Gps_utm_lat = gps_utm_lat;
	}
	public String getGps_utm_long() {
		return Gps_utm_long;
	}
	public void setGps_utm_long(String gps_utm_long) {
		Gps_utm_long = gps_utm_long;
	}
	
    
	public Object getProperty(int arg0) {
		 switch(arg0)
	        {
	        case 0:
	            return Gps_lat;
	        case 1:
	            return Gps_long;
	        case 2:
	            return Gps_timestamp;
	        case 3:
	            return Gps_key;
	        case 4:
	            return Gps_status;
	        case 5:
	            return Gps_datetime;
	        case 6:
	            return Gps_utm_lat;
	        case 7:
	            return Gps_utm_long;    
	        }
	        
	        return null;
	}
	public int getPropertyCount() {
		// TODO Auto-generated method stub
		return 8;
	}
	public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) {
		switch(index)
        {
        case 0:
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "Gps_lat";
            break;
        case 1:
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "Gps_long";
            break;
        case 2:
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "Gps_timestamp";
            break;
        case 3:
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "Gps_key";
            break;
        case 4:
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "Gps_status";
            break;
        case 5:
            info.type = PropertyInfo.OBJECT_CLASS;
            info.name = "Gps_datetime";
            break;
        case 6:
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "Gps_utm_lat";
            break;
        case 7:
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "Gps_utm_lon";
            break;    
        default:break;
        }
		
	}
	public void setProperty(int arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	@SuppressLint({ "NewApi", "NewApi" })
	public XMLGregorianCalendar getGps_datetime() {
		return Gps_datetime;
	}
	public void setGps_datetime(XMLGregorianCalendar gps_datetime) {
		Gps_datetime = gps_datetime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
}
