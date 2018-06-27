package com.ziroom.ziroomcustomer.sublet.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.model.InfoItem;
import com.ziroom.ziroomcustomer.sublet.b.a.a;
import com.ziroom.ziroomcustomer.sublet.model.ButtonBean;
import com.ziroom.ziroomcustomer.sublet.model.SubletTurnDetailBean.ButtonBean;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.widget.InfoBlockLayout;
import com.ziroom.ziroomcustomer.widget.LinearLayoutForListView;
import java.util.List;

public class SubletInitiatorDetailActivity
  extends BaseActivity
{
  private com.ziroom.ziroomcustomer.sublet.b.a a;
  private String b;
  @BindView(2131692782)
  Button btnChangeSubletTime;
  private boolean c;
  private Context d;
  private List<SubletTurnDetailBean.ButtonBean> e;
  private PopupWindow f;
  private boolean g = false;
  @BindView(2131692779)
  ImageView ivSubletTitleMore;
  @BindView(2131692781)
  LinearLayout llChangeTimeContainer;
  @BindView(2131692788)
  InfoBlockLayout mIblLinks;
  @BindView(2131692785)
  InfoBlockLayout mIblTurnLinks;
  @BindView(2131689492)
  ImageView mIvBack;
  @BindView(2131690082)
  ImageView mIvEmpty;
  @BindView(2131692789)
  LinearLayout mLLBottomButtons;
  @BindView(2131696462)
  LinearLayout mLlBookCode;
  @BindView(2131694408)
  LinearLayout mLlKakaEmpty;
  @BindView(2131696467)
  LinearLayout mLlPayTime;
  @BindView(2131696472)
  LinearLayout mLlRentoutDay;
  @BindView(2131692784)
  LinearLayout mLlTurnButtons;
  @BindView(2131692787)
  LinearLayoutForListView mLvProcess;
  @BindView(2131696457)
  SimpleDraweeView mSdvHouseInfoPic;
  @BindView(2131696454)
  TextView mTvBookCode;
  @BindView(2131696463)
  TextView mTvBookCodeRefresh;
  @BindView(2131696464)
  TextView mTvBookCodeShare;
  @BindView(2131690822)
  TextView mTvEmpty;
  @BindView(2131696460)
  TextView mTvHouseInfoDesc;
  @BindView(2131696459)
  TextView mTvHouseInfoDesc2;
  @BindView(2131696458)
  TextView mTvHouseInfoTitle;
  @BindView(2131696469)
  TextView mTvPayTimeHour;
  @BindView(2131696470)
  TextView mTvPayTimeMinute;
  @BindView(2131696471)
  TextView mTvPayTimeSecond;
  @BindView(2131696468)
  TextView mTvPayTimeTitle;
  @BindView(2131692786)
  TextView mTvProcessTitle;
  @BindView(2131696473)
  TextView mTvRentoutDay;
  @BindView(2131689822)
  TextView mTvStatus;
  @BindView(2131696465)
  TextView mTvSubletDays;
  @BindView(2131696466)
  TextView mTvSubletViewCounts;
  @BindView(2131696474)
  TextView mTvTenantName;
  @BindView(2131689541)
  TextView mTvTitle;
  @BindView(2131692790)
  View mVBottomDivider;
  @BindView(2131692783)
  View mVZhuanFasterTipsDivider;
  
  private void a()
  {
    if (this.g)
    {
      this.g = false;
      if (this.f != null) {
        this.f.dismiss();
      }
      return;
    }
    this.g = true;
    if (this.f == null)
    {
      localObject1 = LayoutInflater.from(this.d).inflate(2130905065, null);
      this.f = new PopupWindow((View)localObject1, -2, -2, false);
      this.f.setOutsideTouchable(true);
      this.f.setContentView((View)localObject1);
      localObject1 = (LinearLayout)((View)localObject1).findViewById(2131697344);
      if ((this.e != null) && (this.e.size() > 0))
      {
        i = 0;
        if (i < this.e.size())
        {
          localObject2 = (SubletTurnDetailBean.ButtonBean)this.e.get(i);
          View localView1;
          View localView2;
          if (localObject2 != null)
          {
            localView1 = LayoutInflater.from(this.d).inflate(2130904438, null);
            localView2 = localView1.findViewById(2131695538);
            ((TextView)localView1.findViewById(2131695539)).setText(((SubletTurnDetailBean.ButtonBean)localObject2).getText());
            localView1.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymousView)
              {
                VdsAgent.onClick(this, paramAnonymousView);
                com.ziroom.ziroomcustomer.sublet.b.a locala = SubletInitiatorDetailActivity.b(SubletInitiatorDetailActivity.this);
                locala.getClass();
                new a.a(locala, new ButtonBean(localObject2)).onClick(paramAnonymousView);
                SubletInitiatorDetailActivity.c(SubletInitiatorDetailActivity.this).dismiss();
              }
            });
            if (i != 0) {
              break label227;
            }
            localView2.setVisibility(8);
          }
          for (;;)
          {
            ((LinearLayout)localObject1).addView(localView1);
            i += 1;
            break;
            label227:
            localView2.setVisibility(0);
          }
        }
      }
    }
    Object localObject1 = this.f;
    final Object localObject2 = this.ivSubletTitleMore;
    int i = -n.dip2px(this.d, 14.0F);
    if (!(localObject1 instanceof PopupWindow))
    {
      ((PopupWindow)localObject1).showAsDropDown((View)localObject2, 0, i);
      return;
    }
    VdsAgent.showAsDropDown((PopupWindow)localObject1, (View)localObject2, 0, i);
  }
  
  public void closeError()
  {
    this.mLlKakaEmpty.setVisibility(8);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = this;
    setContentView(2130903571);
    ButterKnife.bind(this);
    this.a = new com.ziroom.ziroomcustomer.sublet.b.a(this);
    this.b = getIntent().getStringExtra("contract_code");
    this.c = getIntent().getBooleanExtra("isFromSuccess", false);
    this.ivSubletTitleMore.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        SubletInitiatorDetailActivity.a(SubletInitiatorDetailActivity.this);
      }
    });
  }
  
  protected void onDestroy()
  {
    if (this.a != null) {
      this.a.dettachView();
    }
    this.a = null;
    super.onDestroy();
  }
  
  protected void onResume()
  {
    this.a.initData(this.b);
    super.onResume();
  }
  
  @OnClick({2131689492, 2131696463, 2131692782})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131692782: 
      paramView = new Intent(this, LeaseSubletSelectTimeActivity.class);
      paramView.putExtra("lease", this.b);
      paramView.putExtra("isNewSublet", false);
      startActivity(paramView);
      return;
    case 2131689492: 
      if (this.c) {
        startActivity(new Intent(this, MainActivity.class));
      }
      finish();
      return;
    }
    this.a.initData(this.b);
  }
  
  public void refreshView()
  {
    this.a.initData(this.b);
  }
  
  public void showBookCode(String paramString1, String paramString2, String paramString3, View.OnClickListener paramOnClickListener)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      this.mLlBookCode.setVisibility(8);
      return;
    }
    this.mLlBookCode.setVisibility(0);
    this.mTvBookCode.setText(paramString1);
    this.mTvSubletDays.setText(paramString2);
    this.mTvSubletViewCounts.setText(paramString3);
    this.mTvBookCodeRefresh.setOnClickListener(paramOnClickListener);
    paramString1 = getResources().getDrawable(2130840475);
    float f1 = getResources().getDisplayMetrics().density;
    int i = (int)(18.0F * f1);
    paramString1.setBounds(0, 0, i, i);
    this.mTvBookCodeShare.setCompoundDrawables(paramString1, null, null, null);
    this.mTvBookCodeShare.setCompoundDrawablePadding((int)(f1 * 2.0F));
    this.mTvBookCodeShare.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        SubletInitiatorDetailActivity.b(SubletInitiatorDetailActivity.this).showBookcodeShare();
      }
    });
  }
  
  public void showBottomButtons(List<TextView> paramList)
  {
    if ((paramList == null) || (paramList.size() < 1))
    {
      this.mLLBottomButtons.setVisibility(8);
      this.mVBottomDivider.setVisibility(8);
      return;
    }
    this.mLLBottomButtons.setVisibility(0);
    this.mVBottomDivider.setVisibility(0);
    this.mLLBottomButtons.removeAllViews();
    if (paramList.size() == 1)
    {
      paramList = (TextView)paramList.get(0);
      paramList.setGravity(17);
      paramList.setBackgroundColor(getResources().getColor(2131624588));
      paramList.setTextColor(getResources().getColor(2131624583));
      paramList.setTextSize(2, 16.0F);
      paramList.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      this.mLLBottomButtons.addView(paramList);
      return;
    }
    Object localObject = (TextView)paramList.get(0);
    ((TextView)localObject).setGravity(17);
    ((TextView)localObject).setBackgroundColor(getResources().getColor(2131624583));
    ((TextView)localObject).setTextColor(getResources().getColor(2131624416));
    ((TextView)localObject).setTextSize(2, 16.0F);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    localLayoutParams.weight = 1.0F;
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    this.mLLBottomButtons.addView((View)localObject);
    paramList = (TextView)paramList.get(1);
    paramList.setGravity(17);
    paramList.setBackgroundColor(getResources().getColor(2131624588));
    paramList.setTextColor(getResources().getColor(2131624583));
    paramList.setTextSize(2, 16.0F);
    localObject = new LinearLayout.LayoutParams(-2, -1);
    ((LinearLayout.LayoutParams)localObject).weight = 2.0F;
    paramList.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.mLLBottomButtons.addView(paramList);
  }
  
  public void showChangeTime(String paramString)
  {
    if (ae.notNull(paramString))
    {
      this.llChangeTimeContainer.setVisibility(8);
      return;
    }
    this.llChangeTimeContainer.setVisibility(0);
  }
  
  public void showError()
  {
    this.mLlKakaEmpty.setVisibility(0);
    this.mTvEmpty.setText("数据异常，请点击图片刷新");
    this.mIvEmpty.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        SubletInitiatorDetailActivity.b(SubletInitiatorDetailActivity.this).initData(SubletInitiatorDetailActivity.d(SubletInitiatorDetailActivity.this));
      }
    });
  }
  
  public void showHouseInfo(String paramString1, String paramString2, String paramString3, String paramString4, View.OnClickListener paramOnClickListener)
  {
    this.mSdvHouseInfoPic.setController(c.frescoController(paramString1));
    this.mTvHouseInfoTitle.setText(paramString2);
    this.mTvHouseInfoDesc.setText(paramString3);
    this.mTvHouseInfoDesc2.setText(paramString4);
    this.mTvHouseInfoDesc2.setOnClickListener(paramOnClickListener);
  }
  
  public void showLinks(String paramString, List<InfoItem> paramList)
  {
    if ((paramList == null) || (paramList.size() < 1))
    {
      this.mIblLinks.setVisibility(8);
      return;
    }
    this.mIblLinks.setVisibility(0);
    this.mIblLinks.initData(paramString, paramList);
  }
  
  public void showPayTime(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramInt3 == 0))
    {
      this.mLlPayTime.setVisibility(8);
      return;
    }
    this.mLlPayTime.setVisibility(0);
    String str1;
    String str2;
    if (paramInt1 < 10)
    {
      str1 = "0" + paramInt1;
      if (paramInt2 >= 10) {
        break label167;
      }
      str2 = "0" + paramInt2;
      label86:
      if (paramInt3 >= 10) {
        break label192;
      }
    }
    label167:
    label192:
    for (String str3 = "0" + paramInt3;; str3 = "" + paramInt3)
    {
      this.mTvPayTimeHour.setText(str1);
      this.mTvPayTimeMinute.setText(str2);
      this.mTvPayTimeSecond.setText(str3);
      return;
      str1 = "" + paramInt1;
      break;
      str2 = "" + paramInt2;
      break label86;
    }
  }
  
  public void showProcess(com.ziroom.ziroomcustomer.sublet.a.a parama)
  {
    if ((parama == null) || (parama.getCount() < 1))
    {
      this.mTvProcessTitle.setVisibility(8);
      this.mLvProcess.setVisibility(8);
      return;
    }
    this.mTvProcessTitle.setVisibility(0);
    this.mLvProcess.setVisibility(0);
    this.mLvProcess.setDividerVisibility(false);
    this.mLvProcess.setAdapter(parama);
  }
  
  public void showRentoutDay(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.mLlRentoutDay.setVisibility(8);
      return;
    }
    this.mLlRentoutDay.setVisibility(0);
    this.mTvRentoutDay.setText(paramString);
  }
  
  public void showStatusTag(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.mTvStatus.setVisibility(8);
      return;
    }
    this.mTvStatus.setVisibility(0);
    this.mTvStatus.setText(paramString);
    this.mTvStatus.setTextColor(paramInt1);
    if (paramInt2 != 0)
    {
      paramString = getResources().getDrawable(paramInt2);
      paramInt1 = (int)(getResources().getDisplayMetrics().density * 18.0F);
      paramString.setBounds(0, 0, paramInt1, paramInt1);
      this.mTvStatus.setCompoundDrawables(paramString, null, null, null);
      return;
    }
    this.mTvStatus.setCompoundDrawables(null, null, null, null);
  }
  
  public void showTenant(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.mTvTenantName.setVisibility(8);
      return;
    }
    this.mTvTenantName.setVisibility(0);
    this.mTvTenantName.setText(paramString);
  }
  
  public void showTitleButton(List<SubletTurnDetailBean.ButtonBean> paramList)
  {
    this.e = paramList;
    this.f = null;
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.ivSubletTitleMore.setVisibility(0);
      return;
    }
    this.ivSubletTitleMore.setVisibility(8);
  }
  
  public void showTurnButtons(List<TextView> paramList)
  {
    if ((paramList == null) || (paramList.size() < 1))
    {
      this.mLlTurnButtons.setVisibility(8);
      return;
    }
    float f1 = getResources().getDisplayMetrics().density;
    int i = (int)(155.0F * f1);
    this.mLlTurnButtons.setVisibility(0);
    this.mLlTurnButtons.removeAllViews();
    if (paramList.size() == 1)
    {
      paramList = (TextView)paramList.get(0);
      paramList.setTextColor(getResources().getColor(2131624415));
      paramList.setTextSize(2, 14.0F);
      paramList.setGravity(17);
      localObject = new LinearLayout.LayoutParams(i, -1);
      ((LinearLayout.LayoutParams)localObject).gravity = 17;
      paramList.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramList.setBackgroundResource(2130839633);
      this.mLlTurnButtons.addView(paramList);
      return;
    }
    Object localObject = (TextView)paramList.get(0);
    ((TextView)localObject).setTextColor(getResources().getColor(2131624415));
    ((TextView)localObject).setTextSize(2, 14.0F);
    ((TextView)localObject).setGravity(17);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    localLayoutParams.rightMargin = ((int)(f1 * 11.0F));
    localLayoutParams.gravity = 17;
    localLayoutParams.weight = 1.0F;
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    ((TextView)localObject).setBackgroundResource(2130839633);
    this.mLlTurnButtons.addView((View)localObject);
    paramList = (TextView)paramList.get(1);
    paramList.setTextColor(getResources().getColor(2131624588));
    paramList.setTextSize(2, 14.0F);
    paramList.setGravity(17);
    localObject = new LinearLayout.LayoutParams(-2, -1);
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    paramList.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramList.setBackgroundResource(2130839634);
    this.mLlTurnButtons.addView(paramList);
  }
  
  public void showTurnLinks(String paramString, List<InfoItem> paramList)
  {
    if ((paramList == null) || (paramList.size() < 1))
    {
      this.mIblTurnLinks.setVisibility(8);
      return;
    }
    this.mIblTurnLinks.setVisibility(0);
    this.mIblTurnLinks.initData(paramString, paramList);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/activity/SubletInitiatorDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */