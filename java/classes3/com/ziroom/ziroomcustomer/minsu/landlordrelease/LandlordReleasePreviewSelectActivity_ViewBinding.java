package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.view.View;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class LandlordReleasePreviewSelectActivity_ViewBinding<T extends LandlordReleasePreviewSelectActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public LandlordReleasePreviewSelectActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.lv_room = ((ListView)Utils.findRequiredViewAsType(paramView, 2131691552, "field 'lv_room'", ListView.class));
    paramView = Utils.findRequiredView(paramView, 2131690078, "field 'btn_cancel' and method 'OnClick'");
    paramT.btn_cancel = paramView;
    this.b = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    LandlordReleasePreviewSelectActivity localLandlordReleasePreviewSelectActivity = this.a;
    if (localLandlordReleasePreviewSelectActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLandlordReleasePreviewSelectActivity.lv_room = null;
    localLandlordReleasePreviewSelectActivity.btn_cancel = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LandlordReleasePreviewSelectActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */