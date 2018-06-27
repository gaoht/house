package com.ziroom.ziroomcustomer.signed;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;

public class BoundCardActivity_ViewBinding<T extends BoundCardActivity>
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
  private View i;
  
  public BoundCardActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mBztb = ((BasicZiroomToolBar)Utils.findRequiredViewAsType(paramView, 2131689787, "field 'mBztb'", BasicZiroomToolBar.class));
    View localView = Utils.findRequiredView(paramView, 2131690456, "field 'mLetBank' and method 'onViewClick'");
    paramT.mLetBank = ((TextView)Utils.castView(localView, 2131690456, "field 'mLetBank'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    paramT.mLetCard = ((EditText)Utils.findRequiredViewAsType(paramView, 2131693198, "field 'mLetCard'", EditText.class));
    paramT.mLetPhone = ((EditText)Utils.findRequiredViewAsType(paramView, 2131689983, "field 'mLetPhone'", EditText.class));
    localView = Utils.findRequiredView(paramView, 2131690043, "field 'mBtn' and method 'onViewClick'");
    paramT.mBtn = ((Button)Utils.castView(localView, 2131690043, "field 'mBtn'", Button.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131693202, "field 'let_verification_btn' and method 'onViewClick'");
    paramT.let_verification_btn = ((TextView)Utils.castView(localView, 2131693202, "field 'let_verification_btn'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    paramT.bound_card_check = ((CheckBox)Utils.findRequiredViewAsType(paramView, 2131693206, "field 'bound_card_check'", CheckBox.class));
    paramT.let_verification = ((EditText)Utils.findRequiredViewAsType(paramView, 2131693204, "field 'let_verification'", EditText.class));
    paramT.let_verification_rl = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131693201, "field 'let_verification_rl'", RelativeLayout.class));
    paramT.pay_installment_html = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131693205, "field 'pay_installment_html'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131693208, "field 'pay_installment_html_text' and method 'onViewClick'");
    paramT.pay_installment_html_text = ((TextView)Utils.castView(localView, 2131693208, "field 'pay_installment_html_text'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131693194, "field 'let_bank_img' and method 'onViewClick'");
    paramT.let_bank_img = ((ImageView)Utils.castView(localView, 2131693194, "field 'let_bank_img'", ImageView.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131692612, "field 'mTvCheckNotPass' and method 'onViewClick'");
    paramT.mTvCheckNotPass = ((TextView)Utils.castView(localView, 2131692612, "field 'mTvCheckNotPass'", TextView.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131693193, "method 'onViewClick'");
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131693195, "method 'onViewClick'");
    this.i = paramView;
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
    BoundCardActivity localBoundCardActivity = this.a;
    if (localBoundCardActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localBoundCardActivity.mBztb = null;
    localBoundCardActivity.mLetBank = null;
    localBoundCardActivity.mLetCard = null;
    localBoundCardActivity.mLetPhone = null;
    localBoundCardActivity.mBtn = null;
    localBoundCardActivity.let_verification_btn = null;
    localBoundCardActivity.bound_card_check = null;
    localBoundCardActivity.let_verification = null;
    localBoundCardActivity.let_verification_rl = null;
    localBoundCardActivity.pay_installment_html = null;
    localBoundCardActivity.pay_installment_html_text = null;
    localBoundCardActivity.let_bank_img = null;
    localBoundCardActivity.mTvCheckNotPass = null;
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
    this.i.setOnClickListener(null);
    this.i = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/BoundCardActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */