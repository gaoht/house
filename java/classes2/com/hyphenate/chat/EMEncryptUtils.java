package com.hyphenate.chat;

import android.util.Base64;
import com.hyphenate.util.EMLog;
import com.hyphenate.util.EasyUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

public class EMEncryptUtils
{
  private static final String TAG = "encrypt";
  
  public static void decryptFile(String paramString1, String paramString2)
  {
    try
    {
      EMLog.d("encrypt", "decrypt file:" + paramString1);
      Object localObject = new RandomAccessFile(paramString1, "r");
      int i = (int)((RandomAccessFile)localObject).length();
      byte[] arrayOfByte = new byte[i];
      int j = ((RandomAccessFile)localObject).read(arrayOfByte);
      if (j != i)
      {
        EMLog.e("encrypt", "error read file, file len:" + i + " readLen:" + j);
        return;
      }
      ((RandomAccessFile)localObject).close();
      paramString2 = EMClient.getInstance().getEncryptProvider().decrypt(arrayOfByte, paramString2);
      localObject = new FileOutputStream(paramString1, false);
      ((FileOutputStream)localObject).write(paramString2);
      ((FileOutputStream)localObject).close();
      EMLog.d("encrypt", "decrypted file:" + paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  static String decryptMessage(String paramString1, String paramString2)
  {
    try
    {
      EMLog.d("encrypt", "encrypted str:" + paramString1);
      byte[] arrayOfByte = Base64.decode(paramString1, 0);
      EMLog.d("encrypt", "base64 decode bytes:" + EasyUtils.convertByteArrayToString(arrayOfByte));
      paramString2 = EMClient.getInstance().getEncryptProvider().decrypt(arrayOfByte, paramString2);
      EMLog.d("encrypt", "decrypt bytes:" + EasyUtils.convertByteArrayToString(paramString2));
      paramString2 = new String(paramString2, "UTF-8");
      EMLog.d("encrypt", "descripted str:" + paramString2);
      return paramString2;
    }
    catch (Exception paramString2)
    {
      paramString2.printStackTrace();
    }
    return paramString1;
  }
  
  public static String encryptFile(String paramString1, String paramString2)
  {
    try
    {
      EMLog.d("encrypt", "try to encrypt file:" + paramString1);
      Object localObject1 = new RandomAccessFile(paramString1, "r");
      int i = (int)((RandomAccessFile)localObject1).length();
      EMLog.d("encrypt", "try to encrypt file:" + paramString1 + " original len:" + i);
      Object localObject2 = new byte[i];
      int j = ((RandomAccessFile)localObject1).read((byte[])localObject2);
      if (j != i)
      {
        EMLog.e("encrypt", "error read file, file len:" + i + " readLen:" + j);
        ((RandomAccessFile)localObject1).close();
        return paramString1;
      }
      ((RandomAccessFile)localObject1).close();
      localObject1 = EMClient.getInstance().getEncryptProvider().encrypt((byte[])localObject2, paramString2);
      paramString2 = null;
      i = paramString1.lastIndexOf('.');
      if (i >= 0) {
        paramString2 = paramString1.substring(i);
      }
      paramString2 = File.createTempFile("encrypted", paramString2);
      localObject2 = new FileOutputStream(paramString2);
      ((FileOutputStream)localObject2).write((byte[])localObject1);
      ((FileOutputStream)localObject2).close();
      paramString2 = paramString2.getAbsolutePath();
      EMLog.d("encrypt", "generated encrypted file:" + paramString2);
      return paramString2;
    }
    catch (Exception paramString2)
    {
      paramString2.printStackTrace();
    }
    return paramString1;
  }
  
  static String encryptMessage(String paramString1, String paramString2)
  {
    try
    {
      EMEncryptProvider localEMEncryptProvider = EMClient.getInstance().getEncryptProvider();
      byte[] arrayOfByte = paramString1.getBytes("UTF-8");
      EMLog.d("encrypt", "utf-8 bytes:" + EasyUtils.convertByteArrayToString(arrayOfByte));
      paramString2 = localEMEncryptProvider.encrypt(arrayOfByte, paramString2);
      EMLog.d("encrypt", "encrypted bytes:" + EasyUtils.convertByteArrayToString(paramString2));
      paramString2 = Base64.encode(paramString2, 0);
      EMLog.d("encrypt", "base64 bytes:" + EasyUtils.convertByteArrayToString(paramString2));
      paramString2 = new String(paramString2);
      EMLog.d("encrypt", "encrypted str:" + paramString2);
      return paramString2;
    }
    catch (Exception paramString2)
    {
      paramString2.printStackTrace();
      EMLog.e("encrypt", "encryption error, send plain msg");
    }
    return paramString1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMEncryptUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */