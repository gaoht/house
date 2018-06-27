package com.ziroom.ziroomcustomer.ziroomstation;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class IntoPaySuccessActivity_ViewBinding<T extends IntoPaySuccessActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public IntoPaySuccessActivity_ViewBinding(final T paramT, View paramView)
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
    paramT.ivPayResultPic = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131692808, "field 'ivPayResultPic'", ImageView.class));
    paramT.tvPayResult = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692809, "field 'tvPayResult'", TextView.class));
    paramT.tvPaySuccTipTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692810, "field 'tvPaySuccTipTitle'", TextView.class));
    paramT.tvPaySuccTips = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692811, "field 'tvPaySuccTips'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131692812, "field 'btnPaySuccSeeOrder' and method 'onClick'");
    paramT.btnPaySuccSeeOrder = ((Button)Utils.castView(localView, 2131692812, "field 'btnPaySuccSeeOrder'", Button.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131692813, "field 'tvPaySuccIntoSeeRules' and method 'onClick'");
    paramT.tvPaySuccIntoSeeRules = ((TextView)Utils.castView(paramView, 2131692813, "field 'tvPaySuccIntoSeeRules'", TextView.class));
    this.d = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    IntoPaySuccessActivity localIntoPaySuccessActivity = this.a;
    if (localIntoPaySuccessActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localIntoPaySuccessActivity.btnBack = null;
    localIntoPaySuccessActivity.tvTitle = null;
    localIntoPaySuccessActivity.ivPayResultPic = null;
    localIntoPaySuccessActivity.tvPayResult = null;
    localIntoPaySuccessActivity.tvPaySuccTipTitle = null;
    localIntoPaySuccessActivity.tvPaySuccTips = null;
    localIntoPaySuccessActivity.btnPaySuccSeeOrder = null;
    localIntoPaySuccessActivity.tvPaySuccIntoSeeRules = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/IntoPaySuccessActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */