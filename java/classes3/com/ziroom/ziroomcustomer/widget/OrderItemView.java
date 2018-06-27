package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.R.styleable;

public class OrderItemView
  extends RelativeLayout
{
  private Context a;
  private int b;
  private String c;
  private String d;
  private ImageView e;
  private TextView f;
  private TextView g;
  private TextView h;
  
  public OrderItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OrderItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public OrderItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a(paramAttributeSet);
    a();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.a).inflate(2130904644, this);
    this.e = ((ImageView)localView.findViewById(2131690097));
    this.f = ((TextView)localView.findViewById(2131689541));
    this.g = ((TextView)localView.findViewById(2131690073));
    this.h = ((TextView)localView.findViewById(2131692154));
    this.e.setImageResource(this.b);
    this.f.setText(this.c);
    this.g.setText(this.d);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = this.a.obtainStyledAttributes(paramAttributeSet, R.styleable.OrderItemView);
    this.b = paramAttributeSet.getResourceId(0, 2130838626);
    this.c = paramAttributeSet.getString(1);
    this.d = paramAttributeSet.getString(2);
    paramAttributeSet.recycle();
  }
  
  public void setDesc(String paramString)
  {
    this.d = paramString;
    this.g.setText(paramString);
  }
  
  public void setIcon(int paramInt)
  {
    this.b = paramInt;
    this.e.setImageResource(this.b);
  }
  
  public void setMessageCount(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.h.setVisibility(8);
      return;
    }
    this.h.setVisibility(0);
    this.h.setText(paramString);
  }
  
  public void setTitle(String paramString)
  {
    this.c = paramString;
    this.f.setText(paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/OrderItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */