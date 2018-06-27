package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class b
  extends a
  implements Serializable, Cloneable, List<Object>, RandomAccess
{
  protected transient Object h;
  protected transient Type i;
  private final List<Object> j;
  
  public b()
  {
    this.j = new ArrayList();
  }
  
  public b(int paramInt)
  {
    this.j = new ArrayList(paramInt);
  }
  
  public b(List<Object> paramList)
  {
    this.j = paramList;
  }
  
  public void add(int paramInt, Object paramObject)
  {
    this.j.add(paramInt, paramObject);
  }
  
  public boolean add(Object paramObject)
  {
    return this.j.add(paramObject);
  }
  
  public boolean addAll(int paramInt, Collection<? extends Object> paramCollection)
  {
    return this.j.addAll(paramInt, paramCollection);
  }
  
  public boolean addAll(Collection<? extends Object> paramCollection)
  {
    return this.j.addAll(paramCollection);
  }
  
  public void clear()
  {
    this.j.clear();
  }
  
  public Object clone()
  {
    return new b(new ArrayList(this.j));
  }
  
  public boolean contains(Object paramObject)
  {
    return this.j.contains(paramObject);
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    return this.j.containsAll(paramCollection);
  }
  
  public boolean equals(Object paramObject)
  {
    return this.j.equals(paramObject);
  }
  
  public b fluentAdd(int paramInt, Object paramObject)
  {
    this.j.add(paramInt, paramObject);
    return this;
  }
  
  public b fluentAdd(Object paramObject)
  {
    this.j.add(paramObject);
    return this;
  }
  
  public b fluentAddAll(int paramInt, Collection<? extends Object> paramCollection)
  {
    this.j.addAll(paramInt, paramCollection);
    return this;
  }
  
  public b fluentAddAll(Collection<? extends Object> paramCollection)
  {
    this.j.addAll(paramCollection);
    return this;
  }
  
  public b fluentClear()
  {
    this.j.clear();
    return this;
  }
  
  public b fluentRemove(int paramInt)
  {
    this.j.remove(paramInt);
    return this;
  }
  
  public b fluentRemove(Object paramObject)
  {
    this.j.remove(paramObject);
    return this;
  }
  
  public b fluentRemoveAll(Collection<?> paramCollection)
  {
    this.j.removeAll(paramCollection);
    return this;
  }
  
  public b fluentRetainAll(Collection<?> paramCollection)
  {
    this.j.retainAll(paramCollection);
    return this;
  }
  
  public b fluentSet(int paramInt, Object paramObject)
  {
    set(paramInt, paramObject);
    return this;
  }
  
  public Object get(int paramInt)
  {
    return this.j.get(paramInt);
  }
  
  public BigDecimal getBigDecimal(int paramInt)
  {
    return TypeUtils.castToBigDecimal(get(paramInt));
  }
  
  public BigInteger getBigInteger(int paramInt)
  {
    return TypeUtils.castToBigInteger(get(paramInt));
  }
  
  public Boolean getBoolean(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return null;
    }
    return TypeUtils.castToBoolean(localObject);
  }
  
  public boolean getBooleanValue(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return false;
    }
    return TypeUtils.castToBoolean(localObject).booleanValue();
  }
  
  public Byte getByte(int paramInt)
  {
    return TypeUtils.castToByte(get(paramInt));
  }
  
  public byte getByteValue(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return 0;
    }
    return TypeUtils.castToByte(localObject).byteValue();
  }
  
  public Type getComponentType()
  {
    return this.i;
  }
  
  public java.util.Date getDate(int paramInt)
  {
    return TypeUtils.castToDate(get(paramInt));
  }
  
  public Double getDouble(int paramInt)
  {
    return TypeUtils.castToDouble(get(paramInt));
  }
  
  public double getDoubleValue(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return 0.0D;
    }
    return TypeUtils.castToDouble(localObject).doubleValue();
  }
  
  public Float getFloat(int paramInt)
  {
    return TypeUtils.castToFloat(get(paramInt));
  }
  
  public float getFloatValue(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return 0.0F;
    }
    return TypeUtils.castToFloat(localObject).floatValue();
  }
  
  public int getIntValue(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return 0;
    }
    return TypeUtils.castToInt(localObject).intValue();
  }
  
  public Integer getInteger(int paramInt)
  {
    return TypeUtils.castToInt(get(paramInt));
  }
  
  public b getJSONArray(int paramInt)
  {
    Object localObject = this.j.get(paramInt);
    if ((localObject instanceof b)) {
      return (b)localObject;
    }
    return (b)toJSON(localObject);
  }
  
  public e getJSONObject(int paramInt)
  {
    Object localObject = this.j.get(paramInt);
    if ((localObject instanceof e)) {
      return (e)localObject;
    }
    return (e)toJSON(localObject);
  }
  
  public Long getLong(int paramInt)
  {
    return TypeUtils.castToLong(get(paramInt));
  }
  
  public long getLongValue(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return 0L;
    }
    return TypeUtils.castToLong(localObject).longValue();
  }
  
  public <T> T getObject(int paramInt, Class<T> paramClass)
  {
    return (T)TypeUtils.castToJavaBean(this.j.get(paramInt), paramClass);
  }
  
  public Object getRelatedArray()
  {
    return this.h;
  }
  
  public Short getShort(int paramInt)
  {
    return TypeUtils.castToShort(get(paramInt));
  }
  
  public short getShortValue(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return 0;
    }
    return TypeUtils.castToShort(localObject).shortValue();
  }
  
  public java.sql.Date getSqlDate(int paramInt)
  {
    return TypeUtils.castToSqlDate(get(paramInt));
  }
  
  public String getString(int paramInt)
  {
    return TypeUtils.castToString(get(paramInt));
  }
  
  public Timestamp getTimestamp(int paramInt)
  {
    return TypeUtils.castToTimestamp(get(paramInt));
  }
  
  public int hashCode()
  {
    return this.j.hashCode();
  }
  
  public int indexOf(Object paramObject)
  {
    return this.j.indexOf(paramObject);
  }
  
  public boolean isEmpty()
  {
    return this.j.isEmpty();
  }
  
  public Iterator<Object> iterator()
  {
    return this.j.iterator();
  }
  
  public int lastIndexOf(Object paramObject)
  {
    return this.j.lastIndexOf(paramObject);
  }
  
  public ListIterator<Object> listIterator()
  {
    return this.j.listIterator();
  }
  
  public ListIterator<Object> listIterator(int paramInt)
  {
    return this.j.listIterator(paramInt);
  }
  
  public Object remove(int paramInt)
  {
    return this.j.remove(paramInt);
  }
  
  public boolean remove(Object paramObject)
  {
    return this.j.remove(paramObject);
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    return this.j.removeAll(paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    return this.j.retainAll(paramCollection);
  }
  
  public Object set(int paramInt, Object paramObject)
  {
    if (paramInt == -1)
    {
      this.j.add(paramObject);
      return null;
    }
    if (this.j.size() <= paramInt)
    {
      int k = this.j.size();
      while (k < paramInt)
      {
        this.j.add(null);
        k += 1;
      }
      this.j.add(paramObject);
      return null;
    }
    return this.j.set(paramInt, paramObject);
  }
  
  public void setComponentType(Type paramType)
  {
    this.i = paramType;
  }
  
  public void setRelatedArray(Object paramObject)
  {
    this.h = paramObject;
  }
  
  public int size()
  {
    return this.j.size();
  }
  
  public List<Object> subList(int paramInt1, int paramInt2)
  {
    return this.j.subList(paramInt1, paramInt2);
  }
  
  public Object[] toArray()
  {
    return this.j.toArray();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return this.j.toArray(paramArrayOfT);
  }
  
  public <T> List<T> toJavaList(Class<T> paramClass)
  {
    ArrayList localArrayList = new ArrayList(size());
    ParserConfig localParserConfig = ParserConfig.getGlobalInstance();
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(TypeUtils.cast(localIterator.next(), paramClass, localParserConfig));
    }
    return localArrayList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */