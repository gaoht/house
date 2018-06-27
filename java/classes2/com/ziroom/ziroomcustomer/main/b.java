package com.ziroom.ziroomcustomer.main;

import android.app.Activity;
import com.ziroom.ziroomcustomer.base.update.UpdateUtil;
import com.ziroom.ziroomcustomer.base.update.UpdateUtil.NeedOtherCheckUpdate;
import java.lang.ref.WeakReference;

public class b
  implements a.a
{
  private WeakReference<a.b> a;
  
  public b(a.b paramb)
  {
    this.a = new WeakReference(paramb);
    paramb = getView();
    if (paramb != null) {
      paramb.setPresenter(this);
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
    a.b localb = getView();
    if (localb != null)
    {
      UpdateUtil.getInstance().checkUpdate(localb.getViewContext(), false);
      UpdateUtil.getInstance().setNeedOtherCheckUpdate(new UpdateUtil.NeedOtherCheckUpdate()
      {
        public void checkUpdate()
        {
          a.b localb = b.this.getView();
          if ((localb != null) && (localb.isActive())) {
            new com.ziroom.ziroomcustomer.f.a((Activity)localb.getViewContext()).checkPgyUpdate(false);
          }
        }
      });
    }
    new com.ziroom.ziroomcustomer.util.a().getAdvertisement();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/main/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */