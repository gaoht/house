package com.ziroom.ziroomcustomer.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public final class aa
{
  public static String a = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCy8jLLLpzPhwFdTwC7LN2HYYS3k1b79KqW5A5nMiKy/cHcocWk9U7eLgNeR7c3Wo4O9Mz+zEq7f3ryQp9yivT0E67j0ZUuFXSFfUNGj0cEASa75nTlh+O9JxRaxjo9OQ4w7SAQG+OxjCxbPU82MoV7YvQdvzfXC60kGgtUqCUccQIDAQAB";
  public static String b = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALLyMssunM+HAV1PALss3YdhhLeTVvv0qpbkDmcyIrL9wdyhxaT1Tt4uA15Htzdajg70zP7MSrt/evJCn3KK9PQTruPRlS4VdIV9Q0aPRwQBJrvmdOWH470nFFrGOj05DjDtIBAb47GMLFs9TzYyhXti9B2/N9cLrSQaC1SoJRxxAgMBAAECgYEAnsPocQDgO/gKK+FGQsthmRXajI17JXxERi/8325J/wjJkZkuJFdJLDMi5ek3EzOSyo5DuuVCgOxwBrU5hoTnIpLtyiLtUZWasVZS+ovqWN6wL0uoE/P6as1Q4eZNh7Aj4ADBU8WanUmpuz8nziRRTwKVpt+YFBGbWUE+jeMIf+ECQQDXjCmL3tO6awPMXFnjsdXFJygWMaeNS+yTsTJdiNixYZLI/JegVYVghAc4WId15W+UMyfKv7GOkRCKXGPAqGVdAkEA1IeLhWwD7STubLhkj5hdXX+StGnz1APNDgNU980YNwA+ADTirAKIQaPi4ijybq6Ye8cA8EqWs45gM3cMTLruJQJAIyHrW6r0I7xxoAulcyF3UG0zcXqibrtjUiddqDU37KGUxUG2jSGjXbnnW13CporBBwzXfYqFLFGkuoiYkbxg2QJAYiY+3t0law1VNsxpVI9u/tD9tWgA/PbMah5LzSzgc/YerAXAcOOyfW3sR7nVTBxBu1gKLO6lbkLgVqQx//WMKQJBAK4O2nlSSrslSNYbZD5x746DxeP/4N38kDIX13BnwDzllr8ocprYwlli0iTYKoQgR1kwkMfgrTIu6Y7lFW8z82E=";
  public static String c = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCfRTdcPIH10gT9f31rQuIInLwe\r7fl2dtEJ93gTmjE9c2H+kLVENWgECiJVQ5sonQNfwToMKdO0b3Olf4pgBKeLThra\rz/L3nYJYlbqjHC3jTjUnZc0luumpXGsox62+PuSGBlfb8zJO6hix4GV/vhyQVCpG\r9aYqgE7zyTRZYX9byQIDAQAB\r";
  public static String d = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJ9FN1w8gfXSBP1/\rfWtC4gicvB7t+XZ20Qn3eBOaMT1zYf6QtUQ1aAQKIlVDmyidA1/BOgwp07Rvc6V/\rimAEp4tOGtrP8vedgliVuqMcLeNONSdlzSW66alcayjHrb4+5IYGV9vzMk7qGLHg\rZX++HJBUKkb1piqATvPJNFlhf1vJAgMBAAECgYA736xhG0oL3EkN9yhx8zG/5RP/\rWJzoQOByq7pTPCr4m/Ch30qVerJAmoKvpPumN+h1zdEBk5PHiAJkm96sG/PTndEf\rkZrAJ2hwSBqptcABYk6ED70gRTQ1S53tyQXIOSjRBcugY/21qeswS3nMyq3xDEPK\rXpdyKPeaTyuK86AEkQJBAM1M7p1lfzEKjNw17SDMLnca/8pBcA0EEcyvtaQpRvaL\rn61eQQnnPdpvHamkRBcOvgCAkfwa1uboru0QdXii/gUCQQDGmkP+KJPX9JVCrbRt\r7wKyIemyNM+J6y1ZBZ2bVCf9jacCQaSkIWnIR1S9UM+1CFE30So2CA0CfCDmQy+y\r7A31AkB8cGFB7j+GTkrLP7SX6KtRboAU7E0q1oijdO24r3xf/Imw4Cy0AAIx4KAu\rL29GOp1YWJYkJXCVTfyZnRxXHxSxAkEAvO0zkSv4uI8rDmtAIPQllF8+eRBT/deD\rJBR7ga/k+wctwK/Bd4Fxp9xzeETP0l8/I+IOTagK+Dos8d8oGQUFoQJBAI4Nwpfo\rMFaLJXGY9ok45wXrcqkJgM+SN6i8hQeujXESVHYatAIL/1DgLi+u46EFD69fw0w+\rc7o0HLlMsYPAzJw=\r";
  private static String e = "RSA";
  
  private static String a(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      String str = paramInputStream.readLine();
      if (str == null) {
        break;
      }
      if (str.charAt(0) != '-')
      {
        localStringBuilder.append(str);
        localStringBuilder.append('\r');
      }
    }
    return localStringBuilder.toString();
  }
  
  public static byte[] decrypt(byte[] paramArrayOfByte, PublicKey paramPublicKey)
  {
    int i = 0;
    try
    {
      Cipher localCipher = Cipher.getInstance(e);
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
  
  public static byte[] decryptData(byte[] paramArrayOfByte, PrivateKey paramPrivateKey)
  {
    try
    {
      Cipher localCipher = Cipher.getInstance(e);
      localCipher.init(2, paramPrivateKey);
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte, PublicKey paramPublicKey)
  {
    int i = 0;
    try
    {
      Cipher localCipher = Cipher.getInstance(e);
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
  
  public static KeyPair generateRSAKeyPair()
  {
    return generateRSAKeyPair(1024);
  }
  
  public static KeyPair generateRSAKeyPair(int paramInt)
  {
    try
    {
      Object localObject = KeyPairGenerator.getInstance(e);
      ((KeyPairGenerator)localObject).initialize(paramInt);
      localObject = ((KeyPairGenerator)localObject).genKeyPair();
      return (KeyPair)localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
    }
    return null;
  }
  
  public static PrivateKey getPrivateKey(String paramString1, String paramString2)
    throws NoSuchAlgorithmException, InvalidKeySpecException
  {
    paramString1 = new RSAPublicKeySpec(new BigInteger(paramString1), new BigInteger(paramString2));
    return KeyFactory.getInstance(e).generatePrivate(paramString1);
  }
  
  public static PrivateKey getPrivateKey(byte[] paramArrayOfByte)
    throws NoSuchAlgorithmException, InvalidKeySpecException
  {
    paramArrayOfByte = new PKCS8EncodedKeySpec(paramArrayOfByte);
    return KeyFactory.getInstance(e).generatePrivate(paramArrayOfByte);
  }
  
  public static PublicKey getPublicKey(String paramString1, String paramString2)
    throws NoSuchAlgorithmException, InvalidKeySpecException
  {
    paramString1 = new RSAPublicKeySpec(new BigInteger(paramString1), new BigInteger(paramString2));
    return KeyFactory.getInstance(e).generatePublic(paramString1);
  }
  
  public static PublicKey getPublicKey(byte[] paramArrayOfByte)
    throws NoSuchAlgorithmException, InvalidKeySpecException
  {
    paramArrayOfByte = new X509EncodedKeySpec(paramArrayOfByte);
    return KeyFactory.getInstance(e).generatePublic(paramArrayOfByte);
  }
  
  public static PrivateKey loadPrivateKey(InputStream paramInputStream)
    throws Exception
  {
    try
    {
      paramInputStream = loadPrivateKey(a(paramInputStream));
      return paramInputStream;
    }
    catch (IOException paramInputStream)
    {
      throw new Exception("私钥数据读取错误");
    }
    catch (NullPointerException paramInputStream)
    {
      throw new Exception("私钥输入流为空");
    }
  }
  
  public static PrivateKey loadPrivateKey(String paramString)
    throws Exception
  {
    try
    {
      paramString = new PKCS8EncodedKeySpec(g.decode(paramString));
      paramString = KeyFactory.getInstance(e).generatePrivate(paramString);
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
  
  public static PublicKey loadPublicKey(InputStream paramInputStream)
    throws Exception
  {
    try
    {
      paramInputStream = loadPublicKey(a(paramInputStream));
      return paramInputStream;
    }
    catch (IOException paramInputStream)
    {
      throw new Exception("公钥数据流读取错误");
    }
    catch (NullPointerException paramInputStream)
    {
      throw new Exception("公钥输入流为空");
    }
  }
  
  public static PublicKey loadPublicKey(String paramString)
    throws Exception
  {
    try
    {
      paramString = g.decode(paramString);
      paramString = KeyFactory.getInstance(e).generatePublic(new X509EncodedKeySpec(paramString));
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
  
  public static void printPrivateKeyInfo(PrivateKey paramPrivateKey)
  {
    paramPrivateKey = (RSAPrivateKey)paramPrivateKey;
    System.out.println("----------RSAPrivateKey ----------");
    System.out.println("Modulus.length=" + paramPrivateKey.getModulus().bitLength());
    System.out.println("Modulus=" + paramPrivateKey.getModulus().toString());
    System.out.println("PrivateExponent.length=" + paramPrivateKey.getPrivateExponent().bitLength());
    System.out.println("PrivatecExponent=" + paramPrivateKey.getPrivateExponent().toString());
  }
  
  public static void printPublicKeyInfo(PublicKey paramPublicKey)
  {
    paramPublicKey = (RSAPublicKey)paramPublicKey;
    System.out.println("----------RSAPublicKey----------");
    System.out.println("Modulus.length=" + paramPublicKey.getModulus().bitLength());
    System.out.println("Modulus=" + paramPublicKey.getModulus().toString());
    System.out.println("PublicExponent.length=" + paramPublicKey.getPublicExponent().bitLength());
    System.out.println("PublicExponent=" + paramPublicKey.getPublicExponent().toString());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */