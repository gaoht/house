package com.ziroom.ziroomcustomer.account.sortlistview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class SideBar
  extends View
{
  public static String[] a = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" };
  private a b;
  private int c = -1;
  private Paint d = new Paint();
  private TextView e;
  
  public SideBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public SideBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SideBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f = paramMotionEvent.getY();
    int j = this.c;
    paramMotionEvent = this.b;
    int k = (int)(f / getHeight() * a.length);
    switch (i)
    {
    default: 
      setBackgroundDrawable(new ColorDrawable(0));
      if ((j != k) && (k >= 0) && (k < a.length))
      {
        if (paramMotionEvent != null) {
          paramMotionEvent.onTouchingLetterChanged(a[k]);
        }
        if (this.e != null)
        {
          this.e.setText(a[k]);
          this.e.setVisibility(0);
        }
        this.c = k;
        invalidate();
      }
      break;
    }
    for (;;)
    {
      return true;
      setBackgroundDrawable(new ColorDrawable(0));
      this.c = -1;
      invalidate();
      if (this.e != null) {
        this.e.setVisibility(4);
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = getWidth();
    int k = i / a.length;
    i = 0;
    while (i < a.length)
    {
      this.d.setColor(Color.parseColor("#444444"));
      this.d.setTypeface(Typeface.DEFAULT_BOLD);
      this.d.setAntiAlias(true);
      this.d.setTextSize(20.0F);
      if (i == this.c)
      {
        this.d.setColor(Color.parseColor("#444444"));
        this.d.setFakeBoldText(true);
      }
      float f1 = j / 2;
      float f2 = this.d.measureText(a[i]) / 2.0F;
      float f3 = k * i + k;
      paramCanvas.drawText(a[i], f1 - f2, f3, this.d);
      this.d.reset();
      i += 1;
    }
  }
  
  public void setOnTouchingLetterChangedListener(a parama)
  {
    this.b = parama;
  }
  
  public void setTextView(TextView paramTextView)
  {
    this.e = paramTextView;
  }
  
  public static abstract interface a
  {
    public abstract void onTouchingLetterChanged(String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/sortlistview/SideBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */