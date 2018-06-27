package com.mob.tools.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.BufferedByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.Security;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.zip.CRC32;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Data
{
  private static final String CHAT_SET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  
  public static String AES128Decode(String paramString, byte[] paramArrayOfByte)
    throws Throwable
  {
    if ((paramString == null) || (paramArrayOfByte == null)) {
      return null;
    }
    return new String(AES128Decode(paramString.getBytes("UTF-8"), paramArrayOfByte), "UTF-8");
  }
  
  public static byte[] AES128Decode(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Throwable
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return null;
    }
    Object localObject = new byte[16];
    System.arraycopy(paramArrayOfByte1, 0, localObject, 0, Math.min(paramArrayOfByte1.length, 16));
    paramArrayOfByte1 = new SecretKeySpec((byte[])localObject, "AES");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AES");
    ((StringBuilder)localObject).append("/EC");
    ((StringBuilder)localObject).append("B/NoP");
    ((StringBuilder)localObject).append("adding");
    localObject = getCipher(((StringBuilder)localObject).toString(), "BC");
    ((Cipher)localObject).init(2, paramArrayOfByte1);
    paramArrayOfByte1 = new byte[((Cipher)localObject).getOutputSize(paramArrayOfByte2.length)];
    int i = ((Cipher)localObject).update(paramArrayOfByte2, 0, paramArrayOfByte2.length, paramArrayOfByte1, 0);
    ((Cipher)localObject).doFinal(paramArrayOfByte1, i);
    return paramArrayOfByte1;
  }
  
  public static byte[] AES128Encode(String paramString1, String paramString2)
    throws Throwable
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return null;
    }
    paramString1 = paramString1.getBytes("UTF-8");
    Object localObject = new byte[16];
    System.arraycopy(paramString1, 0, localObject, 0, Math.min(paramString1.length, 16));
    paramString1 = paramString2.getBytes("UTF-8");
    paramString2 = new SecretKeySpec((byte[])localObject, "AES");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AES");
    ((StringBuilder)localObject).append("/EC");
    ((StringBuilder)localObject).append("B/PKCS7P");
    ((StringBuilder)localObject).append("adding");
    localObject = getCipher(((StringBuilder)localObject).toString(), "BC");
    ((Cipher)localObject).init(1, paramString2);
    paramString2 = new byte[((Cipher)localObject).getOutputSize(paramString1.length)];
    ((Cipher)localObject).doFinal(paramString2, ((Cipher)localObject).update(paramString1, 0, paramString1.length, paramString2, 0));
    return paramString2;
  }
  
  public static byte[] AES128Encode(byte[] paramArrayOfByte, String paramString)
    throws Throwable
  {
    if ((paramArrayOfByte == null) || (paramString == null)) {
      return null;
    }
    return AES128Encode(paramArrayOfByte, paramString.getBytes("UTF-8"));
  }
  
  public static byte[] AES128Encode(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Throwable
  {
    paramArrayOfByte1 = new SecretKeySpec(paramArrayOfByte1, "AES");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AES");
    ((StringBuilder)localObject).append("/EC");
    ((StringBuilder)localObject).append("B/PKCS7P");
    ((StringBuilder)localObject).append("adding");
    localObject = getCipher(((StringBuilder)localObject).toString(), "BC");
    ((Cipher)localObject).init(1, paramArrayOfByte1);
    paramArrayOfByte1 = new byte[((Cipher)localObject).getOutputSize(paramArrayOfByte2.length)];
    ((Cipher)localObject).doFinal(paramArrayOfByte1, ((Cipher)localObject).update(paramArrayOfByte2, 0, paramArrayOfByte2.length, paramArrayOfByte1, 0));
    return paramArrayOfByte1;
  }
  
  public static String Base64AES(String paramString1, String paramString2)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString1 != null)
    {
      if (paramString2 != null) {
        break label19;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      return (String)localObject1;
      label19:
      localObject2 = localObject3;
      try
      {
        paramString1 = Base64.encodeToString(AES128Encode(paramString2, paramString1), 0);
        localObject1 = paramString1;
        localObject2 = paramString1;
        if (!TextUtils.isEmpty(paramString1))
        {
          localObject1 = paramString1;
          localObject2 = paramString1;
          if (paramString1.contains("\n"))
          {
            localObject2 = paramString1;
            paramString1 = paramString1.replace("\n", "");
            return paramString1;
          }
        }
      }
      catch (Throwable paramString1)
      {
        MobLog.getInstance().w(paramString1);
      }
    }
    return (String)localObject2;
  }
  
  public static String CRC32(byte[] paramArrayOfByte)
    throws Throwable
  {
    CRC32 localCRC32 = new CRC32();
    localCRC32.update(paramArrayOfByte);
    long l = localCRC32.getValue();
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append(String.format("%02x", new Object[] { Integer.valueOf((byte)(int)(l >>> 56) & 0xFF) }));
    paramArrayOfByte.append(String.format("%02x", new Object[] { Integer.valueOf((byte)(int)(l >>> 48) & 0xFF) }));
    paramArrayOfByte.append(String.format("%02x", new Object[] { Integer.valueOf((byte)(int)(l >>> 40) & 0xFF) }));
    paramArrayOfByte.append(String.format("%02x", new Object[] { Integer.valueOf((byte)(int)(l >>> 32) & 0xFF) }));
    paramArrayOfByte.append(String.format("%02x", new Object[] { Integer.valueOf((byte)(int)(l >>> 24) & 0xFF) }));
    paramArrayOfByte.append(String.format("%02x", new Object[] { Integer.valueOf((byte)(int)(l >>> 16) & 0xFF) }));
    paramArrayOfByte.append(String.format("%02x", new Object[] { Integer.valueOf((byte)(int)(l >>> 8) & 0xFF) }));
    paramArrayOfByte.append(String.format("%02x", new Object[] { Integer.valueOf((byte)(int)l & 0xFF) }));
    while (paramArrayOfByte.charAt(0) == '0') {
      paramArrayOfByte = paramArrayOfByte.deleteCharAt(0);
    }
    return paramArrayOfByte.toString().toLowerCase();
  }
  
  public static String MD5(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    for (;;)
    {
      return null;
      try
      {
        paramFile = new FileInputStream(paramFile);
        byte[] arrayOfByte = rawMD5(paramFile);
        paramFile.close();
        if (arrayOfByte != null) {
          return toHex(arrayOfByte);
        }
      }
      catch (Throwable paramFile)
      {
        MobLog.getInstance().w(paramFile);
      }
    }
    return null;
  }
  
  public static String MD5(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = rawMD5(paramString);
    } while (paramString == null);
    return toHex(paramString);
  }
  
  public static String MD5(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return null;
      paramArrayOfByte = rawMD5(paramArrayOfByte);
    } while (paramArrayOfByte == null);
    return toHex(paramArrayOfByte);
  }
  
  public static byte[] SHA1(File paramFile)
  {
    Object localObject2 = null;
    if ((paramFile == null) || (!paramFile.exists())) {
      return null;
    }
    Object localObject1 = localObject2;
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramFile);
      localObject1 = localObject2;
      paramFile = SHA1(localFileInputStream);
      localObject1 = paramFile;
      localFileInputStream.close();
      return paramFile;
    }
    catch (Throwable paramFile)
    {
      MobLog.getInstance().w(paramFile);
    }
    return (byte[])localObject1;
  }
  
  public static byte[] SHA1(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = new byte['Ѐ'];
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      for (int i = paramInputStream.read(arrayOfByte); i != -1; i = paramInputStream.read(arrayOfByte)) {
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      paramInputStream = localMessageDigest.digest();
      return paramInputStream;
    }
    catch (Throwable paramInputStream)
    {
      MobLog.getInstance().w(paramInputStream);
    }
    return null;
  }
  
  public static byte[] SHA1(String paramString)
    throws Throwable
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return SHA1(paramString.getBytes("utf-8"));
  }
  
  public static byte[] SHA1(byte[] paramArrayOfByte)
    throws Throwable
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
    localMessageDigest.update(paramArrayOfByte);
    return localMessageDigest.digest();
  }
  
  public static String base62(long paramLong)
  {
    String str;
    if (paramLong == 0L) {
      str = "0";
    }
    while (paramLong > 0L)
    {
      int i = (int)(paramLong % 62L);
      paramLong /= 62L;
      str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(i) + str;
      continue;
      str = "";
    }
    return str;
  }
  
  public static String byteToHex(byte[] paramArrayOfByte)
  {
    return byteToHex(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static String byteToHex(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramArrayOfByte == null) {
      return localStringBuffer.toString();
    }
    while (paramInt1 < paramInt2)
    {
      localStringBuffer.append(String.format("%02x", new Object[] { Byte.valueOf(paramArrayOfByte[paramInt1]) }));
      paramInt1 += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static Cipher getCipher(String paramString1, String paramString2)
    throws Throwable
  {
    localObject2 = null;
    localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString2)) {}
    try
    {
      paramString2 = Security.getProvider(paramString2);
      localObject1 = localObject2;
      if (paramString2 != null) {
        localObject1 = Cipher.getInstance(paramString1, paramString2);
      }
    }
    catch (Throwable paramString2)
    {
      for (;;)
      {
        localObject1 = localObject2;
      }
    }
    paramString2 = (String)localObject1;
    if (localObject1 == null) {
      paramString2 = Cipher.getInstance(paramString1);
    }
    return paramString2;
  }
  
  private static byte[] hexToBytes(String paramString)
  {
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      int j = i * 2;
      arrayOfByte[i] = ((byte)Integer.parseInt(paramString.substring(j, j + 2), 16));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] rawMD5(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = new byte['Ѐ'];
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      for (int i = paramInputStream.read(arrayOfByte); i != -1; i = paramInputStream.read(arrayOfByte)) {
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      paramInputStream = localMessageDigest.digest();
      return paramInputStream;
    }
    catch (Throwable paramInputStream)
    {
      MobLog.getInstance().w(paramInputStream);
    }
    return null;
  }
  
  public static byte[] rawMD5(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = rawMD5(paramString.getBytes("utf-8"));
      return paramString;
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().w(paramString);
    }
    return null;
  }
  
  public static byte[] rawMD5(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
      paramArrayOfByte = rawMD5(localByteArrayInputStream);
      localByteArrayInputStream.close();
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        MobLog.getInstance().w(paramArrayOfByte);
        paramArrayOfByte = null;
      }
    }
  }
  
  public static byte[] rawRSADecode(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
    throws Throwable
  {
    Object localObject = (RSAPrivateKey)KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(paramArrayOfByte2));
    paramArrayOfByte2 = Cipher.getInstance("RSA/None/PKCS1Padding");
    paramArrayOfByte2.init(2, (Key)localObject);
    int i = paramInt / 8;
    localObject = new BufferedByteArrayOutputStream();
    paramInt = 0;
    while (paramArrayOfByte1.length - paramInt > 0)
    {
      byte[] arrayOfByte = paramArrayOfByte2.doFinal(paramArrayOfByte1, paramInt, Math.min(paramArrayOfByte1.length - paramInt, i));
      ((ByteArrayOutputStream)localObject).write(arrayOfByte, 0, arrayOfByte.length);
      paramInt += i;
    }
    ((ByteArrayOutputStream)localObject).close();
    return ((ByteArrayOutputStream)localObject).toByteArray();
  }
  
  public static byte[] rawRSAEncode(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
    throws Throwable
  {
    int i = paramInt / 8 - 11;
    paramArrayOfByte2 = new X509EncodedKeySpec(paramArrayOfByte2);
    Object localObject = (RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(paramArrayOfByte2);
    paramArrayOfByte2 = Cipher.getInstance("RSA/None/PKCS1Padding");
    paramArrayOfByte2.init(1, (Key)localObject);
    localObject = new ByteArrayOutputStream();
    paramInt = 0;
    while (paramArrayOfByte1.length - paramInt > 0)
    {
      byte[] arrayOfByte = paramArrayOfByte2.doFinal(paramArrayOfByte1, paramInt, Math.min(paramArrayOfByte1.length - paramInt, i));
      ((ByteArrayOutputStream)localObject).write(arrayOfByte, 0, arrayOfByte.length);
      paramInt += i;
    }
    ((ByteArrayOutputStream)localObject).close();
    return ((ByteArrayOutputStream)localObject).toByteArray();
  }
  
  private static String toHex(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuffer.append(String.format("%02x", new Object[] { Byte.valueOf(paramArrayOfByte[i]) }));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String urlEncode(String paramString)
  {
    try
    {
      paramString = urlEncode(paramString, "utf-8");
      return paramString;
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().w(paramString);
    }
    return null;
  }
  
  public static String urlEncode(String paramString1, String paramString2)
    throws Throwable
  {
    paramString1 = URLEncoder.encode(paramString1, paramString2);
    if (TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    return paramString1.replace("+", "%20");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/utils/Data.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */