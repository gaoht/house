package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;

public class MyCollectionsActivity_ViewBinding<T extends MyCollectionsActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public MyCollectionsActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mBztb = ((BasicZiroomToolBar)Utils.findRequiredViewAsType(paramView, 2131689787, "field 'mBztb'", BasicZiroomToolBar.class));
    paramT.mFrameContent = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131691891, "field 'mFrameContent'", FrameLayout.class));
    View localView = Utils.findRequiredView(paramView, 2131691889, "field 'mTvHz' and method 'onViewClicked'");
    paramT.mTvHz = ((TextView)Utils.castView(localView, 2131691889, "field 'mTvHz'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131691890, "field 'mTvMinsu' and method 'onViewClicked'");
    paramT.mTvMinsu = ((TextView)Utils.castView(paramView, 2131691890, "field 'mTvMinsu'", TextView.class));
    this.c = paramView;
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
    MyCollectionsActivity localMyCollectionsActivity = this.a;
    if (localMyCollectionsActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMyCollectionsActivity.mBztb = null;
    localMyCollectionsActivity.mFrameContent = null;
    localMyCollectionsActivity.mTvHz = null;
    localMyCollectionsActivity.mTvMinsu = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyCollectionsActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */