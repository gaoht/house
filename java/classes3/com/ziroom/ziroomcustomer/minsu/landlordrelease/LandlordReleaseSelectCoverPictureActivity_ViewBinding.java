package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;

public class LandlordReleaseSelectCoverPictureActivity_ViewBinding<T extends LandlordReleaseSelectCoverPictureActivity>
  implements Unbinder
{
  protected T a;
  
  public LandlordReleaseSelectCoverPictureActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.bztb_title = ((BasicZiroomToolBar)Utils.findRequiredViewAsType(paramView, 2131691043, "field 'bztb_title'", BasicZiroomToolBar.class));
    paramT.rv_pic = ((RecyclerView)Utils.findRequiredViewAsType(paramView, 2131691075, "field 'rv_pic'", RecyclerView.class));
  }
  
  public void unbind()
  {
    LandlordReleaseSelectCoverPictureActivity localLandlordReleaseSelectCoverPictureActivity = this.a;
    if (localLandlordReleaseSelectCoverPictureActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLandlordReleaseSelectCoverPictureActivity.bztb_title = null;
    localLandlordReleaseSelectCoverPictureActivity.rv_pic = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LandlordReleaseSelectCoverPictureActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */