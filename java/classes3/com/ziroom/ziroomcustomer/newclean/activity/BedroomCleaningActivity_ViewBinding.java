package com.ziroom.ziroomcustomer.newclean.activity;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;

public class BedroomCleaningActivity_ViewBinding<T extends BedroomCleaningActivity>
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
  private View j;
  
  public BedroomCleaningActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131690373, "field 'mLetAddress' and method 'onClick'");
    paramT.mLetAddress = ((LabeledEditText)Utils.castView(localView, 2131690373, "field 'mLetAddress'", LabeledEditText.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690388, "field 'mLetTime' and method 'onClick'");
    paramT.mLetTime = ((LabeledEditText)Utils.castView(localView, 2131690388, "field 'mLetTime'", LabeledEditText.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.mLlSelectCleaner = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690389, "field 'mLlSelectCleaner'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131690363, "field 'mletCleaner' and method 'onClick'");
    paramT.mletCleaner = ((LabeledEditText)Utils.castView(localView, 2131690363, "field 'mletCleaner'", LabeledEditText.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690390, "field 'mLetCoupon' and method 'onClick'");
    paramT.mLetCoupon = ((LabeledEditText)Utils.castView(localView, 2131690390, "field 'mLetCoupon'", LabeledEditText.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690391, "field 'mLetSpecial' and method 'onClick'");
    paramT.mLetSpecial = ((LabeledEditText)Utils.castView(localView, 2131690391, "field 'mLetSpecial'", LabeledEditText.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.mTvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'mTvTitle'", TextView.class));
    paramT.mTvAllPrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689841, "field 'mTvAllPrice'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131689843, "field 'mBtnCommit' and method 'onClick'");
    paramT.mBtnCommit = ((Button)Utils.castView(localView, 2131689843, "field 'mBtnCommit'", Button.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131689492, "method 'onClick'");
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690023, "method 'onClick'");
    this.i = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131689839, "method 'onClick'");
    this.j = paramView;
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
    BedroomCleaningActivity localBedroomCleaningActivity = this.a;
    if (localBedroomCleaningActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localBedroomCleaningActivity.mLetAddress = null;
    localBedroomCleaningActivity.mLetTime = null;
    localBedroomCleaningActivity.mLlSelectCleaner = null;
    localBedroomCleaningActivity.mletCleaner = null;
    localBedroomCleaningActivity.mLetCoupon = null;
    localBedroomCleaningActivity.mLetSpecial = null;
    localBedroomCleaningActivity.mTvTitle = null;
    localBedroomCleaningActivity.mTvAllPrice = null;
    localBedroomCleaningActivity.mBtnCommit = null;
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
    this.j.setOnClickListener(null);
    this.j = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/BedroomCleaningActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */