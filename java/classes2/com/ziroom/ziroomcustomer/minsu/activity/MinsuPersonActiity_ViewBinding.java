package com.ziroom.ziroomcustomer.minsu.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;

public class MinsuPersonActiity_ViewBinding<T extends MinsuPersonActiity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  
  public MinsuPersonActiity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.commonTitle = ((CommonTitle)Utils.findRequiredViewAsType(paramView, 2131691272, "field 'commonTitle'", CommonTitle.class));
    View localView = Utils.findRequiredView(paramView, 2131691634, "field 'reduce' and method 'onClick'");
    paramT.reduce = ((ImageView)Utils.castView(localView, 2131691634, "field 'reduce'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.tvPersonNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691635, "field 'tvPersonNum'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131689574, "field 'add' and method 'onClick'");
    paramT.add = ((ImageView)Utils.castView(localView, 2131689574, "field 'add'", ImageView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690953, "field 'tvSave' and method 'onClick'");
    paramT.tvSave = ((TextView)Utils.castView(localView, 2131690953, "field 'tvSave'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691637, "field 'tvResetMap' and method 'onClick'");
    paramT.tvResetMap = ((TextView)Utils.castView(localView, 2131691637, "field 'tvResetMap'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691638, "field 'tvSearchMap' and method 'onClick'");
    paramT.tvSearchMap = ((TextView)Utils.castView(localView, 2131691638, "field 'tvSearchMap'", TextView.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.llMapBottom = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691636, "field 'llMapBottom'", LinearLayout.class));
  }
  
  public void unbind()
  {
    MinsuPersonActiity localMinsuPersonActiity = this.a;
    if (localMinsuPersonActiity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuPersonActiity.commonTitle = null;
    localMinsuPersonActiity.reduce = null;
    localMinsuPersonActiity.tvPersonNum = null;
    localMinsuPersonActiity.add = null;
    localMinsuPersonActiity.tvSave = null;
    localMinsuPersonActiity.tvResetMap = null;
    localMinsuPersonActiity.tvSearchMap = null;
    localMinsuPersonActiity.llMapBottom = null;
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
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuPersonActiity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */