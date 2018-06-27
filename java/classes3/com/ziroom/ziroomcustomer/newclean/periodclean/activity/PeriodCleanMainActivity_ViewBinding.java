package com.ziroom.ziroomcustomer.newclean.periodclean.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.newServiceList.view.RatingStar;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import com.ziroom.ziroomcustomer.widget.MyCleanListView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class PeriodCleanMainActivity_ViewBinding<T extends PeriodCleanMainActivity>
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
  
  public PeriodCleanMainActivity_ViewBinding(final T paramT, View paramView)
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
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    paramT.rlTitle = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131689808, "field 'rlTitle'", RelativeLayout.class));
    paramT.tvPhone = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690666, "field 'tvPhone'", TextView.class));
    paramT.tvAddress = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690053, "field 'tvAddress'", TextView.class));
    paramT.ivIcon = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131690097, "field 'ivIcon'", SimpleDraweeView.class));
    paramT.view = Utils.findRequiredView(paramView, 2131690147, "field 'view'");
    paramT.tvUserName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690912, "field 'tvUserName'", TextView.class));
    paramT.tvUserAge = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692090, "field 'tvUserAge'", TextView.class));
    paramT.tvUserPriace = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692091, "field 'tvUserPriace'", TextView.class));
    paramT.tvUserServiceTxt = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692092, "field 'tvUserServiceTxt'", TextView.class));
    paramT.rsStar = ((RatingStar)Utils.findRequiredViewAsType(paramView, 2131690595, "field 'rsStar'", RatingStar.class));
    paramT.rlUser = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131691500, "field 'rlUser'", RelativeLayout.class));
    paramT.etUser = ((LabeledEditText)Utils.findRequiredViewAsType(paramView, 2131692094, "field 'etUser'", LabeledEditText.class));
    localView = Utils.findRequiredView(paramView, 2131692095, "field 'etPeriod' and method 'onViewClicked'");
    paramT.etPeriod = ((LabeledEditText)Utils.castView(localView, 2131692095, "field 'etPeriod'", LabeledEditText.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131692096, "field 'etTimeLong' and method 'onViewClicked'");
    paramT.etTimeLong = ((LabeledEditText)Utils.castView(localView, 2131692096, "field 'etTimeLong'", LabeledEditText.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690987, "field 'etTime' and method 'onViewClicked'");
    paramT.etTime = ((LabeledEditText)Utils.castView(localView, 2131690987, "field 'etTime'", LabeledEditText.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690002, "field 'etRemark' and method 'onViewClicked'");
    paramT.etRemark = ((LabeledEditText)Utils.castView(localView, 2131690002, "field 'etRemark'", LabeledEditText.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690043, "field 'btn' and method 'onViewClicked'");
    paramT.btn = ((Button)Utils.castView(localView, 2131690043, "field 'btn'", Button.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131692089, "field 'llPlace' and method 'onViewClicked'");
    paramT.llPlace = ((LinearLayout)Utils.castView(localView, 2131692089, "field 'llPlace'", LinearLayout.class));
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.llNoUser = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692093, "field 'llNoUser'", LinearLayout.class));
    paramT.listNotices = ((MyCleanListView)Utils.findRequiredViewAsType(paramView, 2131691228, "field 'listNotices'", MyCleanListView.class));
    paramT.vUser = Utils.findRequiredView(paramView, 2131691501, "field 'vUser'");
    paramT.scrollview = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131689506, "field 'scrollview'", ObservableScrollView.class));
  }
  
  public void unbind()
  {
    PeriodCleanMainActivity localPeriodCleanMainActivity = this.a;
    if (localPeriodCleanMainActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localPeriodCleanMainActivity.ivBack = null;
    localPeriodCleanMainActivity.tvTitle = null;
    localPeriodCleanMainActivity.rlTitle = null;
    localPeriodCleanMainActivity.tvPhone = null;
    localPeriodCleanMainActivity.tvAddress = null;
    localPeriodCleanMainActivity.ivIcon = null;
    localPeriodCleanMainActivity.view = null;
    localPeriodCleanMainActivity.tvUserName = null;
    localPeriodCleanMainActivity.tvUserAge = null;
    localPeriodCleanMainActivity.tvUserPriace = null;
    localPeriodCleanMainActivity.tvUserServiceTxt = null;
    localPeriodCleanMainActivity.rsStar = null;
    localPeriodCleanMainActivity.rlUser = null;
    localPeriodCleanMainActivity.etUser = null;
    localPeriodCleanMainActivity.etPeriod = null;
    localPeriodCleanMainActivity.etTimeLong = null;
    localPeriodCleanMainActivity.etTime = null;
    localPeriodCleanMainActivity.etRemark = null;
    localPeriodCleanMainActivity.btn = null;
    localPeriodCleanMainActivity.llPlace = null;
    localPeriodCleanMainActivity.llNoUser = null;
    localPeriodCleanMainActivity.listNotices = null;
    localPeriodCleanMainActivity.vUser = null;
    localPeriodCleanMainActivity.scrollview = null;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/activity/PeriodCleanMainActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */