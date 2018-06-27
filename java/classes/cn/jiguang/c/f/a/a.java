package cn.jiguang.c.f.a;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a
{
  private static String a;
  private static int b;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[7];
    int j = 0;
    Object localObject2 = "K\005\020\024>H\003lk6I\023vk\034n$*U\032";
    int i = -1;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int k = arrayOfChar.length;
    int i1 = 0;
    int m = 0;
    int i3 = i;
    localObject2 = arrayOfChar;
    int i4 = j;
    Object localObject3 = localObject1;
    int n = k;
    Object localObject4;
    int i2;
    if (k <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i2 = i;
      label68:
      n = m;
      label71:
      localObject2 = localObject1;
      i1 = localObject2[m];
      switch (n % 5)
      {
      default: 
        i = 125;
      }
    }
    for (;;)
    {
      localObject2[m] = ((char)(i ^ i1));
      n += 1;
      if (k == 0)
      {
        m = k;
        break label71;
      }
      i1 = n;
      n = k;
      localObject3 = localObject4;
      i4 = j;
      localObject2 = localObject1;
      i3 = i2;
      i2 = i3;
      localObject1 = localObject2;
      j = i4;
      localObject4 = localObject3;
      k = n;
      m = i1;
      if (n > i1) {
        break label68;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i3)
      {
      default: 
        localObject3[i4] = localObject1;
        j = 1;
        localObject2 = "K\005\020";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "K\023\000r4";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "4%\026E";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "K\005\020\0248I\002lk6I\023tk\034n$*U\032";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "@\003\bk";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "K\005\020\0248I\002lu\022Z!'_\024d'";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        a = "";
        b = 0;
        return;
        i = 10;
        continue;
        i = 64;
        continue;
        i = 67;
        continue;
        i = 59;
      }
    }
  }
  
  public static String a()
  {
    return a;
  }
  
  private static String a(long paramLong)
  {
    String str2 = String.valueOf(paramLong);
    int i = str2.length();
    String str1 = str2;
    if (i >= 2) {
      str1 = str2.substring(i - 2, i);
    }
    switch (Integer.parseInt(str1) % 10)
    {
    default: 
      paramLong = 8L * paramLong + paramLong % 74L;
    }
    for (;;)
    {
      str1 = cn.jiguang.f.a.a(z[5] + String.valueOf(paramLong));
      a = str1;
      return str1;
      paramLong = 5L * paramLong + paramLong % 88L;
      continue;
      paramLong = 23L * paramLong + paramLong % 15L;
      continue;
      paramLong = 3L * paramLong + paramLong % 73L;
      continue;
      paramLong = 13L * paramLong + paramLong % 96L;
      continue;
      paramLong = 17L * paramLong + paramLong % 49L;
      continue;
      paramLong = 7L * paramLong + paramLong % 68L;
      continue;
      paramLong = 31L * paramLong + paramLong % 39L;
      continue;
      paramLong = 29L * paramLong + paramLong % 41L;
      continue;
      paramLong = 37L * paramLong + paramLong % 91L;
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (paramString2.length() != 16) {
      return null;
    }
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString2.getBytes(), z[1]);
    Cipher localCipher = Cipher.getInstance(z[0]);
    localCipher.init(1, localSecretKeySpec, new IvParameterSpec(paramString2.getBytes()));
    return Base64.encodeToString(localCipher.doFinal(paramString1.getBytes()), 2);
  }
  
  public static void a(int paramInt)
  {
    b = paramInt;
  }
  
  public static byte[] a(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      paramString = new SecretKeySpec(paramString.getBytes(z[3]), z[1]);
      Cipher localCipher = Cipher.getInstance(z[6]);
      localCipher.init(2, paramString);
      paramString = localCipher.doFinal(paramArrayOfByte);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte.length - 24;
    byte[] arrayOfByte1 = new byte[24];
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, 24);
    System.arraycopy(paramArrayOfByte, 24, arrayOfByte2, 0, i);
    paramArrayOfByte = "";
    if (paramInt == 1) {
      paramArrayOfByte = a(cn.jiguang.c.a.a.r());
    }
    for (;;)
    {
      try
      {
        paramArrayOfByte = new SecretKeySpec(paramArrayOfByte.getBytes(z[3]), z[1]);
        Cipher localCipher = Cipher.getInstance(z[4]);
        localCipher.init(1, paramArrayOfByte);
        arrayOfByte2 = localCipher.doFinal(arrayOfByte2);
        paramInt = arrayOfByte2.length + 24;
        paramArrayOfByte = new byte[paramInt];
      }
      catch (Exception localException1)
      {
        paramArrayOfByte = null;
      }
      try
      {
        System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, 0, 24);
        System.arraycopy(arrayOfByte2, 0, paramArrayOfByte, 24, arrayOfByte2.length);
        paramArrayOfByte[0] = ((byte)(paramInt >>> 8 & 0xFF));
        paramArrayOfByte[1] = ((byte)(paramInt & 0xFF));
        paramArrayOfByte[0] = ((byte)(paramArrayOfByte[0] | 0x80));
        return paramArrayOfByte;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
      if (paramInt == 0) {
        paramArrayOfByte = a(b);
      }
    }
    localException1.printStackTrace();
    return paramArrayOfByte;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    if (paramString2 == null) {}
    for (;;)
    {
      return null;
      try
      {
        if (paramString2.length() != 16) {
          continue;
        }
        SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString2.getBytes(z[2]), z[1]);
        Cipher localCipher = Cipher.getInstance(z[0]);
        localCipher.init(2, localSecretKeySpec, new IvParameterSpec(paramString2.getBytes()));
        paramString1 = Base64.decode(paramString1, 2);
        return null;
      }
      catch (Exception paramString1)
      {
        try
        {
          paramString1 = new String(localCipher.doFinal(paramString1));
          return paramString1;
        }
        catch (Exception paramString1) {}
        paramString1 = paramString1;
        return null;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/f/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */