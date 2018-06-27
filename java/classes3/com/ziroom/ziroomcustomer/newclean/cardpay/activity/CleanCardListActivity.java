package com.ziroom.ziroomcustomer.newclean.cardpay.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.home.bean.HomePageBannerInfo;
import com.ziroom.ziroomcustomer.home.bean.HomePageBannerInfo.DataBean;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newclean.cardpay.adapter.e;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CleanCard;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import com.ziroom.ziroomcustomer.util.u;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CleanCardListActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private RelativeLayout A;
  private RelativeLayout B;
  private LinearLayout C;
  private View D;
  private String E;
  private LinearLayout F;
  private TextView G;
  private TextView H;
  private BroadcastReceiver I = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("refresh_card"))
      {
        if (CleanCardListActivity.a(CleanCardListActivity.this) != null) {
          CleanCardListActivity.a(CleanCardListActivity.this).clear();
        }
        if (CleanCardListActivity.b(CleanCardListActivity.this) != null) {
          CleanCardListActivity.b(CleanCardListActivity.this).clear();
        }
        if (CleanCardListActivity.c(CleanCardListActivity.this) != null) {
          CleanCardListActivity.c(CleanCardListActivity.this).clear();
        }
        CleanCardListActivity.d(CleanCardListActivity.this);
      }
    }
  };
  private com.freelxl.baselibrary.d.c.a J = new com.freelxl.baselibrary.d.c.a(new com.freelxl.baselibrary.d.f.d(HomePageBannerInfo.class))
  {
    public void onFailure(Throwable paramAnonymousThrowable) {}
    
    public void onSuccess(int paramAnonymousInt, HomePageBannerInfo paramAnonymousHomePageBannerInfo)
    {
      if ((paramAnonymousInt == 200) && (paramAnonymousHomePageBannerInfo != null) && (paramAnonymousHomePageBannerInfo.getData() != null) && (paramAnonymousHomePageBannerInfo.getData().size() > 0))
      {
        CleanCardListActivity.a(CleanCardListActivity.this, ((HomePageBannerInfo.DataBean)paramAnonymousHomePageBannerInfo.getData().get(0)).getPic());
        com.freelxl.baselibrary.f.d.d("CleanCardListActivity", "====" + CleanCardListActivity.j(CleanCardListActivity.this));
        if ((CleanCardListActivity.f(CleanCardListActivity.this).getVisibility() == 0) && (!TextUtils.isEmpty(CleanCardListActivity.j(CleanCardListActivity.this)))) {
          CleanCardListActivity.f(CleanCardListActivity.this).setController(c.frescoController(CleanCardListActivity.j(CleanCardListActivity.this)));
        }
      }
    }
  };
  private Context a;
  private ImageView b;
  private TextView c;
  private ListViewForScrollView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private List<CleanCard> r = new ArrayList();
  private List<CleanCard> s = new ArrayList();
  private List<CleanCard> t = new ArrayList();
  private e u;
  private Intent v;
  private int w = 111;
  private UserInfo x;
  private RelativeLayout y;
  private SimpleDraweeView z;
  
  private void a()
  {
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((TextView)findViewById(2131690242));
    this.d = ((ListViewForScrollView)findViewById(2131690240));
    this.e = ((TextView)findViewById(2131690247));
    this.f = ((TextView)findViewById(2131690244));
    this.g = ((TextView)findViewById(2131690191));
    this.y = ((RelativeLayout)findViewById(2131690202));
    this.z = ((SimpleDraweeView)findViewById(2131690241));
    this.A = ((RelativeLayout)findViewById(2131690246));
    this.B = ((RelativeLayout)findViewById(2131690248));
    this.C = ((LinearLayout)findViewById(2131690243));
    this.D = findViewById(2131690245);
    this.F = ((LinearLayout)findViewById(2131690249));
    this.G = ((TextView)findViewById(2131690250));
    this.H = ((TextView)findViewById(2131690251));
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.B.setOnClickListener(this);
    this.G.setOnClickListener(this);
    this.H.setOnClickListener(this);
    this.u = new e(this.a, this.s);
    this.d.setAdapter(this.u);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("refresh_card");
    registerReceiver(this.I, localIntentFilter);
    this.G.getPaint().setFlags(8);
    this.G.getPaint().setAntiAlias(true);
    this.H.getPaint().setFlags(8);
    this.H.getPaint().setAntiAlias(true);
    this.C.setVisibility(8);
    this.D.setVisibility(8);
  }
  
  private void b()
  {
    n.getServiceBanner(this, 3076, "110000", this.J);
    this.x = ApplicationEx.c.getUser();
    if (this.x != null) {
      n.getCleanCardList(this.a, this.x.getUid(), new a(), false);
    }
  }
  
  private void e()
  {
    this.v = new Intent(this.a, CleanActiviteCardActivity.class);
    startActivityForResult(this.v, this.w);
  }
  
  private void f()
  {
    this.v = new Intent(this.a, CleanBuyCardActivity.class);
    startActivity(this.v);
  }
  
  private void g()
  {
    this.v = new Intent(this.a, CleanCardDetailActivity.class);
    startActivity(this.v);
  }
  
  private void h()
  {
    this.v = new Intent(this.a, CleanCancleCardActivity.class);
    this.v.putExtra("cancleList", (Serializable)this.t);
    startActivity(this.v);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == this.w) && (paramInt2 == -1))
    {
      if (this.r != null) {
        this.r.clear();
      }
      if (this.s != null) {
        this.s.clear();
      }
      if (this.t != null) {
        this.t.clear();
      }
      b();
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    case 2131690242: 
      g();
      return;
    case 2131690247: 
      h();
      return;
    case 2131690246: 
      h();
      return;
    case 2131690248: 
      h();
      return;
    case 2131690244: 
      f();
      return;
    case 2131690191: 
      e();
      return;
    case 2131690250: 
      this.v = new Intent(this.a, CleanStoredCardBuyActivity.class);
      startActivity(this.v);
      return;
    }
    h();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903140);
    this.a = this;
    a();
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      if (this.I != null) {
        unregisterReceiver(this.I);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, com.freelxl.baselibrary.e.k paramk)
    {
      u.d("dsgdsgh:", "===== " + com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      paramString = com.alibaba.fastjson.a.parseObject(com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      String str = (String)paramString.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        if (paramString.get("data") != null) {
          paramk.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), CleanCard.class));
        }
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("message"));
    }
    
    public void onSuccess(com.freelxl.baselibrary.e.k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        CleanCardListActivity.a(CleanCardListActivity.this, (List)paramk.getObject());
        CleanCardListActivity.b(CleanCardListActivity.this).clear();
        if ((CleanCardListActivity.a(CleanCardListActivity.this) != null) && (CleanCardListActivity.a(CleanCardListActivity.this).size() > 0))
        {
          paramk = CleanCardListActivity.a(CleanCardListActivity.this).iterator();
          while (paramk.hasNext())
          {
            CleanCard localCleanCard = (CleanCard)paramk.next();
            if (localCleanCard.getCardState() == 2) {
              CleanCardListActivity.b(CleanCardListActivity.this).add(localCleanCard);
            } else {
              CleanCardListActivity.c(CleanCardListActivity.this).add(localCleanCard);
            }
          }
          CleanCardListActivity.e(CleanCardListActivity.this).notifyDataSetChanged();
          if (CleanCardListActivity.b(CleanCardListActivity.this).size() == 0)
          {
            CleanCardListActivity.f(CleanCardListActivity.this).setVisibility(8);
            CleanCardListActivity.g(CleanCardListActivity.this).setVisibility(8);
            CleanCardListActivity.h(CleanCardListActivity.this).setVisibility(0);
            CleanCardListActivity.i(CleanCardListActivity.this).setVisibility(0);
          }
          if (CleanCardListActivity.b(CleanCardListActivity.this).size() > 0)
          {
            CleanCardListActivity.f(CleanCardListActivity.this).setVisibility(8);
            CleanCardListActivity.h(CleanCardListActivity.this).setVisibility(0);
            CleanCardListActivity.g(CleanCardListActivity.this).setVisibility(0);
            CleanCardListActivity.i(CleanCardListActivity.this).setVisibility(8);
          }
          return;
        }
        CleanCardListActivity.f(CleanCardListActivity.this).setVisibility(8);
        if (!TextUtils.isEmpty(CleanCardListActivity.j(CleanCardListActivity.this))) {
          CleanCardListActivity.f(CleanCardListActivity.this).setController(c.frescoController(CleanCardListActivity.j(CleanCardListActivity.this)));
        }
        CleanCardListActivity.h(CleanCardListActivity.this).setVisibility(8);
        CleanCardListActivity.g(CleanCardListActivity.this).setVisibility(8);
        CleanCardListActivity.k(CleanCardListActivity.this).setBackgroundColor(Color.parseColor("#51000000"));
        CleanCardListActivity.l(CleanCardListActivity.this).setTextColor(-1);
        CleanCardListActivity.m(CleanCardListActivity.this).setTextColor(-1);
        CleanCardListActivity.n(CleanCardListActivity.this).setVisibility(8);
        CleanCardListActivity.o(CleanCardListActivity.this).setVisibility(8);
        CleanCardListActivity.i(CleanCardListActivity.this).setVisibility(0);
        return;
      }
      CleanCardListActivity.f(CleanCardListActivity.this).setVisibility(8);
      if (!TextUtils.isEmpty(CleanCardListActivity.j(CleanCardListActivity.this))) {
        CleanCardListActivity.f(CleanCardListActivity.this).setController(c.frescoController(CleanCardListActivity.j(CleanCardListActivity.this)));
      }
      CleanCardListActivity.k(CleanCardListActivity.this).setBackgroundColor(Color.parseColor("#51000000"));
      CleanCardListActivity.h(CleanCardListActivity.this).setVisibility(8);
      CleanCardListActivity.l(CleanCardListActivity.this).setTextColor(-1);
      CleanCardListActivity.m(CleanCardListActivity.this).setTextColor(-1);
      CleanCardListActivity.g(CleanCardListActivity.this).setVisibility(8);
      if (!TextUtils.isEmpty(paramk.getMessage())) {
        g.textToast(CleanCardListActivity.p(CleanCardListActivity.this), paramk.getMessage());
      }
      CleanCardListActivity.n(CleanCardListActivity.this).setVisibility(8);
      CleanCardListActivity.o(CleanCardListActivity.this).setVisibility(8);
      CleanCardListActivity.i(CleanCardListActivity.this).setVisibility(0);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/activity/CleanCardListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */