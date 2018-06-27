package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;

public class ReferenceCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final ReferenceCodec instance = new ReferenceCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    paramType = (ParameterizedType)paramType;
    paramDefaultJSONParser = paramDefaultJSONParser.parseObject(paramType.getActualTypeArguments()[0]);
    paramType = paramType.getRawType();
    if (paramType == AtomicReference.class) {
      return new AtomicReference(paramDefaultJSONParser);
    }
    if (paramType == WeakReference.class) {
      return new WeakReference(paramDefaultJSONParser);
    }
    if (paramType == SoftReference.class) {
      return new SoftReference(paramDefaultJSONParser);
    }
    throw new UnsupportedOperationException(paramType.toString());
  }
  
  public int getFastMatchToken()
  {
    return 12;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt)
    throws IOException
  {
    if ((paramObject1 instanceof AtomicReference)) {}
    for (paramObject1 = ((AtomicReference)paramObject1).get();; paramObject1 = ((Reference)paramObject1).get())
    {
      paramJSONSerializer.write(paramObject1);
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/ReferenceCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */