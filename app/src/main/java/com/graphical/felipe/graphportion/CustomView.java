package com.graphical.felipe.graphportion;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.util.Hashtable;
import android.widget.Toast;
import net.objecthunter.exp4j.*;


import java.util.Hashtable;

public class CustomView extends View
{

    private Paint paint = new Paint();
    private Hashtable<String,RealCoords> limitCoords = new Hashtable<String,RealCoords>();
    private String expression = "x";

    public CustomView(Context context)
    {
        super(context);
        Initialization(null,0);
    }

    public CustomView(Context context, AttributeSet attributes)
    {
        super(context,attributes);
        Initialization(attributes,0);
    }

    public CustomView(Context context, AttributeSet attributes, int defStyle)
    {
        super(context,attributes,defStyle);
        Initialization(attributes,defStyle);
    }

    private void Initialization(AttributeSet attributes, int defStyle)
    {
        this.paint.setColor(Color.RED);
    }

    public void setExpression(String expression)
    {
        this.expression = expression;
    }

    public String getExpression()
    {
        return this.expression;
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        this.DrawAxis(canvas);
        this.limitCoords = ToolBox.getLimitCoords(canvas);
        MappingCoordinates mappingCoordinates = new MappingCoordinates();
        mappingCoordinates.setExpression(this.expression);
        float xi = -10;
        while (xi<=10)
        {
            mappingCoordinates.yAxisSweeping(xi,canvas);
            xi += MappingCoordinates.aproxValue;
        }

    }

    private void DrawAxis(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(2);
        canvas.drawLine(0,canvas.getWidth()/2,canvas.getWidth(),canvas.getWidth()/2,paint);
        canvas.drawLine(canvas.getWidth()/2,0,canvas.getWidth()/2,canvas.getWidth(),paint);
    }
}
