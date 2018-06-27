package com.ziroom.ziroomcustomer.newclean.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.dialog.d.a;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.Contract;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.e;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newServiceList.view.RatingStar;
import com.ziroom.ziroomcustomer.newclean.d.af;
import com.ziroom.ziroomcustomer.newclean.d.ao;
import com.ziroom.ziroomcustomer.newclean.fragment.ForCleaningCleanerFragment;
import com.ziroom.ziroomcustomer.newclean.fragment.ForCleaningEvalFragment;
import com.ziroom.ziroomcustomer.newclean.fragment.ForCleaningOrderFragment;
import com.ziroom.ziroomcustomer.util.ah;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ForCleaningActivity
  extends BaseActivity
{
  private static int f;
  protected ArrayList<Fragment> a = new ArrayList();
  private Unbinder b;
  private String c;
  private String d;
  private String e;
  private int g = 0;
  @BindView(2131690607)
  FrameLayout mFl;
  @BindView(2131690605)
  ImageView mIv60;
  @BindView(2131690604)
  ImageView mIv70;
  @BindView(2131690598)
  ImageView mIvShow;
  @BindView(2131690600)
  LinearLayout mLlPager;
  @BindView(2131690599)
  RelativeLayout mRLBedroom;
  @BindView(2131690274)
  RelativeLayout mRlCleaner;
  @BindView(2131690603)
  RelativeLayout mRlIndicator;
  @BindView(2131690595)
  RatingStar mRsStar;
  @BindView(2131690070)
  SimpleDraweeView mSdvAdatar;
  @BindView(2131690593)
  TextView mTvAgePlace;
  @BindView(2131690591)
  TextView mTvChangeContract;
  @BindView(2131690601)
  TextView mTvCleaner;
  @BindView(2131690032)
  TextView mTvContractAddress;
  @BindView(2131690602)
  TextView mTvEval;
  @BindView(2131690049)
  TextView mTvName;
  @BindView(2131690048)
  TextView mTvOrder;
  @BindView(2131690059)
  TextView mTvScore;
  @BindView(2131690596)
  TextView mTvTimes;
  @BindView(2131690606)
  ViewPager mVp;
  private FragmentPagerAdapter r;
  private List<Contract> s = new ArrayList();
  private List<String> t;
  private Contract u;
  private com.ziroom.ziroomcustomer.dialog.d v;
  private af w;
  private boolean x = false;
  private ForCleaningOrderFragment y;
  private boolean z = true;
  
  private void a()
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null)
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
      return;
    }
    this.c = ((UserInfo)localObject).getUid();
    this.d = ((UserInfo)localObject).getPhone();
    this.e = ((UserInfo)localObject).getRealName();
    localObject = ApplicationEx.c.getContracts();
    int i;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      i = 0;
      while (i < ((List)localObject).size())
      {
        if (!TextUtils.isEmpty(((Contract)((List)localObject).get(i)).getAddress())) {
          this.s.add(((List)localObject).get(i));
        }
        i += 1;
      }
    }
    if ((this.s != null) && (this.s.size() > 0))
    {
      if (this.s.size() > 1) {
        Collections.sort(this.s, new Comparator()
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
      this.u = ((Contract)this.s.get(0));
      this.t = new ArrayList();
      i = 0;
    }
    while (i < this.s.size())
    {
      this.t.add(((Contract)this.s.get(i)).getAddress());
      i += 1;
      continue;
      g.textToast(getApplicationContext(), "暂时没有合同，请签约后再试！");
      finish();
      return;
    }
    a(this.u);
    if (this.s.size() > 1) {
      this.mTvChangeContract.setVisibility(0);
    }
    for (;;)
    {
      this.mTvContractAddress.setText((CharSequence)this.t.get(0));
      return;
      this.mTvChangeContract.setVisibility(8);
    }
  }
  
  private void a(int paramInt, float paramFloat)
  {
    if (paramInt == 1)
    {
      this.mIv70.setVisibility(0);
      this.mIv60.setVisibility(8);
    }
    while (this.g == paramInt)
    {
      j.moveIndicator("right", paramFloat, f, this.mRlIndicator, this.g);
      return;
      this.mIv70.setVisibility(8);
      this.mIv60.setVisibility(0);
    }
    j.moveIndicator("left", paramFloat, f, this.mRlIndicator, this.g);
  }
  
  private void a(final Contract paramContract)
  {
    n.getBiweeklyCleanContractValidate(this, this.c, paramContract.getOld_contract_code(), paramContract.getHire_contract_code(), new com.ziroom.ziroomcustomer.e.a.a(this, new m(String.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        ForCleaningActivity.b(ForCleaningActivity.this, paramContract);
        ForCleaningActivity.this.mTvContractAddress.setText(ForCleaningActivity.b(ForCleaningActivity.this).getAddress());
        ForCleaningActivity.c(ForCleaningActivity.this);
      }
    });
  }
  
  private void b()
  {
    n.getBiweeklyCleanerInfoByContract(this, this.c, this.u.getOld_contract_code(), this.u.getHire_contract_code(), new com.ziroom.ziroomcustomer.e.a.a(this, new m(af.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        ForCleaningActivity.f(ForCleaningActivity.this);
      }
      
      public void onSuccess(int paramAnonymousInt, af paramAnonymousaf)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousaf);
        ForCleaningActivity.a(ForCleaningActivity.this, paramAnonymousaf);
        if (paramAnonymousaf != null)
        {
          ForCleaningActivity.this.mLlPager.setVisibility(0);
          ForCleaningActivity.this.mFl.setVisibility(8);
          ForCleaningActivity.this.mRlCleaner.setVisibility(0);
          ForCleaningActivity.d(ForCleaningActivity.this);
          ForCleaningActivity.a(ForCleaningActivity.this, ForCleaningActivity.e(ForCleaningActivity.this).getCleanerId());
          ForCleaningActivity.this.mSdvAdatar.setController(com.freelxl.baselibrary.f.c.frescoController(paramAnonymousaf.getHeadPic()));
          ForCleaningActivity.this.mTvName.setText(paramAnonymousaf.getName());
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
            localStringBuilder.append(" ");
            localStringBuilder.append(str2);
          }
          ForCleaningActivity.this.mTvAgePlace.setText(localStringBuilder.toString());
          if (!TextUtils.isEmpty(paramAnonymousaf.getSocre()))
          {
            ForCleaningActivity.this.mTvScore.setText(paramAnonymousaf.getSocre());
            paramAnonymousInt = new BigDecimal(paramAnonymousaf.getSocre()).setScale(0, 4).intValue();
            if (paramAnonymousInt != 0) {
              break label298;
            }
            ForCleaningActivity.this.mRsStar.setStarScore(5);
          }
          while (!TextUtils.isEmpty(paramAnonymousaf.getServeNum()))
          {
            ForCleaningActivity.this.mTvTimes.setText("已服务" + paramAnonymousaf.getServeNum() + "次");
            return;
            label298:
            ForCleaningActivity.this.mRsStar.setStarScore(paramAnonymousInt);
          }
          ForCleaningActivity.this.mTvTimes.setText("");
          return;
        }
        ForCleaningActivity.f(ForCleaningActivity.this);
      }
    });
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 0)
    {
      this.mTvOrder.setTextColor(40960);
      this.mTvCleaner.setTextColor(-12303292);
      this.mTvEval.setTextColor(-12303292);
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        this.mTvOrder.setTextColor(-12303292);
        this.mTvCleaner.setTextColor(40960);
        this.mTvEval.setTextColor(-12303292);
        return;
      }
    } while (paramInt != 2);
    this.mTvOrder.setTextColor(-12303292);
    this.mTvCleaner.setTextColor(-12303292);
    this.mTvEval.setTextColor(40960);
  }
  
  private void d(String paramString)
  {
    String str1 = this.u.getOld_contract_code();
    String str2 = this.u.getHire_contract_code();
    String str3 = this.u.getAddress();
    if (this.x)
    {
      paramString = new ao(paramString, str3, str1, str2, this.d, this.e, this.c);
      org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c(e.a, paramString));
      return;
    }
    this.x = true;
    this.y = null;
    this.y = ForCleaningOrderFragment.getInstance(this.c, this.u.getOld_contract_code(), this.u.getHire_contract_code(), this.d, this.e, this.u.getAddress());
    this.a.add(this.y);
    this.a.add(ForCleaningCleanerFragment.getInstance(paramString));
    this.a.add(ForCleaningEvalFragment.getInstance(paramString));
    this.r = new FragmentPagerAdapter(getSupportFragmentManager())
    {
      public int getCount()
      {
        return 3;
      }
      
      public Fragment getItem(int paramAnonymousInt)
      {
        return (Fragment)ForCleaningActivity.this.a.get(paramAnonymousInt);
      }
    };
    this.mVp.setAdapter(this.r);
    this.mVp.setOffscreenPageLimit(3);
    this.mVp.setCurrentItem(0);
    b(0);
    this.mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
        ForCleaningActivity.a(ForCleaningActivity.this, paramAnonymousInt1, paramAnonymousFloat);
      }
      
      public void onPageSelected(int paramAnonymousInt)
      {
        ForCleaningActivity.a(ForCleaningActivity.this, paramAnonymousInt);
        ForCleaningActivity.b(ForCleaningActivity.this, paramAnonymousInt);
      }
    });
  }
  
  private void e()
  {
    this.mRlCleaner.setVisibility(8);
    this.mLlPager.setVisibility(8);
    this.mRLBedroom.setVisibility(8);
    this.mIvShow.setVisibility(0);
    this.mFl.setVisibility(0);
    if (this.z)
    {
      this.z = false;
      this.y = null;
      this.y = ForCleaningOrderFragment.getInstance(this.c, this.u.getOld_contract_code(), this.u.getHire_contract_code(), this.d, this.e, this.u.getAddress());
      FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.add(2131690607, this.y);
      localFragmentTransaction.commit();
    }
  }
  
  private void f()
  {
    String str1 = this.u.getOld_contract_code();
    String str2 = this.u.getHire_contract_code();
    n.getForCleaningBrdroom(this, this.c, str1, str2, new com.ziroom.ziroomcustomer.e.a.d(this, new f(String.class))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        if ((!TextUtils.isEmpty(paramAnonymousString)) && ("true".equals(paramAnonymousString)))
        {
          ForCleaningActivity.this.mIvShow.setVisibility(8);
          ForCleaningActivity.this.mRLBedroom.setVisibility(0);
          return;
        }
        ForCleaningActivity.this.mIvShow.setVisibility(0);
        ForCleaningActivity.this.mRLBedroom.setVisibility(8);
      }
    });
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (((paramInt1 == 1) || (paramInt1 == 2) || (paramInt1 == 3)) && (paramInt2 == -1)) {
      this.y.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  @OnClick({2131689492, 2131690591, 2131690597, 2131690048, 2131690601, 2131690602, 2131690599})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131689492: 
    case 2131690591: 
    case 2131690597: 
      do
      {
        return;
        finish();
        return;
        if (this.v == null) {
          this.v = new com.ziroom.ziroomcustomer.dialog.d(this, this.t, new d.a()
          {
            public void callback(int paramAnonymousInt, String paramAnonymousString)
            {
              paramAnonymousString = (Contract)ForCleaningActivity.a(ForCleaningActivity.this).get(paramAnonymousInt);
              if (paramAnonymousString == ForCleaningActivity.b(ForCleaningActivity.this)) {
                return;
              }
              ForCleaningActivity.a(ForCleaningActivity.this, paramAnonymousString);
            }
          });
        }
        this.v.show();
        return;
      } while ((this.w == null) || (TextUtils.isEmpty(this.w.getPhone())));
      ah.callPhone(this, this.w.getPhone());
      return;
    case 2131690048: 
      this.mVp.setCurrentItem(0);
      b(0);
      return;
    case 2131690601: 
      this.mVp.setCurrentItem(1);
      b(1);
      return;
    case 2131690602: 
      this.mVp.setCurrentItem(2);
      b(2);
      return;
    }
    com.ziroom.ziroomcustomer.newclean.view.a.StartBedroomCleanActivity(this, "8a90a5d85841edb0015847dd11110000", "卧室保洁");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903177);
    this.b = ButterKnife.bind(this);
    f = j.setInitVar(this, 3, this.mRlIndicator, 70);
    a();
  }
  
  protected void onDestroy()
  {
    this.b.unbind();
    super.onDestroy();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/ForCleaningActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */