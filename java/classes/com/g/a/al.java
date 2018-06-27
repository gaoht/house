package com.g.a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class al
{
  private int a;
  private long b;
  private List c;
  private Map d;
  
  public int a()
  {
    return this.a;
  }
  
  public Map a(boolean paramBoolean)
  {
    if ((this.d == null) || (paramBoolean))
    {
      this.d = new HashMap();
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        aj localaj = (aj)localIterator.next();
        this.d.put(localaj.b(), localaj);
      }
    }
    return this.d;
  }
  
  public long b()
  {
    return this.b;
  }
  
  public List c()
  {
    return this.c;
  }
  
  public al d()
  {
    al localal = new al();
    localal.setTimestamp(this.a);
    localal.setPoiId(this.b);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add(((aj)localIterator.next()).f());
    }
    localal.setBsslist(localLinkedList);
    return localal;
  }
  
  public void setBsslist(List paramList)
  {
    this.c = paramList;
  }
  
  public void setPoiId(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void setTimestamp(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */