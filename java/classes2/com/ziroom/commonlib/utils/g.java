package com.ziroom.commonlib.utils;

import com.alibaba.fastjson.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class g
{
  public static String a = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCy8jLLLpzPhwFdTwC7LN2HYYS3k1b79KqW5A5nMiKy/cHcocWk9U7eLgNeR7c3Wo4O9Mz+zEq7f3ryQp9yivT0E67j0ZUuFXSFfUNGj0cEASa75nTlh+O9JxRaxjo9OQ4w7SAQG+OxjCxbPU82MoV7YvQdvzfXC60kGgtUqCUccQIDAQAB";
  private static String b = "RSA";
  private static char[] c = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static byte[] d = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1 };
  
  private static String a(byte[] paramArrayOfByte, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuilder.append('0');
      }
      localStringBuilder.append(str).append(paramString);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static void a(StringBuffer paramStringBuffer, byte paramByte)
  {
    paramStringBuffer.append("0123456789ABCDEFFFFAD".charAt(paramByte >> 4 & 0xF)).append("0123456789ABCDEFFFFAD".charAt(paramByte & 0xF));
  }
  
  private static byte[] a(String paramString)
  {
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[i] = Integer.valueOf(paramString.substring(i * 2, i * 2 + 2), 16).byteValue();
      i += 1;
    }
    return arrayOfByte;
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
    throws Exception
  {
    KeyGenerator localKeyGenerator = KeyGenerator.getInstance("AES");
    SecureRandom localSecureRandom = SecureRandom.getInstance("SHA1PRNG", "Crypto");
    localSecureRandom.setSeed(paramArrayOfByte);
    localKeyGenerator.init(128, localSecureRandom);
    return localKeyGenerator.generateKey().getEncoded();
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    paramArrayOfByte1 = new SecretKeySpec(paramArrayOfByte1, "AES");
    Cipher localCipher = Cipher.getInstance("AES/ECB/ZeroBytePadding");
    localCipher.init(1, paramArrayOfByte1);
    return localCipher.doFinal(paramArrayOfByte2);
  }
  
  public static String aesDecrypt(String paramString1, String paramString2)
    throws Exception
  {
    return b(a(a(paramString1.getBytes()), paramString2.getBytes()));
  }
  
  public static String aesEncrypt(String paramString1, String paramString2)
    throws Exception
  {
    return new String(b(a(paramString1.getBytes()), a(paramString2)));
  }
  
  private static String b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 3);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      a(localStringBuffer, paramArrayOfByte[i]);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static byte[] b(String paramString)
    throws UnsupportedEncodingException
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramString = paramString.getBytes("US-ASCII");
    int k = paramString.length;
    int i = 0;
    if (i < k) {}
    for (int j = i;; j = i)
    {
      byte[] arrayOfByte = d;
      i = j + 1;
      int n = arrayOfByte[paramString[j]];
      if ((i >= k) || (n != -1))
      {
        j = i;
        if (n == -1) {}
        label65:
        int m;
        do
        {
          return localStringBuffer.toString().getBytes("iso8859-1");
          do
          {
            j = i;
            arrayOfByte = d;
            i = j + 1;
            m = arrayOfByte[paramString[j]];
          } while ((i < k) && (m == -1));
        } while (m == -1);
        localStringBuffer.append((char)(n << 2 | (m & 0x30) >>> 4));
        for (j = i;; j = i)
        {
          i = j + 1;
          j = paramString[j];
          if (j == 61) {
            return localStringBuffer.toString().getBytes("iso8859-1");
          }
          n = d[j];
          if ((i >= k) || (n != -1))
          {
            if (n == -1) {
              break label65;
            }
            localStringBuffer.append((char)((m & 0xF) << 4 | (n & 0x3C) >>> 2));
            for (j = i;; j = i)
            {
              i = j + 1;
              j = paramString[j];
              if (j == 61) {
                return localStringBuffer.toString().getBytes("iso8859-1");
              }
              j = d[j];
              if ((i >= k) || (j != -1))
              {
                if (j == -1) {
                  break label65;
                }
                localStringBuffer.append((char)(j | (n & 0x3) << 6));
                break;
              }
            }
          }
        }
      }
    }
  }
  
  private static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    paramArrayOfByte1 = new SecretKeySpec(paramArrayOfByte1, "AES");
    Cipher localCipher = Cipher.getInstance("AES/ECB/ZeroBytePadding");
    localCipher.init(2, paramArrayOfByte1);
    return localCipher.doFinal(paramArrayOfByte2);
  }
  
  public static byte[] base64Decode(String paramString)
  {
    try
    {
      paramString = b(paramString);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return new byte[0];
  }
  
  public static String base64Encode(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayOfByte.length;
    int i = 0;
    for (;;)
    {
      int n;
      int k;
      if (i < j)
      {
        n = i + 1;
        k = paramArrayOfByte[i] & 0xFF;
        if (n != j) {
          break label81;
        }
        localStringBuffer.append(c[(k >>> 2)]);
        localStringBuffer.append(c[((k & 0x3) << 4)]);
        localStringBuffer.append("==");
      }
      for (;;)
      {
        return localStringBuffer.toString();
        label81:
        m = n + 1;
        n = paramArrayOfByte[n] & 0xFF;
        if (m != j) {
          break;
        }
        localStringBuffer.append(c[(k >>> 2)]);
        localStringBuffer.append(c[((k & 0x3) << 4 | (n & 0xF0) >>> 4)]);
        localStringBuffer.append(c[((n & 0xF) << 2)]);
        localStringBuffer.append("=");
      }
      i = m + 1;
      int m = paramArrayOfByte[m] & 0xFF;
      localStringBuffer.append(c[(k >>> 2)]);
      localStringBuffer.append(c[((k & 0x3) << 4 | (n & 0xF0) >>> 4)]);
      localStringBuffer.append(c[((n & 0xF) << 2 | (m & 0xC0) >>> 6)]);
      localStringBuffer.append(c[(m & 0x3F)]);
    }
  }
  
  public static String desDecrypt(String paramString)
  {
    try
    {
      if (r.isNull(paramString)) {
        return null;
      }
      IvParameterSpec localIvParameterSpec = new IvParameterSpec("EbpU4WtY".getBytes());
      Object localObject = new DESKeySpec("vpRZ1kmU".getBytes());
      localObject = SecretKeyFactory.getInstance("DES").generateSecret((KeySpec)localObject);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(2, (Key)localObject, localIvParameterSpec);
      paramString = new String(localCipher.doFinal(r.hexStr2ByteArr(paramString)), "utf-8");
      return paramString;
    }
    catch (Exception paramString)
    {
      l.e("DESEncrypt", "ENCRYPT ERROR:" + paramString);
    }
    return null;
  }
  
  public static String desDecrypt(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (r.isNull(paramString1)) {
        return null;
      }
      paramString2 = new IvParameterSpec(paramString2.getBytes());
      paramString3 = new DESKeySpec(paramString3.getBytes());
      paramString3 = SecretKeyFactory.getInstance("DES").generateSecret(paramString3);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(2, paramString3, paramString2);
      paramString1 = new String(localCipher.doFinal(r.hexStr2ByteArr(paramString1)), "utf-8");
      return paramString1;
    }
    catch (Exception paramString1)
    {
      l.e("DESEncrypt", "ENCRYPT ERROR:" + paramString1);
    }
    return null;
  }
  
  public static String desEncrypt(String paramString)
  {
    try
    {
      if (r.isNull(paramString)) {
        return null;
      }
      IvParameterSpec localIvParameterSpec = new IvParameterSpec("EbpU4WtY".getBytes());
      Object localObject = new DESKeySpec("vpRZ1kmU".getBytes());
      localObject = SecretKeyFactory.getInstance("DES").generateSecret((KeySpec)localObject);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(1, (Key)localObject, localIvParameterSpec);
      paramString = r.byteArr2HexStr(localCipher.doFinal(paramString.getBytes("utf-8")));
      return paramString;
    }
    catch (Exception paramString)
    {
      l.e("DESEncrypt", "ENCRYPT ERROR:" + paramString);
    }
    return null;
  }
  
  public static String desEncrypt(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (r.isNull(paramString1)) {
        return null;
      }
      paramString2 = new IvParameterSpec(paramString2.getBytes());
      paramString3 = new DESKeySpec(paramString3.getBytes());
      paramString3 = SecretKeyFactory.getInstance("DES").generateSecret(paramString3);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(1, paramString3, paramString2);
      paramString1 = r.byteArr2HexStr(localCipher.doFinal(paramString1.getBytes("utf-8")));
      return paramString1;
    }
    catch (Exception paramString1)
    {
      l.e("DESEncrypt", "ENCRYPT ERROR:" + paramString1);
    }
    return null;
  }
  
  public static PrivateKey loadPrivateKey(String paramString)
    throws Exception
  {
    try
    {
      paramString = new PKCS8EncodedKeySpec(base64Decode(paramString));
      paramString = KeyFactory.getInstance(b).generatePrivate(paramString);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new Exception("无此算法");
    }
    catch (InvalidKeySpecException paramString)
    {
      throw new Exception("私钥非法");
    }
    catch (NullPointerException paramString)
    {
      throw new Exception("私钥数据为空");
    }
  }
  
  public static PublicKey loadPublicKey(String paramString)
    throws Exception
  {
    try
    {
      paramString = base64Decode(paramString);
      paramString = KeyFactory.getInstance(b).generatePublic(new X509EncodedKeySpec(paramString));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new Exception("无此算法");
    }
    catch (InvalidKeySpecException paramString)
    {
      throw new Exception("公钥非法");
    }
    catch (NullPointerException paramString)
    {
      throw new Exception("公钥数据为空");
    }
  }
  
  public static byte[] rsaDecrypt(byte[] paramArrayOfByte, PublicKey paramPublicKey)
  {
    int i = 0;
    try
    {
      Cipher localCipher = Cipher.getInstance(b);
      localCipher.init(2, paramPublicKey);
      int k = paramArrayOfByte.length;
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      int j = 0;
      if (k - i > 0)
      {
        if (k - i > 128) {}
        for (paramPublicKey = localCipher.doFinal(paramArrayOfByte, i, 128);; paramPublicKey = localCipher.doFinal(paramArrayOfByte, i, k - i))
        {
          localByteArrayOutputStream.write(paramPublicKey, 0, paramPublicKey.length);
          j += 1;
          i = j * 128;
          break;
        }
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public static byte[] rsaEncrypt(byte[] paramArrayOfByte, PublicKey paramPublicKey)
  {
    int i = 0;
    try
    {
      Cipher localCipher = Cipher.getInstance(b);
      localCipher.init(1, paramPublicKey);
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      paramPublicKey = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[117];
      for (;;)
      {
        int j = paramArrayOfByte.read(arrayOfByte);
        if (j == -1) {
          break;
        }
        i += 1;
        paramPublicKey.write(localCipher.doFinal(arrayOfByte, 0, j));
      }
      paramArrayOfByte = paramPublicKey.toByteArray();
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return null;
    }
    return paramArrayOfByte;
  }
  
  public static Map<String, String> signMethod(Map paramMap)
  {
    Object localObject2 = m.getUid();
    if (!paramMap.containsKey("uid"))
    {
      localObject1 = localObject2;
      if (r.isNull((String)localObject2)) {
        localObject1 = "";
      }
      paramMap.put("uid", localObject1);
    }
    Object localObject1 = desEncrypt(a.toJSONString(paramMap), SignKeyUtil.getIvKeyFromC(), SignKeyUtil.getKeyFromC());
    paramMap = toMd5(a.toJSONString(paramMap).getBytes());
    localObject2 = new HashMap();
    ((Map)localObject2).put("2y5QfvAy", localObject1);
    ((Map)localObject2).put("hPtJ39Xs", paramMap);
    return (Map<String, String>)localObject2;
  }
  
  public static Map<String, String> signMethod(Map paramMap, String paramString1, String paramString2)
  {
    String str = desEncrypt(a.toJSONString(paramMap), SignKeyUtil.getIvKeyFromC(), SignKeyUtil.getKeyFromC());
    paramMap = toMd5(a.toJSONString(paramMap).getBytes());
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString1, str);
    localHashMap.put(paramString2, paramMap);
    return localHashMap;
  }
  
  public static String toMd5(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.reset();
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = a(localMessageDigest.digest(), "");
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      l.v("EncryptUtil", "toMd5():" + paramArrayOfByte);
      throw new RuntimeException(paramArrayOfByte);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/utils/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */