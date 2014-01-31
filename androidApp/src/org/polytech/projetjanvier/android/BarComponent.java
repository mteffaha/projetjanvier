package org.polytech.projetjanvier.android;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by teffaha on 1/31/14.
 */
public class BarComponent extends View {
    private int currentValue=65;          // Current Value

    private int minValue = 25;
    private int maxValue = 75;

    private int barColor;
    private int textColor;

    private Typeface caviarDreams;
    private Context context;
    private Paint paintBar;
    private Paint paintGrey;
    private Paint paintWhite;

    private int margin= 10;



    // For Calculating the average
    private int sumValues = 245;      // the sum of all passed values
    private int countValues = 5;    // the count of all passed values

    private void init(){

        barColor = Color.rgb(250, 105, 0);
        caviarDreams =  Typeface.createFromAsset(context.getAssets(),"fonts/CaviarDreams.ttf");

        paintBar = new Paint();
        paintBar.setColor(barColor);
        paintBar.setTextSize(40);
        paintBar.setTypeface(caviarDreams);


        paintGrey= new Paint();
        paintGrey.setColor(Color.LTGRAY);

        paintWhite = new Paint();
        paintWhite.setColor(Color.WHITE);

    }

    public BarComponent(Context context) {
        super(context);
        this.context = context;
        init();

    }

    public BarComponent(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public BarComponent(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }


    private int getAverageValue(){
        if(countValues > 0){
            return sumValues/countValues;
        }else{
            return (maxValue-minValue)/2;
        }
    }
    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
        if(currentValue<=minValue){
            minValue = currentValue;
        }
        if(currentValue >= maxValue){
            maxValue = currentValue;
        }
        sumValues+=currentValue;
        countValues++;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);

        int widthMeasure = MeasureSpec.getSize(widthMeasureSpec);
        int heightMeasure = MeasureSpec.getSize(heightMeasureSpec);

        int newWidth, newHeight;

        if (widthSpecMode == MeasureSpec.AT_MOST)
            newWidth = 400;
        else
            newWidth = widthMeasure;

        if (heightSpecMode == MeasureSpec.AT_MOST)
            newHeight = 45;
        else
            newHeight = heightMeasure;

        setMeasuredDimension(newWidth, newHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {


        String title = ""+getAverageValue(); // Creating the title

        // Getting the title size
        Rect bounds = new Rect();
        paintBar.getTextBounds(title, 0, title.length(), bounds);
        canvas.drawText(title,0,bounds.height()+margin, paintBar);

        int width = getWidth()-(bounds.width()+margin); //  the width of the bar

        // Drawing the bar background
        width-=margin;
        canvas.drawRect(bounds.width() + margin, margin, width, getHeight() - (margin / 2), paintGrey);

        // Calculating the width of the rectangle representing the value
        int totalGap = maxValue - minValue;
        int percentage = currentValue - minValue;
        percentage = percentage * 100/totalGap;
        int startAverage = getAverageValue()-minValue;
        startAverage = startAverage *100/totalGap;

        int widthValue = width*percentage/100; // the width the rectangle representing the value
        startAverage = width*startAverage/100;
        //Drawing the rectangle representing the value
        canvas.drawRect(bounds.width() + margin, margin, widthValue, getHeight() - (margin / 2), paintBar);
        // Drawing an indicator for the average value
        canvas.drawRect(bounds.width() + margin+startAverage,margin,bounds.width() +(2*margin)+startAverage, getHeight() -(margin / 2), paintWhite);


    }
}
