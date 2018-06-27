package com.ziroom.ziroomcustomer.findhouse.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Ensure;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Ensure.Detail;
import com.ziroom.ziroomcustomer.util.s;
import java.util.Iterator;
import java.util.List;

public class RentHouseDetailEnsuresPop
  extends PopupWindow
  implements View.OnClickListener
{
  private ImageView a;
  private LinearLayout b;
  private View c;
  private Context d;
  
  public RentHouseDetailEnsuresPop(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RentHouseDetailEnsuresPop(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RentHouseDetailEnsuresPop(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSoftInputMode(16);
    setWidth(-1);
    setHeight(-1);
    setAnimationStyle(2131427507);
    this.c = LayoutInflater.from(paramContext).inflate(2130905036, null);
    this.d = paramContext;
    a();
  }
  
  private void a()
  {
    this.a = ((ImageView)this.c.findViewById(2131697275));
    this.b = ((LinearLayout)this.c.findViewById(2131697279));
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
  
  public void show(View paramView, RentHouseDetail.Ensure paramEnsure)
  {
    if (paramEnsure != null)
    {
      LinearLayout localLinearLayout1 = (LinearLayout)LayoutInflater.from(this.d).inflate(2130905037, null);
      ((TextView)localLinearLayout1.findViewById(2131697280)).setText(paramEnsure.getTitle());
      LinearLayout localLinearLayout2 = (LinearLayout)localLinearLayout1.findViewById(2131697281);
      paramEnsure = paramEnsure.getDetailed();
      if (!s.isEmpty(paramEnsure))
      {
        paramEnsure = paramEnsure.iterator();
        while (paramEnsure.hasNext())
        {
          RentHouseDetail.Ensure.Detail localDetail = (RentHouseDetail.Ensure.Detail)paramEnsure.next();
          RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.d).inflate(2130905039, null);
          TextView localTextView1 = (TextView)localRelativeLayout.findViewById(2131697285);
          TextView localTextView2 = (TextView)localRelativeLayout.findViewById(2131697284);
          TextView localTextView3 = (TextView)localRelativeLayout.findViewById(2131689533);
          localTextView2.setVisibility(8);
          localTextView3.setText(localDetail.getTitle());
          localTextView1.setText(localDetail.getDesc());
          localLinearLayout2.addView(localRelativeLayout);
        }
      }
      this.b.addView(localLinearLayout1);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/RentHouseDetailEnsuresPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */