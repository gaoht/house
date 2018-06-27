package com.ziroom.ziroomcustomer.ziroomapartment.meetaapartdetail;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.collection.GrowingIO;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.MobSDK;
import com.ziroom.commonlib.utils.l;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientOptiBanner;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Space;
import com.ziroom.ziroomcustomer.findhouse.view.RentHouseDetailSpacePop;
import com.ziroom.ziroomcustomer.home.bean.ContentBean;
import com.ziroom.ziroomcustomer.home.bean.HomeRentItem;
import com.ziroom.ziroomcustomer.home.view.HomeRentItemView;
import com.ziroom.ziroomcustomer.home.view.HomeRentItemView.a;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.BaseHouseTypeInfoVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.CommentsVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.FacilitiesVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.LabelsVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.MiddleBannerVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.ProjectDetailInfoVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.ProjectZoVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.SocialVo;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.util.x;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.widget.CycleViewPager;
import com.ziroom.ziroomcustomer.widget.CycleViewPager.a;
import com.ziroom.ziroomcustomer.widget.CycleViewPager.b;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuScanPhotoActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuSignImgActivity;
import com.ziroom.ziroomcustomer.ziroomstation.widget.FlowLayout;
import com.ziroom.ziroomcustomer.ziroomstation.widget.IntoTagTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MeeTaApartDetailActivity
  extends BaseActivity
  implements ObservableScrollView.a, a.b
{
  @BindView(2131696792)
  SimpleDraweeView SocialVoImageUrl;
  @BindView(2131696789)
  LinearLayout SocialVoLin;
  @BindView(2131696790)
  TextView SocialVoTitle;
  public int a;
  public int b;
  HouseTypeAdapter c;
  @BindView(2131696771)
  ConvenientOptiBanner cbZryuCommentsLunbo;
  @BindView(2131691146)
  ConvenientOptiBanner cbZryuMainLunbo;
  @BindView(2131696783)
  ConvenientOptiBanner cbZryuZoLunbo;
  @BindView(2131696769)
  LinearLayout commentsViewLin;
  @BindView(2131696770)
  TextView commentsViewTitle;
  Context d;
  private String e;
  private a.a f;
  @BindView(2131696773)
  LinearLayout facilitiesViewLin;
  @BindView(2131696774)
  TextView facilitiesViewTitle;
  @BindView(2131696796)
  TextView femaleCount;
  @BindView(2131696797)
  View femaleCountView;
  @BindView(2131696787)
  FlowLayout flLabelsVoStatus;
  private float g;
  @BindView(2131696779)
  RecyclerView houseTypeRecyclerView;
  @BindView(2131696777)
  LinearLayout houseTypeViewLin;
  @BindView(2131696778)
  TextView houseTypeViewTitle;
  @BindView(2131696776)
  LinearLayout llConfig;
  @BindView(2131696058)
  Button mBtnB;
  @BindView(2131696791)
  ImageView mImageView2;
  @BindView(2131689492)
  ImageView mIvBack;
  @BindView(2131690673)
  ImageView mIvShare;
  @BindView(2131691870)
  LinearLayout mLlBtn;
  @BindView(2131696788)
  TextView mMeeTaDtlAddress;
  @BindView(2131696786)
  TextView mMeeTaDtlDesc;
  @BindView(2131691166)
  View mMyinfoTitleLine;
  @BindView(2131691158)
  RelativeLayout mRlMeeTaDtlSlider;
  @BindView(2131691160)
  RecyclerView mRvMeeTaSlider;
  @BindView(2131696793)
  View mTotalCount;
  @BindView(2131691165)
  TextView mTvTitleCircleSeeHouse;
  @BindView(2131691164)
  View mViewBackGround;
  @BindView(2131691150)
  View mViewYuPersonBelow;
  @BindView(2131690894)
  ViewStub mVsError;
  @BindView(2131691157)
  ObservableScrollView mZiOsv;
  @BindView(2131696794)
  TextView maleCount;
  @BindView(2131696795)
  View maleCountView;
  @BindView(2131696785)
  TextView meetaProjectName;
  @BindView(2131696775)
  TextView moreFacilities;
  @BindView(2131691163)
  HomeRentItemView projectRecommendVos;
  private CycleViewPager r;
  private c s;
  @BindView(2131696798)
  TextView signCount;
  @BindView(2131691162)
  HomeRentItemView specialSubjectVo;
  private PlatformActionListener t = new PlatformActionListener()
  {
    public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt) {}
    
    public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
    {
      l.d("#########MeeT分享完成回调:平台", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享成功");
      MeeTaApartDetailActivity.this.showToast("分享成功");
    }
    
    public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
    {
      l.d("######### 1分享失败回调: 平台  ", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享失败");
      paramAnonymousThrowable.printStackTrace();
      l.d("######异常信息", "====" + paramAnonymousThrowable.toString() + "======" + paramAnonymousThrowable.getMessage() + "====" + paramAnonymousThrowable.getLocalizedMessage() + "====" + paramAnonymousThrowable.getSuppressed().toString());
      MeeTaApartDetailActivity.this.showToast("分享失败");
      if ("SinaWeibo".equals(paramAnonymousPlatform.getName()))
      {
        ShareSDK.getPlatform(SinaWeibo.NAME).removeAccount(false);
        ShareSDK.removeCookieOnAuthorize(true);
      }
    }
  };
  @BindView(2131691161)
  TextView tvBriefInfo;
  private CycleViewPager.b u = new CycleViewPager.b()
  {
    public void onPosChange(int paramAnonymousInt)
    {
      if (MeeTaApartDetailActivity.a(MeeTaApartDetailActivity.this).getSlidersTypeIndexs() != null)
      {
        MeeTaApartDetailActivity.this.a = (paramAnonymousInt - 1);
        paramAnonymousInt = 0;
      }
      for (;;)
      {
        if (paramAnonymousInt < MeeTaApartDetailActivity.a(MeeTaApartDetailActivity.this).getSlidersTypeIndexs().size())
        {
          int i = ((Integer)MeeTaApartDetailActivity.a(MeeTaApartDetailActivity.this).getSlidersTypeIndexs().get(paramAnonymousInt)).intValue();
          if (MeeTaApartDetailActivity.this.a >= i) {}
        }
        else
        {
          MeeTaApartDetailActivity.this.b = (paramAnonymousInt - 1);
          MeeTaApartDetailActivity.b(MeeTaApartDetailActivity.this).notifyDataSetChanged();
          return;
        }
        paramAnonymousInt += 1;
      }
    }
  };
  private CycleViewPager.a v = new CycleViewPager.a()
  {
    public void onImageClick(int paramAnonymousInt, View paramAnonymousView)
    {
      if (MeeTaApartDetailActivity.c(MeeTaApartDetailActivity.this).isCycle())
      {
        if (!ae.isNull((String)MeeTaApartDetailActivity.a(MeeTaApartDetailActivity.this).getUrl().get(paramAnonymousInt - 1))) {
          break label188;
        }
        paramAnonymousView = new Intent(MeeTaApartDetailActivity.this, ZryuScanPhotoActivity.class);
        paramAnonymousView.putExtra("position", MeeTaApartDetailActivity.this.a);
        paramAnonymousView.putStringArrayListExtra("photos", MeeTaApartDetailActivity.a(MeeTaApartDetailActivity.this).getSliders());
        paramAnonymousView.putStringArrayListExtra("url", MeeTaApartDetailActivity.a(MeeTaApartDetailActivity.this).getUrl());
        if ((MeeTaApartDetailActivity.a(MeeTaApartDetailActivity.this).getSlidersTypes() != null) && (MeeTaApartDetailActivity.a(MeeTaApartDetailActivity.this).getSlidersTypeIndexs() != null))
        {
          paramAnonymousView.putStringArrayListExtra("types", MeeTaApartDetailActivity.a(MeeTaApartDetailActivity.this).getSlidersTypes());
          paramAnonymousView.putIntegerArrayListExtra("typeIndexs", MeeTaApartDetailActivity.a(MeeTaApartDetailActivity.this).getSlidersTypeIndexs());
        }
        MeeTaApartDetailActivity.this.startActivity(paramAnonymousView);
      }
      for (;;)
      {
        w.onEventToZiroomAndUmeng("zra_xm_pic");
        return;
        label188:
        JsBridgeWebActivity.start(MeeTaApartDetailActivity.this, "", (String)MeeTaApartDetailActivity.a(MeeTaApartDetailActivity.this).getUrl().get(paramAnonymousInt - 1));
      }
    }
  };
  @BindView(2131696772)
  View viewCommentsBelow;
  @BindView(2131691147)
  View viewLunboBelow;
  @BindView(2131696784)
  View viewZoBelow;
  @BindView(2131696781)
  LinearLayout zoViewLin;
  @BindView(2131696782)
  TextView zoViewTitle;
  
  private LinearLayout a(ProjectDetailForAppVo.FacilitiesVo paramFacilitiesVo)
  {
    float f1 = getResources().getDisplayMetrics().density;
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(17);
    ((WindowManager)getSystemService("window")).getDefaultDisplay().getWidth();
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0F));
    if (paramFacilitiesVo == null) {
      return localLinearLayout;
    }
    Object localObject = new SimpleDraweeView(this);
    if (paramFacilitiesVo != null) {
      ((SimpleDraweeView)localObject).setController(com.freelxl.baselibrary.f.c.frescoController(paramFacilitiesVo.iconUrl));
    }
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(32.0F * f1), (int)(32.0F * f1));
    localLayoutParams.bottomMargin = ((int)(f1 * 8.0F));
    ((SimpleDraweeView)localObject).setLayoutParams(localLayoutParams);
    com.freelxl.baselibrary.f.c.frescoHierarchyController((SimpleDraweeView)localObject, 2130839305);
    localLinearLayout.addView((View)localObject);
    localObject = new TextView(this);
    ((TextView)localObject).setTextColor(Color.parseColor("#444444"));
    ((TextView)localObject).setTextSize(2, 12.0F);
    if (paramFacilitiesVo != null) {
      ((TextView)localObject).setText(paramFacilitiesVo.facilitiesName);
    }
    ((TextView)localObject).setSingleLine(true);
    ((TextView)localObject).setGravity(17);
    localLinearLayout.addView((View)localObject);
    return localLinearLayout;
  }
  
  private void a(SimpleDraweeView paramSimpleDraweeView, String paramString)
  {
    GenericDraweeHierarchy localGenericDraweeHierarchy = new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(300).setPlaceholderImage(2130840439).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setFailureImage(2130840439).setFailureImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build();
    RoundingParams localRoundingParams = new RoundingParams();
    localRoundingParams.setRoundAsCircle(true);
    localGenericDraweeHierarchy.setRoundingParams(localRoundingParams);
    paramSimpleDraweeView.setHierarchy(localGenericDraweeHierarchy);
    paramSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController(paramString));
  }
  
  public Context getViewContext()
  {
    return this;
  }
  
  public void initCycleViewPager()
  {
    this.r = ((CycleViewPager)getSupportFragmentManager().findFragmentById(2131691159));
    this.r.setCycle(true);
    this.r.setIsPageNumVisible(false);
    this.r.setScaleType(ScalingUtils.ScaleType.FIT_CENTER);
    this.r.setPosChangeListener(this.u);
    this.r.setWheel(true);
    if (this.r != null) {
      GrowingIO.getInstance().ignoreFragment(this, this.r);
    }
    this.s = new c(2130904613);
    this.mRvMeeTaSlider.setLayoutManager(new LinearLayoutManager(this, 0, false));
    this.mRvMeeTaSlider.setAdapter(this.s);
  }
  
  public void initView()
  {
    this.e = getIntent().getStringExtra("projectId");
    this.cbZryuMainLunbo.setClickable(true);
    this.mZiOsv.setOnScrollChangedCallback(this);
  }
  
  public boolean isActive()
  {
    return !isFinishing();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903255);
    ButterKnife.bind(this);
    this.d = this;
    MobSDK.init(this);
    new b(this);
    initCycleViewPager();
    initView();
    if (this.f != null) {
      this.f.getData(this.e);
    }
  }
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    float f1 = paramInt2 / n.dip2px(this.d, 250.0F);
    this.mViewBackGround.setAlpha(f1);
    this.mMyinfoTitleLine.setAlpha(f1);
    if (this.g != f1)
    {
      if (f1 <= 0.75D) {
        break label92;
      }
      this.mTvTitleCircleSeeHouse.setTextColor(getResources().getColor(2131624597));
      this.mIvBack.setImageResource(2130840141);
      this.mIvShare.setImageResource(2130840338);
    }
    for (;;)
    {
      this.g = f1;
      return;
      label92:
      this.mTvTitleCircleSeeHouse.setTextColor(getResources().getColor(2131624583));
      this.mIvBack.setImageResource(2130840142);
      this.mIvShare.setImageResource(2130840339);
    }
  }
  
  @OnClick({2131689492, 2131690673, 2131691165, 2131696788, 2131696058, 2131696057, 2131696792, 2131696775})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131696058: 
      this.f.toBook();
      return;
    case 2131696057: 
      this.f.call();
      return;
    case 2131696788: 
      this.f.toMapRetrieve();
      return;
    case 2131696775: 
      this.f.showAllFacilities();
      return;
    case 2131696792: 
      this.f.toMeeta();
      return;
    case 2131689492: 
      finish();
      return;
    case 2131690673: 
      this.f.showShare();
      return;
    }
    this.f.showCircleSeeHouse();
  }
  
  public void setBtnB(boolean paramBoolean)
  {
    this.mBtnB.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      this.mBtnB.setBackgroundColor(Color.parseColor("#ffa000"));
      return;
    }
    this.mBtnB.setBackgroundColor(Color.parseColor("#dddddd"));
  }
  
  public void setFacilitiesVo(ArrayList<ProjectDetailForAppVo.FacilitiesVo> paramArrayList, String paramString)
  {
    if (ae.notNull(paramString)) {
      this.facilitiesViewTitle.setText(paramString);
    }
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.facilitiesViewLin.setVisibility(0);
      this.llConfig.setVisibility(0);
      int i;
      if (paramArrayList.size() < 5)
      {
        this.moreFacilities.setVisibility(8);
        this.llConfig.removeAllViews();
        i = 0;
        label68:
        if (i >= 5) {
          return;
        }
        if (paramArrayList.size() <= i) {
          break label118;
        }
        this.llConfig.addView(a((ProjectDetailForAppVo.FacilitiesVo)paramArrayList.get(i)));
      }
      for (;;)
      {
        i += 1;
        break label68;
        this.moreFacilities.setVisibility(0);
        break;
        label118:
        this.llConfig.addView(a(null));
      }
    }
    else
    {
      this.facilitiesViewLin.setVisibility(8);
    }
  }
  
  public void setHouseTypeInfoVo(ProjectDetailForAppVo.BaseHouseTypeInfoVo paramBaseHouseTypeInfoVo, String paramString1, String paramString2)
  {
    if ((paramBaseHouseTypeInfoVo != null) && (paramBaseHouseTypeInfoVo.list != null) && (paramBaseHouseTypeInfoVo.list.size() > 0))
    {
      if (ae.notNull(paramBaseHouseTypeInfoVo.title)) {
        this.houseTypeViewTitle.setText(paramBaseHouseTypeInfoVo.title);
      }
      this.houseTypeViewTitle.setVisibility(0);
      if (this.c == null)
      {
        this.c = new HouseTypeAdapter(this.d, paramBaseHouseTypeInfoVo.list, paramString1, paramString2);
        paramBaseHouseTypeInfoVo = new LinearLayoutManager(this, 1, false)
        {
          public boolean canScrollVertically()
          {
            return false;
          }
        };
        this.houseTypeRecyclerView.setLayoutManager(paramBaseHouseTypeInfoVo);
        this.houseTypeRecyclerView.setAdapter(this.c);
        return;
      }
      this.c.setHouseTypeInfoVos(paramBaseHouseTypeInfoVo.list, paramString1, paramString2);
      return;
    }
    this.houseTypeViewTitle.setVisibility(8);
    this.houseTypeViewLin.setVisibility(8);
  }
  
  public void setPresenter(a.a parama)
  {
    this.f = parama;
  }
  
  public void setProjectRecommendVos(final HomeRentItem paramHomeRentItem)
  {
    if ((paramHomeRentItem != null) && (paramHomeRentItem.getContent() != null) && (paramHomeRentItem.getContent().size() > 0))
    {
      this.projectRecommendVos.setVisibility(0);
      this.projectRecommendVos.setData(paramHomeRentItem.getTitle(), paramHomeRentItem.getSubtitle(), null, new HomeRentItemView.a(this.d, paramHomeRentItem.getContent(), 2130904614, 0.8F)
      {
        public void onBindViewHolder(RecyclerView.u paramAnonymousu, int paramAnonymousInt)
        {
          paramAnonymousu = (MeeTaApartDetailActivity.d)paramAnonymousu;
          ContentBean localContentBean = a(paramAnonymousInt);
          paramAnonymousu.a.setTag(Integer.valueOf(paramAnonymousInt));
          paramAnonymousu.e.setController(com.freelxl.baselibrary.f.c.frescoController(localContentBean.img));
          paramAnonymousu.b.setText(localContentBean.getDescribe());
          paramAnonymousu.d.setText(localContentBean.getTitle());
          paramAnonymousu.c.setText(localContentBean.getSubtitle());
        }
        
        public RecyclerView.u onCreateViewHolder(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
        {
          paramAnonymousViewGroup = a(paramAnonymousViewGroup, false);
          MeeTaApartDetailActivity.d locald = new MeeTaApartDetailActivity.d(paramAnonymousViewGroup);
          paramAnonymousViewGroup.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              int i = ((Integer)paramAnonymous2View.getTag()).intValue();
              paramAnonymous2View = (ContentBean)MeeTaApartDetailActivity.12.this.a.getContent().get(i);
              com.ziroom.ziroomcustomer.ziroomapartment.a.ToProjectInfo(MeeTaApartDetailActivity.this, paramAnonymous2View.projectId);
            }
          });
          return locald;
        }
      });
      this.projectRecommendVos.setTitleBold(false);
      return;
    }
    this.projectRecommendVos.setVisibility(8);
  }
  
  public void setSocialVoInfo(ProjectDetailForAppVo.SocialVo paramSocialVo)
  {
    if (paramSocialVo == null)
    {
      this.SocialVoLin.setVisibility(8);
      return;
    }
    if (ae.notNull(paramSocialVo.title))
    {
      this.SocialVoLin.setVisibility(0);
      label32:
      this.femaleCount.setText(String.valueOf(paramSocialVo.femaleCount));
      this.maleCount.setText(String.valueOf(paramSocialVo.maleCount));
      this.signCount.setText("剩余房间：" + paramSocialVo.roomCount);
      this.SocialVoTitle.setText(paramSocialVo.title);
      if (!ae.notNull(paramSocialVo.imageUrl)) {
        break label343;
      }
      this.SocialVoImageUrl.setController(com.freelxl.baselibrary.f.c.frescoController(paramSocialVo.imageUrl));
      this.SocialVoImageUrl.setVisibility(0);
      this.mImageView2.setVisibility(0);
    }
    for (;;)
    {
      int i = this.mTotalCount.getWidth();
      float f1 = paramSocialVo.femaleCount + paramSocialVo.maleCount + paramSocialVo.realRoomCount;
      ViewGroup.LayoutParams localLayoutParams1 = this.maleCountView.getLayoutParams();
      localLayoutParams1.width = ((int)(paramSocialVo.maleCount / f1 * i));
      this.maleCountView.setLayoutParams(localLayoutParams1);
      ViewGroup.LayoutParams localLayoutParams2 = this.femaleCountView.getLayoutParams();
      f1 = paramSocialVo.femaleCount / f1;
      localLayoutParams2.width = ((int)(i * f1));
      this.femaleCountView.setLayoutParams(localLayoutParams2);
      if (localLayoutParams1.width < this.maleCount.getWidth()) {
        this.femaleCount.setPadding(this.maleCount.getWidth() - localLayoutParams1.width + ah.dip2px(getViewContext(), 24.0F), 0, 0, 0);
      }
      if (paramSocialVo.maleCount == 0)
      {
        this.maleCountView.setVisibility(4);
        this.maleCount.setVisibility(4);
      }
      if (paramSocialVo.femaleCount != 0) {
        break;
      }
      this.femaleCountView.setVisibility(4);
      this.femaleCount.setVisibility(4);
      return;
      this.SocialVoLin.setVisibility(8);
      break label32;
      label343:
      this.SocialVoImageUrl.setVisibility(8);
      this.mImageView2.setVisibility(8);
    }
  }
  
  public void setSpecialSubjectVo(final HomeRentItem paramHomeRentItem)
  {
    if ((paramHomeRentItem != null) && (paramHomeRentItem.getContent() != null) && (paramHomeRentItem.getContent().size() > 0))
    {
      this.specialSubjectVo.setVisibility(0);
      this.mViewYuPersonBelow.setVisibility(0);
      this.specialSubjectVo.setData(paramHomeRentItem.getTitle(), paramHomeRentItem.getSubtitle(), null, new HomeRentItemView.a(this, paramHomeRentItem.getContent(), 2130904872, 0.8F)
      {
        public void onBindViewHolder(RecyclerView.u paramAnonymousu, int paramAnonymousInt)
        {
          paramAnonymousu = (MeeTaApartDetailActivity.e)paramAnonymousu;
          ContentBean localContentBean = a(paramAnonymousInt);
          paramAnonymousu.d.setController(com.freelxl.baselibrary.f.c.frescoController(localContentBean.img));
          MeeTaApartDetailActivity.a(MeeTaApartDetailActivity.this, paramAnonymousu.e, localContentBean.getPic());
          paramAnonymousu.b.setText(localContentBean.getDescribe());
          paramAnonymousu.c.setText(localContentBean.getTitle());
          paramAnonymousu.a.setTag(Integer.valueOf(paramAnonymousInt));
        }
        
        public RecyclerView.u onCreateViewHolder(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
        {
          paramAnonymousViewGroup = a(paramAnonymousViewGroup, false);
          MeeTaApartDetailActivity.e locale = new MeeTaApartDetailActivity.e(paramAnonymousViewGroup);
          paramAnonymousViewGroup.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              int i = ((Integer)paramAnonymous2View.getTag()).intValue();
              paramAnonymous2View = (ContentBean)MeeTaApartDetailActivity.11.this.a.getContent().get(i);
              if (paramAnonymous2View != null) {
                JsBridgeWebActivity.start(MeeTaApartDetailActivity.this.getViewContext(), "", paramAnonymous2View.getLink(), true, paramAnonymous2View.getShare_content(), paramAnonymous2View.img, false);
              }
            }
          });
          return locale;
        }
      });
      this.specialSubjectVo.setTitleBold(false);
      return;
    }
    this.specialSubjectVo.setVisibility(8);
    this.mViewYuPersonBelow.setVisibility(8);
  }
  
  public void setTags(final ArrayList<ProjectDetailForAppVo.LabelsVo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    do
    {
      return;
      this.flLabelsVoStatus.removeAllViews();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (ProjectDetailForAppVo.LabelsVo)localIterator.next();
        if (!TextUtils.isEmpty(((ProjectDetailForAppVo.LabelsVo)localObject).labelName))
        {
          IntoTagTextView localIntoTagTextView = new IntoTagTextView(this);
          localIntoTagTextView.setTagBean(((ProjectDetailForAppVo.LabelsVo)localObject).labelName);
          localIntoTagTextView.setGravity(16);
          localIntoTagTextView.setTextAppearance(this, 2131428055);
          localIntoTagTextView.setBackgroundResource(2130837911);
          localIntoTagTextView.setTextColor(ContextCompat.getColor(this, 2131624296));
          localIntoTagTextView.setPadding(com.ziroom.commonlibrary.widget.gridpasswordview.c.dp2px(this, 12), com.ziroom.commonlibrary.widget.gridpasswordview.c.dp2px(this, 3), com.ziroom.commonlibrary.widget.gridpasswordview.c.dp2px(this, 12), com.ziroom.commonlibrary.widget.gridpasswordview.c.dp2px(this, 3));
          localIntoTagTextView.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              new c(MeeTaApartDetailActivity.this.d, 2131427834).show(new f(MeeTaApartDetailActivity.this.d, paramArrayList));
            }
          });
          localObject = new ViewGroup.MarginLayoutParams(-2, n.dip2px(this, 24.0F));
          ((ViewGroup.MarginLayoutParams)localObject).setMargins(0, 0, n.dip2px(this, 5.0F), 0);
          localIntoTagTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.flLabelsVoStatus.addView(localIntoTagTextView);
          this.flLabelsVoStatus.requestLayout();
        }
      }
    } while (!ae.isNull(ad.getMeetaTag(getViewContext())));
    new c(this.d, 2131427834).show(new f(this.d, paramArrayList));
    ad.saveMeetaTag(getViewContext(), "1");
  }
  
  public void setToInfo(ProjectDetailForAppVo.ProjectDetailInfoVo paramProjectDetailInfoVo)
  {
    if (paramProjectDetailInfoVo == null)
    {
      this.mTvTitleCircleSeeHouse.setVisibility(8);
      return;
    }
    if (ae.isNull(paramProjectDetailInfoVo.panoramicUrl)) {
      this.mTvTitleCircleSeeHouse.setVisibility(8);
    }
    this.mMeeTaDtlAddress.setText(paramProjectDetailInfoVo.proAddr);
    this.meetaProjectName.setText(paramProjectDetailInfoVo.projectName);
    this.mMeeTaDtlDesc.setText(paramProjectDetailInfoVo.slogan);
    this.tvBriefInfo.setText(paramProjectDetailInfoVo.briefInfo);
  }
  
  public void setTopPic(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    this.r.setData(this, paramArrayList, this.v);
    this.s.notifyDataSetChanged();
  }
  
  public void showAllFacilities(List<RentHouseDetail.Space> paramList)
  {
    new RentHouseDetailSpacePop(this).show(this.moreFacilities, paramList);
  }
  
  public void showCircleSeeHouse(String paramString)
  {
    if (ae.notNull(paramString)) {
      JsBridgeWebActivity.start(this, "全景看房", paramString);
    }
  }
  
  public void showError(boolean paramBoolean)
  {
    if (!isFinishing())
    {
      if (paramBoolean)
      {
        this.mVsError.setVisibility(0);
        ImageView localImageView1 = (ImageView)findViewById(2131690082);
        localImageView1.setImageResource(2130840094);
        ImageView localImageView2 = (ImageView)findViewById(2131695976);
        ((TextView)findViewById(2131690822)).setText("网络不佳，请点击图片进行刷新");
        localImageView2.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            MeeTaApartDetailActivity.this.finish();
          }
        });
        localImageView1.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (MeeTaApartDetailActivity.a(MeeTaApartDetailActivity.this) != null) {
              MeeTaApartDetailActivity.a(MeeTaApartDetailActivity.this).getData(MeeTaApartDetailActivity.d(MeeTaApartDetailActivity.this));
            }
          }
        });
      }
    }
    else {
      return;
    }
    this.mVsError.setVisibility(8);
  }
  
  public void showLunBoAd(final ArrayList<ProjectDetailForAppVo.MiddleBannerVo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      this.cbZryuMainLunbo.setVisibility(8);
      this.viewLunboBelow.setVisibility(8);
      return;
    }
    this.cbZryuMainLunbo.setVisibility(0);
    this.viewLunboBelow.setVisibility(0);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      localArrayList.add(((ProjectDetailForAppVo.MiddleBannerVo)paramArrayList.get(i)).img);
      i += 1;
    }
    this.cbZryuMainLunbo.setPages(new com.ziroom.commonlibrary.widget.convenientbanner.b.a()
    {
      public MeeTaApartDetailActivity.a createHolder()
      {
        return new MeeTaApartDetailActivity.a(MeeTaApartDetailActivity.this, null);
      }
    }, localArrayList).setPageIndicator(new int[] { 2130839327, 2130839326 }).setOnItemClickListener(new com.ziroom.commonlibrary.widget.convenientbanner.c.b()
    {
      public void onItemClick(int paramAnonymousInt)
      {
        ProjectDetailForAppVo.MiddleBannerVo localMiddleBannerVo = (ProjectDetailForAppVo.MiddleBannerVo)paramArrayList.get(paramAnonymousInt);
        if ((localMiddleBannerVo != null) && ("0".equals(localMiddleBannerVo.app))) {
          JsBridgeWebActivity.start(MeeTaApartDetailActivity.this.getViewContext(), localMiddleBannerVo.title, localMiddleBannerVo.target, true, localMiddleBannerVo.description, localMiddleBannerVo.img, false);
        }
      }
    }).setPointViewVisible(true);
    this.cbZryuMainLunbo.startTurning(5000L);
  }
  
  public void showLunBoCommentsVo(List<ProjectDetailForAppVo.CommentsVo> paramList, String paramString)
  {
    if (ae.notNull(paramString)) {
      this.commentsViewTitle.setText(paramString);
    }
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.cbZryuCommentsLunbo.setVisibility(8);
      this.viewCommentsBelow.setVisibility(8);
      this.commentsViewLin.setVisibility(8);
      return;
    }
    this.commentsViewLin.setVisibility(0);
    this.cbZryuCommentsLunbo.setVisibility(0);
    this.viewCommentsBelow.setVisibility(0);
    this.cbZryuCommentsLunbo.setPages(new com.ziroom.commonlibrary.widget.convenientbanner.b.a()
    {
      public MeeTaApartDetailActivity.b createHolder()
      {
        return new MeeTaApartDetailActivity.b(MeeTaApartDetailActivity.this, null);
      }
    }, paramList).setPageIndicator(new int[] { 2130839327, 2130839326 }).setOnItemClickListener(new com.ziroom.commonlibrary.widget.convenientbanner.c.b()
    {
      public void onItemClick(int paramAnonymousInt) {}
    }).setPointViewVisible(true);
    this.cbZryuMainLunbo.startTurning(5000L);
  }
  
  public void showLunBoZo(ArrayList<ProjectDetailForAppVo.ProjectZoVo> paramArrayList, String paramString)
  {
    if (ae.notNull(paramString)) {
      this.zoViewTitle.setText(paramString);
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      this.cbZryuZoLunbo.setVisibility(8);
      this.viewZoBelow.setVisibility(8);
      this.zoViewLin.setVisibility(8);
      return;
    }
    this.zoViewLin.setVisibility(0);
    this.cbZryuZoLunbo.setVisibility(0);
    this.viewZoBelow.setVisibility(0);
    this.cbZryuZoLunbo.setPages(new com.ziroom.commonlibrary.widget.convenientbanner.b.a()
    {
      public MeeTaApartDetailActivity.f createHolder()
      {
        return new MeeTaApartDetailActivity.f(MeeTaApartDetailActivity.this, null);
      }
    }, paramArrayList).setPageIndicator(new int[] { 2130839327, 2130839326 }).setOnItemClickListener(new com.ziroom.commonlibrary.widget.convenientbanner.c.b()
    {
      public void onItemClick(int paramAnonymousInt) {}
    }).setPointViewVisible(true);
    this.cbZryuMainLunbo.startTurning(5000L);
  }
  
  public void showShare(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (checkNet(this))
    {
      if (ae.notNull(paramString2))
      {
        if ((ae.isNull(paramString3)) || (ae.isNull(paramString2)) || (ae.isNull(paramString4)) || (ae.isNull(paramString1))) {
          return;
        }
        l.d("####meetaaprt####", "==shareUrl=" + paramString2 + "==shareImgUrl==" + paramString3);
        com.ziroom.threelib.ziroomshare.c localc = com.ziroom.threelib.ziroomshare.c.getInstance();
        localc.setPaltFormShowFlag(15);
        localc.shareFromCenter(this, paramString2, paramString1, paramString4, paramString3, this.t);
        return;
      }
      g.textToast(this, "");
      return;
    }
    g.textToast(this, "网络连接错误");
  }
  
  private class a
    implements com.ziroom.commonlibrary.widget.convenientbanner.b.b<String>
  {
    private SimpleDraweeView b;
    
    private a() {}
    
    public void UpdateUI(Context paramContext, int paramInt, String paramString)
    {
      paramContext = x.makeUrl(paramString);
      this.b.setController(com.freelxl.baselibrary.f.c.frescoController(paramContext));
    }
    
    public View createView(Context paramContext)
    {
      this.b = new SimpleDraweeView(paramContext);
      ((GenericDraweeHierarchy)this.b.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
      return this.b;
    }
  }
  
  private class b
    implements com.ziroom.commonlibrary.widget.convenientbanner.b.b<ProjectDetailForAppVo.CommentsVo>
  {
    private SimpleDraweeView b;
    private View c;
    private TextView d;
    private TextView e;
    private TextView f;
    
    private b() {}
    
    public void UpdateUI(Context paramContext, int paramInt, ProjectDetailForAppVo.CommentsVo paramCommentsVo)
    {
      paramContext = x.makeUrl(paramCommentsVo.headerUrl, 0.2F);
      MeeTaApartDetailActivity.a(MeeTaApartDetailActivity.this, this.b, paramContext);
      this.d.setText(paramCommentsVo.content);
      this.e.setText(paramCommentsVo.nickName);
      this.f.setText(paramCommentsVo.remark);
    }
    
    public View createView(Context paramContext)
    {
      this.c = LayoutInflater.from(MeeTaApartDetailActivity.this.d).inflate(2130904873, null);
      this.b = ((SimpleDraweeView)this.c.findViewById(2131696803));
      this.d = ((TextView)this.c.findViewById(2131696805));
      this.e = ((TextView)this.c.findViewById(2131696804));
      this.f = ((TextView)this.c.findViewById(2131696806));
      return this.c;
    }
  }
  
  public class c
    extends RecyclerView.a
  {
    private int b;
    private int c;
    
    public c(int paramInt)
    {
      this.b = paramInt;
      if (paramInt == 2130904611) {
        this.c = (MeeTaApartDetailActivity.this.getResources().getDisplayMetrics().widthPixels / 6);
      }
      while (paramInt != 2130904613) {
        return;
      }
      this.c = ((int)(MeeTaApartDetailActivity.this.getResources().getDisplayMetrics().widthPixels - 32.0F * MeeTaApartDetailActivity.this.getResources().getDisplayMetrics().density + 0.5F) / 6);
    }
    
    public int getItemCount()
    {
      int j = 0;
      int i = j;
      if (this.b == 2130904613)
      {
        i = j;
        if (MeeTaApartDetailActivity.a(MeeTaApartDetailActivity.this).getSlidersTypes() != null)
        {
          i = j;
          if (MeeTaApartDetailActivity.a(MeeTaApartDetailActivity.this).getSlidersTypeIndexs() != null)
          {
            i = j;
            if (MeeTaApartDetailActivity.a(MeeTaApartDetailActivity.this).getSlidersTypes().size() == MeeTaApartDetailActivity.a(MeeTaApartDetailActivity.this).getSlidersTypeIndexs().size()) {
              i = MeeTaApartDetailActivity.a(MeeTaApartDetailActivity.this).getSlidersTypes().size();
            }
          }
        }
      }
      return i;
    }
    
    public void onBindViewHolder(RecyclerView.u paramu, final int paramInt)
    {
      if (this.b == 2130904613)
      {
        paramu = ((a)paramu).a;
        paramu.setText((CharSequence)MeeTaApartDetailActivity.a(MeeTaApartDetailActivity.this).getSlidersTypes().get(paramInt));
        if (paramInt != MeeTaApartDetailActivity.this.b) {
          break label71;
        }
        paramu.setBackgroundResource(2130838624);
      }
      for (;;)
      {
        paramu.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            int i = ((Integer)MeeTaApartDetailActivity.a(MeeTaApartDetailActivity.this).getSlidersTypeIndexs().get(paramInt)).intValue();
            if (i + 1 <= MeeTaApartDetailActivity.a(MeeTaApartDetailActivity.this).getSliders().size()) {
              MeeTaApartDetailActivity.c(MeeTaApartDetailActivity.this).setCurrentItem(i + 1);
            }
          }
        });
        return;
        label71:
        paramu.setBackground(null);
      }
    }
    
    public RecyclerView.u onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      paramViewGroup = LayoutInflater.from(MeeTaApartDetailActivity.this).inflate(this.b, paramViewGroup, false);
      if (this.b == 2130904613)
      {
        paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(this.c, -2));
        return new a(paramViewGroup);
      }
      return null;
    }
    
    private class a
      extends RecyclerView.u
    {
      Button a;
      
      public a(View paramView)
      {
        super();
        this.a = ((Button)paramView.findViewById(2131695868));
      }
    }
  }
  
  public static class d
    extends RecyclerView.u
  {
    protected View a;
    protected TextView b;
    protected TextView c;
    protected TextView d;
    protected SimpleDraweeView e;
    
    public d(View paramView)
    {
      super();
      this.a = paramView;
      this.d = ((TextView)paramView.findViewById(2131689541));
      this.b = ((TextView)paramView.findViewById(2131690073));
      this.e = ((SimpleDraweeView)paramView.findViewById(2131691098));
      this.c = ((TextView)paramView.findViewById(2131690071));
    }
  }
  
  public static class e
    extends RecyclerView.u
  {
    protected View a;
    protected TextView b;
    protected TextView c;
    protected SimpleDraweeView d;
    protected SimpleDraweeView e;
    
    public e(View paramView)
    {
      super();
      this.a = paramView;
      this.c = ((TextView)paramView.findViewById(2131689541));
      this.b = ((TextView)paramView.findViewById(2131696802));
      this.d = ((SimpleDraweeView)paramView.findViewById(2131696799));
      this.e = ((SimpleDraweeView)paramView.findViewById(2131696801));
    }
  }
  
  private class f
    implements com.ziroom.commonlibrary.widget.convenientbanner.b.b<ProjectDetailForAppVo.ProjectZoVo>
  {
    private SimpleDraweeView b;
    private TextView c;
    private TextView d;
    private View e;
    
    private f() {}
    
    public void UpdateUI(Context paramContext, int paramInt, final ProjectDetailForAppVo.ProjectZoVo paramProjectZoVo)
    {
      MeeTaApartDetailActivity.a(MeeTaApartDetailActivity.this, this.b, paramProjectZoVo.headPic);
      this.c.setText(paramProjectZoVo.zoName);
      this.d.setText(paramProjectZoVo.selfIntro);
      if (TextUtils.isEmpty(paramProjectZoVo.headPic))
      {
        this.b.setOnClickListener(null);
        return;
      }
      this.b.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(MeeTaApartDetailActivity.this, ZryuSignImgActivity.class);
          paramAnonymousView.putExtra("imgUrl", paramProjectZoVo.headPic);
          MeeTaApartDetailActivity.this.startActivity(paramAnonymousView);
        }
      });
    }
    
    public View createView(Context paramContext)
    {
      this.e = LayoutInflater.from(MeeTaApartDetailActivity.this.d).inflate(2130904874, null);
      this.b = ((SimpleDraweeView)this.e.findViewById(2131696807));
      this.c = ((TextView)this.e.findViewById(2131696808));
      this.d = ((TextView)this.e.findViewById(2131696809));
      return this.e;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/meetaapartdetail/MeeTaApartDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */