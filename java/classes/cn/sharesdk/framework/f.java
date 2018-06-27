package cn.sharesdk.framework;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Message;
import android.text.TextUtils;
import cn.sharesdk.framework.b.a;
import cn.sharesdk.framework.utils.d;
import com.mob.MobSDK;
import com.mob.commons.eventrecoder.EventRecorder;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class f
  extends d
{
  private a b;
  private HashMap<String, HashMap<String, String>> c = new HashMap();
  private ArrayList<Platform> d = new ArrayList();
  private HashMap<String, Integer> e = new HashMap();
  private HashMap<Integer, String> f = new HashMap();
  private HashMap<Integer, CustomPlatform> g = new HashMap();
  private HashMap<Integer, HashMap<String, Object>> h = new HashMap();
  private HashMap<Integer, Service> i = new HashMap();
  private boolean j = true;
  private boolean k;
  
  private HashMap<String, Object> a(a parama, HashMap<String, Object> paramHashMap)
  {
    try
    {
      if (paramHashMap.containsKey("error"))
      {
        cn.sharesdk.framework.utils.e.b().i("ShareSDK parse sns config ==>>", new Object[] { new Hashon().fromHashMap(paramHashMap) });
        return null;
      }
      if (!paramHashMap.containsKey("res"))
      {
        cn.sharesdk.framework.utils.e.b().d("ShareSDK platform config result ==>>", new Object[] { "SNS configuration is empty" });
        return null;
      }
      paramHashMap = (String)paramHashMap.get("res");
      if (paramHashMap == null) {
        return null;
      }
      parama = parama.c(paramHashMap);
      return parama;
    }
    catch (Throwable parama)
    {
      cn.sharesdk.framework.utils.e.b().w(parama);
    }
    return null;
  }
  
  private boolean a(HashMap<String, Object> paramHashMap)
  {
    synchronized (this.h)
    {
      paramHashMap = e.a(paramHashMap);
      if ((paramHashMap != null) && (paramHashMap.size() > 0))
      {
        this.h.clear();
        this.h = paramHashMap;
        return true;
      }
      return false;
    }
  }
  
  private void g()
  {
    synchronized (this.c)
    {
      this.c.clear();
      for (;;)
      {
        XmlPullParser localXmlPullParser;
        try
        {
          Object localObject1 = XmlPullParserFactory.newInstance();
          ((XmlPullParserFactory)localObject1).setNamespaceAware(true);
          localXmlPullParser = ((XmlPullParserFactory)localObject1).newPullParser();
          localObject1 = null;
          try
          {
            localObject3 = MobSDK.getContext().getAssets().open("ShareSDK.xml");
            localObject1 = localObject3;
          }
          catch (Throwable localThrowable2)
          {
            Object localObject3;
            int n;
            cn.sharesdk.framework.utils.e.b().d(localThrowable2);
            continue;
          }
          localXmlPullParser.setInput((InputStream)localObject1, "utf-8");
          m = localXmlPullParser.getEventType();
          if (m == 1) {
            break;
          }
          if (m == 2)
          {
            localObject3 = localXmlPullParser.getName();
            HashMap localHashMap2 = new HashMap();
            n = localXmlPullParser.getAttributeCount();
            m = 0;
            if (m < n)
            {
              localHashMap2.put(localXmlPullParser.getAttributeName(m), localXmlPullParser.getAttributeValue(m).trim());
              m += 1;
              continue;
            }
            this.c.put(localThrowable2, localHashMap2);
          }
        }
        catch (Throwable localThrowable1)
        {
          cn.sharesdk.framework.utils.e.b().d(localThrowable1);
          return;
        }
        int m = localXmlPullParser.next();
      }
      localThrowable1.close();
    }
  }
  
  public Platform a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      Platform[] arrayOfPlatform = b();
      if (arrayOfPlatform != null)
      {
        int n = arrayOfPlatform.length;
        int m = 0;
        while (m < n)
        {
          Platform localPlatform = arrayOfPlatform[m];
          if (paramString.equals(localPlatform.getName())) {
            return localPlatform;
          }
          m += 1;
        }
      }
    }
  }
  
  public String a(int paramInt, String paramString)
  {
    for (;;)
    {
      synchronized (this.h)
      {
        HashMap localHashMap2 = (HashMap)this.h.get(Integer.valueOf(paramInt));
        if (localHashMap2 == null) {
          return null;
        }
        paramString = localHashMap2.get(paramString);
        if (paramString == null)
        {
          paramString = null;
          return paramString;
        }
      }
      paramString = String.valueOf(paramString);
    }
  }
  
  public String a(Bitmap paramBitmap)
  {
    if (a.b != this.b) {
      return null;
    }
    return a.a().a(paramBitmap);
  }
  
  public String a(String paramString1, boolean paramBoolean, int paramInt, String paramString2)
  {
    if (a.b != this.b) {
      return paramString1;
    }
    return a.a().a(paramString1, paramInt, paramBoolean, paramString2);
  }
  
  public void a()
  {
    this.b = a.a;
    cn.sharesdk.framework.utils.e.a();
    EventRecorder.prepare();
    g();
    super.a();
  }
  
  public void a(int paramInt)
  {
    com.mob.tools.network.NetworkHelper.connectionTimeout = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized (this.h)
    {
      HashMap localHashMap2 = (HashMap)this.h.get(Integer.valueOf(paramInt1));
      this.h.put(Integer.valueOf(paramInt2), localHashMap2);
      return;
    }
  }
  
  public void a(int paramInt, Platform paramPlatform)
  {
    e.a(paramInt, paramPlatform);
  }
  
  protected void a(Message arg1)
  {
    for (;;)
    {
      ArrayList localArrayList;
      synchronized (this.i)
      {
        localArrayList = this.d;
        try
        {
          localObject2 = EventRecorder.checkRecord("SHARESDK");
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            a.a().a(null);
            cn.sharesdk.framework.utils.e.b().w("EventRecorder checkRecord result ==" + (String)localObject2);
            f();
          }
          EventRecorder.clear();
        }
        catch (Throwable localThrowable2)
        {
          Object localObject2;
          cn.sharesdk.framework.utils.e.b().w(localThrowable2);
          continue;
        }
        finally
        {
          this.b = a.b;
          this.d.notify();
          this.i.notify();
        }
        try
        {
          this.d.clear();
          localObject2 = e.a();
          if (localObject2 != null) {
            this.d.addAll((Collection)localObject2);
          }
          localObject2 = this.d.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            Platform localPlatform = (Platform)((Iterator)localObject2).next();
            this.f.put(Integer.valueOf(localPlatform.getPlatformId()), localPlatform.getName());
            this.e.put(localPlatform.getName(), Integer.valueOf(localPlatform.getPlatformId()));
            continue;
            try
            {
              this.b = a.b;
              this.d.notify();
              this.i.notify();
              return;
            }
            finally {}
          }
        }
        catch (Throwable localThrowable1)
        {
          cn.sharesdk.framework.utils.e.b().w(localThrowable1);
        }
      }
      e.a(this.a);
      this.b = a.b;
      new Thread()
      {
        public void run()
        {
          f.this.e();
        }
      }.start();
      this.b = a.b;
      this.d.notify();
      this.i.notify();
    }
  }
  
  public void a(Class<? extends Service> paramClass)
  {
    synchronized (this.i)
    {
      if (this.i.containsKey(Integer.valueOf(paramClass.hashCode()))) {
        return;
      }
    }
    try
    {
      Service localService = (Service)paramClass.newInstance();
      this.i.put(Integer.valueOf(paramClass.hashCode()), localService);
      localService.onBind();
      return;
      paramClass = finally;
      throw paramClass;
    }
    catch (Throwable paramClass)
    {
      for (;;)
      {
        cn.sharesdk.framework.utils.e.b().w(paramClass);
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    e.a(paramString, paramInt);
  }
  
  public void a(String paramString1, String paramString2)
  {
    synchronized (this.c)
    {
      paramString1 = (HashMap)this.c.get(paramString1);
      this.c.put(paramString2, paramString1);
      return;
    }
  }
  
  public void a(String paramString, HashMap<String, Object> arg2)
  {
    label228:
    for (;;)
    {
      synchronized (this.c)
      {
        ??? = (HashMap)this.c.get(paramString);
        if (??? != null) {
          break label228;
        }
        synchronized (new HashMap())
        {
          ??? = ???.entrySet().iterator();
          if (???.hasNext())
          {
            Object localObject3 = (Map.Entry)???.next();
            String str = (String)((Map.Entry)localObject3).getKey();
            localObject3 = ((Map.Entry)localObject3).getValue();
            if (localObject3 == null) {
              continue;
            }
            ((HashMap)???).put(str, String.valueOf(localObject3));
          }
        }
      }
      this.c.put(paramString, ???);
      synchronized (this.d)
      {
        ??? = this.b;
        ??? = a.a;
        if (??? == ???) {}
        try
        {
          this.d.wait();
          ??? = this.d.iterator();
          while (???.hasNext())
          {
            ??? = (Platform)???.next();
            if ((??? != null) && (((Platform)???).getName().equals(paramString))) {
              ((Platform)???).a();
            }
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            cn.sharesdk.framework.utils.e.b().w(localThrowable);
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  /* Error */
  public int b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 48	cn/sharesdk/framework/f:d	Ljava/util/ArrayList;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 54	cn/sharesdk/framework/f:g	Ljava/util/HashMap;
    //   11: astore 4
    //   13: aload 4
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield 50	cn/sharesdk/framework/f:e	Ljava/util/HashMap;
    //   20: aload_1
    //   21: invokevirtual 68	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   24: ifeq +25 -> 49
    //   27: aload_0
    //   28: getfield 50	cn/sharesdk/framework/f:e	Ljava/util/HashMap;
    //   31: aload_1
    //   32: invokevirtual 101	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   35: checkcast 223	java/lang/Integer
    //   38: invokevirtual 384	java/lang/Integer:intValue	()I
    //   41: istore_2
    //   42: aload 4
    //   44: monitorexit
    //   45: aload_3
    //   46: monitorexit
    //   47: iload_2
    //   48: ireturn
    //   49: aload 4
    //   51: monitorexit
    //   52: aload_3
    //   53: monitorexit
    //   54: iconst_0
    //   55: ireturn
    //   56: astore_1
    //   57: aload_3
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    //   61: astore_1
    //   62: aload 4
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	f
    //   0	67	1	paramString	String
    //   41	7	2	m	int
    //   4	54	3	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   7	16	56	finally
    //   45	47	56	finally
    //   52	54	56	finally
    //   57	59	56	finally
    //   65	67	56	finally
    //   16	45	61	finally
    //   49	52	61	finally
    //   62	65	61	finally
  }
  
  public String b(String paramString1, String paramString2)
  {
    synchronized (this.c)
    {
      paramString1 = (HashMap)this.c.get(paramString1);
      if (paramString1 == null) {
        return null;
      }
      paramString1 = (String)paramString1.get(paramString2);
      return paramString1;
    }
  }
  
  public void b(int paramInt)
  {
    com.mob.tools.network.NetworkHelper.readTimout = paramInt;
  }
  
  protected void b(Message paramMessage) {}
  
  public void b(Class<? extends Service> paramClass)
  {
    synchronized (this.i)
    {
      int m = paramClass.hashCode();
      if (this.i.containsKey(Integer.valueOf(m)))
      {
        ((Service)this.i.get(Integer.valueOf(m))).onUnbind();
        this.i.remove(Integer.valueOf(m));
      }
      return;
    }
  }
  
  public Platform[] b()
  {
    long l = System.currentTimeMillis();
    Object localObject4;
    synchronized (this.d)
    {
      Object localObject1 = this.b;
      localObject4 = a.a;
      if (localObject1 == localObject4) {}
      try
      {
        this.d.wait();
        ??? = new ArrayList();
        localObject1 = this.d.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (Platform)((Iterator)localObject1).next();
          if ((localObject4 != null) && (((Platform)localObject4).b()))
          {
            ((Platform)localObject4).a();
            ???.add(localObject4);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          cn.sharesdk.framework.utils.e.b().w(localThrowable);
        }
      }
    }
    e.a(???);
    Object localObject3 = this.g.entrySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Platform)((Map.Entry)((Iterator)localObject3).next()).getValue();
      if ((localObject4 != null) && (((Platform)localObject4).b())) {
        ???.add(localObject4);
      }
    }
    if (???.size() <= 0) {
      return null;
    }
    localObject3 = new Platform[???.size()];
    int m = 0;
    while (m < localObject3.length)
    {
      localObject3[m] = ((Platform)???.get(m));
      m += 1;
    }
    cn.sharesdk.framework.utils.e.b().i("sort list use time: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    return (Platform[])localObject3;
  }
  
  /* Error */
  public <T extends Service> T c(Class<T> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 58	cn/sharesdk/framework/f:i	Ljava/util/HashMap;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 234	cn/sharesdk/framework/f:b	Lcn/sharesdk/framework/f$a;
    //   11: astore_3
    //   12: getstatic 245	cn/sharesdk/framework/f$a:a	Lcn/sharesdk/framework/f$a;
    //   15: astore 4
    //   17: aload_3
    //   18: aload 4
    //   20: if_acmpne +10 -> 30
    //   23: aload_0
    //   24: getfield 58	cn/sharesdk/framework/f:i	Ljava/util/HashMap;
    //   27: invokevirtual 377	java/lang/Object:wait	()V
    //   30: aload_1
    //   31: aload_0
    //   32: getfield 58	cn/sharesdk/framework/f:i	Ljava/util/HashMap;
    //   35: aload_1
    //   36: invokevirtual 344	java/lang/Object:hashCode	()I
    //   39: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   42: invokevirtual 101	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: invokevirtual 423	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   48: checkcast 350	cn/sharesdk/framework/Service
    //   51: astore_1
    //   52: aload_2
    //   53: monitorexit
    //   54: aload_1
    //   55: areturn
    //   56: astore_3
    //   57: invokestatic 73	cn/sharesdk/framework/utils/e:b	()Lcom/mob/tools/log/NLog;
    //   60: aload_3
    //   61: invokevirtual 112	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   64: pop
    //   65: goto -35 -> 30
    //   68: astore_1
    //   69: aload_2
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    //   73: astore_1
    //   74: invokestatic 73	cn/sharesdk/framework/utils/e:b	()Lcom/mob/tools/log/NLog;
    //   77: aload_1
    //   78: invokevirtual 112	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   81: pop
    //   82: aload_2
    //   83: monitorexit
    //   84: aconst_null
    //   85: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	f
    //   0	86	1	paramClass	Class<T>
    //   4	79	2	localHashMap	HashMap
    //   11	7	3	locala1	a
    //   56	5	3	localThrowable	Throwable
    //   15	4	4	locala2	a
    // Exception table:
    //   from	to	target	type
    //   23	30	56	java/lang/Throwable
    //   7	17	68	finally
    //   23	30	68	finally
    //   30	52	68	finally
    //   52	54	68	finally
    //   57	65	68	finally
    //   69	71	68	finally
    //   74	84	68	finally
    //   30	52	73	java/lang/Throwable
  }
  
  public String c(int paramInt)
  {
    synchronized (this.d)
    {
      synchronized (this.g)
      {
        String str = (String)this.f.get(Integer.valueOf(paramInt));
        return str;
      }
    }
  }
  
  public String c(String paramString)
  {
    if (a.b != this.b) {
      return null;
    }
    return a.a().b(paramString);
  }
  
  public boolean c()
  {
    return this.k;
  }
  
  public void d(Class<? extends CustomPlatform> paramClass)
  {
    synchronized (this.g)
    {
      if (this.g.containsKey(Integer.valueOf(paramClass.hashCode()))) {
        return;
      }
      try
      {
        CustomPlatform localCustomPlatform = (CustomPlatform)paramClass.newInstance();
        this.g.put(Integer.valueOf(paramClass.hashCode()), localCustomPlatform);
        if ((localCustomPlatform != null) && (localCustomPlatform.b()))
        {
          this.f.put(Integer.valueOf(localCustomPlatform.getPlatformId()), localCustomPlatform.getName());
          this.e.put(localCustomPlatform.getName(), Integer.valueOf(localCustomPlatform.getPlatformId()));
        }
      }
      catch (Throwable paramClass)
      {
        for (;;)
        {
          cn.sharesdk.framework.utils.e.b().w(paramClass);
        }
      }
      return;
    }
  }
  
  public boolean d()
  {
    synchronized (this.h)
    {
      return (this.h != null) && (this.h.size() > 0);
    }
  }
  
  public void e(Class<? extends CustomPlatform> arg1)
  {
    int m = ???.hashCode();
    synchronized (this.g)
    {
      this.g.remove(Integer.valueOf(m));
      return;
    }
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (a.b != this.b)
    {
      cn.sharesdk.framework.utils.e.b().d("Statistics module unopened", new Object[0]);
      bool2 = bool1;
    }
    boolean bool3;
    for (;;)
    {
      return bool2;
      final a locala = a.a();
      HashMap localHashMap1 = a(locala, locala.e());
      bool1 = bool2;
      if (localHashMap1 != null)
      {
        bool1 = bool2;
        if (localHashMap1.size() > 0) {
          bool1 = a(localHashMap1);
        }
      }
      if (bool1)
      {
        new Thread()
        {
          public void run()
          {
            try
            {
              HashMap localHashMap1 = locala.f();
              HashMap localHashMap2 = f.a(f.this, locala, localHashMap1);
              if ((localHashMap2 != null) && (localHashMap2.size() > 0) && (f.a(f.this, localHashMap2))) {
                locala.a(localHashMap1);
              }
              return;
            }
            catch (Throwable localThrowable)
            {
              cn.sharesdk.framework.utils.e.b().w(localThrowable);
            }
          }
        }.start();
        return bool1;
      }
      bool3 = bool1;
      try
      {
        localHashMap1 = locala.f();
        bool3 = bool1;
        HashMap localHashMap2 = a(locala, localHashMap1);
        bool2 = bool1;
        if (localHashMap2 != null)
        {
          bool2 = bool1;
          bool3 = bool1;
          if (localHashMap2.size() > 0)
          {
            bool3 = bool1;
            bool1 = a(localHashMap2);
            bool2 = bool1;
            if (bool1)
            {
              bool3 = bool1;
              locala.a(localHashMap1);
              return bool1;
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        cn.sharesdk.framework.utils.e.b().w(localThrowable);
      }
    }
    return bool3;
  }
  
  public void f()
  {
    try
    {
      ResHelper.clearCache(MobSDK.getContext());
      return;
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.e.b().w(localThrowable);
    }
  }
  
  private static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */