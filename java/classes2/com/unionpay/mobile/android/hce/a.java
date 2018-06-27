package com.unionpay.mobile.android.hce;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public final class a
{
  public static String a(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        Object localObject = paramString2.getBytes("UTF-8");
        if (paramString1 != null)
        {
          if (paramString1.equals(""))
          {
            break label168;
            paramString2 = new DESedeKeySpec((byte[])localObject);
            paramString2 = SecretKeyFactory.getInstance("desede").generateSecret(paramString2);
            localObject = Cipher.getInstance("DESEDE/ECB/PKCS5Padding");
            ((Cipher)localObject).init(2, paramString2);
            paramString1 = ((Cipher)localObject).doFinal(paramString1);
            if (paramString1 != null) {
              return new String(paramString1, "UTF-8");
            }
          }
          else
          {
            paramString1 = paramString1.toUpperCase();
            int j = paramString1.length() / 2;
            char[] arrayOfChar = paramString1.toCharArray();
            paramString2 = new byte[j];
            int i = 0;
            paramString1 = paramString2;
            if (i >= j) {
              continue;
            }
            int k = i * 2;
            int m = (byte)"0123456789ABCDEF".indexOf(arrayOfChar[k]);
            paramString2[i] = ((byte)((byte)"0123456789ABCDEF".indexOf(arrayOfChar[(k + 1)]) | m << 4));
            i += 1;
            continue;
          }
          return "";
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return null;
      }
      label168:
      paramString1 = null;
    }
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuilder.append(0);
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString1, String paramString2)
  {
    Object localObject = null;
    try
    {
      paramString2 = paramString2.getBytes("UTF-8");
      paramString1 = paramString1.getBytes();
      paramString2 = new DESedeKeySpec(paramString2);
      paramString2 = SecretKeyFactory.getInstance("desede").generateSecret(paramString2);
      Cipher localCipher = Cipher.getInstance("desede/ECB/PKCS5Padding");
      localCipher.init(1, paramString2);
      paramString1 = localCipher.doFinal(paramString1);
      return a(paramString1);
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
        paramString1 = (String)localObject;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/hce/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */