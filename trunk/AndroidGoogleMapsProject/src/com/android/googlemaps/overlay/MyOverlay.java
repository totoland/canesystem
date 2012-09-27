package com.android.googlemaps.overlay;

import java.util.ArrayList;

import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;

public class MyOverlay extends Overlay{
	private Projection projection;
    private ArrayList<GeoPoint> points;
	public MyOverlay(){

    }
	public MyOverlay(Projection projection,ArrayList<GeoPoint> points){
		this.projection = projection;
		this.points = points;
    }

    public void draw(Canvas canvas, MapView mapv, boolean shadow){
        super.draw(canvas, mapv, shadow);

//        Paint   mPaint = new Paint();
//        mPaint.setDither(true);
//        mPaint.setColor(Color.RED);
//        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
//        mPaint.setStrokeJoin(Paint.Join.ROUND);
//        mPaint.setStrokeCap(Paint.Cap.ROUND);
//        mPaint.setStrokeWidth(2);
//
//        GeoPoint gP1 = new GeoPoint((int)(17.5826171480205*1e6), (int)(100.113854738741*1e6));
//        GeoPoint gP2 = new GeoPoint((int)(17.5828366547534*1e6), (int)(100.114996244959*1e6));
//
//        Point p1 = new Point();
//        Point p2 = new Point();
//        Path path = new Path();
//
//        projection.toPixels(gP1, p1);
//        projection.toPixels(gP2, p2);
//
//        path.moveTo(p2.x, p2.y);
//        path.lineTo(p1.x,p1.y);
        
		if (shadow == false && points != null) {
			Point startPoint = null, endPoint = null;
			Path path = new Path();
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
			paint.setARGB(100, 255, 0, 0);
			paint.setAntiAlias(true);
//			paint.setStyle(Style.STROKE);
			paint.setStrokeWidth(2);
			
//			paint.setDither(true);
			paint.setStyle(Paint.Style.FILL_AND_STROKE);
//			paint.setStrokeJoin(Paint.Join.ROUND);
//			paint.setStrokeCap(Paint.Cap.ROUND);
//			paint.setStrokeWidth(2);

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
        int _radius = 6;
        RectF oval = new RectF(point.x - _radius, point.y - _radius, point.x + _radius, point.y + _radius);
        canvas.drawOval(oval, ovalPaint);              
    }
}