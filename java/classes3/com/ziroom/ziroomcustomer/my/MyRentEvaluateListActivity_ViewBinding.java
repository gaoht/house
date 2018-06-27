package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.view.ViewStub;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class MyRentEvaluateListActivity_ViewBinding<T extends MyRentEvaluateListActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public MyRentEvaluateListActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mLvRentEvaluate = ((ListView)Utils.findRequiredViewAsType(paramView, 2131692126, "field 'mLvRentEvaluate'", ListView.class));
    paramT.mVsError = ((ViewStub)Utils.findRequiredViewAsType(paramView, 2131690894, "field 'mVsError'", ViewStub.class));
    paramView = Utils.findRequiredView(paramView, 2131689492, "method 'onClick'");
    this.b = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    MyRentEvaluateListActivity localMyRentEvaluateListActivity = this.a;
    if (localMyRentEvaluateListActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMyRentEvaluateListActivity.mLvRentEvaluate = null;
    localMyRentEvaluateListActivity.mVsError = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyRentEvaluateListActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */