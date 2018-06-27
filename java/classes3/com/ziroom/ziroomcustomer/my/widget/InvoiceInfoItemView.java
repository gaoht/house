package com.ziroom.ziroomcustomer.my.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class InvoiceInfoItemView
  extends LinearLayout
{
  private Context a;
  private TextView b;
  private TextView c;
  
  public InvoiceInfoItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InvoiceInfoItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InvoiceInfoItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    setOrientation(0);
    LayoutInflater.from(this.a).inflate(2130904263, this);
    this.b = ((TextView)findViewById(2131689541));
    this.c = ((TextView)findViewById(2131690084));
  }
  
  public void setText(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
    {
      setVisibility(8);
      return;
    }
    this.b.setText(paramString1);
    this.c.setText(paramString2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/widget/InvoiceInfoItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */