package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;

public class MyCardsActivity_ViewBinding<T extends MyCardsActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  
  public MyCardsActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mBztb = ((BasicZiroomToolBar)Utils.findRequiredViewAsType(paramView, 2131689787, "field 'mBztb'", BasicZiroomToolBar.class));
    View localView = Utils.findRequiredView(paramView, 2131690091, "field 'tv_call' and method 'onClick'");
    paramT.tv_call = ((TextView)Utils.castView(localView, 2131690091, "field 'tv_call'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690088, "method 'onClick'");
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690090, "method 'onClick'");
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131690089, "method 'onClick'");
    this.e = paramView;
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
    MyCardsActivity localMyCardsActivity = this.a;
    if (localMyCardsActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMyCardsActivity.mBztb = null;
    localMyCardsActivity.tv_call = null;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyCardsActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */