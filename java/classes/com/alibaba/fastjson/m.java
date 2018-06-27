package com.alibaba.fastjson;

import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class m<T>
{
  static ConcurrentMap<Type, Type> a = new ConcurrentHashMap(16, 0.75F, 1);
  protected final Type b;
  
  protected m()
  {
    this.b = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
  }
  
  protected m(Type... paramVarArgs)
  {
    Object localObject1 = getClass();
    Object localObject3 = (ParameterizedType)((ParameterizedType)localObject1.getGenericSuperclass()).getActualTypeArguments()[0];
    Object localObject2 = ((ParameterizedType)localObject3).getRawType();
    localObject3 = ((ParameterizedType)localObject3).getActualTypeArguments();
    int i = 0;
    for (;;)
    {
      int k;
      if (i < localObject3.length)
      {
        k = j;
        if ((localObject3[i] instanceof TypeVariable))
        {
          k = j + 1;
          localObject3[i] = paramVarArgs[j];
          if (k < paramVarArgs.length) {}
        }
      }
      else
      {
        localObject2 = new ParameterizedTypeImpl((Type[])localObject3, (Type)localObject1, (Type)localObject2);
        localObject1 = (Type)a.get(localObject2);
        paramVarArgs = (Type[])localObject1;
        if (localObject1 == null)
        {
          a.putIfAbsent(localObject2, localObject2);
          paramVarArgs = (Type)a.get(localObject2);
        }
        this.b = paramVarArgs;
        return;
      }
      i += 1;
      j = k;
    }
  }
  
  public Type getType()
  {
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */