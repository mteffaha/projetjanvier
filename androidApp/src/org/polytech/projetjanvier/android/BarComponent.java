package org.polytech.projetjanvier.android;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.*;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by teffaha on 1/31/14.
 */
public class BarComponent extends View {
    private int currentValue=65;          // Current Value

    private int minValue = 25;
    private int maxValue = 75;

    public void setBarColor(int barColor) {
        this.barColor = barColor;
        paintBar.setColor(barColor);
    }

    private int barColor;

    private Typeface caviarDreams;
    private Context context;
    private Paint paintBar;
    private Paint paintGrey;
    private Paint paintText;
    private Paint paintWhite;

    private int margin= 10;



    // For Calculating the average
    private int sumValues = 245;      // the sum of all passed values
    private int countValues = 5;    // the count of all passed values

    private void init(AttributeSet attrs){

        barColor = Color.rgb(250, 105, 0);

        // Fetching the Color if specified
        if(attrs != null){
            TypedArray a = context.obtainStyledAttributes(attrs,
                    R.styleable.BarComponent);

            final int N = a.getIndexCount();
            for (int i = 0; i < N; ++i)
            {
                int attr = a.getIndex(i);
                switch (attr)
                {
                    case R.styleable.BarComponent_barColor:
                        barColor =a.getColor(attr,barColor);
                        break;
                }
            }
            a.recycle();
        }


        caviarDreams =  Typeface.createFromAsset(context.getAssets(),"fonts/CaviarDreams.ttf");

        paintBar = new Paint();
        paintBar.setColor(barColor);


        paintGrey= new Paint();
        paintGrey.setColor(Color.LTGRAY);

        paintWhite = new Paint();
        paintWhite.setColor(Color.WHITE);

        paintText = new Paint();
        paintText.setColor(Color.DKGRAY);
        paintText.setTextSize(40);
        paintText.setTypeface(caviarDreams);


    }

    public BarComponent(Context context) {
        super(context);
        this.context = context;
        init(null);

    }

    public BarComponent(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(attrs);
    }

    public BarComponent(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(attrs);
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
        invalidate();
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


        String title = ""+getCurrentValue(); // Creating the title

        // Getting the title size
        Rect bounds = new Rect();
        paintText.getTextBounds(title, 0, title.length(), bounds);
        canvas.drawText(title,0,bounds.height()+margin, paintText);

        int width = getWidth()-(2*margin); //  the width of the bar

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
