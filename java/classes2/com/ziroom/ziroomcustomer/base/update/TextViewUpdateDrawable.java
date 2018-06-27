package com.ziroom.ziroomcustomer.base.update;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;

public class TextViewUpdateDrawable
  extends AppCompatTextView
{
  private int drawableBottomHeight;
  private int drawableBottomWidth;
  private int drawableLeftHeight;
  private int drawableLeftWidth;
  private int drawableRightHeight;
  private int drawableRightWidth;
  private int drawableTopHeight;
  private int drawableTopWidth;
  private boolean isAliganCenter = false;
  private boolean isDwMath_content = false;
  private int mHeight;
  private int mWidth;
  
  public TextViewUpdateDrawable(Context paramContext)
  {
    super(paramContext);
  }
  
  public TextViewUpdateDrawable(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TextViewUpdateDrawable(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramInt = dp2px(getContext(), 8);
    this.drawableLeftHeight = paramInt;
    this.drawableLeftWidth = paramInt;
  }
  
  public static int dp2px(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    float f = paramInt;
    return (int)(paramContext.density * f + 0.5D);
  }
  
  private void setDrawable(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 0;
    if (paramInt2 == 0) {
      paramInt2 = paramDrawable.getIntrinsicWidth();
    }
    int i;
    for (;;)
    {
      i = paramInt3;
      if (paramInt3 == 0) {
        i = paramDrawable.getIntrinsicHeight();
      }
      switch (paramInt1)
      {
      default: 
        paramInt1 = 0;
        paramInt3 = 0;
        i = 0;
        paramInt2 = j;
        paramDrawable.setBounds(i, paramInt3, paramInt1, paramInt2);
        return;
      }
    }
    if (this.isAliganCenter) {}
    for (paramInt1 = 0;; paramInt1 = -getLineCount() * getLineHeight() / 2 + getLineHeight() / 2)
    {
      paramInt3 = paramInt1;
      j = 0;
      i = paramInt1 + i;
      paramInt1 = paramInt2;
      paramInt2 = i;
      i = j;
      break;
    }
    if (this.isAliganCenter) {}
    for (paramInt1 = 0;; paramInt1 = -this.mWidth / 2 + paramInt2 / 2)
    {
      paramInt3 = 0;
      j = 0 + i;
      i = paramInt1;
      paramInt1 = paramInt2 + paramInt1;
      paramInt2 = j;
      break;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    Object localObject = getCompoundDrawables();
    Drawable localDrawable1 = localObject[0];
    Drawable localDrawable2 = localObject[1];
    Drawable localDrawable3 = localObject[2];
    localObject = localObject[3];
    if (localDrawable1 != null) {
      setDrawable(localDrawable1, 0, dp2px(getContext(), 3), dp2px(getContext(), 3));
    }
    if (localDrawable2 != null) {
      setDrawable(localDrawable2, 1, this.drawableTopWidth, this.drawableTopHeight);
    }
    if (localDrawable3 != null) {
      setDrawable(localDrawable3, 2, this.drawableRightWidth, this.drawableRightHeight);
    }
    if (localObject != null) {
      setDrawable((Drawable)localObject, 3, this.drawableBottomWidth, this.drawableBottomHeight);
    }
    setCompoundDrawables(localDrawable1, localDrawable2, localDrawable3, (Drawable)localObject);
  }
  
  public void setAliganCenter(boolean paramBoolean)
  {
    this.isAliganCenter = paramBoolean;
  }
  
  public void setDrawableBottomHeight(int paramInt)
  {
    this.drawableBottomHeight = paramInt;
  }
  
  public void setDrawableBottomWidth(int paramInt)
  {
    this.drawableBottomWidth = paramInt;
  }
  
  public void setDrawableLeftHeight(int paramInt)
  {
    this.drawableLeftHeight = paramInt;
  }
  
  public void setDrawableLeftWidth(int paramInt)
  {
    this.drawableLeftWidth = paramInt;
  }
  
  public void setDrawableRightHeight(int paramInt)
  {
    this.drawableRightHeight = paramInt;
  }
  
  public void setDrawableRightWidth(int paramInt)
  {
    this.drawableRightWidth = paramInt;
  }
  
  public void setDrawableTopHeight(int paramInt)
  {
    this.drawableTopHeight = paramInt;
  }
  
  public void setDrawableTopWidth(int paramInt)
  {
    this.drawableTopWidth = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/base/update/TextViewUpdateDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */