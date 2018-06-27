package com.ziroom.ziroomcustomer.findhouse.view;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.commonlibrary.widget.rangebar.RangeBar;
import com.ziroom.ziroomcustomer.widget.AverageItemLayout;

public class HousemapFilterDialog_ViewBinding<T extends HousemapFilterDialog>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public HousemapFilterDialog_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mAilRapid = ((AverageItemLayout)Utils.findRequiredViewAsType(paramView, 2131696221, "field 'mAilRapid'", AverageItemLayout.class));
    paramT.mAilHouseTypeHZ = ((AverageItemLayout)Utils.findRequiredViewAsType(paramView, 2131696223, "field 'mAilHouseTypeHZ'", AverageItemLayout.class));
    paramT.mLlHouseTypeHZ = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696222, "field 'mLlHouseTypeHZ'", LinearLayout.class));
    paramT.mAilHouseTypeZZ = ((AverageItemLayout)Utils.findRequiredViewAsType(paramView, 2131696225, "field 'mAilHouseTypeZZ'", AverageItemLayout.class));
    paramT.mLlHouseTypeZZ = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696224, "field 'mLlHouseTypeZZ'", LinearLayout.class));
    paramT.mAilHouseTypeYZ = ((AverageItemLayout)Utils.findRequiredViewAsType(paramView, 2131696227, "field 'mAilHouseTypeYZ'", AverageItemLayout.class));
    paramT.mLlHouseTypeYZ = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696226, "field 'mLlHouseTypeYZ'", LinearLayout.class));
    paramT.mAilHouseTypeLuxury = ((AverageItemLayout)Utils.findRequiredViewAsType(paramView, 2131696229, "field 'mAilHouseTypeLuxury'", AverageItemLayout.class));
    paramT.mLlHouseTypeLuxury = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696228, "field 'mLlHouseTypeLuxury'", LinearLayout.class));
    paramT.mTvHousemapPrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696230, "field 'mTvHousemapPrice'", TextView.class));
    paramT.mRangebarPrice = ((RangeBar)Utils.findRequiredViewAsType(paramView, 2131696231, "field 'mRangebarPrice'", RangeBar.class));
    paramT.mLlPrice = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692948, "field 'mLlPrice'", LinearLayout.class));
    paramT.mAilPrice = ((AverageItemLayout)Utils.findRequiredViewAsType(paramView, 2131696232, "field 'mAilPrice'", AverageItemLayout.class));
    paramT.mAilFace = ((AverageItemLayout)Utils.findRequiredViewAsType(paramView, 2131696234, "field 'mAilFace'", AverageItemLayout.class));
    paramT.mLlFace = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696233, "field 'mLlFace'", LinearLayout.class));
    paramT.mAilArea = ((AverageItemLayout)Utils.findRequiredViewAsType(paramView, 2131696235, "field 'mAilArea'", AverageItemLayout.class));
    paramT.mLlArea = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131694308, "field 'mLlArea'", LinearLayout.class));
    paramT.mAilFeature = ((AverageItemLayout)Utils.findRequiredViewAsType(paramView, 2131696237, "field 'mAilFeature'", AverageItemLayout.class));
    paramT.mLlFeature = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696236, "field 'mLlFeature'", LinearLayout.class));
    paramT.mAilAround = ((AverageItemLayout)Utils.findRequiredViewAsType(paramView, 2131696238, "field 'mAilAround'", AverageItemLayout.class));
    paramT.mLlAround = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695971, "field 'mLlAround'", LinearLayout.class));
    paramT.mAilVersion1 = ((AverageItemLayout)Utils.findRequiredViewAsType(paramView, 2131696240, "field 'mAilVersion1'", AverageItemLayout.class));
    paramT.mAilVersion2 = ((AverageItemLayout)Utils.findRequiredViewAsType(paramView, 2131696241, "field 'mAilVersion2'", AverageItemLayout.class));
    paramT.mLlVersion = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696239, "field 'mLlVersion'", LinearLayout.class));
    paramT.mAilLeaseType = ((AverageItemLayout)Utils.findRequiredViewAsType(paramView, 2131696243, "field 'mAilLeaseType'", AverageItemLayout.class));
    paramT.mLlRentType = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696242, "field 'mLlRentType'", LinearLayout.class));
    paramT.mAilTags = ((AverageItemLayout)Utils.findRequiredViewAsType(paramView, 2131696245, "field 'mAilTags'", AverageItemLayout.class));
    paramT.mLlHouseStatus = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696244, "field 'mLlHouseStatus'", LinearLayout.class));
    View localView = Utils.findRequiredView(paramView, 2131693064, "field 'mTvReset' and method 'onViewClicked'");
    paramT.mTvReset = ((TextView)Utils.castView(localView, 2131693064, "field 'mTvReset'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131691289, "field 'mTvOk' and method 'onViewClicked'");
    paramT.mTvOk = ((TextView)Utils.castView(paramView, 2131691289, "field 'mTvOk'", TextView.class));
    this.c = paramView;
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
    HousemapFilterDialog localHousemapFilterDialog = this.a;
    if (localHousemapFilterDialog == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localHousemapFilterDialog.mAilRapid = null;
    localHousemapFilterDialog.mAilHouseTypeHZ = null;
    localHousemapFilterDialog.mLlHouseTypeHZ = null;
    localHousemapFilterDialog.mAilHouseTypeZZ = null;
    localHousemapFilterDialog.mLlHouseTypeZZ = null;
    localHousemapFilterDialog.mAilHouseTypeYZ = null;
    localHousemapFilterDialog.mLlHouseTypeYZ = null;
    localHousemapFilterDialog.mAilHouseTypeLuxury = null;
    localHousemapFilterDialog.mLlHouseTypeLuxury = null;
    localHousemapFilterDialog.mTvHousemapPrice = null;
    localHousemapFilterDialog.mRangebarPrice = null;
    localHousemapFilterDialog.mLlPrice = null;
    localHousemapFilterDialog.mAilPrice = null;
    localHousemapFilterDialog.mAilFace = null;
    localHousemapFilterDialog.mLlFace = null;
    localHousemapFilterDialog.mAilArea = null;
    localHousemapFilterDialog.mLlArea = null;
    localHousemapFilterDialog.mAilFeature = null;
    localHousemapFilterDialog.mLlFeature = null;
    localHousemapFilterDialog.mAilAround = null;
    localHousemapFilterDialog.mLlAround = null;
    localHousemapFilterDialog.mAilVersion1 = null;
    localHousemapFilterDialog.mAilVersion2 = null;
    localHousemapFilterDialog.mLlVersion = null;
    localHousemapFilterDialog.mAilLeaseType = null;
    localHousemapFilterDialog.mLlRentType = null;
    localHousemapFilterDialog.mAilTags = null;
    localHousemapFilterDialog.mLlHouseStatus = null;
    localHousemapFilterDialog.mTvReset = null;
    localHousemapFilterDialog.mTvOk = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/HousemapFilterDialog_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */