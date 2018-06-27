package com.ziroom.ziroomcustomer.social.activity.zz;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class ZzSocialMyPhotosActivity_ViewBinding<T extends ZzSocialMyPhotosActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public ZzSocialMyPhotosActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131690078, "field 'btnBack' and method 'onViewClicked'");
    paramT.btnBack = ((ImageView)Utils.castView(localView, 2131690078, "field 'btnBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.rlTitle = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131689808, "field 'rlTitle'", RelativeLayout.class));
    localView = Utils.findRequiredView(paramView, 2131693057, "field 'llAddPhoto' and method 'onViewClicked'");
    paramT.llAddPhoto = ((LinearLayout)Utils.castView(localView, 2131693057, "field 'llAddPhoto'", LinearLayout.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690043, "field 'btn' and method 'onViewClicked'");
    paramT.btn = ((Button)Utils.castView(localView, 2131690043, "field 'btn'", Button.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.flPhoto = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131691480, "field 'flPhoto'", FrameLayout.class));
    paramT.vLineBottom = Utils.findRequiredView(paramView, 2131691494, "field 'vLineBottom'");
    paramT.svContent = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131690150, "field 'svContent'", ObservableScrollView.class));
  }
  
  public void unbind()
  {
    ZzSocialMyPhotosActivity localZzSocialMyPhotosActivity = this.a;
    if (localZzSocialMyPhotosActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localZzSocialMyPhotosActivity.btnBack = null;
    localZzSocialMyPhotosActivity.rlTitle = null;
    localZzSocialMyPhotosActivity.llAddPhoto = null;
    localZzSocialMyPhotosActivity.btn = null;
    localZzSocialMyPhotosActivity.flPhoto = null;
    localZzSocialMyPhotosActivity.vLineBottom = null;
    localZzSocialMyPhotosActivity.svContent = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/zz/ZzSocialMyPhotosActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */