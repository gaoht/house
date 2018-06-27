package com.ziroom.ziroomcustomer.sublet.activity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;

public class LeaseSubletInfomationActivity_ViewBinding<T extends LeaseSubletInfomationActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  
  public LeaseSubletInfomationActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.bztb = ((BasicZiroomToolBar)Utils.findRequiredViewAsType(paramView, 2131689787, "field 'bztb'", BasicZiroomToolBar.class));
    View localView = Utils.findRequiredView(paramView, 2131692249, "field 'btnOk' and method 'onViewClicked'");
    paramT.btnOk = ((Button)Utils.castView(localView, 2131692249, "field 'btnOk'", Button.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.etSubletName = ((EditText)Utils.findRequiredViewAsType(paramView, 2131696688, "field 'etSubletName'", EditText.class));
    paramT.rbSubletSexWoman = ((RadioButton)Utils.findRequiredViewAsType(paramView, 2131696690, "field 'rbSubletSexWoman'", RadioButton.class));
    paramT.rbSubletSexMan = ((RadioButton)Utils.findRequiredViewAsType(paramView, 2131696691, "field 'rbSubletSexMan'", RadioButton.class));
    paramT.rgSubletSex = ((RadioGroup)Utils.findRequiredViewAsType(paramView, 2131696689, "field 'rgSubletSex'", RadioGroup.class));
    paramT.etSubletPhone = ((EditText)Utils.findRequiredViewAsType(paramView, 2131696692, "field 'etSubletPhone'", EditText.class));
    localView = Utils.findRequiredView(paramView, 2131696693, "field 'tvSeeExample' and method 'onViewClicked'");
    paramT.tvSeeExample = ((TextView)Utils.castView(localView, 2131696693, "field 'tvSeeExample'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.etSubletDesc = ((EditText)Utils.findRequiredViewAsType(paramView, 2131696694, "field 'etSubletDesc'", EditText.class));
    paramT.tvSubletDescNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696695, "field 'tvSubletDescNum'", TextView.class));
    paramT.cbAgreeRegulation = ((CheckBox)Utils.findRequiredViewAsType(paramView, 2131696697, "field 'cbAgreeRegulation'", CheckBox.class));
    localView = Utils.findRequiredView(paramView, 2131696698, "field 'tvRegulation' and method 'onViewClicked'");
    paramT.tvRegulation = ((TextView)Utils.castView(localView, 2131696698, "field 'tvRegulation'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131696660, "field 'verification_code' and method 'onViewClicked'");
    paramT.verification_code = ((TextView)Utils.castView(localView, 2131696660, "field 'verification_code'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.sublet_data_code_edit = ((LabeledEditText)Utils.findRequiredViewAsType(paramView, 2131696659, "field 'sublet_data_code_edit'", LabeledEditText.class));
    paramT.verivication_rl = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131696658, "field 'verivication_rl'", RelativeLayout.class));
    paramT.llAgreeRegulation = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696696, "field 'llAgreeRegulation'", LinearLayout.class));
  }
  
  public void unbind()
  {
    LeaseSubletInfomationActivity localLeaseSubletInfomationActivity = this.a;
    if (localLeaseSubletInfomationActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLeaseSubletInfomationActivity.bztb = null;
    localLeaseSubletInfomationActivity.btnOk = null;
    localLeaseSubletInfomationActivity.etSubletName = null;
    localLeaseSubletInfomationActivity.rbSubletSexWoman = null;
    localLeaseSubletInfomationActivity.rbSubletSexMan = null;
    localLeaseSubletInfomationActivity.rgSubletSex = null;
    localLeaseSubletInfomationActivity.etSubletPhone = null;
    localLeaseSubletInfomationActivity.tvSeeExample = null;
    localLeaseSubletInfomationActivity.etSubletDesc = null;
    localLeaseSubletInfomationActivity.tvSubletDescNum = null;
    localLeaseSubletInfomationActivity.cbAgreeRegulation = null;
    localLeaseSubletInfomationActivity.tvRegulation = null;
    localLeaseSubletInfomationActivity.verification_code = null;
    localLeaseSubletInfomationActivity.sublet_data_code_edit = null;
    localLeaseSubletInfomationActivity.verivication_rl = null;
    localLeaseSubletInfomationActivity.llAgreeRegulation = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.e.setOnClickListener(null);
    this.e = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/activity/LeaseSubletInfomationActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */