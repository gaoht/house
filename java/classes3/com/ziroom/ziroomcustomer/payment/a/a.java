package com.ziroom.ziroomcustomer.payment.a;

import android.content.Context;
import android.view.View;
import com.freelxl.baselibrary.a.b;
import com.ziroom.ziroomcustomer.payment.b.c;
import java.util.List;

public class a
  extends com.freelxl.baselibrary.a.a
{
  public a(Context paramContext, List<c> paramList, int paramInt)
  {
    super(paramContext, paramList, paramInt);
  }
  
  public void convert(b paramb, Object paramObject)
  {
    c localc = (c)paramObject;
    if (localc.getMoney() % 100 == 0)
    {
      paramObject = "￥" + localc.getMoney() / 100;
      paramb.setText(2131689846, (String)paramObject);
      paramb.setText(2131690311, localc.getName());
      paramb.setText(2131695523, localc.getRule());
      paramb.setText(2131690313, localc.getDesc());
      if (!localc.isChecked()) {
        break label273;
      }
    }
    label273:
    for (int i = 0;; i = 4)
    {
      paramb.setVisibility(2131694955, i);
      if (!localc.isCanSelect()) {
        break label278;
      }
      paramb.getView(2131694820).setAlpha(1.0F);
      paramb.setTextColor(2131689846, -12303292);
      paramb.setTextColor(2131690311, -12303292);
      paramb.setTextColor(2131695523, -6710887);
      paramb.setTextColor(2131690313, -6710887);
      paramb.setImageResource(2131694818, 2130838744);
      return;
      if (localc.getMoney() % 10 == 0)
      {
        paramObject = "￥" + localc.getMoney() / 100 + "." + localc.getMoney() % 10;
        break;
      }
      paramObject = "￥" + localc.getMoney() / 100 + "." + localc.getMoney() % 100;
      break;
    }
    label278:
    paramb.getView(2131694820).setAlpha(0.7F);
    paramb.setTextColor(2131689846, -6710887);
    paramb.setTextColor(2131690311, -2236963);
    paramb.setTextColor(2131695523, -2236963);
    paramb.setTextColor(2131690313, -2236963);
    paramb.setImageResource(2131694818, 2130838742);
    paramb.setVisibility(2131694955, 4);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */