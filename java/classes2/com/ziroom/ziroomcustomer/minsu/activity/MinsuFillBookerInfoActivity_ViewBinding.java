package com.ziroom.ziroomcustomer.minsu.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class MinsuFillBookerInfoActivity_ViewBinding<T extends MinsuFillBookerInfoActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public MinsuFillBookerInfoActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.sv_content = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131690150, "field 'sv_content'", ObservableScrollView.class));
    paramT.customer_name = ((EditText)Utils.findRequiredViewAsType(paramView, 2131691280, "field 'customer_name'", EditText.class));
    paramT.customer_phone = ((EditText)Utils.findRequiredViewAsType(paramView, 2131691298, "field 'customer_phone'", EditText.class));
    View localView = Utils.findRequiredView(paramView, 2131691200, "field 'get_auth_code' and method 'onClick'");
    paramT.get_auth_code = ((TextView)Utils.castView(localView, 2131691200, "field 'get_auth_code'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.customer_code = ((EditText)Utils.findRequiredViewAsType(paramView, 2131691299, "field 'customer_code'", EditText.class));
    paramT.customer_cer_type = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691281, "field 'customer_cer_type'", TextView.class));
    paramT.customer_cer_value = ((EditText)Utils.findRequiredViewAsType(paramView, 2131691282, "field 'customer_cer_value'", EditText.class));
    localView = Utils.findRequiredView(paramView, 2131691206, "field 'commit' and method 'onClick'");
    paramT.commit = ((TextView)Utils.castView(localView, 2131691206, "field 'commit'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.phone_code_area = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691297, "field 'phone_code_area'", LinearLayout.class));
    paramView = Utils.findRequiredView(paramView, 2131691204, "field 'cer_type_area' and method 'onClick'");
    paramT.cer_type_area = ((LinearLayout)Utils.castView(paramView, 2131691204, "field 'cer_type_area'", LinearLayout.class));
    this.d = paramView;
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
    MinsuFillBookerInfoActivity localMinsuFillBookerInfoActivity = this.a;
    if (localMinsuFillBookerInfoActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuFillBookerInfoActivity.sv_content = null;
    localMinsuFillBookerInfoActivity.customer_name = null;
    localMinsuFillBookerInfoActivity.customer_phone = null;
    localMinsuFillBookerInfoActivity.get_auth_code = null;
    localMinsuFillBookerInfoActivity.customer_code = null;
    localMinsuFillBookerInfoActivity.customer_cer_type = null;
    localMinsuFillBookerInfoActivity.customer_cer_value = null;
    localMinsuFillBookerInfoActivity.commit = null;
    localMinsuFillBookerInfoActivity.phone_code_area = null;
    localMinsuFillBookerInfoActivity.cer_type_area = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuFillBookerInfoActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */