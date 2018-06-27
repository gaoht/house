package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;

public class GeneralCleaningEvalActivity_ViewBinding<T extends GeneralCleaningEvalActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public GeneralCleaningEvalActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.sdv_avatar = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131690070, "field 'sdv_avatar'", SimpleDraweeView.class));
    paramT.tv_name = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690049, "field 'tv_name'", TextView.class));
    paramT.rb_rating = ((RatingBar)Utils.findRequiredViewAsType(paramView, 2131690072, "field 'rb_rating'", RatingBar.class));
    paramT.tv_desc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690073, "field 'tv_desc'", TextView.class));
    paramT.fl_like = ((FlowLayout)Utils.findRequiredViewAsType(paramView, 2131690332, "field 'fl_like'", FlowLayout.class));
    paramT.et_eval = ((EditText)Utils.findRequiredViewAsType(paramView, 2131690075, "field 'et_eval'", EditText.class));
    paramT.tv_eval_num = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690076, "field 'tv_eval_num'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131689816, "field 'btn_submit' and method 'onClick'");
    paramT.btn_submit = ((Button)Utils.castView(localView, 2131689816, "field 'btn_submit'", Button.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131689492, "method 'onClick'");
    this.c = paramView;
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
    GeneralCleaningEvalActivity localGeneralCleaningEvalActivity = this.a;
    if (localGeneralCleaningEvalActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localGeneralCleaningEvalActivity.sdv_avatar = null;
    localGeneralCleaningEvalActivity.tv_name = null;
    localGeneralCleaningEvalActivity.rb_rating = null;
    localGeneralCleaningEvalActivity.tv_desc = null;
    localGeneralCleaningEvalActivity.fl_like = null;
    localGeneralCleaningEvalActivity.et_eval = null;
    localGeneralCleaningEvalActivity.tv_eval_num = null;
    localGeneralCleaningEvalActivity.btn_submit = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/GeneralCleaningEvalActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */