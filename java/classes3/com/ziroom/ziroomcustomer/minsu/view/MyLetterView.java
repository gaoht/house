package com.ziroom.ziroomcustomer.minsu.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.f.ab;

public class MyLetterView
  extends View
{
  private Paint a;
  private boolean b = false;
  private a c;
  private int d = -1;
  private TextView e;
  private String[] f;
  
  public MyLetterView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MyLetterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MyLetterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    this.a = new Paint();
    this.a.setAntiAlias(true);
    this.a.setTextSize(ab.dp2px(ApplicationEx.c, 12.0F));
    this.a.setColor(Color.parseColor("#444444"));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.f == null) || (this.f.length <= 0)) {}
    for (;;)
    {
      return;
      if (this.b) {
        paramCanvas.drawColor(Color.parseColor("#40000000"));
      }
      float f1 = getHeight() / this.f.length;
      int j = getWidth();
      int i = 0;
      while (i < this.f.length)
      {
        String str = this.f[i];
        paramCanvas.drawText(str, j / 2 - this.a.measureText(str) / 2.0F, i * f1 + f1, this.a);
        i += 1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    int k = ab.dp2px(ApplicationEx.c, 220.0F);
    if ((i == Integer.MIN_VALUE) && (j == Integer.MIN_VALUE)) {
      setMeasuredDimension(k, k);
    }
    do
    {
      return;
      if (i == Integer.MIN_VALUE)
      {
        setMeasuredDimension(k, paramInt2);
        return;
      }
    } while (j != Integer.MIN_VALUE);
    setMeasuredDimension(paramInt1, k);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j = (int)(paramMotionEvent.getY() / getHeight() * this.f.length);
    int k = this.d;
    switch (i)
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        do
        {
          return true;
          this.b = true;
        } while ((k == j) || (this.c == null));
        if ((j > 0) && (j < this.f.length))
        {
          this.c.sliding(this.f[j]);
          this.d = j;
          if (this.e != null)
          {
            this.e.setVisibility(0);
            this.e.setText(this.f[j]);
          }
        }
        invalidate();
        return true;
        this.b = true;
      } while ((k == j) || (this.c == null));
      if ((j >= 0) && (j < this.f.length))
      {
        this.c.sliding(this.f[j]);
        this.d = j;
        if (this.e != null)
        {
          this.e.setVisibility(0);
          this.e.setText(this.f[j]);
        }
      }
      invalidate();
      return true;
    }
    this.b = false;
    this.d = -1;
    if (this.e != null) {
      this.e.setVisibility(8);
    }
    invalidate();
    return true;
  }
  
  public void setLetter(String[] paramArrayOfString)
  {
    this.f = paramArrayOfString;
    a();
  }
  
  public void setOnSlidingListener(a parama)
  {
    this.c = parama;
  }
  
  public void setTextView(TextView paramTextView)
  {
    this.e = paramTextView;
  }
  
  public static abstract interface a
  {
    public abstract void sliding(String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/MyLetterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */