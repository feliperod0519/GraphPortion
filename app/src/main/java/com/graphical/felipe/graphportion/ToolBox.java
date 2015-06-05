package com.graphical.felipe.graphportion;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import java.util.Hashtable;
import android.util.Log;

public class ToolBox
{
    public static final float delta= 5;

    public static void drawAPoint(Canvas canvas, float x, float y)
    {
        float radius = ToolBox.delta;
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        AbstractCoords p = new AbstractCoords(x,y,canvas.getWidth());
        float xReal = 0;
        try
        {
            Log.d("x",String.valueOf(p.getX()));
            xReal = p.convertAxisValueFromAbstractToReal(p.getX());
        }
        catch (Exception ex)
        {
            xReal=0;
        }
        float yReal = 0;
        try
        {
            Log.d("y",String.valueOf(p.getY()));
            yReal = p.convertAxisValueFromAbstractToReal(p.getY());
        }
        catch (Exception ex)
        {
            yReal=0;
        }
        canvas.drawCircle(xReal,yReal,radius,paint);
    }

    public static Hashtable getLimitCoords(Canvas canvas)
    {
        Hashtable<String,RealCoords> h = new Hashtable<String,RealCoords>();
        h.put("0,0",new RealCoords(0,0));
        h.put("MAX,0",new RealCoords(canvas.getWidth(),0));
        h.put("0,MAX",new RealCoords(0,canvas.getWidth()));
        h.put("MAX,MAX",new RealCoords(canvas.getWidth(),canvas.getWidth()));
        return h;
    }

    public static float getRealUnitSize(Canvas canvas)
    {
        return canvas.getWidth()/2;
    }
}
