package com.ziroom.ziroomcustomer.newclean.periodclean.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;

public class PeriodcleanMoveSpecialActivity_ViewBinding<T extends PeriodcleanMoveSpecialActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public PeriodcleanMoveSpecialActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131689956, "field 'tv_commit' and method 'onClick'");
    paramT.tv_commit = ((TextView)Utils.castView(localView, 2131689956, "field 'tv_commit'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.fl_like = ((FlowLayout)Utils.findRequiredViewAsType(paramView, 2131690332, "field 'fl_like'", FlowLayout.class));
    paramT.et_remark = ((EditText)Utils.findRequiredViewAsType(paramView, 2131690002, "field 'et_remark'", EditText.class));
    paramT.tv_wordnum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691765, "field 'tv_wordnum'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131689492, "field 'ivBack' and method 'onClick'");
    paramT.ivBack = ((ImageView)Utils.castView(localView, 2131689492, "field 'ivBack'", ImageView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.tvHotLabel = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692098, "field 'tvHotLabel'", TextView.class));
    paramT.tvOtherRemark = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692099, "field 'tvOtherRemark'", TextView.class));
    paramT.view = Utils.findRequiredView(paramView, 2131690147, "field 'view'");
    paramT.tvTotalCount = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691766, "field 'tvTotalCount'", TextView.class));
  }
  
  public void unbind()
  {
    PeriodcleanMoveSpecialActivity localPeriodcleanMoveSpecialActivity = this.a;
    if (localPeriodcleanMoveSpecialActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localPeriodcleanMoveSpecialActivity.tv_commit = null;
    localPeriodcleanMoveSpecialActivity.fl_like = null;
    localPeriodcleanMoveSpecialActivity.et_remark = null;
    localPeriodcleanMoveSpecialActivity.tv_wordnum = null;
    localPeriodcleanMoveSpecialActivity.ivBack = null;
    localPeriodcleanMoveSpecialActivity.tvHotLabel = null;
    localPeriodcleanMoveSpecialActivity.tvOtherRemark = null;
    localPeriodcleanMoveSpecialActivity.view = null;
    localPeriodcleanMoveSpecialActivity.tvTotalCount = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/activity/PeriodcleanMoveSpecialActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */