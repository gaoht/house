package com.ziroom.ziroomcustomer.newclean.c;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.newclean.b.y;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.PeriodGeneralDetailBean;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.PeriodGeneralDetailBean.ChargesBean;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.PeriodGeneralDetailBean.ItemBean;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class e
  extends Dialog
{
  private Context a;
  private ImageView b;
  private TextView c;
  private PeriodGeneralDetailBean d;
  private ListView e;
  private List<PeriodGeneralDetailBean.ItemBean> f = new ArrayList();
  
  public e(Context paramContext, PeriodGeneralDetailBean paramPeriodGeneralDetailBean)
  {
    super(paramContext, 2131427692);
    this.a = paramContext;
    this.d = paramPeriodGeneralDetailBean;
    setDefaultSetting();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.a).inflate(2130903790, null);
    this.c = ((TextView)localView.findViewById(2131693764));
    this.e = ((ListView)localView.findViewById(2131691811));
    this.b = ((ImageView)localView.findViewById(2131689492));
    b();
    setContentView(localView);
  }
  
  private void b()
  {
    if (this.d == null) {
      return;
    }
    Object localObject;
    if (this.d.getCharges() != null)
    {
      int i = (int)(this.d.getCharges().getDiscount().longValue() / 100L);
      if ((this.d.getUserOrderItemVOs() != null) && (this.d.getUserOrderItemVOs().size() > 0))
      {
        this.f.clear();
        this.f.addAll(this.d.getUserOrderItemVOs());
        if (i > 0)
        {
          localObject = new PeriodGeneralDetailBean.ItemBean();
          ((PeriodGeneralDetailBean.ItemBean)localObject).setItemName("优惠金额");
          ((PeriodGeneralDetailBean.ItemBean)localObject).setItemAmount(Integer.valueOf(i));
          ((PeriodGeneralDetailBean.ItemBean)localObject).setCanShowCoupon(false);
          this.f.add(localObject);
        }
        localObject = new y(this.a, this.f);
        this.e.setAdapter((ListAdapter)localObject);
      }
    }
    try
    {
      localObject = new DecimalFormat("######0.00");
      if (this.d.getCharges().getNeedPay() != null) {
        this.c.setText(((DecimalFormat)localObject).format(this.d.getCharges().getNeedPay().longValue() / 100.0D) + "");
      }
      this.b.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          e.this.dismiss();
        }
      });
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  public void setDefaultSetting()
  {
    setCanceledOnTouchOutside(true);
    Window localWindow = getWindow();
    localWindow.setWindowAnimations(2131427962);
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localWindow.setAttributes(localLayoutParams);
    localWindow.getDecorView().setBackgroundColor(-1);
    localWindow.setGravity(80);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */