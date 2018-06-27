package com.alibaba.fastjson.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class ParameterizedTypeImpl
  implements ParameterizedType
{
  private final Type[] actualTypeArguments;
  private final Type ownerType;
  private final Type rawType;
  
  public ParameterizedTypeImpl(Type[] paramArrayOfType, Type paramType1, Type paramType2)
  {
    this.actualTypeArguments = paramArrayOfType;
    this.ownerType = paramType1;
    this.rawType = paramType2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool3;
          } while (paramObject == null);
          bool1 = bool3;
        } while (getClass() != paramObject.getClass());
        paramObject = (ParameterizedTypeImpl)paramObject;
        bool1 = bool3;
      } while (!Arrays.equals(this.actualTypeArguments, ((ParameterizedTypeImpl)paramObject).actualTypeArguments));
      if (this.ownerType == null) {
        break;
      }
      bool1 = bool3;
    } while (!this.ownerType.equals(((ParameterizedTypeImpl)paramObject).ownerType));
    if (this.rawType != null) {
      bool1 = this.rawType.equals(((ParameterizedTypeImpl)paramObject).rawType);
    }
    for (;;)
    {
      return bool1;
      if (((ParameterizedTypeImpl)paramObject).ownerType == null) {
        break;
      }
      return false;
      bool1 = bool2;
      if (((ParameterizedTypeImpl)paramObject).rawType != null) {
        bool1 = false;
      }
    }
  }
  
  public Type[] getActualTypeArguments()
  {
    return this.actualTypeArguments;
  }
  
  public Type getOwnerType()
  {
    return this.ownerType;
  }
  
  public Type getRawType()
  {
    return this.rawType;
  }
  
  public int hashCode()
  {
    int k = 0;
    int i;
    if (this.actualTypeArguments != null)
    {
      i = Arrays.hashCode(this.actualTypeArguments);
      if (this.ownerType == null) {
        break label64;
      }
    }
    label64:
    for (int j = this.ownerType.hashCode();; j = 0)
    {
      if (this.rawType != null) {
        k = this.rawType.hashCode();
      }
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/util/ParameterizedTypeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */