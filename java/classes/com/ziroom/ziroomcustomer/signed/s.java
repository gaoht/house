package com.ziroom.ziroomcustomer.signed;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.d;
import com.ziroom.ziroomcustomer.util.ae;

public class s
{
  public static Context a;
  public static Handler c = new s.3();
  View.OnClickListener b = new s.2(this);
  private View d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private Dialog i;
  
  public s(Context paramContext)
  {
    a = paramContext;
  }
  
  public void getTurnSign()
  {
    d.getTurnSignStyle(c, a);
  }
  
  public void showDialog()
  {
    this.d = View.inflate(a, 2130905178, null);
    this.e = ((TextView)this.d.findViewById(2131697639));
    this.h = ((TextView)this.d.findViewById(2131697638));
    this.g = ((TextView)this.d.findViewById(2131697637));
    this.f = ((TextView)this.d.findViewById(2131697634));
    this.e.setOnClickListener(this.b);
    this.h.setOnClickListener(this.b);
    if (ae.notNull(ApplicationEx.h)) {
      this.f.setText(ApplicationEx.h);
    }
    if (ae.notNull(ApplicationEx.i)) {
      this.g.setText(ApplicationEx.i);
    }
    Dialog localDialog;
    if (this.i == null)
    {
      this.i = new Dialog(a, 2131427781);
      this.i.setContentView(this.d);
      this.i.setCanceledOnTouchOutside(false);
      this.i.setCancelable(false);
      localDialog = this.i;
      if ((localDialog instanceof Dialog)) {
        break label223;
      }
      localDialog.show();
    }
    for (;;)
    {
      ApplicationEx.g = 2;
      this.i.setOnDismissListener(new s.1(this));
      return;
      label223:
      VdsAgent.showDialog((Dialog)localDialog);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */