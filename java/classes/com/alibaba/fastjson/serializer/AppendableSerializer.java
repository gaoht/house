package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

public class AppendableSerializer
  implements ObjectSerializer
{
  public static final AppendableSerializer instance = new AppendableSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt)
    throws IOException
  {
    if (paramObject1 == null)
    {
      paramJSONSerializer.out.writeNull(SerializerFeature.WriteNullStringAsEmpty);
      return;
    }
    paramJSONSerializer.write(paramObject1.toString());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/AppendableSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */