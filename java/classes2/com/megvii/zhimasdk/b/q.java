package com.megvii.zhimasdk.b;

import com.megvii.zhimasdk.b.a.b.f.e;
import com.megvii.zhimasdk.b.a.k;
import com.megvii.zhimasdk.b.a.k.l;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class q
  implements Serializable
{
  protected final ConcurrentHashMap<String, String> a = new ConcurrentHashMap();
  protected final ConcurrentHashMap<String, b> b = new ConcurrentHashMap();
  protected final ConcurrentHashMap<String, a> c = new ConcurrentHashMap();
  protected final ConcurrentHashMap<String, List<a>> d = new ConcurrentHashMap();
  protected final ConcurrentHashMap<String, Object> e = new ConcurrentHashMap();
  protected boolean f;
  protected boolean g = false;
  protected boolean h;
  protected String i = "_elapsed";
  protected boolean j;
  protected String k = "UTF-8";
  
  public q()
  {
    this((Map)null);
  }
  
  public q(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        a((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
  }
  
  private k b(r paramr)
  {
    if ((!this.c.isEmpty()) || (!this.b.isEmpty())) {}
    Map.Entry localEntry;
    for (boolean bool = true;; bool = false)
    {
      paramr = new j(paramr, bool, this.i);
      localIterator = this.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        paramr.a((String)localEntry.getKey(), localEntry.getValue());
      }
    }
    Iterator localIterator = this.e.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      paramr.a((String)localEntry.getKey(), localEntry.getValue());
    }
    localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      paramr.a((String)localEntry.getKey(), localEntry.getValue());
    }
    localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      b localb = (b)localEntry.getValue();
      if (localb.a != null) {
        paramr.a((String)localEntry.getKey(), b.a(localb.a, localb.b, localb.c, localb.d));
      }
    }
    return paramr;
  }
  
  private List<l> b(String paramString, Object paramObject)
  {
    LinkedList localLinkedList = new LinkedList();
    if ((paramObject instanceof Map))
    {
      Map localMap = (Map)paramObject;
      paramObject = new ArrayList(localMap.keySet());
      if ((((List)paramObject).size() > 0) && ((((List)paramObject).get(0) instanceof Comparable))) {
        Collections.sort((List)paramObject);
      }
      Iterator localIterator = ((List)paramObject).iterator();
      Object localObject;
      do
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          paramObject = localIterator.next();
        } while (!(paramObject instanceof String));
        localObject = localMap.get(paramObject);
      } while (localObject == null);
      if (paramString == null) {}
      for (paramObject = (String)paramObject;; paramObject = String.format(Locale.US, "%s[%s]", new Object[] { paramString, paramObject }))
      {
        localLinkedList.addAll(b((String)paramObject, localObject));
        break;
      }
    }
    int n;
    int m;
    if ((paramObject instanceof List))
    {
      paramObject = (List)paramObject;
      n = ((List)paramObject).size();
      m = 0;
      while (m < n)
      {
        localLinkedList.addAll(b(String.format(Locale.US, "%s[%d]", new Object[] { paramString, Integer.valueOf(m) }), ((List)paramObject).get(m)));
        m += 1;
      }
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      n = paramObject.length;
      m = 0;
      while (m < n)
      {
        localLinkedList.addAll(b(String.format(Locale.US, "%s[%d]", new Object[] { paramString, Integer.valueOf(m) }), paramObject[m]));
        m += 1;
      }
    }
    if ((paramObject instanceof Set))
    {
      paramObject = ((Set)paramObject).iterator();
      while (((Iterator)paramObject).hasNext()) {
        localLinkedList.addAll(b(paramString, ((Iterator)paramObject).next()));
      }
    }
    localLinkedList.add(new l(paramString, paramObject.toString()));
    return localLinkedList;
  }
  
  private k c()
  {
    try
    {
      com.megvii.zhimasdk.b.a.b.b.a locala = new com.megvii.zhimasdk.b.a.b.b.a(a(), this.k);
      return locala;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      a.a.b("RequestParams", "createFormEntity failed", localUnsupportedEncodingException);
    }
    return null;
  }
  
  private k c(r paramr)
  {
    paramr = new t(paramr);
    paramr.a(this.f);
    Iterator localIterator = this.a.entrySet().iterator();
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      paramr.b((String)((Map.Entry)localObject1).getKey(), (String)((Map.Entry)localObject1).getValue(), this.k);
    }
    localIterator = b(null, this.e).iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (l)localIterator.next();
      paramr.b(((l)localObject1).a(), ((l)localObject1).b(), this.k);
    }
    localIterator = this.b.entrySet().iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      localObject2 = (b)((Map.Entry)localObject1).getValue();
      if (((b)localObject2).a != null) {
        paramr.a((String)((Map.Entry)localObject1).getKey(), ((b)localObject2).b, ((b)localObject2).a, ((b)localObject2).c);
      }
    }
    localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      localObject2 = (a)((Map.Entry)localObject1).getValue();
      paramr.a((String)((Map.Entry)localObject1).getKey(), ((a)localObject2).a, ((a)localObject2).b, ((a)localObject2).c);
    }
    localIterator = this.d.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      localObject2 = ((List)((Map.Entry)localObject1).getValue()).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        a locala = (a)((Iterator)localObject2).next();
        paramr.a((String)((Map.Entry)localObject1).getKey(), locala.a, locala.b, locala.c);
      }
    }
    return paramr;
  }
  
  public k a(r paramr)
  {
    if (this.h) {
      return b(paramr);
    }
    if ((!this.g) && (this.b.isEmpty()) && (this.c.isEmpty()) && (this.d.isEmpty())) {
      return c();
    }
    return c(paramr);
  }
  
  protected List<l> a()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localLinkedList.add(new l((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
    localLinkedList.addAll(b(null, this.e));
    return localLinkedList;
  }
  
  public void a(String paramString, InputStream paramInputStream)
  {
    a(paramString, paramInputStream, null);
  }
  
  public void a(String paramString1, InputStream paramInputStream, String paramString2)
  {
    a(paramString1, paramInputStream, paramString2, null);
  }
  
  public void a(String paramString1, InputStream paramInputStream, String paramString2, String paramString3)
  {
    a(paramString1, paramInputStream, paramString2, paramString3, this.j);
  }
  
  public void a(String paramString1, InputStream paramInputStream, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((paramString1 != null) && (paramInputStream != null)) {
      this.b.put(paramString1, b.a(paramInputStream, paramString2, paramString3, paramBoolean));
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    if ((paramString != null) && (paramObject != null)) {
      this.e.put(paramString, paramObject);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      this.a.put(paramString1, paramString2);
    }
  }
  
  protected String b()
  {
    return e.a(a(), this.k);
  }
  
  public void b(String paramString1, String paramString2)
  {
    Object localObject1;
    if ((paramString1 != null) && (paramString2 != null))
    {
      Object localObject2 = this.e.get(paramString1);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new HashSet();
        a(paramString1, localObject1);
      }
      if (!(localObject1 instanceof List)) {
        break label59;
      }
      ((List)localObject1).add(paramString2);
    }
    label59:
    while (!(localObject1 instanceof Set)) {
      return;
    }
    ((Set)localObject1).add(paramString2);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.a.entrySet().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append((String)((Map.Entry)localObject).getKey());
      localStringBuilder.append("=");
      localStringBuilder.append((String)((Map.Entry)localObject).getValue());
    }
    localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append((String)((Map.Entry)localObject).getKey());
      localStringBuilder.append("=");
      localStringBuilder.append("STREAM");
    }
    localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append((String)((Map.Entry)localObject).getKey());
      localStringBuilder.append("=");
      localStringBuilder.append("FILE");
    }
    localIterator = this.d.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append((String)((Map.Entry)localObject).getKey());
      localStringBuilder.append("=");
      localStringBuilder.append("FILES(SIZE=").append(((List)((Map.Entry)localObject).getValue()).size()).append(")");
    }
    localIterator = b(null, this.e).iterator();
    while (localIterator.hasNext())
    {
      localObject = (l)localIterator.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append(((l)localObject).a());
      localStringBuilder.append("=");
      localStringBuilder.append(((l)localObject).b());
    }
    return localStringBuilder.toString();
  }
  
  public static class a
    implements Serializable
  {
    public final File a;
    public final String b;
    public final String c;
  }
  
  public static class b
  {
    public final InputStream a;
    public final String b;
    public final String c;
    public final boolean d;
    
    public b(InputStream paramInputStream, String paramString1, String paramString2, boolean paramBoolean)
    {
      this.a = paramInputStream;
      this.b = paramString1;
      this.c = paramString2;
      this.d = paramBoolean;
    }
    
    static b a(InputStream paramInputStream, String paramString1, String paramString2, boolean paramBoolean)
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "application/octet-stream";
      }
      return new b(paramInputStream, paramString1, str, paramBoolean);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */