package com.ziroom.ziroomcustomer.newclean.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.design.widget.TabLayout.Tab;
import android.support.design.widget.TabLayout.TabLayoutOnPageChangeListener;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.a.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.dialog.d;
import com.ziroom.ziroomcustomer.dialog.d.a;
import com.ziroom.ziroomcustomer.e.c.k;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.Contract;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.d.af;
import com.ziroom.ziroomcustomer.newclean.fragment.BiweeklyCleanListFragment;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.math.BigDecimal;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BiweeklyCleanActivity
  extends BaseActivity
{
  private String A = "";
  private String B = "";
  private String C = "";
  private String D = "";
  private af E;
  private List<Contract> F = new ArrayList();
  private List<String> G;
  private Contract H;
  private long I;
  private d J;
  private List K;
  private a L;
  private ImageView M;
  private ImageView N;
  private ImageView O;
  private ImageView P;
  private ImageView Q;
  private TabLayout.OnTabSelectedListener R = new TabLayout.OnTabSelectedListener()
  {
    public void onTabReselected(TabLayout.Tab paramAnonymousTab) {}
    
    public void onTabSelected(TabLayout.Tab paramAnonymousTab)
    {
      BiweeklyCleanActivity.u(BiweeklyCleanActivity.this).setCurrentItem(paramAnonymousTab.getPosition());
    }
    
    public void onTabUnselected(TabLayout.Tab paramAnonymousTab) {}
  };
  private TabLayout.TabLayoutOnPageChangeListener S = new TabLayout.TabLayoutOnPageChangeListener(this.v);
  private TabLayout.TabLayoutOnPageChangeListener T = new TabLayout.TabLayoutOnPageChangeListener(this.w);
  private ObservableScrollView a;
  private TextView b;
  private Button c;
  private View d;
  private View e;
  private RelativeLayout f;
  private SimpleDraweeView g;
  private TextView r;
  private TextView s;
  private TextView t;
  private Button u;
  private TabLayout v;
  private TabLayout w;
  private View x;
  private ViewPager y;
  private int z;
  
  private void a()
  {
    b();
    this.a = ((ObservableScrollView)findViewById(2131690031));
    this.b = ((TextView)findViewById(2131690032));
    this.c = ((Button)findViewById(2131690033));
    this.d = findViewById(2131690034);
    this.e = findViewById(2131690035);
    this.f = ((RelativeLayout)findViewById(2131695946));
    this.g = ((SimpleDraweeView)findViewById(2131690070));
    this.r = ((TextView)findViewById(2131690049));
    this.s = ((TextView)findViewById(2131690593));
    this.t = ((TextView)findViewById(2131690596));
    this.u = ((Button)findViewById(2131690597));
    this.M = ((ImageView)findViewById(2131690054));
    this.N = ((ImageView)findViewById(2131690055));
    this.O = ((ImageView)findViewById(2131690056));
    this.P = ((ImageView)findViewById(2131690057));
    this.Q = ((ImageView)findViewById(2131690058));
    this.v = ((TabLayout)findViewById(2131690036));
    this.w = ((TabLayout)findViewById(2131690038));
    this.x = findViewById(2131690039);
    this.y = ((ViewPager)findViewById(2131690037));
    this.a.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (paramAnonymousInt2 > BiweeklyCleanActivity.a(BiweeklyCleanActivity.this).getY() - BiweeklyCleanActivity.b(BiweeklyCleanActivity.this))
        {
          BiweeklyCleanActivity.c(BiweeklyCleanActivity.this).setVisibility(0);
          BiweeklyCleanActivity.d(BiweeklyCleanActivity.this).setVisibility(0);
          return;
        }
        BiweeklyCleanActivity.c(BiweeklyCleanActivity.this).setVisibility(4);
        BiweeklyCleanActivity.d(BiweeklyCleanActivity.this).setVisibility(4);
      }
    });
  }
  
  private void b()
  {
    ((ImageView)findViewById(2131691493)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        BiweeklyCleanActivity.this.finish();
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
        j.setToWeekList(BiweeklyCleanActivity.this, "weekclean", BiweeklyCleanActivity.e(BiweeklyCleanActivity.this));
      }
    });
    ((TextView)findViewById(2131689541)).setText("自如客保洁");
    this.z = ((int)(getResources().getDisplayMetrics().density * 52.0F));
  }
  
  private void e()
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null)
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
      if (this.F.size() <= 1) {
        break label413;
      }
      this.c.setVisibility(0);
    }
    for (;;)
    {
      this.y.addOnPageChangeListener(this.S);
      this.y.addOnPageChangeListener(this.T);
      this.v.setOnTabSelectedListener(this.R);
      this.v.setTabsFromPagerAdapter(this.L);
      this.w.setTabsFromPagerAdapter(this.L);
      this.v.setupWithViewPager(this.y);
      this.w.setupWithViewPager(this.y);
      this.b.setText(this.H.getAddress());
      n.getBiweeklyCleanContractValidate(this, this.A, this.H.getOld_contract_code(), this.H.getHire_contract_code(), new com.ziroom.commonlibrary.a.a(this, new m(String.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          if ((paramAnonymousThrowable instanceof com.freelxl.baselibrary.d.d.a))
          {
            g.textToast(this.b, paramAnonymousThrowable.getMessage());
            return;
          }
          if ((paramAnonymousThrowable instanceof b))
          {
            g.textToast(this.b, "保洁信息还没有更新哦");
            return;
          }
          if ((paramAnonymousThrowable instanceof UnknownHostException))
          {
            g.textToast(this.b, "网络请求失败，请检查网络连接");
            return;
          }
          g.textToast(this.b, "服务器请求异常！");
        }
        
        public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousString);
          BiweeklyCleanActivity.f(BiweeklyCleanActivity.this);
        }
      });
      return;
      this.A = ((UserInfo)localObject).getUid();
      this.B = ((UserInfo)localObject).getPhone();
      this.C = ((UserInfo)localObject).getRealName();
      localObject = ApplicationEx.c.getContracts();
      int i;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        i = 0;
        while (i < ((List)localObject).size())
        {
          if (!TextUtils.isEmpty(((Contract)((List)localObject).get(i)).getAddress())) {
            this.F.add(((List)localObject).get(i));
          }
          i += 1;
        }
      }
      if ((this.F != null) && (this.F.size() > 0))
      {
        if (this.F.size() > 1) {
          Collections.sort(this.F, new Comparator()
          {
            public int compare(Contract paramAnonymousContract1, Contract paramAnonymousContract2)
            {
              if ((TextUtils.isEmpty(paramAnonymousContract1.getContract_type())) || (TextUtils.isEmpty(paramAnonymousContract1.getEffect_date()))) {
                return -1;
              }
              if ((TextUtils.isEmpty(paramAnonymousContract2.getContract_type())) || (TextUtils.isEmpty(paramAnonymousContract2.getEffect_date()))) {
                return 1;
              }
              if (!paramAnonymousContract1.getContract_type().equals(paramAnonymousContract2.getContract_type())) {
                return paramAnonymousContract1.getContract_type().compareTo(paramAnonymousContract2.getContract_type());
              }
              return paramAnonymousContract1.getEffect_date().compareTo(paramAnonymousContract2.getEffect_date());
            }
          });
        }
        this.H = ((Contract)this.F.get(0));
        this.G = new ArrayList();
        i = 0;
        while (i < this.F.size())
        {
          this.G.add(((Contract)this.F.get(i)).getAddress());
          i += 1;
        }
        break;
      }
      g.textToast(getApplicationContext(), "暂时没有合同，请签约后再试！");
      finish();
      return;
      label413:
      this.c.setVisibility(8);
    }
  }
  
  private void f()
  {
    if (this.H == null) {
      return;
    }
    this.I = System.currentTimeMillis();
    this.b.setText(this.H.getAddress());
    n.getBiweeklyCleanerInfoByContract(this, this.A, this.H.getOld_contract_code(), this.H.getHire_contract_code(), new com.ziroom.ziroomcustomer.e.a.a(this, new m(af.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onSuccess(int paramAnonymousInt, af paramAnonymousaf)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousaf);
        BiweeklyCleanActivity.a(BiweeklyCleanActivity.this, paramAnonymousaf);
        if (paramAnonymousaf != null)
        {
          BiweeklyCleanActivity.g(BiweeklyCleanActivity.this).setController(c.frescoController(paramAnonymousaf.getHeadPic()));
          BiweeklyCleanActivity.h(BiweeklyCleanActivity.this).setText(paramAnonymousaf.getName());
          String str1 = paramAnonymousaf.getAge();
          String str2 = paramAnonymousaf.getNativePlace();
          StringBuilder localStringBuilder = new StringBuilder("");
          if (!TextUtils.isEmpty(str1))
          {
            localStringBuilder.append(str1);
            localStringBuilder.append("岁");
          }
          if (!TextUtils.isEmpty(str2))
          {
            localStringBuilder.append("·");
            localStringBuilder.append(str2);
          }
          BiweeklyCleanActivity.i(BiweeklyCleanActivity.this).setText(localStringBuilder.toString());
          if (!TextUtils.isEmpty(paramAnonymousaf.getSocre()))
          {
            paramAnonymousInt = new BigDecimal(paramAnonymousaf.getSocre()).setScale(0, 4).intValue();
            if (paramAnonymousInt == 0) {
              j.getStar(5, BiweeklyCleanActivity.j(BiweeklyCleanActivity.this), BiweeklyCleanActivity.k(BiweeklyCleanActivity.this), BiweeklyCleanActivity.l(BiweeklyCleanActivity.this), BiweeklyCleanActivity.m(BiweeklyCleanActivity.this), BiweeklyCleanActivity.n(BiweeklyCleanActivity.this));
            }
          }
          else
          {
            if (TextUtils.isEmpty(paramAnonymousaf.getServeNum())) {
              break label329;
            }
            BiweeklyCleanActivity.o(BiweeklyCleanActivity.this).setText("已服务" + paramAnonymousaf.getServeNum() + "次");
          }
          for (;;)
          {
            BiweeklyCleanActivity.p(BiweeklyCleanActivity.this).setVisibility(0);
            BiweeklyCleanActivity.q(BiweeklyCleanActivity.this).setVisibility(0);
            BiweeklyCleanActivity.r(BiweeklyCleanActivity.this).setVisibility(0);
            return;
            j.getStar(paramAnonymousInt, BiweeklyCleanActivity.j(BiweeklyCleanActivity.this), BiweeklyCleanActivity.k(BiweeklyCleanActivity.this), BiweeklyCleanActivity.l(BiweeklyCleanActivity.this), BiweeklyCleanActivity.m(BiweeklyCleanActivity.this), BiweeklyCleanActivity.n(BiweeklyCleanActivity.this));
            break;
            label329:
            BiweeklyCleanActivity.o(BiweeklyCleanActivity.this).setText("");
          }
        }
        BiweeklyCleanActivity.p(BiweeklyCleanActivity.this).setVisibility(8);
        BiweeklyCleanActivity.q(BiweeklyCleanActivity.this).setVisibility(8);
        BiweeklyCleanActivity.r(BiweeklyCleanActivity.this).setVisibility(8);
      }
    });
    n.getBiweeklyCleanMonthList(this, this.A, this.H.getOld_contract_code(), this.H.getHire_contract_code(), new com.ziroom.ziroomcustomer.e.a.a(this, new k(new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        BiweeklyCleanActivity.a(BiweeklyCleanActivity.this, null);
        BiweeklyCleanActivity.a(BiweeklyCleanActivity.this, new BiweeklyCleanActivity.a(BiweeklyCleanActivity.this, BiweeklyCleanActivity.this.getSupportFragmentManager(), BiweeklyCleanActivity.s(BiweeklyCleanActivity.this)));
        BiweeklyCleanActivity.u(BiweeklyCleanActivity.this).setAdapter(BiweeklyCleanActivity.t(BiweeklyCleanActivity.this));
        BiweeklyCleanActivity.a(BiweeklyCleanActivity.this).setTabsFromPagerAdapter(BiweeklyCleanActivity.t(BiweeklyCleanActivity.this));
        BiweeklyCleanActivity.c(BiweeklyCleanActivity.this).setTabsFromPagerAdapter(BiweeklyCleanActivity.t(BiweeklyCleanActivity.this));
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if ((paramAnonymouse != null) && (paramAnonymouse.containsKey("timeList")))
        {
          BiweeklyCleanActivity.a(BiweeklyCleanActivity.this, paramAnonymouse.getJSONArray("timeList"));
          BiweeklyCleanActivity.a(BiweeklyCleanActivity.this, new BiweeklyCleanActivity.a(BiweeklyCleanActivity.this, BiweeklyCleanActivity.this.getSupportFragmentManager(), BiweeklyCleanActivity.s(BiweeklyCleanActivity.this)));
          BiweeklyCleanActivity.u(BiweeklyCleanActivity.this).setAdapter(BiweeklyCleanActivity.t(BiweeklyCleanActivity.this));
          if (paramAnonymouse.containsKey("currentTime"))
          {
            paramAnonymouse = paramAnonymouse.getString("currentTime");
            paramAnonymousInt = BiweeklyCleanActivity.v(BiweeklyCleanActivity.this).indexOf(paramAnonymouse);
            if (paramAnonymousInt > 0) {
              BiweeklyCleanActivity.u(BiweeklyCleanActivity.this).setCurrentItem(paramAnonymousInt);
            }
          }
        }
        do
        {
          return;
          if (BiweeklyCleanActivity.v(BiweeklyCleanActivity.this) != null) {
            BiweeklyCleanActivity.v(BiweeklyCleanActivity.this).clear();
          }
        } while (BiweeklyCleanActivity.t(BiweeklyCleanActivity.this) == null);
        BiweeklyCleanActivity.t(BiweeklyCleanActivity.this).notifyDataSetChanged();
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      return;
      paramIntent = (BiweeklyCleanListFragment)getSupportFragmentManager().findFragmentByTag("android:switcher:2131690037:" + (this.I * 10L + this.y.getCurrentItem()));
    } while (paramIntent == null);
    paramIntent.refreshList();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903111);
    a();
    e();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
        if (this.J == null) {
          this.J = new d(this, this.G, new d.a()
          {
            public void callback(int paramAnonymousInt, final String paramAnonymousString)
            {
              paramAnonymousString = (Contract)BiweeklyCleanActivity.w(BiweeklyCleanActivity.this).get(paramAnonymousInt);
              if (paramAnonymousString == BiweeklyCleanActivity.e(BiweeklyCleanActivity.this)) {
                return;
              }
              n.getBiweeklyCleanContractValidate(BiweeklyCleanActivity.this, BiweeklyCleanActivity.x(BiweeklyCleanActivity.this), paramAnonymousString.getOld_contract_code(), paramAnonymousString.getHire_contract_code(), new com.ziroom.ziroomcustomer.e.a.a(BiweeklyCleanActivity.this, new m(String.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
              {
                public void onSuccess(int paramAnonymous2Int, String paramAnonymous2String)
                {
                  super.onSuccess(paramAnonymous2Int, paramAnonymous2String);
                  BiweeklyCleanActivity.a(BiweeklyCleanActivity.this, paramAnonymousString);
                  BiweeklyCleanActivity.f(BiweeklyCleanActivity.this);
                }
              });
            }
          });
        }
        this.J.show();
        return;
      } while ((this.E == null) || (TextUtils.isEmpty(this.E.getPhone())));
      ah.callPhone(this, this.E.getPhone());
      return;
      w.onEventToZiroomAndUmeng("biweeklyclean_my_cleaner_info");
    } while ((this.E == null) || (TextUtils.isEmpty(this.E.getCleanerId())));
    paramView = new Intent(this, BiWeeklyCleanerInfoActivity.class);
    paramView.putExtra("cleanerId", this.E.getCleanerId());
    startActivity(paramView);
  }
  
  private class a
    extends FragmentPagerAdapter
  {
    private long b;
    
    public a(FragmentManager paramFragmentManager, long paramLong)
    {
      super();
      this.b = paramLong;
    }
    
    public int getCount()
    {
      if (BiweeklyCleanActivity.v(BiweeklyCleanActivity.this) == null) {
        return 0;
      }
      return BiweeklyCleanActivity.v(BiweeklyCleanActivity.this).size();
    }
    
    public Fragment getItem(int paramInt)
    {
      String str = (String)BiweeklyCleanActivity.v(BiweeklyCleanActivity.this).get(paramInt);
      return BiweeklyCleanListFragment.getInstance(BiweeklyCleanActivity.x(BiweeklyCleanActivity.this), BiweeklyCleanActivity.e(BiweeklyCleanActivity.this).getOld_contract_code(), BiweeklyCleanActivity.e(BiweeklyCleanActivity.this).getHire_contract_code(), str, BiweeklyCleanActivity.y(BiweeklyCleanActivity.this), BiweeklyCleanActivity.z(BiweeklyCleanActivity.this), BiweeklyCleanActivity.e(BiweeklyCleanActivity.this).getAddress());
    }
    
    public long getItemId(int paramInt)
    {
      return this.b * 10L + paramInt;
    }
    
    public CharSequence getPageTitle(int paramInt)
    {
      String str2 = (String)BiweeklyCleanActivity.v(BiweeklyCleanActivity.this).get(paramInt);
      String str1 = str2;
      if (str2.contains("-")) {
        str1 = str2.substring(str2.indexOf("-") + 1) + "月";
      }
      return str1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/BiweeklyCleanActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */