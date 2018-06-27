package com.xiaomi.mipush.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.push.service.ao;

class w
  extends ContentObserver
{
  w(u paramu, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean)
  {
    u.a(this.a, Integer.valueOf(ao.a(u.a(this.a)).b()));
    if (u.b(this.a).intValue() != 0)
    {
      u.a(this.a).getContentResolver().unregisterContentObserver(this);
      if (d.d(u.a(this.a))) {
        this.a.d();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/mipush/sdk/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */