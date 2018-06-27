package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.d;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

public class IntegerCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static IntegerCodec instance = new IntegerCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.lexer;
    if (localJSONLexer.token() == 8)
    {
      localJSONLexer.nextToken(16);
      paramObject = null;
      return (T)paramObject;
    }
    if (localJSONLexer.token() == 2) {}
    for (;;)
    {
      try
      {
        int i = localJSONLexer.intValue();
        localJSONLexer.nextToken(16);
        paramDefaultJSONParser = Integer.valueOf(i);
        paramObject = paramDefaultJSONParser;
        if (paramType != AtomicInteger.class) {
          break;
        }
        return new AtomicInteger(paramDefaultJSONParser.intValue());
      }
      catch (NumberFormatException paramDefaultJSONParser)
      {
        throw new d("int value overflow, field : " + paramObject, paramDefaultJSONParser);
      }
      if (localJSONLexer.token() == 3)
      {
        paramDefaultJSONParser = localJSONLexer.decimalValue();
        localJSONLexer.nextToken(16);
        paramDefaultJSONParser = Integer.valueOf(paramDefaultJSONParser.intValue());
      }
      else
      {
        paramDefaultJSONParser = TypeUtils.castToInt(paramDefaultJSONParser.parse());
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
    paramObject2 = (Number)paramObject1;
    if (paramObject2 == null) {
      paramJSONSerializer.writeNull(SerializerFeature.WriteNullNumberAsZero);
    }
    label76:
    do
    {
      for (;;)
      {
        return;
        if ((paramObject1 instanceof Long)) {
          paramJSONSerializer.writeLong(((Number)paramObject2).longValue());
        }
        while (paramJSONSerializer.isEnabled(SerializerFeature.WriteClassName))
        {
          paramObject1 = paramObject2.getClass();
          if (paramObject1 != Byte.class) {
            break label76;
          }
          paramJSONSerializer.write(66);
          return;
          paramJSONSerializer.writeInt(((Number)paramObject2).intValue());
        }
      }
    } while (paramObject1 != Short.class);
    paramJSONSerializer.write(83);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/IntegerCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */