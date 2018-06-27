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
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.d;
import com.ziroom.ziroomcustomer.minsu.view.b.e.a;
import java.util.List;

public class n
  extends RecyclerView.a<com.ziroom.ziroomcustomer.minsu.view.b.a.c>
{
  private List<MinsuHouseBean.DataBean.ListBean> a;
  private e.a b;
  private String c;
  private String d;
  
  public n(Context paramContext) {}
  
  public n(Context paramContext, MinsuHouseBean.DataBean paramDataBean, String paramString1, String paramString2)
  {
    this.a = paramDataBean.list;
    this.c = paramString1;
    this.d = paramString2;
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
        if (n.a(n.this) != null)
        {
          int i = n.this.a(paramc);
          n.a(n.this).onItemClick(paramViewGroup, paramc, i);
        }
      }
    });
    paramc.getConvertView().setOnLongClickListener(new View.OnLongClickListener()
    {
      public boolean onLongClick(View paramAnonymousView)
      {
        if (n.a(n.this) != null)
        {
          int i = n.this.a(paramc);
          return n.a(n.this).onItemLongClick(paramViewGroup, paramc, i);
        }
        return false;
      }
    });
  }
  
  protected boolean a(int paramInt)
  {
    return true;
  }
  
  protected MinsuHouseBean.DataBean.ListBean b(int paramInt)
  {
    if ((this.a != null) && (this.a.size() > paramInt)) {
      return (MinsuHouseBean.DataBean.ListBean)this.a.get(paramInt);
    }
    return null;
  }
  
  public void convert(com.ziroom.ziroomcustomer.minsu.view.b.a.c paramc, MinsuHouseBean.DataBean.ListBean paramListBean)
  {
    if (paramListBean != null)
    {
      String str = ApplicationEx.c.getString(2131297451);
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(2131694516);
      localStringBuffer.append(str);
      localStringBuffer.append("|");
      localStringBuffer.append(str);
      localStringBuffer.append(paramListBean.rentWayName);
      ((SimpleDraweeView)paramc.getView(2131694577)).setHierarchy(d.getHierarchy(ApplicationEx.c));
      ((SimpleDraweeView)paramc.getView(2131694577)).setController(com.freelxl.baselibrary.f.c.frescoController(paramListBean.picUrl));
      ((TextView)paramc.getView(2131694581)).setText(paramListBean.houseName);
      ((TextView)paramc.getView(2131694582)).setText("¥" + ad.getPriceInt(paramListBean.price));
      ((TextView)paramc.getView(2131694584)).setText(paramListBean.rentWayName);
      ((TextView)paramc.getView(2131694586)).setText(paramListBean.cityName);
      if ((paramListBean.isAvailable == 0) || (TextUtils.isEmpty(this.c)) || (TextUtils.isEmpty(this.d))) {
        paramc.getView(2131694587).setVisibility(8);
      }
    }
    else
    {
      return;
    }
    paramc.getView(2131694587).setVisibility(0);
    ((TextView)paramc.getView(2131694587)).setText(this.c + " - " + this.d + "可预订");
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
  
  public void onBindViewHolder(com.ziroom.ziroomcustomer.minsu.view.b.a.c paramc, int paramInt)
  {
    paramc.updatePosition(paramInt);
    convert(paramc, b(paramInt));
  }
  
  public com.ziroom.ziroomcustomer.minsu.view.b.a.c onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    com.ziroom.ziroomcustomer.minsu.view.b.a.c localc = com.ziroom.ziroomcustomer.minsu.view.b.a.c.get(ApplicationEx.c, null, paramViewGroup, 2130904051, -1);
    a(localc.getConvertView());
    a(paramViewGroup, localc, paramInt);
    return localc;
  }
  
  public void setmOnItemClickListener(e.a parama)
  {
    this.b = parama;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/adapter/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */