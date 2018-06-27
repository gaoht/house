package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.ziroomapartment.widget.ZryuEvaluteButton;
import com.ziroom.ziroomcustomer.ziroomstation.widget.MyListView;

public class MySubmitEvaluateActivity_ViewBinding<T extends MySubmitEvaluateActivity>
  implements Unbinder
{
  protected T a;
  
  public MySubmitEvaluateActivity_ViewBinding(T paramT, View paramView)
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
    paramT.tvEvaluateStarDesc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691857, "field 'tvEvaluateStarDesc'", TextView.class));
    paramT.tvCharNumTip = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691859, "field 'tvCharNumTip'", TextView.class));
    paramT.ll_content_container = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690608, "field 'll_content_container'", LinearLayout.class));
    paramT.ll_evaluate_contain = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691851, "field 'll_evaluate_contain'", LinearLayout.class));
  }
  
  public void unbind()
  {
    MySubmitEvaluateActivity localMySubmitEvaluateActivity = this.a;
    if (localMySubmitEvaluateActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMySubmitEvaluateActivity.btnBack = null;
    localMySubmitEvaluateActivity.civZryuEvaluateHeadPic = null;
    localMySubmitEvaluateActivity.ratingbarZryuEvaluate = null;
    localMySubmitEvaluateActivity.lvZryuEvaluateContent = null;
    localMySubmitEvaluateActivity.tvZryuEvaluateZoName = null;
    localMySubmitEvaluateActivity.etZryuEvaluateContent = null;
    localMySubmitEvaluateActivity.btnZryuEvaluateSubmit = null;
    localMySubmitEvaluateActivity.tvTitle = null;
    localMySubmitEvaluateActivity.tvEvaluateDesc = null;
    localMySubmitEvaluateActivity.tvEvaluateStarDesc = null;
    localMySubmitEvaluateActivity.tvCharNumTip = null;
    localMySubmitEvaluateActivity.ll_content_container = null;
    localMySubmitEvaluateActivity.ll_evaluate_contain = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MySubmitEvaluateActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */