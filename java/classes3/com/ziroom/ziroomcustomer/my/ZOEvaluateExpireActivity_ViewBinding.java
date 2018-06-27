package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

public class ZOEvaluateExpireActivity_ViewBinding<T extends ZOEvaluateExpireActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public ZOEvaluateExpireActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.btnBack = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690078, "field 'btnBack'", ImageView.class));
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    paramT.sdvEvaluateResultIcon = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131691831, "field 'sdvEvaluateResultIcon'", SimpleDraweeView.class));
    paramT.tvMyEvaluateResult = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691832, "field 'tvMyEvaluateResult'", TextView.class));
    paramT.tvMyEvaluateDesc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691833, "field 'tvMyEvaluateDesc'", TextView.class));
    paramView = Utils.findRequiredView(paramView, 2131691834, "field 'btnBackMyZiroom' and method 'onViewClicked'");
    paramT.btnBackMyZiroom = ((TextView)Utils.castView(paramView, 2131691834, "field 'btnBackMyZiroom'", TextView.class));
    this.b = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked();
      }
    });
  }
  
  public void unbind()
  {
    ZOEvaluateExpireActivity localZOEvaluateExpireActivity = this.a;
    if (localZOEvaluateExpireActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localZOEvaluateExpireActivity.btnBack = null;
    localZOEvaluateExpireActivity.tvTitle = null;
    localZOEvaluateExpireActivity.sdvEvaluateResultIcon = null;
    localZOEvaluateExpireActivity.tvMyEvaluateResult = null;
    localZOEvaluateExpireActivity.tvMyEvaluateDesc = null;
    localZOEvaluateExpireActivity.btnBackMyZiroom = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/ZOEvaluateExpireActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */