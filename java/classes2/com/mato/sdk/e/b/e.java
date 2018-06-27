package com.mato.sdk.e.b;

import android.content.Context;
import android.text.TextUtils;
import com.mato.sdk.b.f;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e
  extends Thread
{
  private static final String a = com.mato.sdk.b.g.b("");
  private final Context b;
  private final i c;
  private final c d;
  private final com.mato.sdk.d.h e;
  private a f;
  private String g;
  private g h;
  private final AtomicBoolean i = new AtomicBoolean(false);
  
  public e(Context paramContext, i parami, com.mato.sdk.d.h paramh, c paramc)
  {
    this.b = paramContext;
    this.c = parami;
    this.d = paramc;
    this.e = paramh;
  }
  
  private void a(int paramInt)
  {
    if ((this.c != null) && (!this.i.get()))
    {
      this.h.q = paramInt;
      this.c.b(this.h);
    }
  }
  
  private void b(int paramInt)
  {
    if ((this.c != null) && (!this.i.get()))
    {
      this.h.s = paramInt;
      this.c.a(this.h);
    }
  }
  
  public static String c()
  {
    String str2 = com.mato.sdk.g.i.a("localhost");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public static String d()
  {
    List localList = com.mato.sdk.g.i.b();
    if (localList.isEmpty()) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    while (j < localList.size())
    {
      if (j > 0) {
        localStringBuilder.append(";");
      }
      localStringBuilder.append((String)localList.get(j));
      j += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void g()
  {
    com.mato.sdk.b.e locale = com.mato.sdk.proxy.a.a();
    this.h.e = locale.e();
    this.h.d = locale.d();
    this.h.f = com.mato.sdk.proxy.a.b().h().a();
    this.h.k = locale.i();
    this.h.h = com.mato.sdk.g.i.h(this.b);
    this.h.g = d();
    this.h.j = h();
    this.h.i = c();
    if ((this.c != null) && (!this.i.get())) {
      this.c.d(this.h);
    }
  }
  
  /* Error */
  private static List<String> h()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 171	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 172	java/util/ArrayList:<init>	()V
    //   9: astore 7
    //   11: invokestatic 174	com/mato/sdk/e/b/e:i	()Ljava/util/List;
    //   14: astore 6
    //   16: iconst_0
    //   17: istore_0
    //   18: aconst_null
    //   19: astore 4
    //   21: aload 6
    //   23: invokeinterface 99 1 0
    //   28: istore_1
    //   29: iload_0
    //   30: iload_1
    //   31: if_icmpge +106 -> 137
    //   34: invokestatic 180	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   37: new 94	java/lang/StringBuilder
    //   40: dup
    //   41: ldc -74
    //   43: invokespecial 185	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   46: aload 6
    //   48: iload_0
    //   49: invokeinterface 108 2 0
    //   54: checkcast 110	java/lang/String
    //   57: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokevirtual 189	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   66: astore_3
    //   67: new 191	java/io/BufferedReader
    //   70: dup
    //   71: new 193	java/io/InputStreamReader
    //   74: dup
    //   75: aload_3
    //   76: invokevirtual 199	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   79: invokespecial 202	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   82: invokespecial 205	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   85: astore 5
    //   87: aload 5
    //   89: invokevirtual 208	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   92: astore_2
    //   93: aload_2
    //   94: ifnull +46 -> 140
    //   97: aload 7
    //   99: aload_2
    //   100: invokeinterface 212 2 0
    //   105: pop
    //   106: goto -19 -> 87
    //   109: astore_2
    //   110: aload_3
    //   111: astore 4
    //   113: aload 5
    //   115: astore_3
    //   116: aload_3
    //   117: ifnull +7 -> 124
    //   120: aload_3
    //   121: invokevirtual 215	java/io/BufferedReader:close	()V
    //   124: aload 4
    //   126: ifnull +8 -> 134
    //   129: aload 4
    //   131: invokevirtual 218	java/lang/Process:destroy	()V
    //   134: aload_2
    //   135: athrow
    //   136: astore_2
    //   137: aload 7
    //   139: areturn
    //   140: aload 5
    //   142: invokevirtual 215	java/io/BufferedReader:close	()V
    //   145: aload_3
    //   146: ifnull +7 -> 153
    //   149: aload_3
    //   150: invokevirtual 218	java/lang/Process:destroy	()V
    //   153: iload_0
    //   154: iconst_1
    //   155: iadd
    //   156: istore_0
    //   157: aload 5
    //   159: astore_2
    //   160: aload_3
    //   161: astore 4
    //   163: goto -142 -> 21
    //   166: astore_2
    //   167: goto -22 -> 145
    //   170: astore_3
    //   171: goto -47 -> 124
    //   174: astore 5
    //   176: aload_2
    //   177: astore_3
    //   178: aload 5
    //   180: astore_2
    //   181: goto -65 -> 116
    //   184: astore 6
    //   186: aload_2
    //   187: astore 4
    //   189: aload_3
    //   190: astore 5
    //   192: aload 6
    //   194: astore_2
    //   195: aload 4
    //   197: astore_3
    //   198: aload 5
    //   200: astore 4
    //   202: goto -86 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   17	140	0	j	int
    //   28	4	1	k	int
    //   1	99	2	str	String
    //   109	26	2	localObject1	Object
    //   136	1	2	localThrowable	Throwable
    //   159	1	2	localObject2	Object
    //   166	11	2	localIOException1	IOException
    //   180	15	2	localObject3	Object
    //   66	95	3	localObject4	Object
    //   170	1	3	localIOException2	IOException
    //   177	21	3	localObject5	Object
    //   19	182	4	localObject6	Object
    //   85	73	5	localBufferedReader	BufferedReader
    //   174	5	5	localObject7	Object
    //   190	9	5	localObject8	Object
    //   14	33	6	localList	List
    //   184	9	6	localObject9	Object
    //   9	129	7	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   87	93	109	finally
    //   97	106	109	finally
    //   11	16	136	java/lang/Throwable
    //   21	29	136	java/lang/Throwable
    //   120	124	136	java/lang/Throwable
    //   129	134	136	java/lang/Throwable
    //   134	136	136	java/lang/Throwable
    //   140	145	136	java/lang/Throwable
    //   149	153	136	java/lang/Throwable
    //   140	145	166	java/io/IOException
    //   120	124	170	java/io/IOException
    //   34	67	174	finally
    //   67	87	184	finally
  }
  
  private static List<String> i()
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    Process localProcess = Runtime.getRuntime().exec("netcfg");
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getInputStream()));
    for (;;)
    {
      String str = localBufferedReader.readLine();
      if (str == null) {
        break;
      }
      if ((str.contains("UP")) && (!str.contains("0.0.0.0/0"))) {
        localArrayList.add(str.split(" ")[0]);
      }
    }
    localBufferedReader.close();
    localProcess.destroy();
    return localArrayList;
  }
  
  private void j()
  {
    if (this.i.get()) {}
    label208:
    for (;;)
    {
      return;
      Object localObject = this.e.b;
      List localList = this.h.p;
      boolean bool = this.h.b;
      this.h.r = ((List)localObject).size();
      localObject = ((List)localObject).iterator();
      int j = 1;
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label208;
        }
        String str = (String)((Iterator)localObject).next();
        com.mato.sdk.e.b.a.e locale = new com.mato.sdk.e.b.a.e(str);
        if (bool)
        {
          if (this.i.get()) {
            break;
          }
          locale.c = new com.mato.sdk.e.b.a.c(this, str, true).a();
        }
        if (this.i.get()) {
          break;
        }
        locale.b = new com.mato.sdk.e.b.a.c(this, str, false).a();
        localList.add(locale);
        if ((this.c != null) && (!this.i.get()))
        {
          this.h.q = j;
          this.c.b(this.h);
        }
        j += 1;
      }
    }
  }
  
  private void k()
  {
    if (this.i.get()) {}
    for (;;)
    {
      return;
      Object localObject2 = this.e.a;
      Object localObject1 = this.h.o;
      this.h.t = ((List)localObject2).size();
      Object localObject3;
      if (this.h.b)
      {
        localObject3 = this.h;
        ((g)localObject3).t += 1;
      }
      localObject2 = ((List)localObject2).iterator();
      int j = 1;
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label131;
        }
        localObject3 = (String)((Iterator)localObject2).next();
        if (this.i.get()) {
          break;
        }
        ((List)localObject1).add(com.mato.sdk.e.b.b.b.a((String)localObject3));
        b(j);
        j += 1;
      }
      label131:
      if (this.d.e == null) {}
      for (localObject1 = ""; (this.h.b) && (!TextUtils.isEmpty((CharSequence)localObject1)); localObject1 = this.d.e.a())
      {
        localObject2 = com.mato.sdk.e.b.b.b.a((String)localObject1);
        this.h.n.add(new com.mato.sdk.e.b.b.a("maa", (String)localObject1, (com.mato.sdk.e.b.b.c)localObject2));
        b(j);
        return;
      }
    }
  }
  
  private String l()
  {
    if (this.d.e == null) {
      return "";
    }
    return this.d.e.a();
  }
  
  private void m()
  {
    this.g = com.mato.sdk.proxy.a.b().k();
    com.mato.sdk.proxy.a.b().a(this.d.d);
    this.f = new a(this.d);
    this.f.a();
    this.h = new g();
    this.h.b = com.mato.sdk.proxy.a.b().j();
    if (!this.h.b) {
      this.h.m = com.mato.sdk.proxy.g.a(this.b).b("bypass_reason", "");
    }
    Object localObject2 = com.mato.sdk.proxy.a.b().l();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = com.mato.sdk.proxy.a.b().m().f();
      localObject2 = com.mato.sdk.g.i.b((String)localObject1);
      if (!com.mato.sdk.c.d.e.a((Object[])localObject2)) {
        break label205;
      }
    }
    for (localObject1 = new f((String)localObject1, (String)localObject1);; localObject1 = new f((String)localObject1, localObject2[0]))
    {
      this.d.e = ((f)localObject1);
      ((f)localObject1).toString();
      localObject1 = new b(".*", this.d.e.a());
      localObject2 = ((b)localObject1).a;
      localObject2 = ((b)localObject1).b;
      com.mato.sdk.proxy.a.b().a((b)localObject1, this.d.f);
      return;
      label205:
      Object localObject3 = localObject2[0];
    }
  }
  
  private void n()
  {
    b localb = new b(".*", this.d.e.a());
    String str = localb.a;
    str = localb.b;
    com.mato.sdk.proxy.a.b().a(localb, this.d.f);
  }
  
  private static f o()
  {
    Object localObject = com.mato.sdk.proxy.a.b().l();
    if (localObject != null) {
      return (f)localObject;
    }
    localObject = com.mato.sdk.proxy.a.b().m().f();
    String[] arrayOfString = com.mato.sdk.g.i.b((String)localObject);
    if (com.mato.sdk.c.d.e.a(arrayOfString)) {
      return new f((String)localObject, (String)localObject);
    }
    String str = arrayOfString[0];
    return new f((String)localObject, arrayOfString[0]);
  }
  
  private void p()
  {
    try
    {
      com.mato.sdk.proxy.a.b().a(this.g);
      this.f.b();
      com.mato.sdk.proxy.a.b().a(null, this.d.f);
      if ((this.c != null) && (!this.i.get())) {
        this.c.c(this.h);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        localThrowable = localThrowable;
      } while ((this.c == null) || (this.i.get()));
      this.c.c(this.h);
      return;
    }
    finally
    {
      localObject = finally;
      if ((this.c != null) && (!this.i.get())) {
        this.c.c(this.h);
      }
      throw ((Throwable)localObject);
    }
  }
  
  public final void a()
  {
    this.i.set(true);
  }
  
  public final void a(d.a parama)
  {
    if (this.f != null) {
      this.f.a(parama);
    }
  }
  
  public final void b(d.a parama)
  {
    if (this.f != null) {
      this.f.b(parama);
    }
  }
  
  public final boolean b()
  {
    return this.i.get();
  }
  
  public final c e()
  {
    return this.d;
  }
  
  public final void run()
  {
    int k = 1;
    if (this.i.get()) {
      return;
    }
    label843:
    for (;;)
    {
      try
      {
        this.g = com.mato.sdk.proxy.a.b().k();
        com.mato.sdk.proxy.a.b().a(this.d.d);
        this.f = new a(this.d);
        this.f.a();
        this.h = new g();
        this.h.b = com.mato.sdk.proxy.a.b().j();
        if (!this.h.b) {
          this.h.m = com.mato.sdk.proxy.g.a(this.b).b("bypass_reason", "");
        }
        Object localObject4 = com.mato.sdk.proxy.a.b().l();
        Object localObject1 = localObject4;
        int j;
        if (localObject4 == null)
        {
          localObject1 = com.mato.sdk.proxy.a.b().m().f();
          localObject4 = com.mato.sdk.g.i.b((String)localObject1);
          if (com.mato.sdk.c.d.e.a((Object[])localObject4)) {
            localObject1 = new f((String)localObject1, (String)localObject1);
          }
        }
        else
        {
          this.d.e = ((f)localObject1);
          ((f)localObject1).toString();
          localObject1 = new b(".*", this.d.e.a());
          localObject4 = ((b)localObject1).a;
          localObject4 = ((b)localObject1).b;
          com.mato.sdk.proxy.a.b().a((b)localObject1, this.d.f);
          localObject1 = com.mato.sdk.proxy.a.a();
          this.h.e = ((com.mato.sdk.b.e)localObject1).e();
          this.h.d = ((com.mato.sdk.b.e)localObject1).d();
          this.h.f = com.mato.sdk.proxy.a.b().h().a();
          this.h.k = ((com.mato.sdk.b.e)localObject1).i();
          this.h.h = com.mato.sdk.g.i.h(this.b);
          this.h.g = d();
          this.h.j = h();
          this.h.i = c();
          if ((this.c != null) && (!this.i.get())) {
            this.c.d(this.h);
          }
          if (this.i.get()) {
            continue;
          }
          localObject4 = this.e.b;
          localObject1 = this.h.p;
          boolean bool = this.h.b;
          this.h.r = ((List)localObject4).size();
          localObject4 = ((List)localObject4).iterator();
          j = 1;
          if (!((Iterator)localObject4).hasNext()) {
            continue;
          }
          localObject5 = (String)((Iterator)localObject4).next();
          com.mato.sdk.e.b.a.e locale = new com.mato.sdk.e.b.a.e((String)localObject5);
          if (bool)
          {
            if (this.i.get()) {
              continue;
            }
            locale.c = new com.mato.sdk.e.b.a.c(this, (String)localObject5, true).a();
          }
          if (this.i.get()) {
            continue;
          }
          locale.b = new com.mato.sdk.e.b.a.c(this, (String)localObject5, false).a();
          ((List)localObject1).add(locale);
          if ((this.c == null) || (this.i.get())) {
            break label843;
          }
          this.h.q = j;
          this.c.b(this.h);
          break label843;
        }
        Object localObject5 = localObject4[0];
        localObject1 = new f((String)localObject1, localObject4[0]);
        continue;
        Object localObject2;
        j += 1;
      }
      catch (Throwable localThrowable)
      {
        return;
        if (!this.i.get())
        {
          localObject4 = this.e.a;
          localObject2 = this.h.o;
          this.h.t = ((List)localObject4).size();
          if (this.h.b)
          {
            localObject5 = this.h;
            ((g)localObject5).t += 1;
          }
          localObject4 = ((List)localObject4).iterator();
          j = k;
          if (((Iterator)localObject4).hasNext())
          {
            localObject5 = (String)((Iterator)localObject4).next();
            if (!this.i.get())
            {
              ((List)localObject2).add(com.mato.sdk.e.b.b.b.a((String)localObject5));
              b(j);
              j += 1;
            }
          }
          else
          {
            if (this.d.e != null) {
              continue;
            }
            localObject2 = "";
            if ((this.h.b) && (!TextUtils.isEmpty((CharSequence)localObject2)))
            {
              localObject4 = com.mato.sdk.e.b.b.b.a((String)localObject2);
              this.h.n.add(new com.mato.sdk.e.b.b.a("maa", (String)localObject2, (com.mato.sdk.e.b.b.c)localObject4));
              b(j);
            }
          }
        }
        return;
        localObject2 = this.d.e.a();
      }
      finally
      {
        p();
      }
    }
  }
  
  static final class a
    implements d.a
  {
    private final List<d.a> a;
    private final FileOutputStream b;
    private final AtomicBoolean c;
    private final String d;
    
    public a(c paramc)
    {
      this.d = paramc.a;
      e.f();
      String str = this.d;
      str = paramc.c;
      try
      {
        paramc = new FileOutputStream(paramc.c);
        this.b = paramc;
        this.c = new AtomicBoolean(false);
        this.a = new LinkedList();
        return;
      }
      catch (Exception paramc)
      {
        for (;;)
        {
          paramc = null;
        }
      }
    }
    
    private void b(String paramString)
    {
      if ((this.b == null) || (this.c.get())) {
        return;
      }
      e.f();
      try
      {
        this.b.write(paramString.getBytes("utf-8"));
        this.b.write("\n".getBytes());
        return;
      }
      catch (IOException paramString) {}
    }
    
    private void c()
    {
      if ((this.b == null) || (this.c.get())) {
        return;
      }
      this.c.set(true);
      try
      {
        this.b.close();
        return;
      }
      catch (IOException localIOException) {}
    }
    
    public final void a()
    {
      d.a(this.d, this);
    }
    
    public final void a(d.a parama)
    {
      synchronized (this.a)
      {
        this.a.add(parama);
        return;
      }
    }
    
    public final void a(String paramString)
    {
      synchronized (this.a)
      {
        Iterator localIterator = this.a.iterator();
        if (localIterator.hasNext()) {
          ((d.a)localIterator.next()).a(paramString);
        }
      }
      if ((this.b == null) || (this.c.get())) {
        return;
      }
      e.f();
      try
      {
        this.b.write(paramString.getBytes("utf-8"));
        this.b.write("\n".getBytes());
        return;
      }
      catch (IOException paramString) {}
    }
    
    public final void b()
    {
      d.b(this.d);
      if ((this.b == null) || (this.c.get())) {
        return;
      }
      this.c.set(true);
      try
      {
        this.b.close();
        return;
      }
      catch (IOException localIOException) {}
    }
    
    public final void b(d.a parama)
    {
      synchronized (this.a)
      {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext()) {
          if (parama == localIterator.next()) {
            localIterator.remove();
          }
        }
        return;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */