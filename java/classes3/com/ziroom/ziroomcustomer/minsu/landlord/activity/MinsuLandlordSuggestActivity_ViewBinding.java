package com.ziroom.ziroomcustomer.minsu.landlord.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class MinsuLandlordSuggestActivity_ViewBinding<T extends MinsuLandlordSuggestActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public MinsuLandlordSuggestActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mEt = ((EditText)Utils.findRequiredViewAsType(paramView, 2131691275, "field 'mEt'", EditText.class));
    paramView = Utils.findRequiredView(paramView, 2131689816, "field 'mBtnSubmit' and method 'onViewClick'");
    paramT.mBtnSubmit = ((Button)Utils.castView(paramView, 2131689816, "field 'mBtnSubmit'", Button.class));
    this.b = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    MinsuLandlordSuggestActivity localMinsuLandlordSuggestActivity = this.a;
    if (localMinsuLandlordSuggestActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuLandlordSuggestActivity.mEt = null;
    localMinsuLandlordSuggestActivity.mBtnSubmit = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/activity/MinsuLandlordSuggestActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */