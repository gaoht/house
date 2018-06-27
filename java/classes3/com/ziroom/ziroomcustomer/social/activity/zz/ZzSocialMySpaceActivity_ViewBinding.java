package com.ziroom.ziroomcustomer.social.activity.zz;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class ZzSocialMySpaceActivity_ViewBinding<T extends ZzSocialMySpaceActivity>
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
  
  public ZzSocialMySpaceActivity_ViewBinding(final T paramT, View paramView)
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
    localView = Utils.findRequiredView(paramView, 2131692856, "field 'tvProjectListFilter' and method 'onViewClicked'");
    paramT.tvProjectListFilter = ((TextView)Utils.castView(localView, 2131692856, "field 'tvProjectListFilter'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.rlTitle = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131689808, "field 'rlTitle'", RelativeLayout.class));
    paramT.tvName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690049, "field 'tvName'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131693070, "field 'tvEditMyself' and method 'onViewClicked'");
    paramT.tvEditMyself = ((TextView)Utils.castView(localView, 2131693070, "field 'tvEditMyself'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131693057, "field 'llAddPhoto' and method 'onViewClicked'");
    paramT.llAddPhoto = ((LinearLayout)Utils.castView(localView, 2131693057, "field 'llAddPhoto'", LinearLayout.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131693075, "field 'tvEditMyphoto' and method 'onViewClicked'");
    paramT.tvEditMyphoto = ((TextView)Utils.castView(localView, 2131693075, "field 'tvEditMyphoto'", TextView.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.flMyphoto = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131693078, "field 'flMyphoto'", FrameLayout.class));
    localView = Utils.findRequiredView(paramView, 2131693081, "field 'tvEditMyhouse' and method 'onViewClicked'");
    paramT.tvEditMyhouse = ((TextView)Utils.castView(localView, 2131693081, "field 'tvEditMyhouse'", TextView.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.viewGroup = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131693062, "field 'viewGroup'", LinearLayout.class));
    paramT.tvAge = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690052, "field 'tvAge'", TextView.class));
    paramT.tvJob = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693071, "field 'tvJob'", TextView.class));
    paramT.ivImage = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131693056, "field 'ivImage'", SimpleDraweeView.class));
    paramT.tvDes = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693072, "field 'tvDes'", TextView.class));
    paramT.tvHomeDes = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693085, "field 'tvHomeDes'", TextView.class));
    paramT.vPhoto = Utils.findRequiredView(paramView, 2131693074, "field 'vPhoto'");
    paramT.vHome = Utils.findRequiredView(paramView, 2131693080, "field 'vHome'");
    paramT.flMyhome = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131693084, "field 'flMyhome'", FrameLayout.class));
    localView = Utils.findRequiredView(paramView, 2131693077, "field 'llAddPhotoWall' and method 'onViewClicked'");
    paramT.llAddPhotoWall = ((LinearLayout)Utils.castView(localView, 2131693077, "field 'llAddPhotoWall'", LinearLayout.class));
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131693083, "field 'llAddPhotoHome' and method 'onViewClicked'");
    paramT.llAddPhotoHome = ((LinearLayout)Utils.castView(localView, 2131693083, "field 'llAddPhotoHome'", LinearLayout.class));
    this.i = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvPhotoWallNoDes = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693076, "field 'tvPhotoWallNoDes'", TextView.class));
    paramT.tvHomeNoDes = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693082, "field 'tvHomeNoDes'", TextView.class));
    paramT.llPhotoWall = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131693073, "field 'llPhotoWall'", LinearLayout.class));
    paramT.llHome = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131693079, "field 'llHome'", LinearLayout.class));
    paramT.svContent = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131690150, "field 'svContent'", ObservableScrollView.class));
    paramT.vLineBottom = Utils.findRequiredView(paramView, 2131691494, "field 'vLineBottom'");
    paramT.tvSex = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690981, "field 'tvSex'", TextView.class));
    paramT.cb = ((ConvenientBanner)Utils.findRequiredViewAsType(paramView, 2131690977, "field 'cb'", ConvenientBanner.class));
    paramT.mFlTag = ((FlowLayout)Utils.findRequiredViewAsType(paramView, 2131693067, "field 'mFlTag'", FlowLayout.class));
    paramView = Utils.findRequiredView(paramView, 2131693086, "field 'mBtChart' and method 'onViewClicked'");
    paramT.mBtChart = ((Button)Utils.castView(paramView, 2131693086, "field 'mBtChart'", Button.class));
    this.j = paramView;
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
    ZzSocialMySpaceActivity localZzSocialMySpaceActivity = this.a;
    if (localZzSocialMySpaceActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localZzSocialMySpaceActivity.btnBack = null;
    localZzSocialMySpaceActivity.tvProjectListFilter = null;
    localZzSocialMySpaceActivity.rlTitle = null;
    localZzSocialMySpaceActivity.tvName = null;
    localZzSocialMySpaceActivity.tvEditMyself = null;
    localZzSocialMySpaceActivity.llAddPhoto = null;
    localZzSocialMySpaceActivity.tvEditMyphoto = null;
    localZzSocialMySpaceActivity.flMyphoto = null;
    localZzSocialMySpaceActivity.tvEditMyhouse = null;
    localZzSocialMySpaceActivity.viewGroup = null;
    localZzSocialMySpaceActivity.tvAge = null;
    localZzSocialMySpaceActivity.tvJob = null;
    localZzSocialMySpaceActivity.ivImage = null;
    localZzSocialMySpaceActivity.tvDes = null;
    localZzSocialMySpaceActivity.tvHomeDes = null;
    localZzSocialMySpaceActivity.vPhoto = null;
    localZzSocialMySpaceActivity.vHome = null;
    localZzSocialMySpaceActivity.flMyhome = null;
    localZzSocialMySpaceActivity.llAddPhotoWall = null;
    localZzSocialMySpaceActivity.llAddPhotoHome = null;
    localZzSocialMySpaceActivity.tvPhotoWallNoDes = null;
    localZzSocialMySpaceActivity.tvHomeNoDes = null;
    localZzSocialMySpaceActivity.llPhotoWall = null;
    localZzSocialMySpaceActivity.llHome = null;
    localZzSocialMySpaceActivity.svContent = null;
    localZzSocialMySpaceActivity.vLineBottom = null;
    localZzSocialMySpaceActivity.tvSex = null;
    localZzSocialMySpaceActivity.cb = null;
    localZzSocialMySpaceActivity.mFlTag = null;
    localZzSocialMySpaceActivity.mBtChart = null;
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
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/zz/ZzSocialMySpaceActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */