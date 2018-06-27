package com.ziroom.ziroomcustomer.newclean.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.b;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.g;
import com.freelxl.baselibrary.f.h;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.j;
import com.ziroom.ziroomcustomer.e.c.k;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newServiceList.activity.ZiroomOrderListActivity;
import com.ziroom.ziroomcustomer.ziroomstation.dialog.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BiweeklyCleanModifyActivity
  extends BaseActivity
{
  private Map<String, String> A;
  private List<String> B;
  private com.ziroom.ziroomcustomer.ziroomstation.dialog.a C;
  private TextView a;
  private EditText b;
  private TextView c;
  private Button d;
  private String e;
  private String f;
  private String g;
  private String r;
  private String s;
  private String t;
  private String u;
  private String v;
  private String w;
  private String x;
  private Map<String, String> y;
  private List<String> z;
  
  private void a()
  {
    b();
    this.a = ((TextView)findViewById(2131690041));
    this.b = ((EditText)findViewById(2131689811));
    this.c = ((TextView)findViewById(2131690042));
    this.d = ((Button)findViewById(2131689816));
  }
  
  private void b()
  {
    ((ImageView)findViewById(2131691493)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        BiweeklyCleanModifyActivity.this.setResult(0);
        BiweeklyCleanModifyActivity.this.finish();
      }
    });
    findViewById(2131696484).setVisibility(8);
    ImageView localImageView = (ImageView)findViewById(2131696483);
    localImageView.setImageResource(2130838677);
    localImageView.setVisibility(0);
    localImageView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (ApplicationEx.c.isLoginState())
        {
          paramAnonymousView = new Intent(BiweeklyCleanModifyActivity.this, ZiroomOrderListActivity.class);
          BiweeklyCleanModifyActivity.this.startActivity(paramAnonymousView);
          return;
        }
        com.ziroom.commonlibrary.login.a.startLoginActivity(BiweeklyCleanModifyActivity.this);
      }
    });
    ((TextView)findViewById(2131689541)).setText("改约");
  }
  
  private void e()
  {
    Intent localIntent = getIntent();
    this.e = localIntent.getStringExtra("contractAddress");
    this.f = localIntent.getStringExtra("uid");
    this.g = localIntent.getStringExtra("billId");
    this.r = localIntent.getStringExtra("rentContractCode");
    this.s = localIntent.getStringExtra("hireContractCode");
    this.t = localIntent.getStringExtra("name");
    this.u = localIntent.getStringExtra("phone");
    this.v = localIntent.getStringExtra("datetime");
    this.w = localIntent.getStringExtra("date");
    this.x = localIntent.getStringExtra("time");
    this.a.setText(this.e);
    this.b.setText(this.u);
    this.c.setText(this.v);
  }
  
  private void f()
  {
    int i;
    if ((this.z == null) || (this.z.size() == 0))
    {
      g();
      i = 0;
      if ((this.B != null) && (this.B.size() != 0)) {
        break label113;
      }
      h();
    }
    for (;;)
    {
      if ((i == 2) && (this.C == null))
      {
        this.C = new com.ziroom.ziroomcustomer.ziroomstation.dialog.a(this, "服务时间", new a.b()
        {
          public void callBack(HashMap<Integer, String> paramAnonymousHashMap)
          {
            String str = (String)paramAnonymousHashMap.get(Integer.valueOf(0));
            paramAnonymousHashMap = (String)paramAnonymousHashMap.get(Integer.valueOf(1));
            BiweeklyCleanModifyActivity.a(BiweeklyCleanModifyActivity.this, (String)BiweeklyCleanModifyActivity.a(BiweeklyCleanModifyActivity.this).get(str));
            BiweeklyCleanModifyActivity.b(BiweeklyCleanModifyActivity.this, (String)BiweeklyCleanModifyActivity.b(BiweeklyCleanModifyActivity.this).get(paramAnonymousHashMap));
            BiweeklyCleanModifyActivity.c(BiweeklyCleanModifyActivity.this).setText(str + " " + paramAnonymousHashMap);
          }
        }, new List[] { this.z, this.B });
        this.C.show();
      }
      return;
      i = 1;
      break;
      label113:
      i += 1;
    }
  }
  
  private void g()
  {
    n.getBiweeklyCleanAllDate(this, this.f, this.g, new com.ziroom.ziroomcustomer.e.a.a(this, new j(new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onSuccess(int paramAnonymousInt, b paramAnonymousb)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousb);
        if ((paramAnonymousb != null) && (paramAnonymousb.size() > 0))
        {
          BiweeklyCleanModifyActivity.a(BiweeklyCleanModifyActivity.this, new HashMap());
          BiweeklyCleanModifyActivity.a(BiweeklyCleanModifyActivity.this, new ArrayList());
          paramAnonymousInt = 0;
          while (paramAnonymousInt < paramAnonymousb.size())
          {
            e locale = paramAnonymousb.getJSONObject(paramAnonymousInt);
            if ((locale != null) && (locale.containsKey("value")) && (locale.containsKey("key")))
            {
              BiweeklyCleanModifyActivity.a(BiweeklyCleanModifyActivity.this).put(locale.getString("key"), locale.getString("value"));
              BiweeklyCleanModifyActivity.d(BiweeklyCleanModifyActivity.this).add(locale.getString("key"));
            }
            paramAnonymousInt += 1;
          }
          if ((BiweeklyCleanModifyActivity.e(BiweeklyCleanModifyActivity.this) != null) && (BiweeklyCleanModifyActivity.e(BiweeklyCleanModifyActivity.this).size() > 0)) {
            BiweeklyCleanModifyActivity.f(BiweeklyCleanModifyActivity.this);
          }
        }
      }
    });
  }
  
  private void h()
  {
    n.getBiweeklyCleanAllTime(this, new com.ziroom.ziroomcustomer.e.a.a(this, new j(new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onSuccess(int paramAnonymousInt, b paramAnonymousb)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousb);
        if ((paramAnonymousb != null) && (paramAnonymousb.size() > 0))
        {
          BiweeklyCleanModifyActivity.b(BiweeklyCleanModifyActivity.this, new HashMap());
          BiweeklyCleanModifyActivity.b(BiweeklyCleanModifyActivity.this, new ArrayList());
          paramAnonymousInt = 0;
          while (paramAnonymousInt < paramAnonymousb.size())
          {
            e locale = paramAnonymousb.getJSONObject(paramAnonymousInt);
            if ((locale != null) && (locale.containsKey("value")) && (locale.containsKey("key")))
            {
              BiweeklyCleanModifyActivity.b(BiweeklyCleanModifyActivity.this).put(locale.getString("value"), locale.getString("key"));
              BiweeklyCleanModifyActivity.e(BiweeklyCleanModifyActivity.this).add(locale.getString("value"));
            }
            paramAnonymousInt += 1;
          }
          if ((BiweeklyCleanModifyActivity.d(BiweeklyCleanModifyActivity.this) != null) && (BiweeklyCleanModifyActivity.d(BiweeklyCleanModifyActivity.this).size() > 0)) {
            BiweeklyCleanModifyActivity.f(BiweeklyCleanModifyActivity.this);
          }
        }
      }
    });
  }
  
  private void i()
  {
    Intent localIntent = getIntent();
    this.u = VdsAgent.trackEditTextSilent(this.b).toString();
    if (!h.isMobile(this.u))
    {
      g.textToast(this, "请输入正确的手机号！");
      return;
    }
    if ((TextUtils.isEmpty(this.w)) || (TextUtils.isEmpty(this.x)))
    {
      g.textToast(this, "你什么都没有改哦~");
      setResult(0);
      finish();
      return;
    }
    if ((this.u.equals(localIntent.getStringExtra("phone"))) && (this.w.equals(localIntent.getStringExtra("date"))) && (this.x.equals(localIntent.getStringExtra("time"))))
    {
      g.textToast(this, "你什么都没有改哦~");
      setResult(0);
      finish();
      return;
    }
    n.postBiweeklyCleanModify(this, this.f, this.g, this.r, this.s, this.w, this.u, this.t, this.x, new com.ziroom.ziroomcustomer.e.a.a(this, new k(new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        BiweeklyCleanModifyActivity.this.setResult(-1);
        paramAnonymouse = new Intent(BiweeklyCleanModifyActivity.this, BiweeklyCleanModifySuccessActivity.class);
        paramAnonymouse.putExtras(BiweeklyCleanModifyActivity.this.getIntent().getExtras());
        BiweeklyCleanModifyActivity.this.startActivityAndFinish(paramAnonymouse);
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903113);
    a();
    e();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690042: 
      if ((this.C != null) && (!this.C.isShowing()))
      {
        this.C.show();
        return;
      }
      f();
      return;
    }
    i();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/BiweeklyCleanModifyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */