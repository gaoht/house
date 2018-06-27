package com.g.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class am
{
  private static int a = 2;
  private static int b = 6;
  private static int c = 6;
  private static int d = -40;
  private static int e = 4;
  private ak f;
  
  public am()
  {
    this(new ak());
  }
  
  public am(ak paramak)
  {
    this.f = paramak;
  }
  
  public double a(int paramInt1, int paramInt2)
  {
    double d1 = 0.0D;
    if ((paramInt1 >= 0) || (paramInt2 >= 0)) {
      return 0.0D;
    }
    double d2 = (paramInt1 + paramInt2) / 2;
    double d3 = Math.abs(paramInt1 - d2);
    if (d3 > a) {
      d1 = d3 - a;
    }
    return Math.pow((d1 + d2) / d2, b);
  }
  
  public double a(al paramal1, al paramal2)
  {
    Map localMap = paramal1.a(false);
    Object localObject1 = paramal2.a(false);
    HashSet localHashSet = new HashSet();
    Object localObject2 = localMap.entrySet().iterator();
    double d1 = 0.0D;
    double d2 = 0.0D;
    int i = 0;
    int j = 0;
    if (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
      aj localaj = (aj)((Map.Entry)localObject3).getValue();
      localObject3 = (aj)((Map)localObject1).get(((Map.Entry)localObject3).getKey());
      i += localaj.c();
      if (localObject3 == null)
      {
        localHashSet.add(localaj);
        d3 = d2;
        d2 = d1;
        d1 = d3;
      }
      for (;;)
      {
        d3 = d2;
        d2 = d1;
        d1 = d3;
        break;
        j += 1;
        d3 = b(localaj.c(), ((aj)localObject3).c());
        double d4 = a(localaj.c(), ((aj)localObject3).c());
        d2 += d3;
        d3 = d1 + d4 * d3;
        d1 = d2;
        d2 = d3;
      }
    }
    if (j == 0) {
      return 0.0D;
    }
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      int k = i + ((aj)((Map.Entry)localObject2).getValue()).c();
      i = k;
      if (!localMap.containsKey(((Map.Entry)localObject2).getKey()))
      {
        localHashSet.add(((Map.Entry)localObject2).getValue());
        i = k;
      }
    }
    i /= (paramal1.c().size() + paramal2.c().size() - 0);
    i = Math.max(this.f.d(), (int)(i + 1.2D));
    paramal1 = localHashSet.iterator();
    double d3 = 0.0D;
    if (paramal1.hasNext())
    {
      if (((aj)paramal1.next()).c() <= i) {
        break label441;
      }
      d3 = 1.0D + d3;
    }
    label441:
    for (;;)
    {
      break;
      d3 /= (j * 2 + d3);
      d1 /= d2;
      return (1.0D - Math.pow(d3, e)) * d1;
    }
  }
  
  public double a(al paramal, List paramList)
  {
    paramList = paramList.iterator();
    for (double d1 = 0.0D; paramList.hasNext(); d1 = Math.max(a((al)paramList.next(), paramal), d1)) {}
    return d1;
  }
  
  public double a(List paramList1, List paramList2)
  {
    double d1 = 0.0D;
    if ((paramList1.isEmpty()) || (paramList2.isEmpty())) {
      return 0.0D;
    }
    LinkedList localLinkedList = new LinkedList();
    b(paramList1, paramList2, localLinkedList);
    paramList1 = localLinkedList.iterator();
    int i = 0;
    if (paramList1.hasNext())
    {
      paramList2 = (a)paramList1.next();
      if ((paramList2.a == null) || (paramList2.b == null)) {
        break label105;
      }
      d1 += paramList2.c;
      i += 1;
    }
    label105:
    for (;;)
    {
      break;
      return d1 / i;
    }
  }
  
  public double a(List paramList1, List paramList2, List paramList3)
  {
    double d1 = 0.0D;
    if ((paramList1.isEmpty()) || (paramList2.isEmpty()))
    {
      paramList3.addAll(paramList1);
      paramList3.addAll(paramList2);
      return 0.0D;
    }
    LinkedList localLinkedList = new LinkedList();
    b(paramList1, paramList2, localLinkedList);
    paramList2 = localLinkedList.iterator();
    int i = 0;
    while (paramList2.hasNext())
    {
      paramList1 = (a)paramList2.next();
      if ((paramList1.a != null) && (paramList1.b != null))
      {
        d1 += paramList1.c;
        paramList3.add(b(paramList1.a, paramList1.b));
        i += 1;
      }
      else
      {
        if (paramList3.size() < this.f.b()) {
          if (paramList1.a != null) {
            break label179;
          }
        }
        label179:
        for (paramList1 = paramList1.b.d();; paramList1 = paramList1.a.d())
        {
          paramList3.add(paramList1);
          break;
        }
      }
    }
    return d1 / i;
  }
  
  public double b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) || (paramInt2 >= 0)) {
      return 0.0D;
    }
    double d1 = Math.max(paramInt1, paramInt2);
    if (d1 >= d) {
      return 1.0D;
    }
    return Math.pow((d1 + 128.0D) / (d + 128), c);
  }
  
  public al b(al paramal1, al paramal2)
  {
    Object localObject1 = paramal1.a(false);
    Object localObject3 = paramal2.a(false);
    Object localObject2 = new TreeMap();
    paramal1 = new al();
    paramal1.setPoiId(paramal2.b());
    paramal1.setTimestamp(paramal2.a());
    paramal2 = new LinkedList();
    paramal1.setBsslist(paramal2);
    Object localObject4 = ((Map)localObject1).entrySet().iterator();
    double d1;
    int i;
    while (((Iterator)localObject4).hasNext())
    {
      Object localObject5 = (Map.Entry)((Iterator)localObject4).next();
      aj localaj = (aj)((Map.Entry)localObject5).getValue();
      localObject5 = (aj)((Map)localObject3).get(((Map.Entry)localObject5).getKey());
      if (localObject5 == null)
      {
        for (d1 = -localaj.c(); ((SortedMap)localObject2).containsKey(Double.valueOf(d1)); d1 += 1.0E-4D) {}
        ((SortedMap)localObject2).put(Double.valueOf(d1), localaj);
      }
      else
      {
        String str1 = ((aj)localObject5).a();
        String str2 = ((aj)localObject5).b();
        i = ((aj)localObject5).c();
        paramal2.add(new aj(str1, str2, (byte)((localaj.c() + i) / 2), ((aj)localObject5).d(), ((aj)localObject5).e()));
      }
    }
    localObject3 = ((Map)localObject3).entrySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Map.Entry)((Iterator)localObject3).next();
      if (!((Map)localObject1).containsKey(((Map.Entry)localObject4).getKey()))
      {
        for (d1 = -((aj)((Map.Entry)localObject4).getValue()).c(); ((SortedMap)localObject2).containsKey(Double.valueOf(d1)); d1 += 1.0E-4D) {}
        ((SortedMap)localObject2).put(Double.valueOf(d1), ((Map.Entry)localObject4).getValue());
      }
    }
    localObject1 = ((SortedMap)localObject2).entrySet().iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        i = (byte)(int)-((Double)((Map.Entry)localObject2).getKey()).doubleValue();
        if ((paramal2.size() < this.f.c()) && (i >= this.f.d())) {}
      }
      else
      {
        return paramal1;
      }
      paramal2.add(((Map.Entry)localObject2).getValue());
    }
  }
  
  public void b(List paramList1, List paramList2, List paramList3)
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet2 = new HashSet();
    HashSet localHashSet1 = new HashSet();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      al localal1 = (al)paramList1.next();
      Iterator localIterator = paramList2.iterator();
      while (localIterator.hasNext())
      {
        al localal2 = (al)localIterator.next();
        localHashSet1.add(localal2);
        localArrayList.add(new a(localal1, localal2, a(localal1, localal2)));
      }
      localHashSet2.add(localal1);
    }
    Collections.sort(localArrayList, new an(this));
    paramList3.clear();
    paramList1 = localArrayList.iterator();
    while (paramList1.hasNext())
    {
      paramList2 = (a)paramList1.next();
      if ((localHashSet2.contains(paramList2.a)) && (localHashSet1.contains(paramList2.b)))
      {
        localHashSet2.remove(paramList2.a);
        localHashSet1.remove(paramList2.b);
        paramList3.add(paramList2);
      }
    }
    paramList1 = localHashSet2.iterator();
    while (paramList1.hasNext()) {
      paramList3.add(new a((al)paramList1.next(), null, 0.0D));
    }
    paramList1 = localHashSet1.iterator();
    while (paramList1.hasNext()) {
      paramList3.add(new a(null, (al)paramList1.next(), 0.0D));
    }
  }
  
  class a
  {
    public al a;
    public al b;
    public double c;
    
    public a(al paramal1, al paramal2, double paramDouble)
    {
      this.a = paramal1;
      this.b = paramal2;
      this.c = paramDouble;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */