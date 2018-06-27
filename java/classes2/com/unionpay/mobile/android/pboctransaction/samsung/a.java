package com.unionpay.mobile.android.pboctransaction.samsung;

import android.text.TextUtils;
import com.unionpay.mobile.android.pboctransaction.e;
import java.security.PrivateKey;
import javax.crypto.Cipher;

public final class a
{
  public static String a(PrivateKey paramPrivateKey, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramPrivateKey == null)) {
      return "";
    }
    try
    {
      Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      byte[] arrayOfByte = new byte['õ'];
      System.arraycopy(paramString.getBytes(), 0, arrayOfByte, 0, paramString.getBytes().length);
      localCipher.init(1, paramPrivateKey);
      paramPrivateKey = e.a(localCipher.doFinal(arrayOfByte));
      return paramPrivateKey;
    }
    catch (Exception paramPrivateKey)
    {
      paramPrivateKey.printStackTrace();
    }
    return "";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pboctransaction/samsung/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */