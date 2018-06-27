package com.ziroom.ziroomcustomer.flux.view;

import android.os.Bundle;
import com.freelxl.baselibrary.f.g;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.flux.b;
import com.ziroom.ziroomcustomer.widget.LodingProgressDialog;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.j;

public abstract class BaseFluxActivity
  extends BaseActivity
{
  protected b a;
  private com.ziroom.ziroomcustomer.flux.b.a b;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c.getDefault().register(this);
    this.a = b.get();
    this.b = new com.ziroom.ziroomcustomer.flux.b.a(this);
    this.a.register(this.b);
  }
  
  protected void onDestroy()
  {
    this.a.unregister(this.b);
    c.getDefault().unregister(this);
    super.onDestroy();
  }
  
  @j(threadMode=ThreadMode.MAIN)
  public void onEvent(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    if ((parama.getTarget() != null) && (!parama.getTarget().equals(getClass().getName()))) {
      return;
    }
    String str = parama.getType();
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        onEventHandle(parama);
        return;
        if (str.equals("type_show_loading"))
        {
          i = 0;
          continue;
          if (str.equals("type_dismiss_loading"))
          {
            i = 1;
            continue;
            if (str.equals("type_login"))
            {
              i = 2;
              continue;
              if (str.equals("type_toast")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    LodingProgressDialog.show(this, "", false, true);
    return;
    dismissProgress();
    return;
    com.ziroom.commonlibrary.login.a.startLoginActivity(this);
    return;
    g.textToast(this, this.b.getToastMsg());
  }
  
  protected abstract void onEventHandle(com.ziroom.ziroomcustomer.flux.a.a parama);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/flux/view/BaseFluxActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */