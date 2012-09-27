package com.android.googlemaps.overlay;

import java.util.List;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import com.google.android.maps.Projection;

public class PolygonOverlay extends OverlayItem {
	private Projection projection;
    private List<GeoPoint> points;
    private Path path;
	
    public PolygonOverlay(GeoPoint point, String title, String snippet) {
		super(point, title, snippet);
	}
	public void setPolygonOverlay(Projection projection,List<GeoPoint> points){
		this.projection = projection;
		this.points = points;
    }
	public void draw(Canvas canvas, MapView mapv, boolean shadow){
        //draw(canvas, mapv, shadow);	        
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
			
			Paint paint = new Paint();
	        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
	        paint.setStrokeWidth(2);
	        paint.setColor(0x186666ff);
	        paint.setARGB(100, 255, 0, 0);
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

}
