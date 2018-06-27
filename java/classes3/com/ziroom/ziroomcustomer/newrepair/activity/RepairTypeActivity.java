package com.ziroom.ziroomcustomer.newrepair.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.a.e;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.home.view.HomeCListCtrlView.b;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.activity.RepairBuyCardActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.RepairOrderActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.RepairOrderNewActivity;
import com.ziroom.ziroomcustomer.newclean.d.bb;
import com.ziroom.ziroomcustomer.newclean.d.bm;
import com.ziroom.ziroomcustomer.newclean.d.bm.a;
import com.ziroom.ziroomcustomer.newclean.d.bm.b;
import com.ziroom.ziroomcustomer.newclean.view.ServiceRecyclerView;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.webview.HomeWebActivity;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.util.List;

public class RepairTypeActivity
  extends BaseActivity
  implements View.OnClickListener, ObservableScrollView.a
{
  private String A;
  private String B;
  private String C;
  private TextView D;
  private RelativeLayout a;
  private ImageView b;
  private TextView c;
  private View d;
  private ObservableScrollView e;
  private ListViewForScrollView f;
  private ServiceRecyclerView g;
  private Context r;
  private List<bb> s;
  private String t;
  private List<bm.b> u;
  private SimpleDraweeView v;
  private RelativeLayout w;
  private TextView x;
  private TextView y;
  private ImageView z;
  
  private void a()
  {
    this.r = this;
    this.a = ((RelativeLayout)findViewById(2131692321));
    this.b = ((ImageView)findViewById(2131690302));
    this.b.setFocusable(true);
    this.b.setFocusableInTouchMode(true);
    this.b.requestFocus();
    this.c = ((TextView)findViewById(2131690303));
    this.d = findViewById(2131690284);
    this.e = ((ObservableScrollView)findViewById(2131690263));
    this.v = ((SimpleDraweeView)findViewById(2131690304));
    this.f = ((ListViewForScrollView)findViewById(2131692318));
    this.g = ((ServiceRecyclerView)findViewById(2131692320));
    this.g.setClickable(true);
    ViewGroup.LayoutParams localLayoutParams = this.v.getLayoutParams();
    localLayoutParams.width = ac.getScreenWidth(this.r);
    localLayoutParams.height = (ac.getScreenWidth(this.r) * 27 / 50);
    this.v.setLayoutParams(localLayoutParams);
    this.w = ((RelativeLayout)findViewById(2131690265));
    this.x = ((TextView)findViewById(2131690267));
    this.y = ((TextView)findViewById(2131690268));
    this.z = ((ImageView)findViewById(2131690269));
    this.D = ((TextView)findViewById(2131692319));
  }
  
  private void b()
  {
    this.b.setOnClickListener(this);
    this.e.setOnScrollChangedCallback(this);
    this.v.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.z.setOnClickListener(this);
  }
  
  private void e()
  {
    f();
  }
  
  private void f()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {}
    for (this.t = localUserInfo.getUid();; this.t = "")
    {
      com.ziroom.ziroomcustomer.e.n.getRepairTypeList(this.r, this.t, new com.ziroom.ziroomcustomer.e.a.a(this, new l(bb.class, new e()))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
        }
        
        public void onSuccess(int paramAnonymousInt, List<bb> paramAnonymousList)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousList);
          if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0)) {
            RepairTypeActivity.a(RepairTypeActivity.this, paramAnonymousList);
          }
          paramAnonymousList = new com.ziroom.ziroomcustomer.newclean.b.n(RepairTypeActivity.a(RepairTypeActivity.this), RepairTypeActivity.b(RepairTypeActivity.this));
          RepairTypeActivity.c(RepairTypeActivity.this).setAdapter(paramAnonymousList);
          RepairTypeActivity.d(RepairTypeActivity.this);
        }
      });
      h();
      return;
    }
  }
  
  private void g()
  {
    this.f.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousView = ((bb)RepairTypeActivity.b(RepairTypeActivity.this).get(paramAnonymousInt)).getServiceInfoId();
        String str = ((bb)RepairTypeActivity.b(RepairTypeActivity.this).get(paramAnonymousInt)).getServiceInfoName();
        if ("00000000".equals(paramAnonymousView)) {
          if (!ApplicationEx.c.isLoginState())
          {
            com.ziroom.commonlibrary.login.a.startLoginActivity(RepairTypeActivity.a(RepairTypeActivity.this));
            g.textToast(RepairTypeActivity.a(RepairTypeActivity.this), "请先登录");
          }
        }
        for (;;)
        {
          return;
          if ((ApplicationEx.c.getContracts() == null) || ((ApplicationEx.c.getContracts() != null) && (ApplicationEx.c.getContracts().size() == 0)))
          {
            com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(RepairTypeActivity.a(RepairTypeActivity.this)).setTitle("提示").setContent("您没有履行中的合同哦~").setOnConfirmClickListener(new c.b()
            {
              public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean) {}
            }).build().show();
            return;
          }
          paramAnonymousAdapterView = new Intent(RepairTypeActivity.a(RepairTypeActivity.this), InternalRepairSelectActivity.class);
          while (paramAnonymousAdapterView != null)
          {
            RepairTypeActivity.this.startActivity(paramAnonymousAdapterView);
            return;
            if (!ApplicationEx.c.isLoginState())
            {
              com.ziroom.commonlibrary.login.a.startLoginActivity(RepairTypeActivity.a(RepairTypeActivity.this));
              g.textToast(RepairTypeActivity.a(RepairTypeActivity.this), "请先登录");
              return;
            }
            paramAnonymousAdapterView = new Intent(RepairTypeActivity.a(RepairTypeActivity.this), RepairOrderNewActivity.class);
            paramAnonymousAdapterView.putExtra("serviceInfoId", paramAnonymousView);
            paramAnonymousAdapterView.putExtra("serviceInfoName", str);
          }
        }
      }
    });
  }
  
  private void h()
  {
    j.getCommonJsonGate(this.r, q.o + "contentful/ziruke-app/v1/fuwu/weixiu.json", new d(this.r, new f(bm.class))
    {
      public void onSuccess(int paramAnonymousInt, bm paramAnonymousbm)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousbm);
        if (paramAnonymousbm != null)
        {
          bm.a locala = paramAnonymousbm.getTopBanner();
          if (locala != null)
          {
            String str = locala.getPic();
            RepairTypeActivity.e(RepairTypeActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(str));
            RepairTypeActivity.a(RepairTypeActivity.this, locala.getTitle());
            str = locala.getSubtitle();
            RepairTypeActivity.b(RepairTypeActivity.this, locala.getUrl());
            RepairTypeActivity.c(RepairTypeActivity.this, locala.getTypes());
            if (TextUtils.isEmpty(RepairTypeActivity.f(RepairTypeActivity.this))) {
              break label198;
            }
            RepairTypeActivity.g(RepairTypeActivity.this).setVisibility(0);
            RepairTypeActivity.h(RepairTypeActivity.this).setText(RepairTypeActivity.f(RepairTypeActivity.this));
            RepairTypeActivity.i(RepairTypeActivity.this).setText(str);
          }
        }
        for (;;)
        {
          RepairTypeActivity.b(RepairTypeActivity.this, paramAnonymousbm.getTips());
          if ((RepairTypeActivity.j(RepairTypeActivity.this) != null) && (!RepairTypeActivity.j(RepairTypeActivity.this).isEmpty())) {
            RepairTypeActivity.k(RepairTypeActivity.this).setVisibility(0);
          }
          RepairTypeActivity.this.bindServiceTips(RepairTypeActivity.j(RepairTypeActivity.this));
          return;
          label198:
          RepairTypeActivity.g(RepairTypeActivity.this).setVisibility(8);
        }
      }
    });
  }
  
  public void bindServiceTips(final List<bm.b> paramList)
  {
    if (paramList == null)
    {
      this.g.setVisibility(8);
      return;
    }
    this.g.setVisibility(0);
    this.g.setData(this.r, paramList);
    this.g.setOnClickListener(new HomeCListCtrlView.b()
    {
      public void onClick() {}
      
      public void onItemClick(int paramAnonymousInt)
      {
        String str1 = ((bm.b)paramList.get(paramAnonymousInt)).getUrl();
        String str2 = ((bm.b)paramList.get(paramAnonymousInt)).getTitle();
        Intent localIntent = new Intent(RepairTypeActivity.a(RepairTypeActivity.this), HomeWebActivity.class);
        localIntent.putExtra("title", str2);
        localIntent.putExtra("url", str1);
        RepairTypeActivity.this.startActivity(localIntent);
      }
    });
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690302: 
      finish();
      return;
    }
    paramView = null;
    if (this.C.equals("1"))
    {
      paramView = new Intent(this.r, HomeWebActivity.class);
      paramView.putExtra("url", this.A);
      paramView.putExtra("title", this.B);
      startActivity(paramView);
      return;
    }
    String str = this.A;
    int i = -1;
    switch (str.hashCode())
    {
    default: 
      label180:
      switch (i)
      {
      }
      break;
    }
    while (paramView != null)
    {
      startActivity(paramView);
      return;
      if (!str.equals("repair_shuiluguanjian")) {
        break label180;
      }
      i = 0;
      break label180;
      if (!str.equals("repair_dengjudianlu")) {
        break label180;
      }
      i = 1;
      break label180;
      if (!str.equals("repair_kaisuohuansuo")) {
        break label180;
      }
      i = 2;
      break label180;
      if (!str.equals("repair_kongtiaoqingxi")) {
        break label180;
      }
      i = 3;
      break label180;
      if (!str.equals("card_repair")) {
        break label180;
      }
      i = 4;
      break label180;
      paramView = new Intent(this.r, RepairOrderActivity.class);
      paramView.putExtra("type", 0);
      continue;
      paramView = new Intent(this.r, RepairOrderActivity.class);
      paramView.putExtra("type", 1);
      continue;
      paramView = new Intent(this.r, RepairOrderActivity.class);
      paramView.putExtra("type", 2);
      continue;
      paramView = new Intent(this.r, RepairOrderActivity.class);
      paramView.putExtra("type", 3);
      continue;
      paramView = new Intent(this.r, RepairBuyCardActivity.class);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903479);
    a();
    b();
    e();
  }
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    float f1 = 1.0F;
    float f2 = paramInt2 / com.ziroom.ziroomcustomer.util.n.dip2px(this, 100.0F);
    if (f2 > 1.0F) {}
    for (;;)
    {
      this.a.setAlpha(f1);
      this.c.setAlpha(f1);
      this.d.setAlpha(f1);
      if (f1 > 0.6D)
      {
        this.b.setImageResource(2130840141);
        return;
      }
      this.b.setImageResource(2130840141);
      return;
      f1 = f2;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/activity/RepairTypeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */