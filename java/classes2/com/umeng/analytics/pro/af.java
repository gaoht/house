package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class af
{
  private static final String a = ".imprint";
  private static final byte[] b = "pbl0".getBytes();
  private static af f;
  private az c;
  private a d = new a();
  private bn e = null;
  private Context g;
  
  af(Context paramContext)
  {
    this.g = paramContext;
  }
  
  public static af a(Context paramContext)
  {
    try
    {
      if (f == null)
      {
        f = new af(paramContext);
        f.c();
      }
      paramContext = f;
      return paramContext;
    }
    finally {}
  }
  
  private bn a(bn parambn1, bn parambn2)
  {
    if (parambn2 == null) {
      return parambn1;
    }
    Map localMap = parambn1.d();
    Iterator localIterator = parambn2.d().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((bo)localEntry.getValue()).e()) {
        localMap.put(localEntry.getKey(), localEntry.getValue());
      } else {
        localMap.remove(localEntry.getKey());
      }
    }
    parambn1.a(parambn2.g());
    parambn1.a(a(parambn1));
    return parambn1;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2 == null;
    }
    return paramString1.equals(paramString2);
  }
  
  private boolean c(bn parambn)
  {
    if (!parambn.j().equals(a(parambn))) {
      return false;
    }
    parambn = parambn.d().values().iterator();
    while (parambn.hasNext())
    {
      Object localObject = (bo)parambn.next();
      byte[] arrayOfByte = bt.a(((bo)localObject).i());
      localObject = a((bo)localObject);
      int i = 0;
      while (i < 4)
      {
        if (arrayOfByte[i] != localObject[i]) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  private bn d(bn parambn)
  {
    Map localMap = parambn.d();
    Object localObject = new ArrayList(localMap.size() / 2);
    Iterator localIterator = localMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!((bo)localEntry.getValue()).e()) {
        ((List)localObject).add(localEntry.getKey());
      }
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localMap.remove((String)((Iterator)localObject).next());
    }
    return parambn;
  }
  
  public bn a()
  {
    try
    {
      bn localbn = this.e;
      return localbn;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String a(bn parambn)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = new TreeMap(parambn.d()).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append((String)localEntry.getKey());
      if (((bo)localEntry.getValue()).e()) {
        localStringBuilder.append(((bo)localEntry.getValue()).c());
      }
      localStringBuilder.append(((bo)localEntry.getValue()).f());
      localStringBuilder.append(((bo)localEntry.getValue()).i());
    }
    localStringBuilder.append(parambn.b);
    return bw.a(localStringBuilder.toString()).toLowerCase(Locale.US);
  }
  
  public void a(az paramaz)
  {
    this.c = paramaz;
  }
  
  public byte[] a(bo parambo)
  {
    Object localObject = ByteBuffer.allocate(8);
    ((ByteBuffer)localObject).order(null);
    ((ByteBuffer)localObject).putLong(parambo.f());
    parambo = ((ByteBuffer)localObject).array();
    localObject = b;
    byte[] arrayOfByte = new byte[4];
    int i = 0;
    while (i < 4)
    {
      arrayOfByte[i] = ((byte)(parambo[i] ^ localObject[i]));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public a b()
  {
    return this.d;
  }
  
  /* Error */
  public void b(bn parambn)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: aload_1
    //   10: invokespecial 225	com/umeng/analytics/pro/af:c	(Lcom/umeng/analytics/pro/bn;)Z
    //   13: ifeq -6 -> 7
    //   16: iconst_0
    //   17: istore_2
    //   18: aload_0
    //   19: monitorenter
    //   20: aload_0
    //   21: getfield 44	com/umeng/analytics/pro/af:e	Lcom/umeng/analytics/pro/bn;
    //   24: astore 5
    //   26: aload 5
    //   28: ifnonnull +84 -> 112
    //   31: aconst_null
    //   32: astore_3
    //   33: aload 5
    //   35: ifnonnull +86 -> 121
    //   38: aload_0
    //   39: aload_1
    //   40: invokespecial 227	com/umeng/analytics/pro/af:d	(Lcom/umeng/analytics/pro/bn;)Lcom/umeng/analytics/pro/bn;
    //   43: astore_1
    //   44: aload_0
    //   45: aload_1
    //   46: putfield 44	com/umeng/analytics/pro/af:e	Lcom/umeng/analytics/pro/bn;
    //   49: aload_1
    //   50: ifnonnull +82 -> 132
    //   53: aload 4
    //   55: astore_1
    //   56: aload_0
    //   57: aload_3
    //   58: aload_1
    //   59: invokespecial 229	com/umeng/analytics/pro/af:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   62: ifne +5 -> 67
    //   65: iconst_1
    //   66: istore_2
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_0
    //   70: getfield 44	com/umeng/analytics/pro/af:e	Lcom/umeng/analytics/pro/bn;
    //   73: ifnull -66 -> 7
    //   76: iload_2
    //   77: ifeq -70 -> 7
    //   80: aload_0
    //   81: getfield 42	com/umeng/analytics/pro/af:d	Lcom/umeng/analytics/pro/af$a;
    //   84: aload_0
    //   85: getfield 44	com/umeng/analytics/pro/af:e	Lcom/umeng/analytics/pro/bn;
    //   88: invokevirtual 231	com/umeng/analytics/pro/af$a:a	(Lcom/umeng/analytics/pro/bn;)V
    //   91: aload_0
    //   92: getfield 204	com/umeng/analytics/pro/af:c	Lcom/umeng/analytics/pro/az;
    //   95: ifnull -88 -> 7
    //   98: aload_0
    //   99: getfield 204	com/umeng/analytics/pro/af:c	Lcom/umeng/analytics/pro/az;
    //   102: aload_0
    //   103: getfield 42	com/umeng/analytics/pro/af:d	Lcom/umeng/analytics/pro/af$a;
    //   106: invokeinterface 236 2 0
    //   111: return
    //   112: aload 5
    //   114: invokevirtual 123	com/umeng/analytics/pro/bn:j	()Ljava/lang/String;
    //   117: astore_3
    //   118: goto -85 -> 33
    //   121: aload_0
    //   122: aload 5
    //   124: aload_1
    //   125: invokespecial 238	com/umeng/analytics/pro/af:a	(Lcom/umeng/analytics/pro/bn;Lcom/umeng/analytics/pro/bn;)Lcom/umeng/analytics/pro/bn;
    //   128: astore_1
    //   129: goto -85 -> 44
    //   132: aload_1
    //   133: invokevirtual 123	com/umeng/analytics/pro/bn:j	()Ljava/lang/String;
    //   136: astore_1
    //   137: goto -81 -> 56
    //   140: astore_1
    //   141: aload_0
    //   142: monitorexit
    //   143: aload_1
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	af
    //   0	145	1	parambn	bn
    //   17	60	2	i	int
    //   32	86	3	str	String
    //   1	53	4	localObject	Object
    //   24	99	5	localbn	bn
    // Exception table:
    //   from	to	target	type
    //   20	26	140	finally
    //   38	44	140	finally
    //   44	49	140	finally
    //   56	65	140	finally
    //   67	69	140	finally
    //   112	118	140	finally
    //   121	129	140	finally
    //   132	137	140	finally
    //   141	143	140	finally
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: new 242	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: getfield 46	com/umeng/analytics/pro/af:g	Landroid/content/Context;
    //   13: invokevirtual 248	android/content/Context:getFilesDir	()Ljava/io/File;
    //   16: ldc 10
    //   18: invokespecial 251	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   21: invokevirtual 254	java/io/File:exists	()Z
    //   24: ifne +4 -> 28
    //   27: return
    //   28: aload_0
    //   29: getfield 46	com/umeng/analytics/pro/af:g	Landroid/content/Context;
    //   32: ldc 10
    //   34: invokevirtual 258	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   37: astore_1
    //   38: aload_1
    //   39: astore_2
    //   40: aload_1
    //   41: invokestatic 261	com/umeng/analytics/pro/bw:b	(Ljava/io/InputStream;)[B
    //   44: astore_3
    //   45: aload_3
    //   46: astore_2
    //   47: aload_1
    //   48: invokestatic 264	com/umeng/analytics/pro/bw:c	(Ljava/io/InputStream;)V
    //   51: aload_2
    //   52: ifnull -25 -> 27
    //   55: new 56	com/umeng/analytics/pro/bn
    //   58: dup
    //   59: invokespecial 265	com/umeng/analytics/pro/bn:<init>	()V
    //   62: astore_1
    //   63: new 267	com/umeng/analytics/pro/cj
    //   66: dup
    //   67: invokespecial 268	com/umeng/analytics/pro/cj:<init>	()V
    //   70: aload_1
    //   71: aload_2
    //   72: invokevirtual 271	com/umeng/analytics/pro/cj:a	(Lcom/umeng/analytics/pro/cg;[B)V
    //   75: aload_0
    //   76: aload_1
    //   77: putfield 44	com/umeng/analytics/pro/af:e	Lcom/umeng/analytics/pro/bn;
    //   80: aload_0
    //   81: getfield 42	com/umeng/analytics/pro/af:d	Lcom/umeng/analytics/pro/af$a;
    //   84: aload_1
    //   85: invokevirtual 231	com/umeng/analytics/pro/af$a:a	(Lcom/umeng/analytics/pro/bn;)V
    //   88: return
    //   89: astore_1
    //   90: aload_1
    //   91: invokevirtual 274	java/lang/Exception:printStackTrace	()V
    //   94: return
    //   95: astore_3
    //   96: aconst_null
    //   97: astore_1
    //   98: aload_1
    //   99: astore_2
    //   100: aload_3
    //   101: invokevirtual 274	java/lang/Exception:printStackTrace	()V
    //   104: aload_1
    //   105: invokestatic 264	com/umeng/analytics/pro/bw:c	(Ljava/io/InputStream;)V
    //   108: aload 4
    //   110: astore_2
    //   111: goto -60 -> 51
    //   114: astore_1
    //   115: aload_2
    //   116: invokestatic 264	com/umeng/analytics/pro/bw:c	(Ljava/io/InputStream;)V
    //   119: aload_1
    //   120: athrow
    //   121: astore_1
    //   122: goto -7 -> 115
    //   125: astore_3
    //   126: goto -28 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	af
    //   37	48	1	localObject1	Object
    //   89	2	1	localException1	Exception
    //   97	8	1	localInputStream	java.io.InputStream
    //   114	6	1	localObject2	Object
    //   121	1	1	localObject3	Object
    //   1	115	2	localObject4	Object
    //   44	2	3	arrayOfByte	byte[]
    //   95	6	3	localException2	Exception
    //   125	1	3	localException3	Exception
    //   3	106	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   55	88	89	java/lang/Exception
    //   28	38	95	java/lang/Exception
    //   28	38	114	finally
    //   40	45	121	finally
    //   100	104	121	finally
    //   40	45	125	java/lang/Exception
  }
  
  public void d()
  {
    if (this.e == null) {
      return;
    }
    try
    {
      byte[] arrayOfByte = new cp().a(this.e);
      bw.a(new File(this.g.getFilesDir(), ".imprint"), arrayOfByte);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean e()
  {
    return new File(this.g.getFilesDir(), ".imprint").delete();
  }
  
  public static class a
  {
    private int a = -1;
    private int b = -1;
    private int c = -1;
    private int d = -1;
    private int e = -1;
    private String f = null;
    private int g = -1;
    private String h = null;
    private int i = -1;
    private int j = -1;
    private String k = null;
    private String l = null;
    private String m = null;
    private String n = null;
    private String o = null;
    
    a() {}
    
    a(bn parambn)
    {
      a(parambn);
    }
    
    private int a(bn parambn, String paramString)
    {
      if (parambn != null) {
        try
        {
          if (parambn.f())
          {
            parambn = (bo)parambn.d().get(paramString);
            if (parambn != null)
            {
              boolean bool = TextUtils.isEmpty(parambn.c());
              if (!bool) {}
            }
            else
            {
              return -1;
            }
            int i1;
            return -1;
          }
        }
        catch (Exception parambn)
        {
          try
          {
            i1 = Integer.parseInt(parambn.c().trim());
            return i1;
          }
          catch (Exception parambn)
          {
            for (;;) {}
          }
          parambn = parambn;
          parambn.printStackTrace();
        }
      }
      return -1;
    }
    
    private String b(bn parambn, String paramString)
    {
      if (parambn != null)
      {
        try
        {
          if (!parambn.f()) {
            return null;
          }
          parambn = (bo)parambn.d().get(paramString);
          if ((parambn == null) || (TextUtils.isEmpty(parambn.c()))) {
            break label58;
          }
          parambn = parambn.c();
        }
        catch (Exception parambn)
        {
          for (;;)
          {
            parambn.printStackTrace();
            parambn = null;
          }
        }
        return parambn;
      }
      label58:
      return null;
    }
    
    public int a(int paramInt)
    {
      if (this.a == -1) {}
      while ((this.a > 3) || (this.a < 0)) {
        return paramInt;
      }
      return this.a;
    }
    
    public long a(long paramLong)
    {
      if (this.j == -1) {}
      while (this.j < 48) {
        return paramLong;
      }
      return 3600000L * this.j;
    }
    
    public String a(String paramString)
    {
      if (this.n != null) {
        paramString = this.n;
      }
      return paramString;
    }
    
    public void a(bn parambn)
    {
      if (parambn == null) {
        return;
      }
      this.a = a(parambn, "defcon");
      this.b = a(parambn, "latent");
      this.c = a(parambn, "codex");
      this.d = a(parambn, "report_policy");
      this.e = a(parambn, "report_interval");
      this.f = b(parambn, "client_test");
      this.g = a(parambn, "test_report_interval");
      this.h = b(parambn, "umid");
      this.i = a(parambn, "integrated_test");
      this.j = a(parambn, "latent_hours");
      this.k = b(parambn, "country");
      this.l = b(parambn, "domain_p");
      this.m = b(parambn, "domain_s");
      this.n = b(parambn, "initial_view_time");
      this.o = b(parambn, "track_list");
    }
    
    public boolean a()
    {
      return this.g != -1;
    }
    
    public int[] a(int paramInt1, int paramInt2)
    {
      if ((this.d == -1) || (!ca.a(this.d))) {
        return new int[] { paramInt1, paramInt2 };
      }
      if ((this.e == -1) || (this.e < 90) || (this.e > 86400)) {
        this.e = 90;
      }
      return new int[] { this.d, this.e * 1000 };
    }
    
    public int b(int paramInt)
    {
      if (this.b == -1) {}
      while ((this.b < 0) || (this.b > 1800)) {
        return paramInt;
      }
      return this.b * 1000;
    }
    
    public String b(String paramString)
    {
      if (this.o != null) {
        paramString = this.o;
      }
      return paramString;
    }
    
    public boolean b()
    {
      return this.i == 1;
    }
    
    public int c(int paramInt)
    {
      if ((this.c == 0) || (this.c == 1) || (this.c == -1)) {
        paramInt = this.c;
      }
      return paramInt;
    }
    
    public String c(String paramString)
    {
      if (this.m != null) {
        paramString = this.m;
      }
      return paramString;
    }
    
    public int d(int paramInt)
    {
      if ((this.g == -1) || (this.g < 90) || (this.g > 86400)) {
        return paramInt;
      }
      return this.g * 1000;
    }
    
    public String d(String paramString)
    {
      if (this.l != null) {
        paramString = this.l;
      }
      return paramString;
    }
    
    public String e(String paramString)
    {
      if (this.k != null) {
        paramString = this.k;
      }
      return paramString;
    }
    
    public String f(String paramString)
    {
      if ((this.f == null) || (!bg.a(this.f))) {
        return paramString;
      }
      return this.f;
    }
    
    public String g(String paramString)
    {
      return this.h;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */