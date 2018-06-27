package com.unionpay.mobile.android.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  private static String a = "[{\"type\":\"app\",\"sort\":100,\"package_info\":[{\"schema\":\"com.unionpay.uppay\",\"version\":\".*\",\"sign\":\"23137B5BE6AEF6682B41E6536F08367E0949A1CC\",\"sort\":101}],\"need_install\":true,\"install_msg\":\"�Ƿ����ذ�װ��������֧������\",\"url\":\"https://mobile.unionpay.com/getclient?platform=android&type=securepayplugin\",\"download_app\":\"UPPayPluginEx.apk\",\"download_title\":\"��������֧������\",\"download_desp\":\"��������֧������\",\"md5\":\"D75BB2802E61738A9A03BF014F927D9A\"},{\"type\":\"jar\",\"sort\":200}]";
  private static SimpleDateFormat b = new SimpleDateFormat("yyyyMMddhhmmss");
  
  public static String a()
  {
    return b.format(new Date(System.currentTimeMillis()));
  }
  
  public static String a(Context paramContext)
  {
    localObject = "";
    String str3 = PreferenceUtils.a(paramContext, "configs");
    String str2 = PreferenceUtils.a(paramContext, "mode");
    String str1 = PreferenceUtils.a(paramContext, "or");
    paramContext = (Context)localObject;
    if (!TextUtils.isEmpty(str3))
    {
      paramContext = (Context)localObject;
      if (!TextUtils.isEmpty(str2))
      {
        paramContext = (Context)localObject;
        if (TextUtils.isEmpty(str1)) {}
      }
    }
    for (;;)
    {
      try
      {
        paramContext = new JSONObject(str3);
        str3 = i.a(paramContext, "sign");
      }
      catch (JSONException paramContext)
      {
        int i;
        boolean bool;
        int j;
        paramContext = (Context)localObject;
        continue;
        paramContext = "";
        continue;
      }
      try
      {
        i = Integer.parseInt(str2);
        paramContext = new String(Base64.decode(paramContext.getString("configs"), 2));
        str1 = b(d(paramContext + str1));
        bool = PreferenceUtils.forConfig(i, str3).equals(str1);
        if (!bool) {
          continue;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        try
        {
          paramContext = new JSONArray(paramContext);
          j = paramContext.length();
          i = 0;
          if (i >= j) {
            continue;
          }
          localObject = i.b(paramContext, i);
          if (localObject == null) {
            continue;
          }
          localObject = (JSONObject)localObject;
          if (!"app".equals(i.a((JSONObject)localObject, "type"))) {
            continue;
          }
          return new String(Base64.decode(i.a((JSONObject)localObject, "ca"), 2));
        }
        catch (JSONException paramContext)
        {
          return "";
        }
        localNumberFormatException = localNumberFormatException;
        i = 0;
        continue;
      }
      i += 1;
    }
    return "";
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      Object localObject2 = Integer.toHexString(paramArrayOfByte[i]);
      int j = ((String)localObject2).length();
      Object localObject1 = localObject2;
      if (j == 1) {
        localObject1 = "0" + (String)localObject2;
      }
      localObject2 = localObject1;
      if (j > 2) {
        localObject2 = ((String)localObject1).substring(j - 2, j);
      }
      localStringBuilder.append(((String)localObject2).toUpperCase());
      if (i < paramArrayOfByte.length - 1) {
        localStringBuilder.append(':');
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramContext.getPackageManager().getPackageInfo(paramString, 0);
      bool = true;
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return paramString.matches("[0-9A-Fa-f]+");
  }
  
  public static String b(Context paramContext, String paramString)
  {
    Object localObject = null;
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getPackageInfo(paramString, 64);
      paramString = new ByteArrayInputStream(paramContext.signatures[0].toByteArray());
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      try
      {
        paramContext = CertificateFactory.getInstance("X509");
      }
      catch (CertificateException paramContext)
      {
        try
        {
          paramContext = (X509Certificate)paramContext.generateCertificate(paramString);
        }
        catch (CertificateException paramContext)
        {
          try
          {
            for (;;)
            {
              paramContext = a(MessageDigest.getInstance("SHA1").digest(paramContext.getEncoded()));
              return paramContext.replaceAll(":", "");
              paramContext = paramContext;
              paramContext.printStackTrace();
              paramContext = null;
              continue;
              paramContext = paramContext;
              paramContext.printStackTrace();
              paramContext = null;
              continue;
              paramContext = paramContext;
              paramContext.printStackTrace();
              paramContext = null;
            }
          }
          catch (NoSuchAlgorithmException paramContext)
          {
            for (;;)
            {
              paramContext.printStackTrace();
              paramContext = (Context)localObject;
            }
          }
          catch (CertificateEncodingException paramContext)
          {
            for (;;)
            {
              paramContext.printStackTrace();
              paramContext = (Context)localObject;
            }
          }
        }
      }
    }
  }
  
  public static String b(String paramString)
  {
    char[] arrayOfChar = "0123456789ABCDEF".toCharArray();
    StringBuilder localStringBuilder = new StringBuilder("");
    paramString = paramString.getBytes();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      int k = paramString[i];
      localStringBuilder.append(arrayOfChar[((k & 0xF0) >> 4)]);
      localStringBuilder.append(arrayOfChar[(k & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString().trim();
  }
  
  public static String c(String paramString)
  {
    try
    {
      paramString = new BigDecimal(paramString).divide(new BigDecimal("100")).toString();
      return paramString;
    }
    catch (Exception paramString) {}
    return "1";
  }
  
  private static String d(String paramString)
  {
    try
    {
      paramString = paramString.getBytes();
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.reset();
      localMessageDigest.update(paramString);
      paramString = b.a(localMessageDigest.digest());
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/utils/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */