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
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newmovehouse.b.b;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHServiceDate;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHServiceDate.DataBean;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHServiceDate.DataBean.MoveOrderDateBean;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHServiceTime;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHServiceTime.DataBean;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHServiceTime.DataBean.MoveOrderTimeBean;
import com.ziroom.ziroomcustomer.widget.HorizontalListView;
import java.util.List;

public class MovingServiceTimeActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private Context a;
  private HorizontalListView b;
  private MyGridView c;
  private View d;
  private TextView e;
  private TextView f;
  private com.ziroom.ziroomcustomer.newmovehouse.b.h g;
  private b r;
  private List<MHServiceTime.DataBean.MoveOrderTimeBean> s;
  private List<MHServiceDate.DataBean.MoveOrderDateBean> t;
  private String u;
  private long v;
  private long w;
  private boolean x = false;
  private TextView y;
  
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
    this.y = ((TextView)findViewById(2131689837));
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
        MovingServiceTimeActivity.a(MovingServiceTimeActivity.this, paramAnonymousInt);
      }
    });
    this.c.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (((MHServiceTime.DataBean.MoveOrderTimeBean)MovingServiceTimeActivity.a(MovingServiceTimeActivity.this).get(paramAnonymousInt)).getHaveCapacity() == 1)
        {
          if (MovingServiceTimeActivity.b(MovingServiceTimeActivity.this) != null) {
            MovingServiceTimeActivity.b(MovingServiceTimeActivity.this).setSelectPosition(paramAnonymousInt);
          }
          MovingServiceTimeActivity.a(MovingServiceTimeActivity.this, ((MHServiceTime.DataBean.MoveOrderTimeBean)MovingServiceTimeActivity.a(MovingServiceTimeActivity.this).get(paramAnonymousInt)).getTimePointKey());
          MovingServiceTimeActivity.c(MovingServiceTimeActivity.this).setBackgroundColor(Color.parseColor("#ffa000"));
          return;
        }
        g.textToast(MovingServiceTimeActivity.d(MovingServiceTimeActivity.this), "已约满，请选择其他时间");
      }
    });
  }
  
  private void b(int paramInt)
  {
    if (this.r != null)
    {
      this.r.setSelectPosition(paramInt);
      this.w = ((MHServiceDate.DataBean.MoveOrderDateBean)this.t.get(paramInt)).getDateKey();
      com.ziroom.ziroomcustomer.newmovehouse.b.h localh1 = this.g;
      com.ziroom.ziroomcustomer.newmovehouse.b.h localh2 = this.g;
      localh1.setSelectPosition(-1);
    }
    c(paramInt);
  }
  
  private void c(int paramInt)
  {
    n.getMovingVanTimePoint(this.a, this.u, ((MHServiceDate.DataBean.MoveOrderDateBean)this.t.get(paramInt)).getDateKey(), new com.ziroom.commonlibrary.a.a(this.a, new com.ziroom.ziroomcustomer.newServiceList.utils.h(MHServiceTime.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        g.textToast(MovingServiceTimeActivity.d(MovingServiceTimeActivity.this), "服务器异常，正在努力抢修中，请稍后再试!");
      }
      
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        int i = 0;
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
        paramAnonymousObject = (MHServiceTime)paramAnonymousObject;
        if ((paramAnonymousObject != null) && ("0".equals(((MHServiceTime)paramAnonymousObject).getStatus())) && (((MHServiceTime)paramAnonymousObject).getData() != null))
        {
          if (TextUtils.isEmpty(((MHServiceTime)paramAnonymousObject).getData().getRemark()))
          {
            MovingServiceTimeActivity.e(MovingServiceTimeActivity.this).setVisibility(8);
            MovingServiceTimeActivity.a(MovingServiceTimeActivity.this, ((MHServiceTime)paramAnonymousObject).getData().getMoveOrderTime());
            MovingServiceTimeActivity.b(MovingServiceTimeActivity.this).setData(MovingServiceTimeActivity.a(MovingServiceTimeActivity.this));
            if (!MovingServiceTimeActivity.f(MovingServiceTimeActivity.this)) {
              break label264;
            }
            if (MovingServiceTimeActivity.a(MovingServiceTimeActivity.this) != null)
            {
              paramAnonymousInt = 0;
              label115:
              if (paramAnonymousInt < MovingServiceTimeActivity.a(MovingServiceTimeActivity.this).size())
              {
                if (((MHServiceTime.DataBean.MoveOrderTimeBean)MovingServiceTimeActivity.a(MovingServiceTimeActivity.this).get(paramAnonymousInt)).getTimePointKey() != MovingServiceTimeActivity.g(MovingServiceTimeActivity.this)) {
                  break label257;
                }
                if (((MHServiceTime.DataBean.MoveOrderTimeBean)MovingServiceTimeActivity.a(MovingServiceTimeActivity.this).get(paramAnonymousInt)).getHaveCapacity() == 1) {
                  break label243;
                }
                MovingServiceTimeActivity.a(MovingServiceTimeActivity.this, 0L);
                MovingServiceTimeActivity.b(MovingServiceTimeActivity.this, 0L);
              }
            }
            label202:
            MovingServiceTimeActivity.a(MovingServiceTimeActivity.this, false);
          }
          for (;;)
          {
            return;
            MovingServiceTimeActivity.e(MovingServiceTimeActivity.this).setText(((MHServiceTime)paramAnonymousObject).getData().getRemark());
            MovingServiceTimeActivity.e(MovingServiceTimeActivity.this).setVisibility(0);
            break;
            label243:
            MovingServiceTimeActivity.b(MovingServiceTimeActivity.this).setSelectPosition(paramAnonymousInt);
            break label202;
            label257:
            paramAnonymousInt += 1;
            break label115;
            label264:
            if (MovingServiceTimeActivity.a(MovingServiceTimeActivity.this) != null)
            {
              paramAnonymousInt = i;
              while (paramAnonymousInt < MovingServiceTimeActivity.a(MovingServiceTimeActivity.this).size())
              {
                if (((MHServiceTime.DataBean.MoveOrderTimeBean)MovingServiceTimeActivity.a(MovingServiceTimeActivity.this).get(paramAnonymousInt)).getTimePointKey() == MovingServiceTimeActivity.g(MovingServiceTimeActivity.this))
                {
                  MovingServiceTimeActivity.b(MovingServiceTimeActivity.this).setSelectPosition(paramAnonymousInt);
                  return;
                }
                paramAnonymousInt += 1;
              }
            }
          }
        }
        if ((paramAnonymousObject != null) && (!TextUtils.isEmpty(((MHServiceTime)paramAnonymousObject).getMessage())))
        {
          g.textToast(MovingServiceTimeActivity.d(MovingServiceTimeActivity.this), ((MHServiceTime)paramAnonymousObject).getMessage());
          MovingServiceTimeActivity.a(MovingServiceTimeActivity.this, false);
          return;
        }
        g.textToast(MovingServiceTimeActivity.d(MovingServiceTimeActivity.this), "网络数据请求失败!");
        MovingServiceTimeActivity.a(MovingServiceTimeActivity.this, false);
      }
    });
  }
  
  private void e()
  {
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      this.u = localBundle.getString("serviceTypeCode");
      this.v = localBundle.getLong("moveTime");
      this.w = localBundle.getLong("selectDate");
      if ((this.w <= 0L) || (this.v <= 0L)) {
        break label131;
      }
      this.x = true;
    }
    for (;;)
    {
      this.r = new b(this.a, this.t);
      this.b.setAdapter(this.r);
      this.g = new com.ziroom.ziroomcustomer.newmovehouse.b.h(4, this.s, this.a);
      this.c.setAdapter(this.g);
      f();
      return;
      label131:
      this.f.setBackgroundColor(Color.parseColor("#dddddd"));
    }
  }
  
  private void f()
  {
    n.getMovingVanData(this.a, this.u, new com.ziroom.commonlibrary.a.a(this.a, new com.ziroom.ziroomcustomer.newServiceList.utils.h(MHServiceDate.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        g.textToast(MovingServiceTimeActivity.d(MovingServiceTimeActivity.this), "服务器异常，正在努力抢修中，请稍后再试!");
      }
      
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
        paramAnonymousObject = (MHServiceDate)paramAnonymousObject;
        int i;
        if ((paramAnonymousObject != null) && ("0".equals(((MHServiceDate)paramAnonymousObject).getStatus())) && (((MHServiceDate)paramAnonymousObject).getData() != null))
        {
          MovingServiceTimeActivity.b(MovingServiceTimeActivity.this, ((MHServiceDate)paramAnonymousObject).getData().getMoveOrderDate());
          MovingServiceTimeActivity.i(MovingServiceTimeActivity.this).setData(MovingServiceTimeActivity.h(MovingServiceTimeActivity.this));
          if (MovingServiceTimeActivity.f(MovingServiceTimeActivity.this)) {
            if (MovingServiceTimeActivity.h(MovingServiceTimeActivity.this) != null)
            {
              paramAnonymousInt = 0;
              if (paramAnonymousInt >= MovingServiceTimeActivity.h(MovingServiceTimeActivity.this).size()) {
                break label235;
              }
              if (((MHServiceDate.DataBean.MoveOrderDateBean)MovingServiceTimeActivity.h(MovingServiceTimeActivity.this).get(paramAnonymousInt)).getDateKey() != MovingServiceTimeActivity.j(MovingServiceTimeActivity.this)) {
                break label159;
              }
              i = 1;
              MovingServiceTimeActivity.a(MovingServiceTimeActivity.this, paramAnonymousInt);
            }
          }
        }
        label159:
        label235:
        for (paramAnonymousInt = i;; paramAnonymousInt = 0)
        {
          if (paramAnonymousInt == 0) {
            MovingServiceTimeActivity.a(MovingServiceTimeActivity.this, 0);
          }
          return;
          paramAnonymousInt += 1;
          break;
          MovingServiceTimeActivity.a(MovingServiceTimeActivity.this, 0);
          return;
          if ((paramAnonymousObject != null) && (!TextUtils.isEmpty(((MHServiceDate)paramAnonymousObject).getMessage())))
          {
            g.textToast(MovingServiceTimeActivity.d(MovingServiceTimeActivity.this), ((MHServiceDate)paramAnonymousObject).getMessage());
            MovingServiceTimeActivity.a(MovingServiceTimeActivity.this, false);
            return;
          }
          g.textToast(MovingServiceTimeActivity.d(MovingServiceTimeActivity.this), "网络数据请求失败!");
          MovingServiceTimeActivity.a(MovingServiceTimeActivity.this, false);
          return;
        }
      }
    });
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
    if (this.v > 0L)
    {
      paramView = getIntent();
      paramView.putExtra("moveTime", this.v);
      paramView.putExtra("selectDate", this.w);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/activity/MovingServiceTimeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */