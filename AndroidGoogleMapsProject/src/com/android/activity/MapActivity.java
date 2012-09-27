package com.android.activity;

import java.util.ArrayList;
import java.util.List;

import com.android.activity.R;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;

public class MapActivity extends com.google.android.maps.MapActivity {

	LocationManager locman;
	LocationListener loclis;
	Location Location;
	private MapView map;
	
	List<GeoPoint> geoPointsArray = new ArrayList<GeoPoint>();
	private MapController controller;
	String provider = LocationManager.NETWORK_PROVIDER;
	double lat;
	double lon;
	
	public static String TAG = "MapActivity";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		initMapView();
		initMyLocation();
		locman = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//		locman.requestLocationUpdates(provider,60000, 100,loclis);
//		Location = locman.getLastKnownLocation(provider);
		Criteria criteria = new Criteria();
        provider = locman.getBestProvider(criteria, false);
        loclis = new MyLocationListener();
        Location = locman.getLastKnownLocation(provider);
        if(Location!=null){
        	locman.requestLocationUpdates(Location.getProvider(),10000, 100,loclis);
        }
	}

	/** Find and initialize the map view. */
	private void initMapView() {
		map = (MapView) findViewById(R.id.map_view2);
		controller = map.getController();
		map.setSatellite(false);
		map.setBuiltInZoomControls(true);
	}

	/** Find Current Position on Map. */
	private void initMyLocation() {
		final MyLocationOverlay overlay = new MyLocationOverlay(this, map);
		overlay.enableMyLocation();
		overlay.enableCompass(); // does not work in emulator
		overlay.runOnFirstFix(new Runnable() {
			public void run() {
				// Zoom in to current location
				controller.setZoom(24);
				controller.animateTo(overlay.getMyLocation());
			}
		});
		map.getOverlays().add(overlay);
	}

	public void onLocationChanged(Location location) {
		if (Location != null) {
			lat = Location.getLatitude();
			lon = Location.getLongitude();
			GeoPoint New_geopoint = new GeoPoint((int) (lat * 1e6),
					(int) (lon * 1e6));
			controller.animateTo(New_geopoint);
			geoPointsArray.add(New_geopoint);

			String Text = "คุณอยู่ที่ : " +

			"Latitud = " + Location.getLatitude() +

			"Longitud = " + Location.getLongitude();

			Toast.makeText(getApplicationContext(),

			Text,

			Toast.LENGTH_SHORT).show();
		}

	}
	
	public void locationChanged(Location location) {
        locman.requestLocationUpdates( location.getProvider(), 5000, 0, loclis);
    }
	
	public double getDistance(double lat1, double lon1, double lat2, double lon2) {
		double latA = Math.toRadians(lat1);
		double lonA = Math.toRadians(lon1);
		double latB = Math.toRadians(lat2);
		double lonB = Math.toRadians(lon2);
		double cosAng = (Math.cos(latA) * Math.cos(latB) * Math
				.cos(lonB - lonA)) + (Math.sin(latA) * Math.sin(latB));
		double ang = Math.acos(cosAng);
		double dist = ang * 6371;
		return dist;
	}

	class MyOverlay extends Overlay {
		public MyOverlay() {
		}

		public void draw(Canvas canvas, MapView mapv, boolean shadow) {
			super.draw(canvas, mapv, shadow);

			Projection projection = map.getProjection();
			Path p = new Path();
			for (int i = 0; i < geoPointsArray.size(); i++) {
				if (i == geoPointsArray.size() - 1) {
					break;
				}
				Point from = new Point();
				Point to = new Point();
				projection.toPixels(geoPointsArray.get(i), from);
				projection.toPixels(geoPointsArray.get(i + 1), to);
				p.moveTo(from.x, from.y);
				p.lineTo(to.x, to.y);
			}
			Paint mPaint = new Paint();
			mPaint.setStyle(Style.STROKE);
			mPaint.setColor(0xFFFF0000);
			mPaint.setAntiAlias(true);
			canvas.drawLine(0, 4, 5, 50, mPaint);
			canvas.drawPath(p, mPaint);
			super.draw(canvas, map, shadow);
		}
	}

	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub

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
			
			locationChanged(loc);
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
}
