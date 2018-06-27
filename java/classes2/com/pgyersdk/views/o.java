package com.pgyersdk.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.TypedValue;
import android.widget.Button;

public class o
  extends Button
{
  private Context a;
  
  public o(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    int i = (int)TypedValue.applyDimension(1, 5.0F, paramContext.getResources().getDisplayMetrics());
    Object localObject = new float[8];
    localObject[0] = i;
    localObject[1] = i;
    localObject[2] = i;
    localObject[3] = i;
    localObject[4] = i;
    localObject[5] = i;
    localObject[6] = i;
    localObject[7] = i;
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape((float[])localObject, null, null));
    localShapeDrawable.getPaint().setColor(Color.parseColor("#f2f2f2"));
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    localObject = new ShapeDrawable(new RoundRectShape((float[])localObject, null, null));
    ((ShapeDrawable)localObject).getPaint().setColor(Color.parseColor("#e0e0e0"));
    ((ShapeDrawable)localObject).getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    setBackgroundDrawable(a(paramContext, localShapeDrawable, (Drawable)localObject, (Drawable)localObject, localShapeDrawable));
    setTextSize(16.0F);
  }
  
  public static StateListDrawable a(Context paramContext, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    paramContext = new StateListDrawable();
    paramContext.addState(new int[] { 16842919 }, paramDrawable2);
    paramContext.addState(new int[] { 16842908 }, paramDrawable3);
    paramContext.addState(new int[0], paramDrawable1);
    return paramContext;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/views/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */