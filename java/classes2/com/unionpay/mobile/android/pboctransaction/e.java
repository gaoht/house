package com.unionpay.mobile.android.pboctransaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class e
{
  static HashMap<String, String> a = new f();
  
  private static String a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 != null)
    {
      str = paramString1;
      if (paramString2 != null)
      {
        str = paramString1;
        if (paramString1.length() > paramString2.length()) {
          for (;;)
          {
            str = paramString1;
            if (!paramString1.substring(paramString1.length() - paramString2.length(), paramString1.length()).equalsIgnoreCase(paramString2)) {
              break;
            }
            paramString1 = paramString1.substring(0, paramString1.length() - paramString2.length());
          }
        }
      }
    }
    return str;
  }
  
  public static final String a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public static final String a(byte[] paramArrayOfByte, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfByte == null) || (paramInt <= 0)) {
      return null;
    }
    int i = 0;
    while (i < paramInt)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuilder.append(0);
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString().toUpperCase();
  }
  
  private static boolean a(ArrayList<AppIdentification> paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramString == null)) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (((AppIdentification)paramArrayList.next()).a().equalsIgnoreCase(paramString)) {
        return false;
      }
    }
    return true;
  }
  
  public static final byte[] a(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      paramString = null;
      return paramString;
    }
    paramString = paramString.toUpperCase();
    int j = paramString.length() / 2;
    char[] arrayOfChar = paramString.toCharArray();
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    for (;;)
    {
      paramString = arrayOfByte;
      if (i >= j) {
        break;
      }
      int k = i * 2;
      int m = (byte)"0123456789ABCDEF".indexOf(arrayOfChar[k]);
      arrayOfByte[i] = ((byte)((byte)"0123456789ABCDEF".indexOf(arrayOfChar[(k + 1)]) | m << 4));
      i += 1;
    }
  }
  
  public static final ArrayList<AppIdentification> b(String paramString)
  {
    int j = 0;
    if ((paramString != null) && (paramString.length() > 4))
    {
      ArrayList localArrayList = new ArrayList();
      String str1 = paramString.substring(paramString.length() - 4);
      if ((str1 != null) && (str1.equalsIgnoreCase("9000")))
      {
        str1 = paramString.substring(0, paramString.length() - 4);
        if ((str1 != null) && (str1.length() > 0) && (j != -1))
        {
          paramString = "";
          j = str1.indexOf("61", j);
          if (j != -1)
          {
            String str2 = str1.substring(j + 2, j + 4);
            String str3 = str1.substring(j + 4, j + 6);
            if (j + 6 + Integer.parseInt(str3, 16) * 2 < str1.length()) {
              paramString = str1.substring(j + 6, Integer.parseInt(str3, 16) * 2 + (j + 6));
            }
            int i = Integer.parseInt(str2, 16) * 2 + (j + 2);
            if (i <= str1.length()) {}
            for (;;)
            {
              paramString = paramString.trim();
              j = i;
              if (paramString.length() <= 8) {
                break;
              }
              j = i;
              if (paramString.equalsIgnoreCase("A0000003334355502D4D4F42494C45")) {
                break;
              }
              j = i;
              if (!a(localArrayList, paramString)) {
                break;
              }
              localArrayList.add(new AppIdentification(paramString, null));
              j = i;
              break;
              i = j + 2;
            }
          }
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public static String c(String paramString)
  {
    return a(paramString, "F");
  }
  
  public static String d(String paramString)
  {
    return a(paramString, "00");
  }
  
  public static String e(String paramString)
  {
    if (a.containsKey(paramString)) {
      return (String)a.get(paramString);
    }
    return "";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pboctransaction/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */