package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.string.a;

public class aq
{
  private static int a = 8;
  private byte[] b = new byte['Ā'];
  private int c = 0;
  private int d = 0;
  private int e = 64870;
  
  public static int a(byte paramByte)
  {
    if (paramByte >= 0) {
      return paramByte;
    }
    return paramByte + 256;
  }
  
  public static String a(byte[] paramArrayOfByte, String paramString)
  {
    return String.valueOf(a.a(a(paramArrayOfByte, paramString.getBytes())));
  }
  
  private void a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int j = 0;
    int k = paramArrayOfByte.length;
    int i = 0;
    while (i < 256)
    {
      this.b[i] = ((byte)i);
      i += 1;
    }
    this.d = 0;
    for (this.c = 0; this.c < paramInt; this.c += 1)
    {
      this.d = ((this.d + a(this.b[this.c]) + a(paramArrayOfByte[(this.c % k)])) % 256);
      a(this.b, this.c, this.d);
    }
    if (paramInt != 256) {
      this.e = ((this.d + a(this.b[paramInt]) + a(paramArrayOfByte[(paramInt % k)])) % 256);
    }
    if (paramBoolean)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("S_").append(paramInt - 1).append(":");
      i = j;
      while (i <= paramInt)
      {
        paramArrayOfByte.append(" ").append(a(this.b[i]));
        i += 1;
      }
      paramArrayOfByte.append("   j_").append(paramInt - 1).append("=").append(this.d);
      paramArrayOfByte.append("   j_").append(paramInt).append("=").append(this.e);
      paramArrayOfByte.append("   S_").append(paramInt - 1).append("[j_").append(paramInt - 1).append("]=").append(a(this.b[this.d]));
      paramArrayOfByte.append("   S_").append(paramInt - 1).append("[j_").append(paramInt).append("]=").append(a(this.b[this.e]));
      if (this.b[1] != 0) {
        paramArrayOfByte.append("   S[1]!=0");
      }
      b.a(paramArrayOfByte.toString());
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    a(256, paramArrayOfByte, false);
  }
  
  private static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte[paramInt1];
    paramArrayOfByte[paramInt1] = paramArrayOfByte[paramInt2];
    paramArrayOfByte[paramInt2] = i;
  }
  
  public static byte[] a(String paramString1, String paramString2)
  {
    int j = 0;
    paramString1 = a.a(paramString1);
    paramString2 = paramString2.getBytes();
    byte[] arrayOfByte = new byte[paramString1.length + 1 + paramString2.length];
    int i = 0;
    while (i < paramString1.length)
    {
      arrayOfByte[i] = paramString1[i];
      i += 1;
    }
    arrayOfByte[paramString1.length] = 95;
    i = j;
    while (i < paramString2.length)
    {
      arrayOfByte[(paramString1.length + 1 + i)] = paramString2[i];
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte2.length];
    aq localaq = new aq();
    localaq.a(paramArrayOfByte1);
    localaq.b();
    int i = 0;
    while (i < paramArrayOfByte2.length)
    {
      arrayOfByte[i] = ((byte)(paramArrayOfByte2[i] ^ localaq.a()));
      i += 1;
    }
    return arrayOfByte;
  }
  
  private void b()
  {
    this.d = 0;
    this.c = 0;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, String paramString)
  {
    return a(paramArrayOfByte, a.a(paramString));
  }
  
  byte a()
  {
    this.c = ((this.c + 1) % 256);
    this.d = ((this.d + a(this.b[this.c])) % 256);
    a(this.b, this.c, this.d);
    return this.b[((a(this.b[this.c]) + a(this.b[this.d])) % 256)];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */