package com.ziroom.ziroomcustomer.social.activity.zz;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class ZzSocialMyZiroomActivity_ViewBinding<T extends ZzSocialMyZiroomActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public ZzSocialMyZiroomActivity_ViewBinding(final T paramT, View paramView)
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
    paramT.flPhoto = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131691480, "field 'flPhoto'", FrameLayout.class));
    paramT.etRemark = ((EditText)Utils.findRequiredViewAsType(paramView, 2131690002, "field 'etRemark'", EditText.class));
    paramT.tvCurrentNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690403, "field 'tvCurrentNum'", TextView.class));
    paramT.tvMaxNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690404, "field 'tvMaxNum'", TextView.class));
    paramT.rlDescInfo = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131690402, "field 'rlDescInfo'", FrameLayout.class));
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
    paramT.vLineBottom = Utils.findRequiredView(paramView, 2131691494, "field 'vLineBottom'");
    paramT.svContent = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131690150, "field 'svContent'", ObservableScrollView.class));
  }
  
  public void unbind()
  {
    ZzSocialMyZiroomActivity localZzSocialMyZiroomActivity = this.a;
    if (localZzSocialMyZiroomActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localZzSocialMyZiroomActivity.btnBack = null;
    localZzSocialMyZiroomActivity.rlTitle = null;
    localZzSocialMyZiroomActivity.llAddPhoto = null;
    localZzSocialMyZiroomActivity.flPhoto = null;
    localZzSocialMyZiroomActivity.etRemark = null;
    localZzSocialMyZiroomActivity.tvCurrentNum = null;
    localZzSocialMyZiroomActivity.tvMaxNum = null;
    localZzSocialMyZiroomActivity.rlDescInfo = null;
    localZzSocialMyZiroomActivity.btn = null;
    localZzSocialMyZiroomActivity.vLineBottom = null;
    localZzSocialMyZiroomActivity.svContent = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/zz/ZzSocialMyZiroomActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */