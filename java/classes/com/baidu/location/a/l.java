package com.baidu.location.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import com.baidu.location.Jni;
import com.baidu.location.b.h;
import com.baidu.location.d.e;
import com.baidu.location.d.i;
import com.baidu.location.d.j;
import com.baidu.location.f;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.HttpInstrumentation;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

@Instrumented
public class l
  extends e
{
  private static l p = null;
  String a = null;
  String b = null;
  String c = null;
  String d = null;
  int e = 1;
  Handler f = null;
  
  /* Error */
  public static void a(File paramFile1, File paramFile2)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 48	java/io/BufferedInputStream
    //   6: dup
    //   7: new 50	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 53	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: invokespecial 56	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_3
    //   19: new 58	java/io/BufferedOutputStream
    //   22: dup
    //   23: new 60	java/io/FileOutputStream
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 61	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   31: invokespecial 64	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   34: astore_1
    //   35: sipush 5120
    //   38: newarray <illegal type>
    //   40: astore 4
    //   42: aload_3
    //   43: aload 4
    //   45: invokevirtual 68	java/io/BufferedInputStream:read	([B)I
    //   48: istore_2
    //   49: iload_2
    //   50: iconst_m1
    //   51: if_icmpeq +33 -> 84
    //   54: aload_1
    //   55: aload 4
    //   57: iconst_0
    //   58: iload_2
    //   59: invokevirtual 72	java/io/BufferedOutputStream:write	([BII)V
    //   62: goto -20 -> 42
    //   65: astore_0
    //   66: aload_3
    //   67: ifnull +7 -> 74
    //   70: aload_3
    //   71: invokevirtual 75	java/io/BufferedInputStream:close	()V
    //   74: aload_1
    //   75: ifnull +7 -> 82
    //   78: aload_1
    //   79: invokevirtual 76	java/io/BufferedOutputStream:close	()V
    //   82: aload_0
    //   83: athrow
    //   84: aload_1
    //   85: invokevirtual 79	java/io/BufferedOutputStream:flush	()V
    //   88: aload_0
    //   89: invokevirtual 85	java/io/File:delete	()Z
    //   92: pop
    //   93: aload_3
    //   94: ifnull +7 -> 101
    //   97: aload_3
    //   98: invokevirtual 75	java/io/BufferedInputStream:close	()V
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokevirtual 76	java/io/BufferedOutputStream:close	()V
    //   109: return
    //   110: astore_0
    //   111: aconst_null
    //   112: astore_1
    //   113: aload 4
    //   115: astore_3
    //   116: goto -50 -> 66
    //   119: astore_0
    //   120: aconst_null
    //   121: astore_1
    //   122: goto -56 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramFile1	File
    //   0	125	1	paramFile2	File
    //   48	11	2	i	int
    //   18	98	3	localObject	Object
    //   1	113	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   35	42	65	finally
    //   42	49	65	finally
    //   54	62	65	finally
    //   84	93	65	finally
    //   3	19	110	finally
    //   19	35	119	finally
  }
  
  private boolean a(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.getType() == 0))
      {
        paramContext = com.baidu.location.b.c.a(com.baidu.location.b.b.a().e());
        if (!paramContext.equals("3G"))
        {
          boolean bool = paramContext.equals("4G");
          if (!bool) {}
        }
        else
        {
          return true;
        }
      }
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    File localFile = new File(j.g() + File.separator + "tmp");
    if (localFile.exists()) {
      localFile.delete();
    }
    FileOutputStream localFileOutputStream;
    for (;;)
    {
      try
      {
        localFileOutputStream = new FileOutputStream(localFile);
        byte[] arrayOfByte = new byte['က'];
        paramString1 = new URL(paramString1);
        if (!(paramString1 instanceof URL))
        {
          paramString1 = paramString1.openConnection();
          paramString1 = (HttpURLConnection)paramString1;
          BufferedInputStream localBufferedInputStream = new BufferedInputStream(paramString1.getInputStream());
          int i = localBufferedInputStream.read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          localFileOutputStream.write(arrayOfByte, 0, i);
          continue;
        }
        paramString1 = HttpInstrumentation.openConnection((URL)paramString1);
      }
      catch (Exception paramString1)
      {
        localFile.delete();
        return false;
      }
    }
    paramString1.disconnect();
    localFileOutputStream.close();
    if (localFile.length() < 10240L)
    {
      localFile.delete();
      return false;
    }
    localFile.renameTo(new File(j.g() + File.separator + paramString2));
    return true;
  }
  
  public static l b()
  {
    if (p == null) {
      p = new l();
    }
    return p;
  }
  
  private Handler f()
  {
    return this.f;
  }
  
  private void g()
  {
    Object localObject1 = j.g() + "/grtcfrsa.dat";
    try
    {
      localObject1 = new File((String)localObject1);
      Object localObject2;
      if (!((File)localObject1).exists())
      {
        localObject2 = new File(i.a);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        if (((File)localObject1).createNewFile())
        {
          localObject2 = new RandomAccessFile((File)localObject1, "rw");
          ((RandomAccessFile)localObject2).seek(2L);
          ((RandomAccessFile)localObject2).writeInt(0);
          ((RandomAccessFile)localObject2).seek(8L);
          byte[] arrayOfByte = "1980_01_01:0".getBytes();
          ((RandomAccessFile)localObject2).writeInt(arrayOfByte.length);
          ((RandomAccessFile)localObject2).write(arrayOfByte);
          ((RandomAccessFile)localObject2).seek(200L);
          ((RandomAccessFile)localObject2).writeBoolean(false);
          ((RandomAccessFile)localObject2).seek(800L);
          ((RandomAccessFile)localObject2).writeBoolean(false);
          ((RandomAccessFile)localObject2).close();
        }
      }
      else
      {
        localObject1 = new RandomAccessFile((File)localObject1, "rw");
        ((RandomAccessFile)localObject1).seek(200L);
        ((RandomAccessFile)localObject1).writeBoolean(true);
        if (this.e == 1)
        {
          ((RandomAccessFile)localObject1).writeBoolean(true);
          if (this.d == null) {
            break label218;
          }
          localObject2 = this.d.getBytes();
          ((RandomAccessFile)localObject1).writeInt(localObject2.length);
          ((RandomAccessFile)localObject1).write((byte[])localObject2);
        }
        for (;;)
        {
          ((RandomAccessFile)localObject1).close();
          return;
          ((RandomAccessFile)localObject1).writeBoolean(false);
          break;
          label218:
          if (Math.abs(f.getFrameVersion() - 7.02F) < 1.0E-8F) {
            ((RandomAccessFile)localObject1).writeInt(0);
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void h()
  {
    if (this.a == null) {}
    while (!h.h()) {
      return;
    }
    new p(this).start();
  }
  
  private boolean i()
  {
    if (this.c == null) {}
    while (new File(j.g() + File.separator + this.c).exists()) {
      return true;
    }
    return a("http://" + this.a + "/" + this.c, this.c);
  }
  
  private void j()
  {
    if (this.b == null) {}
    File localFile;
    do
    {
      do
      {
        return;
        localFile = new File(j.g() + File.separator + this.b);
      } while ((localFile.exists()) || (!a("http://" + this.a + "/" + this.b, this.b)));
      localObject = j.a(localFile, "SHA-256");
    } while ((this.d == null) || (localObject == null) || (!j.b((String)localObject, this.d, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiP7BS5IjEOzrKGR9/Ww9oSDhdX1ir26VOsYjT1T6tk2XumRpkHRwZbrucDcNnvSB4QsqiEJnvTSRi7YMbh2H9sLMkcvHlMV5jAErNvnuskWfcvf7T2mq7EUZI/Hf4oVZhHV0hQJRFVdTcjWI6q2uaaKM3VMh+roDesiE7CR2biQIDAQAB")));
    Object localObject = new File(j.g() + File.separator + f.replaceFileName);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    try
    {
      a(localFile, (File)localObject);
      return;
    }
    catch (Exception localException)
    {
      ((File)localObject).delete();
    }
  }
  
  @SuppressLint({"NewApi"})
  public void a()
  {
    int i = 0;
    StringBuffer localStringBuffer = new StringBuffer(128);
    localStringBuffer.append("&sdk=");
    localStringBuffer.append(7.02F);
    localStringBuffer.append("&fw=");
    localStringBuffer.append(f.getFrameVersion());
    localStringBuffer.append("&suit=");
    localStringBuffer.append(2);
    if (com.baidu.location.d.b.a().b == null)
    {
      localStringBuffer.append("&im=");
      localStringBuffer.append(com.baidu.location.d.b.a().a);
    }
    for (;;)
    {
      localStringBuffer.append("&mb=");
      localStringBuffer.append(Build.MODEL);
      localStringBuffer.append("&sv=");
      String str2 = Build.VERSION.RELEASE;
      String str1 = str2;
      if (str2 != null)
      {
        str1 = str2;
        if (str2.length() > 10) {
          str1 = str2.substring(0, 10);
        }
      }
      localStringBuffer.append(str1);
      try
      {
        if (Build.VERSION.SDK_INT > 20)
        {
          String[] arrayOfString = Build.SUPPORTED_ABIS;
          str2 = null;
          label174:
          str1 = str2;
          if (i < arrayOfString.length)
          {
            if (i == 0) {}
            for (str2 = arrayOfString[i] + ";";; str2 = str2 + arrayOfString[i] + ";")
            {
              i += 1;
              break label174;
              localStringBuffer.append("&cu=");
              localStringBuffer.append(com.baidu.location.d.b.a().b);
              break;
            }
          }
        }
        else
        {
          str1 = Build.CPU_ABI2;
        }
      }
      catch (Error localError)
      {
        for (;;)
        {
          Object localObject1 = null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2 = null;
        }
      }
    }
    if (str1 != null)
    {
      localStringBuffer.append("&cpuabi=");
      localStringBuffer.append(str1);
    }
    localStringBuffer.append("&pack=");
    localStringBuffer.append(com.baidu.location.d.b.d);
    this.h = (j.d() + "?&it=" + Jni.en1(localStringBuffer.toString()));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(this.j);
      if ("up".equals(localJSONObject.getString("res")))
      {
        this.a = localJSONObject.getString("upath");
        if (localJSONObject.has("u1")) {
          this.b = localJSONObject.getString("u1");
        }
        if (localJSONObject.has("u2")) {
          this.c = localJSONObject.getString("u2");
        }
        if (localJSONObject.has("u1_rsa")) {
          this.d = localJSONObject.getString("u1_rsa");
        }
        f().post(new o(this));
      }
      if (localJSONObject.has("ison")) {
        this.e = localJSONObject.getInt("ison");
      }
      g();
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    com.baidu.location.d.c.a().a(System.currentTimeMillis());
  }
  
  public void c()
  {
    long l = com.baidu.location.d.c.a().b();
    if (System.currentTimeMillis() - l > 86400000L)
    {
      f().postDelayed(new m(this), 10000L);
      f().postDelayed(new n(this), 5000L);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */