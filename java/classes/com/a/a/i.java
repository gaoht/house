package com.a.a;

import com.a.a.a.v;

public class i
{
  public static void appendProperties(e parame1, e parame2, boolean paramBoolean1, boolean paramBoolean2)
    throws c
  {
    appendProperties(parame1, parame2, paramBoolean1, paramBoolean2, false);
  }
  
  public static void appendProperties(e parame1, e parame2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    throws c
  {
    v.appendProperties(parame1, parame2, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public static String catenateArrayItems(e parame, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
    throws c
  {
    return v.catenateArrayItems(parame, paramString1, paramString2, paramString3, paramString4, paramBoolean);
  }
  
  public static String convertFromBoolean(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "True";
    }
    return "False";
  }
  
  public static String convertFromDate(a parama)
  {
    return com.a.a.a.e.render(parama);
  }
  
  public static String convertFromDouble(double paramDouble)
  {
    return String.valueOf(paramDouble);
  }
  
  public static String convertFromInteger(int paramInt)
  {
    return String.valueOf(paramInt);
  }
  
  public static String convertFromLong(long paramLong)
  {
    return String.valueOf(paramLong);
  }
  
  public static boolean convertToBoolean(String paramString)
    throws c
  {
    boolean bool = false;
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new c("Empty convert-string", 5);
    }
    paramString = paramString.toLowerCase();
    try
    {
      int i = Integer.parseInt(paramString);
      return i != 0;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (("true".equals(paramString)) || ("t".equals(paramString)) || ("on".equals(paramString)) || ("yes".equals(paramString))) {
        bool = true;
      }
    }
    return bool;
  }
  
  public static a convertToDate(String paramString)
    throws c
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new c("Empty convert-string", 5);
    }
    return com.a.a.a.e.parse(paramString);
  }
  
  public static double convertToDouble(String paramString)
    throws c
  {
    if (paramString != null) {}
    try
    {
      if (paramString.length() == 0) {
        throw new c("Empty convert-string", 5);
      }
    }
    catch (NumberFormatException paramString)
    {
      throw new c("Invalid double string", 5);
    }
    double d = Double.parseDouble(paramString);
    return d;
  }
  
  public static int convertToInteger(String paramString)
    throws c
  {
    if (paramString != null) {}
    try
    {
      if (paramString.length() == 0) {
        throw new c("Empty convert-string", 5);
      }
    }
    catch (NumberFormatException paramString)
    {
      throw new c("Invalid integer string", 5);
    }
    if (paramString.startsWith("0x")) {
      return Integer.parseInt(paramString.substring(2), 16);
    }
    int i = Integer.parseInt(paramString);
    return i;
  }
  
  public static long convertToLong(String paramString)
    throws c
  {
    if (paramString != null) {}
    try
    {
      if (paramString.length() == 0) {
        throw new c("Empty convert-string", 5);
      }
    }
    catch (NumberFormatException paramString)
    {
      throw new c("Invalid long string", 5);
    }
    if (paramString.startsWith("0x")) {
      return Long.parseLong(paramString.substring(2), 16);
    }
    long l = Long.parseLong(paramString);
    return l;
  }
  
  public static byte[] decodeBase64(String paramString)
    throws c
  {
    try
    {
      paramString = com.a.a.a.a.decode(paramString.getBytes());
      return paramString;
    }
    catch (Throwable paramString)
    {
      throw new c("Invalid base64 string", 5, paramString);
    }
  }
  
  public static String encodeBase64(byte[] paramArrayOfByte)
  {
    return new String(com.a.a.a.a.encode(paramArrayOfByte));
  }
  
  public static void removeProperties(e parame, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
    throws c
  {
    v.removeProperties(parame, paramString1, paramString2, paramBoolean1, paramBoolean2);
  }
  
  public static void separateArrayItems(e parame, String paramString1, String paramString2, String paramString3, com.a.a.b.e parame1, boolean paramBoolean)
    throws c
  {
    v.separateArrayItems(parame, paramString1, paramString2, paramString3, parame1, paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */