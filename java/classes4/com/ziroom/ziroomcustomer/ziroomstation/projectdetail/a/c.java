package com.ziroom.ziroomcustomer.ziroomstation.projectdetail.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.StrategySearchListBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.List;

public class c
  extends RecyclerView.a<a>
{
  private List<StrategySearchListBean.DataBean.ListBean> a;
  private Context b;
  
  public c(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public int getItemCount()
  {
    int i = 3;
    if (this.a == null) {
      i = 0;
    }
    while (this.a.size() > 3) {
      return i;
    }
    return this.a.size();
  }
  
  public void onBindViewHolder(a parama, int paramInt)
  {
    StrategySearchListBean.DataBean.ListBean localListBean = (StrategySearchListBean.DataBean.ListBean)this.a.get(paramInt);
    com.freelxl.baselibrary.f.c.loadHolderImage(parama.c, localListBean.getBannerImg());
    parama.d.setText(localListBean.getCityName() + " · " + localListBean.getBusinessArea());
    parama.e.setText(localListBean.getTitle());
    parama.f.setText(localListBean.getSubCategory() + " | " + localListBean.getSubTitle());
    parama.a.setTag(localListBean);
    parama.a.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = (StrategySearchListBean.DataBean.ListBean)paramAnonymousView.getTag();
        JsBridgeWebActivity.start(c.a(c.this), "城市攻略", paramAnonymousView.getTargetUrl(), paramAnonymousView.getSubTitle(), paramAnonymousView.getBannerImg(), true);
      }
    });
    if (paramInt == 2)
    {
      parama.b.setVisibility(8);
      return;
    }
    parama.b.setVisibility(0);
  }
  
  public a onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new a(LayoutInflater.from(this.b).inflate(2130904559, paramViewGroup, false));
  }
  
  public void setData(List<StrategySearchListBean.DataBean.ListBean> paramList)
  {
    this.a = paramList;
    notifyDataSetChanged();
  }
  
  class a
    extends RecyclerView.u
  {
    View a;
    View b;
    SimpleDraweeView c;
    TextView d;
    TextView e;
    TextView f;
    
    public a(View paramView)
    {
      super();
      this.a = paramView;
      this.c = ((SimpleDraweeView)paramView.findViewById(2131695349));
      this.d = ((TextView)paramView.findViewById(2131690053));
      this.e = ((TextView)paramView.findViewById(2131689541));
      this.f = ((TextView)paramView.findViewById(2131690071));
      this.b = paramView.findViewById(2131691738);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/projectdetail/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */