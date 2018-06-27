package com.ziroom.ziroomcustomer.sublet.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.widget.InfoBlockLayout;

public class SubletReservationConfirmActivity_ViewBinding<T extends SubletReservationConfirmActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public SubletReservationConfirmActivity_ViewBinding(final T paramT, View paramView)
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
    paramT.iblReservatorInfo = ((InfoBlockLayout)Utils.findRequiredViewAsType(paramView, 2131697608, "field 'iblReservatorInfo'", InfoBlockLayout.class));
    paramT.tvDateDesc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697609, "field 'tvDateDesc'", TextView.class));
    paramT.iblHouseInfo = ((InfoBlockLayout)Utils.findRequiredViewAsType(paramView, 2131697610, "field 'iblHouseInfo'", InfoBlockLayout.class));
    paramT.iblInitiatorInfo = ((InfoBlockLayout)Utils.findRequiredViewAsType(paramView, 2131697611, "field 'iblInitiatorInfo'", InfoBlockLayout.class));
    paramView = Utils.findRequiredView(paramView, 2131697612, "field 'tvConfirmReservation' and method 'onViewClicked'");
    paramT.tvConfirmReservation = ((TextView)Utils.castView(paramView, 2131697612, "field 'tvConfirmReservation'", TextView.class));
    this.d = paramView;
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
    SubletReservationConfirmActivity localSubletReservationConfirmActivity = this.a;
    if (localSubletReservationConfirmActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localSubletReservationConfirmActivity.ivBack = null;
    localSubletReservationConfirmActivity.tvContactKeeper = null;
    localSubletReservationConfirmActivity.iblReservatorInfo = null;
    localSubletReservationConfirmActivity.tvDateDesc = null;
    localSubletReservationConfirmActivity.iblHouseInfo = null;
    localSubletReservationConfirmActivity.iblInitiatorInfo = null;
    localSubletReservationConfirmActivity.tvConfirmReservation = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */