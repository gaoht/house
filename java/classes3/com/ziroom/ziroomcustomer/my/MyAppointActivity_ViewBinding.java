package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class MyAppointActivity_ViewBinding<T extends MyAppointActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  
  public MyAppointActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131689492, "field 'ivBack' and method 'onClick'");
    paramT.ivBack = ((ImageView)Utils.castView(localView, 2131689492, "field 'ivBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691888, "field 'tvDel' and method 'onClick'");
    paramT.tvDel = ((TextView)Utils.castView(localView, 2131691888, "field 'tvDel'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691563, "field 'tvEdit' and method 'onClick'");
    paramT.tvEdit = ((TextView)Utils.castView(localView, 2131691563, "field 'tvEdit'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691864, "field 'tvGoing' and method 'onClick'");
    paramT.tvGoing = ((TextView)Utils.castView(localView, 2131691864, "field 'tvGoing'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691865, "field 'tvFinished' and method 'onClick'");
    paramT.tvFinished = ((TextView)Utils.castView(localView, 2131691865, "field 'tvFinished'", TextView.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.flFrag = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131691866, "field 'flFrag'", FrameLayout.class));
  }
  
  public void unbind()
  {
    MyAppointActivity localMyAppointActivity = this.a;
    if (localMyAppointActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMyAppointActivity.ivBack = null;
    localMyAppointActivity.tvDel = null;
    localMyAppointActivity.tvEdit = null;
    localMyAppointActivity.tvGoing = null;
    localMyAppointActivity.tvFinished = null;
    localMyAppointActivity.flFrag = null;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyAppointActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */