package com.ziroom.ziroomcustomer.ziroomapartment.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.ziroom.ziroomcustomer.util.x;
import com.ziroom.ziroomcustomer.ziroomapartment.model.HomePageBeanZRY.ZiroomerBean.ZiroomerlistBean;

public class ZryuHomePageZiroomerView
  extends RelativeLayout
{
  private Context a;
  private SimpleDraweeView b;
  private TextView c;
  private TextView d;
  private float e;
  private final int f = 180;
  private final int g = 120;
  
  public ZryuHomePageZiroomerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ZryuHomePageZiroomerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ZryuHomePageZiroomerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    this.e = this.a.getResources().getDisplayMetrics().density;
    a();
  }
  
  private void a()
  {
    d();
    c();
    b();
  }
  
  private void b()
  {
    this.d = new TextView(this.a);
    this.d.setTextSize(2, 12.0F);
    this.d.setTextColor(this.a.getResources().getColor(2131624417));
    this.d.setMaxLines(3);
    this.d.setEllipsize(TextUtils.TruncateAt.END);
    this.c.measure(0, 0);
    int i = this.c.getHeight();
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = ((int)(192.0F * this.e));
    localLayoutParams.topMargin = (i + (int)(44.0F * this.e));
    this.d.setLayoutParams(localLayoutParams);
    addView(this.d);
  }
  
  private void c()
  {
    this.c = new TextView(this.a);
    this.c.setTextSize(2, 16.0F);
    this.c.setTextColor(this.a.getResources().getColor(2131624416));
    this.c.setMaxLines(2);
    this.c.setEllipsize(TextUtils.TruncateAt.END);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = ((int)(192.0F * this.e));
    this.c.setLayoutParams(localLayoutParams);
    addView(this.c);
  }
  
  private void d()
  {
    this.b = new SimpleDraweeView(this.a);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(180.0F * this.e), (int)(120.0F * this.e));
    this.b.setLayoutParams(localLayoutParams);
    addView(this.b);
  }
  
  public void setContent(HomePageBeanZRY.ZiroomerBean.ZiroomerlistBean paramZiroomerlistBean)
  {
    String str = x.makeUrl(paramZiroomerlistBean.getPic(), 0.5F);
    this.b.setController(c.frescoController(str));
    this.c.setText(paramZiroomerlistBean.getTitle());
    this.d.setText(paramZiroomerlistBean.getSubtitle());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/widget/ZryuHomePageZiroomerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */