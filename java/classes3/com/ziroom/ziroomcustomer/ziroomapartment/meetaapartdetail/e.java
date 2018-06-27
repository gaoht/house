package com.ziroom.ziroomcustomer.ziroomapartment.meetaapartdetail;

import android.content.Context;
import android.text.TextUtils;
import com.freelxl.baselibrary.d.f.a;
import com.ziroom.ziroomcustomer.e.a.c;
import com.ziroom.ziroomcustomer.e.c.d;
import com.ziroom.ziroomcustomer.e.j;
import java.lang.ref.WeakReference;

public class e
  implements d.a
{
  private WeakReference<d.b> a;
  private com.alibaba.fastjson.e b;
  private String c;
  
  public e(d.b paramb)
  {
    if (paramb != null)
    {
      this.a = new WeakReference(paramb);
      paramb.setPresenter(this);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    d.b localb = getView();
    if ((localb != null) && (localb.isActive()) && (this.b != null)) {
      j.zryuMeetaOnOffSwitch(localb.getViewContext(), this.b.getInteger("personId"), paramBoolean, new c(localb.getViewContext(), new d())
      {
        public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          d.b localb = e.this.getView();
          if ((localb != null) && (localb.isActive()) && (paramAnonymouse != null))
          {
            if (paramAnonymouse.getBoolean("result").booleanValue()) {
              e.this.start();
            }
          }
          else {
            return;
          }
          localb.toEditInfo(paramAnonymouse.getString("url"));
        }
      });
    }
  }
  
  public void closeCircle()
  {
    a(false);
  }
  
  public void detachView()
  {
    if (this.a != null) {
      this.a.clear();
    }
    this.a = null;
  }
  
  public d.b getView()
  {
    if (this.a != null) {
      return (d.b)this.a.get();
    }
    return null;
  }
  
  public void openCircle()
  {
    a(true);
  }
  
  public void setProjectId(String paramString)
  {
    this.c = paramString;
  }
  
  public void start()
  {
    d.b localb = getView();
    if ((localb != null) && (localb.isActive()) && (!TextUtils.isEmpty(this.c))) {
      j.zryuMeetaCheckSwitch(localb.getViewContext(), this.c, new c(localb.getViewContext(), new d())
      {
        public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          d.b localb = e.this.getView();
          if ((localb != null) && (localb.isActive()) && (paramAnonymouse != null))
          {
            e.a(e.this, paramAnonymouse);
            localb.showSettting(paramAnonymouse.getInteger("hasValid"), paramAnonymouse.getInteger("meetaShow"));
          }
        }
      });
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/meetaapartdetail/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */