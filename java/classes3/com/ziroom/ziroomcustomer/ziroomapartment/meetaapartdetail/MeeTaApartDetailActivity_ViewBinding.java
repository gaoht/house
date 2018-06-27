package com.ziroom.ziroomcustomer.ziroomapartment.meetaapartdetail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientOptiBanner;
import com.ziroom.ziroomcustomer.home.view.HomeRentItemView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.ziroomstation.widget.FlowLayout;

public class MeeTaApartDetailActivity_ViewBinding<T extends MeeTaApartDetailActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  private View i;
  
  public MeeTaApartDetailActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mRvMeeTaSlider = ((RecyclerView)Utils.findRequiredViewAsType(paramView, 2131691160, "field 'mRvMeeTaSlider'", RecyclerView.class));
    paramT.mRlMeeTaDtlSlider = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131691158, "field 'mRlMeeTaDtlSlider'", RelativeLayout.class));
    paramT.mMeeTaDtlDesc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696786, "field 'mMeeTaDtlDesc'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131696788, "field 'mMeeTaDtlAddress' and method 'onViewClicked'");
    paramT.mMeeTaDtlAddress = ((TextView)Utils.castView(localView, 2131696788, "field 'mMeeTaDtlAddress'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.mZiOsv = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131691157, "field 'mZiOsv'", ObservableScrollView.class));
    paramT.meetaProjectName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696785, "field 'meetaProjectName'", TextView.class));
    paramT.flLabelsVoStatus = ((FlowLayout)Utils.findRequiredViewAsType(paramView, 2131696787, "field 'flLabelsVoStatus'", FlowLayout.class));
    paramT.SocialVoTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696790, "field 'SocialVoTitle'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131696792, "field 'SocialVoImageUrl' and method 'onViewClicked'");
    paramT.SocialVoImageUrl = ((SimpleDraweeView)Utils.castView(localView, 2131696792, "field 'SocialVoImageUrl'", SimpleDraweeView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.mImageView2 = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131696791, "field 'mImageView2'", ImageView.class));
    paramT.maleCount = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696794, "field 'maleCount'", TextView.class));
    paramT.maleCountView = Utils.findRequiredView(paramView, 2131696795, "field 'maleCountView'");
    paramT.femaleCount = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696796, "field 'femaleCount'", TextView.class));
    paramT.femaleCountView = Utils.findRequiredView(paramView, 2131696797, "field 'femaleCountView'");
    paramT.signCount = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696798, "field 'signCount'", TextView.class));
    paramT.mTotalCount = Utils.findRequiredView(paramView, 2131696793, "field 'mTotalCount'");
    paramT.SocialVoLin = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696789, "field 'SocialVoLin'", LinearLayout.class));
    paramT.tvBriefInfo = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691161, "field 'tvBriefInfo'", TextView.class));
    paramT.specialSubjectVo = ((HomeRentItemView)Utils.findRequiredViewAsType(paramView, 2131691162, "field 'specialSubjectVo'", HomeRentItemView.class));
    paramT.projectRecommendVos = ((HomeRentItemView)Utils.findRequiredViewAsType(paramView, 2131691163, "field 'projectRecommendVos'", HomeRentItemView.class));
    paramT.cbZryuMainLunbo = ((ConvenientOptiBanner)Utils.findRequiredViewAsType(paramView, 2131691146, "field 'cbZryuMainLunbo'", ConvenientOptiBanner.class));
    paramT.viewLunboBelow = Utils.findRequiredView(paramView, 2131691147, "field 'viewLunboBelow'");
    paramT.facilitiesViewTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696774, "field 'facilitiesViewTitle'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131696775, "field 'moreFacilities' and method 'onViewClicked'");
    paramT.moreFacilities = ((TextView)Utils.castView(localView, 2131696775, "field 'moreFacilities'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.llConfig = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696776, "field 'llConfig'", LinearLayout.class));
    paramT.facilitiesViewLin = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696773, "field 'facilitiesViewLin'", LinearLayout.class));
    paramT.houseTypeViewTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696778, "field 'houseTypeViewTitle'", TextView.class));
    paramT.houseTypeRecyclerView = ((RecyclerView)Utils.findRequiredViewAsType(paramView, 2131696779, "field 'houseTypeRecyclerView'", RecyclerView.class));
    paramT.houseTypeViewLin = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696777, "field 'houseTypeViewLin'", LinearLayout.class));
    paramT.commentsViewTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696770, "field 'commentsViewTitle'", TextView.class));
    paramT.cbZryuCommentsLunbo = ((ConvenientOptiBanner)Utils.findRequiredViewAsType(paramView, 2131696771, "field 'cbZryuCommentsLunbo'", ConvenientOptiBanner.class));
    paramT.viewCommentsBelow = Utils.findRequiredView(paramView, 2131696772, "field 'viewCommentsBelow'");
    paramT.commentsViewLin = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696769, "field 'commentsViewLin'", LinearLayout.class));
    paramT.zoViewTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696782, "field 'zoViewTitle'", TextView.class));
    paramT.cbZryuZoLunbo = ((ConvenientOptiBanner)Utils.findRequiredViewAsType(paramView, 2131696783, "field 'cbZryuZoLunbo'", ConvenientOptiBanner.class));
    paramT.viewZoBelow = Utils.findRequiredView(paramView, 2131696784, "field 'viewZoBelow'");
    paramT.mViewBackGround = Utils.findRequiredView(paramView, 2131691164, "field 'mViewBackGround'");
    paramT.mMyinfoTitleLine = Utils.findRequiredView(paramView, 2131691166, "field 'mMyinfoTitleLine'");
    localView = Utils.findRequiredView(paramView, 2131691165, "field 'mTvTitleCircleSeeHouse' and method 'onViewClicked'");
    paramT.mTvTitleCircleSeeHouse = ((TextView)Utils.castView(localView, 2131691165, "field 'mTvTitleCircleSeeHouse'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.zoViewLin = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696781, "field 'zoViewLin'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131690673, "field 'mIvShare' and method 'onViewClicked'");
    paramT.mIvShare = ((ImageView)Utils.castView(localView, 2131690673, "field 'mIvShare'", ImageView.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131689492, "field 'mIvBack' and method 'onViewClicked'");
    paramT.mIvBack = ((ImageView)Utils.castView(localView, 2131689492, "field 'mIvBack'", ImageView.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.mViewYuPersonBelow = Utils.findRequiredView(paramView, 2131691150, "field 'mViewYuPersonBelow'");
    localView = Utils.findRequiredView(paramView, 2131696058, "field 'mBtnB' and method 'onViewClicked'");
    paramT.mBtnB = ((Button)Utils.castView(localView, 2131696058, "field 'mBtnB'", Button.class));
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.mVsError = ((ViewStub)Utils.findRequiredViewAsType(paramView, 2131690894, "field 'mVsError'", ViewStub.class));
    paramT.mLlBtn = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691870, "field 'mLlBtn'", LinearLayout.class));
    paramView = Utils.findRequiredView(paramView, 2131696057, "method 'onViewClicked'");
    this.i = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    MeeTaApartDetailActivity localMeeTaApartDetailActivity = this.a;
    if (localMeeTaApartDetailActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMeeTaApartDetailActivity.mRvMeeTaSlider = null;
    localMeeTaApartDetailActivity.mRlMeeTaDtlSlider = null;
    localMeeTaApartDetailActivity.mMeeTaDtlDesc = null;
    localMeeTaApartDetailActivity.mMeeTaDtlAddress = null;
    localMeeTaApartDetailActivity.mZiOsv = null;
    localMeeTaApartDetailActivity.meetaProjectName = null;
    localMeeTaApartDetailActivity.flLabelsVoStatus = null;
    localMeeTaApartDetailActivity.SocialVoTitle = null;
    localMeeTaApartDetailActivity.SocialVoImageUrl = null;
    localMeeTaApartDetailActivity.mImageView2 = null;
    localMeeTaApartDetailActivity.maleCount = null;
    localMeeTaApartDetailActivity.maleCountView = null;
    localMeeTaApartDetailActivity.femaleCount = null;
    localMeeTaApartDetailActivity.femaleCountView = null;
    localMeeTaApartDetailActivity.signCount = null;
    localMeeTaApartDetailActivity.mTotalCount = null;
    localMeeTaApartDetailActivity.SocialVoLin = null;
    localMeeTaApartDetailActivity.tvBriefInfo = null;
    localMeeTaApartDetailActivity.specialSubjectVo = null;
    localMeeTaApartDetailActivity.projectRecommendVos = null;
    localMeeTaApartDetailActivity.cbZryuMainLunbo = null;
    localMeeTaApartDetailActivity.viewLunboBelow = null;
    localMeeTaApartDetailActivity.facilitiesViewTitle = null;
    localMeeTaApartDetailActivity.moreFacilities = null;
    localMeeTaApartDetailActivity.llConfig = null;
    localMeeTaApartDetailActivity.facilitiesViewLin = null;
    localMeeTaApartDetailActivity.houseTypeViewTitle = null;
    localMeeTaApartDetailActivity.houseTypeRecyclerView = null;
    localMeeTaApartDetailActivity.houseTypeViewLin = null;
    localMeeTaApartDetailActivity.commentsViewTitle = null;
    localMeeTaApartDetailActivity.cbZryuCommentsLunbo = null;
    localMeeTaApartDetailActivity.viewCommentsBelow = null;
    localMeeTaApartDetailActivity.commentsViewLin = null;
    localMeeTaApartDetailActivity.zoViewTitle = null;
    localMeeTaApartDetailActivity.cbZryuZoLunbo = null;
    localMeeTaApartDetailActivity.viewZoBelow = null;
    localMeeTaApartDetailActivity.mViewBackGround = null;
    localMeeTaApartDetailActivity.mMyinfoTitleLine = null;
    localMeeTaApartDetailActivity.mTvTitleCircleSeeHouse = null;
    localMeeTaApartDetailActivity.zoViewLin = null;
    localMeeTaApartDetailActivity.mIvShare = null;
    localMeeTaApartDetailActivity.mIvBack = null;
    localMeeTaApartDetailActivity.mViewYuPersonBelow = null;
    localMeeTaApartDetailActivity.mBtnB = null;
    localMeeTaApartDetailActivity.mVsError = null;
    localMeeTaApartDetailActivity.mLlBtn = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.e.setOnClickListener(null);
    this.e = null;
    this.f.setOnClickListener(null);
    this.f = null;
    this.g.setOnClickListener(null);
    this.g = null;
    this.h.setOnClickListener(null);
    this.h = null;
    this.i.setOnClickListener(null);
    this.i = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/meetaapartdetail/MeeTaApartDetailActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */