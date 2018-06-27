package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

public class PrimitiveArraySerializer
  implements ObjectSerializer
{
  public static PrimitiveArraySerializer instance = new PrimitiveArraySerializer();
  
  public final void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt)
    throws IOException
  {
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    paramInt = 0;
    paramJSONSerializer = paramJSONSerializer.out;
    if (paramObject1 == null)
    {
      paramJSONSerializer.writeNull(SerializerFeature.WriteNullListAsEmpty);
      return;
    }
    if ((paramObject1 instanceof int[]))
    {
      paramObject1 = (int[])paramObject1;
      paramJSONSerializer.write(91);
      while (paramInt < paramObject1.length)
      {
        if (paramInt != 0) {
          paramJSONSerializer.write(44);
        }
        paramJSONSerializer.writeInt(paramObject1[paramInt]);
        paramInt += 1;
      }
      paramJSONSerializer.write(93);
      return;
    }
    if ((paramObject1 instanceof short[]))
    {
      paramObject1 = (short[])paramObject1;
      paramJSONSerializer.write(91);
      paramInt = i;
      while (paramInt < paramObject1.length)
      {
        if (paramInt != 0) {
          paramJSONSerializer.write(44);
        }
        paramJSONSerializer.writeInt(paramObject1[paramInt]);
        paramInt += 1;
      }
      paramJSONSerializer.write(93);
      return;
    }
    if ((paramObject1 instanceof long[]))
    {
      paramObject1 = (long[])paramObject1;
      paramJSONSerializer.write(91);
      paramInt = j;
      while (paramInt < paramObject1.length)
      {
        if (paramInt != 0) {
          paramJSONSerializer.write(44);
        }
        paramJSONSerializer.writeLong(paramObject1[paramInt]);
        paramInt += 1;
      }
      paramJSONSerializer.write(93);
      return;
    }
    if ((paramObject1 instanceof boolean[]))
    {
      paramObject1 = (boolean[])paramObject1;
      paramJSONSerializer.write(91);
      paramInt = k;
      while (paramInt < paramObject1.length)
      {
        if (paramInt != 0) {
          paramJSONSerializer.write(44);
        }
        paramJSONSerializer.write(paramObject1[paramInt]);
        paramInt += 1;
      }
      paramJSONSerializer.write(93);
      return;
    }
    if ((paramObject1 instanceof float[]))
    {
      paramObject1 = (float[])paramObject1;
      paramJSONSerializer.write(91);
      paramInt = m;
      if (paramInt < paramObject1.length)
      {
        if (paramInt != 0) {
          paramJSONSerializer.write(44);
        }
        float f = paramObject1[paramInt];
        if (Float.isNaN(f)) {
          paramJSONSerializer.writeNull();
        }
        for (;;)
        {
          paramInt += 1;
          break;
          paramJSONSerializer.append(Float.toString(f));
        }
      }
      paramJSONSerializer.write(93);
      return;
    }
    if ((paramObject1 instanceof double[]))
    {
      paramObject1 = (double[])paramObject1;
      paramJSONSerializer.write(91);
      paramInt = n;
      if (paramInt < paramObject1.length)
      {
        if (paramInt != 0) {
          paramJSONSerializer.write(44);
        }
        double d = paramObject1[paramInt];
        if (Double.isNaN(d)) {
          paramJSONSerializer.writeNull();
        }
        for (;;)
        {
          paramInt += 1;
          break;
          paramJSONSerializer.append(Double.toString(d));
        }
      }
      paramJSONSerializer.write(93);
      return;
    }
    if ((paramObject1 instanceof byte[]))
    {
      paramJSONSerializer.writeByteArray((byte[])paramObject1);
      return;
    }
    paramJSONSerializer.writeString(new String((char[])paramObject1));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/PrimitiveArraySerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */