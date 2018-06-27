package com.baidu.trace.b;

import android.os.Handler;
import android.os.Message;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class a
{
  private static a a = a.a;
  private static b b = null;
  
  public static a a()
  {
    return a;
  }
  
  public static void a(a parama, e parame)
  {
    a = parama;
    if (a.a == parama)
    {
      if (b != null)
      {
        b.a();
        if ((b instanceof k)) {
          b = null;
        }
      }
      else
      {
        b = j.e();
      }
      b.a(parame);
    }
    while (a.b != parama) {
      return;
    }
    int i;
    if (b != null)
    {
      b.a();
      if ((b instanceof j))
      {
        i = b.c();
        b = null;
      }
    }
    for (b = k.a(i);; b = k.a(8300))
    {
      b.a(parame);
      return;
    }
  }
  
  public static void a(byte[] paramArrayOfByte, Handler paramHandler)
  {
    for (;;)
    {
      try
      {
        boolean bool = d();
        if (bool) {
          try
          {
            b.a(paramArrayOfByte);
            return;
          }
          catch (Exception paramArrayOfByte)
          {
            paramArrayOfByte = paramArrayOfByte;
            if (paramHandler == null) {
              continue;
            }
            paramHandler.obtainMessage(4).sendToTarget();
            continue;
          }
          finally {}
        }
        if (paramHandler == null) {
          continue;
        }
      }
      finally {}
      paramHandler.obtainMessage(4).sendToTarget();
    }
  }
  
  public static b b()
  {
    return b;
  }
  
  protected static DataInputStream c()
    throws IOException
  {
    try
    {
      if (d())
      {
        Object localObject1 = b.d();
        if (localObject1 != null) {}
        for (localObject1 = new DataInputStream((InputStream)localObject1);; localObject1 = null) {
          return (DataInputStream)localObject1;
        }
      }
      throw new IOException();
    }
    finally {}
  }
  
  public static boolean d()
  {
    if (b == null) {
      return false;
    }
    try
    {
      boolean bool = b.b();
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static void e()
  {
    if (b != null) {
      b.a();
    }
  }
  
  public static enum a
  {
    static
    {
      a locala = a;
      locala = b;
    }
    
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */