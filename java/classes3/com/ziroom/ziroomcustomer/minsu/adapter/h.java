package com.ziroom.ziroomcustomer.minsu.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuImReplyCommonBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuImReplyCommonBean.DataBean.ListMsgBean;
import com.ziroom.ziroomcustomer.minsu.view.b.a.c;
import com.ziroom.ziroomcustomer.minsu.view.b.e.a;
import java.util.List;

public class h
  extends RecyclerView.a<c>
{
  private List<MinsuImReplyCommonBean.DataBean.ListMsgBean> a;
  private e.a b;
  private Context c;
  
  public h(Context paramContext, MinsuImReplyCommonBean.DataBean paramDataBean)
  {
    this.c = paramContext;
    this.a = paramDataBean.listMsg;
  }
  
  protected int a(RecyclerView.u paramu)
  {
    return paramu.getAdapterPosition();
  }
  
  protected void a(View paramView) {}
  
  protected void a(final ViewGroup paramViewGroup, final c paramc, int paramInt)
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
        if (h.a(h.this) != null)
        {
          int i = h.this.a(paramc);
          h.a(h.this).onItemClick(paramViewGroup, paramc, i);
        }
      }
    });
    paramc.getConvertView().setOnLongClickListener(new View.OnLongClickListener()
    {
      public boolean onLongClick(View paramAnonymousView)
      {
        if (h.a(h.this) != null)
        {
          int i = h.this.a(paramc);
          return h.a(h.this).onItemLongClick(paramViewGroup, paramc, i);
        }
        return false;
      }
    });
  }
  
  protected boolean a(int paramInt)
  {
    return true;
  }
  
  protected MinsuImReplyCommonBean.DataBean.ListMsgBean b(int paramInt)
  {
    if ((this.a != null) && (this.a.size() > paramInt)) {
      return (MinsuImReplyCommonBean.DataBean.ListMsgBean)this.a.get(paramInt);
    }
    return null;
  }
  
  public void convert(c paramc, MinsuImReplyCommonBean.DataBean.ListMsgBean paramListMsgBean)
  {
    if (paramListMsgBean != null)
    {
      paramc.setText(2131694579, paramListMsgBean.content);
      paramc.setTextColor(2131694579, this.c.getResources().getColor(2131624081));
      paramc.getView(2131694579).setTag(2131689523, paramListMsgBean);
      return;
    }
    paramc.setText(2131694579, this.c.getString(2131297064));
    paramc.setTextColor(2131694579, this.c.getResources().getColor(2131624475));
    paramc.getView(2131694579).setTag(2131689523, Integer.valueOf(0));
  }
  
  public int getItemCount()
  {
    if (this.a != null) {
      return this.a.size() + 1;
    }
    return 1;
  }
  
  public void onBindViewHolder(c paramc, int paramInt)
  {
    paramc.updatePosition(paramInt);
    convert(paramc, b(paramInt));
  }
  
  public c onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    c localc = c.get(ApplicationEx.c, null, paramViewGroup, 2130904049, -1);
    a(localc.getConvertView());
    a(paramViewGroup, localc, paramInt);
    return localc;
  }
  
  public void setData(List<MinsuImReplyCommonBean.DataBean.ListMsgBean> paramList)
  {
    this.a = paramList;
    notifyDataSetChanged();
  }
  
  public void setmOnItemClickListener(e.a parama)
  {
    this.b = parama;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/adapter/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */