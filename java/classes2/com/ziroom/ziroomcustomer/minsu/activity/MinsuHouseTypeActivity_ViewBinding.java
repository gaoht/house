package com.ziroom.ziroomcustomer.minsu.activity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;

public class MinsuHouseTypeActivity_ViewBinding<T extends MinsuHouseTypeActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  
  public MinsuHouseTypeActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.commonTitle = ((CommonTitle)Utils.findRequiredViewAsType(paramView, 2131691272, "field 'commonTitle'", CommonTitle.class));
    View localView = Utils.findRequiredView(paramView, 2131691422, "field 'cbHouse' and method 'onChecked'");
    paramT.cbHouse = ((CheckBox)Utils.castView(localView, 2131691422, "field 'cbHouse'", CheckBox.class));
    this.b = localView;
    ((CompoundButton)localView).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      @Instrumented
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
        paramT.onChecked(paramAnonymousCompoundButton, paramAnonymousBoolean);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691420, "field 'rlHouse' and method 'onClick'");
    paramT.rlHouse = ((RelativeLayout)Utils.castView(localView, 2131691420, "field 'rlHouse'", RelativeLayout.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691425, "field 'cbRoom' and method 'onChecked'");
    paramT.cbRoom = ((CheckBox)Utils.castView(localView, 2131691425, "field 'cbRoom'", CheckBox.class));
    this.d = localView;
    ((CompoundButton)localView).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      @Instrumented
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
        paramT.onChecked(paramAnonymousCompoundButton, paramAnonymousBoolean);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691423, "field 'rlRoom' and method 'onClick'");
    paramT.rlRoom = ((RelativeLayout)Utils.castView(localView, 2131691423, "field 'rlRoom'", RelativeLayout.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131690953, "field 'tvSave' and method 'onClick'");
    paramT.tvSave = ((TextView)Utils.castView(paramView, 2131690953, "field 'tvSave'", TextView.class));
    this.f = paramView;
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
    MinsuHouseTypeActivity localMinsuHouseTypeActivity = this.a;
    if (localMinsuHouseTypeActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuHouseTypeActivity.commonTitle = null;
    localMinsuHouseTypeActivity.cbHouse = null;
    localMinsuHouseTypeActivity.rlHouse = null;
    localMinsuHouseTypeActivity.cbRoom = null;
    localMinsuHouseTypeActivity.rlRoom = null;
    localMinsuHouseTypeActivity.tvSave = null;
    ((CompoundButton)this.b).setOnCheckedChangeListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    ((CompoundButton)this.d).setOnCheckedChangeListener(null);
    this.d = null;
    this.e.setOnClickListener(null);
    this.e = null;
    this.f.setOnClickListener(null);
    this.f = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuHouseTypeActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */