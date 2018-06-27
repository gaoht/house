package com.ziroom.ziroomcustomer.newclean.mvp;

import android.content.Context;
import android.os.Bundle;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newclean.d.ae;
import java.lang.ref.WeakReference;

public class d
  implements c.a
{
  private WeakReference<c.b> a;
  private Context b;
  private String c;
  private String d;
  private String e;
  private String f;
  
  public d(c.b paramb)
  {
    this.a = new WeakReference(paramb);
    this.b = ((c.b)this.a.get()).getViewContext();
    if (paramb != null) {
      paramb.setPresenter(this);
    }
  }
  
  private void a()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo == null) {
      return;
    }
    n.getCleanHistoryCleaner(this.b, localUserInfo.getUid(), this.c, this.d, this.e, this.f, "2", new com.ziroom.ziroomcustomer.e.a.a(this.b, new m(ae.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onSuccess(int paramAnonymousInt, ae paramAnonymousae)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousae);
        if (paramAnonymousae != null) {}
      }
    });
  }
  
  private void b() {}
  
  public void detachView()
  {
    if (this.a != null)
    {
      this.a.clear();
      this.a = null;
    }
  }
  
  public Object getView()
  {
    if (this.a != null) {
      return this.a.get();
    }
    return null;
  }
  
  public boolean isActivityAlive()
  {
    return (getView() != null) && (((c.b)this.a.get()).isActive());
  }
  
  public void start()
  {
    if (isActivityAlive())
    {
      new Bundle();
      a();
      b();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/mvp/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */