package cn.jiguang.f;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class h
{
  private static String a;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[3];
    Object localObject2 = "KuV\013WNrS\000Z:\006'|&=";
    int i = -1;
    int j = 0;
    Object localObject1 = arrayOfString;
    localObject2 = ((String)localObject2).toCharArray();
    int k = localObject2.length;
    int m;
    Object localObject3;
    int n;
    int i1;
    label50:
    int i2;
    label99:
    label121:
    Object localObject4;
    int i3;
    if (k <= 1)
    {
      m = 0;
      localObject3 = localObject1;
      n = j;
      localObject1 = localObject2;
      i1 = i;
      j = m;
      for (;;)
      {
        localObject2 = localObject1;
        i2 = localObject2[m];
        switch (j % 5)
        {
        default: 
          i = 99;
          localObject2[m] = ((char)(i ^ i2));
          j += 1;
          if (k != 0) {
            break label121;
          }
          m = k;
        }
      }
      i = k;
      localObject4 = localObject3;
      i3 = n;
      localObject2 = localObject1;
      i2 = i1;
    }
    for (;;)
    {
      i1 = i2;
      localObject1 = localObject2;
      n = i3;
      localObject3 = localObject4;
      k = i;
      m = j;
      if (i > j) {
        break label50;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i2)
      {
      default: 
        localObject4[i3] = localObject1;
        localObject2 = " \0328O@_\0048\025乣V鿡9\023";
        j = 1;
        i = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        j = 2;
        localObject2 = "6\000Q";
        i = 1;
        break;
      case 1: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        a = z[0];
        return;
        i = 123;
        break label99;
        i = 68;
        break label99;
        i = 100;
        break label99;
        i = 56;
        break label99;
        m = 0;
        i2 = i;
        i3 = j;
        localObject4 = localObject1;
        i = k;
        j = m;
      }
    }
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      a(localStringBuffer, paramArrayOfByte[i]);
      localStringBuffer.append(' ');
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static void a(StringBuffer paramStringBuffer, byte paramByte)
  {
    paramStringBuffer.append(z[0].charAt(paramByte >> 4 & 0xF)).append(z[0].charAt(paramByte & 0xF));
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {}
    while ((paramString.length() == 0) || (paramString.trim().length() == 0)) {
      return true;
    }
    return false;
  }
  
  public static String b(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return null;
    }
    try
    {
      Object localObject = MessageDigest.getInstance(z[2]);
      ((MessageDigest)localObject).update(paramString.getBytes());
      paramString = ((MessageDigest)localObject).digest();
      if (paramString == null) {
        return "";
      }
      localObject = new StringBuffer(paramString.length * 2);
      int i = 0;
      while (i < paramString.length)
      {
        a((StringBuffer)localObject, paramString[i]);
        i += 1;
      }
      paramString = ((StringBuffer)localObject).toString();
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString) {}
    return null;
  }
  
  public static String c(String paramString)
  {
    if (a(paramString)) {
      return "";
    }
    return Pattern.compile(z[1]).matcher(paramString).replaceAll("");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/f/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */