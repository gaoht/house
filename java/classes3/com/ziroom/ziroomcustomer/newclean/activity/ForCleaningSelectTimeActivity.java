package com.ziroom.ziroomcustomer.newclean.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.freelxl.baselibrary.d.f.a;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.e;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newServiceList.utils.i;
import com.ziroom.ziroomcustomer.newclean.b.ad;
import com.ziroom.ziroomcustomer.newclean.b.b;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newclean.d.an;
import com.ziroom.ziroomcustomer.newclean.d.ay;
import com.ziroom.ziroomcustomer.newclean.d.bj;
import com.ziroom.ziroomcustomer.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForCleaningSelectTimeActivity
  extends BaseActivity
{
  private HorizontalListView a;
  private MyGridView b;
  private ForCleaningSelectTimeActivity c;
  private List<an> d = new ArrayList();
  private List<ay> e = new ArrayList();
  private ad f;
  private b g;
  private List<bj> r = new ArrayList();
  private List<String> s = new ArrayList();
  private String t;
  private String u;
  private TextView v;
  private String w;
  
  private void a()
  {
    this.a = ((HorizontalListView)findViewById(2131689972));
    this.b = ((MyGridView)findViewById(2131689973));
    this.v = ((TextView)findViewById(2131689956));
  }
  
  private void b()
  {
    this.w = getIntent().getStringExtra("workBillId");
    this.f = new ad(this.c, this.r);
    this.a.setAdapter(this.f);
    this.g = new b(4, this.e, this.c);
    this.b.setAdapter(this.g);
    f();
  }
  
  private void e()
  {
    findViewById(2131689492).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ForCleaningSelectTimeActivity.this.finish();
      }
    });
    this.a.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        ForCleaningSelectTimeActivity.a(ForCleaningSelectTimeActivity.this).setSelectPosition(paramAnonymousInt);
        ForCleaningSelectTimeActivity.a(ForCleaningSelectTimeActivity.this, (String)ForCleaningSelectTimeActivity.b(ForCleaningSelectTimeActivity.this).get(paramAnonymousInt));
        ForCleaningSelectTimeActivity.b(ForCleaningSelectTimeActivity.this, "");
        ForCleaningSelectTimeActivity.c(ForCleaningSelectTimeActivity.this);
      }
    });
    this.b.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if ("0".equals(((ay)ForCleaningSelectTimeActivity.d(ForCleaningSelectTimeActivity.this).get(paramAnonymousInt)).getFlag()))
        {
          if (ForCleaningSelectTimeActivity.e(ForCleaningSelectTimeActivity.this) != null) {
            ForCleaningSelectTimeActivity.e(ForCleaningSelectTimeActivity.this).setSelectPosition(paramAnonymousInt);
          }
          ForCleaningSelectTimeActivity.b(ForCleaningSelectTimeActivity.this, ((ay)ForCleaningSelectTimeActivity.d(ForCleaningSelectTimeActivity.this).get(paramAnonymousInt)).getDatePlan());
          return;
        }
        g.textToast(ForCleaningSelectTimeActivity.f(ForCleaningSelectTimeActivity.this), "已约满，请选择其他时间");
      }
    });
    this.v.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (TextUtils.isEmpty(ForCleaningSelectTimeActivity.g(ForCleaningSelectTimeActivity.this)))
        {
          g.textToast(ForCleaningSelectTimeActivity.f(ForCleaningSelectTimeActivity.this), "请先选择日期");
          return;
        }
        if (TextUtils.isEmpty(ForCleaningSelectTimeActivity.h(ForCleaningSelectTimeActivity.this)))
        {
          g.textToast(ForCleaningSelectTimeActivity.f(ForCleaningSelectTimeActivity.this), "请先选择时间点");
          return;
        }
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("appointDateTime", ForCleaningSelectTimeActivity.h(ForCleaningSelectTimeActivity.this));
        ForCleaningSelectTimeActivity.this.setResult(-1, paramAnonymousView);
        ForCleaningSelectTimeActivity.this.finish();
      }
    });
  }
  
  private void f()
  {
    if (TextUtils.isEmpty(this.w)) {
      return;
    }
    n.getForCleaningData(this.c, this.w, new d(this.c, new e(an.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        ForCleaningSelectTimeActivity.this.finish();
      }
      
      public void onSuccess(int paramAnonymousInt, List<an> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        if (paramAnonymousList != null)
        {
          ForCleaningSelectTimeActivity.i(ForCleaningSelectTimeActivity.this).clear();
          ForCleaningSelectTimeActivity.i(ForCleaningSelectTimeActivity.this).addAll(paramAnonymousList);
          ForCleaningSelectTimeActivity.b(ForCleaningSelectTimeActivity.this).clear();
          ForCleaningSelectTimeActivity.j(ForCleaningSelectTimeActivity.this).clear();
          if ((ForCleaningSelectTimeActivity.i(ForCleaningSelectTimeActivity.this) != null) && (ForCleaningSelectTimeActivity.i(ForCleaningSelectTimeActivity.this).size() > 0))
          {
            paramAnonymousList = paramAnonymousList.iterator();
            while (paramAnonymousList.hasNext())
            {
              Object localObject = (an)paramAnonymousList.next();
              ForCleaningSelectTimeActivity.b(ForCleaningSelectTimeActivity.this).add(((an)localObject).getDate());
              String str = ((an)localObject).getWeek();
              localObject = i.getCandleTime(((an)localObject).getDate());
              ForCleaningSelectTimeActivity.j(ForCleaningSelectTimeActivity.this).add(new bj((String)localObject, str));
            }
          }
          ForCleaningSelectTimeActivity.a(ForCleaningSelectTimeActivity.this).notifyDataSetChanged();
          ForCleaningSelectTimeActivity.a(ForCleaningSelectTimeActivity.this, ((an)ForCleaningSelectTimeActivity.i(ForCleaningSelectTimeActivity.this).get(0)).getDate());
          ForCleaningSelectTimeActivity.a(ForCleaningSelectTimeActivity.this).setSelectPosition(0);
          ForCleaningSelectTimeActivity.c(ForCleaningSelectTimeActivity.this);
        }
      }
    });
  }
  
  private void g()
  {
    n.getForCleaningTimePoint(this.c, this.w, this.t, new d(this.c, new e(ay.class))
    {
      public void onSuccess(int paramAnonymousInt, List<ay> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
        {
          ForCleaningSelectTimeActivity.d(ForCleaningSelectTimeActivity.this).clear();
          ForCleaningSelectTimeActivity.d(ForCleaningSelectTimeActivity.this).addAll(paramAnonymousList);
          ForCleaningSelectTimeActivity.e(ForCleaningSelectTimeActivity.this).notifyDataSetChanged();
          ForCleaningSelectTimeActivity.e(ForCleaningSelectTimeActivity.this).setSelectPosition(-1);
        }
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903178);
    this.c = this;
    a();
    b();
    e();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/ForCleaningSelectTimeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */