package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.umeng.analytics.AnalyticsConfig;
import java.io.File;
import org.json.JSONObject;

public class aa
{
  private final byte[] a = { 0, 0, 0, 0, 0, 0, 0, 0 };
  private final int b = 1;
  private final int c = 0;
  private String d = "1.0";
  private String e = null;
  private byte[] f = null;
  private byte[] g = null;
  private byte[] h = null;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  private byte[] l = null;
  private byte[] m = null;
  private boolean n = false;
  
  private aa(byte[] paramArrayOfByte1, String paramString, byte[] paramArrayOfByte2)
    throws Exception
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0)) {
      throw new Exception("entity is null or empty");
    }
    this.e = paramString;
    this.k = paramArrayOfByte1.length;
    this.l = bu.a(paramArrayOfByte1);
    this.j = ((int)(System.currentTimeMillis() / 1000L));
    this.m = paramArrayOfByte2;
  }
  
  public static aa a(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      String str2 = bv.q(paramContext);
      String str3 = bv.c(paramContext);
      SharedPreferences localSharedPreferences = ba.a(paramContext);
      String str1 = localSharedPreferences.getString("signature", null);
      int i1 = localSharedPreferences.getInt("serial", 1);
      paramString = new aa(paramArrayOfByte, paramString, (str3 + str2).getBytes());
      paramString.a(str1);
      paramString.a(i1);
      paramString.b();
      localSharedPreferences.edit().putInt("serial", i1 + 1).putString("signature", paramString.a()).commit();
      paramString.b(paramContext);
      return paramString;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static String a(Context paramContext)
  {
    paramContext = ba.a(paramContext);
    if (paramContext == null) {
      return null;
    }
    return paramContext.getString("signature", null);
  }
  
  private byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int i6 = 0;
    byte[] arrayOfByte1 = bt.b(this.m);
    byte[] arrayOfByte2 = bt.b(this.l);
    int i7 = arrayOfByte1.length;
    byte[] arrayOfByte3 = new byte[i7 * 2];
    int i5 = 0;
    while (i5 < i7)
    {
      arrayOfByte3[(i5 * 2)] = arrayOfByte2[i5];
      arrayOfByte3[(i5 * 2 + 1)] = arrayOfByte1[i5];
      i5 += 1;
    }
    i5 = 0;
    while (i5 < 2)
    {
      arrayOfByte3[i5] = paramArrayOfByte[i5];
      arrayOfByte3[(arrayOfByte3.length - i5 - 1)] = paramArrayOfByte[(paramArrayOfByte.length - i5 - 1)];
      i5 += 1;
    }
    int i1 = (byte)(paramInt & 0xFF);
    int i2 = (byte)(paramInt >> 8 & 0xFF);
    int i3 = (byte)(paramInt >> 16 & 0xFF);
    int i4 = (byte)(paramInt >>> 24);
    paramInt = i6;
    while (paramInt < arrayOfByte3.length)
    {
      arrayOfByte3[paramInt] = ((byte)(arrayOfByte3[paramInt] ^ new byte[] { i1, i2, i3, i4 }[(paramInt % 4)]));
      paramInt += 1;
    }
    return arrayOfByte3;
  }
  
  public static aa b(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      String str2 = bv.q(paramContext);
      String str3 = bv.c(paramContext);
      SharedPreferences localSharedPreferences = ba.a(paramContext);
      String str1 = localSharedPreferences.getString("signature", null);
      int i1 = localSharedPreferences.getInt("serial", 1);
      paramString = new aa(paramArrayOfByte, paramString, (str3 + str2).getBytes());
      paramString.a(true);
      paramString.a(str1);
      paramString.a(i1);
      paramString.b();
      localSharedPreferences.edit().putInt("serial", i1 + 1).putString("signature", paramString.a()).commit();
      paramString.b(paramContext);
      return paramString;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  private byte[] d()
  {
    return a(this.a, (int)(System.currentTimeMillis() / 1000L));
  }
  
  private byte[] e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(bt.a(this.f));
    localStringBuilder.append(this.i);
    localStringBuilder.append(this.j);
    localStringBuilder.append(this.k);
    localStringBuilder.append(bt.a(this.g));
    return bt.b(localStringBuilder.toString().getBytes());
  }
  
  public String a()
  {
    return bt.a(this.f);
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a(String paramString)
  {
    this.f = bt.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void b()
  {
    if (this.f == null) {
      this.f = d();
    }
    byte[] arrayOfByte;
    if (this.n) {
      arrayOfByte = new byte[16];
    }
    try
    {
      System.arraycopy(this.f, 1, arrayOfByte, 0, 16);
      this.l = bt.a(this.l, arrayOfByte);
      this.g = a(this.f, this.j);
      this.h = e();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void b(Context paramContext)
  {
    String str1 = this.e;
    String str2 = af.a(paramContext).b().g(null);
    Object localObject1 = bt.a(this.f);
    Object localObject2 = new byte[16];
    System.arraycopy(this.f, 2, localObject2, 0, 16);
    String str3 = bt.a(bt.b((byte[])localObject2));
    try
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("appkey", str1);
      if (str2 != null) {
        ((JSONObject)localObject2).put("umid", str2);
      }
      ((JSONObject)localObject2).put("signature", localObject1);
      ((JSONObject)localObject2).put("checksum", str3);
      localObject1 = new File(paramContext.getFilesDir(), ".umeng");
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdir();
      }
      bw.a(new File((File)localObject1, "exchangeIdentity.json"), ((JSONObject)localObject2).toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("appkey", str1);
          ((JSONObject)localObject1).put("channel", AnalyticsConfig.getChannel(paramContext));
          if (str2 != null) {
            ((JSONObject)localObject1).put("umid", bw.b(str2));
          }
          bw.a(new File(paramContext.getFilesDir(), "exid.dat"), ((JSONObject)localObject1).toString());
          return;
        }
        catch (Throwable paramContext)
        {
          paramContext.printStackTrace();
        }
        localThrowable = localThrowable;
        localThrowable.printStackTrace();
      }
    }
  }
  
  public byte[] c()
  {
    Object localObject = new bq();
    ((bq)localObject).a(this.d);
    ((bq)localObject).b(this.e);
    ((bq)localObject).c(bt.a(this.f));
    ((bq)localObject).a(this.i);
    ((bq)localObject).c(this.j);
    ((bq)localObject).d(this.k);
    ((bq)localObject).a(this.l);
    if (this.n) {}
    for (int i1 = 1;; i1 = 0)
    {
      ((bq)localObject).e(i1);
      ((bq)localObject).d(bt.a(this.g));
      ((bq)localObject).e(bt.a(this.h));
      try
      {
        localObject = new cp().a((cg)localObject);
        return (byte[])localObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return null;
  }
  
  public String toString()
  {
    int i1 = 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("version : %s\n", new Object[] { this.d }));
    localStringBuilder.append(String.format("address : %s\n", new Object[] { this.e }));
    localStringBuilder.append(String.format("signature : %s\n", new Object[] { bt.a(this.f) }));
    localStringBuilder.append(String.format("serial : %s\n", new Object[] { Integer.valueOf(this.i) }));
    localStringBuilder.append(String.format("timestamp : %d\n", new Object[] { Integer.valueOf(this.j) }));
    localStringBuilder.append(String.format("length : %d\n", new Object[] { Integer.valueOf(this.k) }));
    localStringBuilder.append(String.format("guid : %s\n", new Object[] { bt.a(this.g) }));
    localStringBuilder.append(String.format("checksum : %s ", new Object[] { bt.a(this.h) }));
    if (this.n) {}
    for (;;)
    {
      localStringBuilder.append(String.format("codex : %d", new Object[] { Integer.valueOf(i1) }));
      return localStringBuilder.toString();
      i1 = 0;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */