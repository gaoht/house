package com.ziroom.ziroomcustomer.my.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.my.model.OIOpenModel.TypeListBean;

public class InvoiceTextView
  extends TextView
{
  OIOpenModel.TypeListBean a;
  int b;
  
  public InvoiceTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public InvoiceTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public InvoiceTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int getCurTag()
  {
    return this.b;
  }
  
  public OIOpenModel.TypeListBean getTagBean()
  {
    return this.a;
  }
  
  public void setTag(int paramInt)
  {
    this.b = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      setTextAppearance(getContext(), 2131427928);
      setBackgroundResource(2130837835);
      return;
    case 2: 
      setTextAppearance(getContext(), 2131427926);
      setBackgroundResource(2130837834);
      return;
    }
    setTextAppearance(getContext(), 2131427927);
    setBackgroundResource(2130837836);
  }
  
  public void setTagBean(OIOpenModel.TypeListBean paramTypeListBean)
  {
    this.a = paramTypeListBean;
    setText(paramTypeListBean.name);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/widget/InvoiceTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */