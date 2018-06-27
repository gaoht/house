package com.ziroom.credit.main;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.alibaba.fastjson.e;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.a.a;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.credit.R.id;
import com.ziroom.credit.R.layout;
import com.ziroom.credit.base.CreditBaseActivity;
import com.ziroom.router.activityrouter.Routers;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CreditEquityActivity
  extends CreditBaseActivity
  implements c.b
{
  private ListView d;
  private LinearLayout e;
  private a f;
  private List<e> g = new LinkedList();
  
  protected int c()
  {
    return R.layout.credit_activity_equity;
  }
  
  protected void d()
  {
    setTitleText("信用权益");
    this.d = ((ListView)findViewById(R.id.credit_list));
    this.e = ((LinearLayout)findViewById(R.id.credit_ll_empont));
  }
  
  protected c.a e()
  {
    return new d(this);
  }
  
  public void getEquities(com.alibaba.fastjson.b paramb)
  {
    this.g.clear();
    paramb = paramb.iterator();
    while (paramb.hasNext())
    {
      Object localObject = paramb.next();
      this.g.add((e)localObject);
    }
    if (this.g.size() == 0) {
      this.e.setVisibility(0);
    }
    for (;;)
    {
      this.f.setDatas(this.g);
      this.f.notifyDataSetChanged();
      return;
      this.e.setVisibility(8);
    }
  }
  
  public Context getViewContext()
  {
    return this;
  }
  
  protected void initData()
  {
    this.f = new a(this, this.g, R.layout.credit_item_equity)
    {
      public void convert(com.freelxl.baselibrary.a.b paramAnonymousb, final e paramAnonymouse)
      {
        SimpleDraweeView localSimpleDraweeView = (SimpleDraweeView)paramAnonymousb.getView(R.id.credit_img);
        localSimpleDraweeView.setHierarchy(new GenericDraweeHierarchyBuilder(CreditEquityActivity.this.getResources()).setFadeDuration(300).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_XY).build());
        localSimpleDraweeView.setController(c.frescoController(paramAnonymouse.get("logoUrl").toString()));
        paramAnonymousb.setText(R.id.credit_tv_label, paramAnonymouse.get("title").toString());
        paramAnonymousb.setText(R.id.credit_tv_desc, paramAnonymouse.get("des").toString());
        paramAnonymousb.setOnClickListener(R.id.credit_tv_get, new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymous2View)
          {
            VdsAgent.onClick(this, paramAnonymous2View);
            Routers.open(CreditEquityActivity.this, "ziroomCustomer://zrRentModule/h5WJFunction?url=" + paramAnonymouse.get("url").toString() + "&title=" + paramAnonymouse.get("title").toString());
          }
        });
        paramAnonymousb.setOnClickListener(R.id.credit_img, new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymous2View)
          {
            VdsAgent.onClick(this, paramAnonymous2View);
            Routers.open(CreditEquityActivity.this, "ziroomCustomer://zrRentModule/h5WJFunction?url=" + paramAnonymouse.get("url").toString() + "&title=" + paramAnonymouse.get("title").toString());
          }
        });
      }
    };
    this.d.setAdapter(this.f);
  }
  
  public boolean isActive()
  {
    return !isFinishing();
  }
  
  public void setPresenter(c.a parama)
  {
    this.a = parama;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/CreditEquityActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */