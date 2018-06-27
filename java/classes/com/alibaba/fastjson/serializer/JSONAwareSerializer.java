package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.c;
import java.io.IOException;
import java.lang.reflect.Type;

public class JSONAwareSerializer
  implements ObjectSerializer
{
  public static JSONAwareSerializer instance = new JSONAwareSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt)
    throws IOException
  {
    paramJSONSerializer.out.write(((c)paramObject1).toJSONString());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/JSONAwareSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */