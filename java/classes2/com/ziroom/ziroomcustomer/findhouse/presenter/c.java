package com.ziroom.ziroomcustomer.findhouse.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.ziroom.ziroomcustomer.e.a.e;
import com.ziroom.ziroomcustomer.e.c.q;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail;
import java.lang.ref.WeakReference;

public class c
  implements a.a
{
  private WeakReference<a.b> a;
  private RentHouseDetail b;
  private String c;
  private String d;
  
  public c(String paramString1, String paramString2, RentHouseDetail paramRentHouseDetail, a.b paramb)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.b = paramRentHouseDetail;
    this.a = new WeakReference(paramb);
    paramb.setPresenter(this);
  }
  
  public void detachView()
  {
    a.b localb = getView();
    if (localb != null) {
      com.freelxl.baselibrary.d.a.cancel(localb.getViewContext());
    }
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
  
  public void initData()
  {
    a.b localb;
    if (this.b != null)
    {
      localb = getView();
      if ((localb != null) && (localb.isActive())) {
        localb.initWithData(this.b);
      }
    }
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(this.c)) || (TextUtils.isEmpty(this.d)));
      localb = getView();
    } while ((localb == null) || (!localb.isActive()));
    e local1 = new e(localb.getViewContext(), new q(RentHouseDetail.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        paramAnonymousThrowable = c.this.getView();
        if ((paramAnonymousThrowable != null) && (paramAnonymousThrowable.isActive())) {
          paramAnonymousThrowable.showError();
        }
      }
      
      public void onSuccess(int paramAnonymousInt, RentHouseDetail paramAnonymousRentHouseDetail)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousRentHouseDetail);
        c.a(c.this, paramAnonymousRentHouseDetail);
        a.b localb = c.this.getView();
        if ((localb != null) && (localb.isActive())) {
          localb.initWithData(paramAnonymousRentHouseDetail);
        }
      }
    };
    j.getRentHouseDetail(localb.getViewContext(), this.c, this.d, local1);
  }
  
  public void start() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/presenter/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */