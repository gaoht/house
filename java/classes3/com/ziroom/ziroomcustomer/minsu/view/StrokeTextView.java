package com.ziroom.ziroomcustomer.minsu.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint.Style;
import android.graphics.Shader.TileMode;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.R.styleable;
import java.lang.reflect.Field;
import java.util.Arrays;

@SuppressLint({"AppCompatCustomView"})
public class StrokeTextView
  extends TextView
{
  private int[] a;
  private int b;
  private int c = -16777216;
  private LinearGradient d;
  private boolean e;
  private int f;
  private TextPaint g;
  private int h;
  
  public StrokeTextView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public StrokeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public StrokeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.g = getPaint();
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.StrokeTextView);
      this.c = paramContext.getColor(0, -16777216);
      this.b = paramContext.getDimensionPixelSize(1, 0);
      this.h = paramContext.getInt(2, 0);
      setStrokeColor(this.c);
      setStrokeWidth(this.b);
      setGradientOrientation(this.h);
      paramContext.recycle();
    }
  }
  
  private LinearGradient getGradient()
  {
    if (this.h == 0) {
      return new LinearGradient(0.0F, 0.0F, getWidth(), 0.0F, this.a, null, Shader.TileMode.CLAMP);
    }
    return new LinearGradient(0.0F, 0.0F, 0.0F, getHeight(), this.a, null, Shader.TileMode.CLAMP);
  }
  
  private void setColor(int paramInt)
  {
    try
    {
      Field localField = TextView.class.getDeclaredField("mCurTextColor");
      localField.setAccessible(true);
      localField.set(this, Integer.valueOf(paramInt));
      localField.setAccessible(false);
      this.g.setColor(paramInt);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.b > 0)
    {
      this.f = getCurrentTextColor();
      this.g.setStrokeWidth(this.b);
      this.g.setFakeBoldText(true);
      this.g.setShadowLayer(this.b, 0.0F, 0.0F, 0);
      this.g.setStyle(Paint.Style.FILL_AND_STROKE);
      setColor(this.c);
      this.g.setShader(null);
      super.onDraw(paramCanvas);
      if (this.e)
      {
        if (this.a != null) {
          this.d = getGradient();
        }
        this.e = false;
      }
      if (this.d != null)
      {
        this.g.setShader(this.d);
        this.g.setColor(-1);
      }
      for (;;)
      {
        this.g.setStrokeWidth(0.0F);
        this.g.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        super.onDraw(paramCanvas);
        return;
        setColor(this.f);
      }
    }
    super.onDraw(paramCanvas);
  }
  
  public void setGradientColor(int[] paramArrayOfInt)
  {
    if (!Arrays.equals(paramArrayOfInt, this.a))
    {
      this.a = paramArrayOfInt;
      this.e = true;
      invalidate();
    }
  }
  
  public void setGradientOrientation(int paramInt)
  {
    if (this.h != paramInt)
    {
      this.h = paramInt;
      this.e = true;
      invalidate();
    }
  }
  
  public void setStrokeColor(int paramInt)
  {
    if (this.c != paramInt)
    {
      this.c = paramInt;
      invalidate();
    }
  }
  
  public void setStrokeWidth(int paramInt)
  {
    this.b = paramInt;
    invalidate();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/StrokeTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */