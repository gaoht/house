package com.ziroom.ziroomcustomer.home;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.contract.ZiroomGuestActivity;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuMapActivity;
import java.util.List;

public class HomePageFragmentZYU
  extends HomePageFragment
  implements View.OnClickListener
{
  private ImageView A;
  private LinearLayout B;
  private View C;
  private com.ziroom.ziroomcustomer.home.view.b D;
  boolean t = true;
  private String u;
  private int v = 3;
  private TextView w;
  private Intent x;
  private Context y;
  private int z = 0;
  
  public HomePageFragmentZYU()
  {
    super(2130903199);
  }
  
  private void b(View paramView)
  {
    this.w = ((TextView)paramView.findViewById(2131690748));
    this.A = ((ImageView)paramView.findViewById(2131690751));
    this.B = ((LinearLayout)paramView.findViewById(2131690768));
    this.C = paramView.findViewById(2131690754);
  }
  
  private void f()
  {
    this.B.setOnClickListener(this);
    this.C.setOnClickListener(this);
  }
  
  private void g()
  {
    if (this.D != null) {
      this.D.loadData();
    }
  }
  
  protected void a(float paramFloat)
  {
    super.a(paramFloat);
    if (paramFloat <= 0.0F)
    {
      this.C.setVisibility(0);
      this.C.setAlpha(1.0F);
      this.C.setTranslationY(0.0F);
      return;
    }
    if (paramFloat >= 1.0F)
    {
      this.C.setVisibility(8);
      return;
    }
    if (paramFloat <= 0.85D)
    {
      this.C.setVisibility(0);
      paramFloat = paramFloat / 85.0F * 100.0F;
      this.C.setAlpha(1.0F - paramFloat * (paramFloat * paramFloat));
      return;
    }
    this.C.setVisibility(8);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (paramInt2 >= this.p * 3 / 4)
    {
      this.C.setTranslationY(0.0F);
      return;
    }
    this.C.setTranslationY(-paramInt2);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    this.y = getActivity();
    this.D = new com.ziroom.ziroomcustomer.home.view.b(paramView, getActivity());
    b(paramView);
    f();
  }
  
  protected void c()
  {
    this.o = false;
    super.c();
  }
  
  protected void e()
  {
    super.e();
    Intent localIntent = new Intent(this.y, ZryuMapActivity.class);
    if (com.ziroom.ziroomcustomer.base.b.getZryuCurrentCity() != null) {
      localIntent.putExtra("citycode", com.ziroom.ziroomcustomer.base.b.getZryuCurrentCity().getCode());
    }
    startActivity(localIntent);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690775: 
      this.x = new Intent(this.y, ZiroomGuestActivity.class);
      this.x.putExtra("ziru", "ziruke");
      startActivity(this.x);
      w.onEvent(this.y, "home_customer_more");
      return;
    }
    w.onEventToZiroomAndUmeng("zra_search");
    paramView = new Intent(this.y, ZryuMapActivity.class);
    if (com.ziroom.ziroomcustomer.base.b.getZryuCurrentCity() != null) {
      paramView.putExtra("citycode", com.ziroom.ziroomcustomer.base.b.getZryuCurrentCity().getCode());
    }
    startActivity(paramView);
  }
  
  public void onDestroy()
  {
    if (this.D != null) {
      this.D.detach();
    }
    this.D = null;
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    g();
  }
  
  public void setMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
    {
      ((ViewGroup.MarginLayoutParams)paramView.getLayoutParams()).setMargins(paramInt1, paramInt2, paramInt3, paramInt4);
      paramView.requestLayout();
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      if ((com.ziroom.ziroomcustomer.base.b.getCurrentCity() == null) || (!com.ziroom.ziroomcustomer.base.b.getZryuCityList().contains(com.ziroom.ziroomcustomer.base.b.getCurrentCity()))) {
        break label107;
      }
      com.ziroom.ziroomcustomer.base.b.changeZryuCity(com.ziroom.ziroomcustomer.base.b.getCurrentCity());
    }
    for (;;)
    {
      if ((this.u != null) && (com.ziroom.ziroomcustomer.base.b.getZryuCurrentCity() != null) && (!this.u.equals(com.ziroom.ziroomcustomer.base.b.getZryuCurrentCity().getCode()))) {
        this.t = true;
      }
      if (this.t)
      {
        g();
        w.onEventToZiroomAndUmeng("zra_home");
        if (com.ziroom.ziroomcustomer.base.b.getZryuCurrentCity() != null) {
          this.u = com.ziroom.ziroomcustomer.base.b.getZryuCurrentCity().getCode();
        }
        this.t = false;
      }
      return;
      label107:
      com.ziroom.ziroomcustomer.base.b.changeZryuCity("110000");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/HomePageFragmentZYU.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */