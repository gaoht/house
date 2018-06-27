package com.ziroom.ziroomcustomer.my.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuSignedActivity;
import com.ziroom.ziroomcustomer.my.model.SortIndexBean;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.ziroomstation.OrderDetailActivity;
import java.util.List;

public class MyTravelListMoreAdapter
  extends RecyclerView.a
{
  List<SortIndexBean> a;
  a b;
  private Context c;
  
  public int getItemCount()
  {
    return this.a.size();
  }
  
  public void onBindViewHolder(RecyclerView.u paramu, final int paramInt)
  {
    final SortIndexBean localSortIndexBean = (SortIndexBean)this.a.get(paramInt);
    ((MyTravelViewHolder)paramu).travel_tv_address.setText(localSortIndexBean.getHouseAddress());
    String str = localSortIndexBean.getArriveTime();
    if (!TextUtils.isEmpty(str)) {
      str = str.replace("-", "/");
    }
    for (;;)
    {
      ((MyTravelViewHolder)paramu).travel_tv_arriveTime.setText(str);
      str = localSortIndexBean.getLeaveTime();
      if (!TextUtils.isEmpty(str))
      {
        str = str.replace("-", "/");
        ((MyTravelViewHolder)paramu).travel_tv_leaveTime.setText(str);
      }
      ((MyTravelViewHolder)paramu).travel_tv_name.setText(localSortIndexBean.getHouseName());
      if (localSortIndexBean.getOrderType() == 1)
      {
        str = "<b>自如民宿 · </b> ";
        ((MyTravelViewHolder)paramu).travel_tv_contract.setText("联系房东");
      }
      for (;;)
      {
        ((MyTravelViewHolder)paramu).travel_tv_name.setText(Html.fromHtml(str + localSortIndexBean.getHouseName()));
        ((MyTravelViewHolder)paramu).travel_tv_contract.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            MyTravelListMoreAdapter.this.b.onClick(paramInt, localSortIndexBean);
          }
        });
        paramu.itemView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            int i = localSortIndexBean.getOrderType();
            if (i == 1)
            {
              paramAnonymousView = new Intent(MyTravelListMoreAdapter.a(MyTravelListMoreAdapter.this), MinsuSignedActivity.class);
              paramAnonymousView.putExtra("fid", localSortIndexBean.getFid());
              paramAnonymousView.putExtra("rentWay", localSortIndexBean.getRentWay());
              paramAnonymousView.putExtra("orderSn", localSortIndexBean.getOrderSn());
              MyTravelListMoreAdapter.a(MyTravelListMoreAdapter.this).startActivity(paramAnonymousView);
              w.onEvent("PersonalCenter_tellandlord");
            }
            while (i != 2) {
              return;
            }
            paramAnonymousView = new Intent(MyTravelListMoreAdapter.a(MyTravelListMoreAdapter.this), OrderDetailActivity.class);
            paramAnonymousView.putExtra("orderBid", localSortIndexBean.getFid());
            MyTravelListMoreAdapter.a(MyTravelListMoreAdapter.this).startActivity(paramAnonymousView);
            w.onEvent("PersonalCenter_telbutler");
          }
        });
        return;
        str = "<b>自如驿 · </b>";
        ((MyTravelViewHolder)paramu).travel_tv_contract.setText("联系管家");
      }
    }
  }
  
  public RecyclerView.u onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    this.c = paramViewGroup.getContext();
    return new MyTravelViewHolder(LayoutInflater.from(this.c).inflate(2130904396, paramViewGroup, false));
  }
  
  public void setList(List<SortIndexBean> paramList)
  {
    this.a = paramList;
  }
  
  public void setListener(a parama)
  {
    this.b = parama;
  }
  
  public static class MyTravelViewHolder
    extends RecyclerView.u
  {
    @BindView(2131695435)
    TextView travel_tv_address;
    @BindView(2131695433)
    TextView travel_tv_arriveTime;
    @BindView(2131695436)
    TextView travel_tv_contract;
    @BindView(2131695434)
    TextView travel_tv_leaveTime;
    @BindView(2131695432)
    TextView travel_tv_name;
    
    public MyTravelViewHolder(View paramView)
    {
      super();
      ButterKnife.bind(this, paramView);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onClick(int paramInt, SortIndexBean paramSortIndexBean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/adapter/MyTravelListMoreAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */