package com.alibaba.fastjson;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class e
  extends a
  implements Serializable, Cloneable, InvocationHandler, Map<String, Object>
{
  private final Map<String, Object> h;
  
  public e()
  {
    this(16, false);
  }
  
  public e(int paramInt)
  {
    this(paramInt, false);
  }
  
  public e(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.h = new LinkedHashMap(paramInt);
      return;
    }
    this.h = new HashMap(paramInt);
  }
  
  public e(Map<String, Object> paramMap)
  {
    this.h = paramMap;
  }
  
  public e(boolean paramBoolean)
  {
    this(16, paramBoolean);
  }
  
  public void clear()
  {
    this.h.clear();
  }
  
  public Object clone()
  {
    if ((this.h instanceof LinkedHashMap)) {}
    for (Object localObject = new LinkedHashMap(this.h);; localObject = new HashMap(this.h)) {
      return new e((Map)localObject);
    }
  }
  
  public boolean containsKey(Object paramObject)
  {
    return this.h.containsKey(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    return this.h.containsValue(paramObject);
  }
  
  public Set<Map.Entry<String, Object>> entrySet()
  {
    return this.h.entrySet();
  }
  
  public boolean equals(Object paramObject)
  {
    return this.h.equals(paramObject);
  }
  
  public e fluentClear()
  {
    this.h.clear();
    return this;
  }
  
  public e fluentPut(String paramString, Object paramObject)
  {
    this.h.put(paramString, paramObject);
    return this;
  }
  
  public e fluentPutAll(Map<? extends String, ? extends Object> paramMap)
  {
    this.h.putAll(paramMap);
    return this;
  }
  
  public e fluentRemove(Object paramObject)
  {
    this.h.remove(paramObject);
    return this;
  }
  
  public Object get(Object paramObject)
  {
    return this.h.get(paramObject);
  }
  
  public BigDecimal getBigDecimal(String paramString)
  {
    return TypeUtils.castToBigDecimal(get(paramString));
  }
  
  public BigInteger getBigInteger(String paramString)
  {
    return TypeUtils.castToBigInteger(get(paramString));
  }
  
  public Boolean getBoolean(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null) {
      return null;
    }
    return TypeUtils.castToBoolean(paramString);
  }
  
  public boolean getBooleanValue(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null) {
      return false;
    }
    return TypeUtils.castToBoolean(paramString).booleanValue();
  }
  
  public Byte getByte(String paramString)
  {
    return TypeUtils.castToByte(get(paramString));
  }
  
  public byte getByteValue(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null) {
      return 0;
    }
    return TypeUtils.castToByte(paramString).byteValue();
  }
  
  public byte[] getBytes(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null) {
      return null;
    }
    return TypeUtils.castToBytes(paramString);
  }
  
  public java.util.Date getDate(String paramString)
  {
    return TypeUtils.castToDate(get(paramString));
  }
  
  public Double getDouble(String paramString)
  {
    return TypeUtils.castToDouble(get(paramString));
  }
  
  public double getDoubleValue(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null) {
      return 0.0D;
    }
    return TypeUtils.castToDouble(paramString).doubleValue();
  }
  
  public Float getFloat(String paramString)
  {
    return TypeUtils.castToFloat(get(paramString));
  }
  
  public float getFloatValue(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null) {
      return 0.0F;
    }
    return TypeUtils.castToFloat(paramString).floatValue();
  }
  
  public int getIntValue(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null) {
      return 0;
    }
    return TypeUtils.castToInt(paramString).intValue();
  }
  
  public Integer getInteger(String paramString)
  {
    return TypeUtils.castToInt(get(paramString));
  }
  
  public b getJSONArray(String paramString)
  {
    paramString = this.h.get(paramString);
    if ((paramString instanceof b)) {
      return (b)paramString;
    }
    if ((paramString instanceof String)) {
      return (b)a.parse((String)paramString);
    }
    return (b)toJSON(paramString);
  }
  
  public e getJSONObject(String paramString)
  {
    paramString = this.h.get(paramString);
    if ((paramString instanceof e)) {
      return (e)paramString;
    }
    if ((paramString instanceof String)) {
      return a.parseObject((String)paramString);
    }
    return (e)toJSON(paramString);
  }
  
  public Long getLong(String paramString)
  {
    return TypeUtils.castToLong(get(paramString));
  }
  
  public long getLongValue(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null) {
      return 0L;
    }
    return TypeUtils.castToLong(paramString).longValue();
  }
  
  public <T> T getObject(String paramString, Class<T> paramClass)
  {
    return (T)TypeUtils.castToJavaBean(this.h.get(paramString), paramClass);
  }
  
  public Short getShort(String paramString)
  {
    return TypeUtils.castToShort(get(paramString));
  }
  
  public short getShortValue(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null) {
      return 0;
    }
    return TypeUtils.castToShort(paramString).shortValue();
  }
  
  public java.sql.Date getSqlDate(String paramString)
  {
    return TypeUtils.castToSqlDate(get(paramString));
  }
  
  public String getString(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.toString();
  }
  
  public Timestamp getTimestamp(String paramString)
  {
    return TypeUtils.castToTimestamp(get(paramString));
  }
  
  public int hashCode()
  {
    return this.h.hashCode();
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    throws Throwable
  {
    paramObject = paramMethod.getParameterTypes();
    if (paramObject.length == 1)
    {
      if (paramMethod.getName().equals("equals")) {
        return Boolean.valueOf(equals(paramArrayOfObject[0]));
      }
      if (paramMethod.getReturnType() != Void.TYPE) {
        throw new d("illegal setter");
      }
      paramObject = (JSONField)paramMethod.getAnnotation(JSONField.class);
      if ((paramObject == null) || (((JSONField)paramObject).name().length() == 0)) {
        break label479;
      }
    }
    label351:
    label474:
    label479:
    for (paramObject = ((JSONField)paramObject).name();; paramObject = null)
    {
      Object localObject = paramObject;
      if (paramObject == null)
      {
        paramObject = paramMethod.getName();
        if (!((String)paramObject).startsWith("set")) {
          throw new d("illegal setter");
        }
        paramObject = ((String)paramObject).substring(3);
        if (((String)paramObject).length() == 0) {
          throw new d("illegal setter");
        }
        localObject = Character.toLowerCase(((String)paramObject).charAt(0)) + ((String)paramObject).substring(1);
      }
      this.h.put(localObject, paramArrayOfObject[0]);
      return null;
      if (paramObject.length == 0)
      {
        if (paramMethod.getReturnType() == Void.TYPE) {
          throw new d("illegal getter");
        }
        paramObject = (JSONField)paramMethod.getAnnotation(JSONField.class);
        if ((paramObject == null) || (((JSONField)paramObject).name().length() == 0)) {
          break label474;
        }
      }
      for (paramObject = ((JSONField)paramObject).name();; paramObject = null)
      {
        paramArrayOfObject = (Object[])paramObject;
        if (paramObject == null)
        {
          paramObject = paramMethod.getName();
          if (!((String)paramObject).startsWith("get")) {
            break label351;
          }
          paramObject = ((String)paramObject).substring(3);
          if (((String)paramObject).length() == 0) {
            throw new d("illegal getter");
          }
        }
        for (paramArrayOfObject = Character.toLowerCase(((String)paramObject).charAt(0)) + ((String)paramObject).substring(1);; paramArrayOfObject = Character.toLowerCase(((String)paramObject).charAt(0)) + ((String)paramObject).substring(1))
        {
          return TypeUtils.cast(this.h.get(paramArrayOfObject), paramMethod.getGenericReturnType(), ParserConfig.getGlobalInstance());
          if (!((String)paramObject).startsWith("is")) {
            break;
          }
          paramObject = ((String)paramObject).substring(2);
          if (((String)paramObject).length() == 0) {
            throw new d("illegal getter");
          }
        }
        if (((String)paramObject).startsWith("hashCode")) {
          return Integer.valueOf(hashCode());
        }
        if (((String)paramObject).startsWith("toString")) {
          return toString();
        }
        throw new d("illegal getter");
        throw new UnsupportedOperationException(paramMethod.toGenericString());
      }
    }
  }
  
  public boolean isEmpty()
  {
    return this.h.isEmpty();
  }
  
  public Set<String> keySet()
  {
    return this.h.keySet();
  }
  
  public Object put(String paramString, Object paramObject)
  {
    return this.h.put(paramString, paramObject);
  }
  
  public void putAll(Map<? extends String, ? extends Object> paramMap)
  {
    this.h.putAll(paramMap);
  }
  
  public Object remove(Object paramObject)
  {
    return this.h.remove(paramObject);
  }
  
  public int size()
  {
    return this.h.size();
  }
  
  public Collection<Object> values()
  {
    return this.h.values();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */