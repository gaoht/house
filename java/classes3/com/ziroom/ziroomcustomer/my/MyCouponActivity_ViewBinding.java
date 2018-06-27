package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;

public class MyCouponActivity_ViewBinding<T extends MyCouponActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public MyCouponActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mBztb = ((BasicZiroomToolBar)Utils.findRequiredViewAsType(paramView, 2131689787, "field 'mBztb'", BasicZiroomToolBar.class));
    paramT.mLv = ((ListView)Utils.findRequiredViewAsType(paramView, 2131689817, "field 'mLv'", ListView.class));
    paramT.mFlEmpty = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131691788, "field 'mFlEmpty'", FrameLayout.class));
    paramT.mTvEmpty = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691829, "field 'mTvEmpty'", TextView.class));
    Object localObject = Utils.findRequiredView(paramView, 2131691830, "field 'mTvGotoExpired' and method 'onViewClick'");
    paramT.mTvGotoExpired = ((TextView)Utils.castView((View)localObject, 2131691830, "field 'mTvGotoExpired'", TextView.class));
    this.b = ((View)localObject);
    ((View)localObject).setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    paramView = paramView.getContext();
    localObject = paramView.getResources();
    paramT.mColorGray99 = Utils.getColor((Resources)localObject, paramView.getTheme(), 2131624393);
    paramT.mSize1_5 = ((Resources)localObject).getDimensionPixelSize(2131231180);
    paramT.mSize9_5 = ((Resources)localObject).getDimensionPixelSize(2131231183);
    paramT.mSize16 = ((Resources)localObject).getDimensionPixelSize(2131231179);
    paramT.mSize24 = ((Resources)localObject).getDimensionPixelSize(2131231181);
    paramT.mSizeText12 = ((Resources)localObject).getDimensionPixelSize(2131231242);
    paramT.mSizeText14_5 = ((Resources)localObject).getDimensionPixelSize(2131231178);
  }
  
  public void unbind()
  {
    MyCouponActivity localMyCouponActivity = this.a;
    if (localMyCouponActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMyCouponActivity.mBztb = null;
    localMyCouponActivity.mLv = null;
    localMyCouponActivity.mFlEmpty = null;
    localMyCouponActivity.mTvEmpty = null;
    localMyCouponActivity.mTvGotoExpired = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyCouponActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */