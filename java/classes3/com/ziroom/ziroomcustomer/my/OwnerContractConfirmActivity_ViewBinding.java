package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class OwnerContractConfirmActivity_ViewBinding<T extends OwnerContractConfirmActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  
  public OwnerContractConfirmActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.llContentContainer = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690608, "field 'llContentContainer'", LinearLayout.class));
    paramT.stubError = ((ViewStub)Utils.findRequiredViewAsType(paramView, 2131690620, "field 'stubError'", ViewStub.class));
    View localView = Utils.findRequiredView(paramView, 2131689492, "field 'ivBack' and method 'onViewClicked'");
    paramT.ivBack = ((ImageView)Utils.castView(localView, 2131689492, "field 'ivBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691990, "field 'tvContactKeeper' and method 'onViewClicked'");
    paramT.tvContactKeeper = ((TextView)Utils.castView(localView, 2131691990, "field 'tvContactKeeper'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvTopTips = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691991, "field 'tvTopTips'", TextView.class));
    paramT.ivConfirmStep1 = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131691993, "field 'ivConfirmStep1'", ImageView.class));
    paramT.ivConfirmStep2 = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131691995, "field 'ivConfirmStep2'", ImageView.class));
    paramT.ivConfirmStep3 = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131691997, "field 'ivConfirmStep3'", ImageView.class));
    localView = Utils.findRequiredView(paramView, 2131691994, "field 'tvConfirmStep1' and method 'onViewClicked'");
    paramT.tvConfirmStep1 = ((TextView)Utils.castView(localView, 2131691994, "field 'tvConfirmStep1'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691996, "field 'tvConfirmStep2' and method 'onViewClicked'");
    paramT.tvConfirmStep2 = ((TextView)Utils.castView(localView, 2131691996, "field 'tvConfirmStep2'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691998, "field 'tvConfirmStep3' and method 'onViewClicked'");
    paramT.tvConfirmStep3 = ((TextView)Utils.castView(localView, 2131691998, "field 'tvConfirmStep3'", TextView.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.flFrag = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131691866, "field 'flFrag'", FrameLayout.class));
    paramT.viewLine = Utils.findRequiredView(paramView, 2131690678, "field 'viewLine'");
    paramT.llConfirmStep1 = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691992, "field 'llConfirmStep1'", LinearLayout.class));
    paramView = Utils.findRequiredView(paramView, 2131691101, "field 'btnBottom' and method 'onViewClicked'");
    paramT.btnBottom = ((Button)Utils.castView(paramView, 2131691101, "field 'btnBottom'", Button.class));
    this.g = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    OwnerContractConfirmActivity localOwnerContractConfirmActivity = this.a;
    if (localOwnerContractConfirmActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localOwnerContractConfirmActivity.llContentContainer = null;
    localOwnerContractConfirmActivity.stubError = null;
    localOwnerContractConfirmActivity.ivBack = null;
    localOwnerContractConfirmActivity.tvContactKeeper = null;
    localOwnerContractConfirmActivity.tvTopTips = null;
    localOwnerContractConfirmActivity.ivConfirmStep1 = null;
    localOwnerContractConfirmActivity.ivConfirmStep2 = null;
    localOwnerContractConfirmActivity.ivConfirmStep3 = null;
    localOwnerContractConfirmActivity.tvConfirmStep1 = null;
    localOwnerContractConfirmActivity.tvConfirmStep2 = null;
    localOwnerContractConfirmActivity.tvConfirmStep3 = null;
    localOwnerContractConfirmActivity.flFrag = null;
    localOwnerContractConfirmActivity.viewLine = null;
    localOwnerContractConfirmActivity.llConfirmStep1 = null;
    localOwnerContractConfirmActivity.btnBottom = null;
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
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerContractConfirmActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */