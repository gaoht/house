package com.ziroom.ziroomcustomer.social.activity.a;

import android.content.Context;
import android.content.Intent;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.social.a.a.a;
import com.ziroom.ziroomcustomer.social.activity.ac.AcMainActivity;
import com.ziroom.ziroomcustomer.social.model.e;
import com.ziroom.ziroomcustomer.social.model.g;
import java.util.ArrayList;
import java.util.List;

public class c
  implements b.a
{
  private b.b a;
  private int b = 1;
  private int c;
  private final int d = 10;
  private boolean e = true;
  private boolean f;
  private com.ziroom.ziroomcustomer.e.a.f<g> g;
  private List<e> h = new ArrayList();
  private com.ziroom.ziroomcustomer.social.a.a i;
  
  public c(b.b paramb)
  {
    this.a = paramb;
    this.a.setPresenter(this);
  }
  
  private void a()
  {
    Intent localIntent = new Intent(this.a.getViewContext(), AcMainActivity.class);
    localIntent.putExtra("cityCode", com.ziroom.ziroomcustomer.base.b.getCurrentCity().getCode());
    ((BaseActivity)this.a.getViewContext()).startActivityAndFinish(localIntent);
  }
  
  public void detachView()
  {
    this.a = null;
  }
  
  public void enrollClick()
  {
    a();
  }
  
  public void getData()
  {
    if ((!this.e) || (this.f)) {
      return;
    }
    this.f = true;
    if (this.g == null) {
      this.g = new com.ziroom.ziroomcustomer.e.a.f(this.a.getViewContext(), new com.ziroom.ziroomcustomer.e.c.f(g.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          c.a(c.this, false);
        }
        
        public void onSuccess(int paramAnonymousInt, g paramAnonymousg)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousg);
          c.a(c.this, false);
          if (!c.this.isViewActive()) {}
          do
          {
            return;
            if ((paramAnonymousg != null) && (paramAnonymousg.getList() != null)) {
              break;
            }
          } while (c.a(c.this) != 1);
          c.b(c.this).showEmpty();
          return;
          if (paramAnonymousg.getList().size() < 10) {
            c.b(c.this, false);
          }
          while (paramAnonymousg.getList().size() < 1)
          {
            c.b(c.this).showEmpty();
            return;
            c.b(c.this, true);
          }
          paramAnonymousg = paramAnonymousg.getList();
          c.c(c.this);
          if (c.d(c.this) == null) {
            c.a(c.this, new ArrayList());
          }
          c.d(c.this).addAll(paramAnonymousg);
          c.e(c.this).notifyDataSetChanged();
        }
      };
    }
    j.acEnrollList(this.a.getViewContext(), this.c, 10, this.b, this.g);
  }
  
  public b.b getView()
  {
    return this.a;
  }
  
  public boolean isViewActive()
  {
    return (this.a != null) && (this.a.isActive());
  }
  
  public void setState(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void start()
  {
    this.c = 1;
    this.e = true;
    if (this.h != null) {
      this.h.clear();
    }
    this.i = new com.ziroom.ziroomcustomer.social.a.a(this.a.getViewContext(), this.h);
    this.i.setRefreshListener(new a.a()
    {
      public void refresh()
      {
        c.this.start();
      }
    });
    this.a.setReclyclerViewAdapter(this.i);
    getData();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */