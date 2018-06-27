package com.g.a;

import android.content.Context;
import java.util.Calendar;

final class bg
  implements Runnable
{
  public void run()
  {
    try
    {
      if (!r.c(c.e)) {
        return;
      }
      if (bf.c())
      {
        j.a("https://i.tddmp.com/a/" + l.a(c.e), "", false);
        Calendar localCalendar = Calendar.getInstance();
        Context localContext = c.e;
        int i = localCalendar.get(6);
        v.a(localContext, "TD_app_pefercen_profile", "TD_sdk_last_send_time", localCalendar.get(3) + i * 1000);
        return;
      }
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */