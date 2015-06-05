package com.graphical.felipe.graphportion;

import android.util.Log;

public class AbstractCoords extends RealCoords
{
    float w = 0;
    float u = 0;

    public AbstractCoords(float x,float y,float w)
    {
        super(x,y);
        this.w = w;
        this.u = w/20;
    }

    public float getW()
    {
        return this.w;
    }

    public void setW(float w)
    {
        this.w = w;
    }

    public float convertAxisValueFromAbstractToReal(float value) throws Exception
    {
        if (value<-10 && value>10)
        {
            throw new Exception("The chart allows only values ranging -10 and +10");
        }
        return (value + 10)*this.u;
    }
}
