package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.TextView;
import com.freelxl.baselibrary.d.f.a;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.c;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.widget.ScrollControlerViewPager;
import com.ziroom.ziroomcustomer.ziroomapartment.fragment.ZryuSignLivingBillsFragment;
import com.ziroom.ziroomcustomer.ziroomapartment.fragment.ZryuSignLivingBillsFragment.b;
import com.ziroom.ziroomcustomer.ziroomapartment.fragment.ZryuSignRentBillsFragment;
import com.ziroom.ziroomcustomer.ziroomapartment.fragment.ZryuSignRentBillsFragment.b;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignBillList;
import java.text.DecimalFormat;
import java.util.List;

public class ZryuSignBillsListActivity
  extends BaseActivity
  implements ZryuSignLivingBillsFragment.b, ZryuSignRentBillsFragment.b
{
  private ZryuSignRentBillsFragment A;
  private ZryuSignLivingBillsFragment B;
  private c C = new c(this, new f(ZryuSignBillList.class))
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
    }
    
    public void onSuccess(int paramAnonymousInt, ZryuSignBillList paramAnonymousZryuSignBillList)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousZryuSignBillList);
      if (paramAnonymousZryuSignBillList != null)
      {
        ZryuSignBillsListActivity.a(ZryuSignBillsListActivity.this, paramAnonymousZryuSignBillList.getContractCode());
        if (ZryuSignBillsListActivity.a(ZryuSignBillsListActivity.this) != null) {
          break label122;
        }
        ZryuSignBillsListActivity.a(ZryuSignBillsListActivity.this, new ZryuSignBillsListActivity.a(ZryuSignBillsListActivity.this, ZryuSignBillsListActivity.this.getSupportFragmentManager(), paramAnonymousZryuSignBillList));
        ZryuSignBillsListActivity.b(ZryuSignBillsListActivity.this).setAdapter(ZryuSignBillsListActivity.a(ZryuSignBillsListActivity.this));
        if (ZryuSignBillsListActivity.c(ZryuSignBillsListActivity.this) != 1) {
          break label99;
        }
        ZryuSignBillsListActivity.b(ZryuSignBillsListActivity.this).setCurrentItem(0);
      }
      label99:
      label122:
      do
      {
        do
        {
          return;
        } while (ZryuSignBillsListActivity.c(ZryuSignBillsListActivity.this) != 2);
        ZryuSignBillsListActivity.b(ZryuSignBillsListActivity.this).setCurrentItem(1);
        return;
        ZryuSignBillsListActivity.a(ZryuSignBillsListActivity.this, (ZryuSignRentBillsFragment)ZryuSignBillsListActivity.this.getSupportFragmentManager().findFragmentByTag("android:switcher:2131691905:0"));
        if (ZryuSignBillsListActivity.d(ZryuSignBillsListActivity.this) != null) {
          ZryuSignBillsListActivity.d(ZryuSignBillsListActivity.this).setData(paramAnonymousZryuSignBillList.getRoomRentList(), paramAnonymousZryuSignBillList.getRoomRentTip());
        }
        ZryuSignBillsListActivity.a(ZryuSignBillsListActivity.this, (ZryuSignLivingBillsFragment)ZryuSignBillsListActivity.this.getSupportFragmentManager().findFragmentByTag("android:switcher:2131691905:1"));
      } while (ZryuSignBillsListActivity.e(ZryuSignBillsListActivity.this) == null);
      ZryuSignBillsListActivity.e(ZryuSignBillsListActivity.this).setData(paramAnonymousZryuSignBillList.getLiftList(), paramAnonymousZryuSignBillList.getLifeFeeTip());
    }
  };
  private TextView a;
  private TextView b;
  private View c;
  private TextView d;
  private TextView e;
  private View f;
  private ScrollControlerViewPager g;
  private String r;
  private String s;
  private int t;
  private int u = 1;
  private a v;
  private int w;
  private int x;
  private b y;
  private int z;
  
  private void a()
  {
    this.a = ((TextView)findViewById(2131692999));
    this.b = ((TextView)findViewById(2131693000));
    this.c = findViewById(2131693001);
    this.e = ((TextView)findViewById(2131693003));
    this.d = ((TextView)findViewById(2131693004));
    this.f = findViewById(2131693005);
    this.g = ((ScrollControlerViewPager)findViewById(2131691905));
    this.g.setNoScroll(true);
    this.w = Color.parseColor("#444444");
    this.x = Color.parseColor("#FFA000");
  }
  
  private void b()
  {
    this.y = new b();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.ziroom.ziroomcustomer.payresult");
    registerReceiver(this.y, localIntentFilter);
    this.r = getIntent().getStringExtra("contractId");
    this.u = getIntent().getIntExtra("type", 1);
    this.t = getIntent().getIntExtra("flag", 0);
    e();
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 0)
    {
      this.a.setTextColor(this.x);
      this.c.setVisibility(0);
      this.e.setTextColor(this.w);
      this.f.setVisibility(4);
    }
    while (paramInt != 1) {
      return;
    }
    this.a.setTextColor(this.w);
    this.c.setVisibility(4);
    this.e.setTextColor(this.x);
    this.f.setVisibility(0);
  }
  
  private void e()
  {
    if (this.u == 1) {
      b(0);
    }
    for (;;)
    {
      j.zryuPaymentItems(this, this.r, this.t, this.C);
      return;
      if (this.u == 2) {
        b(1);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903605);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.y != null) {
      unregisterReceiver(this.y);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    e();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131692998: 
    case 2131693002: 
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              this.u = 1;
            } while (this.g == null);
            b(0);
          } while (this.v == null);
          this.g.setCurrentItem(0);
          return;
          this.u = 2;
        } while (this.g == null);
        b(1);
      } while (this.v == null);
      this.g.setCurrentItem(1);
      return;
    }
    finish();
  }
  
  public void onZryuSignLivingBillsNumChanged(int paramInt)
  {
    if ((!isFinishing()) && (this.d != null))
    {
      if (paramInt > 0)
      {
        this.d.setVisibility(0);
        this.d.setText(paramInt + "");
      }
    }
    else {
      return;
    }
    this.d.setVisibility(8);
  }
  
  public void onZryuSignLivingBillsPay(int paramInt)
  {
    this.z = paramInt;
  }
  
  public void onZryuSignRentBillsNumChanged(int paramInt)
  {
    if ((!isFinishing()) && (this.b != null))
    {
      if (paramInt > 0)
      {
        this.b.setVisibility(0);
        this.b.setText(paramInt + "");
      }
    }
    else {
      return;
    }
    this.b.setVisibility(8);
  }
  
  public void refreshData()
  {
    e();
  }
  
  private class a
    extends FragmentPagerAdapter
  {
    private ZryuSignBillList b;
    
    public a(FragmentManager paramFragmentManager, ZryuSignBillList paramZryuSignBillList)
    {
      super();
      this.b = paramZryuSignBillList;
    }
    
    public int getCount()
    {
      return 2;
    }
    
    public Fragment getItem(int paramInt)
    {
      String str2 = null;
      String str1 = null;
      Object localObject = null;
      if (paramInt == 0)
      {
        str1 = ZryuSignBillsListActivity.f(ZryuSignBillsListActivity.this);
        str2 = this.b.getSystemId();
        if (this.b == null) {
          localObject = ZryuSignRentBillsFragment.getInstance(str1, str2, (List)localObject, this.b.getRoomRentTip(), this.b.getContractCode());
        }
      }
      do
      {
        return (Fragment)localObject;
        localObject = this.b.getRoomRentList();
        break;
        localObject = str2;
      } while (paramInt != 1);
      str2 = ZryuSignBillsListActivity.f(ZryuSignBillsListActivity.this);
      String str3 = this.b.getSystemId();
      if (this.b == null) {}
      for (localObject = str1;; localObject = this.b.getLiftList()) {
        return ZryuSignLivingBillsFragment.getInstance(str2, str3, (List)localObject, this.b.getLifeFeeTip(), ZryuSignBillsListActivity.g(ZryuSignBillsListActivity.this));
      }
    }
  }
  
  class b
    extends BroadcastReceiver
  {
    b() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int i = -1;
      int j = paramIntent.getIntExtra("code", -1);
      paramContext = paramIntent.getStringExtra("payType");
      if (j == 1) {
        switch (paramContext.hashCode())
        {
        default: 
          switch (i)
          {
          }
          break;
        }
      }
      do
      {
        do
        {
          return;
          if (!paramContext.equals("1001")) {
            break;
          }
          i = 0;
          break;
        } while (ZryuSignBillsListActivity.h(ZryuSignBillsListActivity.this) <= 0);
        paramContext = new DecimalFormat("0.00");
        paramIntent = new Intent(ZryuSignBillsListActivity.this, ZryuSignPaySuccessActivity.class);
        paramIntent.putExtra("contractId", ZryuSignBillsListActivity.f(ZryuSignBillsListActivity.this));
        paramIntent.putExtra("contractCode", ZryuSignBillsListActivity.i(ZryuSignBillsListActivity.this));
        paramIntent.putExtra("period", "0");
        paramIntent.putExtra("type", "1001");
        paramIntent.putExtra("isPaySuccess", true);
        paramIntent.putExtra("money", paramContext.format(ZryuSignBillsListActivity.h(ZryuSignBillsListActivity.this) / 100.0F));
        ZryuSignBillsListActivity.this.startActivity(paramIntent);
        return;
        switch (paramContext.hashCode())
        {
        default: 
          return;
        }
      } while (!paramContext.equals("1001"));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuSignBillsListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */