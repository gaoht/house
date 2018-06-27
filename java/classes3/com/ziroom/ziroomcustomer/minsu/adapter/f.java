package com.ziroom.ziroomcustomer.minsu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.testin.analysis.TestinApi;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.CityCardBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.CityCardBean.RegionListBean;
import com.ziroom.ziroomcustomer.minsu.f.d;
import com.ziroom.ziroomcustomer.minsu.view.b.e.a;
import java.util.List;

public class f
  extends RecyclerView.a<com.ziroom.ziroomcustomer.minsu.view.b.a.c>
{
  private List<MinsuHouseBean.DataBean.CityCardBean.RegionListBean> a;
  private e.a b;
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  
  public f(Context paramContext) {}
  
  public f(Context paramContext, MinsuHouseBean.DataBean.CityCardBean paramCityCardBean)
  {
    this.a = paramCityCardBean.regionList;
    this.f = paramCityCardBean.cityCode;
    this.c = TestinApi.getStringFlag("subtitle1", "");
    this.d = TestinApi.getStringFlag("subtitle2", "");
    this.e = TestinApi.getStringFlag("subtitle3", "");
  }
  
  protected int a(RecyclerView.u paramu)
  {
    return paramu.getAdapterPosition();
  }
  
  protected void a(View paramView) {}
  
  protected void a(final ViewGroup paramViewGroup, final com.ziroom.ziroomcustomer.minsu.view.b.a.c paramc, int paramInt)
  {
    if (!a(paramInt)) {
      return;
    }
    paramc.getConvertView().setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (f.a(f.this) != null)
        {
          int i = f.this.a(paramc);
          f.a(f.this).onItemClick(paramViewGroup, paramc, i);
        }
      }
    });
    paramc.getConvertView().setOnLongClickListener(new View.OnLongClickListener()
    {
      public boolean onLongClick(View paramAnonymousView)
      {
        if (f.a(f.this) != null)
        {
          int i = f.this.a(paramc);
          return f.a(f.this).onItemLongClick(paramViewGroup, paramc, i);
        }
        return false;
      }
    });
  }
  
  protected boolean a(int paramInt)
  {
    return true;
  }
  
  protected MinsuHouseBean.DataBean.CityCardBean.RegionListBean b(int paramInt)
  {
    if ((this.a != null) && (this.a.size() > paramInt)) {
      return (MinsuHouseBean.DataBean.CityCardBean.RegionListBean)this.a.get(paramInt);
    }
    return null;
  }
  
  public void convert(com.ziroom.ziroomcustomer.minsu.view.b.a.c paramc, MinsuHouseBean.DataBean.CityCardBean.RegionListBean paramRegionListBean, int paramInt)
  {
    if (this.f.equals("110100")) {
      if (paramInt == 0) {
        if (TextUtils.isEmpty(this.c)) {
          if (paramRegionListBean != null) {
            ((TextView)paramc.getView(2131694578)).setText(paramRegionListBean.regionBrief);
          }
        }
      }
    }
    for (;;)
    {
      if (paramRegionListBean != null)
      {
        ((SimpleDraweeView)paramc.getView(2131694577)).setHierarchy(d.getHierarchy(ApplicationEx.c));
        ((SimpleDraweeView)paramc.getView(2131694577)).setController(com.freelxl.baselibrary.f.c.frescoController(paramRegionListBean.picSrc));
        ((TextView)paramc.getView(2131689541)).setText(paramRegionListBean.regionName);
      }
      return;
      ((TextView)paramc.getView(2131694578)).setText(this.c);
      continue;
      if (paramInt == 1)
      {
        if (TextUtils.isEmpty(this.d))
        {
          if (paramRegionListBean != null) {
            ((TextView)paramc.getView(2131694578)).setText(paramRegionListBean.regionBrief);
          }
        }
        else {
          ((TextView)paramc.getView(2131694578)).setText(this.d);
        }
      }
      else if (paramInt == 2)
      {
        if (TextUtils.isEmpty(this.e))
        {
          if (paramRegionListBean != null) {
            ((TextView)paramc.getView(2131694578)).setText(paramRegionListBean.regionBrief);
          }
        }
        else {
          ((TextView)paramc.getView(2131694578)).setText(this.e);
        }
      }
      else
      {
        ((TextView)paramc.getView(2131694578)).setText(paramRegionListBean.regionBrief);
        continue;
        ((TextView)paramc.getView(2131694578)).setText(paramRegionListBean.regionBrief);
      }
    }
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
  
  public void onBindViewHolder(com.ziroom.ziroomcustomer.minsu.view.b.a.c paramc, int paramInt)
  {
    paramc.updatePosition(paramInt);
    convert(paramc, b(paramInt), paramInt);
  }
  
  public com.ziroom.ziroomcustomer.minsu.view.b.a.c onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    com.ziroom.ziroomcustomer.minsu.view.b.a.c localc = com.ziroom.ziroomcustomer.minsu.view.b.a.c.get(ApplicationEx.c, null, paramViewGroup, 2130904048, -1);
    a(localc.getConvertView());
    a(paramViewGroup, localc, paramInt);
    return localc;
  }
  
  public void setmOnItemClickListener(e.a parama)
  {
    this.b = parama;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/adapter/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */