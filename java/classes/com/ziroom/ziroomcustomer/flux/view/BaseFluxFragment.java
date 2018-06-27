package com.ziroom.ziroomcustomer.flux.view;

import android.content.Context;
import android.os.Bundle;
import com.freelxl.baselibrary.f.g;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.flux.b;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.j;

public abstract class BaseFluxFragment
  extends BaseFragment
{
  protected b a;
  private com.ziroom.ziroomcustomer.flux.b.a b;
  
  protected abstract void a(com.ziroom.ziroomcustomer.flux.a.a parama);
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.a = b.get();
    this.b = new com.ziroom.ziroomcustomer.flux.b.a(this);
    this.a.register(this.b);
    c.getDefault().register(this);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDetach()
  {
    this.a.unregister(this.b);
    c.getDefault().unregister(this);
    super.onDetach();
  }
  
  @j(threadMode=ThreadMode.MAIN)
  public void onEvent(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    if ((parama.getTarget() != null) && (!parama.getTarget().equals(getClass().getName()))) {}
    do
    {
      return;
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
          a(parama);
          return;
          if (str.equals("type_show_loading"))
          {
            i = 0;
            continue;
            if (str.equals("type_dismiss_loading"))
            {
              i = 1;
              continue;
              if (str.equals("type_toast")) {
                i = 2;
              }
            }
          }
          break;
        }
      }
      showProgress("");
      return;
      dismissProgress();
      return;
    } while (getActivity() == null);
    g.textToast(getActivity(), this.b.getToastMsg());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/flux/view/BaseFluxFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */