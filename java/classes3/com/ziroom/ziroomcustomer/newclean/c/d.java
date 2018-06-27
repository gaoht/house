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
import com.ziroom.ziroomcustomer.newclean.b.v;
import com.ziroom.ziroomcustomer.newclean.d.au;
import com.ziroom.ziroomcustomer.newclean.d.au.a;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class d
  extends Dialog
{
  private Context a;
  private TextView b;
  private ImageView c;
  private au d;
  private ListView e;
  private List<au.a> f = new ArrayList();
  
  public d(Context paramContext, au paramau)
  {
    super(paramContext, 2131427692);
    this.a = paramContext;
    this.d = paramau;
    setDefaultSetting();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.a).inflate(2130903790, null);
    this.c = ((ImageView)localView.findViewById(2131689492));
    this.e = ((ListView)localView.findViewById(2131691811));
    this.b = ((TextView)localView.findViewById(2131693764));
    b();
    setContentView(localView);
  }
  
  private void b()
  {
    if (this.d == null) {
      return;
    }
    int i = this.d.getDiscountPrice();
    Object localObject;
    if ((this.d.getUserOrderItemVOs() != null) && (this.d.getUserOrderItemVOs().size() > 0))
    {
      this.f.clear();
      this.f.addAll(this.d.getUserOrderItemVOs());
      if (i > 0)
      {
        localObject = new au.a();
        ((au.a)localObject).setItemName("优惠金额");
        ((au.a)localObject).setItemAmount(Integer.valueOf(i));
        this.f.add(localObject);
      }
      localObject = new v(this.a, this.f);
      this.e.setAdapter((ListAdapter)localObject);
    }
    try
    {
      localObject = new DecimalFormat("######0.00");
      float f1 = Float.valueOf(this.d.getPayAmount()).floatValue();
      this.b.setText(((DecimalFormat)localObject).format(f1) + "");
      this.c.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          d.this.dismiss();
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */