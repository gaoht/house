package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class MyAboutActivity_ViewBinding<T extends MyAboutActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public MyAboutActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mTvVersion = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691818, "field 'mTvVersion'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131690693, "method 'onViewClick'");
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691819, "method 'onViewClick'");
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131689895, "method 'onViewClick'");
    this.d = paramView;
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
    MyAboutActivity localMyAboutActivity = this.a;
    if (localMyAboutActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMyAboutActivity.mTvVersion = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyAboutActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */