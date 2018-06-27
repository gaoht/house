package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.ReleaseUsageAndTipsView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class LandlordReleaseOnceStepOneFragment_ViewBinding<T extends LandlordReleaseOnceStepOneFragment>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  
  public LandlordReleaseOnceStepOneFragment_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.ruatv_tip = ((ReleaseUsageAndTipsView)Utils.findRequiredViewAsType(paramView, 2131689893, "field 'ruatv_tip'", ReleaseUsageAndTipsView.class));
    View localView = Utils.findRequiredView(paramView, 2131690078, "field 'btn_back' and method 'OnClick'");
    paramT.btn_back = localView;
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691560, "field 'btn_next' and method 'OnClick'");
    paramT.btn_next = localView;
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    paramT.ll_house_rent_way_container = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131694282, "field 'll_house_rent_way_container'", LinearLayout.class));
    paramT.tv_house_rent_way_title_1 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694283, "field 'tv_house_rent_way_title_1'", TextView.class));
    paramT.tv_house_rent_way_title_2 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694625, "field 'tv_house_rent_way_title_2'", TextView.class));
    paramT.tv_house_rent_way_content_1 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694284, "field 'tv_house_rent_way_content_1'", TextView.class));
    paramT.tv_house_rent_way_content_2 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694626, "field 'tv_house_rent_way_content_2'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131694624, "field 'iv_house_rent_way_1' and method 'OnClick'");
    paramT.iv_house_rent_way_1 = ((ImageView)Utils.castView(localView, 2131694624, "field 'iv_house_rent_way_1'", ImageView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131694627, "field 'iv_house_rent_way_2' and method 'OnClick'");
    paramT.iv_house_rent_way_2 = ((ImageView)Utils.castView(localView, 2131694627, "field 'iv_house_rent_way_2'", ImageView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131694286, "field 'btn_house_type' and method 'OnClick'");
    paramT.btn_house_type = localView;
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    paramT.v_divider = Utils.findRequiredView(paramView, 2131689863, "field 'v_divider'");
    paramT.osv_content = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131691557, "field 'osv_content'", ObservableScrollView.class));
    paramT.tv_house_type = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694215, "field 'tv_house_type'", TextView.class));
    paramT.ll_house_type_container = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131694285, "field 'll_house_type_container'", LinearLayout.class));
    paramT.ll_house_rent_way_title_3 = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131694628, "field 'll_house_rent_way_title_3'", LinearLayout.class));
    paramT.tv_house_rent_way_title_3 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694629, "field 'tv_house_rent_way_title_3'", TextView.class));
    paramT.tv_house_rent_way_content_3 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694630, "field 'tv_house_rent_way_content_3'", TextView.class));
    paramView = Utils.findRequiredView(paramView, 2131694631, "field 'iv_house_rent_way_3' and method 'OnClick'");
    paramT.iv_house_rent_way_3 = ((ImageView)Utils.castView(paramView, 2131694631, "field 'iv_house_rent_way_3'", ImageView.class));
    this.g = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    LandlordReleaseOnceStepOneFragment localLandlordReleaseOnceStepOneFragment = this.a;
    if (localLandlordReleaseOnceStepOneFragment == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLandlordReleaseOnceStepOneFragment.ruatv_tip = null;
    localLandlordReleaseOnceStepOneFragment.btn_back = null;
    localLandlordReleaseOnceStepOneFragment.btn_next = null;
    localLandlordReleaseOnceStepOneFragment.ll_house_rent_way_container = null;
    localLandlordReleaseOnceStepOneFragment.tv_house_rent_way_title_1 = null;
    localLandlordReleaseOnceStepOneFragment.tv_house_rent_way_title_2 = null;
    localLandlordReleaseOnceStepOneFragment.tv_house_rent_way_content_1 = null;
    localLandlordReleaseOnceStepOneFragment.tv_house_rent_way_content_2 = null;
    localLandlordReleaseOnceStepOneFragment.iv_house_rent_way_1 = null;
    localLandlordReleaseOnceStepOneFragment.iv_house_rent_way_2 = null;
    localLandlordReleaseOnceStepOneFragment.btn_house_type = null;
    localLandlordReleaseOnceStepOneFragment.v_divider = null;
    localLandlordReleaseOnceStepOneFragment.osv_content = null;
    localLandlordReleaseOnceStepOneFragment.tv_house_type = null;
    localLandlordReleaseOnceStepOneFragment.ll_house_type_container = null;
    localLandlordReleaseOnceStepOneFragment.ll_house_rent_way_title_3 = null;
    localLandlordReleaseOnceStepOneFragment.tv_house_rent_way_title_3 = null;
    localLandlordReleaseOnceStepOneFragment.tv_house_rent_way_content_3 = null;
    localLandlordReleaseOnceStepOneFragment.iv_house_rent_way_3 = null;
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
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LandlordReleaseOnceStepOneFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */