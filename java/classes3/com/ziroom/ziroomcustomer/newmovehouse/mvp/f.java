package com.ziroom.ziroomcustomer.newmovehouse.mvp;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanDetail.UserOrderItemVOsBean;
import java.text.DecimalFormat;
import java.util.List;

public class f
  extends RecyclerView.a<g>
{
  private Context a;
  private List<MovingVanDetail.UserOrderItemVOsBean> b;
  private boolean c;
  private a d;
  
  public f(Context paramContext, List<MovingVanDetail.UserOrderItemVOsBean> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = this.c;
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
  
  public void onBindViewHolder(g paramg, final int paramInt)
  {
    MovingVanDetail.UserOrderItemVOsBean localUserOrderItemVOsBean = (MovingVanDetail.UserOrderItemVOsBean)this.b.get(paramInt);
    paramg.b.setText(localUserOrderItemVOsBean.getItemName());
    Object localObject = new DecimalFormat("######0.00");
    int i = localUserOrderItemVOsBean.getItemAmount();
    paramg.c.setText(((DecimalFormat)localObject).format(i / 100.0D) + "元");
    localObject = (RelativeLayout.LayoutParams)paramg.c.getLayoutParams();
    paramg.a.setOnClickListener(null);
    if ("优惠金额".equals(localUserOrderItemVOsBean.getItemName())) {
      if (i != 0)
      {
        paramg.c.setTextColor(this.a.getResources().getColor(2131624608));
        if (!this.c) {
          break label214;
        }
        paramg.d.setVisibility(0);
        ((RelativeLayout.LayoutParams)localObject).removeRule(11);
        ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131690724);
        paramg.a.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (f.a(f.this) != null) {
              f.a(f.this).onClick(paramInt);
            }
          }
        });
      }
    }
    for (;;)
    {
      paramg.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      paramg.c.setTextColor(this.a.getResources().getColor(2131624039));
      break;
      label214:
      paramg.d.setVisibility(8);
      ((RelativeLayout.LayoutParams)localObject).removeRule(0);
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      continue;
      paramg.d.setVisibility(8);
      ((RelativeLayout.LayoutParams)localObject).removeRule(0);
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      paramg.c.setTextColor(this.a.getResources().getColor(2131624039));
    }
  }
  
  public g onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new g(LayoutInflater.from(paramViewGroup.getContext()).inflate(2130904366, paramViewGroup, false));
  }
  
  public void setMoveFeeArrow(boolean paramBoolean)
  {
    this.c = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void setOnItemClickListener(a parama)
  {
    this.d = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onClick(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/mvp/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */