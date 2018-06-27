package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.d;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class OptionalCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static OptionalCodec instance = new OptionalCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    if (paramType == OptionalInt.class)
    {
      paramDefaultJSONParser = TypeUtils.castToInt(paramDefaultJSONParser.parseObject(Integer.class));
      if (paramDefaultJSONParser == null) {
        return OptionalInt.empty();
      }
      return OptionalInt.of(paramDefaultJSONParser.intValue());
    }
    if (paramType == OptionalLong.class)
    {
      paramDefaultJSONParser = TypeUtils.castToLong(paramDefaultJSONParser.parseObject(Long.class));
      if (paramDefaultJSONParser == null) {
        return OptionalLong.empty();
      }
      return OptionalLong.of(paramDefaultJSONParser.longValue());
    }
    if (paramType == OptionalDouble.class)
    {
      paramDefaultJSONParser = TypeUtils.castToDouble(paramDefaultJSONParser.parseObject(Double.class));
      if (paramDefaultJSONParser == null) {
        return OptionalDouble.empty();
      }
      return OptionalDouble.of(paramDefaultJSONParser.doubleValue());
    }
    paramDefaultJSONParser = paramDefaultJSONParser.parseObject(TypeUtils.unwrapOptional(paramType));
    if (paramDefaultJSONParser == null) {
      return Optional.empty();
    }
    return Optional.of(paramDefaultJSONParser);
  }
  
  public int getFastMatchToken()
  {
    return 12;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt)
    throws IOException
  {
    if (paramObject1 == null)
    {
      paramJSONSerializer.writeNull();
      return;
    }
    if ((paramObject1 instanceof Optional))
    {
      paramObject1 = (Optional)paramObject1;
      if (((Optional)paramObject1).isPresent()) {}
      for (paramObject1 = ((Optional)paramObject1).get();; paramObject1 = null)
      {
        paramJSONSerializer.write(paramObject1);
        return;
      }
    }
    if ((paramObject1 instanceof OptionalDouble))
    {
      paramObject1 = (OptionalDouble)paramObject1;
      if (((OptionalDouble)paramObject1).isPresent())
      {
        paramJSONSerializer.write(Double.valueOf(((OptionalDouble)paramObject1).getAsDouble()));
        return;
      }
      paramJSONSerializer.writeNull();
      return;
    }
    if ((paramObject1 instanceof OptionalInt))
    {
      paramObject1 = (OptionalInt)paramObject1;
      if (((OptionalInt)paramObject1).isPresent())
      {
        paramInt = ((OptionalInt)paramObject1).getAsInt();
        paramJSONSerializer.out.writeInt(paramInt);
        return;
      }
      paramJSONSerializer.writeNull();
      return;
    }
    if ((paramObject1 instanceof OptionalLong))
    {
      paramObject1 = (OptionalLong)paramObject1;
      if (((OptionalLong)paramObject1).isPresent())
      {
        long l = ((OptionalLong)paramObject1).getAsLong();
        paramJSONSerializer.out.writeLong(l);
        return;
      }
      paramJSONSerializer.writeNull();
      return;
    }
    throw new d("not support optional : " + paramObject1.getClass());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/OptionalCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */