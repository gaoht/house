package com.ziroom.ziroomcustomer.minsu.view.stickylistheaders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

class b<TKey, TItemValue>
{
  LinkedHashMap<Object, List<TItemValue>> a = new LinkedHashMap();
  LinkedHashMap<Object, TKey> b = new LinkedHashMap();
  private a<TKey, TItemValue> c;
  
  b()
  {
    this(new a()
    {
      public TKey keyIdToKey(Object paramAnonymousObject)
      {
        return (TKey)paramAnonymousObject;
      }
      
      public Object keyToKeyId(TKey paramAnonymousTKey)
      {
        return paramAnonymousTKey;
      }
      
      public TItemValue valueIdToValue(Object paramAnonymousObject)
      {
        return (TItemValue)paramAnonymousObject;
      }
      
      public Object valueToValueId(TItemValue paramAnonymousTItemValue)
      {
        return paramAnonymousTItemValue;
      }
    });
  }
  
  b(a<TKey, TItemValue> parama)
  {
    this.c = parama;
  }
  
  protected boolean a(List<TItemValue> paramList, TItemValue paramTItemValue)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (this.c.valueToValueId(localObject).equals(this.c.valueToValueId(paramTItemValue))) {
        return true;
      }
    }
    return false;
  }
  
  public void add(TKey paramTKey, TItemValue paramTItemValue)
  {
    Object localObject = this.c.keyToKeyId(paramTKey);
    if (this.a.get(localObject) == null) {
      this.a.put(localObject, new ArrayList());
    }
    localObject = getKey(paramTItemValue);
    if (localObject != null) {
      ((List)this.a.get(this.c.keyToKeyId(localObject))).remove(paramTItemValue);
    }
    this.b.put(this.c.valueToValueId(paramTItemValue), paramTKey);
    if (!a((List)this.a.get(this.c.keyToKeyId(paramTKey)), paramTItemValue)) {
      ((List)this.a.get(this.c.keyToKeyId(paramTKey))).add(paramTItemValue);
    }
  }
  
  public void clear()
  {
    this.b.clear();
    this.a.clear();
  }
  
  public void clearValues()
  {
    Iterator localIterator = entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry.getValue() != null) {
        ((List)localEntry.getValue()).clear();
      }
    }
    this.b.clear();
  }
  
  public Set<Map.Entry<Object, List<TItemValue>>> entrySet()
  {
    return this.a.entrySet();
  }
  
  public List<TItemValue> get(TKey paramTKey)
  {
    return (List)this.a.get(this.c.keyToKeyId(paramTKey));
  }
  
  public TKey getKey(TItemValue paramTItemValue)
  {
    return (TKey)this.b.get(this.c.valueToValueId(paramTItemValue));
  }
  
  public TItemValue getValueByPosition(int paramInt)
  {
    Object localObject = this.b.keySet().toArray();
    if (paramInt > localObject.length) {
      throw new IndexOutOfBoundsException();
    }
    localObject = localObject[paramInt];
    return (TItemValue)this.c.valueIdToValue(localObject);
  }
  
  public void removeKey(TKey paramTKey)
  {
    if (this.a.get(this.c.keyToKeyId(paramTKey)) != null)
    {
      Iterator localIterator = ((List)this.a.get(this.c.keyToKeyId(paramTKey))).iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        this.b.remove(this.c.valueToValueId(localObject));
      }
      this.a.remove(this.c.keyToKeyId(paramTKey));
    }
  }
  
  public void removeValue(TItemValue paramTItemValue)
  {
    if (getKey(paramTItemValue) != null)
    {
      List localList = (List)this.a.get(this.c.keyToKeyId(getKey(paramTItemValue)));
      if (localList != null) {
        localList.remove(paramTItemValue);
      }
    }
    this.b.remove(this.c.valueToValueId(paramTItemValue));
  }
  
  public Set<Map.Entry<Object, TKey>> reverseEntrySet()
  {
    return this.b.entrySet();
  }
  
  public int size()
  {
    return this.a.size();
  }
  
  public int valuesSize()
  {
    return this.b.size();
  }
  
  static abstract interface a<TKey, TItemValue>
  {
    public abstract TKey keyIdToKey(Object paramObject);
    
    public abstract Object keyToKeyId(TKey paramTKey);
    
    public abstract TItemValue valueIdToValue(Object paramObject);
    
    public abstract Object valueToValueId(TItemValue paramTItemValue);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/stickylistheaders/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */