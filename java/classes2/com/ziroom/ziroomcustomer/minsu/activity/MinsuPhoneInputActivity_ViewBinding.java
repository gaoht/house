package com.ziroom.ziroomcustomer.minsu.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class MinsuPhoneInputActivity_ViewBinding<T extends MinsuPhoneInputActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public MinsuPhoneInputActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131689816, "field 'mBtnSubmit' and method 'onViewClick'");
    paramT.mBtnSubmit = ((Button)Utils.castView(localView, 2131689816, "field 'mBtnSubmit'", Button.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    paramT.nationName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691641, "field 'nationName'", TextView.class));
    paramT.nationCode = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691644, "field 'nationCode'", TextView.class));
    paramT.et_customer_mobile = ((EditText)Utils.findRequiredViewAsType(paramView, 2131691645, "field 'et_customer_mobile'", EditText.class));
    paramView = Utils.findRequiredView(paramView, 2131691639, "method 'onViewClick'");
    this.c = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    MinsuPhoneInputActivity localMinsuPhoneInputActivity = this.a;
    if (localMinsuPhoneInputActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuPhoneInputActivity.mBtnSubmit = null;
    localMinsuPhoneInputActivity.nationName = null;
    localMinsuPhoneInputActivity.nationCode = null;
    localMinsuPhoneInputActivity.et_customer_mobile = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuPhoneInputActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */