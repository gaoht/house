package com.ziroom.ziroomcustomer.social.activity.zz;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class ZzSocialBaseMessageActivity_ViewBinding<T extends ZzSocialBaseMessageActivity>
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
  
  public ZzSocialBaseMessageActivity_ViewBinding(final T paramT, View paramView)
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
    paramT.etSex = ((EditText)Utils.findRequiredViewAsType(paramView, 2131693059, "field 'etSex'", EditText.class));
    paramT.etTime = ((EditText)Utils.findRequiredViewAsType(paramView, 2131693060, "field 'etTime'", EditText.class));
    paramT.tvCompany = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693058, "field 'tvCompany'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131690635, "field 'llCompany' and method 'onViewClicked'");
    paramT.llCompany = ((LinearLayout)Utils.castView(localView, 2131690635, "field 'llCompany'", LinearLayout.class));
    this.d = localView;
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
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690043, "field 'btn' and method 'onViewClicked'");
    paramT.btn = ((Button)Utils.castView(localView, 2131690043, "field 'btn'", Button.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131693056, "field 'ivImage' and method 'onViewClicked'");
    paramT.ivImage = ((SimpleDraweeView)Utils.castView(localView, 2131693056, "field 'ivImage'", SimpleDraweeView.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvAddress = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690053, "field 'tvAddress'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131692247, "field 'llAddress' and method 'onViewClicked'");
    paramT.llAddress = ((LinearLayout)Utils.castView(localView, 2131692247, "field 'llAddress'", LinearLayout.class));
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvQuanzi = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693061, "field 'tvQuanzi'", TextView.class));
    paramT.vLineBottom = Utils.findRequiredView(paramView, 2131691494, "field 'vLineBottom'");
    paramT.svContent = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131690150, "field 'svContent'", ObservableScrollView.class));
  }
  
  public void unbind()
  {
    ZzSocialBaseMessageActivity localZzSocialBaseMessageActivity = this.a;
    if (localZzSocialBaseMessageActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localZzSocialBaseMessageActivity.btnBack = null;
    localZzSocialBaseMessageActivity.rlTitle = null;
    localZzSocialBaseMessageActivity.llAddPhoto = null;
    localZzSocialBaseMessageActivity.etName = null;
    localZzSocialBaseMessageActivity.etSex = null;
    localZzSocialBaseMessageActivity.etTime = null;
    localZzSocialBaseMessageActivity.tvCompany = null;
    localZzSocialBaseMessageActivity.llCompany = null;
    localZzSocialBaseMessageActivity.tvType = null;
    localZzSocialBaseMessageActivity.llType = null;
    localZzSocialBaseMessageActivity.btn = null;
    localZzSocialBaseMessageActivity.ivImage = null;
    localZzSocialBaseMessageActivity.tvAddress = null;
    localZzSocialBaseMessageActivity.llAddress = null;
    localZzSocialBaseMessageActivity.tvQuanzi = null;
    localZzSocialBaseMessageActivity.vLineBottom = null;
    localZzSocialBaseMessageActivity.svContent = null;
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
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/zz/ZzSocialBaseMessageActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */