package com.umeng.analytics.pro;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class cq<T extends cq<?, ?>, F extends cn>
  implements cg<T, F>
{
  private static final Map<Class<? extends dn>, do> c = new HashMap();
  protected Object a;
  protected F b;
  
  static
  {
    c.put(dp.class, new b(null));
    c.put(dq.class, new d(null));
  }
  
  protected cq()
  {
    this.b = null;
    this.a = null;
  }
  
  protected cq(F paramF, Object paramObject)
  {
    a(paramF, paramObject);
  }
  
  protected cq(cq<T, F> paramcq)
  {
    if (!paramcq.getClass().equals(getClass())) {
      throw new ClassCastException();
    }
    this.b = paramcq.b;
    this.a = a(paramcq.a);
  }
  
  private static Object a(Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof cg)) {
      localObject = ((cg)paramObject).p();
    }
    do
    {
      return localObject;
      if ((paramObject instanceof ByteBuffer)) {
        return ch.d((ByteBuffer)paramObject);
      }
      if ((paramObject instanceof List)) {
        return a((List)paramObject);
      }
      if ((paramObject instanceof Set)) {
        return a((Set)paramObject);
      }
      localObject = paramObject;
    } while (!(paramObject instanceof Map));
    return a((Map)paramObject);
  }
  
  private static List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a(paramList.next()));
    }
    return localArrayList;
  }
  
  private static Map a(Map<Object, Object> paramMap)
  {
    HashMap localHashMap = new HashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localHashMap.put(a(localEntry.getKey()), a(localEntry.getValue()));
    }
    return localHashMap;
  }
  
  private static Set a(Set paramSet)
  {
    HashSet localHashSet = new HashSet();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      localHashSet.add(a(paramSet.next()));
    }
    return localHashSet;
  }
  
  public F a()
  {
    return this.b;
  }
  
  protected abstract F a(short paramShort);
  
  public Object a(int paramInt)
  {
    return a(a((short)paramInt));
  }
  
  public Object a(F paramF)
  {
    if (paramF != this.b) {
      throw new IllegalArgumentException("Cannot get the value of field " + paramF + " because union's set field is " + this.b);
    }
    return c();
  }
  
  protected abstract Object a(df paramdf, da paramda)
    throws cm;
  
  protected abstract Object a(df paramdf, short paramShort)
    throws cm;
  
  public void a(int paramInt, Object paramObject)
  {
    a(a((short)paramInt), paramObject);
  }
  
  public void a(F paramF, Object paramObject)
  {
    b(paramF, paramObject);
    this.b = paramF;
    this.a = paramObject;
  }
  
  public void a(df paramdf)
    throws cm
  {
    ((do)c.get(paramdf.D())).b().b(paramdf, this);
  }
  
  public final void b()
  {
    this.b = null;
    this.a = null;
  }
  
  protected abstract void b(F paramF, Object paramObject)
    throws ClassCastException;
  
  public void b(df paramdf)
    throws cm
  {
    ((do)c.get(paramdf.D())).b().a(paramdf, this);
  }
  
  public boolean b(F paramF)
  {
    return this.b == paramF;
  }
  
  protected abstract da c(F paramF);
  
  public Object c()
  {
    return this.a;
  }
  
  protected abstract void c(df paramdf)
    throws cm;
  
  public boolean c(int paramInt)
  {
    return b(a((short)paramInt));
  }
  
  protected abstract void d(df paramdf)
    throws cm;
  
  public boolean d()
  {
    return this.b != null;
  }
  
  protected abstract dk e();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<");
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append(" ");
    Object localObject;
    if (a() != null)
    {
      localObject = c();
      localStringBuilder.append(c(a()).a);
      localStringBuilder.append(":");
      if (!(localObject instanceof ByteBuffer)) {
        break label96;
      }
      ch.a((ByteBuffer)localObject, localStringBuilder);
    }
    for (;;)
    {
      localStringBuilder.append(">");
      return localStringBuilder.toString();
      label96:
      localStringBuilder.append(localObject.toString());
    }
  }
  
  private static class a
    extends dp<cq>
  {
    public void a(df paramdf, cq paramcq)
      throws cm
    {
      paramcq.b = null;
      paramcq.a = null;
      paramdf.j();
      da localda = paramdf.l();
      paramcq.a = paramcq.a(paramdf, localda);
      if (paramcq.a != null) {
        paramcq.b = paramcq.a(localda.c);
      }
      paramdf.m();
      paramdf.l();
      paramdf.k();
    }
    
    public void b(df paramdf, cq paramcq)
      throws cm
    {
      if ((paramcq.a() == null) || (paramcq.c() == null)) {
        throw new dg("Cannot write a TUnion with no set value!");
      }
      paramdf.a(paramcq.e());
      paramdf.a(paramcq.c(paramcq.b));
      paramcq.c(paramdf);
      paramdf.c();
      paramdf.d();
      paramdf.b();
    }
  }
  
  private static class b
    implements do
  {
    public cq.a a()
    {
      return new cq.a(null);
    }
  }
  
  private static class c
    extends dq<cq>
  {
    public void a(df paramdf, cq paramcq)
      throws cm
    {
      paramcq.b = null;
      paramcq.a = null;
      short s = paramdf.v();
      paramcq.a = paramcq.a(paramdf, s);
      if (paramcq.a != null) {
        paramcq.b = paramcq.a(s);
      }
    }
    
    public void b(df paramdf, cq paramcq)
      throws cm
    {
      if ((paramcq.a() == null) || (paramcq.c() == null)) {
        throw new dg("Cannot write a TUnion with no set value!");
      }
      paramdf.a(paramcq.b.a());
      paramcq.d(paramdf);
    }
  }
  
  private static class d
    implements do
  {
    public cq.c a()
    {
      return new cq.c(null);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */