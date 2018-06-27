package com.ziroom.ziroomcustomer.minsu.landlord.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.f;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaluationListBean.DataBean.RowsBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLLOrderListBean.DataBean.OrderListBean;
import com.ziroom.ziroomcustomer.minsu.dialog.h;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.landlord.activity.LandlordOrderDetailActivity;
import com.ziroom.ziroomcustomer.minsu.landlord.activity.MinsuLandlordFutrueOrderActivity;
import java.util.LinkedList;
import java.util.List;

public class a
  extends RecyclerView.a
  implements View.OnClickListener
{
  public int a = 0;
  private LayoutInflater b;
  private List<Object> c = new LinkedList();
  private b d = b.a;
  private c e = null;
  private Context f;
  private int g = 1;
  
  public a(Context paramContext)
  {
    this.f = paramContext;
    this.b = LayoutInflater.from(paramContext);
  }
  
  public int getItemCount()
  {
    return this.c.size() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == this.c.size()) {
      return 1;
    }
    return 0;
  }
  
  public b getmLoadType()
  {
    return this.d;
  }
  
  public void onBindViewHolder(RecyclerView.u paramu, int paramInt)
  {
    final Object localObject;
    if (getItemViewType(paramInt) == 0)
    {
      paramu = (d)paramu;
      paramu.itemView.setOnClickListener(this);
      if (this.g == 1)
      {
        localObject = (MinsuLLOrderListBean.DataBean.OrderListBean)this.c.get(paramInt);
        d.a(paramu).setText(((MinsuLLOrderListBean.DataBean.OrderListBean)localObject).houseName);
        d.b(paramu).setText(((MinsuLLOrderListBean.DataBean.OrderListBean)localObject).startTimeStr + "-" + ((MinsuLLOrderListBean.DataBean.OrderListBean)localObject).endTimeStr);
        d.c(paramu).setText(((MinsuLLOrderListBean.DataBean.OrderListBean)localObject).userName);
        d.d(paramu).setText(((MinsuLLOrderListBean.DataBean.OrderListBean)localObject).contactsNum + "人");
        d.e(paramu).setText(((MinsuLLOrderListBean.DataBean.OrderListBean)localObject).orderStatusShowName);
        d.f(paramu).setText(((MinsuLLOrderListBean.DataBean.OrderListBean)localObject).waitDealOrderButton);
        if (((MinsuLLOrderListBean.DataBean.OrderListBean)localObject).headPicUrl != null) {
          d.g(paramu).setController(c.frescoController(((MinsuLLOrderListBean.DataBean.OrderListBean)localObject).headPicUrl.toString()));
        }
        d.f(paramu).setTag(Integer.valueOf(paramInt));
        d.f(paramu).setOnClickListener(this);
        paramu.itemView.setTag(Integer.valueOf(paramInt));
      }
    }
    label407:
    label472:
    do
    {
      return;
      if (this.g == 2)
      {
        localObject = (MinsuEvaluationListBean.DataBean.RowsBean)this.c.get(paramInt);
        d.a(paramu).setText(((MinsuEvaluationListBean.DataBean.RowsBean)localObject).houseName);
        d.b(paramu).setText(((MinsuEvaluationListBean.DataBean.RowsBean)localObject).startTimeStr + "-" + ((MinsuEvaluationListBean.DataBean.RowsBean)localObject).endTimeStr);
        d.c(paramu).setText(((MinsuEvaluationListBean.DataBean.RowsBean)localObject).userName);
        d.d(paramu).setText(((MinsuEvaluationListBean.DataBean.RowsBean)localObject).peopleNum + "人");
        d.e(paramu).setText(((MinsuEvaluationListBean.DataBean.RowsBean)localObject).evaTips);
        d.f(paramu).setText(((MinsuEvaluationListBean.DataBean.RowsBean)localObject).pjButton);
        if (((MinsuEvaluationListBean.DataBean.RowsBean)localObject).userPicUrl != null) {
          d.g(paramu).setController(c.frescoController(((MinsuEvaluationListBean.DataBean.RowsBean)localObject).userPicUrl));
        }
        if (TextUtils.isEmpty(((MinsuEvaluationListBean.DataBean.RowsBean)localObject).evaTips)) {
          d.h(paramu).setVisibility(4);
        }
        d.i(paramu).setText(((MinsuEvaluationListBean.DataBean.RowsBean)localObject).invitEvalButton);
        if (f.isNull(((MinsuEvaluationListBean.DataBean.RowsBean)localObject).invitEvalButton))
        {
          d.i(paramu).setVisibility(8);
          if (!f.isNull(((MinsuEvaluationListBean.DataBean.RowsBean)localObject).pjButton)) {
            break label472;
          }
          d.f(paramu).setVisibility(8);
        }
        for (;;)
        {
          d.f(paramu).setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              k.toEvaActivity((Activity)a.a(a.this), localObject.orderSn, h.a);
            }
          });
          d.i(paramu).setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              k.toImPage((Activity)a.a(a.this), localObject.userUid, localObject.houseFid, localObject.rentWay, 1, "MinsuOrderSigned");
            }
          });
          break;
          d.i(paramu).setVisibility(0);
          break label407;
          d.f(paramu).setVisibility(0);
        }
      }
      localObject = (MinsuLLOrderListBean.DataBean.OrderListBean)this.c.get(paramInt);
      if (paramInt > 0)
      {
        MinsuLLOrderListBean.DataBean.OrderListBean localOrderListBean = (MinsuLLOrderListBean.DataBean.OrderListBean)this.c.get(paramInt - 1);
        if ((localOrderListBean != null) && (localOrderListBean.startTimeStr.equals(((MinsuLLOrderListBean.DataBean.OrderListBean)localObject).startTimeStr))) {
          d.j(paramu).setVisibility(8);
        }
      }
      for (;;)
      {
        d.a(paramu).setText(((MinsuLLOrderListBean.DataBean.OrderListBean)localObject).houseName);
        d.b(paramu).setVisibility(8);
        d.c(paramu).setText(((MinsuLLOrderListBean.DataBean.OrderListBean)localObject).userName);
        d.d(paramu).setText(((MinsuLLOrderListBean.DataBean.OrderListBean)localObject).contactsNum + "人");
        d.e(paramu).setText(((MinsuLLOrderListBean.DataBean.OrderListBean)localObject).orderStatusShowName);
        d.f(paramu).setText(((MinsuLLOrderListBean.DataBean.OrderListBean)localObject).imToTaButton);
        if (((MinsuLLOrderListBean.DataBean.OrderListBean)localObject).headPicUrl != null) {
          d.g(paramu).setController(c.frescoController(((MinsuLLOrderListBean.DataBean.OrderListBean)localObject).headPicUrl.toString()));
        }
        d.i(paramu).setVisibility(8);
        d.f(paramu).setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            k.toImPage((Activity)a.a(a.this), localObject.userUid, localObject.houseFid, localObject.rentWay, 1, "MinsuOrderSigned");
          }
        });
        d.i(paramu).setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = new Intent(a.a(a.this), LandlordOrderDetailActivity.class);
            paramAnonymousView.putExtra("orderSn", localObject.orderSn);
            ((Activity)a.a(a.this)).startActivityForResult(paramAnonymousView, 770);
            a.a(a.this).startActivity(paramAnonymousView);
          }
        });
        break;
        d.j(paramu).setVisibility(0);
        d.j(paramu).setText(((MinsuLLOrderListBean.DataBean.OrderListBean)localObject).startTimeStr);
        continue;
        d.j(paramu).setVisibility(0);
        d.j(paramu).setText(((MinsuLLOrderListBean.DataBean.OrderListBean)localObject).startTimeStr);
      }
      paramu = (a)paramu;
      if (this.d == b.a)
      {
        paramu.itemView.setTag(Integer.valueOf(-1));
        paramu.itemView.setVisibility(8);
        return;
      }
      if (this.d == b.b)
      {
        a.a(paramu).setVisibility(0);
        a.b(paramu).setVisibility(8);
        a.c(paramu).setVisibility(8);
        paramu.itemView.setTag(Integer.valueOf(-2));
        paramu.itemView.setVisibility(0);
        a.a(paramu).setText("加载更多");
        return;
      }
      if (this.d != b.d) {
        break label982;
      }
      paramu.itemView.setTag(Integer.valueOf(-3));
      paramu.itemView.setVisibility(0);
      a.a(paramu).setVisibility(0);
      a.b(paramu).setVisibility(8);
      a.c(paramu).setVisibility(8);
      a.a(paramu).setText("已经加载了全部数据");
    } while ((this.g != 11) || (this.a != 1));
    paramu.itemView.setVisibility(0);
    a.a(paramu).setVisibility(8);
    a.b(paramu).setVisibility(8);
    a.c(paramu).setVisibility(0);
    a.c(paramu).setTag(Integer.valueOf(-3));
    a.c(paramu).setOnClickListener(this);
    return;
    label982:
    if (this.d == b.e)
    {
      paramu.itemView.setTag(Integer.valueOf(-4));
      paramu.itemView.setVisibility(0);
      a.a(paramu).setVisibility(8);
      a.b(paramu).setVisibility(0);
      a.c(paramu).setVisibility(8);
      if (this.g == 1)
      {
        a.b(paramu).setText("您暂时还没有待处理订单");
        return;
      }
      if (this.g == 2)
      {
        a.b(paramu).setText("您暂时还没有待评价订单");
        return;
      }
      a.b(paramu).setText("您暂时还没有将至订单");
      return;
    }
    paramu.itemView.setTag(Integer.valueOf(-5));
    paramu.itemView.setVisibility(0);
    a.c(paramu).setVisibility(8);
    a.a(paramu).setVisibility(0);
    a.b(paramu).setVisibility(8);
    a.a(paramu).setText("网络异常，点击重新加载");
    a.a(paramu).setTag(Integer.valueOf(-5));
    a.a(paramu).setOnClickListener(this);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    int i;
    if (this.e != null)
    {
      i = ((Integer)paramView.getTag()).intValue();
      if (i >= 0) {
        this.e.onItemClick(paramView, i);
      }
    }
    else
    {
      return;
    }
    if (i != -3)
    {
      c localc = this.e;
      if (i == -2) {}
      for (boolean bool = true;; bool = false)
      {
        localc.onFooterClick(paramView, bool);
        return;
      }
    }
    paramView = new Intent(this.f, MinsuLandlordFutrueOrderActivity.class);
    this.f.startActivity(paramView);
  }
  
  public RecyclerView.u onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      return new d(this.b.inflate(2130904335, paramViewGroup, false));
    }
    return new a(this.b.inflate(2130904336, paramViewGroup, false));
  }
  
  public void setData(List<Object> paramList)
  {
    this.c = paramList;
    notifyDataSetChanged();
  }
  
  public void setLoadType(b paramb)
  {
    this.d = paramb;
  }
  
  public void setType(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setmOnItemClickListener(c paramc)
  {
    this.e = paramc;
  }
  
  private class a
    extends RecyclerView.u
  {
    private TextView b;
    private TextView c;
    private TextView d;
    
    public a(View paramView)
    {
      super();
      this.b = ((TextView)paramView.findViewById(2131689850));
      this.c = ((TextView)paramView.findViewById(2131690822));
      this.d = ((TextView)paramView.findViewById(2131690326));
    }
  }
  
  public static enum b
  {
    private b() {}
  }
  
  public static abstract interface c
  {
    public abstract void onFooterClick(View paramView, boolean paramBoolean);
    
    public abstract void onItemClick(View paramView, int paramInt);
  }
  
  private class d
    extends RecyclerView.u
  {
    private SimpleDraweeView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private View k;
    
    public d(View paramView)
    {
      super();
      this.b = ((SimpleDraweeView)paramView.findViewById(2131690097));
      this.c = ((TextView)paramView.findViewById(2131690053));
      this.e = ((TextView)paramView.findViewById(2131693265));
      this.d = ((TextView)paramView.findViewById(2131689852));
      this.f = ((TextView)paramView.findViewById(2131692636));
      this.g = ((TextView)paramView.findViewById(2131691509));
      this.h = ((TextView)paramView.findViewById(2131689822));
      this.i = ((TextView)paramView.findViewById(2131695319));
      this.j = ((TextView)paramView.findViewById(2131695320));
      this.k = paramView.findViewById(2131693139);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */