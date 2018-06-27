package com.unionpay.mobile.android.hce;

import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.unionpay.mobile.android.utils.j;
import java.util.concurrent.ConcurrentHashMap;

final class g
  implements Handler.Callback
{
  g(f paramf) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      f.a(this.a);
      this.a.b();
      continue;
      paramMessage = (String)paramMessage.obj;
      f.a(this.a, paramMessage);
      continue;
      paramMessage = (Bundle)paramMessage.obj;
      if (paramMessage != null)
      {
        Object localObject = paramMessage.getString("pkgName");
        boolean bool = paramMessage.getBoolean("success");
        String str1 = paramMessage.getString("result");
        String str2 = paramMessage.getString("reserved");
        j.c("yitong", "result: " + str1);
        d locald = (d)f.b(this.a).get(localObject);
        paramMessage = locald;
        if (locald == null) {
          paramMessage = new d((String)localObject);
        }
        if (bool)
        {
          paramMessage.a(str1);
          paramMessage.b(str2);
        }
        paramMessage.e();
        f.b(this.a).put(localObject, paramMessage);
        f.a(this.a, (String)localObject);
        continue;
        paramMessage = (String)paramMessage.obj;
        locald = (d)f.b(this.a).get(paramMessage);
        localObject = (l)f.c(this.a).get(paramMessage);
        locald.f();
        f.b(this.a).put(paramMessage, locald);
        ((l)localObject).e();
        f.c(this.a).put(paramMessage, localObject);
        f.a(this.a, paramMessage);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/hce/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */