package com.ziroom.ziroomcustomer.newmovehouse.mvp;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.widget.ScrollControlerViewPager;

public class MoveRecActivity_ViewBinding<T extends MoveRecActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public MoveRecActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131691493, "field 'btnLeftImg' and method 'click'");
    paramT.btnLeftImg = ((ImageView)Utils.castView(localView, 2131691493, "field 'btnLeftImg'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.click(paramAnonymousView);
      }
    });
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    paramT.ivChat = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690023, "field 'ivChat'", ImageView.class));
    paramT.rlTitle = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131689808, "field 'rlTitle'", RelativeLayout.class));
    paramT.viewPager = ((ScrollControlerViewPager)Utils.findRequiredViewAsType(paramView, 2131691721, "field 'viewPager'", ScrollControlerViewPager.class));
  }
  
  public void unbind()
  {
    MoveRecActivity localMoveRecActivity = this.a;
    if (localMoveRecActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMoveRecActivity.btnLeftImg = null;
    localMoveRecActivity.tvTitle = null;
    localMoveRecActivity.ivChat = null;
    localMoveRecActivity.rlTitle = null;
    localMoveRecActivity.viewPager = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/mvp/MoveRecActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */