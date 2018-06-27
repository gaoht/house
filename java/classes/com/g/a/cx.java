package com.g.a;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

final class cx
{
  static void a(Activity paramActivity, a parama)
  {
    try
    {
      if (parama.b().equals("APP"))
      {
        if ((i.d(parama) != null) && (i.d(parama).equals("2"))) {
          z.execute(new cy(parama));
        }
        i.b("0", parama);
        aw.b().removeMessages(0);
        if ((paramActivity != null) && ((paramActivity.getChangingConfigurations() & 0x80) == 128))
        {
          h.iForDeveloper("Ignore page changing during screen switch");
          db.l = true;
          return;
        }
      }
      z.execute(new cz(parama));
      return;
    }
    catch (Throwable paramActivity)
    {
      av.postSDKError(paramActivity);
    }
  }
  
  static void b(Activity paramActivity, a parama)
  {
    try
    {
      if ((parama.b().equals("APP")) || (parama.b().equals("APP_SQL")))
      {
        i.b("1", parama);
        aw.b().removeMessages(0);
        Message localMessage = Message.obtain();
        localMessage.obj = parama;
        localMessage.what = 0;
        aw.b().sendMessageDelayed(localMessage, c.p);
      }
      z.execute(new da(parama, paramActivity));
      return;
    }
    catch (Throwable paramActivity)
    {
      av.postSDKError(paramActivity);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */