package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.xmpush.thrift.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class aw
{
  private static aw a = new aw();
  private static ExecutorService b = Executors.newSingleThreadExecutor();
  private Context c;
  private Map<String, b> d = new HashMap();
  private String e;
  private final ArrayList<av.b> f = new ArrayList();
  
  public static aw a()
  {
    return a;
  }
  
  private void a(av.b paramb)
  {
    f localf = new f(null);
    localf.a = paramb;
    b.execute(localf);
  }
  
  private b c()
  {
    Object localObject = (b)this.d.get("UPLOADER_FROM_MIPUSHCLIENT");
    if (localObject != null) {}
    b localb;
    do
    {
      return (b)localObject;
      localb = (b)this.d.get("UPLOADER_FROM_XMPUSHSERVICE");
      localObject = localb;
    } while (localb != null);
    return null;
  }
  
  private boolean c(String paramString)
  {
    b.c("TinyDataManager is checking and uploading tiny data, reason is " + paramString + ", the size of pending list is " + this.f.size());
    if (b()) {}
    Object localObject1;
    do
    {
      return false;
      localObject1 = c();
    } while (localObject1 == null);
    Object localObject2 = new ArrayList();
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      av.b localb = (av.b)localIterator.next();
      if ((localb.c.a != null) && (((b)localObject1).a(localb))) {
        ((ArrayList)localObject2).add(localb);
      }
    }
    if (((ArrayList)localObject2).size() != 0)
    {
      ((b)localObject1).a((ArrayList)localObject2);
      localObject1 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (av.b)((Iterator)localObject1).next();
        b.c("Pending Data " + ((av.b)localObject2).toString() + " uploaded by TinyDataManager, reason is " + paramString);
        this.f.remove(localObject2);
      }
    }
    return true;
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null)
    {
      b.d("[TinyDataManager]:context is null, TinyDataManager.init(Context, TinyDataUploader) failed.");
      return;
    }
    c localc = new c();
    c.a(localc, paramContext);
    b.execute(localc);
  }
  
  public void a(b paramb, String paramString)
  {
    if (paramb == null)
    {
      b.d("[TinyDataManager]: please do not add null uploader to TinyDataManager.");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      b.d("[TinyDataManager]: can not add a provider from unkown resource.");
      return;
    }
    a locala = new a();
    locala.b = paramString;
    locala.a = paramb;
    b.execute(locala);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(this.e))
    {
      b.d("[TinyDataManager]:channel is not null, please do not set repeatly.");
      return;
    }
    e locale = new e(null);
    locale.a = paramString;
    b.execute(locale);
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, long paramLong, String paramString3)
  {
    return a(paramInt, paramString1, paramString2, paramLong, paramString3, true);
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, long paramLong, String paramString3, boolean paramBoolean)
  {
    if (av.a(paramString1, paramString2, paramLong, paramString3)) {
      return false;
    }
    av.b localb = new av.b();
    localb.b = paramInt;
    localb.c.g = paramString1;
    localb.c.c = paramString2;
    localb.c.d = paramLong;
    localb.c.b = paramString3;
    localb.c.f = paramBoolean;
    localb.c.e = System.currentTimeMillis();
    a(localb);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    return a(0, paramString1, paramString2, paramLong, paramString3);
  }
  
  public void b(String paramString)
  {
    b.execute(new d(paramString));
  }
  
  public boolean b()
  {
    return this.c == null;
  }
  
  public class a
    implements Runnable
  {
    aw.b a;
    String b;
    
    public a() {}
    
    public void run()
    {
      aw.b(aw.this).put(this.b, this.a);
      aw.a(aw.this, "Add uploader, provider is " + this.b);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(ArrayList<av.b> paramArrayList);
    
    public abstract boolean a(av.b paramb);
  }
  
  public class c
    implements Runnable
  {
    private Context b;
    
    public c() {}
    
    public void run()
    {
      if (aw.a(aw.this) != null)
      {
        b.d("[TinyDataManager]: please do not init TinyDataManager repeatly.");
        return;
      }
      aw.a(aw.this, this.b);
      av.a locala = new av.a(this.b);
      aw.this.a(locala, "SHORT_UPLOADER_FROM_SELF");
      aw.a(aw.this, "Init");
    }
  }
  
  private class d
    implements Runnable
  {
    String a;
    
    public d(String paramString)
    {
      this.a = paramString;
    }
    
    public void run()
    {
      aw.a(aw.this, this.a);
    }
  }
  
  private class e
    implements Runnable
  {
    String a;
    
    private e() {}
    
    public void run()
    {
      if (!TextUtils.isEmpty(aw.c(aw.this)))
      {
        b.d("[TinyDataManager]:channel is not null, please do not set repeatly.");
        return;
      }
      aw.b(aw.this, this.a);
      int i = 0;
      while (i < aw.d(aw.this).size())
      {
        av.b localb = (av.b)aw.d(aw.this).get(i);
        if ((!localb.c.f) && (localb.c.a == null)) {
          localb.c.a = this.a;
        }
        i += 1;
      }
      aw.a(aw.this, "Set channel to " + this.a);
    }
  }
  
  private class f
    implements Runnable
  {
    av.b a;
    
    private f() {}
    
    public void run()
    {
      int k = 1;
      aw.b localb;
      Object localObject2;
      int j;
      int i;
      Object localObject1;
      if (this.a.c.f)
      {
        this.a.c.a = "push_sdk_channel";
        this.a.a = av.a();
        localb = aw.e(aw.this);
        localObject2 = null;
        j = 0;
        if (localb == null)
        {
          localObject2 = "uploader is null";
          j = 1;
        }
        i = j;
        localObject1 = localObject2;
        if (j == 0)
        {
          i = j;
          localObject1 = localObject2;
          if (aw.this.b())
          {
            localObject1 = "TinyDataManager need init";
            i = 1;
          }
        }
        j = i;
        localObject2 = localObject1;
        if (i == 0)
        {
          j = i;
          localObject2 = localObject1;
          if (this.a.c.a == null)
          {
            localObject2 = "request channel is null";
            j = 1;
          }
        }
        if ((j != 0) || (localb.a(this.a))) {
          break label283;
        }
        localObject1 = "uploader refuse upload";
        i = k;
      }
      for (;;)
      {
        if (i != 0)
        {
          b.c(this.a.toString() + " is added to pending list. Pending Reason is " + (String)localObject1);
          aw.d(aw.this).add(this.a);
          return;
          this.a.c.a = aw.c(aw.this);
          break;
        }
        b.c(this.a.toString() + " is uploaded immediately.");
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(this.a);
        localb.a((ArrayList)localObject1);
        return;
        label283:
        i = j;
        localObject1 = localObject2;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */