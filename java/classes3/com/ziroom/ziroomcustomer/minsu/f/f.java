package com.ziroom.ziroomcustomer.minsu.f;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.dialog.i;
import java.util.ArrayList;
import java.util.List;

public class f
{
  private Activity a;
  private i b;
  private List c;
  private String d;
  
  public f(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public void init()
  {
    this.d = com.ziroom.ziroomcustomer.minsu.b.c.b;
    if (c.isNull(this.d))
    {
      this.d = aa.getString(ApplicationEx.c, "telphone", null);
      com.ziroom.ziroomcustomer.minsu.b.c.b = this.d;
    }
    this.c = new ArrayList();
    if (!c.isNull(this.d)) {
      this.c.add(this.a.getString(2131296752));
    }
    this.c.add(this.a.getString(2131296753));
    this.b = new i(this.a, new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        f.a(f.this).dismiss();
        if (f.c(f.this).get(paramAnonymousInt).equals(f.b(f.this).getString(2131296752)))
        {
          k.callPhone(f.b(f.this), f.d(f.this));
          return;
        }
        k.contactIM((BaseActivity)f.b(f.this));
      }
    }, this.c);
  }
  
  public void showPop()
  {
    if (this.b == null) {
      return;
    }
    ad.hideSoftInput(this.a);
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        i locali = f.a(f.this);
        View localView = f.b(f.this).getWindow().getDecorView();
        if (!(locali instanceof PopupWindow))
        {
          locali.showAtLocation(localView, 80, 0, 0);
          return;
        }
        VdsAgent.showAtLocation((PopupWindow)locali, localView, 80, 0, 0);
      }
    }, 250L);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/f/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */