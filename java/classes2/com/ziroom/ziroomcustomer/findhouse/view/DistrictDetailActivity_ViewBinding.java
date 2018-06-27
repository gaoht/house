package com.ziroom.ziroomcustomer.findhouse.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.baidu.mapapi.map.TextureMapView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.widget.AutoLineFeedLayout;
import com.ziroom.ziroomcustomer.widget.ExpandableTextViewNewLine;
import com.ziroom.ziroomcustomer.widget.LinearLayoutForListView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class DistrictDetailActivity_ViewBinding<T extends DistrictDetailActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  
  public DistrictDetailActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.flCarousel = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131690881, "field 'flCarousel'", FrameLayout.class));
    paramT.llCarousel = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690884, "field 'llCarousel'", LinearLayout.class));
    paramT.hscCarousel = ((HorizontalScrollView)Utils.findRequiredViewAsType(paramView, 2131690883, "field 'hscCarousel'", HorizontalScrollView.class));
    paramT.tvDistrictName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690885, "field 'tvDistrictName'", TextView.class));
    paramT.tvDistrictConcern = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690886, "field 'tvDistrictConcern'", TextView.class));
    paramT.tvDistrictSubtitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690887, "field 'tvDistrictSubtitle'", TextView.class));
    paramT.tvDistrictIntroduce = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690888, "field 'tvDistrictIntroduce'", TextView.class));
    paramT.llDistrictIntroduce = ((LinearLayoutForListView)Utils.findRequiredViewAsType(paramView, 2131690889, "field 'llDistrictIntroduce'", LinearLayoutForListView.class));
    View localView = Utils.findRequiredView(paramView, 2131690890, "field 'tvDistrictIntroduceMore' and method 'onViewClicked'");
    paramT.tvDistrictIntroduceMore = ((TextView)Utils.castView(localView, 2131690890, "field 'tvDistrictIntroduceMore'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvHouse = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690891, "field 'tvHouse'", TextView.class));
    paramT.llHouse = ((LinearLayoutForListView)Utils.findRequiredViewAsType(paramView, 2131690892, "field 'llHouse'", LinearLayoutForListView.class));
    localView = Utils.findRequiredView(paramView, 2131690893, "field 'tvHouseMore' and method 'onViewClicked'");
    paramT.tvHouseMore = ((TextView)Utils.castView(localView, 2131690893, "field 'tvHouseMore'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.ivMapCenter = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131695970, "field 'ivMapCenter'", ImageView.class));
    paramT.tvTrafficName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695965, "field 'tvTrafficName'", TextView.class));
    paramT.llAround = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695971, "field 'llAround'", LinearLayout.class));
    paramT.osv = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131690031, "field 'osv'", ObservableScrollView.class));
    paramT.vHeader = Utils.findRequiredView(paramView, 2131694590, "field 'vHeader'");
    localView = Utils.findRequiredView(paramView, 2131689492, "field 'ivBack' and method 'onViewClicked'");
    paramT.ivBack = ((ImageView)Utils.castView(localView, 2131689492, "field 'ivBack'", ImageView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690673, "field 'ivShare' and method 'onViewClicked'");
    paramT.ivShare = ((ImageView)Utils.castView(localView, 2131690673, "field 'ivShare'", ImageView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.llHeader = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691583, "field 'llHeader'", LinearLayout.class));
    paramT.vHeaderDivider = Utils.findRequiredView(paramView, 2131696034, "field 'vHeaderDivider'");
    paramT.vsError = ((ViewStub)Utils.findRequiredViewAsType(paramView, 2131690894, "field 'vsError'", ViewStub.class));
    paramT.tvDistrictLabelTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695956, "field 'tvDistrictLabelTitle'", TextView.class));
    paramT.alflDistrictInfoTag = ((AutoLineFeedLayout)Utils.findRequiredViewAsType(paramView, 2131695957, "field 'alflDistrictInfoTag'", AutoLineFeedLayout.class));
    paramT.llDistrictRank = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695954, "field 'llDistrictRank'", LinearLayout.class));
    paramT.etvDistrictOverview = ((ExpandableTextViewNewLine)Utils.findRequiredViewAsType(paramView, 2131695960, "field 'etvDistrictOverview'", ExpandableTextViewNewLine.class));
    paramT.llDistrictOverview = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695958, "field 'llDistrictOverview'", LinearLayout.class));
    paramT.etvDistrictPropertyManager = ((ExpandableTextViewNewLine)Utils.findRequiredViewAsType(paramView, 2131695963, "field 'etvDistrictPropertyManager'", ExpandableTextViewNewLine.class));
    paramT.llDistrictPropertyManager = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695961, "field 'llDistrictPropertyManager'", LinearLayout.class));
    paramT.rvRecommend = ((RecyclerView)Utils.findRequiredViewAsType(paramView, 2131695973, "field 'rvRecommend'", RecyclerView.class));
    paramT.llDistrictDetailRecommend = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695972, "field 'llDistrictDetailRecommend'", LinearLayout.class));
    paramT.tvDistrictOverviewTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695959, "field 'tvDistrictOverviewTitle'", TextView.class));
    paramT.tvDistrictPropertyManagerTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695962, "field 'tvDistrictPropertyManagerTitle'", TextView.class));
    paramT.sdvDistrictOrderIcon = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131695955, "field 'sdvDistrictOrderIcon'", SimpleDraweeView.class));
    paramT.llDistrictRankAndLabel = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695953, "field 'llDistrictRankAndLabel'", LinearLayout.class));
    paramT.llDistrictSurroundTraffic = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695964, "field 'llDistrictSurroundTraffic'", LinearLayout.class));
    paramT.llDistrictSurroundTrafficTitle = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695967, "field 'llDistrictSurroundTrafficTitle'", LinearLayout.class));
    paramT.hsvSurroundTrafficTitles = ((HorizontalScrollView)Utils.findRequiredViewAsType(paramView, 2131695966, "field 'hsvSurroundTrafficTitles'", HorizontalScrollView.class));
    paramT.mvDistrictSurroundTraffic = ((TextureMapView)Utils.findRequiredViewAsType(paramView, 2131695969, "field 'mvDistrictSurroundTraffic'", TextureMapView.class));
    paramView = Utils.findRequiredView(paramView, 2131695968, "field 'rlTrafficMap' and method 'onViewClicked'");
    paramT.rlTrafficMap = ((RelativeLayout)Utils.castView(paramView, 2131695968, "field 'rlTrafficMap'", RelativeLayout.class));
    this.f = paramView;
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
    DistrictDetailActivity localDistrictDetailActivity = this.a;
    if (localDistrictDetailActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localDistrictDetailActivity.flCarousel = null;
    localDistrictDetailActivity.llCarousel = null;
    localDistrictDetailActivity.hscCarousel = null;
    localDistrictDetailActivity.tvDistrictName = null;
    localDistrictDetailActivity.tvDistrictConcern = null;
    localDistrictDetailActivity.tvDistrictSubtitle = null;
    localDistrictDetailActivity.tvDistrictIntroduce = null;
    localDistrictDetailActivity.llDistrictIntroduce = null;
    localDistrictDetailActivity.tvDistrictIntroduceMore = null;
    localDistrictDetailActivity.tvHouse = null;
    localDistrictDetailActivity.llHouse = null;
    localDistrictDetailActivity.tvHouseMore = null;
    localDistrictDetailActivity.ivMapCenter = null;
    localDistrictDetailActivity.tvTrafficName = null;
    localDistrictDetailActivity.llAround = null;
    localDistrictDetailActivity.osv = null;
    localDistrictDetailActivity.vHeader = null;
    localDistrictDetailActivity.ivBack = null;
    localDistrictDetailActivity.ivShare = null;
    localDistrictDetailActivity.llHeader = null;
    localDistrictDetailActivity.vHeaderDivider = null;
    localDistrictDetailActivity.vsError = null;
    localDistrictDetailActivity.tvDistrictLabelTitle = null;
    localDistrictDetailActivity.alflDistrictInfoTag = null;
    localDistrictDetailActivity.llDistrictRank = null;
    localDistrictDetailActivity.etvDistrictOverview = null;
    localDistrictDetailActivity.llDistrictOverview = null;
    localDistrictDetailActivity.etvDistrictPropertyManager = null;
    localDistrictDetailActivity.llDistrictPropertyManager = null;
    localDistrictDetailActivity.rvRecommend = null;
    localDistrictDetailActivity.llDistrictDetailRecommend = null;
    localDistrictDetailActivity.tvDistrictOverviewTitle = null;
    localDistrictDetailActivity.tvDistrictPropertyManagerTitle = null;
    localDistrictDetailActivity.sdvDistrictOrderIcon = null;
    localDistrictDetailActivity.llDistrictRankAndLabel = null;
    localDistrictDetailActivity.llDistrictSurroundTraffic = null;
    localDistrictDetailActivity.llDistrictSurroundTrafficTitle = null;
    localDistrictDetailActivity.hsvSurroundTrafficTitles = null;
    localDistrictDetailActivity.mvDistrictSurroundTraffic = null;
    localDistrictDetailActivity.rlTrafficMap = null;
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
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/DistrictDetailActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */