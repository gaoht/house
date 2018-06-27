package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.d;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public abstract class FieldDeserializer
{
  protected BeanContext beanContext;
  protected final Class<?> clazz;
  public final FieldInfo fieldInfo;
  
  public FieldDeserializer(Class<?> paramClass, FieldInfo paramFieldInfo)
  {
    this.clazz = paramClass;
    this.fieldInfo = paramFieldInfo;
    if (paramFieldInfo == null) {}
  }
  
  public int getFastMatchToken()
  {
    return 0;
  }
  
  public abstract void parseField(DefaultJSONParser paramDefaultJSONParser, Object paramObject, Type paramType, Map<String, Object> paramMap);
  
  public void setValue(Object paramObject, int paramInt)
  {
    setValue(paramObject, Integer.valueOf(paramInt));
  }
  
  public void setValue(Object paramObject, long paramLong)
  {
    setValue(paramObject, Long.valueOf(paramLong));
  }
  
  public void setValue(Object paramObject1, Object paramObject2)
  {
    if ((paramObject2 == null) && (this.fieldInfo.fieldClass.isPrimitive())) {}
    Object localObject;
    label267:
    label282:
    label475:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        for (;;)
                        {
                          return;
                          try
                          {
                            localObject = this.fieldInfo.method;
                            if (localObject == null) {
                              break label282;
                            }
                            if (!this.fieldInfo.getOnly) {
                              break label267;
                            }
                            if (this.fieldInfo.fieldClass == AtomicInteger.class)
                            {
                              paramObject1 = (AtomicInteger)((Method)localObject).invoke(paramObject1, new Object[0]);
                              if (paramObject1 == null) {
                                continue;
                              }
                              ((AtomicInteger)paramObject1).set(((AtomicInteger)paramObject2).get());
                            }
                          }
                          catch (Exception paramObject1)
                          {
                            throw new d("set property error, " + this.fieldInfo.name, (Throwable)paramObject1);
                          }
                        }
                        if (this.fieldInfo.fieldClass != AtomicLong.class) {
                          break;
                        }
                        paramObject1 = (AtomicLong)((Method)localObject).invoke(paramObject1, new Object[0]);
                      } while (paramObject1 == null);
                      ((AtomicLong)paramObject1).set(((AtomicLong)paramObject2).get());
                      return;
                      if (this.fieldInfo.fieldClass != AtomicBoolean.class) {
                        break;
                      }
                      paramObject1 = (AtomicBoolean)((Method)localObject).invoke(paramObject1, new Object[0]);
                    } while (paramObject1 == null);
                    ((AtomicBoolean)paramObject1).set(((AtomicBoolean)paramObject2).get());
                    return;
                    if (!Map.class.isAssignableFrom(((Method)localObject).getReturnType())) {
                      break;
                    }
                    paramObject1 = (Map)((Method)localObject).invoke(paramObject1, new Object[0]);
                  } while (paramObject1 == null);
                  ((Map)paramObject1).putAll((Map)paramObject2);
                  return;
                  paramObject1 = (Collection)((Method)localObject).invoke(paramObject1, new Object[0]);
                } while (paramObject1 == null);
                ((Collection)paramObject1).addAll((Collection)paramObject2);
                return;
                ((Method)localObject).invoke(paramObject1, new Object[] { paramObject2 });
                return;
                localObject = this.fieldInfo.field;
                if (!this.fieldInfo.getOnly) {
                  break label475;
                }
                if (this.fieldInfo.fieldClass != AtomicInteger.class) {
                  break;
                }
                paramObject1 = (AtomicInteger)((Field)localObject).get(paramObject1);
              } while (paramObject1 == null);
              ((AtomicInteger)paramObject1).set(((AtomicInteger)paramObject2).get());
              return;
              if (this.fieldInfo.fieldClass != AtomicLong.class) {
                break;
              }
              paramObject1 = (AtomicLong)((Field)localObject).get(paramObject1);
            } while (paramObject1 == null);
            ((AtomicLong)paramObject1).set(((AtomicLong)paramObject2).get());
            return;
            if (this.fieldInfo.fieldClass != AtomicBoolean.class) {
              break;
            }
            paramObject1 = (AtomicBoolean)((Field)localObject).get(paramObject1);
          } while (paramObject1 == null);
          ((AtomicBoolean)paramObject1).set(((AtomicBoolean)paramObject2).get());
          return;
          if (!Map.class.isAssignableFrom(this.fieldInfo.fieldClass)) {
            break;
          }
          paramObject1 = (Map)((Field)localObject).get(paramObject1);
        } while (paramObject1 == null);
        ((Map)paramObject1).putAll((Map)paramObject2);
        return;
        paramObject1 = (Collection)((Field)localObject).get(paramObject1);
      } while (paramObject1 == null);
      ((Collection)paramObject1).addAll((Collection)paramObject2);
      return;
    } while (localObject == null);
    ((Field)localObject).set(paramObject1, paramObject2);
  }
  
  public void setValue(Object paramObject, String paramString)
  {
    setValue(paramObject, paramString);
  }
  
  public void setValue(Object paramObject, boolean paramBoolean)
  {
    setValue(paramObject, Boolean.valueOf(paramBoolean));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/FieldDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */