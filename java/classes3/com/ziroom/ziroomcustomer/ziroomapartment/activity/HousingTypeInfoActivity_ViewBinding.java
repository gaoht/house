package com.ziroom.ziroomcustomer.ziroomapartment.activity;

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
import com.ziroom.ziroomcustomer.widget.AutoLineFeedLayout;
import com.ziroom.ziroomcustomer.widget.ExpandableTextViewNewLine;
import com.ziroom.ziroomcustomer.widget.LinearLayoutForListView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class HousingTypeInfoActivity_ViewBinding<T extends HousingTypeInfoActivity>
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
  
  public HousingTypeInfoActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.rlSlider = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131692858, "field 'rlSlider'", RelativeLayout.class));
    paramT.tvPrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689912, "field 'tvPrice'", TextView.class));
    paramT.tvHousetype = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696568, "field 'tvHousetype'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131696569, "field 'tvHouseRemaining' and method 'onViewClicked'");
    paramT.tvHouseRemaining = ((TextView)Utils.castView(localView, 2131696569, "field 'tvHouseRemaining'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.alflHouseInfoTag = ((AutoLineFeedLayout)Utils.findRequiredViewAsType(paramView, 2131696406, "field 'alflHouseInfoTag'", AutoLineFeedLayout.class));
    paramT.tvLocation = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690748, "field 'tvLocation'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131696571, "field 'llLocation' and method 'onViewClicked'");
    paramT.llLocation = ((LinearLayout)Utils.castView(localView, 2131696571, "field 'llLocation'", LinearLayout.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.llActivity = ((LinearLayoutForListView)Utils.findRequiredViewAsType(paramView, 2131696573, "field 'llActivity'", LinearLayoutForListView.class));
    paramT.llConfigBlock = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696564, "field 'llConfigBlock'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131696566, "field 'tvConfigMore' and method 'onViewClicked'");
    paramT.tvConfigMore = ((TextView)Utils.castView(localView, 2131696566, "field 'tvConfigMore'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131696567, "field 'ivConfigArrowMore' and method 'onViewClicked'");
    paramT.ivConfigArrowMore = ((ImageView)Utils.castView(localView, 2131696567, "field 'ivConfigArrowMore'", ImageView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.llRoomBlock = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696565, "field 'llRoomBlock'", LinearLayout.class));
    paramT.etvHouseIntroduce = ((ExpandableTextViewNewLine)Utils.findRequiredViewAsType(paramView, 2131696415, "field 'etvHouseIntroduce'", ExpandableTextViewNewLine.class));
    paramT.llConfig = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691352, "field 'llConfig'", LinearLayout.class));
    paramT.llRooms = ((LinearLayoutForListView)Utils.findRequiredViewAsType(paramView, 2131696575, "field 'llRooms'", LinearLayoutForListView.class));
    paramT.osv = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131690031, "field 'osv'", ObservableScrollView.class));
    paramT.vHeader = Utils.findRequiredView(paramView, 2131694590, "field 'vHeader'");
    localView = Utils.findRequiredView(paramView, 2131689492, "field 'ivBack' and method 'onViewClicked'");
    paramT.ivBack = ((ImageView)Utils.castView(localView, 2131689492, "field 'ivBack'", ImageView.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690673, "field 'ivShare' and method 'onViewClicked'");
    paramT.ivShare = ((ImageView)Utils.castView(localView, 2131690673, "field 'ivShare'", ImageView.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.llHeader = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691583, "field 'llHeader'", LinearLayout.class));
    paramT.vHeaderDivider = Utils.findRequiredView(paramView, 2131696034, "field 'vHeaderDivider'");
    localView = Utils.findRequiredView(paramView, 2131696057, "field 'btnA' and method 'onViewClicked'");
    paramT.btnA = ((Button)Utils.castView(localView, 2131696057, "field 'btnA'", Button.class));
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131696058, "field 'btnB' and method 'onViewClicked'");
    paramT.btnB = ((Button)Utils.castView(localView, 2131696058, "field 'btnB'", Button.class));
    this.i = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.vsError = ((ViewStub)Utils.findRequiredViewAsType(paramView, 2131690894, "field 'vsError'", ViewStub.class));
    paramT.divider_location = Utils.findRequiredView(paramView, 2131696572, "field 'divider_location'");
    paramT.divider_activity = Utils.findRequiredView(paramView, 2131696574, "field 'divider_activity'");
    paramT.divider_tags = Utils.findRequiredView(paramView, 2131696570, "field 'divider_tags'");
    paramT.mRvSlider = ((RecyclerView)Utils.findRequiredViewAsType(paramView, 2131692860, "field 'mRvSlider'", RecyclerView.class));
  }
  
  public void unbind()
  {
    HousingTypeInfoActivity localHousingTypeInfoActivity = this.a;
    if (localHousingTypeInfoActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localHousingTypeInfoActivity.rlSlider = null;
    localHousingTypeInfoActivity.tvPrice = null;
    localHousingTypeInfoActivity.tvHousetype = null;
    localHousingTypeInfoActivity.tvHouseRemaining = null;
    localHousingTypeInfoActivity.alflHouseInfoTag = null;
    localHousingTypeInfoActivity.tvLocation = null;
    localHousingTypeInfoActivity.llLocation = null;
    localHousingTypeInfoActivity.llActivity = null;
    localHousingTypeInfoActivity.llConfigBlock = null;
    localHousingTypeInfoActivity.tvConfigMore = null;
    localHousingTypeInfoActivity.ivConfigArrowMore = null;
    localHousingTypeInfoActivity.llRoomBlock = null;
    localHousingTypeInfoActivity.etvHouseIntroduce = null;
    localHousingTypeInfoActivity.llConfig = null;
    localHousingTypeInfoActivity.llRooms = null;
    localHousingTypeInfoActivity.osv = null;
    localHousingTypeInfoActivity.vHeader = null;
    localHousingTypeInfoActivity.ivBack = null;
    localHousingTypeInfoActivity.ivShare = null;
    localHousingTypeInfoActivity.llHeader = null;
    localHousingTypeInfoActivity.vHeaderDivider = null;
    localHousingTypeInfoActivity.btnA = null;
    localHousingTypeInfoActivity.btnB = null;
    localHousingTypeInfoActivity.vsError = null;
    localHousingTypeInfoActivity.divider_location = null;
    localHousingTypeInfoActivity.divider_activity = null;
    localHousingTypeInfoActivity.divider_tags = null;
    localHousingTypeInfoActivity.mRvSlider = null;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/HousingTypeInfoActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */