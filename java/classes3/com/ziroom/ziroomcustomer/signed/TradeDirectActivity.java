package com.ziroom.ziroomcustomer.signed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.e.k;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.signed.a.p;
import com.ziroom.ziroomcustomer.util.s;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.ziroomstation.utils.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TradeDirectActivity
  extends BaseActivity
{
  int a = 0;
  int b = -1;
  private List<p> c;
  private com.ziroom.ziroomcustomer.signed.adapter.b d;
  private com.ziroom.ziroomcustomer.signed.adapter.b e;
  private p f;
  private p g;
  @BindView(2131692610)
  ListView lv_direct;
  @BindView(2131692609)
  ListView lv_trade;
  private f<String> r = new f(this, new com.ziroom.ziroomcustomer.e.c.q(String.class))
  {
    public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousString);
      u.e("TradeDirectActivity", "onSuccess:获取行业方向成功 " + paramAnonymousString);
      paramAnonymousString = h.getJsonString(paramAnonymousString, "industryList");
      TradeDirectActivity.a(TradeDirectActivity.this, h.parseArray(paramAnonymousString, p.class));
      u.e("TradeDirectActivity", "onSuccess: Model: " + TradeDirectActivity.a(TradeDirectActivity.this));
      TradeDirectActivity.b(TradeDirectActivity.this);
    }
  };
  @BindView(2131695950)
  TextView tv_rightButton;
  @BindView(2131695949)
  TextView tv_title;
  
  private void a()
  {
    Object localObject = getIntent();
    String str = ((Intent)localObject).getStringExtra("selected");
    localObject = ((Intent)localObject).getStringExtra("selectedDirected");
    this.f = ((p)h.parseObject(str, p.class));
    this.g = ((p)h.parseObject((String)localObject, p.class));
  }
  
  private void b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", g.getToken());
    com.freelxl.baselibrary.d.a.get(com.ziroom.ziroomcustomer.e.q.O + e.k.c).tag(this).addHeader("Accept", "application/json; version=1").params(g.getPassportSign(localHashMap)).enqueue(this.r);
  }
  
  private void e()
  {
    this.d.setListener(new a()
    {
      public void onClick(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        TradeDirectActivity.this.b = paramAnonymousInt1;
        Object localObject = (p)TradeDirectActivity.a(TradeDirectActivity.this).get(paramAnonymousInt1);
        if (("HYSTUDENT".equals(((p)localObject).getCode())) || ("学生".equals(((p)localObject).getName())))
        {
          ((p)localObject).setAspects(new ArrayList());
          TradeDirectActivity.this.sendTradeDirectInfo();
          return;
        }
        if (TradeDirectActivity.this.lv_direct.getVisibility() == 8) {
          TradeDirectActivity.this.lv_direct.setVisibility(0);
        }
        localObject = ((p)localObject).getAspects();
        TradeDirectActivity.c(TradeDirectActivity.this).setList((List)localObject);
        TradeDirectActivity.c(TradeDirectActivity.this).notifyDataSetChanged();
      }
    });
    this.e.setListener(new a()
    {
      public void onClick(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        TradeDirectActivity.this.a = paramAnonymousInt1;
        TradeDirectActivity.this.sendTradeDirectInfo();
      }
    });
  }
  
  private void f()
  {
    Object localObject1;
    String str;
    int i;
    if (!s.isEmpty(this.c))
    {
      this.d.setList(this.c);
      if (this.f != null)
      {
        localObject1 = this.f.getId();
        str = this.f.getName();
        if ((localObject1 != null) && (str != null)) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      Object localObject2;
      if (i < this.c.size())
      {
        localObject2 = (p)this.c.get(i);
        if ((localObject2 == null) || (!str.equals(((p)localObject2).getName())) || (!((String)localObject1).equals(((p)localObject2).getId()))) {
          break label423;
        }
        this.b = i;
        this.d.setCurrentPos(this.b);
        localObject1 = ((p)localObject2).getAspects();
        if ((this.g != null) && (!s.isEmpty((List)localObject1)))
        {
          str = this.g.getId();
          localObject2 = this.g.getName();
          if ((str != null) && (localObject2 != null)) {
            i = 0;
          }
        }
      }
      for (;;)
      {
        if (i < ((List)localObject1).size())
        {
          if ((!str.equals(((p)((List)localObject1).get(i)).getId())) || (!((String)localObject2).equals(((p)((List)localObject1).get(i)).getName()))) {
            break label416;
          }
          this.a = i;
          this.g = ((p)((List)localObject1).get(i));
          this.e.setList(((p)this.c.get(this.b)).getAspects());
          this.e.setCurrentPos(this.a);
          if (this.lv_direct.getVisibility() == 8) {
            this.lv_direct.setVisibility(0);
          }
        }
        this.d.notifyDataSetChanged();
        this.e.notifyDataSetChanged();
        if ((this.b > 0) && (this.b < this.c.size()))
        {
          this.lv_trade.smoothScrollToPosition(this.b);
          localObject1 = ((p)this.c.get(this.b)).getAspects();
          if ((this.a > 0) && (this.g != null) && (!s.isEmpty((List)localObject1)) && (this.a < ((List)localObject1).size())) {
            this.lv_direct.smoothScrollToPosition(this.a);
          }
        }
        return;
        label416:
        i += 1;
      }
      label423:
      i += 1;
    }
  }
  
  private void g()
  {
    this.tv_title.setText("行业/方向");
    this.tv_rightButton.setVisibility(8);
  }
  
  @OnClick({2131695948, 2131695950})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903536);
    ButterKnife.bind(this);
    g();
    a();
    this.d = new com.ziroom.ziroomcustomer.signed.adapter.b(this, 1, null);
    this.e = new com.ziroom.ziroomcustomer.signed.adapter.b(this, 2, null);
    this.lv_trade.setAdapter(this.d);
    this.lv_direct.setAdapter(this.e);
    e();
    b();
  }
  
  public void sendTradeDirectInfo()
  {
    String str = com.alibaba.fastjson.a.toJSONString((p)this.c.get(this.b));
    Intent localIntent = new Intent();
    localIntent.putExtra("trade", str);
    localIntent.putExtra("directPos", this.a);
    setResult(200, localIntent);
    finish();
  }
  
  public static abstract interface a
  {
    public abstract void onClick(int paramInt1, int paramInt2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/TradeDirectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */