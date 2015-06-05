package com.graphical.felipe.graphportion;

import android.graphics.Canvas;
import net.objecthunter.exp4j.*;
import android.util.Log;

import java.util.Random;



public class MappingCoordinates {

    public static final float aproxValue = 0.2F;
    public static final float delta= 0.05F;
    String expression = "x";

    public String getExpression()
    {
        return this.expression;
    }

    public void setExpression(String value)
    {
        this.expression = value;
    }

    public void yAxisSweeping(float x, Canvas canvas)
    {
        float yi = -10;
        while (yi>=-10 && yi<=10)
        {
            Expression e = new ExpressionBuilder(this.expression)
                    .variables("x")
                    .build()
                    .setVariable("x",x);
            double valueToCompare = e.evaluate();
            if (valueToCompare>=(yi-MappingCoordinates.delta) && valueToCompare<=(yi+MappingCoordinates.delta))
            {
                ToolBox.drawAPoint(canvas,x,yi*-1);
            }
            yi += MappingCoordinates.aproxValue;
        }
    }

    private boolean validateIfCoordinatesMeetCriteria(AbstractCoords point)
    {
        float y= Evaluate(point.getX());
        if (point.getY()==y)
        {
            return true;
        }
        return false;
    }

    private float Evaluate(float x)
    {
        return 0.1F;
    }

}
