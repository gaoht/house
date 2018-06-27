package com.huawei.hms.support.api.push.a.a;

import android.text.TextUtils;
import com.huawei.hms.support.api.push.a.b;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;

public abstract class a
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    if (paramArrayOfByte.length == 0) {
      return "";
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      arrayOfChar[(i * 2)] = a[((j & 0xF0) >> 4)];
      arrayOfChar[(i * 2 + 1)] = a[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static JSONArray a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (b.b()) {
        b.a("BaseUtil", "jsonString is null");
      }
    }
    do
    {
      return null;
      try
      {
        paramString = new JSONArray(paramString);
        return paramString;
      }
      catch (JSONException paramString) {}
    } while (!b.b());
    b.a("BaseUtil", "cast jsonString to jsonArray error");
    return null;
  }
  
  public static byte[] b(String paramString)
  {
    int i = 0;
    arrayOfByte = new byte[paramString.length() / 2];
    try
    {
      paramString = paramString.getBytes("UTF-8");
      while (i < arrayOfByte.length)
      {
        arrayOfByte[i] = ((byte)((byte)(Byte.decode("0x" + new String(new byte[] { paramString[(i * 2)] }, "UTF-8")).byteValue() << 4) ^ Byte.decode("0x" + new String(new byte[] { paramString[(i * 2 + 1)] }, "UTF-8")).byteValue()));
        i += 1;
      }
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException paramString)
    {
      if (b.b()) {
        b.a("BaseUtil", "hexString2ByteArray error" + paramString.getMessage());
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/huawei/hms/support/api/push/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */