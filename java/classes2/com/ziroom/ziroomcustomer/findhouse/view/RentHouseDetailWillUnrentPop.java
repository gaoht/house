package com.ziroom.ziroomcustomer.findhouse.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail;

public class RentHouseDetailWillUnrentPop
  extends PopupWindow
  implements View.OnClickListener
{
  private ImageView a;
  private TextView b;
  private View c;
  
  public RentHouseDetailWillUnrentPop(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RentHouseDetailWillUnrentPop(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RentHouseDetailWillUnrentPop(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSoftInputMode(16);
    setWidth(-1);
    setHeight(-1);
    setAnimationStyle(2131427507);
    this.c = LayoutInflater.from(paramContext).inflate(2130905066, null);
    a();
  }
  
  private void a()
  {
    this.a = ((ImageView)this.c.findViewById(2131697275));
    this.b = ((TextView)this.c.findViewById(2131697346));
    this.a.setOnClickListener(this);
    setContentView(this.c);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    dismiss();
  }
  
  public void show(View paramView, RentHouseDetail paramRentHouseDetail)
  {
    if (paramRentHouseDetail != null)
    {
      this.b.setText(paramRentHouseDetail.getWill_unrent_tip());
      if (!(this instanceof PopupWindow)) {
        super.showAtLocation(paramView, 0, 0, 0);
      }
    }
    else
    {
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)this, paramView, 0, 0, 0);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/RentHouseDetailWillUnrentPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */