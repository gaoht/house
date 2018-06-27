package com.ziroom.ziroomcustomer.ziroomstation;

import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class IntoDealMainActivity_ViewBinding<T extends IntoDealMainActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  
  public IntoDealMainActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131690078, "field 'btnBack' and method 'onClick'");
    paramT.btnBack = ((ImageView)Utils.castView(localView, 2131690078, "field 'btnBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131692791, "field 'tvRenewBatch' and method 'onClick'");
    paramT.tvRenewBatch = ((TextView)Utils.castView(localView, 2131692791, "field 'tvRenewBatch'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.llTabsViewGroup = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692792, "field 'llTabsViewGroup'", LinearLayout.class));
    paramT.tvCashPledgeTotal = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692800, "field 'tvCashPledgeTotal'", TextView.class));
    paramT.ivCashPledgeRightIcon = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131692801, "field 'ivCashPledgeRightIcon'", ImageView.class));
    localView = Utils.findRequiredView(paramView, 2131692802, "field 'btnPayNow' and method 'onClick'");
    paramT.btnPayNow = ((Button)Utils.castView(localView, 2131692802, "field 'btnPayNow'", Button.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131692535, "field 'rlPricesDetails' and method 'onClick'");
    paramT.rlPricesDetails = ((LinearLayout)Utils.castView(localView, 2131692535, "field 'rlPricesDetails'", LinearLayout.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.hScrollView = ((HorizontalScrollView)Utils.findRequiredViewAsType(paramView, 2131690093, "field 'hScrollView'", HorizontalScrollView.class));
    paramT.rlRoomMap8 = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131692794, "field 'rlRoomMap8'", RelativeLayout.class));
    paramT.rlRoomMap12 = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131692796, "field 'rlRoomMap12'", RelativeLayout.class));
    paramT.ivRoomMap8 = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131692795, "field 'ivRoomMap8'", ImageView.class));
    paramT.ivRoomMap12 = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131692797, "field 'ivRoomMap12'", ImageView.class));
    paramT.llBtnsAtBotton = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692798, "field 'llBtnsAtBotton'", LinearLayout.class));
    paramT.hsvRoomBedsMap = ((HorizontalScrollView)Utils.findRequiredViewAsType(paramView, 2131692793, "field 'hsvRoomBedsMap'", HorizontalScrollView.class));
  }
  
  public void unbind()
  {
    IntoDealMainActivity localIntoDealMainActivity = this.a;
    if (localIntoDealMainActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localIntoDealMainActivity.btnBack = null;
    localIntoDealMainActivity.tvTitle = null;
    localIntoDealMainActivity.tvRenewBatch = null;
    localIntoDealMainActivity.llTabsViewGroup = null;
    localIntoDealMainActivity.tvCashPledgeTotal = null;
    localIntoDealMainActivity.ivCashPledgeRightIcon = null;
    localIntoDealMainActivity.btnPayNow = null;
    localIntoDealMainActivity.rlPricesDetails = null;
    localIntoDealMainActivity.hScrollView = null;
    localIntoDealMainActivity.rlRoomMap8 = null;
    localIntoDealMainActivity.rlRoomMap12 = null;
    localIntoDealMainActivity.ivRoomMap8 = null;
    localIntoDealMainActivity.ivRoomMap12 = null;
    localIntoDealMainActivity.llBtnsAtBotton = null;
    localIntoDealMainActivity.hsvRoomBedsMap = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.e.setOnClickListener(null);
    this.e = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/IntoDealMainActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */