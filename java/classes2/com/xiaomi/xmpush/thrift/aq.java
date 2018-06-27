package com.xiaomi.xmpush.thrift;

import android.content.Context;
import com.xiaomi.channel.commonutils.android.b.a;
import com.xiaomi.push.service.ay;
import org.apache.thrift.a;
import org.apache.thrift.f;
import org.apache.thrift.g;
import org.apache.thrift.protocol.a.a;
import org.apache.thrift.protocol.k.a;

public class aq
{
  public static short a(Context paramContext, ab paramab)
  {
    int k = 0;
    int m = com.xiaomi.channel.commonutils.android.b.d(paramContext, paramab.f).a();
    int i;
    if (com.xiaomi.channel.commonutils.misc.e.b(paramContext))
    {
      i = 4;
      if (!com.xiaomi.channel.commonutils.misc.e.a(paramContext)) {
        break label65;
      }
    }
    label65:
    for (int j = 8;; j = 0)
    {
      if (ay.a(paramContext, paramab)) {
        k = 16;
      }
      return (short)(j + (0 + m + i) + k);
      i = 0;
      break;
    }
  }
  
  public static short a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int k = 0;
    int i;
    if (paramBoolean1)
    {
      i = 4;
      if (!paramBoolean2) {
        break label39;
      }
    }
    label39:
    for (int j = 2;; j = 0)
    {
      if (paramBoolean3) {
        k = 1;
      }
      return (short)(k + (j + (0 + i)));
      i = 0;
      break;
    }
  }
  
  public static <T extends a<T, ?>> void a(T paramT, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new f("the message byte is empty.");
    }
    new org.apache.thrift.e(new k.a(true, true, paramArrayOfByte.length)).a(paramT, paramArrayOfByte);
  }
  
  public static <T extends a<T, ?>> byte[] a(T paramT)
  {
    if (paramT == null) {
      return null;
    }
    try
    {
      paramT = new g(new a.a()).a(paramT);
      return paramT;
    }
    catch (f paramT)
    {
      com.xiaomi.channel.commonutils.logger.b.a("convertThriftObjectToBytes catch TException.", paramT);
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */