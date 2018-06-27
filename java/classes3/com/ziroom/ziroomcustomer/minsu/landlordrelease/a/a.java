package com.ziroom.ziroomcustomer.minsu.landlordrelease.a;

import android.app.Activity;
import android.content.Context;
import com.ziroom.ziroomcustomer.minsu.landlord.d.c;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLDaysEditInitBean;
import java.util.List;

public class a
{
  private static a b;
  final com.ziroom.ziroomcustomer.flux.b a;
  
  private a(com.ziroom.ziroomcustomer.flux.b paramb)
  {
    this.a = paramb;
  }
  
  public static a getInstance(com.ziroom.ziroomcustomer.flux.b paramb)
  {
    if (b == null) {
      b = new a(paramb);
    }
    return b;
  }
  
  public void initLLCalendarEdit(final Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt, List<String> paramList)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.initLLCalendarEdit(paramActivity, paramString1, paramString2, paramString3, paramInt, paramList, new com.ziroom.ziroomcustomer.minsu.landlord.d.a(paramActivity, new com.ziroom.ziroomcustomer.minsu.landlord.d.b(LLDaysEditInitBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("CalendarEditInitError", paramAnonymousThrowable.getMessage()), paramActivity);
      }
      
      public void onSuccess(int paramAnonymousInt, LLDaysEditInitBean paramAnonymousLLDaysEditInitBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousLLDaysEditInitBean);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("CalendarEditInit", paramAnonymousLLDaysEditInitBean), paramActivity);
      }
    });
  }
  
  public void saveLLCalendarEdit(final Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt, List<String> paramList, Integer paramInteger1, Integer paramInteger2)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.saveLLCalendarEdit(paramActivity, paramString1, paramString2, paramString3, paramInt, paramList, paramInteger1, paramInteger2, new com.ziroom.ziroomcustomer.minsu.landlord.d.a(paramActivity, new c(String.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("CalendarEditSaveError", paramAnonymousThrowable.getMessage()), paramActivity);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("CalendarEditSave", paramAnonymousString), paramActivity);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */