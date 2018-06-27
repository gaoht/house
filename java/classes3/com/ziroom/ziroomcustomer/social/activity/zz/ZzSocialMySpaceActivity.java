package com.ziroom.ziroomcustomer.social.activity.zz;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.collection.GrowingIO;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner.b;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner.c;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.social.model.k;
import com.ziroom.ziroomcustomer.social.model.u;
import com.ziroom.ziroomcustomer.social.model.u.a;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.x;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.util.ArrayList;
import java.util.List;

public class ZzSocialMySpaceActivity
  extends BaseActivity
{
  private View[] a;
  private List<String> b;
  @BindView(2131690078)
  ImageView btnBack;
  private String[] c;
  @BindView(2131690977)
  ConvenientBanner cb;
  private boolean d = false;
  private boolean e = false;
  private u f;
  @BindView(2131693084)
  FrameLayout flMyhome;
  @BindView(2131693078)
  FrameLayout flMyphoto;
  private String g = "";
  @BindView(2131693056)
  SimpleDraweeView ivImage;
  @BindView(2131693057)
  LinearLayout llAddPhoto;
  @BindView(2131693083)
  LinearLayout llAddPhotoHome;
  @BindView(2131693077)
  LinearLayout llAddPhotoWall;
  @BindView(2131693079)
  LinearLayout llHome;
  @BindView(2131693073)
  LinearLayout llPhotoWall;
  @BindView(2131693086)
  Button mBtChart;
  @BindView(2131693067)
  FlowLayout mFlTag;
  private List<String> r = new ArrayList();
  @BindView(2131689808)
  RelativeLayout rlTitle;
  @BindView(2131690150)
  ObservableScrollView svContent;
  @BindView(2131690052)
  TextView tvAge;
  @BindView(2131693072)
  TextView tvDes;
  @BindView(2131693081)
  TextView tvEditMyhouse;
  @BindView(2131693075)
  TextView tvEditMyphoto;
  @BindView(2131693070)
  TextView tvEditMyself;
  @BindView(2131693085)
  TextView tvHomeDes;
  @BindView(2131693082)
  TextView tvHomeNoDes;
  @BindView(2131693071)
  TextView tvJob;
  @BindView(2131690049)
  TextView tvName;
  @BindView(2131693076)
  TextView tvPhotoWallNoDes;
  @BindView(2131692856)
  TextView tvProjectListFilter;
  @BindView(2131690981)
  TextView tvSex;
  @BindView(2131693080)
  View vHome;
  @BindView(2131691494)
  View vLineBottom;
  @BindView(2131693074)
  View vPhoto;
  @BindView(2131693062)
  LinearLayout viewGroup;
  
  private void a()
  {
    if (!this.e)
    {
      UserInfo localUserInfo = ApplicationEx.c.getUser();
      if (localUserInfo == null) {
        return;
      }
      if (localUserInfo.getUid().equals(this.g))
      {
        this.mBtChart.setVisibility(8);
        this.tvProjectListFilter.setText("编辑");
        this.tvEditMyhouse.setVisibility(8);
        this.tvEditMyphoto.setVisibility(8);
        this.tvEditMyself.setVisibility(8);
        this.vHome.setVisibility(0);
        this.vPhoto.setVisibility(0);
      }
    }
    for (;;)
    {
      int i = com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b.getScreenWidth(this) - ah.dip2px(this, 48.0F);
      int j = ah.dip2px(this, 24.0F) + i;
      this.ivImage.setLayoutParams(new LinearLayout.LayoutParams(j, j));
      this.llAddPhotoWall.setLayoutParams(new LinearLayout.LayoutParams(i, i / 3 * 2));
      this.llAddPhotoHome.setLayoutParams(new LinearLayout.LayoutParams(i, i / 3 * 2));
      this.llAddPhotoWall.setTranslationX(ah.dip2px(this, 24.0F));
      this.llAddPhotoHome.setTranslationX(ah.dip2px(this, 24.0F));
      this.llAddPhotoWall.setTranslationY(ah.dip2px(this, 24.0F));
      this.llAddPhotoHome.setTranslationY(ah.dip2px(this, 24.0F));
      this.ivImage.setTranslationY(ah.dip2px(this, 24.0F));
      this.ivImage.setTranslationX(ah.dip2px(this, 24.0F));
      this.flMyhome.setLayoutParams(new LinearLayout.LayoutParams(i, i / 3 * 2));
      this.flMyhome.setTranslationX(ah.dip2px(this, 24.0F));
      this.flMyhome.setTranslationY(ah.dip2px(this, 24.0F));
      this.vLineBottom.setAlpha(0.0F);
      this.svContent.setOnScrollChangedCallback(new ObservableScrollView.a()
      {
        public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          float f = paramAnonymousInt2 / 100.0F;
          ZzSocialMySpaceActivity.this.vLineBottom.setAlpha(f);
        }
      });
      return;
      this.mBtChart.setVisibility(0);
      break;
      this.tvProjectListFilter.setText("完成");
      this.tvEditMyhouse.setVisibility(0);
      this.tvEditMyphoto.setVisibility(0);
      this.tvEditMyself.setVisibility(0);
      this.vHome.setVisibility(4);
      this.vPhoto.setVisibility(4);
    }
  }
  
  private void a(View paramView, String[] paramArrayOfString, int paramInt)
  {
    paramView.setTransitionName("sharedView");
    Intent localIntent = new Intent(this, ZzSocialBigPicsActivity.class);
    localIntent.putExtra("imageUrls", paramArrayOfString);
    localIntent.putExtra("currentImageIndex", paramInt);
    startActivity(localIntent, ActivityOptions.makeScaleUpAnimation(paramView, paramView.getWidth() / 2, paramView.getHeight() / 2, 0, 0).toBundle());
  }
  
  private void a(final List<String> paramList)
  {
    int j = 0;
    int i = 0;
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    this.flMyphoto.removeAllViews();
    switch (paramList.size())
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      paramList = new LinearLayout.LayoutParams(com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b.getScreenWidth(this), i + ah.dip2px(this, 48.0F));
      this.flMyphoto.setLayoutParams(paramList);
      return;
      j = com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b.getScreenWidth(this) - ah.dip2px(this, 48.0F);
      i = j * 2 / 3;
      Object localObject1 = new SimpleDraweeView(this);
      ((SimpleDraweeView)localObject1).setLayoutParams(new FrameLayout.LayoutParams(j, i));
      ((SimpleDraweeView)localObject1).setTranslationY(ah.dip2px(this, 24.0F));
      ((SimpleDraweeView)localObject1).setTranslationX(ah.dip2px(this, 24.0F));
      Object localObject2 = new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(300).build();
      Object localObject3 = new RoundingParams();
      ((RoundingParams)localObject3).setCornersRadius(com.ziroom.ziroomcustomer.util.n.dip2px(this, 2.0F));
      ((GenericDraweeHierarchy)localObject2).setRoundingParams((RoundingParams)localObject3);
      ((SimpleDraweeView)localObject1).setHierarchy((DraweeHierarchy)localObject2);
      ((SimpleDraweeView)localObject1).setController(c.frescoController((String)paramList.get(0)));
      ((SimpleDraweeView)localObject1).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          String str = (String)paramList.get(0);
          ZzSocialMySpaceActivity.a(ZzSocialMySpaceActivity.this, paramAnonymousView, new String[] { str }, 0);
        }
      });
      this.flMyphoto.addView((View)localObject1);
      continue;
      i = (com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b.getScreenWidth(this) - ah.dip2px(this, 52.0F)) / 2;
      localObject1 = new FrameLayout.LayoutParams(i, i);
      localObject2 = new SimpleDraweeView(this);
      ((SimpleDraweeView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ((SimpleDraweeView)localObject2).setTranslationY(ah.dip2px(this, 24.0F));
      ((SimpleDraweeView)localObject2).setTranslationX(ah.dip2px(this, 24.0F));
      localObject3 = new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(300).build();
      RoundingParams localRoundingParams = new RoundingParams();
      localRoundingParams.setCornersRadius(com.ziroom.ziroomcustomer.util.n.dip2px(this, 2.0F));
      ((GenericDraweeHierarchy)localObject3).setRoundingParams(localRoundingParams);
      ((SimpleDraweeView)localObject2).setHierarchy((DraweeHierarchy)localObject3);
      ((SimpleDraweeView)localObject2).setController(c.frescoController((String)paramList.get(0)));
      ((SimpleDraweeView)localObject2).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          String str1 = (String)paramList.get(0);
          String str2 = (String)paramList.get(1);
          ZzSocialMySpaceActivity.a(ZzSocialMySpaceActivity.this, paramAnonymousView, new String[] { str1, str2 }, 0);
        }
      });
      this.flMyphoto.addView((View)localObject2);
      localObject2 = new SimpleDraweeView(this);
      ((SimpleDraweeView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ((SimpleDraweeView)localObject2).setTranslationY(ah.dip2px(this, 24.0F));
      ((SimpleDraweeView)localObject2).setTranslationX(ah.dip2px(this, 28.0F) + i);
      localObject1 = new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(300).build();
      localObject3 = new RoundingParams();
      ((RoundingParams)localObject3).setCornersRadius(com.ziroom.ziroomcustomer.util.n.dip2px(this, 2.0F));
      ((GenericDraweeHierarchy)localObject1).setRoundingParams((RoundingParams)localObject3);
      ((SimpleDraweeView)localObject2).setHierarchy((DraweeHierarchy)localObject1);
      ((SimpleDraweeView)localObject2).setController(c.frescoController((String)paramList.get(1)));
      ((SimpleDraweeView)localObject2).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          String str1 = (String)paramList.get(0);
          String str2 = (String)paramList.get(1);
          ZzSocialMySpaceActivity.a(ZzSocialMySpaceActivity.this, paramAnonymousView, new String[] { str1, str2 }, 1);
        }
      });
      this.flMyphoto.addView((View)localObject2);
      continue;
      int k = com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b.getScreenWidth(this) - ah.dip2px(this, 52.0F);
      j = k / 3 * 2;
      localObject2 = new FrameLayout.LayoutParams(j, j);
      localObject1 = new SimpleDraweeView(this);
      ((SimpleDraweeView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((SimpleDraweeView)localObject1).setTranslationY(ah.dip2px(this, 24.0F));
      ((SimpleDraweeView)localObject1).setTranslationX(ah.dip2px(this, 24.0F));
      localObject2 = new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(300).build();
      localObject3 = new RoundingParams();
      ((RoundingParams)localObject3).setCornersRadius(com.ziroom.ziroomcustomer.util.n.dip2px(this, 2.0F));
      ((GenericDraweeHierarchy)localObject2).setRoundingParams((RoundingParams)localObject3);
      ((SimpleDraweeView)localObject1).setHierarchy((DraweeHierarchy)localObject2);
      ((SimpleDraweeView)localObject1).setController(c.frescoController((String)paramList.get(0)));
      ((SimpleDraweeView)localObject1).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          String str1 = (String)paramList.get(0);
          String str2 = (String)paramList.get(1);
          String str3 = (String)paramList.get(2);
          ZzSocialMySpaceActivity.a(ZzSocialMySpaceActivity.this, paramAnonymousView, new String[] { str1, str2, str3 }, 0);
        }
      });
      this.flMyphoto.addView((View)localObject1);
      while (i < 2)
      {
        localObject1 = new SimpleDraweeView(this);
        ((SimpleDraweeView)localObject1).setLayoutParams(new FrameLayout.LayoutParams(k / 3 - ah.dip2px(this, 4.0F), k / 3 - ah.dip2px(this, 2.0F)));
        ((SimpleDraweeView)localObject1).setTranslationY((k / 3 + ah.dip2px(this, 2.0F)) * i + ah.dip2px(this, 24.0F));
        ((SimpleDraweeView)localObject1).setTranslationX(k / 3 * 2 + ah.dip2px(this, 28.0F));
        localObject2 = new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(300).build();
        localObject3 = new RoundingParams();
        ((RoundingParams)localObject3).setCornersRadius(com.ziroom.ziroomcustomer.util.n.dip2px(this, 2.0F));
        ((GenericDraweeHierarchy)localObject2).setRoundingParams((RoundingParams)localObject3);
        ((SimpleDraweeView)localObject1).setHierarchy((DraweeHierarchy)localObject2);
        ((SimpleDraweeView)localObject1).setController(c.frescoController((String)paramList.get(i + 1)));
        ((SimpleDraweeView)localObject1).setTag(Integer.valueOf(i));
        this.flMyphoto.addView((View)localObject1);
        ((SimpleDraweeView)localObject1).setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            String str1 = (String)paramList.get(0);
            String str2 = (String)paramList.get(1);
            String str3 = (String)paramList.get(2);
            ZzSocialMySpaceActivity localZzSocialMySpaceActivity = ZzSocialMySpaceActivity.this;
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            ZzSocialMySpaceActivity.a(localZzSocialMySpaceActivity, paramAnonymousView, new String[] { str1, str2, str3 }, i + 1);
          }
        });
        i += 1;
      }
      i = j;
      continue;
      k = com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b.getScreenWidth(this) - ah.dip2px(this, 48.0F);
      int m = ah.dip2px(this, 7.0F);
      localObject3 = new FrameLayout.LayoutParams(k, k / 3 * 2);
      localObject1 = new FrameLayout.LayoutParams((k - ah.dip2px(this, 8.0F)) / 3, (k - ah.dip2px(this, 8.0F)) / 3);
      localObject2 = new SimpleDraweeView(this);
      ((SimpleDraweeView)localObject2).setTranslationY(ah.dip2px(this, 24.0F));
      ((SimpleDraweeView)localObject2).setTranslationX(ah.dip2px(this, 24.0F));
      ((SimpleDraweeView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject3 = new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(300).build();
      localRoundingParams = new RoundingParams();
      localRoundingParams.setCornersRadius(com.ziroom.ziroomcustomer.util.n.dip2px(this, 2.0F));
      ((GenericDraweeHierarchy)localObject3).setRoundingParams(localRoundingParams);
      ((SimpleDraweeView)localObject2).setHierarchy((DraweeHierarchy)localObject3);
      ((SimpleDraweeView)localObject2).setController(c.frescoController((String)paramList.get(0)));
      ((SimpleDraweeView)localObject2).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          String str1 = (String)paramList.get(0);
          String str2 = (String)paramList.get(1);
          String str3 = (String)paramList.get(2);
          String str4 = (String)paramList.get(3);
          ZzSocialMySpaceActivity.a(ZzSocialMySpaceActivity.this, paramAnonymousView, new String[] { str1, str2, str3, str4 }, 0);
        }
      });
      this.flMyphoto.addView((View)localObject2);
      i = j;
      while (i < 3)
      {
        localObject2 = new SimpleDraweeView(this);
        ((SimpleDraweeView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ((SimpleDraweeView)localObject2).setTranslationY(ah.dip2px(this, 28.0F) + k / 3 * 2);
        ((SimpleDraweeView)localObject2).setTranslationX(ah.dip2px(this, 24.0F) + ((k - ah.dip2px(this, 8.0F)) / 3 + ah.dip2px(this, 4.0F)) * i);
        localObject3 = new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(300).build();
        localRoundingParams = new RoundingParams();
        localRoundingParams.setCornersRadius(com.ziroom.ziroomcustomer.util.n.dip2px(this, 2.0F));
        ((GenericDraweeHierarchy)localObject3).setRoundingParams(localRoundingParams);
        ((SimpleDraweeView)localObject2).setHierarchy((DraweeHierarchy)localObject3);
        ((SimpleDraweeView)localObject2).setController(c.frescoController((String)paramList.get(i + 1)));
        ((SimpleDraweeView)localObject2).setTag(Integer.valueOf(i));
        this.flMyphoto.addView((View)localObject2);
        ((SimpleDraweeView)localObject2).setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            String str1 = (String)paramList.get(0);
            String str2 = (String)paramList.get(1);
            String str3 = (String)paramList.get(2);
            String str4 = (String)paramList.get(3);
            ZzSocialMySpaceActivity localZzSocialMySpaceActivity = ZzSocialMySpaceActivity.this;
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            ZzSocialMySpaceActivity.a(localZzSocialMySpaceActivity, paramAnonymousView, new String[] { str1, str2, str3, str4 }, i + 1);
          }
        });
        i += 1;
      }
      i = k - m;
    }
  }
  
  private void b()
  {
    com.ziroom.ziroomcustomer.e.n.requestGetUserInfo(this, this.g, new d(this, new com.ziroom.ziroomcustomer.e.c.f(u.class))
    {
      public void onSuccess(int paramAnonymousInt, u paramAnonymousu)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousu);
        ZzSocialMySpaceActivity.a(ZzSocialMySpaceActivity.this, paramAnonymousu);
        if (paramAnonymousu == null) {
          return;
        }
        ZzSocialMySpaceActivity.this.tvName.setText(paramAnonymousu.getNick_name());
        ZzSocialMySpaceActivity.this.tvAge.setText(paramAnonymousu.getAge() + "岁");
        String str;
        if (com.freelxl.baselibrary.f.f.notNull(paramAnonymousu.getCompany_short()))
        {
          ZzSocialMySpaceActivity.this.tvJob.setText(paramAnonymousu.getCompany_short() + " · " + paramAnonymousu.getDirection());
          TextView localTextView = ZzSocialMySpaceActivity.this.tvSex;
          if (paramAnonymousu.getGender() != 1) {
            break label421;
          }
          str = "男";
          label135:
          localTextView.setText(str);
          ZzSocialMySpaceActivity.this.tvHomeNoDes.setText(paramAnonymousu.getTips().getHome_title());
          ZzSocialMySpaceActivity.this.tvPhotoWallNoDes.setText(paramAnonymousu.getTips().getPhotos());
          if (!com.freelxl.baselibrary.f.f.notNull(paramAnonymousu.getHead_img())) {
            break label427;
          }
          ZzSocialMySpaceActivity.this.ivImage.setVisibility(0);
          ZzSocialMySpaceActivity.this.llAddPhoto.setVisibility(8);
          ZzSocialMySpaceActivity.this.ivImage.setController(c.frescoController(paramAnonymousu.getHead_img()));
          label225:
          if (!com.freelxl.baselibrary.f.f.notNull(paramAnonymousu.getDescription())) {
            break label453;
          }
          ZzSocialMySpaceActivity.this.tvDes.setText(paramAnonymousu.getDescription());
        }
        for (;;)
        {
          label249:
          if ((paramAnonymousu.getTags() != null) && (paramAnonymousu.getTags().size() > 0))
          {
            ZzSocialMySpaceActivity.this.mFlTag.setVisibility(0);
            ZzSocialMySpaceActivity.a(ZzSocialMySpaceActivity.this).clear();
            ZzSocialMySpaceActivity.this.mFlTag.removeAllViews();
            paramAnonymousInt = 0;
            for (;;)
            {
              if (paramAnonymousInt < paramAnonymousu.getTags().size())
              {
                ZzSocialMySpaceActivity.a(ZzSocialMySpaceActivity.this).add(((u.a)paramAnonymousu.getTags().get(paramAnonymousInt)).getName());
                paramAnonymousInt += 1;
                continue;
                if (com.freelxl.baselibrary.f.f.isNull(paramAnonymousu.getCompany()))
                {
                  ZzSocialMySpaceActivity.this.tvJob.setText(paramAnonymousu.getDirection());
                  break;
                }
                ZzSocialMySpaceActivity.this.tvJob.setText(paramAnonymousu.getCompany() + " · " + paramAnonymousu.getDirection());
                break;
                label421:
                str = "女";
                break label135;
                label427:
                ZzSocialMySpaceActivity.this.ivImage.setVisibility(8);
                ZzSocialMySpaceActivity.this.llAddPhoto.setVisibility(0);
                break label225;
                label453:
                ZzSocialMySpaceActivity.this.tvDes.setText("这个家伙比较懒，什么都没说...");
                break label249;
              }
            }
            j.addZzSocialFlke2(ZzSocialMySpaceActivity.this, ZzSocialMySpaceActivity.a(ZzSocialMySpaceActivity.this), ZzSocialMySpaceActivity.this.mFlTag);
            if ((paramAnonymousu.getPhotos() != null) && (paramAnonymousu.getPhotos().size() != 0)) {
              break label817;
            }
            if (!ZzSocialMySpaceActivity.b(ZzSocialMySpaceActivity.this)) {
              break label766;
            }
            ZzSocialMySpaceActivity.this.tvPhotoWallNoDes.setVisibility(0);
            ZzSocialMySpaceActivity.this.llAddPhotoWall.setVisibility(0);
            ZzSocialMySpaceActivity.this.llPhotoWall.setVisibility(0);
            ZzSocialMySpaceActivity.this.flMyphoto.setVisibility(8);
            if (!ZzSocialMySpaceActivity.c(ZzSocialMySpaceActivity.this)) {
              break label752;
            }
            ZzSocialMySpaceActivity.this.vPhoto.setVisibility(4);
          }
        }
        for (;;)
        {
          ZzSocialMySpaceActivity.this.tvHomeDes.setText(paramAnonymousu.getHome().getDescription());
          ZzSocialMySpaceActivity.b(ZzSocialMySpaceActivity.this, paramAnonymousu.getHome().getPhotos());
          ZzSocialMySpaceActivity.d(ZzSocialMySpaceActivity.this);
          if (!ZzSocialMySpaceActivity.b(ZzSocialMySpaceActivity.this)) {
            break label936;
          }
          ZzSocialMySpaceActivity.this.llHome.setVisibility(0);
          if ((ZzSocialMySpaceActivity.e(ZzSocialMySpaceActivity.this) == null) || (ZzSocialMySpaceActivity.e(ZzSocialMySpaceActivity.this).size() <= 0)) {
            break label889;
          }
          ZzSocialMySpaceActivity.this.tvHomeNoDes.setVisibility(8);
          ZzSocialMySpaceActivity.this.llAddPhotoHome.setVisibility(8);
          ZzSocialMySpaceActivity.this.flMyhome.setVisibility(0);
          ZzSocialMySpaceActivity.this.tvHomeDes.setVisibility(0);
          if (!ZzSocialMySpaceActivity.c(ZzSocialMySpaceActivity.this)) {
            break label877;
          }
          ZzSocialMySpaceActivity.this.vHome.setVisibility(4);
          return;
          ZzSocialMySpaceActivity.this.mFlTag.setVisibility(8);
          break;
          label752:
          ZzSocialMySpaceActivity.this.vPhoto.setVisibility(0);
          continue;
          label766:
          ZzSocialMySpaceActivity.this.tvPhotoWallNoDes.setVisibility(8);
          ZzSocialMySpaceActivity.this.llAddPhotoWall.setVisibility(8);
          ZzSocialMySpaceActivity.this.llPhotoWall.setVisibility(8);
          ZzSocialMySpaceActivity.this.flMyphoto.setVisibility(8);
          continue;
          label817:
          ZzSocialMySpaceActivity.this.tvPhotoWallNoDes.setVisibility(8);
          ZzSocialMySpaceActivity.this.llAddPhotoWall.setVisibility(8);
          ZzSocialMySpaceActivity.this.llPhotoWall.setVisibility(0);
          ZzSocialMySpaceActivity.this.flMyphoto.setVisibility(0);
          ZzSocialMySpaceActivity.a(ZzSocialMySpaceActivity.this, paramAnonymousu.getPhotos());
        }
        label877:
        ZzSocialMySpaceActivity.this.vHome.setVisibility(0);
        return;
        label889:
        ZzSocialMySpaceActivity.this.tvHomeNoDes.setVisibility(0);
        ZzSocialMySpaceActivity.this.llAddPhotoHome.setVisibility(0);
        ZzSocialMySpaceActivity.this.flMyhome.setVisibility(8);
        ZzSocialMySpaceActivity.this.tvHomeDes.setVisibility(8);
        return;
        label936:
        ZzSocialMySpaceActivity.this.llHome.setVisibility(0);
        ZzSocialMySpaceActivity.this.tvHomeNoDes.setVisibility(8);
        ZzSocialMySpaceActivity.this.llAddPhotoHome.setVisibility(8);
        if ((ZzSocialMySpaceActivity.e(ZzSocialMySpaceActivity.this) != null) && (ZzSocialMySpaceActivity.e(ZzSocialMySpaceActivity.this).size() > 0))
        {
          ZzSocialMySpaceActivity.this.flMyhome.setVisibility(0);
          ZzSocialMySpaceActivity.this.tvHomeDes.setVisibility(0);
          return;
        }
        ZzSocialMySpaceActivity.this.flMyhome.setVisibility(8);
        ZzSocialMySpaceActivity.this.tvHomeDes.setVisibility(8);
        ZzSocialMySpaceActivity.this.llHome.setVisibility(8);
      }
    });
  }
  
  private void b(int paramInt)
  {
    int i = 0;
    if (i < this.a.length)
    {
      if (i == paramInt) {
        this.a[i].setBackgroundColor(-1);
      }
      for (;;)
      {
        i += 1;
        break;
        this.a[i].setBackgroundColor(-2130706433);
      }
    }
  }
  
  private void e()
  {
    if ((this.b == null) || (this.b.size() == 0)) {
      return;
    }
    this.a = new View[this.b.size()];
    this.viewGroup.removeAllViews();
    int i = 0;
    if (i < this.a.length)
    {
      View localView = new View(this);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ah.dip2px(this, 14.0F), ah.dip2px(this, 2.0F));
      localLayoutParams.setMargins(ah.dip2px(this, 2.0F), 0, ah.dip2px(this, 2.0F), 0);
      localView.setLayoutParams(localLayoutParams);
      this.a[i] = localView;
      if (i == 0) {
        localView.setBackgroundColor(-2130706433);
      }
      for (;;)
      {
        this.viewGroup.addView(localView);
        i += 1;
        break;
        localView.setBackgroundColor(-1);
      }
    }
    if (this.a.length == 1) {
      this.viewGroup.setVisibility(8);
    }
    for (;;)
    {
      this.c = new String[this.b.size()];
      i = 0;
      while (i < this.b.size())
      {
        this.c[i] = ((String)this.b.get(i));
        i += 1;
      }
      this.viewGroup.setVisibility(0);
    }
    this.cb.setPages(new com.ziroom.commonlibrary.widget.convenientbanner.b.a()
    {
      public ZzSocialMySpaceActivity.a createHolder()
      {
        return new ZzSocialMySpaceActivity.a(ZzSocialMySpaceActivity.this, null);
      }
    }, this.b, new ConvenientBanner.b()
    {
      public void configGio(ViewPager paramAnonymousViewPager)
      {
        if ((paramAnonymousViewPager != null) && (paramAnonymousViewPager.getAdapter() != null) && (paramAnonymousViewPager.getAdapter().getCount() > 0))
        {
          ArrayList localArrayList = new ArrayList();
          int i = 0;
          while (i < paramAnonymousViewPager.getAdapter().getCount())
          {
            localArrayList.add("轮播图-" + i);
            i += 1;
          }
          GrowingIO.getInstance();
          GrowingIO.trackBanner(paramAnonymousViewPager, localArrayList);
        }
      }
    }).setPageIndicatorAlign(ConvenientBanner.c.c).setCoverBottomViewVisible(true).setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt)
      {
        ZzSocialMySpaceActivity.a(ZzSocialMySpaceActivity.this, paramAnonymousInt % ZzSocialMySpaceActivity.f(ZzSocialMySpaceActivity.this).length);
      }
    }).setPointViewVisible(false);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    b();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903632);
    ButterKnife.bind(this);
    this.g = getIntent().getStringExtra("be_uid");
    this.d = getIntent().getBooleanExtra("isEditer", false);
    if (this.d)
    {
      this.tvProjectListFilter.setText("编辑");
      this.tvProjectListFilter.setVisibility(0);
    }
    for (;;)
    {
      a();
      b();
      return;
      this.tvProjectListFilter.setVisibility(4);
    }
  }
  
  @OnClick({2131692856, 2131690078, 2131693070, 2131693057, 2131693075, 2131693081, 2131693077, 2131693083, 2131693086})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131693057: 
    default: 
      return;
    case 2131692856: 
      if (!this.e) {}
      for (boolean bool = true;; bool = false)
      {
        this.e = bool;
        a();
        b();
        return;
      }
    case 2131690078: 
      finish();
      return;
    case 2131693070: 
      paramView = new Intent(this, ZzSocialChangeBaseMessageActivity.class);
      paramView.putExtra("title", this.f.getTips().getHead_name());
      paramView.putExtra("des", this.f.getTips().getDescription());
      startActivityForResult(paramView, 19);
      return;
    case 2131693075: 
    case 2131693077: 
      paramView = new Intent(this, ZzSocialMyPhotosActivity.class);
      paramView.putStringArrayListExtra("photos", (ArrayList)this.f.getPhotos());
      startActivityForResult(paramView, 20);
      return;
    case 2131693081: 
    case 2131693083: 
      paramView = new Intent(this, ZzSocialMyZiroomActivity.class);
      paramView.putStringArrayListExtra("photos", (ArrayList)this.f.getHome().getPhotos());
      paramView.putExtra("des", this.f.getHome().getDescription());
      paramView.putExtra("remark", this.f.getTips().getHome_description());
      startActivityForResult(paramView, 21);
      return;
    }
    paramView = new Intent(this, ZzSocialChatDetailActivity.class);
    paramView.putExtra("toChatUid", this.g);
    paramView.putExtra("toChatPic", this.f.getHead_img());
    paramView.putExtra("toChatName", this.f.getNick_name());
    paramView.putExtra("isFrom", "");
    startActivity(paramView);
  }
  
  private class a
    implements com.ziroom.commonlibrary.widget.convenientbanner.b.b<String>
  {
    private SimpleDraweeView b;
    
    private a() {}
    
    public void UpdateUI(Context paramContext, final int paramInt, String paramString)
    {
      paramContext = x.makeUrl(paramString);
      this.b.setController(c.frescoController(paramContext));
      this.b.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          ZzSocialMySpaceActivity.a(ZzSocialMySpaceActivity.this, paramAnonymousView, ZzSocialMySpaceActivity.g(ZzSocialMySpaceActivity.this), paramInt);
        }
      });
    }
    
    public View createView(Context paramContext)
    {
      this.b = new SimpleDraweeView(paramContext);
      ((GenericDraweeHierarchy)this.b.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
      return this.b;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/zz/ZzSocialMySpaceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */