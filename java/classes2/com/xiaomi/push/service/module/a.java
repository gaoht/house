package com.xiaomi.push.service.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.android.c;
import dalvik.system.DexClassLoader;
import java.io.File;
import junit.framework.Assert;

class a
{
  private Context a;
  private String b;
  private String c;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private String g;
  private SharedPreferences h;
  
  public a(Context paramContext, String paramString)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paramString;
    this.h = this.a.getSharedPreferences("mipush_extra", 0);
    if (!TextUtils.isEmpty(this.b)) {
      bool = true;
    }
    Assert.assertEquals(true, bool);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    return b(paramContext, paramString) + "/" + paramString + ".apk";
  }
  
  private String a(String paramString)
  {
    try
    {
      paramString = this.a.getPackageManager().getPackageArchiveInfo(paramString, 16512).applicationInfo.metaData.getString("Launcher");
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private void a(int paramInt)
  {
    this.h.edit().putInt(this.b + "_asset_app_version", paramInt).commit();
  }
  
  private void a(long paramLong)
  {
    this.h.edit().putLong(this.b + "_asset_modified", paramLong).commit();
  }
  
  private static String b(Context paramContext, String paramString)
  {
    return paramContext.getDir(paramString, 0).getAbsolutePath();
  }
  
  private void b(int paramInt)
  {
    this.h.edit().putInt(this.b + "_asset_version", paramInt).commit();
  }
  
  private void b(long paramLong)
  {
    this.h.edit().putLong(this.b + "_local_modified", paramLong).commit();
  }
  
  private void b(String paramString)
  {
    this.h.edit().putString(this.b + "_asset_launcher", paramString).commit();
  }
  
  private void c(int paramInt)
  {
    this.h.edit().putInt(this.b + "_local_version", paramInt).commit();
  }
  
  private void c(String paramString)
  {
    this.h.edit().putString(this.b + "_local_launcher", paramString).commit();
  }
  
  private boolean g()
  {
    File localFile = new File(l());
    return (localFile.exists()) && ((s() != localFile.lastModified()) || (q() == 0));
  }
  
  private boolean h()
  {
    File localFile = new File(d());
    return (localFile.exists()) && ((t() == localFile.lastModified()) || (r() == 0));
  }
  
  /* Error */
  private boolean i()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 4
    //   5: iconst_0
    //   6: istore_1
    //   7: new 140	java/io/File
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 161	com/xiaomi/push/service/module/a:l	()Ljava/lang/String;
    //   15: invokespecial 163	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore 12
    //   20: iload 4
    //   22: istore_2
    //   23: aload 12
    //   25: invokevirtual 166	java/io/File:exists	()Z
    //   28: ifeq +104 -> 132
    //   31: aconst_null
    //   32: astore 9
    //   34: aconst_null
    //   35: astore 11
    //   37: aload_0
    //   38: getfield 35	com/xiaomi/push/service/module/a:a	Landroid/content/Context;
    //   41: invokevirtual 192	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   44: new 61	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   51: aload_0
    //   52: getfield 37	com/xiaomi/push/service/module/a:b	Ljava/lang/String;
    //   55: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 72
    //   60: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokevirtual 198	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   69: astore 10
    //   71: aload 10
    //   73: astore 11
    //   75: aload 10
    //   77: astore 9
    //   79: aload 10
    //   81: invokevirtual 203	android/content/res/AssetFileDescriptor:getLength	()J
    //   84: lstore 5
    //   86: aload 10
    //   88: astore 11
    //   90: aload 10
    //   92: astore 9
    //   94: aload 12
    //   96: invokevirtual 206	java/io/File:length	()J
    //   99: lstore 7
    //   101: lload 5
    //   103: lload 7
    //   105: lcmp
    //   106: ifeq +5 -> 111
    //   109: iconst_1
    //   110: istore_1
    //   111: iload_1
    //   112: istore_2
    //   113: aload 10
    //   115: ifnull +17 -> 132
    //   118: aload 10
    //   120: invokevirtual 210	android/content/res/AssetFileDescriptor:getParcelFileDescriptor	()Landroid/os/ParcelFileDescriptor;
    //   123: astore 9
    //   125: aload 9
    //   127: invokestatic 215	com/xiaomi/channel/commonutils/file/a:a	(Landroid/os/ParcelFileDescriptor;)V
    //   130: iload_1
    //   131: istore_2
    //   132: iload_2
    //   133: ireturn
    //   134: astore 9
    //   136: aload 11
    //   138: astore 9
    //   140: new 61	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   147: ldc -39
    //   149: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_0
    //   153: getfield 37	com/xiaomi/push/service/module/a:b	Ljava/lang/String;
    //   156: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: ldc -37
    //   161: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 223	com/xiaomi/channel/commonutils/logger/b:d	(Ljava/lang/String;)V
    //   170: iload 4
    //   172: istore_2
    //   173: aload 11
    //   175: ifnull -43 -> 132
    //   178: aload 11
    //   180: invokevirtual 210	android/content/res/AssetFileDescriptor:getParcelFileDescriptor	()Landroid/os/ParcelFileDescriptor;
    //   183: astore 9
    //   185: iload_3
    //   186: istore_1
    //   187: goto -62 -> 125
    //   190: astore 10
    //   192: aconst_null
    //   193: astore 9
    //   195: aload 10
    //   197: invokevirtual 226	java/lang/Exception:printStackTrace	()V
    //   200: iload 4
    //   202: istore_2
    //   203: aload 9
    //   205: ifnull -73 -> 132
    //   208: aload 9
    //   210: invokevirtual 210	android/content/res/AssetFileDescriptor:getParcelFileDescriptor	()Landroid/os/ParcelFileDescriptor;
    //   213: astore 9
    //   215: iload_3
    //   216: istore_1
    //   217: goto -92 -> 125
    //   220: astore 11
    //   222: aload 9
    //   224: astore 10
    //   226: aload 11
    //   228: astore 9
    //   230: aload 10
    //   232: ifnull +11 -> 243
    //   235: aload 10
    //   237: invokevirtual 210	android/content/res/AssetFileDescriptor:getParcelFileDescriptor	()Landroid/os/ParcelFileDescriptor;
    //   240: invokestatic 215	com/xiaomi/channel/commonutils/file/a:a	(Landroid/os/ParcelFileDescriptor;)V
    //   243: aload 9
    //   245: athrow
    //   246: astore 11
    //   248: aload 9
    //   250: astore 10
    //   252: aload 11
    //   254: astore 9
    //   256: goto -26 -> 230
    //   259: astore 11
    //   261: aload 10
    //   263: astore 9
    //   265: aload 11
    //   267: astore 10
    //   269: goto -74 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	a
    //   6	211	1	bool1	boolean
    //   22	181	2	bool2	boolean
    //   1	215	3	bool3	boolean
    //   3	198	4	bool4	boolean
    //   84	18	5	l1	long
    //   99	5	7	l2	long
    //   32	94	9	localObject1	Object
    //   134	1	9	localFileNotFoundException	java.io.FileNotFoundException
    //   138	126	9	localObject2	Object
    //   69	50	10	localAssetFileDescriptor	android.content.res.AssetFileDescriptor
    //   190	6	10	localException1	Exception
    //   224	44	10	localObject3	Object
    //   35	144	11	localObject4	Object
    //   220	7	11	localObject5	Object
    //   246	7	11	localObject6	Object
    //   259	7	11	localException2	Exception
    //   18	77	12	localFile	File
    // Exception table:
    //   from	to	target	type
    //   37	71	134	java/io/FileNotFoundException
    //   79	86	134	java/io/FileNotFoundException
    //   94	101	134	java/io/FileNotFoundException
    //   37	71	190	java/lang/Exception
    //   37	71	220	finally
    //   79	86	220	finally
    //   94	101	220	finally
    //   140	170	220	finally
    //   195	200	246	finally
    //   79	86	259	java/lang/Exception
    //   94	101	259	java/lang/Exception
  }
  
  private void j()
  {
    label100:
    for (;;)
    {
      try
      {
        com.xiaomi.channel.commonutils.logger.b.b("copyAssetFile start");
        String[] arrayOfString = this.a.getAssets().list("");
        if (arrayOfString == null) {
          break label100;
        }
        int j = arrayOfString.length;
        i = 0;
        if (i >= j) {
          break label100;
        }
        String str = arrayOfString[i];
        if ((TextUtils.isEmpty(str)) || (!str.startsWith(this.b))) {
          continue;
        }
        c.a(this.a, str, l());
      }
      catch (Exception localException)
      {
        int i;
        localException.printStackTrace();
        continue;
      }
      finally
      {
        com.xiaomi.channel.commonutils.logger.b.b("copyAssetFile end");
      }
      com.xiaomi.channel.commonutils.logger.b.b("copyAssetFile end");
      return;
      i += 1;
    }
  }
  
  private String k()
  {
    return b(this.a, this.b);
  }
  
  private String l()
  {
    return k() + "/" + this.b + "_asset.apk";
  }
  
  private String m()
  {
    return k() + "/lib/";
  }
  
  private String n()
  {
    return k() + "/asset_lib/";
  }
  
  private boolean o()
  {
    try
    {
      int i = p();
      int j = com.xiaomi.channel.commonutils.android.b.b(this.a, this.a.getPackageName());
      return i != j;
    }
    catch (Exception localException) {}
    return true;
  }
  
  private int p()
  {
    try
    {
      int i = this.h.getInt(this.b + "_asset_app_version", 0);
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  private int q()
  {
    try
    {
      int i = this.h.getInt(this.b + "_asset_version", 0);
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  private int r()
  {
    try
    {
      int i = this.h.getInt(this.b + "_local_version", 0);
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  private long s()
  {
    try
    {
      long l = this.h.getLong(this.b + "_asset_modified", 0L);
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  private long t()
  {
    try
    {
      long l = this.h.getLong(this.b + "_local_modified", 0L);
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  private String u()
  {
    try
    {
      String str = this.h.getString(this.b + "_asset_launcher", null);
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private String v()
  {
    try
    {
      String str = this.h.getString(this.b + "_local_launcher", null);
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public int a()
  {
    return this.d;
  }
  
  public String b()
  {
    return this.g;
  }
  
  public DexClassLoader c()
  {
    int j = 1;
    for (;;)
    {
      try
      {
        com.xiaomi.channel.commonutils.logger.b.b("load apk " + this.b);
        localObject1 = l();
        File localFile = new File((String)localObject1);
        boolean bool = i();
        com.xiaomi.channel.commonutils.logger.b.b("assert app size changed : " + bool);
        if ((!localFile.exists()) || (bool) || (o()))
        {
          com.xiaomi.channel.commonutils.logger.b.b("re-copy asset file");
          j();
        }
        if (!localFile.exists()) {
          break label828;
        }
        com.xiaomi.channel.commonutils.logger.b.b("check modify.");
        if ((g()) || (bool) || (o()))
        {
          com.xiaomi.channel.commonutils.logger.b.b("modified.");
          this.e = com.xiaomi.channel.commonutils.android.b.c(this.a, (String)localObject1);
          b(this.e);
          a(com.xiaomi.channel.commonutils.android.b.b(this.a, this.a.getPackageName()));
          a(localFile.lastModified());
          i = 1;
          localObject1 = d();
          localFile = new File((String)localObject1);
          if (!localFile.exists()) {
            break label833;
          }
          if (!h()) {
            continue;
          }
          this.f = com.xiaomi.channel.commonutils.android.b.c(this.a, (String)localObject1);
          c(this.f);
          b(localFile.lastModified());
          com.xiaomi.channel.commonutils.logger.b.b("asset version " + this.e);
          com.xiaomi.channel.commonutils.logger.b.b("local version " + this.f);
          if (this.e < this.f) {
            continue;
          }
          if (this.e <= this.d) {
            break label780;
          }
          this.d = this.e;
          this.c = l();
          if (i == 0) {
            continue;
          }
          this.g = a(this.c);
          b(this.g);
          com.xiaomi.channel.commonutils.android.a.a(this.a, this.c, n());
          localObject1 = new DexClassLoader(this.c, this.a.getDir("dex", 0).getAbsolutePath(), n(), ClassLoader.getSystemClassLoader());
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        com.xiaomi.channel.commonutils.logger.b.a(localException);
        com.xiaomi.channel.commonutils.logger.b.b("load apk : " + this.c + ", version : " + this.d);
        com.xiaomi.channel.commonutils.logger.b.b("load apk done.");
        DexClassLoader localDexClassLoader = null;
        continue;
        if (this.f <= this.d) {
          break label780;
        }
        this.d = this.f;
        this.c = d();
        if (j == 0) {
          continue;
        }
        this.g = a(this.c);
        c(this.g);
        com.xiaomi.channel.commonutils.android.a.a(this.a, this.c, m());
        localDexClassLoader = new DexClassLoader(this.c, this.a.getDir("dex", 0).getAbsolutePath(), m(), ClassLoader.getSystemClassLoader());
        com.xiaomi.channel.commonutils.logger.b.b("load apk : " + this.c + ", version : " + this.d);
        com.xiaomi.channel.commonutils.logger.b.b("load apk done.");
        continue;
        this.g = v();
        continue;
      }
      finally
      {
        com.xiaomi.channel.commonutils.logger.b.b("load apk : " + this.c + ", version : " + this.d);
        com.xiaomi.channel.commonutils.logger.b.b("load apk done.");
      }
      try
      {
        com.xiaomi.channel.commonutils.logger.b.b("load apk : " + this.c + ", version : " + this.d);
        com.xiaomi.channel.commonutils.logger.b.b("load apk done.");
        return (DexClassLoader)localObject1;
      }
      finally {}
      com.xiaomi.channel.commonutils.logger.b.b("not modified.");
      this.e = q();
      break label828;
      this.f = r();
      break label833;
      this.g = u();
      continue;
      label780:
      com.xiaomi.channel.commonutils.logger.b.b("load apk : " + this.c + ", version : " + this.d);
      com.xiaomi.channel.commonutils.logger.b.b("load apk done.");
      continue;
      label828:
      int i = 0;
      continue;
      label833:
      j = 0;
    }
  }
  
  public String d()
  {
    return a(this.a, this.b);
  }
  
  public String e()
  {
    return this.b;
  }
  
  public String f()
  {
    return this.c;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/module/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */