package com.mato.sdk.d;

import android.text.TextUtils;
import org.json.JSONObject;

public class k
{
  private static final int a = -1;
  private static final String b = "md5";
  private static final String c = "networkType";
  private static final String d = "fetchUrl";
  private static final String e = "http://mauth.chinanetcenter.com/frontoffice/precacheConfig";
  private final String f;
  private final int g;
  private final String h;
  
  private k()
  {
    throw new AssertionError();
  }
  
  private k(String paramString1, int paramInt, String paramString2)
  {
    this.f = paramString1;
    this.g = paramInt;
    this.h = paramString2;
  }
  
  public static k a(JSONObject paramJSONObject)
  {
    String str2 = paramJSONObject.optString("md5", "");
    int i = paramJSONObject.optInt("networkType", -1);
    String str1 = c.a(paramJSONObject, "fetchUrl", true);
    paramJSONObject = str1;
    if (str1 == null) {
      paramJSONObject = "http://mauth.chinanetcenter.com/frontoffice/precacheConfig";
    }
    return new k(str2, i, paramJSONObject);
  }
  
  private static String a(Object paramObject)
  {
    if (paramObject == null) {
      return "";
    }
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    return paramObject.toString();
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != paramObject2)
    {
      if (paramObject1 != null) {
        break label15;
      }
      if (paramObject2 != null) {
        break label23;
      }
    }
    label15:
    while (paramObject1.equals(paramObject2)) {
      return true;
    }
    label23:
    return false;
  }
  
  private static int[] a(Integer[] paramArrayOfInteger)
  {
    int[] arrayOfInt = new int[paramArrayOfInteger.length];
    int i = 0;
    while (i < paramArrayOfInteger.length)
    {
      arrayOfInt[i] = paramArrayOfInteger[i].intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  private static long[] a(Long[] paramArrayOfLong)
  {
    long[] arrayOfLong = new long[paramArrayOfLong.length];
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      arrayOfLong[i] = paramArrayOfLong[i].longValue();
      i += 1;
    }
    return arrayOfLong;
  }
  
  public static Integer[] a(int[] paramArrayOfInt)
  {
    Integer[] arrayOfInteger = new Integer[paramArrayOfInt.length];
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      arrayOfInteger[i] = Integer.valueOf(paramArrayOfInt[i]);
      i += 1;
    }
    return arrayOfInteger;
  }
  
  public static Long[] a(long[] paramArrayOfLong)
  {
    Long[] arrayOfLong = new Long[paramArrayOfLong.length];
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      arrayOfLong[i] = Long.valueOf(paramArrayOfLong[i]);
      i += 1;
    }
    return arrayOfLong;
  }
  
  private static <V> int b(V paramV1, V paramV2)
  {
    if (paramV1 == null)
    {
      if (paramV2 == null) {
        return 0;
      }
      return -1;
    }
    if (paramV2 == null) {
      return 1;
    }
    return ((Comparable)paramV1).compareTo(paramV2);
  }
  
  public final String a()
  {
    return this.f;
  }
  
  public final int b()
  {
    return this.g;
  }
  
  public final String c()
  {
    return this.h;
  }
  
  public final boolean d()
  {
    return (!TextUtils.isEmpty(this.f)) && (this.g != -1) && (!TextUtils.isEmpty(this.h));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/d/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */