package com.ziroom.ziroomcustomer.signed.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.f.f;
import com.ziroom.commonlibrary.widget.gridpasswordview.c;
import com.ziroom.ziroomcustomer.R.styleable;

public class TextLineView
  extends FrameLayout
{
  private TextView a;
  private View b;
  private boolean c = false;
  private String d;
  private int e = 0;
  private a f;
  private String g = "#ffa000";
  private String h = "#444444";
  
  public TextLineView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public TextLineView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TextLineView);
    this.c = localTypedArray.getBoolean(0, false);
    this.d = localTypedArray.getString(3);
    if (f.isNull(localTypedArray.getString(2)))
    {
      str = this.h;
      this.h = str;
      if (!f.isNull(localTypedArray.getString(1))) {
        break label148;
      }
    }
    label148:
    for (String str = this.g;; str = localTypedArray.getString(1))
    {
      this.g = str;
      int i = localTypedArray.getDimensionPixelSize(4, -1);
      if (i != -1) {
        this.e = c.px2sp(paramContext, i);
      }
      a(paramContext, paramAttributeSet);
      return;
      str = localTypedArray.getString(2);
      break;
    }
  }
  
  public TextLineView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TextLineView);
    this.c = localTypedArray.getBoolean(0, false);
    this.d = localTypedArray.getString(3);
    if (f.isNull(localTypedArray.getString(2)))
    {
      str = this.h;
      this.h = str;
      if (!f.isNull(localTypedArray.getString(1))) {
        break label149;
      }
    }
    label149:
    for (String str = this.g;; str = localTypedArray.getString(1))
    {
      this.g = str;
      paramInt = localTypedArray.getDimensionPixelSize(4, -1);
      if (paramInt != -1) {
        this.e = c.px2sp(paramContext, paramInt);
      }
      a(paramContext, paramAttributeSet);
      return;
      str = localTypedArray.getString(2);
      break;
    }
  }
  
  public TextLineView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TextLineView);
    this.c = localTypedArray.getBoolean(0, false);
    this.d = localTypedArray.getString(3);
    if (f.isNull(localTypedArray.getString(2)))
    {
      str = this.h;
      this.h = str;
      if (!f.isNull(localTypedArray.getString(1))) {
        break label151;
      }
    }
    label151:
    for (String str = this.g;; str = localTypedArray.getString(1))
    {
      this.g = str;
      paramInt1 = localTypedArray.getDimensionPixelSize(4, -1);
      if (paramInt1 != -1) {
        this.e = c.px2sp(paramContext, paramInt1);
      }
      a(paramContext, paramAttributeSet);
      return;
      str = localTypedArray.getString(2);
      break;
    }
  }
  
  private void a()
  {
    if (this.c)
    {
      this.a.setTextColor(Color.parseColor(this.g));
      this.b.setBackgroundColor(Color.parseColor(this.g));
      return;
    }
    this.a.setTextColor(Color.parseColor(this.h));
    this.b.setBackgroundColor(Color.parseColor("#00000000"));
  }
  
  private void setTextSize(float paramFloat)
  {
    this.a.setTextSize(2, paramFloat);
  }
  
  protected void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130905225, null);
    this.a = ((TextView)paramContext.findViewById(2131689529));
    this.b = paramContext.findViewById(2131697796);
    addView(paramContext);
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130905225, null);
    this.a = ((TextView)paramContext.findViewById(2131689529));
    this.b = paramContext.findViewById(2131697796);
    addView(paramContext);
    if (this.d != null) {
      this.a.setText(this.d);
    }
    this.a.setTextSize(this.e);
    a();
  }
  
  public String getColor()
  {
    return this.h;
  }
  
  public a getOnCheckShowListener()
  {
    return this.f;
  }
  
  public String getShowColor()
  {
    return this.g;
  }
  
  public TextView getText()
  {
    return this.a;
  }
  
  public boolean isShow()
  {
    return this.c;
  }
  
  public void setColor(String paramString)
  {
    this.h = paramString;
  }
  
  public void setOnCheckShowListener(a parama)
  {
    this.f = parama;
  }
  
  public void setShow(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.c = paramBoolean1;
    if ((this.c) && (paramBoolean2) && (this.f != null)) {
      this.f.onCheckShow(this);
    }
    a();
  }
  
  public void setShowColor(String paramString)
  {
    this.g = paramString;
  }
  
  public void setStr(String paramString)
  {
    this.d = paramString;
    if (paramString != null) {
      this.a.setText(paramString);
    }
  }
  
  public void setText(TextView paramTextView)
  {
    this.a = paramTextView;
  }
  
  public static abstract interface a
  {
    public abstract void onCheckShow(View paramView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/widget/TextLineView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */