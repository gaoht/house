package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.xmpush.thrift.aa;
import com.xiaomi.xmpush.thrift.ab;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.ag;
import com.xiaomi.xmpush.thrift.ai;
import com.xiaomi.xmpush.thrift.aj;
import com.xiaomi.xmpush.thrift.al;
import com.xiaomi.xmpush.thrift.an;
import com.xiaomi.xmpush.thrift.ap;
import com.xiaomi.xmpush.thrift.aq;
import com.xiaomi.xmpush.thrift.u;
import com.xiaomi.xmpush.thrift.w;
import com.xiaomi.xmpush.thrift.x;
import java.nio.ByteBuffer;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class q
{
  private static final byte[] a = { 100, 23, 84, 114, 72, 0, 4, 97, 73, 97, 2, 52, 84, 102, 18, 32 };
  
  protected static <T extends org.apache.thrift.a<T, ?>> ab a(Context paramContext, T paramT, com.xiaomi.xmpush.thrift.a parama)
  {
    if (!parama.equals(com.xiaomi.xmpush.thrift.a.a)) {}
    for (boolean bool = true;; bool = false) {
      return a(paramContext, paramT, parama, bool, paramContext.getPackageName(), a.a(paramContext).c());
    }
  }
  
  protected static <T extends org.apache.thrift.a<T, ?>> ab a(Context paramContext, T paramT, com.xiaomi.xmpush.thrift.a parama, boolean paramBoolean, String paramString1, String paramString2)
  {
    byte[] arrayOfByte = aq.a(paramT);
    if (arrayOfByte == null)
    {
      b.a("invoke convertThriftObjectToBytes method, return null.");
      return null;
    }
    ab localab = new ab();
    paramT = arrayOfByte;
    if (paramBoolean)
    {
      paramContext = a.a(paramContext).f();
      if (TextUtils.isEmpty(paramContext))
      {
        b.a("regSecret is empty, return null");
        return null;
      }
      paramContext = com.xiaomi.channel.commonutils.string.a.a(paramContext);
    }
    try
    {
      paramT = b(paramContext, arrayOfByte);
      paramContext = new u();
      paramContext.a = 5L;
      paramContext.b = "fakeid";
      localab.a(paramContext);
      localab.a(ByteBuffer.wrap(paramT));
      localab.a(parama);
      localab.c(true);
      localab.b(paramString1);
      localab.a(paramBoolean);
      localab.a(paramString2);
      return localab;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        b.d("encryption error. ");
        paramT = arrayOfByte;
      }
    }
  }
  
  private static Cipher a(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = new SecretKeySpec(paramArrayOfByte, "AES");
    IvParameterSpec localIvParameterSpec = new IvParameterSpec(a);
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(paramInt, paramArrayOfByte, localIvParameterSpec);
    return localCipher;
  }
  
  public static org.apache.thrift.a a(Context paramContext, ab paramab)
  {
    if (paramab.c()) {}
    for (paramContext = com.xiaomi.channel.commonutils.string.a.a(a.a(paramContext).f());; paramContext = paramab.f()) {
      try
      {
        paramContext = a(paramContext, paramab.f());
        paramab = a(paramab.a(), paramab.c);
        if (paramab != null) {
          aq.a(paramab, paramContext);
        }
        return paramab;
      }
      catch (Exception paramContext)
      {
        throw new c("the aes decrypt failed.", paramContext);
      }
    }
  }
  
  private static org.apache.thrift.a a(com.xiaomi.xmpush.thrift.a parama, boolean paramBoolean)
  {
    switch (r.a[parama.ordinal()])
    {
    default: 
      return null;
    case 1: 
      return new ag();
    case 2: 
      return new an();
    case 3: 
      return new al();
    case 4: 
      return new ap();
    case 5: 
      return new aj();
    case 6: 
      return new w();
    case 7: 
      return new aa();
    case 8: 
      return new ai();
    case 9: 
      if (paramBoolean) {
        return new ae();
      }
      parama = new x();
      parama.a(true);
      return parama;
    }
    return new aa();
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return a(paramArrayOfByte1, 2).doFinal(paramArrayOfByte2);
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return a(paramArrayOfByte1, 1).doFinal(paramArrayOfByte2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/mipush/sdk/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */