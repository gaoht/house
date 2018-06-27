package com.megvii.a.a;

import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private float[] a = new float[5];
  private int b = 0;
  private boolean c = false;
  
  public static String a(Rect paramRect)
  {
    return "242 " + paramRect.left + "," + paramRect.top + "," + paramRect.right + "," + paramRect.bottom;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        localObject = MessageDigest.getInstance("SHA");
        ((MessageDigest)localObject).update(paramArrayOfByte);
        paramArrayOfByte = ((MessageDigest)localObject).digest();
        localObject = new StringBuilder();
        int j = paramArrayOfByte.length;
        i = 0;
        if (i < j)
        {
          String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
          if (str.length() == 2)
          {
            ((StringBuilder)localObject).append(str);
          }
          else
          {
            ((StringBuilder)localObject).append("0");
            ((StringBuilder)localObject).append(str);
          }
        }
      }
      catch (NoSuchAlgorithmException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return null;
      }
      paramArrayOfByte = ((StringBuilder)localObject).toString().toUpperCase();
      return paramArrayOfByte;
      i += 1;
    }
  }
  
  public static JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", Build.VERSION.SDK_INT);
      localJSONObject.put("release", Build.VERSION.RELEASE);
      localJSONObject.put("model", Build.MODEL);
      localJSONObject.put("brand", Build.BRAND);
      localJSONObject.put("manufacturer", Build.MANUFACTURER);
      localJSONObject.put("arch", Build.CPU_ABI);
      localJSONObject.put("fingerprint", Build.FINGERPRINT);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  private static void a(InputStream paramInputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException paramInputStream) {}
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: new 160	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 161	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_2
    //   8: sipush 1024
    //   11: newarray <illegal type>
    //   13: astore_3
    //   14: new 163	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 164	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   22: astore_0
    //   23: aload_0
    //   24: aload_3
    //   25: invokevirtual 168	java/io/InputStream:read	([B)I
    //   28: istore_1
    //   29: iload_1
    //   30: iconst_m1
    //   31: if_icmpeq +20 -> 51
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: iload_1
    //   38: invokevirtual 172	java/io/ByteArrayOutputStream:write	([BII)V
    //   41: goto -18 -> 23
    //   44: astore_2
    //   45: aload_0
    //   46: invokestatic 174	com/megvii/a/a/b:a	(Ljava/io/InputStream;)V
    //   49: aconst_null
    //   50: areturn
    //   51: aload_2
    //   52: invokevirtual 175	java/io/ByteArrayOutputStream:close	()V
    //   55: aload_0
    //   56: invokestatic 174	com/megvii/a/a/b:a	(Ljava/io/InputStream;)V
    //   59: aload_2
    //   60: invokevirtual 178	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   63: areturn
    //   64: astore_0
    //   65: aconst_null
    //   66: astore_3
    //   67: aload_0
    //   68: astore_2
    //   69: aload_3
    //   70: invokestatic 174	com/megvii/a/a/b:a	(Ljava/io/InputStream;)V
    //   73: aload_2
    //   74: athrow
    //   75: astore_2
    //   76: aload_0
    //   77: astore_3
    //   78: goto -9 -> 69
    //   81: astore_0
    //   82: aconst_null
    //   83: astore_0
    //   84: goto -39 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramString	String
    //   28	10	1	i	int
    //   7	28	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   44	16	2	localIOException	IOException
    //   68	6	2	str	String
    //   75	1	2	localObject1	Object
    //   13	65	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   23	29	44	java/io/IOException
    //   34	41	44	java/io/IOException
    //   51	55	44	java/io/IOException
    //   14	23	64	finally
    //   23	29	75	finally
    //   34	41	75	finally
    //   51	55	75	finally
    //   14	23	81	java/io/IOException
  }
  
  public static boolean b(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    try
    {
      System.load(paramString);
      return true;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      d.b("load dynamic library failed, please check library path");
    }
    return false;
  }
  
  public void a(com.megvii.livenessdetection.a.b paramb)
  {
    int i;
    if (paramb == null)
    {
      if (this.c)
      {
        paramb = this.a;
        i = this.b;
        this.b = (i + 1);
        paramb[(i % 5)] = 0.0F;
      }
      return;
    }
    float f1;
    if (this.c)
    {
      float[] arrayOfFloat = this.a;
      i = this.b;
      this.b = (i + 1);
      arrayOfFloat[(i % 5)] = paramb.i;
      f1 = 100.0F;
      arrayOfFloat = this.a;
      int j = arrayOfFloat.length;
      i = 0;
      if (i < j)
      {
        float f2 = arrayOfFloat[i];
        if (f2 >= f1) {
          break label138;
        }
        f1 = f2;
      }
    }
    label138:
    for (;;)
    {
      i += 1;
      break;
      paramb.w = f1;
      return;
      paramb.w = paramb.i;
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 0;
    try
    {
      this.c = true;
      while (i < 5)
      {
        this.a[i] = 0.0F;
        i += 1;
      }
      this.b = 0;
      return;
    }
    finally {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */