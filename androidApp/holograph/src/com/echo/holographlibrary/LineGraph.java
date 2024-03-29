/*
 * 	   Created by Daniel Nadeau
 * 	   daniel.nadeau01@gmail.com
 * 	   danielnadeau.blogspot.com
 * 
 * 	   Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package com.echo.holographlibrary;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Point;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class LineGraph extends View {
	
	private ArrayList<Line> lines = new ArrayList<Line>();
	Paint paint = new Paint();
	private float minY = 0, minX = 0;
	private float maxY = 0, maxX = 0;
	private double rangeYRatio = 0;
	private double rangeXRatio = 0;
	private boolean isMaxYUserSet = false;
	private int lineToFill = -1;
	private int indexSelected = -1;
	private OnPointClickedListener listener;
	private Bitmap fullImage;
	private boolean shouldUpdate = false;
	
	public LineGraph(Context context){
		super(context);
	}
	
	public LineGraph(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	public void setMinY(float minY){
		
	}
	
	public void removeAllLines(){
		while (lines.size() > 0){
			lines.remove(0);
		}
		shouldUpdate = true;
		postInvalidate();
	}
	
	public void addLine(Line line) {
		lines.add(line);
		shouldUpdate = true;
		postInvalidate();
	}
	public void addPointToLine(int lineIndex, double x, double y){
		addPointToLine(lineIndex, (float) x, (float) y);
	}
	public void addPointToLine(int lineIndex, float x, float y){
		LinePoint p = new LinePoint(x, y);

		addPointToLine(lineIndex, p);
	}
	
	public double getRangeYRatio(){
		return rangeYRatio;
	}
	
	public void setRangeYRatio(double rr){
		this.rangeYRatio = rr;
	}
	public double getRangeXRatio(){
		return rangeXRatio;
	}
	
	public void setRangeXRatio(double rr){
		this.rangeXRatio = rr;
	}
	public void addPointToLine(int lineIndex, LinePoint point){
		Line line = getLine(lineIndex);
		line.addPoint(point);
		lines.set(lineIndex, line);
		resetLimits();
		shouldUpdate = true;
		postInvalidate();
	}
	
	public void addPointsToLine(int lineIndex, LinePoint[] points){
		Line line = getLine(lineIndex);
		for(LinePoint point : points){
			line.addPoint(point);
		}
		lines.set(lineIndex, line);
		resetLimits();
		shouldUpdate = true;
		postInvalidate();
	}
	
	public void removeAllPointsAfter(int lineIndex, double x){
		removeAllPointsBetween(lineIndex, x, getMaxX());
	}
	public void removeAllPointsBefore(int lineIndex, double x){
		removeAllPointsBetween(lineIndex, getMinX(), x);
	}
	
	public void removeAllPointsBetween(int lineIndex, double startX, double finishX){
		Line line = getLine(lineIndex);
		LinePoint[] pts = new LinePoint[line.getPoints().size()];
		pts = line.getPoints().toArray(pts);
		for(LinePoint point : pts){
			if(point.getX() >= startX && point.getX() <= finishX)
				line.removePoint(point);
		}
		lines.set(lineIndex, line);
		resetLimits();
		shouldUpdate = true;
		postInvalidate();
	}
	public void removePointsFromLine(int lineIndex, LinePoint[] points){
		Line line = getLine(lineIndex);
		for(LinePoint point : points){
			line.removePoint(point);
		}
		lines.set(lineIndex, line);
		resetLimits();
		shouldUpdate = true;
		postInvalidate();
	}
	public void removePointFromLine(int lineIndex, float x, float y){
		LinePoint p = null;
		Line line = getLine(lineIndex);
		p = line.getPoint(x, y);
		removePointFromLine(lineIndex, p);
	}
	public void removePointFromLine(int lineIndex, LinePoint point){
		Line line = getLine(lineIndex);
		line.removePoint(point);
		lines.set(lineIndex, line);
		resetLimits();
		shouldUpdate = true;
		postInvalidate();
	}
	
	public void resetYLimits(){
		float range = getMaxY() - getMinY();
		setRangeY(getMinY()-range*getRangeYRatio(), getMaxY()+range*getRangeYRatio());
	}
	public void resetXLimits(){
		float range = getMaxX() - getMinX();
		setRangeY(getMinX()-range*getRangeXRatio(), getMaxX()+range*getRangeXRatio());
	}
	public void resetLimits() {
		resetYLimits();
		resetXLimits();
	}
	public ArrayList<Line> getLines() {
		return lines;
	}
	public void setLineToFill(int indexOfLine) {
		this.lineToFill = indexOfLine;
		shouldUpdate = true;
		postInvalidate();
	}
	public int getLineToFill(){
		return lineToFill;
	}
	public void setLines(ArrayList<Line> lines) {
		this.lines = lines;
	}
	public Line getLine(int index) {
		return lines.get(index);
	}
	public int getSize(){
		return lines.size();
	}
	
	public void setRangeY(float min, float max) {
		minY = min;
		maxY = max;
		isMaxYUserSet = true;
	}
	private void setRangeY(double min, double max){
		minY = (float)min;
		maxY = (float)max;
	}
	public void setRangeX(float min, float max) {
		minX = min;
		maxX = max;
	}
	private void setRangeX(double min, double max){
		minX = (float)min;
		maxX = (float)max;
	}
	public float getMaxY(){
		float max = lines.get(0).getPoint(0).getY();
		for (Line line : lines){
			for (LinePoint point : line.getPoints()){
				max = point.getY() > max ? point.getY() : max;
			}
		}
		maxY = max;
		return maxY;	
	}

	public float getMinY(){
		float min = lines.get(0).getPoint(0).getY();
		for (Line line : lines){
			for (LinePoint point : line.getPoints()){
				min = point.getY() < min ? point.getY() : min;
			}
		}
		minY = min;
		return minY;
	}
	public float getMinLimY(){
		return minY;
	}
	public float getMaxLimY(){
		return maxY;
	}
	public float getMinLimX(){
		return minX;
	}
	public float getMaxLimX(){
		return maxX;
	}
	public float getMaxX(){
		float max = lines.size() > 0 ? lines.get(0).getPoint(0).getX() : 0;
		for (Line line : lines){
			for (LinePoint point : line.getPoints()){
				max = point.getX() > max ? point.getX() : max;
			}
		}
		maxX = max;
		return maxX;
		
	}
	public float getMinX(){
		float min = lines.size() > 0 ? lines.get(0).getPoint(0).getX() : 0;
		for (Line line : lines){
			for (LinePoint point : line.getPoints()){
				min = point.getX() < min ? point.getX() : min;
			}
		}
		minX = min;
		return minX;
	}
	


	 
	public void onDraw(Canvas ca) {
		if (fullImage == null || shouldUpdate) {
			fullImage = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
			Canvas canvas = new Canvas(fullImage);
			
			paint.reset();
			Path path = new Path();

			float bottomPadding = 10, topPadding = 10;
			float sidePadding = 10;
			float usableHeight = getHeight() - bottomPadding - topPadding;
			float usableWidth = getWidth() - 2*sidePadding;

			float maxY = getMaxLimY();
			float minY = getMinLimY();
			float maxX = getMaxLimX();
			float minX = getMinLimX();

	        
			int lineCount = 0;
			for (Line line : lines){
				int count = 0;
				float firstXPixels = 0, lastXPixels = 0, newYPixels = 0;
				float lastYPixels = 0, newXPixels = 0;
				
				if (lineCount == lineToFill){
					paint.setColor(Color.BLACK);
					paint.setAlpha(30);
					paint.setStrokeWidth(2);
					for (int i = 10; i-getWidth() < getHeight(); i = i+20){
						canvas.drawLine(i, getHeight()-bottomPadding, 0, getHeight()-bottomPadding-i, paint);
					}
					
					paint.reset();
					
					paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
					for (LinePoint p : line.getPoints()){
						float yPercent = (p.getY()-minY)/(maxY - minY);
						float xPercent = (p.getX()-minX)/(maxX - minX);
						if (count == 0){
							lastXPixels = sidePadding + (xPercent*usableWidth);
							lastYPixels = getHeight() - bottomPadding - (usableHeight*yPercent);
							firstXPixels = lastXPixels;
							path.moveTo(lastXPixels, lastYPixels);
						} else {
							newXPixels = sidePadding + (xPercent*usableWidth);
							newYPixels = getHeight() - bottomPadding - (usableHeight*yPercent);
							path.lineTo(newXPixels, newYPixels);
							Path pa = new Path();
							pa.moveTo(lastXPixels, lastYPixels);
							pa.lineTo(newXPixels, newYPixels);
							pa.lineTo(newXPixels, 0);
							pa.lineTo(lastXPixels, 0);
							pa.close();
							canvas.drawPath(pa, paint);
							lastXPixels = newXPixels;
							lastYPixels = newYPixels;
						}
						count++;
					}
					
					path.reset();
					
					path.moveTo(0, getHeight()-bottomPadding);
					path.lineTo(sidePadding, getHeight()-bottomPadding);
					path.lineTo(sidePadding, 0);
					path.lineTo(0, 0);
					path.close();
					canvas.drawPath(path, paint);
					
					path.reset();
					
					path.moveTo(getWidth(), getHeight()-bottomPadding);
					path.lineTo(getWidth()-sidePadding, getHeight()-bottomPadding);
					path.lineTo(getWidth()-sidePadding, 0);
					path.lineTo(getWidth(), 0);
					path.close();
					
					canvas.drawPath(path, paint);
					
				}
				
				lineCount++;
			}
			
			paint.reset();
			
			paint.setColor(Color.BLACK);
			paint.setAlpha(50);
			paint.setAntiAlias(true);
			canvas.drawLine(sidePadding, getHeight() - bottomPadding, getWidth()-sidePadding, getHeight()-bottomPadding, paint);
			paint.setAlpha(255);
			
			for (Line line : lines){
				int count = 0;
				float lastXPixels = 0, newYPixels = 0;
				float lastYPixels = 0, newXPixels = 0;
				
				paint.setColor(line.getColor());
				paint.setStrokeWidth(6);
				
				for (LinePoint p : line.getPoints()){
					float yPercent = (p.getY()-minY)/(maxY - minY);
					float xPercent = (p.getX()-minX)/(maxX - minX);
					if (count == 0){
						lastXPixels = sidePadding + (xPercent*usableWidth);
						lastYPixels = getHeight() - bottomPadding - (usableHeight*yPercent);
					} else {
						newXPixels = sidePadding + (xPercent*usableWidth);
						newYPixels = getHeight() - bottomPadding - (usableHeight*yPercent);
						canvas.drawLine(lastXPixels, lastYPixels, newXPixels, newYPixels, paint);
						lastXPixels = newXPixels;
						lastYPixels = newYPixels;
					}
					count++;
				}
			}
			
			
			int pointCount = 0;
			
			for (Line line : lines){

				paint.setColor(line.getColor());
				paint.setStrokeWidth(6);
				paint.setStrokeCap(Paint.Cap.ROUND);
				
				if (line.isShowingPoints()){
					for (LinePoint p : line.getPoints()){
						float yPercent = (p.getY()-minY)/(maxY - minY);
						float xPercent = (p.getX()-minX)/(maxX - minX);
						float xPixels = sidePadding + (xPercent*usableWidth);
						float yPixels = getHeight() - bottomPadding - (usableHeight*yPercent);
						
						paint.setColor(Color.GRAY);
						canvas.drawCircle(xPixels, yPixels, 10, paint);
						paint.setColor(Color.WHITE);
						canvas.drawCircle(xPixels, yPixels, 5, paint);
						
						Path path2 = new Path();
						path2.addCircle(xPixels, yPixels, 30, Direction.CW);
						p.setPath(path2);
						p.setRegion(new Region((int)(xPixels-30), (int)(yPixels-30), (int)(xPixels+30), (int)(yPixels+30)));
						
						if (indexSelected == pointCount && listener != null){
							paint.setColor(Color.parseColor("#33B5E5"));
							paint.setAlpha(100);
							canvas.drawPath(p.getPath(), paint);
							paint.setAlpha(255);
						}
						
						pointCount++;
					}
				}
			}
			
			shouldUpdate = false;
		}
		
		ca.drawBitmap(fullImage, 0, 0, null);
		
		
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {

	    Point point = new Point();
	    point.x = (int) event.getX();
	    point.y = (int) event.getY();
	    
	    int count = 0;
	    int lineCount = 0;
	    int pointCount = 0;
	    
	    Region r = new Region();
	    for (Line line : lines){
	    	pointCount = 0;
	    	for (LinePoint p : line.getPoints()){
	    		
	    		if (p.getPath() != null && p.getRegion() != null){
	    			r.setPath(p.getPath(), p.getRegion());
			    	if (r.contains((int)point.x,(int) point.y) && event.getAction() == MotionEvent.ACTION_DOWN){
			    		indexSelected = count;
			    	} else if (event.getAction() == MotionEvent.ACTION_UP){
			    		if (r.contains((int)point.x,(int) point.y) && listener != null){
			    			listener.onClick(lineCount, pointCount);
			    		}
			    		indexSelected = -1;
			    	}
	    		}
		    	
		    	pointCount++;
			    count++;
	    	}
	    	lineCount++;
	    	
	    }
	    
	    if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_UP){
	    	shouldUpdate = true;
	    	postInvalidate();
	    }
	    
	    

	    return true;
	}
	
	public void setOnPointClickedListener(OnPointClickedListener listener) {
		this.listener = listener;
	}
	
	public interface OnPointClickedListener {
		abstract void onClick(int lineIndex, int pointIndex);
	}
}
