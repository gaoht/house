package com.ziroom.ziroomcustomer.minsu.searchlist.b;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.searchlist.MinsuSearchListActivity;
import com.ziroom.ziroomcustomer.minsu.searchlist.base.b;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.StationSearchListBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.StationSearchListBean.DataBean.ListBean.LabelTipBean;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.widget.ZiroomFlowLayout;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class c
  extends RecyclerView.a<RecyclerView.u>
{
  private Context a;
  private List<StationSearchListBean.DataBean.ListBean> b;
  private b<StationSearchListBean.DataBean.ListBean> c;
  private int d;
  private int e;
  private int f;
  private boolean g = true;
  private b h = b.a;
  private int i = 0;
  
  public c(Context paramContext)
  {
    this.a = paramContext;
    this.d = n.dip2px(this.a, 10.0F);
    this.e = n.dip2px(this.a, 2.0F);
    this.f = n.dip2px(this.a, 4.0F);
  }
  
  private int a(int paramInt)
  {
    switch (3.a[this.h.ordinal()])
    {
    }
    return paramInt;
  }
  
  private TextView a(StationSearchListBean.DataBean.ListBean.LabelTipBean paramLabelTipBean)
  {
    TextView localTextView = new TextView(this.a);
    localTextView.setText(paramLabelTipBean.getName());
    localTextView.setBackgroundResource(2130839670);
    localTextView.setPadding(this.f, this.e, this.f, this.e);
    localTextView.setTextColor(Color.parseColor("#ff6262"));
    localTextView.setTextSize(8.0F);
    return localTextView;
  }
  
  public void addData(List<StationSearchListBean.DataBean.ListBean> paramList)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void addSearchItem(StationSearchListBean.DataBean.ListBean paramListBean)
  {
    this.b.add(paramListBean);
  }
  
  public void changeMoreStatus(int paramInt)
  {
    this.i = paramInt;
    notifyDataSetChanged();
  }
  
  public boolean getCanLoadMore()
  {
    return this.g;
  }
  
  public b getCurrentModel()
  {
    return this.h;
  }
  
  public List<StationSearchListBean.DataBean.ListBean> getData()
  {
    return this.b;
  }
  
  public int getItemCount()
  {
    if (this.b == null) {
      return 0;
    }
    if (this.h == b.b) {
      return this.b.size();
    }
    return this.b.size() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    int k = 0;
    int j = k;
    if (this.h == b.a)
    {
      j = k;
      if (paramInt + 1 == getItemCount()) {
        j = 1;
      }
    }
    return j;
  }
  
  public void onBindViewHolder(RecyclerView.u paramu, int paramInt)
  {
    if ((paramu instanceof c))
    {
      paramu = (c)paramu;
      localListBean = (StationSearchListBean.DataBean.ListBean)this.b.get(a(paramInt));
      com.freelxl.baselibrary.f.c.loadHolderImage(paramu.b, localListBean.getPicUrl());
      paramu.c.setText(localListBean.getProjectName());
      if (localListBean.getStatus() != 2) {
        if (localListBean.getMinPrice() == localListBean.getMaxPrice()) {
          paramu.d.setText("¥" + localListBean.getMinPrice() + "/晚");
        }
      }
      for (;;)
      {
        paramu.e.setText(localListBean.getCityName() + " | " + localListBean.getAreaName() + " | " + localListBean.getHouseModelCount() + "种房型");
        paramu.g.setText(localListBean.getEvaluateCount() + " 评价");
        paramu.f.setText(new BigDecimal(localListBean.getEvaluateScore()).setScale(1, 4).doubleValue() + " 分");
        paramu.i.setVisibility(8);
        paramu.h.setVisibility(8);
        paramu.k.setTag(localListBean);
        paramu.k.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = (StationSearchListBean.DataBean.ListBean)paramAnonymousView.getTag();
            if (c.a(c.this) != null) {
              c.a(c.this).onCollectClick(paramAnonymousView, true);
            }
          }
        });
        paramu.a.setTag(localListBean);
        paramu.a.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = (StationSearchListBean.DataBean.ListBean)paramAnonymousView.getTag();
            if (paramAnonymousView.getStatus() != 2)
            {
              if ((c.b(c.this) instanceof MinsuSearchListActivity))
              {
                Calendar localCalendar1 = ((MinsuSearchListActivity)c.b(c.this)).getDateStart();
                Calendar localCalendar2 = ((MinsuSearchListActivity)c.b(c.this)).getDateEnd();
                String str1 = ((MinsuSearchListActivity)c.b(c.this)).getStartDate();
                String str2 = ((MinsuSearchListActivity)c.b(c.this)).getEndDate();
                k.toStationProjectApp(c.b(c.this), paramAnonymousView.getProjectBid(), localCalendar1, localCalendar2, str1, str2);
                return;
              }
              k.toStationProjectApp(c.b(c.this), paramAnonymousView.getProjectBid(), null, null, null, null);
              return;
            }
            af.showToast(c.b(c.this), "敬请期待");
          }
        });
        paramu.j.removeAllViews();
        paramu.j.setMaxLine(1);
        if (localListBean.getLabelTipsList() == null) {
          break;
        }
        localIterator = localListBean.getLabelTipsList().iterator();
        while (localIterator.hasNext())
        {
          localLabelTipBean = (StationSearchListBean.DataBean.ListBean.LabelTipBean)localIterator.next();
          localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
          localLayoutParams.rightMargin = this.d;
          paramu.j.addView(a(localLabelTipBean), localLayoutParams);
        }
        paramu.d.setText("¥" + localListBean.getMinPrice() + "/晚-¥" + localListBean.getMaxPrice() + "/晚");
        continue;
        paramu.d.setText("即将开始");
      }
      switch (localListBean.getStatus())
      {
      default: 
        paramu.i.setVisibility(8);
        paramu.g.setVisibility(0);
        paramu.f.setVisibility(0);
        paramu.h.setVisibility(8);
        paramu.c.setTextColor(Color.parseColor("#444444"));
        paramu.d.setTextColor(Color.parseColor("#444444"));
      }
    }
    while (!(paramu instanceof a))
    {
      StationSearchListBean.DataBean.ListBean localListBean;
      Iterator localIterator;
      StationSearchListBean.DataBean.ListBean.LabelTipBean localLabelTipBean;
      LinearLayout.LayoutParams localLayoutParams;
      return;
      paramu.i.setVisibility(0);
      paramu.g.setVisibility(8);
      paramu.f.setVisibility(8);
      paramu.h.setVisibility(8);
      paramu.c.setTextColor(Color.parseColor("#444444"));
      paramu.d.setTextColor(Color.parseColor("#444444"));
      return;
      paramu.i.setVisibility(8);
      paramu.g.setVisibility(8);
      paramu.f.setVisibility(8);
      paramu.h.setVisibility(0);
      paramu.c.setTextColor(Color.parseColor("#999999"));
      paramu.d.setTextColor(Color.parseColor("#999999"));
      return;
    }
    paramu = (a)paramu;
    if (this.g)
    {
      switch (this.i)
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
  }
  
  public RecyclerView.u onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      return new c(LayoutInflater.from(this.a).inflate(2130904350, paramViewGroup, false));
    }
    if (paramInt == 1) {
      return new a(LayoutInflater.from(this.a).inflate(2130904347, paramViewGroup, false));
    }
    return null;
  }
  
  public void setCanLoadMore(boolean paramBoolean)
  {
    this.g = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void setData(List<StationSearchListBean.DataBean.ListBean> paramList, b paramb)
  {
    this.b = paramList;
    this.h = paramb;
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
  
  public static enum b
  {
    private b() {}
  }
  
  class c
    extends RecyclerView.u
  {
    View a;
    SimpleDraweeView b;
    TextView c;
    TextView d;
    TextView e;
    TextView f;
    TextView g;
    TextView h;
    TextView i;
    ZiroomFlowLayout j;
    ImageView k;
    
    public c(View paramView)
    {
      super();
      this.a = paramView;
      this.b = ((SimpleDraweeView)this.a.findViewById(2131695337));
      this.c = ((TextView)this.a.findViewById(2131689541));
      this.d = ((TextView)this.a.findViewById(2131689912));
      this.e = ((TextView)this.a.findViewById(2131689837));
      this.f = ((TextView)this.a.findViewById(2131695345));
      this.g = ((TextView)this.a.findViewById(2131695346));
      this.h = ((TextView)this.a.findViewById(2131695347));
      this.i = ((TextView)this.a.findViewById(2131695348));
      this.j = ((ZiroomFlowLayout)this.a.findViewById(2131695343));
      this.k = ((ImageView)this.a.findViewById(2131695342));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/searchlist/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */