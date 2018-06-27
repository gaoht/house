package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

public class ZOEvaluateSuccessActivity_ViewBinding<T extends ZOEvaluateSuccessActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public ZOEvaluateSuccessActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.btnBack = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690078, "field 'btnBack'", ImageView.class));
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    paramT.sdvEvaluateResultIcon = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131691831, "field 'sdvEvaluateResultIcon'", SimpleDraweeView.class));
    paramT.tvMyEvaluateResult = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691832, "field 'tvMyEvaluateResult'", TextView.class));
    paramT.tvMyEvaluateResultDesc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691835, "field 'tvMyEvaluateResultDesc'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131691836, "field 'btnSeeEvaluation' and method 'onViewClicked'");
    paramT.btnSeeEvaluation = ((TextView)Utils.castView(localView, 2131691836, "field 'btnSeeEvaluation'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131691834, "field 'btnBackMyZiroom' and method 'onViewClicked'");
    paramT.btnBackMyZiroom = ((TextView)Utils.castView(paramView, 2131691834, "field 'btnBackMyZiroom'", TextView.class));
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
    ZOEvaluateSuccessActivity localZOEvaluateSuccessActivity = this.a;
    if (localZOEvaluateSuccessActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localZOEvaluateSuccessActivity.btnBack = null;
    localZOEvaluateSuccessActivity.tvTitle = null;
    localZOEvaluateSuccessActivity.sdvEvaluateResultIcon = null;
    localZOEvaluateSuccessActivity.tvMyEvaluateResult = null;
    localZOEvaluateSuccessActivity.tvMyEvaluateResultDesc = null;
    localZOEvaluateSuccessActivity.btnSeeEvaluation = null;
    localZOEvaluateSuccessActivity.btnBackMyZiroom = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/ZOEvaluateSuccessActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */