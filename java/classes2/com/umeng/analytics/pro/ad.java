package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ad
{
  public static ad a;
  private final String b = "umeng_it.cache";
  private File c;
  private bm d = null;
  private long e;
  private long f;
  private Set<y> g = new HashSet();
  private a h = null;
  
  ad(Context paramContext)
  {
    this.c = new File(paramContext.getFilesDir(), "umeng_it.cache");
    this.f = 86400000L;
    this.h = new a(paramContext);
    this.h.b();
  }
  
  public static ad a(Context paramContext)
  {
    try
    {
      if (a == null)
      {
        a = new ad(paramContext);
        a.a(new ae(paramContext));
        a.a(new z(paramContext));
        a.a(new am(paramContext));
        a.a(new ac(paramContext));
        a.a(new ab(paramContext));
        a.a(new ag(paramContext));
        a.a(new aj());
        a.a(new an(paramContext));
        Object localObject = new al(paramContext);
        if (!TextUtils.isEmpty(((al)localObject).f())) {
          a.a((y)localObject);
        }
        localObject = new ai(paramContext);
        if (((ai)localObject).g())
        {
          a.a((y)localObject);
          a.a(new ah(paramContext));
          ((ai)localObject).i();
        }
        a.e();
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void a(bm parambm)
  {
    if (parambm != null) {}
    try
    {
      try
      {
        parambm = new cp().a(parambm);
        if (parambm != null) {
          bw.a(this.c, parambm);
        }
        return;
      }
      finally {}
      return;
    }
    catch (Exception parambm)
    {
      parambm.printStackTrace();
    }
  }
  
  private void g()
  {
    bm localbm = new bm();
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      y localy = (y)localIterator.next();
      if (localy.c())
      {
        if (localy.d() != null) {
          localHashMap.put(localy.b(), localy.d());
        }
        if ((localy.e() != null) && (!localy.e().isEmpty())) {
          localArrayList.addAll(localy.e());
        }
      }
    }
    localbm.a(localArrayList);
    localbm.a(localHashMap);
    try
    {
      this.d = localbm;
      return;
    }
    finally {}
  }
  
  /* Error */
  private bm h()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/umeng/analytics/pro/ad:c	Ljava/io/File;
    //   4: invokevirtual 196	java/io/File:exists	()Z
    //   7: ifne +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: new 198	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: getfield 53	com/umeng/analytics/pro/ad:c	Ljava/io/File;
    //   20: invokespecial 201	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore_2
    //   24: aload_2
    //   25: astore_1
    //   26: aload_2
    //   27: invokestatic 204	com/umeng/analytics/pro/bw:b	(Ljava/io/InputStream;)[B
    //   30: astore_3
    //   31: aload_2
    //   32: astore_1
    //   33: new 138	com/umeng/analytics/pro/bm
    //   36: dup
    //   37: invokespecial 139	com/umeng/analytics/pro/bm:<init>	()V
    //   40: astore 4
    //   42: aload_2
    //   43: astore_1
    //   44: new 206	com/umeng/analytics/pro/cj
    //   47: dup
    //   48: invokespecial 207	com/umeng/analytics/pro/cj:<init>	()V
    //   51: aload 4
    //   53: aload_3
    //   54: invokevirtual 210	com/umeng/analytics/pro/cj:a	(Lcom/umeng/analytics/pro/cg;[B)V
    //   57: aload_2
    //   58: invokestatic 213	com/umeng/analytics/pro/bw:c	(Ljava/io/InputStream;)V
    //   61: aload 4
    //   63: areturn
    //   64: astore_3
    //   65: aconst_null
    //   66: astore_2
    //   67: aload_2
    //   68: astore_1
    //   69: aload_3
    //   70: invokevirtual 136	java/lang/Exception:printStackTrace	()V
    //   73: aload_2
    //   74: invokestatic 213	com/umeng/analytics/pro/bw:c	(Ljava/io/InputStream;)V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_1
    //   80: aconst_null
    //   81: astore_3
    //   82: aload_1
    //   83: astore_2
    //   84: aload_3
    //   85: invokestatic 213	com/umeng/analytics/pro/bw:c	(Ljava/io/InputStream;)V
    //   88: aload_2
    //   89: athrow
    //   90: astore_2
    //   91: aload_1
    //   92: astore_3
    //   93: goto -9 -> 84
    //   96: astore_3
    //   97: goto -30 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	ad
    //   25	44	1	localObject1	Object
    //   79	13	1	localObject2	Object
    //   23	66	2	localObject3	Object
    //   90	1	2	localObject4	Object
    //   30	24	3	arrayOfByte	byte[]
    //   64	6	3	localException1	Exception
    //   81	12	3	localObject5	Object
    //   96	1	3	localException2	Exception
    //   40	22	4	localbm	bm
    // Exception table:
    //   from	to	target	type
    //   12	24	64	java/lang/Exception
    //   12	24	79	finally
    //   26	31	90	finally
    //   33	42	90	finally
    //   44	57	90	finally
    //   69	73	90	finally
    //   26	31	96	java/lang/Exception
    //   33	42	96	java/lang/Exception
    //   44	57	96	java/lang/Exception
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    if (l - this.e >= this.f)
    {
      Iterator localIterator = this.g.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        y localy = (y)localIterator.next();
        if (localy.c()) {
          if (localy.a())
          {
            int j = 1;
            i = j;
            if (!localy.c())
            {
              this.h.b(localy.b());
              i = j;
            }
          }
        }
      }
      if (i != 0)
      {
        g();
        this.h.a();
        f();
      }
      this.e = l;
    }
  }
  
  public void a(long paramLong)
  {
    this.f = paramLong;
  }
  
  public boolean a(y paramy)
  {
    if (this.h.a(paramy.b())) {
      return this.g.add(paramy);
    }
    return false;
  }
  
  public bm b()
  {
    return this.d;
  }
  
  public String c()
  {
    return null;
  }
  
  public void d()
  {
    Iterator localIterator = this.g.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      y localy = (y)localIterator.next();
      if (localy.c())
      {
        if ((localy.e() == null) || (localy.e().isEmpty())) {
          break label84;
        }
        localy.a(null);
        i = 1;
      }
    }
    label84:
    for (;;)
    {
      break;
      if (i != 0)
      {
        this.d.b(false);
        f();
      }
      return;
    }
  }
  
  public void e()
  {
    Object localObject2 = h();
    if (localObject2 == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList(this.g.size());
    try
    {
      this.d = ((bm)localObject2);
      localObject2 = this.g.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        y localy = (y)((Iterator)localObject2).next();
        localy.a(this.d);
        if (!localy.c()) {
          localArrayList.add(localy);
        }
      }
      localIterator = ((List)localObject1).iterator();
    }
    finally {}
    Iterator localIterator;
    while (localIterator.hasNext())
    {
      localObject2 = (y)localIterator.next();
      this.g.remove(localObject2);
    }
    g();
  }
  
  public void f()
  {
    if (this.d != null) {
      a(this.d);
    }
  }
  
  public static class a
  {
    private Context a;
    private Set<String> b = new HashSet();
    
    public a(Context paramContext)
    {
      this.a = paramContext;
    }
    
    public void a()
    {
      if (!this.b.isEmpty())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          localStringBuilder.append((String)localIterator.next());
          localStringBuilder.append(',');
        }
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
        ba.a(this.a).edit().putString("invld_id", localStringBuilder.toString()).commit();
      }
    }
    
    public boolean a(String paramString)
    {
      return !this.b.contains(paramString);
    }
    
    public void b()
    {
      Object localObject = ba.a(this.a).getString("invld_id", null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(",");
        if (localObject != null)
        {
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            CharSequence localCharSequence = localObject[i];
            if (!TextUtils.isEmpty(localCharSequence)) {
              this.b.add(localCharSequence);
            }
            i += 1;
          }
        }
      }
    }
    
    public void b(String paramString)
    {
      this.b.add(paramString);
    }
    
    public void c(String paramString)
    {
      this.b.remove(paramString);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */