package com.xiaomi.push.log;

import android.content.Context;
import java.io.File;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

class c
  extends b.b
{
  File a;
  
  c(b paramb, int paramInt, Date paramDate1, Date paramDate2, String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramb);
  }
  
  public void b()
  {
    if (!com.xiaomi.channel.commonutils.file.c.d()) {}
    for (;;)
    {
      return;
      try
      {
        File localFile = new File(b.a(this.h).getExternalFilesDir(null) + "/.logcache");
        localFile.mkdirs();
        if (localFile.isDirectory())
        {
          a locala = new a();
          locala.a(this.b);
          this.a = locala.a(b.a(this.h), this.c, this.d, localFile);
          return;
        }
      }
      catch (NullPointerException localNullPointerException) {}
    }
  }
  
  public void c()
  {
    if ((this.a != null) && (this.a.exists())) {
      b.b(this.h).add(new b.c(this.h, this.e, this.f, this.a, this.g));
    }
    b.a(this.h, 0L);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/log/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */