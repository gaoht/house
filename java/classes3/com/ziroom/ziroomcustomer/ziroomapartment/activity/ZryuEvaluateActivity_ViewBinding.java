package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.ziroomapartment.widget.ZryuEvaluteButton;
import com.ziroom.ziroomcustomer.ziroomstation.widget.MyListView;

public class ZryuEvaluateActivity_ViewBinding<T extends ZryuEvaluateActivity>
  implements Unbinder
{
  protected T a;
  
  public ZryuEvaluateActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.btnBack = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690078, "field 'btnBack'", ImageView.class));
    paramT.civZryuEvaluateHeadPic = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131691852, "field 'civZryuEvaluateHeadPic'", SimpleDraweeView.class));
    paramT.ratingbarZryuEvaluate = ((ZryuEvaluteButton)Utils.findRequiredViewAsType(paramView, 2131691856, "field 'ratingbarZryuEvaluate'", ZryuEvaluteButton.class));
    paramT.lvZryuEvaluateContent = ((MyListView)Utils.findRequiredViewAsType(paramView, 2131691854, "field 'lvZryuEvaluateContent'", MyListView.class));
    paramT.tvZryuEvaluateZoName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691853, "field 'tvZryuEvaluateZoName'", TextView.class));
    paramT.etZryuEvaluateContent = ((EditText)Utils.findRequiredViewAsType(paramView, 2131691858, "field 'etZryuEvaluateContent'", EditText.class));
    paramT.btnZryuEvaluateSubmit = ((Button)Utils.findRequiredViewAsType(paramView, 2131691860, "field 'btnZryuEvaluateSubmit'", Button.class));
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    paramT.tvEvaluateDesc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691855, "field 'tvEvaluateDesc'", TextView.class));
  }
  
  public void unbind()
  {
    ZryuEvaluateActivity localZryuEvaluateActivity = this.a;
    if (localZryuEvaluateActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localZryuEvaluateActivity.btnBack = null;
    localZryuEvaluateActivity.civZryuEvaluateHeadPic = null;
    localZryuEvaluateActivity.ratingbarZryuEvaluate = null;
    localZryuEvaluateActivity.lvZryuEvaluateContent = null;
    localZryuEvaluateActivity.tvZryuEvaluateZoName = null;
    localZryuEvaluateActivity.etZryuEvaluateContent = null;
    localZryuEvaluateActivity.btnZryuEvaluateSubmit = null;
    localZryuEvaluateActivity.tvTitle = null;
    localZryuEvaluateActivity.tvEvaluateDesc = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuEvaluateActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */