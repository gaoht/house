package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.b.a.c;
import com.xiaomi.channel.commonutils.android.j;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.misc.h.b;
import com.xiaomi.push.protobuf.a.a;
import com.xiaomi.push.protobuf.b.b;
import com.xiaomi.smack.util.e;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;

public class at
{
  private static String a;
  private static at e = new at();
  private List<a> b = new ArrayList();
  private a.a c;
  private h.b d;
  
  public static at a()
  {
    return e;
  }
  
  public static String e()
  {
    try
    {
      if (a == null)
      {
        localObject1 = j.a().getSharedPreferences("XMPushServiceConfig", 0);
        a = ((SharedPreferences)localObject1).getString("DeviceUUID", null);
        if (a == null)
        {
          a = j.b();
          if (a != null) {
            ((SharedPreferences)localObject1).edit().putString("DeviceUUID", a).commit();
          }
        }
      }
      Object localObject1 = a;
      return (String)localObject1;
    }
    finally {}
  }
  
  private void f()
  {
    if (this.c == null) {
      h();
    }
  }
  
  private void g()
  {
    if (this.d != null) {
      return;
    }
    this.d = new au(this);
    e.a(this.d);
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: new 102	java/io/BufferedInputStream
    //   3: dup
    //   4: invokestatic 52	com/xiaomi/channel/commonutils/android/j:a	()Landroid/content/Context;
    //   7: ldc 104
    //   9: invokevirtual 108	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   12: invokespecial 111	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_2
    //   16: aload_2
    //   17: astore_1
    //   18: aload_0
    //   19: aload_2
    //   20: invokestatic 116	com/google/b/a/b:a	(Ljava/io/InputStream;)Lcom/google/b/a/b;
    //   23: invokestatic 121	com/xiaomi/push/protobuf/a$a:c	(Lcom/google/b/a/b;)Lcom/xiaomi/push/protobuf/a$a;
    //   26: putfield 37	com/xiaomi/push/service/at:c	Lcom/xiaomi/push/protobuf/a$a;
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: invokevirtual 124	java/io/BufferedInputStream:close	()V
    //   35: aload_2
    //   36: invokestatic 128	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   39: aload_0
    //   40: getfield 37	com/xiaomi/push/service/at:c	Lcom/xiaomi/push/protobuf/a$a;
    //   43: ifnonnull +14 -> 57
    //   46: aload_0
    //   47: new 118	com/xiaomi/push/protobuf/a$a
    //   50: dup
    //   51: invokespecial 129	com/xiaomi/push/protobuf/a$a:<init>	()V
    //   54: putfield 37	com/xiaomi/push/service/at:c	Lcom/xiaomi/push/protobuf/a$a;
    //   57: return
    //   58: astore_3
    //   59: aconst_null
    //   60: astore_2
    //   61: aload_2
    //   62: astore_1
    //   63: new 131	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   70: ldc -122
    //   72: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_3
    //   76: invokevirtual 141	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   79: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 149	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   88: aload_2
    //   89: invokestatic 128	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   92: goto -53 -> 39
    //   95: astore_2
    //   96: aconst_null
    //   97: astore_1
    //   98: aload_1
    //   99: invokestatic 128	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   102: aload_2
    //   103: athrow
    //   104: astore_2
    //   105: goto -7 -> 98
    //   108: astore_3
    //   109: goto -48 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	at
    //   17	82	1	localBufferedInputStream1	java.io.BufferedInputStream
    //   15	74	2	localBufferedInputStream2	java.io.BufferedInputStream
    //   95	8	2	localObject1	Object
    //   104	1	2	localObject2	Object
    //   58	18	3	localException1	Exception
    //   108	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	16	58	java/lang/Exception
    //   0	16	95	finally
    //   18	29	104	finally
    //   31	35	104	finally
    //   63	88	104	finally
    //   18	29	108	java/lang/Exception
    //   31	35	108	java/lang/Exception
  }
  
  private void i()
  {
    try
    {
      if (this.c != null)
      {
        BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(j.a().openFileOutput("XMCloudCfg", 0));
        c localc = c.a(localBufferedOutputStream);
        this.c.a(localc);
        localc.a();
        localBufferedOutputStream.close();
      }
      return;
    }
    catch (Exception localException)
    {
      b.a("save config failure: " + localException.getMessage());
    }
  }
  
  void a(b.b paramb)
  {
    if ((paramb.i()) && (paramb.h() > c())) {
      g();
    }
    try
    {
      a[] arrayOfa = (a[])this.b.toArray(new a[this.b.size()]);
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        arrayOfa[i].a(paramb);
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  public void a(a parama)
  {
    try
    {
      this.b.add(parama);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  void b()
  {
    try
    {
      this.b.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  int c()
  {
    f();
    if (this.c != null) {
      return this.c.d();
    }
    return 0;
  }
  
  public a.a d()
  {
    f();
    return this.c;
  }
  
  public static abstract class a
  {
    public void a(a.a parama) {}
    
    public void a(b.b paramb) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */