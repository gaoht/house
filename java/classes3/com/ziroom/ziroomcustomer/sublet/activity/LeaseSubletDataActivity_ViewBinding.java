package com.ziroom.ziroomcustomer.sublet.activity;

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
import com.ziroom.ziroomcustomer.widget.LabeledEditText;

public class LeaseSubletDataActivity_ViewBinding<T extends LeaseSubletDataActivity>
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
  
  public LeaseSubletDataActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mBztb = ((BasicZiroomToolBar)Utils.findRequiredViewAsType(paramView, 2131689787, "field 'mBztb'", BasicZiroomToolBar.class));
    paramT.sublet_data_phone_edit = ((LabeledEditText)Utils.findRequiredViewAsType(paramView, 2131696657, "field 'sublet_data_phone_edit'", LabeledEditText.class));
    paramT.sublet_data_code_edit = ((LabeledEditText)Utils.findRequiredViewAsType(paramView, 2131696659, "field 'sublet_data_code_edit'", LabeledEditText.class));
    paramT.sublet_data_time_edit = ((LabeledEditText)Utils.findRequiredViewAsType(paramView, 2131696652, "field 'sublet_data_time_edit'", LabeledEditText.class));
    paramT.sublet_data_name_edit = ((LabeledEditText)Utils.findRequiredViewAsType(paramView, 2131696656, "field 'sublet_data_name_edit'", LabeledEditText.class));
    View localView = Utils.findRequiredView(paramView, 2131696660, "field 'verification_code' and method 'onClic'");
    paramT.verification_code = ((TextView)Utils.castView(localView, 2131696660, "field 'verification_code'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramT.verivication_rl = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131696658, "field 'verivication_rl'", RelativeLayout.class));
    paramT.lease_sublet_data_check = ((CheckBox)Utils.findRequiredViewAsType(paramView, 2131696661, "field 'lease_sublet_data_check'", CheckBox.class));
    localView = Utils.findRequiredView(paramView, 2131696663, "field 'lease_sublet_data_btn' and method 'onClic'");
    paramT.lease_sublet_data_btn = ((Button)Utils.castView(localView, 2131696663, "field 'lease_sublet_data_btn'", Button.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramT.lease_sublet_data_prompt = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131696664, "field 'lease_sublet_data_prompt'", ImageView.class));
    paramT.lease_sublet_data_time_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696653, "field 'lease_sublet_data_time_ll'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131696654, "field 'lease_sublet_data_price' and method 'onClic'");
    paramT.lease_sublet_data_price = ((TextView)Utils.castView(localView, 2131696654, "field 'lease_sublet_data_price'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramT.lease_sublet_data_time = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696655, "field 'lease_sublet_data_time'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131696662, "field 'lease_sublet_data_html' and method 'onClic'");
    paramT.lease_sublet_data_html = ((TextView)Utils.castView(localView, 2131696662, "field 'lease_sublet_data_html'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramT.sublet_data_house_text_et = ((EditText)Utils.findRequiredViewAsType(paramView, 2131696648, "field 'sublet_data_house_text_et'", EditText.class));
    paramT.sublet_data_house_text_size = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696649, "field 'sublet_data_house_text_size'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131696650, "field 'sublet_data_sample' and method 'onClic'");
    paramT.sublet_data_sample = ((TextView)Utils.castView(localView, 2131696650, "field 'sublet_data_sample'", TextView.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131696651, "method 'onClic'");
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131696665, "method 'onClic'");
    this.h = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    LeaseSubletDataActivity localLeaseSubletDataActivity = this.a;
    if (localLeaseSubletDataActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLeaseSubletDataActivity.mBztb = null;
    localLeaseSubletDataActivity.sublet_data_phone_edit = null;
    localLeaseSubletDataActivity.sublet_data_code_edit = null;
    localLeaseSubletDataActivity.sublet_data_time_edit = null;
    localLeaseSubletDataActivity.sublet_data_name_edit = null;
    localLeaseSubletDataActivity.verification_code = null;
    localLeaseSubletDataActivity.verivication_rl = null;
    localLeaseSubletDataActivity.lease_sublet_data_check = null;
    localLeaseSubletDataActivity.lease_sublet_data_btn = null;
    localLeaseSubletDataActivity.lease_sublet_data_prompt = null;
    localLeaseSubletDataActivity.lease_sublet_data_time_ll = null;
    localLeaseSubletDataActivity.lease_sublet_data_price = null;
    localLeaseSubletDataActivity.lease_sublet_data_time = null;
    localLeaseSubletDataActivity.lease_sublet_data_html = null;
    localLeaseSubletDataActivity.sublet_data_house_text_et = null;
    localLeaseSubletDataActivity.sublet_data_house_text_size = null;
    localLeaseSubletDataActivity.sublet_data_sample = null;
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
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/activity/LeaseSubletDataActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */