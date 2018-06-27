package com.ziroom.ziroomcustomer.signed.education;

import com.freelxl.baselibrary.d.b.b;
import com.freelxl.baselibrary.d.f.e;
import com.ziroom.ziroomcustomer.e.e.k;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.signed.a.k;
import com.ziroom.ziroomcustomer.ziroomstation.utils.h;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class d
  implements c.a
{
  WeakReference<c.b> a;
  List<k> b;
  
  public d(c.b paramb)
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
  
  public c.b getView()
  {
    if (this.a != null) {
      return (c.b)this.a.get();
    }
    return null;
  }
  
  public void initData(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(getView().getViewContext()));
    localHashMap.put("school_name", paramString);
    com.freelxl.baselibrary.d.a.get(q.O + e.k.e).tag(this).addHeader("Accept", "application/json; version=1").params(g.getPassportSign(localHashMap)).enqueue(new com.freelxl.baselibrary.d.c.a(new e())
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        paramAnonymousString = h.getJsonString(h.getJsonString(paramAnonymousString, "data"), "schoolList");
        d.this.b = h.parseArray(paramAnonymousString, k.class);
        if ((d.this.b != null) && (d.this.b.size() > 0))
        {
          d.this.getView().setNoResultVisiable(8);
          d.this.getView().showSchoolList(d.this.b);
          return;
        }
        d.this.getView().showSchoolList(d.this.b);
        d.this.getView().setNoResultVisiable(0);
      }
    });
  }
  
  public void start() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/education/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */