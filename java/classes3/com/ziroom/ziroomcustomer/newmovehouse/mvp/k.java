package com.ziroom.ziroomcustomer.newmovehouse.mvp;

import android.content.Intent;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.d.av;
import com.ziroom.ziroomcustomer.newmovehouse.b.g;
import java.lang.ref.WeakReference;
import java.util.List;

public class k
  implements j.a
{
  private WeakReference<j.b> a;
  private String b;
  private g c;
  
  public k(j.b paramb)
  {
    this.a = new WeakReference(paramb);
    if (paramb != null) {
      paramb.setPresenter(this);
    }
  }
  
  private boolean a()
  {
    return (getView() != null) && (((j.b)this.a.get()).isActive());
  }
  
  public void detachView()
  {
    if (this.a != null)
    {
      this.a.clear();
      this.a = null;
      org.greenrobot.eventbus.c.getDefault().unregister(this);
    }
  }
  
  public void getOrderState()
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((UserInfo)localObject).getUid();
    } while (!a());
    n.getMoveOrderState(((j.b)this.a.get()).getViewContext(), this.b, (String)localObject, new com.freelxl.baselibrary.d.c.a(new l(av.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        paramAnonymousThrowable.printStackTrace();
        if (k.a(k.this)) {
          ((j.b)k.b(k.this).get()).onLoad();
        }
      }
      
      public void onSuccess(int paramAnonymousInt, List<av> paramAnonymousList)
      {
        if (k.a(k.this))
        {
          ((j.b)k.b(k.this).get()).onLoad();
          if (paramAnonymousList != null)
          {
            k.a(k.this, new g(((j.b)k.b(k.this).get()).getViewContext(), paramAnonymousList));
            ((j.b)k.b(k.this).get()).setXLAdapter(k.c(k.this));
          }
        }
      }
    });
  }
  
  public Object getView()
  {
    if (this.a != null) {
      return this.a.get();
    }
    return null;
  }
  
  public void refresh()
  {
    org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("move_small_button_refresh", null));
    org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("move_small_button_refresh_detail", null));
    getOrderState();
  }
  
  public void start()
  {
    if (a()) {
      this.b = ((j.b)this.a.get()).getExtras().getStringExtra("orderId");
    }
    getOrderState();
  }
  
  public void toChat()
  {
    if (a()) {
      j.toChat(((j.b)this.a.get()).getActivity());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/mvp/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */