package com.ziroom.ziroomcustomer.sublet.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.sublet.widget.LuxuryHouseShareView;
import com.ziroom.ziroomcustomer.sublet.widget.SubletHouseShareView;

public class SubletHouseShareActivity_ViewBinding<T extends SubletHouseShareActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public SubletHouseShareActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131692590, "field 'mTvSavePic' and method 'onViewClicked'");
    paramT.mTvSavePic = ((TextView)Utils.castView(localView, 2131692590, "field 'mTvSavePic'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131689826, "field 'mTvShare' and method 'onViewClicked'");
    paramT.mTvShare = ((TextView)Utils.castView(localView, 2131689826, "field 'mTvShare'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.mSubletShareView = ((SubletHouseShareView)Utils.findRequiredViewAsType(paramView, 2131692588, "field 'mSubletShareView'", SubletHouseShareView.class));
    localView = Utils.findRequiredView(paramView, 2131689492, "field 'mIvBack' and method 'onViewClicked'");
    paramT.mIvBack = ((ImageView)Utils.castView(localView, 2131689492, "field 'mIvBack'", ImageView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.luxuryShareView = ((LuxuryHouseShareView)Utils.findRequiredViewAsType(paramView, 2131692589, "field 'luxuryShareView'", LuxuryHouseShareView.class));
  }
  
  public void unbind()
  {
    SubletHouseShareActivity localSubletHouseShareActivity = this.a;
    if (localSubletHouseShareActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localSubletHouseShareActivity.mTvSavePic = null;
    localSubletHouseShareActivity.mTvShare = null;
    localSubletHouseShareActivity.mSubletShareView = null;
    localSubletHouseShareActivity.mIvBack = null;
    localSubletHouseShareActivity.luxuryShareView = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/activity/SubletHouseShareActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */