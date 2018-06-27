package com.ziroom.ziroomcustomer.my.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.collection.GrowingIO;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner.b;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner.c;
import com.ziroom.commonlibrary.widget.convenientbanner.b.a;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.my.MyAppointActivity;
import com.ziroom.ziroomcustomer.my.model.InitiateTipsBean;
import com.ziroom.ziroomcustomer.my.model.InitiateTipsBean.BannerBean;
import com.ziroom.ziroomcustomer.signed.h;
import com.ziroom.ziroomcustomer.signed.h.a;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.x;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.ArrayList;
import java.util.List;

public class InitiateAppointTipsActivity
  extends BaseActivity
{
  private int a;
  private String b;
  private String c;
  @BindView(2131690977)
  ConvenientBanner mCbBanner;
  @BindView(2131690974)
  TextView mTvFindHouse;
  @BindView(2131690071)
  TextView mTvSubtitle;
  @BindView(2131690976)
  TextView mTvTipsContent;
  @BindView(2131690975)
  TextView mTvTipsTitle;
  @BindView(2131689541)
  TextView mTvTitle;
  @BindView(2131690973)
  TextView mTvToAppoint;
  
  private void a()
  {
    InitiateTipsBean localInitiateTipsBean = (InitiateTipsBean)getIntent().getSerializableExtra("initiateTipsBean");
    this.a = getIntent().getIntExtra("isDisplayCoupon", 0);
    this.b = getIntent().getStringExtra("couponUrl");
    this.c = getIntent().getStringExtra("skipUrl");
    a(localInitiateTipsBean);
    b(localInitiateTipsBean);
    e();
  }
  
  private void a(InitiateTipsBean paramInitiateTipsBean)
  {
    this.mTvTitle.setText(paramInitiateTipsBean.getTitle());
    this.mTvSubtitle.setText(paramInitiateTipsBean.getSubtitle());
    this.mTvTipsTitle.setText(paramInitiateTipsBean.getTips_title());
    this.mTvTipsContent.setText(paramInitiateTipsBean.getTips_content());
  }
  
  private void b()
  {
    Object localObject = getResources().getDisplayMetrics();
    int i = (int)((((DisplayMetrics)localObject).widthPixels - ((DisplayMetrics)localObject).density * 36.0F) / 2.5F);
    localObject = (LinearLayout.LayoutParams)this.mCbBanner.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).height = i;
    this.mCbBanner.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(final InitiateTipsBean paramInitiateTipsBean)
  {
    if ((this.mCbBanner != null) && (paramInitiateTipsBean != null) && (paramInitiateTipsBean.getBannar() != null) && (paramInitiateTipsBean.getBannar().size() > 0))
    {
      this.mCbBanner.setVisibility(0);
      GrowingIO.setViewContent(this.mCbBanner, "约看完成轮播图");
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramInitiateTipsBean.getBannar().size())
      {
        localArrayList.add(((InitiateTipsBean.BannerBean)paramInitiateTipsBean.getBannar().get(i)).getImg());
        i += 1;
      }
      this.mCbBanner.setPages(new a()
      {
        public InitiateAppointTipsActivity.a createHolder()
        {
          return new InitiateAppointTipsActivity.a(InitiateAppointTipsActivity.this, null);
        }
      }, localArrayList, new ConvenientBanner.b()
      {
        public void configGio(ViewPager paramAnonymousViewPager)
        {
          if ((paramAnonymousViewPager != null) && (paramAnonymousViewPager.getAdapter() != null) && (paramAnonymousViewPager.getAdapter().getCount() > 0))
          {
            ArrayList localArrayList = new ArrayList();
            int i = 0;
            while (i < paramAnonymousViewPager.getAdapter().getCount())
            {
              localArrayList.add("约看完成轮播图-" + i);
              i += 1;
            }
            GrowingIO.getInstance();
            GrowingIO.trackBanner(paramAnonymousViewPager, localArrayList);
          }
        }
      }).setPageIndicator(new int[] { 2130839319, 2130839311 }).setPageIndicatorAlign(ConvenientBanner.c.c).setCoverBottomViewResource(2130838550).setCoverBottomViewVisible(true).setOnItemClickListener(new com.ziroom.commonlibrary.widget.convenientbanner.c.b()
      {
        public void onItemClick(int paramAnonymousInt)
        {
          InitiateTipsBean.BannerBean localBannerBean = (InitiateTipsBean.BannerBean)paramInitiateTipsBean.getBannar().get(paramAnonymousInt);
          if (localBannerBean != null) {
            JsBridgeWebActivity.start(InitiateAppointTipsActivity.this, localBannerBean.getTitle(), localBannerBean.getTarget(), true, localBannerBean.getDescription(), localBannerBean.getImg(), false);
          }
        }
      }).setPointViewVisible(true);
      this.mCbBanner.startTurning(5000L);
      return;
    }
    this.mCbBanner.setVisibility(8);
  }
  
  private void e()
  {
    if ((this.a == 1) && (!TextUtils.isEmpty(this.b))) {
      h.creatDialog(this, this.b, false, true, this.c, null, new h.a()
      {
        public void closeDialog() {}
        
        public void toMoveHouseWeb(String paramAnonymousString)
        {
          if (ae.notNull(paramAnonymousString)) {
            JsBridgeWebActivity.start(InitiateAppointTipsActivity.this, null, paramAnonymousString);
          }
        }
      });
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903221);
    ButterKnife.bind(this);
    b();
    a();
  }
  
  @OnClick({2131690973, 2131690974})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690973: 
      startActivity(new Intent(this, MyAppointActivity.class));
      return;
    }
    paramView = new Intent("finishHouseDetailActivity");
    LocalBroadcastManager.getInstance(this).sendBroadcast(paramView);
    finish();
  }
  
  private class a
    implements com.ziroom.commonlibrary.widget.convenientbanner.b.b<String>
  {
    private SimpleDraweeView b;
    
    private a() {}
    
    public void UpdateUI(Context paramContext, int paramInt, String paramString)
    {
      paramContext = x.makeUrl(paramString);
      this.b.setController(c.frescoController(paramContext));
    }
    
    public View createView(Context paramContext)
    {
      this.b = new SimpleDraweeView(paramContext);
      ((GenericDraweeHierarchy)this.b.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
      return this.b;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/widget/InitiateAppointTipsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */