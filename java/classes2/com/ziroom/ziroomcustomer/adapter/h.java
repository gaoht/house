package com.ziroom.ziroomcustomer.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.activity.LeaseConfirmPayActivity;
import com.ziroom.ziroomcustomer.model.RentCardDetail;
import java.util.ArrayList;
import java.util.List;

public class h
  extends BaseAdapter
{
  private Context a;
  private Handler b;
  private List<RentCardDetail> c;
  private List<RentCardDetail> d = new ArrayList();
  
  public h(Context paramContext, Handler paramHandler, List<RentCardDetail> paramList)
  {
    this.a = paramContext;
    this.b = paramHandler;
    this.c = paramList;
  }
  
  public List<RentCardDetail> getChecked()
  {
    return this.d;
  }
  
  public int getCheckedPosition(RentCardDetail paramRentCardDetail)
  {
    int i = 0;
    while (i < this.d.size())
    {
      if (paramRentCardDetail.getCardCode().equals(((RentCardDetail)this.d.get(i)).getCardCode())) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public int getCount()
  {
    return this.c.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2130904270, null);
      paramViewGroup = new a(null);
      paramViewGroup.b = ((TextView)paramView.findViewById(2131695189));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131689846));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a = ((ImageView)paramView.findViewById(2131695187));
      final RentCardDetail localRentCardDetail = (RentCardDetail)this.c.get(paramInt);
      paramViewGroup.b.setText(localRentCardDetail.getCardCode());
      paramViewGroup.c.setText(localRentCardDetail.getCardValue() + "");
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          int i = h.this.getCheckedPosition(localRentCardDetail);
          if (i < 0)
          {
            double d = LeaseConfirmPayActivity.a.getInputAmount();
            if (localRentCardDetail.getCardValue() > d)
            {
              g.textToast(h.a(h.this), "租金卡不能超出支付金额！", 0);
              return;
            }
            h.b(h.this).add(localRentCardDetail);
          }
          for (;;)
          {
            h.c(h.this).sendEmptyMessage(131075);
            return;
            h.b(h.this).remove(i);
          }
        }
      });
      if (getCheckedPosition(localRentCardDetail) >= 0) {
        break;
      }
      paramViewGroup.a.setImageResource(2130839460);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    paramViewGroup.a.setImageResource(2130839459);
    return paramView;
  }
  
  public void setData(List<RentCardDetail> paramList)
  {
    this.c = paramList;
  }
  
  private class a
  {
    ImageView a;
    TextView b;
    TextView c;
    
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/adapter/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */