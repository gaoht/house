package com.ziroom.ziroomcustomer.minsu.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class MinsuLandlordAuthInfoActivity_ViewBinding<T extends MinsuLandlordAuthInfoActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  
  public MinsuLandlordAuthInfoActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mLetName = ((EditText)Utils.findRequiredViewAsType(paramView, 2131691442, "field 'mLetName'", EditText.class));
    paramT.mLetType = ((EditText)Utils.findRequiredViewAsType(paramView, 2131691444, "field 'mLetType'", EditText.class));
    paramT.mLetCode = ((EditText)Utils.findRequiredViewAsType(paramView, 2131691445, "field 'mLetCode'", EditText.class));
    paramT.sv_content = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131690150, "field 'sv_content'", ObservableScrollView.class));
    paramT.v_divider = Utils.findRequiredView(paramView, 2131689863, "field 'v_divider'");
    paramT.ivArrow = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690724, "field 'ivArrow'", ImageView.class));
    paramT.mLlPhotoDesc = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691450, "field 'mLlPhotoDesc'", LinearLayout.class));
    paramT.mTvPhoto = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691446, "field 'mTvPhoto'", TextView.class));
    paramT.mTvPhotoUploadTip = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691451, "field 'mTvPhotoUploadTip'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131691447, "field 'mSdvFront' and method 'onViewClick'");
    paramT.mSdvFront = ((SimpleDraweeView)Utils.castView(localView, 2131691447, "field 'mSdvFront'", SimpleDraweeView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691448, "field 'mSdvBack' and method 'onViewClick'");
    paramT.mSdvBack = ((SimpleDraweeView)Utils.castView(localView, 2131691448, "field 'mSdvBack'", SimpleDraweeView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691449, "field 'mSdvHand' and method 'onViewClick'");
    paramT.mSdvHand = ((SimpleDraweeView)Utils.castView(localView, 2131691449, "field 'mSdvHand'", SimpleDraweeView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131689816, "field 'mBtnSubmit' and method 'onViewClick'");
    paramT.mBtnSubmit = ((TextView)Utils.castView(localView, 2131689816, "field 'mBtnSubmit'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691443, "method 'onViewClick'");
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131689492, "method 'onViewClick'");
    this.g = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    MinsuLandlordAuthInfoActivity localMinsuLandlordAuthInfoActivity = this.a;
    if (localMinsuLandlordAuthInfoActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuLandlordAuthInfoActivity.mLetName = null;
    localMinsuLandlordAuthInfoActivity.mLetType = null;
    localMinsuLandlordAuthInfoActivity.mLetCode = null;
    localMinsuLandlordAuthInfoActivity.sv_content = null;
    localMinsuLandlordAuthInfoActivity.v_divider = null;
    localMinsuLandlordAuthInfoActivity.ivArrow = null;
    localMinsuLandlordAuthInfoActivity.mLlPhotoDesc = null;
    localMinsuLandlordAuthInfoActivity.mTvPhoto = null;
    localMinsuLandlordAuthInfoActivity.mTvPhotoUploadTip = null;
    localMinsuLandlordAuthInfoActivity.mSdvFront = null;
    localMinsuLandlordAuthInfoActivity.mSdvBack = null;
    localMinsuLandlordAuthInfoActivity.mSdvHand = null;
    localMinsuLandlordAuthInfoActivity.mBtnSubmit = null;
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
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuLandlordAuthInfoActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */