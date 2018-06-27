package com.ziroom.ziroomcustomer.minsu.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuDateBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuDateBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLLHouseListBean;
import com.ziroom.ziroomcustomer.minsu.f.l;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.ziroomstation.dialog.a.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MinsuSetHouseTodayDiscountActivity
  extends BaseActivity
{
  private String a;
  private String b;
  private int c;
  private String d;
  private String e;
  private TextView f;
  private TextView g;
  private TextView r;
  private List<String> s = new ArrayList();
  private List<String> t = new ArrayList();
  private com.ziroom.ziroomcustomer.ziroomstation.dialog.a u;
  private com.ziroom.ziroomcustomer.ziroomstation.dialog.a v;
  private String w;
  private String x;
  private LinearLayout y;
  private LinearLayout z;
  
  private void a()
  {
    Object localObject = getIntent();
    this.a = ((Intent)localObject).getStringExtra("houseFid");
    this.b = ((Intent)localObject).getStringExtra("roomFid");
    this.c = ((Intent)localObject).getIntExtra("rentWay", 1);
    this.e = ((Intent)localObject).getStringExtra("setHintUrl");
    this.d = ((Intent)localObject).getStringExtra("saveHint");
    localObject = getResources().getStringArray(2131361823);
    int i = 0;
    while (i < localObject.length)
    {
      this.s.add(localObject[i]);
      i += 1;
    }
    this.g = ((TextView)findViewById(2131692339));
    this.r = ((TextView)findViewById(2131692341));
    this.y = ((LinearLayout)findViewById(2131692338));
    this.z = ((LinearLayout)findViewById(2131692340));
    localObject = (SimpleDraweeView)findViewById(2131692342);
    ((SimpleDraweeView)localObject).setController(com.freelxl.baselibrary.f.c.frescoController(this.e));
    ((SimpleDraweeView)localObject).setHierarchy(com.ziroom.ziroomcustomer.minsu.f.d.getHierarchy(this));
    this.f = ((TextView)findViewById(2131692343));
    findViewById(2131692337).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuSetHouseTodayDiscountActivity.this.finish();
      }
    });
    findViewById(2131692343).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuSetHouseTodayDiscountActivity.a(MinsuSetHouseTodayDiscountActivity.this);
      }
    });
    this.y.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (MinsuSetHouseTodayDiscountActivity.b(MinsuSetHouseTodayDiscountActivity.this) != null) {
          MinsuSetHouseTodayDiscountActivity.b(MinsuSetHouseTodayDiscountActivity.this).show();
        }
      }
    });
    this.z.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuSetHouseTodayDiscountActivity.c(MinsuSetHouseTodayDiscountActivity.this);
      }
    });
    e();
    this.u = new com.ziroom.ziroomcustomer.ziroomstation.dialog.a(this, "请选择折扣", new a.b()
    {
      public void callBack(HashMap<Integer, String> paramAnonymousHashMap)
      {
        MinsuSetHouseTodayDiscountActivity.a(MinsuSetHouseTodayDiscountActivity.this, ((String)paramAnonymousHashMap.get(Integer.valueOf(0))).replace("折", ""));
        MinsuSetHouseTodayDiscountActivity.d(MinsuSetHouseTodayDiscountActivity.this).setText((CharSequence)paramAnonymousHashMap.get(Integer.valueOf(0)));
        MinsuSetHouseTodayDiscountActivity.e(MinsuSetHouseTodayDiscountActivity.this);
      }
    }, new List[] { this.s });
  }
  
  private void b()
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this).setTitle("提示").setContent(this.d).setCanceledOnTouchOutside(false).setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          MinsuSetHouseTodayDiscountActivity.f(MinsuSetHouseTodayDiscountActivity.this);
        }
      }
    }).build().show();
  }
  
  private void e()
  {
    if ((!TextUtils.isEmpty(this.w)) && (!TextUtils.isEmpty(this.x)))
    {
      this.f.setClickable(true);
      this.f.setBackgroundColor(Color.parseColor("#FFA000"));
      return;
    }
    this.f.setClickable(false);
    this.f.setBackgroundColor(Color.parseColor("#DDDDDD"));
  }
  
  private void f()
  {
    if (TextUtils.isEmpty(this.g.getText().toString())) {
      return;
    }
    if (Integer.valueOf(this.x.substring(11, 13)).intValue() == 24) {}
    for (String str = this.x.substring(0, 11) + "23:59:59";; str = this.x)
    {
      com.ziroom.ziroomcustomer.minsu.e.a.setHouseTodayDiscount(this, this.a, this.b, String.valueOf(this.c), this.w, str, true, new s(this, new r(MinsuLLHouseListBean.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          StringBuilder localStringBuilder = new StringBuilder().append(" onFailure ");
          if (paramAnonymousThrowable == null) {}
          for (paramAnonymousThrowable = " e = null ";; paramAnonymousThrowable = " e.msg = " + paramAnonymousThrowable.getMessage())
          {
            l.e("error", paramAnonymousThrowable);
            return;
          }
        }
        
        public void onSuccess(int paramAnonymousInt, MinsuLLHouseListBean paramAnonymousMinsuLLHouseListBean)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousMinsuLLHouseListBean);
          if ((paramAnonymousMinsuLLHouseListBean != null) && (paramAnonymousMinsuLLHouseListBean.checkSuccess(MinsuSetHouseTodayDiscountActivity.this))) {
            MinsuSetHouseTodayDiscountActivity.this.finish();
          }
        }
      });
      return;
    }
  }
  
  private void g()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getTodayDiscountStartDate(this, true, new com.freelxl.baselibrary.d.c.a(new r(MinsuDateBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.freelxl.baselibrary.f.d.d("lanzhihong", Log.getStackTraceString(paramAnonymousThrowable.getCause()));
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuDateBean paramAnonymousMinsuDateBean)
      {
        if ((paramAnonymousMinsuDateBean == null) || (!paramAnonymousMinsuDateBean.checkSuccess(MinsuSetHouseTodayDiscountActivity.this)) || (paramAnonymousMinsuDateBean.getData() == null)) {
          return;
        }
        MinsuSetHouseTodayDiscountActivity.g(MinsuSetHouseTodayDiscountActivity.this).clear();
        paramAnonymousInt = Integer.valueOf(paramAnonymousMinsuDateBean.getData().getCurrentDate().substring(11, 13)).intValue();
        paramAnonymousMinsuDateBean = m.GetMinsuTodayDate();
        for (;;)
        {
          paramAnonymousInt += 1;
          if (paramAnonymousInt > 24)
          {
            Collections.reverse(MinsuSetHouseTodayDiscountActivity.g(MinsuSetHouseTodayDiscountActivity.this));
            MinsuSetHouseTodayDiscountActivity.a(MinsuSetHouseTodayDiscountActivity.this, new com.ziroom.ziroomcustomer.ziroomstation.dialog.a(MinsuSetHouseTodayDiscountActivity.this, "请选择截止时间", new a.b()
            {
              public void callBack(HashMap<Integer, String> paramAnonymous2HashMap)
              {
                MinsuSetHouseTodayDiscountActivity.b(MinsuSetHouseTodayDiscountActivity.this, (String)paramAnonymous2HashMap.get(Integer.valueOf(0)));
                MinsuSetHouseTodayDiscountActivity.i(MinsuSetHouseTodayDiscountActivity.this).setText(MinsuSetHouseTodayDiscountActivity.h(MinsuSetHouseTodayDiscountActivity.this));
                MinsuSetHouseTodayDiscountActivity.e(MinsuSetHouseTodayDiscountActivity.this);
              }
            }, new List[] { MinsuSetHouseTodayDiscountActivity.g(MinsuSetHouseTodayDiscountActivity.this) }));
            MinsuSetHouseTodayDiscountActivity.j(MinsuSetHouseTodayDiscountActivity.this).show();
            return;
          }
          MinsuSetHouseTodayDiscountActivity.g(MinsuSetHouseTodayDiscountActivity.this).add(paramAnonymousMinsuDateBean + String.valueOf(paramAnonymousInt) + ":00:00");
        }
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903482);
    a();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuSetHouseTodayDiscountActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */