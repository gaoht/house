package com.ziroom.ziroomcustomer.sharedlife.activity;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.gesturelock.view.GestureLockMiniView;
import com.ziroom.ziroomcustomer.gesturelock.view.GestureLockViewGroup;

public class SharedLifeGestureLockActivity_ViewBinding<T extends SharedLifeGestureLockActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public SharedLifeGestureLockActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.gestureLockViewGroup = ((GestureLockViewGroup)Utils.findRequiredViewAsType(paramView, 2131690686, "field 'gestureLockViewGroup'", GestureLockViewGroup.class));
    paramT.gestureLockPathView = ((GestureLockMiniView)Utils.findRequiredViewAsType(paramView, 2131690683, "field 'gestureLockPathView'", GestureLockMiniView.class));
    View localView = Utils.findRequiredView(paramView, 2131690687, "field 'tv_forgotten' and method 'onClick'");
    paramT.tv_forgotten = ((TextView)Utils.castView(localView, 2131690687, "field 'tv_forgotten'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.tv_errorView = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690685, "field 'tv_errorView'", TextView.class));
    paramT.tv_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695949, "field 'tv_title'", TextView.class));
    paramT.tv_rightButton = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695950, "field 'tv_rightButton'", TextView.class));
    paramT.sdv_userIcon = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131690684, "field 'sdv_userIcon'", SimpleDraweeView.class));
    paramT.rl_container = Utils.findRequiredView(paramView, 2131690682, "field 'rl_container'");
    paramView = Utils.findRequiredView(paramView, 2131695948, "method 'onClick'");
    this.c = paramView;
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
    SharedLifeGestureLockActivity localSharedLifeGestureLockActivity = this.a;
    if (localSharedLifeGestureLockActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localSharedLifeGestureLockActivity.gestureLockViewGroup = null;
    localSharedLifeGestureLockActivity.gestureLockPathView = null;
    localSharedLifeGestureLockActivity.tv_forgotten = null;
    localSharedLifeGestureLockActivity.tv_errorView = null;
    localSharedLifeGestureLockActivity.tv_title = null;
    localSharedLifeGestureLockActivity.tv_rightButton = null;
    localSharedLifeGestureLockActivity.sdv_userIcon = null;
    localSharedLifeGestureLockActivity.rl_container = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sharedlife/activity/SharedLifeGestureLockActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */