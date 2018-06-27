package com.pgyersdk.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.Shape;
import android.widget.Button;
import com.pgyersdk.i.c;

public class t
  extends Button
{
  private String a = "#f2f2f2";
  private String b = "#e0e0e0";
  private Context c;
  private ShapeDrawable d;
  private ShapeDrawable e;
  private Shape f;
  private Shape g;
  
  public t(Context paramContext)
  {
    super(paramContext);
    this.c = paramContext;
    setPadding(c.a(paramContext, 20.0F), 0, 0, 0);
    setBackground(3);
    setTextSize(16.0F);
    setPadding(0, 0, c.a(paramContext, 10.0F), 0);
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
  
  private void a(Context paramContext, Canvas paramCanvas, String paramString, int paramInt)
  {
    Paint localPaint = new Paint();
    Path localPath = new Path();
    localPath.moveTo(0.0F, getHeight() / 2);
    localPath.lineTo(c.a(paramContext, 10.0F), getHeight() / 2 - c.a(paramContext, 4.0F));
    localPath.lineTo(c.a(paramContext, 10.0F), getHeight() / 2 + c.a(paramContext, 4.0F));
    localPath.lineTo(0.0F, getHeight() / 2);
    localPath.close();
    localPaint.setColor(Color.parseColor(paramString));
    paramCanvas.drawPath(localPath, localPaint);
    paramCanvas.drawRoundRect(new RectF(c.a(paramContext, 10.0F), 0.0F, getWidth(), getHeight()), c.a(paramContext, 5.0F), c.a(paramContext, 5.0F), localPaint);
    paramString = new Paint();
    paramString.setAntiAlias(true);
    paramString.setStyle(Paint.Style.STROKE);
    paramString.setStrokeWidth(2.0F);
    paramString.setColor(-7829368);
    int i = c.a(paramContext, 5.0F);
    if (paramInt >= 1) {
      paramCanvas.drawArc(new RectF(c.a(paramContext, 8.0F), c.a(paramContext, 8.0F) + i, getHeight() - i * 2 - c.a(paramContext, 8.0F), getHeight() - i - c.a(paramContext, 8.0F)), -30.0F, 60.0F, false, paramString);
    }
    if (paramInt >= 2) {
      paramCanvas.drawArc(new RectF(c.a(paramContext, 4.0F), c.a(paramContext, 4.0F) + i, getHeight() - i * 2 - c.a(paramContext, 4.0F), getHeight() - i - c.a(paramContext, 4.0F)), -30.0F, 60.0F, false, paramString);
    }
    if (paramInt >= 3) {
      paramCanvas.drawArc(new RectF(0.0F, i, getHeight() - i * 2, getHeight() - i), -30.0F, 60.0F, false, paramString);
    }
  }
  
  private void setBackground(int paramInt)
  {
    this.f = new v(this, paramInt);
    this.d = new ShapeDrawable(this.f);
    this.d.getPaint().setColor(Color.parseColor(this.a));
    this.d.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    this.g = new w(this, paramInt);
    this.e = new ShapeDrawable(this.g);
    this.e.getPaint().setColor(Color.parseColor(this.b));
    this.e.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    setBackgroundDrawable(a(this.c, this.d, this.e, this.e, this.d));
  }
  
  public void a(int paramInt)
  {
    setBackground(paramInt);
    postInvalidate();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/views/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */