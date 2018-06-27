package com.unionpay.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private static SimpleDateFormat a = new SimpleDateFormat("yyyyMMddhhmmss");
  
  public static String a(Context paramContext)
  {
    localObject = "";
    String str3 = UPUtils.a(paramContext, "configs");
    String str2 = UPUtils.a(paramContext, "mode");
    String str1 = UPUtils.a(paramContext, "or");
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
        str3 = f.a(paramContext, "sign");
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
        str1 = a(UPUtils.a(paramContext + str1));
        bool = UPUtils.forConfig(i, str3).equals(str1);
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
          localObject = f.a(paramContext, i);
          if (localObject == null) {
            continue;
          }
          localObject = (JSONObject)localObject;
          if (!"app".equals(f.a((JSONObject)localObject, "type"))) {
            continue;
          }
          return new String(Base64.decode(f.a((JSONObject)localObject, "ca"), 2));
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
  
  public static String a(String paramString)
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
    Object localObject1 = new File(paramString);
    paramString = new FileInputStream((File)localObject1);
    try
    {
      localObject1 = paramString.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, ((File)localObject1).length());
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update((ByteBuffer)localObject1);
      localObject1 = new BigInteger(1, localMessageDigest.digest()).toString(16);
      try
      {
        paramString.close();
        return (String)localObject1;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return (String)localObject1;
      }
      try
      {
        paramString.close();
        throw ((Throwable)localObject2);
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
    catch (Exception localException)
    {
      localException = localException;
      localException.printStackTrace();
      try
      {
        paramString.close();
        return null;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
    finally {}
  }
  
  public static String c(Context paramContext, String paramString)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      str = paramContext.getPackageManager().getPackageInfo(paramString, 0).versionName;
      return str;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return "";
  }
  
  public static void c(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists())
    {
      if (!paramString.isFile()) {
        break label34;
      }
      paramString.delete();
    }
    for (;;)
    {
      paramString.delete();
      return;
      label34:
      if (paramString.isDirectory())
      {
        File[] arrayOfFile = paramString.listFiles();
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          c(arrayOfFile[i].getPath());
          i += 1;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/utils/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */