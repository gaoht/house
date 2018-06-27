package com.ziroom.ziroomcustomer.ziroomapartment.meetaapartdetail;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.LabelsVo;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.ziroomapartment.a.a;
import com.ziroom.ziroomcustomer.ziroomapartment.widget.ViewPagerIndicator2;
import java.util.ArrayList;

public class c
  extends Dialog
{
  public ViewPager a;
  View.OnClickListener b = new View.OnClickListener()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      switch (paramAnonymousView.getId())
      {
      default: 
        return;
      }
      c.this.dismiss();
    }
  };
  private ViewPagerIndicator2 c;
  private ImageView d;
  private Context e;
  
  protected c(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.e = paramContext;
  }
  
  private void a(Context paramContext, PagerAdapter paramPagerAdapter)
  {
    paramContext = View.inflate(this.e, 2130903813, null);
    setContentView(paramContext);
    this.a = ((ViewPager)paramContext.findViewById(2131693817));
    this.d = ((ImageView)paramContext.findViewById(2131693819));
    this.c = ((ViewPagerIndicator2)paramContext.findViewById(2131693818));
    this.a.setAdapter(paramPagerAdapter);
    this.a.setEnabled(true);
    this.a.setOffscreenPageLimit(2);
    paramContext = new a();
    this.a.setPageTransformer(true, paramContext);
    this.a.setPageMargin(-ah.dip2px(this.e, 34.0F));
    this.d.setOnClickListener(this.b);
    this.c.setViewPager(this.a, paramPagerAdapter.getCount());
  }
  
  private void a(Context paramContext, ArrayList<ProjectDetailForAppVo.LabelsVo> paramArrayList)
  {
    paramContext = View.inflate(this.e, 2130903813, null);
    setContentView(paramContext);
    this.a = ((ViewPager)paramContext.findViewById(2131693817));
    this.d = ((ImageView)paramContext.findViewById(2131693819));
    this.c = ((ViewPagerIndicator2)paramContext.findViewById(2131693818));
    paramContext = new f(this.e, paramArrayList);
    this.a.setAdapter(paramContext);
    this.a.setEnabled(true);
    this.a.setOffscreenPageLimit(2);
    paramContext = new a();
    this.a.setPageTransformer(true, paramContext);
    this.a.setPageMargin(-ah.dip2px(this.e, 34.0F));
    this.d.setOnClickListener(this.b);
    this.c.setViewPager(this.a, paramArrayList.size());
  }
  
  public void show(PagerAdapter paramPagerAdapter)
  {
    show();
    a(this.e, paramPagerAdapter);
  }
  
  public void show(ArrayList<ProjectDetailForAppVo.LabelsVo> paramArrayList)
  {
    show();
    a(this.e, paramArrayList);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/meetaapartdetail/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */