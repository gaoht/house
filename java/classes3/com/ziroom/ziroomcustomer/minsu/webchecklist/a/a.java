package com.ziroom.ziroomcustomer.minsu.webchecklist.a;

import android.app.Activity;
import com.freelxl.baselibrary.d.f.d;
import com.ziroom.ziroomcustomer.flux.b;
import com.ziroom.ziroomcustomer.minsu.f.s;

public class a
{
  private static a b;
  final b a;
  
  private a(b paramb)
  {
    this.a = paramb;
  }
  
  public static a getInstance(b paramb)
  {
    if (b == null) {
      b = new a(paramb);
    }
    return b;
  }
  
  public void getCheckListData(final Object paramObject, Activity paramActivity)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getCheckListData(paramActivity, new s(paramActivity, new d(com.ziroom.ziroomcustomer.minsu.webchecklist.c.a.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("checklist_getdata_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.minsu.webchecklist.c.a paramAnonymousa)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousa);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("checklist_getdata", paramAnonymousa), paramObject);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/webchecklist/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */