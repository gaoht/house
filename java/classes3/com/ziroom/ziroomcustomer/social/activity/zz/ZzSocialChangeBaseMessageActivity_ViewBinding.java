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
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class ZzSocialChangeBaseMessageActivity_ViewBinding<T extends ZzSocialChangeBaseMessageActivity>
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
  
  public ZzSocialChangeBaseMessageActivity_ViewBinding(final T paramT, View paramView)
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
    paramT.etName = ((EditText)Utils.findRequiredViewAsType(paramView, 2131689810, "field 'etName'", EditText.class));
    paramT.tvAddress = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690053, "field 'tvAddress'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131692247, "field 'llAddress' and method 'onViewClicked'");
    paramT.llAddress = ((LinearLayout)Utils.castView(localView, 2131692247, "field 'llAddress'", LinearLayout.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvCompany = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693058, "field 'tvCompany'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131690635, "field 'llCompany' and method 'onViewClicked'");
    paramT.llCompany = ((LinearLayout)Utils.castView(localView, 2131690635, "field 'llCompany'", LinearLayout.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvType = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689848, "field 'tvType'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131689847, "field 'llType' and method 'onViewClicked'");
    paramT.llType = ((LinearLayout)Utils.castView(localView, 2131689847, "field 'llType'", LinearLayout.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.etRemark = ((EditText)Utils.findRequiredViewAsType(paramView, 2131690002, "field 'etRemark'", EditText.class));
    paramT.tvCurrentNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690403, "field 'tvCurrentNum'", TextView.class));
    paramT.tvMaxNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690404, "field 'tvMaxNum'", TextView.class));
    paramT.rlDescInfo = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131690402, "field 'rlDescInfo'", FrameLayout.class));
    localView = Utils.findRequiredView(paramView, 2131690043, "field 'btn' and method 'onViewClicked'");
    paramT.btn = ((Button)Utils.castView(localView, 2131690043, "field 'btn'", Button.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131693056, "field 'ivImage' and method 'onViewClicked'");
    paramT.ivImage = ((SimpleDraweeView)Utils.castView(localView, 2131693056, "field 'ivImage'", SimpleDraweeView.class));
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    paramT.vLineBottom = Utils.findRequiredView(paramView, 2131691494, "field 'vLineBottom'");
    paramT.svContent = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131690150, "field 'svContent'", ObservableScrollView.class));
    localView = Utils.findRequiredView(paramView, 2131693064, "field 'tvReset' and method 'onViewClicked'");
    paramT.tvReset = ((TextView)Utils.castView(localView, 2131693064, "field 'tvReset'", TextView.class));
    this.i = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.ivReset = Utils.findRequiredView(paramView, 2131693063, "field 'ivReset'");
    paramT.mFlTag = ((FlowLayout)Utils.findRequiredViewAsType(paramView, 2131693067, "field 'mFlTag'", FlowLayout.class));
    paramT.mTvTagDesc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693066, "field 'mTvTagDesc'", TextView.class));
    paramT.mViewAdd = Utils.findRequiredView(paramView, 2131690279, "field 'mViewAdd'");
    paramView = Utils.findRequiredView(paramView, 2131693065, "method 'onViewClicked'");
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
    ZzSocialChangeBaseMessageActivity localZzSocialChangeBaseMessageActivity = this.a;
    if (localZzSocialChangeBaseMessageActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localZzSocialChangeBaseMessageActivity.btnBack = null;
    localZzSocialChangeBaseMessageActivity.rlTitle = null;
    localZzSocialChangeBaseMessageActivity.llAddPhoto = null;
    localZzSocialChangeBaseMessageActivity.etName = null;
    localZzSocialChangeBaseMessageActivity.tvAddress = null;
    localZzSocialChangeBaseMessageActivity.llAddress = null;
    localZzSocialChangeBaseMessageActivity.tvCompany = null;
    localZzSocialChangeBaseMessageActivity.llCompany = null;
    localZzSocialChangeBaseMessageActivity.tvType = null;
    localZzSocialChangeBaseMessageActivity.llType = null;
    localZzSocialChangeBaseMessageActivity.etRemark = null;
    localZzSocialChangeBaseMessageActivity.tvCurrentNum = null;
    localZzSocialChangeBaseMessageActivity.tvMaxNum = null;
    localZzSocialChangeBaseMessageActivity.rlDescInfo = null;
    localZzSocialChangeBaseMessageActivity.btn = null;
    localZzSocialChangeBaseMessageActivity.ivImage = null;
    localZzSocialChangeBaseMessageActivity.tvTitle = null;
    localZzSocialChangeBaseMessageActivity.vLineBottom = null;
    localZzSocialChangeBaseMessageActivity.svContent = null;
    localZzSocialChangeBaseMessageActivity.tvReset = null;
    localZzSocialChangeBaseMessageActivity.ivReset = null;
    localZzSocialChangeBaseMessageActivity.mFlTag = null;
    localZzSocialChangeBaseMessageActivity.mTvTagDesc = null;
    localZzSocialChangeBaseMessageActivity.mViewAdd = null;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/zz/ZzSocialChangeBaseMessageActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */