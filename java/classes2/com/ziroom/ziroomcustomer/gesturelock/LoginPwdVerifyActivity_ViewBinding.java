package com.ziroom.ziroomcustomer.gesturelock;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class LoginPwdVerifyActivity_ViewBinding<T extends LoginPwdVerifyActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public LoginPwdVerifyActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.myinfoTvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695949, "field 'myinfoTvTitle'", TextView.class));
    paramT.tv_rightButton = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695950, "field 'tv_rightButton'", TextView.class));
    paramT.edt_pwd = ((EditText)Utils.findRequiredViewAsType(paramView, 2131691139, "field 'edt_pwd'", EditText.class));
    View localView = Utils.findRequiredView(paramView, 2131695948, "method 'onClick'");
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131691140, "method 'onClick'");
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
    LoginPwdVerifyActivity localLoginPwdVerifyActivity = this.a;
    if (localLoginPwdVerifyActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLoginPwdVerifyActivity.myinfoTvTitle = null;
    localLoginPwdVerifyActivity.tv_rightButton = null;
    localLoginPwdVerifyActivity.edt_pwd = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/gesturelock/LoginPwdVerifyActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */