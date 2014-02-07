package org.polytech.projetjanvier.android;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;
import org.polytech.projetjanvier.android.entities.Sensor;

/**
 * Created by teffaha on 1/29/14.
 */
public class SensorComponent extends View implements SensorUpdate {

    protected int strokeWidth = 25; // Width of element drawn (the circular bars), also determines the repartition/spacing of element
    protected int startDegree =  -90; // the start degree from which the circular bars will be drawn

    private Typeface caviarDreams; // the font used for writing information


    // Inforamtion relative to the sensor
    private int id = 0;
    private int rssi = 20;

    private int temperature = 60;
    private int soc = 90;
    private int maxTemperature = 100;
    private int minTemperature = 0;
    private int maxSoc = 100;
    private int minSoc = 0;


    private int getTemperatureDegree(){
        int percentage =((temperature-minTemperature)*100)/maxTemperature;
        return 360 * percentage/100;
    }

    private int getSocDegree(){
        int percentage =((soc-minSoc)*100)/maxSoc;
        return 360 * percentage/100;
    }


    public SensorComponent(Context context, AttributeSet attrs, int defStyle){
        super(context,attrs,defStyle);
        caviarDreams = Typeface.createFromAsset(context.getAssets(), "fonts/opensans.ttf");

    }
    public SensorComponent(Context context, AttributeSet attrs)
    {
        super(context,attrs);
        caviarDreams = Typeface.createFromAsset(context.getAssets(), "fonts/opensans.ttf");

    }
    public SensorComponent(Context context) {
        super(context);
        caviarDreams = Typeface.createFromAsset(context.getAssets(), "fonts/opensans.ttf");

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);

        int widthMeasure = MeasureSpec.getSize(widthMeasureSpec);
        int heightMeasure = MeasureSpec.getSize(heightMeasureSpec);

        int newWidth, newHeight;

        if (widthSpecMode == MeasureSpec.AT_MOST)
            newWidth = 300;
        else
            newWidth = widthMeasure;

        if (heightSpecMode == MeasureSpec.AT_MOST)
            newHeight = 300;
        else
            newHeight = heightMeasure;

        setMeasuredDimension(newWidth, newHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // Defining Colors
        int colorFoodPills = Color.rgb(250, 105, 0); // Temperature color
        int colorAoi = Color.rgb(105,210,231);       // Soc Color (State of Charge).
        int colorBeachStorm=Color.rgb(224,228,204);  // Border of the center region and color of the line


        // Defining Paints
        Paint paintEraser = new Paint();
        paintEraser.setMaskFilter(null);
        paintEraser.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));


        Paint paintTemperature = new Paint();
        paintTemperature.setColor(colorFoodPills);
        paintTemperature.setStyle(Paint.Style.STROKE);
        paintTemperature.setStrokeWidth(strokeWidth);

        Paint paintSoc = new Paint();
        paintSoc.setColor(colorAoi);
        paintSoc.setStyle(Paint.Style.STROKE);
        paintSoc.setStrokeWidth(strokeWidth);

        Paint paintBorder =  new Paint();
        paintBorder.setColor(colorBeachStorm);
        paintBorder.setStyle(Paint.Style.FILL);

        Paint paintMain = new Paint();
        paintMain.setColor(Color.rgb(44, 62, 80));
        paintMain.setStyle(Paint.Style.FILL);

        Paint paintWhite = new Paint();
        paintWhite.setTextSize((int) (1.1 * strokeWidth));
        paintWhite.setColor(Color.rgb(236, 240, 241));
        paintWhite.setTypeface(caviarDreams);

        Paint paintGrey = new Paint();
        paintGrey.setColor(Color.rgb(189, 195, 199));
        paintGrey.setTextSize(20);
        paintGrey.setTypeface(caviarDreams);


        Path arcPath = new Path();


        int step = strokeWidth; // the decrease in size
        canvas.drawArc(new RectF(step,step,getWidth()-(2*step),getHeight()-(2*step)),startDegree,getTemperatureDegree(),false,paintTemperature);
        //canvas.drawRect(new RectF(strokeWidth,strokeWidth,getWidth()-(2*strokeWidth),getHeight()-(2*strokeWidth)),paintTemperature);


        arcPath.addArc(new RectF(step,step,getWidth()-(2*step),getHeight()-(2*step)),startDegree,180);
        paintGrey.setColor(Color.WHITE);
        canvas.drawTextOnPath("TEMPERATURE",arcPath,10,10,paintGrey);

        int step2 = (2*strokeWidth);
        canvas.drawArc(new RectF(step2,step2,getWidth()-step - step2,getHeight()-step - step2),startDegree,getSocDegree(),false,paintSoc);

        arcPath.reset();
        arcPath.addArc(new RectF(step2,step2,getWidth()-step - step2,getHeight()-step - step2),startDegree,180);
        canvas.drawTextOnPath("ÉTAT DE CHARGE",arcPath,10,10,paintGrey);


        int ovalTop,ovalLeft;
        int ovalBottom,ovalRight;
        ovalLeft= ovalTop = 3*strokeWidth;
        ovalRight = getWidth() - step -  ovalTop;
        ovalBottom = getHeight()- step - ovalLeft;


        canvas.drawOval(new RectF(ovalLeft,ovalTop,ovalRight,ovalBottom),paintBorder);





        canvas.drawOval(new RectF(ovalLeft,ovalTop,ovalRight,ovalBottom),paintMain);

        paintBorder.setStyle(Paint.Style.STROKE);
        paintBorder.setStrokeWidth(4);

        // Drawing the middle line
        int startX,startY,endX,endY;

        startY = endY= (ovalBottom  + ovalTop)/2;
        startX = ovalLeft + strokeWidth;
        endX = ovalRight - strokeWidth;
        canvas.drawLine(startX,startY,endX,endY,paintBorder);


        // Writing information


        canvas.drawText("ID :"+this.id,startX+(strokeWidth/2),startY-(strokeWidth)-((paintWhite.descent() + paintWhite.ascent()) / 2),paintWhite);
        canvas.drawText("RSSI: "+this.rssi,startX+(int)(strokeWidth/2),startY+5+(strokeWidth)-((paintWhite.descent() + paintWhite.ascent()) / 2),paintWhite);

    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        if(temperature >maxTemperature || temperature < minTemperature){
            return;
        }
        this.temperature = temperature;
    }

    public int getSoc() {
        return soc;
    }

    public void setSoc(int soc) {
        if(soc > maxSoc || soc < minSoc){
            return;
        }
        this.soc = soc;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(int maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public int getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(int minTemperature) {
        this.minTemperature = minTemperature;
    }

    public int getMaxSoc() {
        return maxSoc;
    }

    public void setMaxSoc(int maxSoc) {
        this.maxSoc = maxSoc;
    }

    public int getMinSoc() {
        return minSoc;
    }

    public void setMinSoc(int minSoc) {
        this.minSoc = minSoc;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    @Override
    public void updateSensor(Sensor sensor) {
        this.id = sensor.getId();
        this.temperature = sensor.getTemperature();
        this.soc = sensor.getSoc();
        this.rssi =sensor.getRssi();
        invalidate();
    }
}
