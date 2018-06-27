package com.ziroom.ziroomcustomer.account.a;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import com.freelxl.baselibrary.a.a;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.account.model.AccountDetails.DataBean;
import java.util.List;

public class b
  extends a<AccountDetails.DataBean>
  implements View.OnClickListener
{
  Context d;
  
  public b(Context paramContext, List<AccountDetails.DataBean> paramList)
  {
    super(paramContext, paramList, 2130903075);
    this.d = paramContext;
  }
  
  public void convert(com.freelxl.baselibrary.a.b paramb, AccountDetails.DataBean paramDataBean) {}
  
  public void convert(com.freelxl.baselibrary.a.b paramb, AccountDetails.DataBean paramDataBean, int paramInt)
  {
    super.convert(paramb, paramDataBean, paramInt);
    if ("1".equals(paramDataBean.getType()))
    {
      paramb.setText(2131689793, "+" + paramDataBean.getBalance());
      paramb.setTextColor(2131689793, Color.parseColor("#63D18B"));
    }
    for (;;)
    {
      paramb.setText(2131689792, paramDataBean.getDate());
      paramb.setText(2131689790, paramDataBean.getType_name());
      if ((!"2".equals(paramDataBean.getStatus())) || (!"3".equals(paramDataBean.getType()))) {
        break;
      }
      paramb.setVisibility(2131689791, 0);
      return;
      if ("2".equals(paramDataBean.getType()))
      {
        paramb.setText(2131689793, "-" + paramDataBean.getBalance());
        paramb.setTextColor(2131689793, Color.parseColor("#444444"));
      }
      else if ("3".equals(paramDataBean.getType()))
      {
        paramb.setText(2131689793, paramDataBean.getBalance());
        paramb.setText(2131689794, paramDataBean.getStatus_name());
        paramb.setTextColor(2131689793, Color.parseColor("#444444"));
      }
    }
    paramb.setVisibility(2131689791, 8);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */