package com.ziroom.ziroomcustomer.newclean.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;

public class ForCleaningEvalFragment_ViewBinding<T extends ForCleaningEvalFragment>
  implements Unbinder
{
  protected T a;
  
  public ForCleaningEvalFragment_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mLvEval = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131693955, "field 'mLvEval'", ListViewForScrollView.class));
    paramT.mTvToAll = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693956, "field 'mTvToAll'", TextView.class));
    paramT.mTvNoData = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690175, "field 'mTvNoData'", TextView.class));
  }
  
  public void unbind()
  {
    ForCleaningEvalFragment localForCleaningEvalFragment = this.a;
    if (localForCleaningEvalFragment == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localForCleaningEvalFragment.mLvEval = null;
    localForCleaningEvalFragment.mTvToAll = null;
    localForCleaningEvalFragment.mTvNoData = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/fragment/ForCleaningEvalFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */