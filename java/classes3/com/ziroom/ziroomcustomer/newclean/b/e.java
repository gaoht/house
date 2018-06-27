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
import com.ziroom.ziroomcustomer.newclean.activity.BiweeklyCleanModifyActivity;
import com.ziroom.ziroomcustomer.newclean.activity.WeekCleanDetailActivity;
import com.ziroom.ziroomcustomer.util.w;
import java.util.List;

public class e
  extends BaseAdapter
{
  private final String a = "BiweeklyCleanAdapter";
  private Context b;
  private List<com.ziroom.ziroomcustomer.newclean.d.m> c;
  private LayoutInflater d;
  private Bundle e;
  
  public e(Context paramContext, List<com.ziroom.ziroomcustomer.newclean.d.m> paramList, Bundle paramBundle)
  {
    this.b = paramContext;
    this.c = paramList;
    this.e = paramBundle;
    this.d = LayoutInflater.from(paramContext);
  }
  
  public int getCount()
  {
    if (this.c == null) {
      return 0;
    }
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
    final com.ziroom.ziroomcustomer.newclean.d.m localm = (com.ziroom.ziroomcustomer.newclean.d.m)this.c.get(paramInt);
    if (paramView == null)
    {
      paramView = this.d.inflate(2130904138, paramViewGroup, false);
      paramViewGroup = new a(null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131689852));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131689822));
      paramViewGroup.c = ((Button)paramView.findViewById(2131690043));
      paramView.setTag(paramViewGroup);
      paramViewGroup.a.setText("预约时间：" + localm.getConstructionDate());
      if (!TextUtils.isEmpty(localm.getOrderStatus())) {
        break label222;
      }
      paramViewGroup.b.setText("订单状态：");
      label135:
      String str = localm.getOperateName();
      paramInt = localm.getOperateCode();
      if (TextUtils.isEmpty(str)) {
        break label316;
      }
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.c.setText(str);
      if (paramInt != 1) {
        break label255;
      }
      paramViewGroup.c.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          w.onEventToZiroomAndUmeng("biweeklyclean_my_change");
          n.getBiweeklyCleanModifyValidate(e.a(e.this), e.b(e.this).getString("uid"), localm.getOrderId(), e.b(e.this).getString("rentContractCode"), e.b(e.this).getString("hireContractCode"), e.b(e.this).getString("phone"), e.b(e.this).getString("name"), new com.ziroom.ziroomcustomer.e.a.a(e.a(e.this), new com.ziroom.ziroomcustomer.e.c.m(String.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
          {
            public void onSuccess(int paramAnonymous2Int, String paramAnonymous2String)
            {
              super.onSuccess(paramAnonymous2Int, paramAnonymous2String);
              paramAnonymous2String = new Intent(e.a(e.this), BiweeklyCleanModifyActivity.class);
              paramAnonymous2String.putExtras(e.b(e.this));
              paramAnonymous2String.putExtra("billId", e.1.this.a.getOrderId());
              paramAnonymous2String.putExtra("datetime", e.1.this.a.getConstructionDate());
              paramAnonymous2String.putExtra("date", e.1.this.a.getAppointDate());
              paramAnonymous2String.putExtra("time", e.1.this.a.getTimePeroid());
              ((Activity)e.a(e.this)).startActivityForResult(paramAnonymous2String, 1);
            }
          });
        }
      });
    }
    for (;;)
    {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(e.a(e.this), WeekCleanDetailActivity.class);
          paramAnonymousView.putExtras(e.b(e.this));
          paramAnonymousView.putExtra("billId", localm.getOrderId());
          paramAnonymousView.putExtra("cleanerId", localm.getMonthCleanerId());
          paramAnonymousView.putExtra("date", localm.getAppointDate());
          paramAnonymousView.putExtra("time", localm.getTimePeroid());
          e.a(e.this).startActivity(paramAnonymousView);
        }
      });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label222:
      paramViewGroup.b.setText("订单状态：" + localm.getOrderStatus());
      break label135;
      label255:
      if (paramInt == 2)
      {
        paramViewGroup.c.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            w.onEventToZiroomAndUmeng("biweeklyclean_my_evaluate");
            paramAnonymousView = new Intent(e.a(e.this), WeekCleanDetailActivity.class);
            paramAnonymousView.putExtras(e.b(e.this));
            paramAnonymousView.putExtra("billId", localm.getOrderId());
            paramAnonymousView.putExtra("cleanerId", localm.getMonthCleanerId());
            paramAnonymousView.putExtra("date", localm.getAppointDate());
            paramAnonymousView.putExtra("time", localm.getTimePeroid());
            ((Activity)e.a(e.this)).startActivityForResult(paramAnonymousView, 2);
          }
        });
      }
      else if (paramInt == 3)
      {
        paramViewGroup.c.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            w.onEventToZiroomAndUmeng("biweeklyclean_my_evaluate_add");
            if (!TextUtils.isEmpty(localm.getEvaluateId()))
            {
              paramAnonymousView = new Intent(e.a(e.this), BiWeeklyEvalActivity.class);
              paramAnonymousView.putExtras(e.b(e.this));
              paramAnonymousView.putExtra("billId", localm.getOrderId());
              paramAnonymousView.putExtra("evalId", localm.getEvaluateId());
              paramAnonymousView.putExtra("cleanerId", localm.getMonthCleanerId());
              paramAnonymousView.putExtra("date", localm.getAppointDate());
              paramAnonymousView.putExtra("time", localm.getTimePeroid());
              ((Activity)e.a(e.this)).startActivityForResult(paramAnonymousView, 3);
            }
          }
        });
      }
      else
      {
        paramViewGroup.c.setOnClickListener(null);
        continue;
        label316:
        paramViewGroup.c.setVisibility(8);
      }
    }
  }
  
  public void setData(List<com.ziroom.ziroomcustomer.newclean.d.m> paramList)
  {
    this.c = paramList;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */