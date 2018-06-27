package com.ziroom.ziroomcustomer.my;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class MyAppointsActivity_ViewBinding<T extends MyAppointsActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  
  public MyAppointsActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131689930, "method 'onClick'");
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131689931, "method 'onClick'");
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131689932, "method 'onClick'");
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131689933, "method 'onClick'");
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131689929, "method 'onClick'");
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
    if (this.a == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyAppointsActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */