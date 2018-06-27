package com.ziroom.ziroomcustomer.minsu.searchlist.b;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.StrategySearchListBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.ArrayList;
import java.util.List;

public class d
  extends RecyclerView.a<RecyclerView.u>
{
  private Context a;
  private List<StrategySearchListBean.DataBean.ListBean> b;
  private List<StrategySearchListBean.DataBean.ListBean> c;
  private boolean d = true;
  private c e = c.a;
  private int f = 0;
  
  public d(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public void addData(List<StrategySearchListBean.DataBean.ListBean> paramList)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void addSearchItem(StrategySearchListBean.DataBean.ListBean paramListBean)
  {
    this.b.add(paramListBean);
  }
  
  public void changeMoreStatus(int paramInt)
  {
    this.f = paramInt;
    notifyDataSetChanged();
  }
  
  public boolean getCanLoadMore()
  {
    return this.d;
  }
  
  public c getCurrentModel()
  {
    return this.e;
  }
  
  public List<StrategySearchListBean.DataBean.ListBean> getData()
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    return this.b;
  }
  
  public int getItemCount()
  {
    int j = 0;
    int i;
    if (this.b == null)
    {
      i = 0;
      if (this.c != null) {
        break label57;
      }
      label18:
      j = i + j;
      i = j;
      if (j != 0)
      {
        if (this.e != c.a) {
          break label70;
        }
        i = j + 1;
      }
    }
    label57:
    label70:
    do
    {
      do
      {
        return i;
        i = this.b.size();
        break;
        j = this.c.size();
        break label18;
        i = j;
      } while (this.b == null);
      i = j;
    } while (this.b.size() <= 0);
    return j;
  }
  
  public int getItemViewType(int paramInt)
  {
    int j = 0;
    int i;
    if (this.e == c.a)
    {
      i = j;
      if (paramInt + 1 == getItemCount()) {
        i = 1;
      }
    }
    do
    {
      do
      {
        do
        {
          return i;
          i = j;
        } while (this.b == null);
        i = j;
      } while (this.b.size() == 0);
      i = j;
    } while (paramInt != this.b.size());
    return 2;
  }
  
  public void onBindViewHolder(RecyclerView.u paramu, int paramInt)
  {
    int j = 0;
    int i;
    if ((paramu instanceof d))
    {
      d locald = (d)paramu;
      if (this.b == null)
      {
        i = 0;
        if (paramInt >= i) {
          break label181;
        }
        paramu = (StrategySearchListBean.DataBean.ListBean)this.b.get(paramInt);
        c.loadHolderImage(locald.b, paramu.getBannerImg());
        locald.c.setText(paramu.getCityName() + " · " + paramu.getBusinessArea());
        locald.d.setText(paramu.getTitle());
        locald.e.setText(paramu.getSubCategory() + " | " + paramu.getSubTitle());
        locald.a.setTag(paramu);
        locald.a.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = (StrategySearchListBean.DataBean.ListBean)paramAnonymousView.getTag();
            JsBridgeWebActivity.start(d.a(d.this), "城市攻略", paramAnonymousView.getTargetUrl(), paramAnonymousView.getSubTitle(), paramAnonymousView.getBannerImg(), true);
          }
        });
      }
    }
    label181:
    do
    {
      return;
      i = this.b.size();
      break;
      paramu = this.c;
      if (this.b == null) {}
      for (i = j;; i = this.b.size())
      {
        paramu = (StrategySearchListBean.DataBean.ListBean)paramu.get(paramInt - i);
        break;
      }
      if ((paramu instanceof a))
      {
        paramu = (a)paramu;
        if (this.d)
        {
          switch (this.f)
          {
          default: 
            return;
          case 0: 
            paramu.b.setText("上拉加载更多...");
            return;
          }
          paramu.b.setText("正在加载更多数据...");
          return;
        }
        paramu.b.setText("没有更多数据");
        return;
      }
    } while (!(paramu instanceof b));
    ((b)paramu).b.setText("更多精彩推荐");
  }
  
  public RecyclerView.u onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      return new d(LayoutInflater.from(this.a).inflate(2130904351, paramViewGroup, false));
    }
    if (paramInt == 1) {
      return new a(LayoutInflater.from(this.a).inflate(2130904347, paramViewGroup, false));
    }
    if (paramInt == 2) {
      return new b(LayoutInflater.from(this.a).inflate(2130904352, paramViewGroup, false));
    }
    return null;
  }
  
  public void setCanLoadMore(boolean paramBoolean)
  {
    this.d = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void setData(List<StrategySearchListBean.DataBean.ListBean> paramList, c paramc)
  {
    this.b = paramList;
    this.e = paramc;
    notifyDataSetChanged();
  }
  
  public void setSuggestData(List<StrategySearchListBean.DataBean.ListBean> paramList)
  {
    this.c = paramList;
    this.e = c.b;
    notifyDataSetChanged();
  }
  
  class a
    extends RecyclerView.u
  {
    View a;
    TextView b;
    
    public a(View paramView)
    {
      super();
      this.a = paramView;
      this.b = ((TextView)paramView.findViewById(2131695336));
    }
  }
  
  class b
    extends RecyclerView.u
  {
    View a;
    TextView b;
    
    public b(View paramView)
    {
      super();
      this.a = paramView;
      this.b = ((TextView)paramView.findViewById(2131691571));
    }
  }
  
  public static enum c
  {
    private c() {}
  }
  
  class d
    extends RecyclerView.u
  {
    View a;
    SimpleDraweeView b;
    TextView c;
    TextView d;
    TextView e;
    
    public d(View paramView)
    {
      super();
      this.a = paramView;
      this.b = ((SimpleDraweeView)paramView.findViewById(2131695349));
      this.c = ((TextView)paramView.findViewById(2131690053));
      this.d = ((TextView)paramView.findViewById(2131689541));
      this.e = ((TextView)paramView.findViewById(2131690071));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/searchlist/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */