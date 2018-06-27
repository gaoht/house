package com.ziroom.ziroomcustomer.newclean.periodclean.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class PeriodCleanChangePhoneActivity_ViewBinding<T extends PeriodCleanChangePhoneActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public PeriodCleanChangePhoneActivity_ViewBinding(final T paramT, View paramView)
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
    paramT.edPhone = ((EditText)Utils.findRequiredViewAsType(paramView, 2131692071, "field 'edPhone'", EditText.class));
    localView = Utils.findRequiredView(paramView, 2131692072, "field 'imgClean' and method 'onViewClicked'");
    paramT.imgClean = ((ImageView)Utils.castView(localView, 2131692072, "field 'imgClean'", ImageView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131690043, "field 'btn' and method 'onViewClicked'");
    paramT.btn = ((Button)Utils.castView(paramView, 2131690043, "field 'btn'", Button.class));
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
    PeriodCleanChangePhoneActivity localPeriodCleanChangePhoneActivity = this.a;
    if (localPeriodCleanChangePhoneActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localPeriodCleanChangePhoneActivity.ivBack = null;
    localPeriodCleanChangePhoneActivity.edPhone = null;
    localPeriodCleanChangePhoneActivity.imgClean = null;
    localPeriodCleanChangePhoneActivity.btn = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/activity/PeriodCleanChangePhoneActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */