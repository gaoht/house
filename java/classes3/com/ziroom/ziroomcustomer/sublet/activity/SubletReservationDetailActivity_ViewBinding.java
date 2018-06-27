package com.ziroom.ziroomcustomer.sublet.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.widget.InfoBlockLayout;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;

public class SubletReservationDetailActivity_ViewBinding<T extends SubletReservationDetailActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  
  public SubletReservationDetailActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131689492, "field 'ivBack' and method 'onViewClicked'");
    paramT.ivBack = ((ImageView)Utils.castView(localView, 2131689492, "field 'ivBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691990, "field 'tvContactKeeper' and method 'onViewClicked'");
    paramT.tvContactKeeper = ((TextView)Utils.castView(localView, 2131691990, "field 'tvContactKeeper'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.iblReservationInfo = ((InfoBlockLayout)Utils.findRequiredViewAsType(paramView, 2131697617, "field 'iblReservationInfo'", InfoBlockLayout.class));
    paramT.iblZuKeInfo = ((InfoBlockLayout)Utils.findRequiredViewAsType(paramView, 2131697618, "field 'iblZuKeInfo'", InfoBlockLayout.class));
    paramT.tvReservationStatus = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697613, "field 'tvReservationStatus'", TextView.class));
    paramT.sdvHouseInfoPic = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131696457, "field 'sdvHouseInfoPic'", SimpleDraweeView.class));
    paramT.tvHouseInfoTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696458, "field 'tvHouseInfoTitle'", TextView.class));
    paramT.tvHouseInfoPrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696459, "field 'tvHouseInfoPrice'", TextView.class));
    paramT.tvHouseInfoNumber = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696460, "field 'tvHouseInfoNumber'", TextView.class));
    paramT.tvConfirmDesc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697614, "field 'tvConfirmDesc'", TextView.class));
    paramT.lvfsvReservatingProgress = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131697616, "field 'lvfsvReservatingProgress'", ListViewForScrollView.class));
    localView = Utils.findRequiredView(paramView, 2131697619, "field 'tvBtnLeft' and method 'onViewClicked'");
    paramT.tvBtnLeft = ((TextView)Utils.castView(localView, 2131697619, "field 'tvBtnLeft'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131697620, "field 'tvBtnRight' and method 'onViewClicked'");
    paramT.tvBtnRight = ((TextView)Utils.castView(localView, 2131697620, "field 'tvBtnRight'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.llProgressContainer = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131697615, "field 'llProgressContainer'", LinearLayout.class));
    paramT.viewBelowContainer = Utils.findRequiredView(paramView, 2131696461, "field 'viewBelowContainer'");
    paramView = Utils.findRequiredView(paramView, 2131696456, "field 'rlHouseInfoContainer' and method 'onViewClicked'");
    paramT.rlHouseInfoContainer = ((RelativeLayout)Utils.castView(paramView, 2131696456, "field 'rlHouseInfoContainer'", RelativeLayout.class));
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
    SubletReservationDetailActivity localSubletReservationDetailActivity = this.a;
    if (localSubletReservationDetailActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localSubletReservationDetailActivity.ivBack = null;
    localSubletReservationDetailActivity.tvContactKeeper = null;
    localSubletReservationDetailActivity.iblReservationInfo = null;
    localSubletReservationDetailActivity.iblZuKeInfo = null;
    localSubletReservationDetailActivity.tvReservationStatus = null;
    localSubletReservationDetailActivity.sdvHouseInfoPic = null;
    localSubletReservationDetailActivity.tvHouseInfoTitle = null;
    localSubletReservationDetailActivity.tvHouseInfoPrice = null;
    localSubletReservationDetailActivity.tvHouseInfoNumber = null;
    localSubletReservationDetailActivity.tvConfirmDesc = null;
    localSubletReservationDetailActivity.lvfsvReservatingProgress = null;
    localSubletReservationDetailActivity.tvBtnLeft = null;
    localSubletReservationDetailActivity.tvBtnRight = null;
    localSubletReservationDetailActivity.llProgressContainer = null;
    localSubletReservationDetailActivity.viewBelowContainer = null;
    localSubletReservationDetailActivity.rlHouseInfoContainer = null;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/activity/SubletReservationDetailActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */