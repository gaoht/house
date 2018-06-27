package com.ziroom.ziroomcustomer.my.selfsetting;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

public class SelfSettingActivity_ViewBinding<T extends SelfSettingActivity>
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
  private View k;
  
  public SelfSettingActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131689895, "field 'tvBack' and method 'onViewClicked'");
    paramT.tvBack = ((ImageView)Utils.castView(localView, 2131689895, "field 'tvBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvNickname = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691304, "field 'tvNickname'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131691841, "field 'llNickname' and method 'onViewClicked'");
    paramT.llNickname = ((LinearLayout)Utils.castView(localView, 2131691841, "field 'llNickname'", LinearLayout.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.sdvAvatar = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131690070, "field 'sdvAvatar'", SimpleDraweeView.class));
    localView = Utils.findRequiredView(paramView, 2131691842, "field 'llAvatar' and method 'onViewClicked'");
    paramT.llAvatar = ((LinearLayout)Utils.castView(localView, 2131691842, "field 'llAvatar'", LinearLayout.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691843, "field 'llCard' and method 'onViewClicked'");
    paramT.llCard = ((LinearLayout)Utils.castView(localView, 2131691843, "field 'llCard'", LinearLayout.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691844, "field 'llCredentials' and method 'onViewClicked'");
    paramT.llCredentials = ((LinearLayout)Utils.castView(localView, 2131691844, "field 'llCredentials'", LinearLayout.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691845, "field 'llEducation' and method 'onViewClicked'");
    paramT.llEducation = ((LinearLayout)Utils.castView(localView, 2131691845, "field 'llEducation'", LinearLayout.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691846, "field 'llAccount' and method 'onViewClicked'");
    paramT.llAccount = ((LinearLayout)Utils.castView(localView, 2131691846, "field 'llAccount'", LinearLayout.class));
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691847, "field 'llAbout' and method 'onViewClicked'");
    paramT.llAbout = ((LinearLayout)Utils.castView(localView, 2131691847, "field 'llAbout'", LinearLayout.class));
    this.i = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvDelete = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691849, "field 'tvDelete'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131691848, "field 'llDelete' and method 'onViewClicked'");
    paramT.llDelete = ((LinearLayout)Utils.castView(localView, 2131691848, "field 'llDelete'", LinearLayout.class));
    this.j = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131691850, "field 'btnLogout' and method 'onViewClicked'");
    paramT.btnLogout = ((Button)Utils.castView(paramView, 2131691850, "field 'btnLogout'", Button.class));
    this.k = paramView;
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
    SelfSettingActivity localSelfSettingActivity = this.a;
    if (localSelfSettingActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localSelfSettingActivity.tvBack = null;
    localSelfSettingActivity.tvNickname = null;
    localSelfSettingActivity.llNickname = null;
    localSelfSettingActivity.sdvAvatar = null;
    localSelfSettingActivity.llAvatar = null;
    localSelfSettingActivity.llCard = null;
    localSelfSettingActivity.llCredentials = null;
    localSelfSettingActivity.llEducation = null;
    localSelfSettingActivity.llAccount = null;
    localSelfSettingActivity.llAbout = null;
    localSelfSettingActivity.tvDelete = null;
    localSelfSettingActivity.llDelete = null;
    localSelfSettingActivity.btnLogout = null;
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
    this.k.setOnClickListener(null);
    this.k = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/selfsetting/SelfSettingActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */