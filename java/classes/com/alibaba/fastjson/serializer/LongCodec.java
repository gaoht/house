package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicLong;

public class LongCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static LongCodec instance = new LongCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    paramObject = paramDefaultJSONParser.lexer;
    long l;
    if (((JSONLexer)paramObject).token() == 2)
    {
      l = ((JSONLexer)paramObject).longValue();
      ((JSONLexer)paramObject).nextToken(16);
    }
    for (paramDefaultJSONParser = Long.valueOf(l);; paramDefaultJSONParser = TypeUtils.castToLong(paramDefaultJSONParser))
    {
      paramObject = paramDefaultJSONParser;
      if (paramType == AtomicLong.class) {
        paramObject = new AtomicLong(paramDefaultJSONParser.longValue());
      }
      return (T)paramObject;
      paramDefaultJSONParser = paramDefaultJSONParser.parse();
      if (paramDefaultJSONParser == null) {
        return null;
      }
    }
  }
  
  public int getFastMatchToken()
  {
    return 2;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt)
    throws IOException
  {
    paramJSONSerializer = paramJSONSerializer.out;
    if (paramObject1 == null) {
      paramJSONSerializer.writeNull(SerializerFeature.WriteNullNumberAsZero);
    }
    long l;
    do
    {
      return;
      l = ((Long)paramObject1).longValue();
      paramJSONSerializer.writeLong(l);
    } while ((!paramJSONSerializer.isEnabled(SerializerFeature.WriteClassName)) || (l > 2147483647L) || (l < -2147483648L) || (paramType == Long.class));
    paramJSONSerializer.write(76);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/LongCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */