package com.ziroom.ziroomcustomer.newclean.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;

public class ForCleaningCleanerFragment_ViewBinding<T extends ForCleaningCleanerFragment>
  implements Unbinder
{
  protected T a;
  
  public ForCleaningCleanerFragment_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mTvServicePlace = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693960, "field 'mTvServicePlace'", TextView.class));
    paramT.mTvNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690003, "field 'mTvNum'", TextView.class));
    paramT.mTvHireData = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693961, "field 'mTvHireData'", TextView.class));
    paramT.mTvNativePlace = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693962, "field 'mTvNativePlace'", TextView.class));
    paramT.mTvAge = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690052, "field 'mTvAge'", TextView.class));
    paramT.mTvConstellation = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693963, "field 'mTvConstellation'", TextView.class));
    paramT.mTvFond = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693964, "field 'mTvFond'", TextView.class));
    paramT.mFlLike = ((FlowLayout)Utils.findRequiredViewAsType(paramView, 2131690332, "field 'mFlLike'", FlowLayout.class));
    paramT.mGvIdent = ((MyGridView)Utils.findRequiredViewAsType(paramView, 2131693958, "field 'mGvIdent'", MyGridView.class));
    paramT.mTvFlkeTag = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694031, "field 'mTvFlkeTag'", TextView.class));
    paramT.mTvIdentDesc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694032, "field 'mTvIdentDesc'", TextView.class));
  }
  
  public void unbind()
  {
    ForCleaningCleanerFragment localForCleaningCleanerFragment = this.a;
    if (localForCleaningCleanerFragment == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localForCleaningCleanerFragment.mTvServicePlace = null;
    localForCleaningCleanerFragment.mTvNum = null;
    localForCleaningCleanerFragment.mTvHireData = null;
    localForCleaningCleanerFragment.mTvNativePlace = null;
    localForCleaningCleanerFragment.mTvAge = null;
    localForCleaningCleanerFragment.mTvConstellation = null;
    localForCleaningCleanerFragment.mTvFond = null;
    localForCleaningCleanerFragment.mFlLike = null;
    localForCleaningCleanerFragment.mGvIdent = null;
    localForCleaningCleanerFragment.mTvFlkeTag = null;
    localForCleaningCleanerFragment.mTvIdentDesc = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/fragment/ForCleaningCleanerFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */