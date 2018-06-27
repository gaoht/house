package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Enumeration;

public class EnumerationSerializer
  implements ObjectSerializer
{
  public static EnumerationSerializer instance = new EnumerationSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt)
    throws IOException
  {
    paramInt = 0;
    SerializeWriter localSerializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null)
    {
      localSerializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
      return;
    }
    Enumeration localEnumeration = null;
    Object localObject = localEnumeration;
    if (localSerializeWriter.isEnabled(SerializerFeature.WriteClassName))
    {
      localObject = localEnumeration;
      if ((paramType instanceof ParameterizedType)) {
        localObject = ((ParameterizedType)paramType).getActualTypeArguments()[0];
      }
    }
    localEnumeration = (Enumeration)paramObject1;
    paramType = paramJSONSerializer.context;
    paramJSONSerializer.setContext(paramType, paramObject1, paramObject2, 0);
    try
    {
      localSerializeWriter.append('[');
      while (localEnumeration.hasMoreElements())
      {
        paramObject1 = localEnumeration.nextElement();
        int i = paramInt + 1;
        if (paramInt != 0) {
          localSerializeWriter.append(',');
        }
        if (paramObject1 == null)
        {
          localSerializeWriter.writeNull();
          paramInt = i;
        }
        else
        {
          paramJSONSerializer.getObjectWriter(paramObject1.getClass()).write(paramJSONSerializer, paramObject1, Integer.valueOf(i - 1), (Type)localObject, 0);
          paramInt = i;
        }
      }
      localSerializeWriter.append(']');
      return;
    }
    finally
    {
      paramJSONSerializer.context = paramType;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/EnumerationSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */