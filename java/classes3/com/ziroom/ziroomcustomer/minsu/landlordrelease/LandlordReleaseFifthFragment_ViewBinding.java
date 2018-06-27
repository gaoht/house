package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.ReleaseUsageAndTipsView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ReMeasureRecyclerView;

public class LandlordReleaseFifthFragment_ViewBinding<T extends LandlordReleaseFifthFragment>
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
  
  public LandlordReleaseFifthFragment_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
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
    localView = Utils.findRequiredView(paramView, 2131694243, "field 'btn_release' and method 'OnClick'");
    paramT.btn_release = localView;
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131694244, "field 'btn_preview' and method 'OnClick'");
    paramT.btn_preview = localView;
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    paramT.rv_picture = ((ReMeasureRecyclerView)Utils.findRequiredViewAsType(paramView, 2131694233, "field 'rv_picture'", ReMeasureRecyclerView.class));
    paramT.ruatv_tip = ((ReleaseUsageAndTipsView)Utils.findRequiredViewAsType(paramView, 2131689893, "field 'ruatv_tip'", ReleaseUsageAndTipsView.class));
    paramT.tv_picture_upload_info = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694232, "field 'tv_picture_upload_info'", TextView.class));
    paramT.rv_select_cover_picture = ((ReMeasureRecyclerView)Utils.findRequiredViewAsType(paramView, 2131694235, "field 'rv_select_cover_picture'", ReMeasureRecyclerView.class));
    localView = Utils.findRequiredView(paramView, 2131694236, "field 'rl_zz_cover_container' and method 'OnClick'");
    paramT.rl_zz_cover_container = localView;
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    paramT.ll_hz_cover_container = Utils.findRequiredView(paramView, 2131694234, "field 'll_hz_cover_container'");
    paramT.sdv_zz_cover = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131694238, "field 'sdv_zz_cover'", SimpleDraweeView.class));
    paramT.cb_photo_rules = ((CheckBox)Utils.findRequiredViewAsType(paramView, 2131694241, "field 'cb_photo_rules'", CheckBox.class));
    localView = Utils.findRequiredView(paramView, 2131691234, "field 'btn_landlord_rules' and method 'OnClick'");
    paramT.btn_landlord_rules = localView;
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691233, "field 'btn_platform_rules' and method 'OnClick'");
    paramT.btn_platform_rules = localView;
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    paramT.osv_content = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131691557, "field 'osv_content'", ObservableScrollView.class));
    paramT.v_divider = Utils.findRequiredView(paramView, 2131689863, "field 'v_divider'");
    paramT.tv_zz_cover_review = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694239, "field 'tv_zz_cover_review'", TextView.class));
    paramT.tv_room_ph_hint = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694240, "field 'tv_room_ph_hint'", TextView.class));
    paramView = Utils.findRequiredView(paramView, 2131694242, "method 'OnClick'");
    this.h = paramView;
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
    LandlordReleaseFifthFragment localLandlordReleaseFifthFragment = this.a;
    if (localLandlordReleaseFifthFragment == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLandlordReleaseFifthFragment.btn_back = null;
    localLandlordReleaseFifthFragment.btn_release = null;
    localLandlordReleaseFifthFragment.btn_preview = null;
    localLandlordReleaseFifthFragment.rv_picture = null;
    localLandlordReleaseFifthFragment.ruatv_tip = null;
    localLandlordReleaseFifthFragment.tv_picture_upload_info = null;
    localLandlordReleaseFifthFragment.rv_select_cover_picture = null;
    localLandlordReleaseFifthFragment.rl_zz_cover_container = null;
    localLandlordReleaseFifthFragment.ll_hz_cover_container = null;
    localLandlordReleaseFifthFragment.sdv_zz_cover = null;
    localLandlordReleaseFifthFragment.cb_photo_rules = null;
    localLandlordReleaseFifthFragment.btn_landlord_rules = null;
    localLandlordReleaseFifthFragment.btn_platform_rules = null;
    localLandlordReleaseFifthFragment.osv_content = null;
    localLandlordReleaseFifthFragment.v_divider = null;
    localLandlordReleaseFifthFragment.tv_zz_cover_review = null;
    localLandlordReleaseFifthFragment.tv_room_ph_hint = null;
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
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LandlordReleaseFifthFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */