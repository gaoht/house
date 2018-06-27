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
import com.ziroom.ziroomcustomer.findhouse.a.b;
import com.ziroom.ziroomcustomer.findhouse.model.DistrictDetail.IntroBean;
import com.ziroom.ziroomcustomer.widget.LinearLayoutForListView;
import java.util.List;

public class DistrictInfoPop
  extends PopupWindow
  implements View.OnClickListener
{
  private ImageView a;
  private TextView b;
  private LinearLayoutForListView c;
  private View d;
  private Context e;
  
  public DistrictInfoPop(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DistrictInfoPop(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DistrictInfoPop(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSoftInputMode(16);
    setWidth(-1);
    setHeight(-1);
    setAnimationStyle(2131427507);
    this.d = LayoutInflater.from(paramContext).inflate(2130905035, null);
    this.e = paramContext;
    a();
  }
  
  private void a()
  {
    this.b = ((TextView)this.d.findViewById(2131690049));
    this.a = ((ImageView)this.d.findViewById(2131697275));
    this.c = ((LinearLayoutForListView)this.d.findViewById(2131697278));
    this.a.setOnClickListener(this);
    setContentView(this.d);
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
  
  public void show(View paramView, DistrictDetail.IntroBean paramIntroBean)
  {
    if ((paramIntroBean == null) || (paramIntroBean.getData() == null)) {
      return;
    }
    List localList = paramIntroBean.getData();
    this.b.setText(paramIntroBean.getTitle());
    this.c.removeAllViews();
    paramIntroBean = new b(this.e, localList);
    this.c.setAdapter(paramIntroBean);
    if (!(this instanceof PopupWindow))
    {
      super.showAtLocation(paramView, 0, 0, 0);
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)this, paramView, 0, 0, 0);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/DistrictInfoPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */