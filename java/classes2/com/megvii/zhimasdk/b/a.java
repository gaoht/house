package com.megvii.zhimasdk.b;

import android.content.Context;
import com.megvii.zhimasdk.b.a.b.c.j;
import com.megvii.zhimasdk.b.a.e.c.d;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;

public class a
{
  public static m a = new l();
  private final com.megvii.zhimasdk.b.a.i.b.k b;
  private final com.megvii.zhimasdk.b.a.n.e c;
  private final Map<Context, List<p>> d;
  private final Map<String, String> e;
  private int f = 10;
  private int g = 10000;
  private int h = 10000;
  private ExecutorService i;
  private boolean j = true;
  
  public a()
  {
    this(false, 80, 443);
  }
  
  public a(com.megvii.zhimasdk.b.a.e.c.i parami)
  {
    com.megvii.zhimasdk.b.a.l.b localb = new com.megvii.zhimasdk.b.a.l.b();
    com.megvii.zhimasdk.b.a.e.a.a.a(localb, this.g);
    com.megvii.zhimasdk.b.a.e.a.a.a(localb, new com.megvii.zhimasdk.b.a.e.a.c(this.f));
    com.megvii.zhimasdk.b.a.e.a.a.a(localb, 10);
    com.megvii.zhimasdk.b.a.l.c.a(localb, this.h);
    com.megvii.zhimasdk.b.a.l.c.c(localb, this.g);
    com.megvii.zhimasdk.b.a.l.c.a(localb, true);
    com.megvii.zhimasdk.b.a.l.c.b(localb, 8192);
    com.megvii.zhimasdk.b.a.l.f.a(localb, com.megvii.zhimasdk.b.a.v.c);
    parami = a(parami, localb);
    if (parami != null) {}
    for (;;)
    {
      v.a(bool, "Custom implementation of #createConnectionManager(SchemeRegistry, BasicHttpParams) returned null");
      this.i = a();
      this.d = Collections.synchronizedMap(new WeakHashMap());
      this.e = new HashMap();
      this.c = new com.megvii.zhimasdk.b.a.n.n(new com.megvii.zhimasdk.b.a.n.a());
      this.b = new com.megvii.zhimasdk.b.a.i.b.k(parami, localb);
      this.b.a(new com.megvii.zhimasdk.b.a.r()
      {
        public void a(com.megvii.zhimasdk.b.a.q paramAnonymousq, com.megvii.zhimasdk.b.a.n.e paramAnonymouse)
        {
          if (!paramAnonymousq.a("Accept-Encoding")) {
            paramAnonymousq.a("Accept-Encoding", "gzip");
          }
          paramAnonymouse = a.a(a.this).keySet().iterator();
          while (paramAnonymouse.hasNext())
          {
            String str = (String)paramAnonymouse.next();
            if (paramAnonymousq.a(str))
            {
              com.megvii.zhimasdk.b.a.e locale = paramAnonymousq.c(str);
              a.a.b("AsyncHttpClient", String.format("Headers were overwritten! (%s | %s) overwrites (%s | %s)", new Object[] { str, a.a(a.this).get(str), locale.c(), locale.d() }));
              paramAnonymousq.b(locale);
            }
            paramAnonymousq.a(str, (String)a.a(a.this).get(str));
          }
        }
      });
      this.b.a(new com.megvii.zhimasdk.b.a.u()
      {
        public void a(com.megvii.zhimasdk.b.a.s paramAnonymouss, com.megvii.zhimasdk.b.a.n.e paramAnonymouse)
        {
          paramAnonymouse = paramAnonymouss.b();
          if (paramAnonymouse == null) {}
          for (;;)
          {
            return;
            Object localObject = paramAnonymouse.g();
            if (localObject != null)
            {
              localObject = ((com.megvii.zhimasdk.b.a.e)localObject).e();
              int j = localObject.length;
              int i = 0;
              while (i < j)
              {
                if (localObject[i].a().equalsIgnoreCase("gzip"))
                {
                  paramAnonymouss.a(new a.a(paramAnonymouse));
                  return;
                }
                i += 1;
              }
            }
          }
        }
      });
      this.b.a(new com.megvii.zhimasdk.b.a.r()
      {
        public void a(com.megvii.zhimasdk.b.a.q paramAnonymousq, com.megvii.zhimasdk.b.a.n.e paramAnonymouse)
        {
          paramAnonymousq = new com.megvii.zhimasdk.b.a.a.f();
          paramAnonymousq.a("Bearer", new g());
          paramAnonymouse.a("http.authscheme-registry", paramAnonymousq);
          paramAnonymousq = (com.megvii.zhimasdk.b.a.a.h)paramAnonymouse.a("http.auth.target-scope");
          com.megvii.zhimasdk.b.a.b.i locali = (com.megvii.zhimasdk.b.a.b.i)paramAnonymouse.a("http.auth.credentials-provider");
          paramAnonymouse = (com.megvii.zhimasdk.b.a.n)paramAnonymouse.a("http.target_host");
          if (paramAnonymousq.c() == null)
          {
            paramAnonymouse = locali.a(new com.megvii.zhimasdk.b.a.a.g(paramAnonymouse.a(), paramAnonymouse.b()));
            if (!(paramAnonymouse instanceof u)) {
              break label119;
            }
            paramAnonymousq.a(new g.a());
            paramAnonymousq.a(paramAnonymouse);
          }
          label119:
          while (paramAnonymouse == null) {
            return;
          }
          paramAnonymousq.a(new com.megvii.zhimasdk.b.a.i.a.b());
          paramAnonymousq.a(paramAnonymouse);
        }
      }, 0);
      this.b.a(new s(5, 1500));
      return;
      bool = false;
    }
  }
  
  public a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this(a(paramBoolean, paramInt1, paramInt2));
  }
  
  private com.megvii.zhimasdk.b.a.b.c.e a(com.megvii.zhimasdk.b.a.b.c.e parame, com.megvii.zhimasdk.b.a.k paramk)
  {
    if (paramk != null) {
      parame.a(paramk);
    }
    return parame;
  }
  
  private static com.megvii.zhimasdk.b.a.e.c.i a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean) {
      a.b("AsyncHttpClient", "Beware! Using the fix is insecure, as it doesn't verify SSL certificates.");
    }
    int k = paramInt1;
    if (paramInt1 < 1)
    {
      k = 80;
      a.b("AsyncHttpClient", "Invalid HTTP port number specified, defaulting to 80");
    }
    paramInt1 = paramInt2;
    if (paramInt2 < 1)
    {
      paramInt1 = 443;
      a.b("AsyncHttpClient", "Invalid HTTPS port number specified, defaulting to 443");
    }
    if (paramBoolean) {}
    for (com.megvii.zhimasdk.b.a.e.d.g localg = n.b();; localg = com.megvii.zhimasdk.b.a.e.d.g.d())
    {
      com.megvii.zhimasdk.b.a.e.c.i locali = new com.megvii.zhimasdk.b.a.e.c.i();
      locali.a(new com.megvii.zhimasdk.b.a.e.c.e("http", d.a(), k));
      locali.a(new com.megvii.zhimasdk.b.a.e.c.e("https", localg, paramInt1));
      return locali;
    }
  }
  
  private com.megvii.zhimasdk.b.a.k a(q paramq, r paramr)
  {
    com.megvii.zhimasdk.b.a.k localk = null;
    if (paramq != null) {}
    try
    {
      localk = paramq.a(paramr);
      return localk;
    }
    catch (IOException paramq)
    {
      if (paramr != null)
      {
        paramr.b(0, null, null, paramq);
        return null;
      }
      paramq.printStackTrace();
    }
    return null;
  }
  
  public static String a(boolean paramBoolean, String paramString, q paramq)
  {
    Object localObject;
    if (paramString == null)
    {
      localObject = null;
      return (String)localObject;
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        localObject = new URL(URLDecoder.decode(paramString, "UTF-8"));
        localObject = new URI(((URL)localObject).getProtocol(), ((URL)localObject).getUserInfo(), ((URL)localObject).getHost(), ((URL)localObject).getPort(), ((URL)localObject).getPath(), ((URL)localObject).getQuery(), ((URL)localObject).getRef()).toASCIIString();
        paramString = (String)localObject;
        localObject = paramString;
        if (paramq == null) {
          break;
        }
        paramq = paramq.b().trim();
        localObject = paramString;
        if (paramq.equals("")) {
          break;
        }
        localObject = paramString;
        if (paramq.equals("?")) {
          break;
        }
        localObject = new StringBuilder().append(paramString);
        if (!paramString.contains("?")) {
          break label177;
        }
        paramString = "&";
        paramString = paramString;
        return paramString + paramq;
      }
      catch (Exception localException)
      {
        a.b("AsyncHttpClient", "getUrlWithQueryString encoding URL", localException);
      }
      continue;
      label177:
      paramString = "?";
    }
  }
  
  public static void a(com.megvii.zhimasdk.b.a.k paramk)
  {
    if ((paramk instanceof com.megvii.zhimasdk.b.a.g.f)) {}
    for (;;)
    {
      try
      {
        Field[] arrayOfField = com.megvii.zhimasdk.b.a.g.f.class.getDeclaredFields();
        int m = arrayOfField.length;
        int k = 0;
        Field localField;
        if (k < m)
        {
          localField = arrayOfField[k];
          if (localField.getName().equals("wrappedEntity"))
          {
            if (localField != null)
            {
              localField.setAccessible(true);
              paramk = (com.megvii.zhimasdk.b.a.k)localField.get(paramk);
              if (paramk != null) {
                paramk.c();
              }
            }
            return;
          }
          k += 1;
        }
        else
        {
          localField = null;
        }
      }
      catch (Throwable paramk)
      {
        a.b("AsyncHttpClient", "wrappedEntity consume", paramk);
        return;
      }
    }
  }
  
  public static void a(InputStream paramInputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException paramInputStream)
    {
      a.a("AsyncHttpClient", "Cannot close input stream", paramInputStream);
    }
  }
  
  public static void a(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (IOException paramOutputStream)
    {
      a.a("AsyncHttpClient", "Cannot close output stream", paramOutputStream);
    }
  }
  
  public static boolean a(PushbackInputStream paramPushbackInputStream)
  {
    boolean bool = true;
    if (paramPushbackInputStream == null) {
      return false;
    }
    byte[] arrayOfByte = new byte[2];
    int k = 0;
    for (;;)
    {
      if (k < 2) {}
      try
      {
        int m = paramPushbackInputStream.read(arrayOfByte, k, 2 - k);
        if (m < 0) {
          return false;
        }
        k += m;
      }
      finally
      {
        paramPushbackInputStream.unread(arrayOfByte, 0, k);
      }
    }
    paramPushbackInputStream.unread(arrayOfByte, 0, k);
    if (35615 == (arrayOfByte[0] & 0xFF | arrayOfByte[1] << 8 & 0xFF00)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  protected com.megvii.zhimasdk.b.a.e.b a(com.megvii.zhimasdk.b.a.e.c.i parami, com.megvii.zhimasdk.b.a.l.b paramb)
  {
    return new com.megvii.zhimasdk.b.a.i.c.a.g(paramb, parami);
  }
  
  protected b a(com.megvii.zhimasdk.b.a.i.b.k paramk, com.megvii.zhimasdk.b.a.n.e parame, j paramj, String paramString, r paramr, Context paramContext)
  {
    return new b(paramk, parame, paramj, paramr);
  }
  
  public p a(Context paramContext, String paramString1, com.megvii.zhimasdk.b.a.k paramk, String paramString2, r paramr)
  {
    return b(this.b, this.c, a(new com.megvii.zhimasdk.b.a.b.c.h(a(paramString1)), paramk), paramString2, paramr, paramContext);
  }
  
  public p a(Context paramContext, String paramString, q paramq, r paramr)
  {
    return b(this.b, this.c, new i(a(this.j, paramString, paramq)), null, paramr, paramContext);
  }
  
  public p a(String paramString, q paramq, r paramr)
  {
    return a(null, paramString, paramq, paramr);
  }
  
  protected URI a(String paramString)
  {
    return URI.create(paramString).normalize();
  }
  
  protected ExecutorService a()
  {
    return Executors.newCachedThreadPool();
  }
  
  public void a(int paramInt)
  {
    int k = paramInt;
    if (paramInt < 1000) {
      k = 10000;
    }
    b(k);
    c(k);
  }
  
  public p b(Context paramContext, String paramString, q paramq, r paramr)
  {
    return a(paramContext, paramString, a(paramq, paramr), null, paramr);
  }
  
  protected p b(com.megvii.zhimasdk.b.a.i.b.k paramk, com.megvii.zhimasdk.b.a.n.e parame, j paramj, String arg4, r paramr, Context paramContext)
  {
    if (paramj == null) {
      throw new IllegalArgumentException("HttpUriRequest must not be null");
    }
    if (paramr == null) {
      throw new IllegalArgumentException("ResponseHandler must not be null");
    }
    if ((paramr.a()) && (!paramr.b())) {
      throw new IllegalArgumentException("Synchronous ResponseHandler used in AsyncHttpClient. You should create your response handler in a looper thread or use SyncHttpClient instead.");
    }
    if (??? != null)
    {
      if ((!(paramj instanceof com.megvii.zhimasdk.b.a.b.c.e)) || (((com.megvii.zhimasdk.b.a.b.c.e)paramj).c() == null) || (!paramj.a("Content-Type"))) {
        break label279;
      }
      a.d("AsyncHttpClient", "Passed contentType will be ignored because HttpEntity sets content type");
    }
    for (;;)
    {
      paramr.a(paramj.e());
      paramr.a(paramj.j());
      paramk = a(paramk, parame, paramj, ???, paramr, paramContext);
      this.i.submit(paramk);
      paramj = new p(paramk);
      if (paramContext != null) {
        synchronized (this.d)
        {
          parame = (List)this.d.get(paramContext);
          paramk = parame;
          if (parame == null)
          {
            paramk = Collections.synchronizedList(new LinkedList());
            this.d.put(paramContext, paramk);
          }
          paramk.add(paramj);
          paramk = paramk.iterator();
          while (paramk.hasNext()) {
            if (((p)paramk.next()).c())
            {
              paramk.remove();
              continue;
              label279:
              paramj.b("Content-Type", ???);
            }
          }
        }
      }
    }
    return paramj;
  }
  
  public p b(String paramString, q paramq, r paramr)
  {
    return b(null, paramString, paramq, paramr);
  }
  
  public void b(int paramInt)
  {
    int k = paramInt;
    if (paramInt < 1000) {
      k = 10000;
    }
    this.g = k;
    com.megvii.zhimasdk.b.a.l.e locale = this.b.q();
    com.megvii.zhimasdk.b.a.e.a.a.a(locale, this.g);
    com.megvii.zhimasdk.b.a.l.c.c(locale, this.g);
  }
  
  public void c(int paramInt)
  {
    int k = paramInt;
    if (paramInt < 1000) {
      k = 10000;
    }
    this.h = k;
    com.megvii.zhimasdk.b.a.l.c.a(this.b.q(), this.h);
  }
  
  private static class a
    extends com.megvii.zhimasdk.b.a.g.f
  {
    InputStream a;
    PushbackInputStream b;
    GZIPInputStream c;
    
    public a(com.megvii.zhimasdk.b.a.k paramk)
    {
      super();
    }
    
    public InputStream a()
    {
      this.a = this.d.a();
      this.b = new PushbackInputStream(this.a, 2);
      if (a.a(this.b))
      {
        this.c = new GZIPInputStream(this.b);
        return this.c;
      }
      return this.b;
    }
    
    public long b()
    {
      if (this.d == null) {
        return 0L;
      }
      return this.d.b();
    }
    
    public void c()
    {
      a.a(this.a);
      a.a(this.b);
      a.a(this.c);
      super.c();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */