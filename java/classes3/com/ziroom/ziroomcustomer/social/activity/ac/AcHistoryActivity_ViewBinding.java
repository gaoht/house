package com.ziroom.ziroomcustomer.social.activity.ac;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class AcHistoryActivity_ViewBinding<T extends AcHistoryActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public AcHistoryActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131689492, "field 'mIvBack' and method 'onViewClicked'");
    paramT.mIvBack = ((ImageView)Utils.castView(localView, 2131689492, "field 'mIvBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked();
      }
    });
    paramT.mLvHistory = ((ListView)Utils.findRequiredViewAsType(paramView, 2131689827, "field 'mLvHistory'", ListView.class));
    paramT.mLlEmpty = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131689818, "field 'mLlEmpty'", LinearLayout.class));
  }
  
  public void unbind()
  {
    AcHistoryActivity localAcHistoryActivity = this.a;
    if (localAcHistoryActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localAcHistoryActivity.mIvBack = null;
    localAcHistoryActivity.mLvHistory = null;
    localAcHistoryActivity.mLlEmpty = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/ac/AcHistoryActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */