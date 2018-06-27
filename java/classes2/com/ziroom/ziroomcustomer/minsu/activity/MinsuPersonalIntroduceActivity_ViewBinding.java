package com.ziroom.ziroomcustomer.minsu.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class MinsuPersonalIntroduceActivity_ViewBinding<T extends MinsuPersonalIntroduceActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public MinsuPersonalIntroduceActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.etContent = ((EditText)Utils.findRequiredViewAsType(paramView, 2131690084, "field 'etContent'", EditText.class));
    paramView = Utils.findRequiredView(paramView, 2131689997, "field 'tvSubmit' and method 'onClick'");
    paramT.tvSubmit = ((TextView)Utils.castView(paramView, 2131689997, "field 'tvSubmit'", TextView.class));
    this.b = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick();
      }
    });
  }
  
  public void unbind()
  {
    MinsuPersonalIntroduceActivity localMinsuPersonalIntroduceActivity = this.a;
    if (localMinsuPersonalIntroduceActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuPersonalIntroduceActivity.etContent = null;
    localMinsuPersonalIntroduceActivity.tvSubmit = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuPersonalIntroduceActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */