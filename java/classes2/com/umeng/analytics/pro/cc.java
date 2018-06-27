package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Locale;

public final class cc
{
  private static cc a = null;
  private static Context b;
  private static String c;
  private static final String e = "mobclick_agent_user_";
  private static final String f = "mobclick_agent_header_";
  private static final String g = "mobclick_agent_cached_";
  private a d;
  
  public cc(Context paramContext)
  {
    this.d = new a(paramContext);
  }
  
  public static cc a(Context paramContext)
  {
    try
    {
      b = paramContext.getApplicationContext();
      c = paramContext.getPackageName();
      if (a == null) {
        a = new cc(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private SharedPreferences k()
  {
    return b.getSharedPreferences("mobclick_agent_user_" + c, 0);
  }
  
  private String l()
  {
    return "mobclick_agent_header_" + c;
  }
  
  private String m()
  {
    SharedPreferences localSharedPreferences = ba.a(b);
    if (localSharedPreferences != null)
    {
      int i = localSharedPreferences.getInt("versioncode", 0);
      int j = Integer.parseInt(bv.a(b));
      if ((i != 0) && (j != i)) {
        return "mobclick_agent_cached_" + c + i;
      }
      return "mobclick_agent_cached_" + c + bv.a(b);
    }
    return "mobclick_agent_cached_" + c + bv.a(b);
  }
  
  public void a(int paramInt)
  {
    SharedPreferences localSharedPreferences = ba.a(b);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putInt("vt", paramInt).commit();
    }
  }
  
  public void a(String paramString)
  {
    SharedPreferences localSharedPreferences = ba.a(b);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putString("appkey", paramString).commit();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      SharedPreferences.Editor localEditor = k().edit();
      localEditor.putString("au_p", paramString1);
      localEditor.putString("au_u", paramString2);
      localEditor.commit();
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.d.a(paramArrayOfByte);
  }
  
  public String[] a()
  {
    Object localObject2 = null;
    Object localObject1 = k();
    String str1 = ((SharedPreferences)localObject1).getString("au_p", null);
    String str2 = ((SharedPreferences)localObject1).getString("au_u", null);
    localObject1 = localObject2;
    if (str1 != null)
    {
      localObject1 = localObject2;
      if (str2 != null)
      {
        localObject1 = new String[2];
        localObject1[0] = str1;
        localObject1[1] = str2;
      }
    }
    return (String[])localObject1;
  }
  
  public void b()
  {
    k().edit().remove("au_p").remove("au_u").commit();
  }
  
  public void b(String paramString)
  {
    SharedPreferences localSharedPreferences = ba.a(b);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putString("channel", paramString).commit();
    }
  }
  
  public String c()
  {
    String str = null;
    SharedPreferences localSharedPreferences = ba.a(b);
    if (localSharedPreferences != null) {
      str = localSharedPreferences.getString("appkey", null);
    }
    return str;
  }
  
  public void c(String paramString)
  {
    SharedPreferences localSharedPreferences = ba.a(b);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putString("st", paramString).commit();
    }
  }
  
  public String d()
  {
    String str = null;
    SharedPreferences localSharedPreferences = ba.a(b);
    if (localSharedPreferences != null) {
      str = localSharedPreferences.getString("channel", null);
    }
    return str;
  }
  
  public String e()
  {
    String str = null;
    SharedPreferences localSharedPreferences = ba.a(b);
    if (localSharedPreferences != null) {
      str = localSharedPreferences.getString("st", null);
    }
    return str;
  }
  
  public int f()
  {
    int i = 0;
    SharedPreferences localSharedPreferences = ba.a(b);
    if (localSharedPreferences != null) {
      i = localSharedPreferences.getInt("vt", 0);
    }
    return i;
  }
  
  public void g()
  {
    b.deleteFile(l());
    b.deleteFile(m());
    w.a(b).a(true, false);
    m.a(b).b(new f()
    {
      public void a(Object paramAnonymousObject, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousObject.equals("success")) {}
      }
    });
  }
  
  public boolean h()
  {
    return this.d.a();
  }
  
  public a i()
  {
    return this.d;
  }
  
  public static class a
  {
    private final int a = 10;
    private File b;
    private FilenameFilter c = new FilenameFilter()
    {
      public boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        return paramAnonymousString.startsWith("um");
      }
    };
    
    public a(Context paramContext)
    {
      this(paramContext, ".um");
    }
    
    public a(Context paramContext, String paramString)
    {
      this.b = new File(paramContext.getFilesDir(), paramString);
      if ((!this.b.exists()) || (!this.b.isDirectory())) {
        this.b.mkdir();
      }
    }
    
    /* Error */
    public void a(cc.b paramb)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: aload_0
      //   3: getfield 47	com/umeng/analytics/pro/cc$a:b	Ljava/io/File;
      //   6: aload_0
      //   7: getfield 34	com/umeng/analytics/pro/cc$a:c	Ljava/io/FilenameFilter;
      //   10: invokevirtual 64	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
      //   13: astore 6
      //   15: aload 6
      //   17: ifnull +60 -> 77
      //   20: aload 6
      //   22: arraylength
      //   23: bipush 10
      //   25: if_icmplt +52 -> 77
      //   28: aload 6
      //   30: invokestatic 70	java/util/Arrays:sort	([Ljava/lang/Object;)V
      //   33: aload 6
      //   35: arraylength
      //   36: bipush 10
      //   38: isub
      //   39: istore 4
      //   41: new 9	com/umeng/analytics/pro/cc$a$1
      //   44: dup
      //   45: aload_0
      //   46: iload 4
      //   48: invokespecial 73	com/umeng/analytics/pro/cc$a$1:<init>	(Lcom/umeng/analytics/pro/cc$a;I)V
      //   51: invokestatic 78	com/umeng/analytics/pro/bz:b	(Ljava/lang/Runnable;)V
      //   54: iconst_0
      //   55: istore_2
      //   56: iload_2
      //   57: iload 4
      //   59: if_icmpge +18 -> 77
      //   62: aload 6
      //   64: iload_2
      //   65: aaload
      //   66: invokevirtual 81	java/io/File:delete	()Z
      //   69: pop
      //   70: iload_2
      //   71: iconst_1
      //   72: iadd
      //   73: istore_2
      //   74: goto -18 -> 56
      //   77: aload 6
      //   79: ifnull +90 -> 169
      //   82: aload 6
      //   84: arraylength
      //   85: ifle +84 -> 169
      //   88: aload_1
      //   89: aload_0
      //   90: getfield 47	com/umeng/analytics/pro/cc$a:b	Ljava/io/File;
      //   93: invokeinterface 86 2 0
      //   98: aload 6
      //   100: arraylength
      //   101: istore 4
      //   103: iload_3
      //   104: istore_2
      //   105: iload_2
      //   106: iload 4
      //   108: if_icmpge +51 -> 159
      //   111: aload_1
      //   112: aload 6
      //   114: iload_2
      //   115: aaload
      //   116: invokeinterface 89 2 0
      //   121: istore 5
      //   123: iload 5
      //   125: ifeq +11 -> 136
      //   128: aload 6
      //   130: iload_2
      //   131: aaload
      //   132: invokevirtual 81	java/io/File:delete	()Z
      //   135: pop
      //   136: iload_2
      //   137: iconst_1
      //   138: iadd
      //   139: istore_2
      //   140: goto -35 -> 105
      //   143: astore 7
      //   145: aload 6
      //   147: iload_2
      //   148: aaload
      //   149: invokevirtual 81	java/io/File:delete	()Z
      //   152: pop
      //   153: goto -17 -> 136
      //   156: astore_1
      //   157: aload_1
      //   158: athrow
      //   159: aload_1
      //   160: aload_0
      //   161: getfield 47	com/umeng/analytics/pro/cc$a:b	Ljava/io/File;
      //   164: invokeinterface 91 2 0
      //   169: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	170	0	this	a
      //   0	170	1	paramb	cc.b
      //   55	93	2	i	int
      //   1	103	3	j	int
      //   39	70	4	k	int
      //   121	3	5	bool	boolean
      //   13	133	6	arrayOfFile	File[]
      //   143	1	7	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   111	123	143	java/lang/Throwable
      //   111	123	156	finally
    }
    
    public void a(byte[] paramArrayOfByte)
    {
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
        return;
      }
      Object localObject = String.format(Locale.US, "um_cache_%d.env", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      localObject = new File(this.b, (String)localObject);
      try
      {
        bw.a((File)localObject, paramArrayOfByte);
        return;
      }
      catch (Exception paramArrayOfByte) {}
    }
    
    public boolean a()
    {
      File[] arrayOfFile = this.b.listFiles();
      return (arrayOfFile != null) && (arrayOfFile.length > 0);
    }
    
    public void b()
    {
      File[] arrayOfFile = this.b.listFiles(this.c);
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          arrayOfFile[i].delete();
          i += 1;
        }
      }
    }
    
    public int c()
    {
      File[] arrayOfFile = this.b.listFiles(this.c);
      if ((arrayOfFile != null) && (arrayOfFile.length > 0)) {
        return arrayOfFile.length;
      }
      return 0;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(File paramFile);
    
    public abstract boolean b(File paramFile);
    
    public abstract void c(File paramFile);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */