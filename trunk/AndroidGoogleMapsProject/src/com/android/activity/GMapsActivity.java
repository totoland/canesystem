package com.android.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.activity.R;
import com.android.dao.TblPoint;
import com.android.utils.AndroidConstant;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import com.google.android.maps.Projection;

@SuppressLint("NewApi")
public class GMapsActivity extends MapActivity {
	
	public MapView mapView;
	public LocationManager locationManager;
	public static final int latitudeE6 = 13;
	public static final int longitudeE6 = 100;
	public String provider;
	public static String TAG = "GMapsActivity";
	public CustomItemizedOverlay itemizedOverlay;
	public LocationListener mlocListener = null;
	public Locale locale = new Locale("th", "TH");
	private MapController controller;
	private Drawable drawable;
	private TblPoint tblPoint;
	private Button btnPolygon;
	private Button btnNowGIS;
	private Button btnStopGIS;
	private boolean flagSatellite = false;
	private MyLocationOverlay overlayNowGIS;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        if (android.os.Build.VERSION.SDK_INT > 9) {
        	StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        	StrictMode.setThreadPolicy(policy);
        }
        Log.i("", "onCreate");
        this.loadInit();
        Intent startingIntent = getIntent();

        if (startingIntent != null)
        {
            Bundle b = startingIntent.getExtras();
            if (b != null)
            {
                if(b.getString(AndroidConstant.MODE).equals(AndroidConstant.TAGGING)){
                	Log.i("", "tagging");
                	mlocListener = new MyLocationListener();
                	try {
						potNowGis();
					} catch (Exception e) {
						e.printStackTrace();
					}
                }else if(b.getString(AndroidConstant.MODE).equals(AndroidConstant.LOAD_PLANG_POLYGON)){
                	btnNowGIS = (Button)findViewById(R.id.now_gis);
                	btnNowGIS.setVisibility(View.GONE);
                	btnStopGIS = (Button)findViewById(R.id.bt_stop_gis);
                	btnStopGIS.setVisibility(View.GONE);
                	mlocListener = new LocationListenerShowLocation();
                	onClickPolygon(null);
                	
                	try {
						drawsPolygonNearLocation();
					} catch (Exception e) {
						e.printStackTrace();
					}
                }
            }
            else
            {
            	Log.e("", "can 't get bundle");
            }
        }
        nowLocation();

    }
    public void nowLocation(){
    	if(overlayNowGIS==null){
    		overlayNowGIS = new MyLocationOverlay(this, mapView);
    	}
    	overlayNowGIS.enableMyLocation();
    	overlayNowGIS.enableCompass(); // does not work in emulator
    	overlayNowGIS.runOnFirstFix(new Runnable() {
			public void run() {
				// Zoom in to current location
				controller.setZoom(17);
				controller.animateTo(overlayNowGIS.getMyLocation());
			}
		});
		mapView.getOverlays().add(overlayNowGIS);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.map_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.item_map_hybrid) {
        	flagSatellite = !flagSatellite;
            mapView.setSatellite(flagSatellite);
        }else if(item.getItemId()==R.id.item_map_now_gis){
        	nowLocation();
        }
        return true;
    }
	public void loadInit() {
		Locale.setDefault(locale);
		drawable = this.getResources().getDrawable(R.drawable.marker_red);
		mapView = (MapView) findViewById(R.id.map_view);
		mapView.setBuiltInZoomControls(true);
		mapView.setSatellite(flagSatellite);
		mapView.setDrawingCacheEnabled(true);
		mapView.setDrawingCacheQuality(0);
		mapView.setFilterTouchesWhenObscured(true);
		mapView.setSaveEnabled(true);
		mapView.setScrollbarFadingEnabled(true);
	    //mlocListener = new MyLocationListener();
    	locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    	
    	controller = mapView.getController();
    	overlayNowGIS = new MyLocationOverlay(this, mapView);
	}
	
	public void onClickPolygon(View view){
		tblPoint =  new TblPoint(this);
		Cursor cursor = tblPoint.findStateWhereState("500");
		int row = cursor.getCount();
		mapView.getOverlays().clear();
		String stateID = null;
		
	    
	    ArrayList<GeoPoint>listPoint = new ArrayList<GeoPoint>();
	    int loop = 1;
	    int rowAll = 0;
	    cursor.moveToFirst();
		do{
	    	if(stateID==null){
	    		stateID = cursor.getString(cursor.getColumnIndex("StateID"));
	    	}
	    	if(!stateID.equals(cursor.getString(cursor.getColumnIndex("StateID"))) || loop==row){
				CustomItemizedOverlay itemizedOverlay = new CustomItemizedOverlay(drawable, this);
				ArrayList<GeoPoint>tempList = new ArrayList<GeoPoint>(listPoint);
				
				int nwLat = -90 * 1000000;
			    int nwLng = 180 * 1000000;
			    int seLat = 90 * 1000000;
			    int seLng = -180 * 1000000;
			    
	    		for(int i=0;i<tempList.size();i++){
	    			nwLat = Math.max(nwLat, tempList.get(i).getLatitudeE6());
	    			nwLng = Math.min(nwLng, tempList.get(i).getLongitudeE6());
	    			seLat = Math.min(seLat, tempList.get(i).getLatitudeE6());
	    			seLng = Math.max(seLng, tempList.get(i).getLongitudeE6());
	    		}
	    		GeoPoint center = new GeoPoint((nwLat + seLat) / 2, (nwLng + seLng) / 2);
				mapView.getOverlays().add(new MyOverlay(mapView.getProjection(),tempList,cursor.getString(cursor.getColumnIndex("color")),cursor.getString(cursor.getColumnIndex("strokecolor"))));
				
				itemizedOverlay.addOverlay(new OverlayItem(center, "รายละเอียดแปลง",
						 cursor.getString(cursor.getColumnIndex("quotacode"))+"\n"+cursor.getString(cursor.getColumnIndex("plotdatecut"))+" "
						+cursor.getString(cursor.getColumnIndex("canetypename"))+"\n"+cursor.getString(cursor.getColumnIndex("locationmainname"))+" "
						+cursor.getString(cursor.getColumnIndex("locationname"))+"\n"+
						"ชื่อ-สกุลชาวไร่ "+cursor.getString(cursor.getColumnIndex("satffname"))));
				mapView.getOverlays().add(itemizedOverlay);
				listPoint.clear();
				stateID = cursor.getString(cursor.getColumnIndex("StateID"));
				rowAll++;
	    	}

			listPoint.add(new GeoPoint((int)(Double.parseDouble(cursor.getString(cursor.getColumnIndex("lat")))*1e6), (int)(Double.parseDouble(cursor.getString(cursor.getColumnIndex("lng")))*1e6)));
			loop++;
		}while(cursor.moveToNext());

		Toast.makeText( getApplicationContext(),"พบทั้งหมด "+rowAll+" แปลง",Toast.LENGTH_LONG).show();
	}
	
	public void onClickNewMAP(View view){
		Intent mapN = new Intent(getApplicationContext(), com.android.activity.MapActivity.class);
    	startActivity(mapN);
	}
	//Tagging
    public void potNowGis()throws Exception{
        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);
        Location location = locationManager.getLastKnownLocation(provider);
        if (location != null) {
          locationChanged(location);
        }
    }
    //Update Polygon in map
    public void drawsPolygonNearLocation()throws Exception{
        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);
        Location location = locationManager.getLastKnownLocation(provider);
        
        if (location != null) {
             locationManager.requestLocationUpdates( location.getProvider(), 5000, 0, mlocListener);
        }
    }
	public void onClickBtNowGIS(View view){
		//closeGIS();
		try{
			potNowGis();
		}catch(Exception ex){
			Toast.makeText( getApplicationContext(),"พบข้อผิดพลาด : ไม่สามารถเชื่อต่อ Webservice ได้",Toast.LENGTH_LONG).show();
			closeGIS();
		}
    }
	public void onClickMainMemu(View view){
		Intent mapN = new Intent(getApplicationContext(), com.android.activity.MainMenuActivity.class);
    	startActivity(mapN);
	}
    
	public void onClickStopGIS(View view){
		closeGIS();
    	Toast.makeText( getApplicationContext(),"หยุดการทำงาน  GIS",Toast.LENGTH_SHORT).show();
    }
    public void closeGIS(){
    	mlocListener.onProviderDisabled(null);
    	locationManager.removeUpdates(mlocListener);
    }
    public void locationChanged(int lat,int lng) {
        List<Overlay> mapOverlays = mapView.getOverlays();
        mapOverlays.clear();
        Drawable drawable = this.getResources().getDrawable(R.drawable.icon);
		itemizedOverlay = new CustomItemizedOverlay(drawable, this);
		
		final GeoPoint point = new GeoPoint(lat,lng);
		
		final MyLocationOverlay overlay = new MyLocationOverlay(this, mapView);
		
		overlay.enableMyLocation();
		overlay.enableCompass(); // does not work in emulator
		overlay.runOnFirstFix(new Runnable() {
			public void run() {
				// Zoom in to current location
				controller.animateTo(point);
			}
		});
		mapView.getOverlays().add(overlay);
      }
    public void locationChanged(Location location) {
        int lat = (int) (location.getLatitude()*1e6);
        int lng = (int) (location.getLongitude()*1e6);
        locationChanged(lat,lng);
        locationManager.requestLocationUpdates( location.getProvider(), 5000, 0, mlocListener);
    }
	
    @Override
	protected boolean isRouteDisplayed() {
		return false;
	}
    public class LocationListenerShowLocation extends MyLocationListener{
    	@Override
    	public void onLocationChanged(Location loc)

		{
			Log.i("intfo", "onLocationChanged");
			loc.getLatitude();
			loc.getLongitude();
//			if(res==null){
//				closeGIS();
//			}
		}
    }
	public class MyLocationListener implements LocationListener

	{
		public MyLocationListener() {
			Log.i(TAG, "MyLocationListener");
		}

		public void onLocationChanged(Location loc)

		{
			Log.i("intfo", "onLocationChanged");
			loc.getLatitude();

			loc.getLongitude();

			String Text = "คุณอยู่ที่ : " +

			"Latitud = " + loc.getLatitude() +

			"Longitud = " + loc.getLongitude();

			Toast.makeText(getApplicationContext(),

			Text,

			Toast.LENGTH_SHORT).show();
//			WebServices ws = new WebServices();
//			String res = ws.ws("abc", loc.getLatitude()+"", loc.getLongitude()+"", new Date().toString());
//			Toast.makeText(getApplicationContext(),
//
//					res,
//
//					Toast.LENGTH_SHORT).show();
//			if(res==null){
//				closeGIS();
//			}
//			if(res!=null){
//				locationChanged(loc);
//			}
		}

		public void onProviderDisabled(String provider)

		{
			Log.i("intfo", "onProviderDisabled");
			Toast.makeText(getApplicationContext(),

			"Gps Disabled",

			Toast.LENGTH_SHORT).show();

		}

		public void onProviderEnabled(String provider)

		{
			Log.i("intfo", "onProviderEnabled");
			Toast.makeText(getApplicationContext(),

			"Gps Enabled",

			Toast.LENGTH_SHORT).show();

		}

		public void onStatusChanged(String provider, int status, Bundle extras)

		{
			Log.i("intfo", "onStatusChanged");
		}
	}
	
	class MyOverlay extends Overlay{
		private Projection projection;
	    private List<GeoPoint> points;
	    private Path path;
	    private String color;
		public MyOverlay(){

	    }
		public MyOverlay(Projection projection,List<GeoPoint> points,String color,String stroke){
			this.projection = projection;
			this.points = points;
			this.color = color;
	    }

	    public void draw(Canvas canvas, MapView mapv, boolean shadow){
	        super.draw(canvas, mapv, shadow);	        
			if (shadow == false && points != null) {
				Point startPoint = null, endPoint = null;
				Path path = new Path();
				path.setFillType(Path.FillType.EVEN_ODD);

				// We are creating the path
				for (int i = 0; i < points.size(); i++) {
					GeoPoint gPointA = points.get(i);
					Point pointA = new Point();
					projection.toPixels(gPointA, pointA);
					if (i == 0) { // This is the start point
						startPoint = pointA;
						path.moveTo(pointA.x, pointA.y);
					} else {
						if (i == points.size() - 1)// This is the end point
							endPoint = pointA;
							path.lineTo(pointA.x, pointA.y);
					}
				}

//				Paint paint = new Paint();
//				paint.setARGB(100, 255, 0, 0);
//				paint.setAntiAlias(true);
////				paint.setStyle(Style.STROKE);
//				paint.setStrokeWidth(2);
//				
////				paint.setDither(true);
//				paint.setStyle(Paint.Style.FILL_AND_STROKE);
////				paint.setStrokeJoin(Paint.Join.ROUND);
////				paint.setStrokeCap(Paint.Cap.ROUND);
////				paint.setStrokeWidth(2);
				Paint paint = new Paint();
		        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		        paint.setStrokeWidth(2);
		        paint.setColor(0x186666ff);
		        paint.setARGB(100, 255, 0, 0);
		        int hex = Integer.parseInt(color.replaceFirst("^#",""), 16);
		        int r = (hex & 0xFF0000) >> 16;
		        int g = (hex & 0xFF00) >> 8;
		        int b = (hex & 0xFF);
		        paint.setARGB(r, g, b, 0);
		        //paint.setColor(customPolygon.getColor()); 
		        paint.setStyle(Paint.Style.FILL_AND_STROKE);
		        paint.setAntiAlias(true);

				
				if (true) {
					if (startPoint != null) {
						drawOval(canvas, paint, startPoint);
					}
					if (endPoint != null) {
						drawOval(canvas, paint, endPoint);
					}
				}
				if (!path.isEmpty())
					canvas.drawPath(path, paint);
			}
	    	
	    }
	    private void drawOval(Canvas canvas, Paint paint, Point point) {
	        Paint ovalPaint = new Paint(paint);
	        ovalPaint.setStyle(Paint.Style.FILL_AND_STROKE);
	        ovalPaint.setStrokeWidth(2);
	        int _radius = 0;
	        RectF oval = new RectF(point.x - _radius, point.y - _radius, point.x + _radius, point.y + _radius);
	        canvas.drawOval(oval, ovalPaint);              
	    }
	    public boolean onKeyDown(int keyCode,KeyEvent event,MapView mapView){
	    	Toast.makeText(getBaseContext(),"onKeyDown!!", 
                    Toast.LENGTH_SHORT).show();
	    	return false;
	    }

	    public boolean onTrackballEvent(MotionEvent event, MapView mapView){   
	    	Toast.makeText(getBaseContext(),"Click!!", 
	                    Toast.LENGTH_SHORT).show();                                
	        return false;
	    }
	}
}
