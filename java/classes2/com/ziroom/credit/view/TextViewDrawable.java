package com.ziroom.credit.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;

public class TextViewDrawable
  extends AppCompatTextView
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private boolean i = true;
  private boolean j = false;
  private int k;
  private int l;
  
  public TextViewDrawable(Context paramContext)
  {
    super(paramContext);
  }
  
  public TextViewDrawable(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TextViewDrawable(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3)
  {
    int m;
    if (paramInt2 == 0)
    {
      paramInt2 = paramDrawable.getIntrinsicWidth();
      m = paramInt3;
      if (paramInt3 == 0) {
        m = paramDrawable.getIntrinsicHeight();
      }
      switch (paramInt1)
      {
      default: 
        paramInt1 = 0;
        paramInt2 = 0;
        paramInt3 = 0;
      }
    }
    for (;;)
    {
      paramDrawable.setBounds(0, paramInt3, paramInt2, paramInt1);
      return;
      break;
      if (this.i) {}
      for (paramInt1 = 0;; paramInt1 = -getLineCount() * getLineHeight() / 2 + getLineHeight() / 2)
      {
        paramInt3 = paramInt1;
        paramInt1 += m;
        break;
      }
      paramInt3 = dp2px(getContext(), 15);
      paramInt2 = 0 + paramInt3;
      paramInt1 = this.l / 2 - dp2px(getContext(), 4);
      paramInt3 = paramInt1 - paramInt3;
    }
  }
  
  public static int dp2px(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    float f1 = paramInt;
    return (int)(paramContext.density * f1 + 0.5D);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Object localObject = getCompoundDrawables();
    paramCanvas = localObject[0];
    Drawable localDrawable1 = localObject[1];
    Drawable localDrawable2 = localObject[2];
    localObject = localObject[3];
    if (paramCanvas != null) {
      a(paramCanvas, 0, dp2px(getContext(), 10), dp2px(getContext(), 10));
    }
    if (localDrawable1 != null) {
      a(localDrawable1, 1, this.b, this.f);
    }
    if (localDrawable2 != null) {
      a(localDrawable2, 2, this.c, this.g);
    }
    if (localObject != null) {
      a((Drawable)localObject, 3, this.d, this.h);
    }
    setCompoundDrawables(paramCanvas, localDrawable1, localDrawable2, (Drawable)localObject);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.k = paramInt1;
    this.l = paramInt2;
    Object localObject = getCompoundDrawables();
    Drawable localDrawable1 = localObject[0];
    Drawable localDrawable2 = localObject[1];
    Drawable localDrawable3 = localObject[2];
    localObject = localObject[3];
    if (localDrawable1 != null) {
      a(localDrawable1, 0, dp2px(getContext(), 10), dp2px(getContext(), 10));
    }
    if (localDrawable2 != null) {
      a(localDrawable2, 1, this.b, this.f);
    }
    if (localDrawable3 != null) {
      a(localDrawable3, 2, this.c, this.g);
    }
    if (localObject != null) {
      a((Drawable)localObject, 3, this.d, this.h);
    }
    setCompoundDrawables(localDrawable1, localDrawable2, localDrawable3, (Drawable)localObject);
  }
  
  public void setAliganCenter(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setDrawableBottomHeight(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setDrawableBottomWidth(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setDrawableLeftHeight(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setDrawableLeftWidth(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setDrawableRightHeight(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setDrawableRightWidth(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setDrawableTopHeight(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setDrawableTopWidth(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/view/TextViewDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */