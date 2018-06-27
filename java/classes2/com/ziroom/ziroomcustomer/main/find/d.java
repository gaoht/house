package com.ziroom.ziroomcustomer.main.find;

import android.content.Context;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.d.f.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.a.b;
import com.ziroom.ziroomcustomer.e.j;
import java.lang.ref.WeakReference;

public class d
  implements a.a
{
  WeakReference<a.b> a;
  
  public d(a.b paramb)
  {
    this.a = new WeakReference(paramb);
    if (getView() != null) {
      getView().setPresenter(this);
    }
  }
  
  public void detachView()
  {
    if (this.a != null)
    {
      this.a.clear();
      this.a = null;
    }
  }
  
  public a.b getView()
  {
    if (this.a != null) {
      return (a.b)this.a.get();
    }
    return null;
  }
  
  public void start()
  {
    if (getView() != null) {
      j.getCityList(getView().getViewContext(), new b(ApplicationEx.c, new com.ziroom.ziroomcustomer.e.c.d())
      {
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          paramAnonymouse = d.this.getView();
          if (paramAnonymouse.isActive()) {
            paramAnonymouse.showTestDialog();
          }
        }
      });
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/main/find/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */