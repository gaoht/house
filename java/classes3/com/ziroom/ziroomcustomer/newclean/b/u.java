package com.ziroom.ziroomcustomer.newclean.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newclean.activity.BiWeeklyEvalActivity;
import com.ziroom.ziroomcustomer.newclean.activity.ForCleaningAppointActivity;
import com.ziroom.ziroomcustomer.newclean.activity.WeekCleanDetailActivity;
import java.util.List;

public class u
  extends BaseAdapter
{
  public int a = 1;
  public int b = 2;
  public int c = 3;
  private final String d = "ForCleaningOrderAdapter";
  private Context e;
  private List<com.ziroom.ziroomcustomer.newclean.d.m> f;
  private LayoutInflater g;
  private Bundle h;
  
  public u(Context paramContext, List<com.ziroom.ziroomcustomer.newclean.d.m> paramList, Bundle paramBundle)
  {
    this.e = paramContext;
    this.f = paramList;
    this.h = paramBundle;
    this.g = LayoutInflater.from(paramContext);
  }
  
  public int getCount()
  {
    if (this.f == null) {
      return 0;
    }
    return this.f.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.f.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    final com.ziroom.ziroomcustomer.newclean.d.m localm = (com.ziroom.ziroomcustomer.newclean.d.m)this.f.get(paramInt);
    String str;
    if (paramView == null)
    {
      paramView = this.g.inflate(2130904200, paramViewGroup, false);
      paramViewGroup = new a(null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131689852));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131689822));
      paramViewGroup.c = ((Button)paramView.findViewById(2131690043));
      paramView.setTag(paramViewGroup);
      str = localm.getOperateName();
      paramInt = localm.getOperateCode();
      if (!TextUtils.isEmpty(str)) {
        break label221;
      }
      paramViewGroup.c.setVisibility(8);
      label115:
      if (!TextUtils.isEmpty(localm.getPlanServiceDate())) {
        break label241;
      }
      paramViewGroup.a.setText("预约时间：" + localm.getConstructionDate());
      label156:
      if (!TextUtils.isEmpty(localm.getOrderStatus())) {
        break label274;
      }
      paramViewGroup.b.setText("订单状态：");
    }
    for (;;)
    {
      paramViewGroup.c.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (paramInt == paramInt) {
            n.getBiweeklyCleanModifyValidate(u.a(u.this), u.b(u.this).getString("uid"), localm.getOrderId(), u.b(u.this).getString("rentContractCode"), u.b(u.this).getString("hireContractCode"), u.b(u.this).getString("phone"), u.b(u.this).getString("name"), new com.ziroom.ziroomcustomer.e.a.a(u.a(u.this), new com.ziroom.ziroomcustomer.e.c.m(String.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
            {
              public void onSuccess(int paramAnonymous2Int, String paramAnonymous2String)
              {
                super.onSuccess(paramAnonymous2Int, paramAnonymous2String);
                paramAnonymous2String = new Intent(u.a(u.this), ForCleaningAppointActivity.class);
                paramAnonymous2String.putExtra("billId", u.1.this.b.getOrderId());
                paramAnonymous2String.putExtra("cleanerId", u.1.this.b.getMonthCleanerId());
                paramAnonymous2String.putExtras(u.b(u.this));
                ((Activity)u.a(u.this)).startActivityForResult(paramAnonymous2String, 1);
              }
            });
          }
          do
          {
            return;
            if (paramInt == u.this.b)
            {
              paramAnonymousView = new Intent(u.a(u.this), WeekCleanDetailActivity.class);
              paramAnonymousView.putExtras(u.b(u.this));
              paramAnonymousView.putExtra("billId", localm.getOrderId());
              paramAnonymousView.putExtra("cleanerId", localm.getMonthCleanerId());
              paramAnonymousView.putExtra("date", localm.getAppointDate());
              paramAnonymousView.putExtra("time", localm.getTimePeroid());
              ((Activity)u.a(u.this)).startActivityForResult(paramAnonymousView, 2);
              return;
            }
          } while ((paramInt != u.this.c) || (TextUtils.isEmpty(localm.getEvaluateId())));
          paramAnonymousView = new Intent(u.a(u.this), BiWeeklyEvalActivity.class);
          paramAnonymousView.putExtras(u.b(u.this));
          paramAnonymousView.putExtra("billId", localm.getOrderId());
          paramAnonymousView.putExtra("evalId", localm.getEvaluateId());
          paramAnonymousView.putExtra("cleanerId", localm.getMonthCleanerId());
          paramAnonymousView.putExtra("date", localm.getAppointDate());
          paramAnonymousView.putExtra("time", localm.getTimePeroid());
          ((Activity)u.a(u.this)).startActivityForResult(paramAnonymousView, 3);
        }
      });
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(u.a(u.this), WeekCleanDetailActivity.class);
          paramAnonymousView.putExtras(u.b(u.this));
          paramAnonymousView.putExtra("billId", localm.getOrderId());
          paramAnonymousView.putExtra("cleanerId", localm.getMonthCleanerId());
          paramAnonymousView.putExtra("date", localm.getAppointDate());
          paramAnonymousView.putExtra("time", localm.getTimePeroid());
          u.a(u.this).startActivity(paramAnonymousView);
        }
      });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label221:
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.c.setText(str);
      break label115;
      label241:
      paramViewGroup.a.setText("预约时间：" + localm.getPlanServiceDate());
      break label156;
      label274:
      paramViewGroup.b.setText("订单状态：" + localm.getOrderStatus());
    }
  }
  
  public void setData(List<com.ziroom.ziroomcustomer.newclean.d.m> paramList, Bundle paramBundle)
  {
    this.f = paramList;
    this.h = paramBundle;
    notifyDataSetChanged();
  }
  
  private class a
  {
    public TextView a;
    public TextView b;
    public Button c;
    
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/b/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */