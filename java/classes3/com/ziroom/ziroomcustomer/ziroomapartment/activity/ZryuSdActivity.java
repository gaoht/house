package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.b;
import com.freelxl.baselibrary.d.f.a;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.c;
import com.ziroom.ziroomcustomer.e.c.e;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.ziroomapartment.fragment.ZryuSdElectricityMeterFragment;
import com.ziroom.ziroomcustomer.ziroomapartment.fragment.ZryuSdWaterMeterFragment;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sd.ValidContract;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZryuSdActivity
  extends BaseActivity
{
  private int A;
  private ValidContract B;
  private a C;
  private int D = 0;
  private final int a = 1;
  private TextView b;
  private ImageView c;
  private View d;
  private FrameLayout e;
  private FrameLayout f;
  private ImageView g;
  private View r;
  private FrameLayout s;
  private ImageView t;
  private View u;
  private ViewPager v;
  private RelativeLayout w;
  private TextView x;
  private List<ValidContract> y;
  private String z;
  
  private void a()
  {
    this.b = ((TextView)findViewById(2131689541));
    this.c = ((ImageView)findViewById(2131692937));
    this.d = findViewById(2131692780);
    this.e = ((FrameLayout)findViewById(2131692938));
    this.f = ((FrameLayout)findViewById(2131692939));
    this.g = ((ImageView)findViewById(2131692940));
    this.r = findViewById(2131692941);
    this.s = ((FrameLayout)findViewById(2131692942));
    this.t = ((ImageView)findViewById(2131692943));
    this.u = findViewById(2131692944);
    this.v = ((ViewPager)findViewById(2131692945));
    this.w = ((RelativeLayout)findViewById(2131690081));
    this.x = ((TextView)findViewById(2131690822));
  }
  
  private void a(ValidContract paramValidContract)
  {
    if (paramValidContract != null)
    {
      this.B = paramValidContract;
      paramValidContract = this.B.getContractId();
      this.b.setText(this.B.getProjectName() + this.B.getRoomCode());
      if (this.C == null)
      {
        this.C = new a(getSupportFragmentManager(), paramValidContract);
        this.v.setAdapter(this.C);
        this.v.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
          public void onPageScrollStateChanged(int paramAnonymousInt) {}
          
          public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
          
          public void onPageSelected(int paramAnonymousInt)
          {
            ZryuSdActivity.a(ZryuSdActivity.this, paramAnonymousInt);
          }
        });
        this.v.setCurrentItem(this.D);
      }
    }
    else
    {
      return;
    }
    this.C.setContractId(paramValidContract);
  }
  
  private void b()
  {
    this.D = getIntent().getIntExtra("tab", 0);
    if ((ApplicationEx.c.getUser() != null) && (!TextUtils.isEmpty(ApplicationEx.c.getUser().getUid()))) {
      j.zryuValidContractList(this, new c(this, new e(ValidContract.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
        }
        
        public void onSuccess(int paramAnonymousInt, List<ValidContract> paramAnonymousList)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousList);
          ZryuSdActivity.a(ZryuSdActivity.this, new ArrayList());
          if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
          {
            paramAnonymousList = paramAnonymousList.iterator();
            while (paramAnonymousList.hasNext())
            {
              ValidContract localValidContract = (ValidContract)paramAnonymousList.next();
              if (((localValidContract.getIsSmartWatermeter() != null) && (localValidContract.getIsSmartWatermeter().intValue() == 1)) || ((localValidContract.getIsSmartWattmeter() != null) && (localValidContract.getIsSmartWattmeter().intValue() == 1))) {
                ZryuSdActivity.a(ZryuSdActivity.this).add(localValidContract);
              }
            }
          }
          ZryuSdActivity.a(ZryuSdActivity.this, b.toJSONString(ZryuSdActivity.a(ZryuSdActivity.this)));
          if (ZryuSdActivity.a(ZryuSdActivity.this).size() > 1)
          {
            ZryuSdActivity.b(ZryuSdActivity.this).setVisibility(0);
            paramAnonymousList = new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                ZryuSdActivity.c(ZryuSdActivity.this);
              }
            };
            ZryuSdActivity.d(ZryuSdActivity.this).setOnClickListener(paramAnonymousList);
            ZryuSdActivity.b(ZryuSdActivity.this).setOnClickListener(paramAnonymousList);
          }
          while (ZryuSdActivity.a(ZryuSdActivity.this).size() > 0)
          {
            ZryuSdActivity.e(ZryuSdActivity.this).setVisibility(8);
            ZryuSdActivity.f(ZryuSdActivity.this).setVisibility(0);
            ZryuSdActivity.g(ZryuSdActivity.this).setVisibility(0);
            ZryuSdActivity.h(ZryuSdActivity.this).setVisibility(8);
            ZryuSdActivity.a(ZryuSdActivity.this, (ValidContract)ZryuSdActivity.a(ZryuSdActivity.this).get(0));
            return;
            ZryuSdActivity.b(ZryuSdActivity.this).setVisibility(8);
            ZryuSdActivity.d(ZryuSdActivity.this).setOnClickListener(null);
          }
          ZryuSdActivity.d(ZryuSdActivity.this).setText("智能水电表");
          ZryuSdActivity.e(ZryuSdActivity.this).setVisibility(0);
          ZryuSdActivity.f(ZryuSdActivity.this).setVisibility(8);
          ZryuSdActivity.g(ZryuSdActivity.this).setVisibility(8);
          ZryuSdActivity.h(ZryuSdActivity.this).setVisibility(0);
        }
      });
    }
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 0)
    {
      this.g.setImageResource(2130840353);
      this.t.setImageResource(2130840350);
      this.r.setVisibility(0);
      this.u.setVisibility(8);
    }
    while (paramInt != 1) {
      return;
    }
    this.g.setImageResource(2130840352);
    this.t.setImageResource(2130840351);
    this.r.setVisibility(8);
    this.u.setVisibility(0);
  }
  
  private void e()
  {
    Intent localIntent = new Intent(this, ZryuSdContractSelectActivity.class);
    localIntent.putExtra("selectedIndex", this.A);
    localIntent.putExtra("contractList", this.z);
    startActivityForResult(localIntent, 1);
    overridePendingTransition(2130968676, 2130968590);
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
      this.B = ((ValidContract)paramIntent.getParcelableExtra("SelectedContract"));
    } while (this.B == null);
    this.A = paramIntent.getIntExtra("selectedIndex", -1);
    a(this.B);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903597);
    a();
    b();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    case 2131692939: 
      this.v.setCurrentItem(0);
      return;
    }
    this.v.setCurrentItem(1);
  }
  
  private class a
    extends FragmentPagerAdapter
  {
    private String b;
    
    public a(FragmentManager paramFragmentManager, String paramString)
    {
      super();
      this.b = paramString;
    }
    
    public int getCount()
    {
      return 2;
    }
    
    public Fragment getItem(int paramInt)
    {
      if (paramInt == 0) {
        return ZryuSdWaterMeterFragment.getInstance(this.b);
      }
      if (paramInt == 1) {
        return ZryuSdElectricityMeterFragment.getInstance(this.b);
      }
      return null;
    }
    
    public void setContractId(String paramString)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        this.b = paramString;
        Object localObject = (ZryuSdWaterMeterFragment)ZryuSdActivity.this.getSupportFragmentManager().findFragmentByTag("android:switcher:2131692945:0");
        if (localObject != null) {
          ((ZryuSdWaterMeterFragment)localObject).refresh(paramString);
        }
        localObject = (ZryuSdElectricityMeterFragment)ZryuSdActivity.this.getSupportFragmentManager().findFragmentByTag("android:switcher:2131692945:1");
        if (localObject != null) {
          ((ZryuSdElectricityMeterFragment)localObject).refresh(paramString);
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuSdActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */