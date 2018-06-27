package com.ziroom.ziroomcustomer.newmovehouse.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.o;
import com.ziroom.ziroomcustomer.newServiceList.utils.h;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newmovehouse.b.b;
import com.ziroom.ziroomcustomer.newmovehouse.b.c;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHServiceDate;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHServiceDate.DataBean;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHServiceDate.DataBean.MoveOrderDateBean;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHServiceTime;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHServiceTime.DataBean;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHServiceTime.DataBean.MoveOrderTimeBean;
import com.ziroom.ziroomcustomer.widget.HorizontalListView;
import java.util.List;

public class MHServiceTimeActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private Context a;
  private HorizontalListView b;
  private MyGridView c;
  private View d;
  private TextView e;
  private TextView f;
  private TextView g;
  private c r;
  private b s;
  private List<MHServiceTime.DataBean.MoveOrderTimeBean> t;
  private List<MHServiceDate.DataBean.MoveOrderDateBean> u;
  private String v;
  private long w;
  private long x;
  private boolean y = false;
  
  private void a()
  {
    this.e = ((TextView)findViewById(2131689541));
    this.e.setText("服务时间");
    this.d = findViewById(2131691493);
    findViewById(2131696484).setVisibility(8);
    findViewById(2131691494).setVisibility(8);
    this.c = ((MyGridView)findViewById(2131691795));
    this.c.setSelector(new ColorDrawable(0));
    this.b = ((HorizontalListView)findViewById(2131691794));
    this.f = ((TextView)findViewById(2131689843));
    this.g = ((TextView)findViewById(2131689857));
  }
  
  private void b()
  {
    this.d.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.b.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        MHServiceTimeActivity.a(MHServiceTimeActivity.this, paramAnonymousInt);
      }
    });
    this.c.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (((MHServiceTime.DataBean.MoveOrderTimeBean)MHServiceTimeActivity.a(MHServiceTimeActivity.this).get(paramAnonymousInt)).getHaveCapacity() == 1)
        {
          if (MHServiceTimeActivity.b(MHServiceTimeActivity.this) != null) {
            MHServiceTimeActivity.b(MHServiceTimeActivity.this).setSelectPosition(paramAnonymousInt);
          }
          MHServiceTimeActivity.a(MHServiceTimeActivity.this, ((MHServiceTime.DataBean.MoveOrderTimeBean)MHServiceTimeActivity.a(MHServiceTimeActivity.this).get(paramAnonymousInt)).getTimePointKey());
          MHServiceTimeActivity.c(MHServiceTimeActivity.this).setBackgroundColor(Color.parseColor("#ffa000"));
          return;
        }
        g.textToast(MHServiceTimeActivity.d(MHServiceTimeActivity.this), "已约满，请选择其他时间");
      }
    });
  }
  
  private void b(int paramInt)
  {
    if (this.s != null)
    {
      this.s.setSelectPosition(paramInt);
      this.x = ((MHServiceDate.DataBean.MoveOrderDateBean)this.u.get(paramInt)).getDateKey();
      this.r.setSelectPosition(-1);
    }
    o.requestMoveTimes(this.a, this.v, ((MHServiceDate.DataBean.MoveOrderDateBean)this.u.get(paramInt)).getDateKey(), new com.ziroom.commonlibrary.a.a(this.a, new h(MHServiceTime.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        g.textToast(MHServiceTimeActivity.d(MHServiceTimeActivity.this), "服务器异常，正在努力抢修中，请稍后再试!");
      }
      
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        int i = 0;
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
        paramAnonymousObject = (MHServiceTime)paramAnonymousObject;
        if ((paramAnonymousObject != null) && ("0".equals(((MHServiceTime)paramAnonymousObject).getStatus())) && (((MHServiceTime)paramAnonymousObject).getData() != null))
        {
          MHServiceTimeActivity.b(MHServiceTimeActivity.this, ((MHServiceTime)paramAnonymousObject).getData().getMoveOrderTime());
          MHServiceTimeActivity.b(MHServiceTimeActivity.this).setData(MHServiceTimeActivity.a(MHServiceTimeActivity.this));
          paramAnonymousInt = i;
          if (MHServiceTimeActivity.g(MHServiceTimeActivity.this))
          {
            paramAnonymousInt = 0;
            for (;;)
            {
              if (paramAnonymousInt < MHServiceTimeActivity.a(MHServiceTimeActivity.this).size())
              {
                if (((MHServiceTime.DataBean.MoveOrderTimeBean)MHServiceTimeActivity.a(MHServiceTimeActivity.this).get(paramAnonymousInt)).getTimePointKey() != MHServiceTimeActivity.i(MHServiceTimeActivity.this)) {
                  break label193;
                }
                if (((MHServiceTime.DataBean.MoveOrderTimeBean)MHServiceTimeActivity.a(MHServiceTimeActivity.this).get(paramAnonymousInt)).getHaveCapacity() == 1) {
                  break label179;
                }
                MHServiceTimeActivity.a(MHServiceTimeActivity.this, 0L);
                MHServiceTimeActivity.b(MHServiceTimeActivity.this, 0L);
              }
              for (;;)
              {
                MHServiceTimeActivity.a(MHServiceTimeActivity.this, false);
                return;
                label179:
                MHServiceTimeActivity.b(MHServiceTimeActivity.this).setSelectPosition(paramAnonymousInt);
              }
              label193:
              paramAnonymousInt += 1;
            }
          }
          do
          {
            paramAnonymousInt += 1;
            if (paramAnonymousInt >= MHServiceTimeActivity.a(MHServiceTimeActivity.this).size()) {
              break;
            }
          } while (((MHServiceTime.DataBean.MoveOrderTimeBean)MHServiceTimeActivity.a(MHServiceTimeActivity.this).get(paramAnonymousInt)).getTimePointKey() != MHServiceTimeActivity.i(MHServiceTimeActivity.this));
          MHServiceTimeActivity.b(MHServiceTimeActivity.this).setSelectPosition(paramAnonymousInt);
          return;
        }
        if ((paramAnonymousObject != null) && (!TextUtils.isEmpty(((MHServiceTime)paramAnonymousObject).getMessage())))
        {
          g.textToast(MHServiceTimeActivity.d(MHServiceTimeActivity.this), ((MHServiceTime)paramAnonymousObject).getMessage());
          MHServiceTimeActivity.a(MHServiceTimeActivity.this, false);
          return;
        }
        g.textToast(MHServiceTimeActivity.d(MHServiceTimeActivity.this), "网络数据请求失败!");
        MHServiceTimeActivity.a(MHServiceTimeActivity.this, false);
      }
    });
  }
  
  private void e()
  {
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      this.v = localBundle.getString("serviceTypeCode");
      this.w = localBundle.getLong("moveTime");
      this.x = localBundle.getLong("selectDate");
      if ((this.x <= 0L) || (this.w <= 0L)) {
        break label172;
      }
      this.y = true;
    }
    for (;;)
    {
      this.s = new b(this.a, this.u);
      this.b.setAdapter(this.s);
      this.r = new c(4, this.t, this.a);
      this.c.setAdapter(this.r);
      o.requestMoveDates(this.a, this.v, new com.ziroom.commonlibrary.a.a(this.a, new h(MHServiceDate.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          g.textToast(MHServiceTimeActivity.d(MHServiceTimeActivity.this), "服务器异常，正在努力抢修中，请稍后再试!");
        }
        
        public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousObject);
          paramAnonymousObject = (MHServiceDate)paramAnonymousObject;
          int i;
          if ((paramAnonymousObject != null) && ("0".equals(((MHServiceDate)paramAnonymousObject).getStatus())) && (((MHServiceDate)paramAnonymousObject).getData() != null))
          {
            MHServiceTimeActivity.a(MHServiceTimeActivity.this, ((MHServiceDate)paramAnonymousObject).getData().getMoveOrderDate());
            MHServiceTimeActivity.f(MHServiceTimeActivity.this).setData(MHServiceTimeActivity.e(MHServiceTimeActivity.this));
            if (MHServiceTimeActivity.g(MHServiceTimeActivity.this))
            {
              paramAnonymousInt = 0;
              if (paramAnonymousInt >= MHServiceTimeActivity.e(MHServiceTimeActivity.this).size()) {
                break label225;
              }
              if (((MHServiceDate.DataBean.MoveOrderDateBean)MHServiceTimeActivity.e(MHServiceTimeActivity.this).get(paramAnonymousInt)).getDateKey() == MHServiceTimeActivity.h(MHServiceTimeActivity.this))
              {
                i = 1;
                MHServiceTimeActivity.a(MHServiceTimeActivity.this, paramAnonymousInt);
              }
            }
          }
          label225:
          for (paramAnonymousInt = i;; paramAnonymousInt = 0)
          {
            if (paramAnonymousInt == 0) {
              MHServiceTimeActivity.a(MHServiceTimeActivity.this, 0);
            }
            return;
            paramAnonymousInt += 1;
            break;
            MHServiceTimeActivity.a(MHServiceTimeActivity.this, 0);
            return;
            if ((paramAnonymousObject != null) && (!TextUtils.isEmpty(((MHServiceDate)paramAnonymousObject).getMessage())))
            {
              g.textToast(MHServiceTimeActivity.d(MHServiceTimeActivity.this), ((MHServiceDate)paramAnonymousObject).getMessage());
              MHServiceTimeActivity.a(MHServiceTimeActivity.this, false);
              return;
            }
            g.textToast(MHServiceTimeActivity.d(MHServiceTimeActivity.this), "网络数据请求失败!");
            MHServiceTimeActivity.a(MHServiceTimeActivity.this, false);
            return;
          }
        }
      });
      j.getServiceCalendarTip(this.a, "move", this.g);
      return;
      label172:
      this.f.setBackgroundColor(Color.parseColor("#dddddd"));
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView != null) {}
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131691493: 
      setResult(0, getIntent());
      finish();
      return;
    }
    if (this.w > 0L)
    {
      paramView = getIntent();
      paramView.putExtra("moveTime", this.w);
      paramView.putExtra("selectDate", this.x);
      setResult(-1, paramView);
      finish();
      return;
    }
    g.textToast(this.a, "请选择服务时间");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903354);
    this.a = this;
    a();
    b();
    e();
  }
  
  protected void onDestroy()
  {
    com.freelxl.baselibrary.d.a.cancel(this.a.getClass().getName());
    super.onDestroy();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/activity/MHServiceTimeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */