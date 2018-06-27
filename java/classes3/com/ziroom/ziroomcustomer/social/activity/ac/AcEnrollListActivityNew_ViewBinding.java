package com.ziroom.ziroomcustomer.social.activity.ac;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.social.view.NavigationView;

public class AcEnrollListActivityNew_ViewBinding<T extends AcEnrollListActivityNew>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public AcEnrollListActivityNew_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131689492, "field 'mIvBack' and method 'onViewClicked'");
    paramT.mIvBack = ((ImageView)Utils.castView(localView, 2131689492, "field 'mIvBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.mTvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'mTvTitle'", TextView.class));
    paramT.mRlTitle = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131689808, "field 'mRlTitle'", RelativeLayout.class));
    paramT.mNavi = ((NavigationView)Utils.findRequiredViewAsType(paramView, 2131689820, "field 'mNavi'", NavigationView.class));
  }
  
  public void unbind()
  {
    AcEnrollListActivityNew localAcEnrollListActivityNew = this.a;
    if (localAcEnrollListActivityNew == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localAcEnrollListActivityNew.mIvBack = null;
    localAcEnrollListActivityNew.mTvTitle = null;
    localAcEnrollListActivityNew.mRlTitle = null;
    localAcEnrollListActivityNew.mNavi = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/ac/AcEnrollListActivityNew_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */