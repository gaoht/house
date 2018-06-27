package com.pgyersdk.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import com.pgyersdk.i.c;

public class p
  extends LinearLayout
{
  private Context a;
  private Paint b;
  
  public p(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.a = paramContext;
    this.b = new Paint();
    setBottomBarColor(paramInt);
  }
  
  public static StateListDrawable a(Context paramContext, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    paramContext = new StateListDrawable();
    paramContext.addState(new int[] { 16842919, 16842910 }, paramDrawable2);
    paramContext.addState(new int[] { 16842910, 16842908 }, paramDrawable3);
    paramContext.addState(new int[] { 16842910 }, paramDrawable1);
    paramContext.addState(new int[] { 16842908 }, paramDrawable3);
    paramContext.addState(new int[] { 16842909 }, paramDrawable4);
    paramContext.addState(new int[0], paramDrawable1);
    return paramContext;
  }
  
  private void a(Context paramContext, Canvas paramCanvas)
  {
    Path localPath = new Path();
    localPath.moveTo(0.0F, 0.0F);
    localPath.lineTo(getWidth(), 0.0F);
    localPath.lineTo(getWidth(), getHeight() - c.a(this.a, 5.0F));
    localPath.lineTo(0.0F, getHeight() - c.a(this.a, 5.0F));
    paramCanvas.drawPath(localPath, this.b);
    int i = paramContext.getResources().getDisplayMetrics().widthPixels / 6 - c.a(paramContext, 10.0F);
    paramContext = new Path();
    paramContext.moveTo(i, getHeight() - c.a(this.a, 5.0F));
    paramContext.lineTo(c.a(this.a, 5.0F) + i, getHeight());
    paramContext.lineTo(c.a(this.a, 10.0F) + i, getHeight() - c.a(this.a, 5.0F));
    paramContext.lineTo(i, getHeight() - c.a(this.a, 5.0F));
    paramCanvas.drawPath(paramContext, this.b);
  }
  
  public void setBottomBarColor(int paramInt)
  {
    this.b.setColor(paramInt);
    this.b.setStyle(Paint.Style.FILL);
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new u(this));
    localShapeDrawable.getPaint().setColor(paramInt);
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    setBackgroundDrawable(a(this.a, localShapeDrawable, localShapeDrawable, localShapeDrawable, localShapeDrawable));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/views/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */