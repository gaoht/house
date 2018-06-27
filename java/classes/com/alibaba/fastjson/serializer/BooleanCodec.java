package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

public class BooleanCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final BooleanCodec instance = new BooleanCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    paramObject = paramDefaultJSONParser.lexer;
    if (((JSONLexer)paramObject).token() == 6)
    {
      ((JSONLexer)paramObject).nextToken(16);
      paramDefaultJSONParser = Boolean.TRUE;
    }
    for (;;)
    {
      paramObject = paramDefaultJSONParser;
      if (paramType == AtomicBoolean.class) {
        paramObject = new AtomicBoolean(paramDefaultJSONParser.booleanValue());
      }
      return (T)paramObject;
      if (((JSONLexer)paramObject).token() == 7)
      {
        ((JSONLexer)paramObject).nextToken(16);
        paramDefaultJSONParser = Boolean.FALSE;
      }
      else if (((JSONLexer)paramObject).token() == 2)
      {
        int i = ((JSONLexer)paramObject).intValue();
        ((JSONLexer)paramObject).nextToken(16);
        if (i == 1) {
          paramDefaultJSONParser = Boolean.TRUE;
        } else {
          paramDefaultJSONParser = Boolean.FALSE;
        }
      }
      else
      {
        paramDefaultJSONParser = paramDefaultJSONParser.parse();
        if (paramDefaultJSONParser == null) {
          return null;
        }
        paramDefaultJSONParser = TypeUtils.castToBoolean(paramDefaultJSONParser);
      }
    }
  }
  
  public int getFastMatchToken()
  {
    return 6;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt)
    throws IOException
  {
    paramJSONSerializer = paramJSONSerializer.out;
    paramObject1 = (Boolean)paramObject1;
    if (paramObject1 == null)
    {
      paramJSONSerializer.writeNull(SerializerFeature.WriteNullBooleanAsFalse);
      return;
    }
    if (((Boolean)paramObject1).booleanValue())
    {
      paramJSONSerializer.write("true");
      return;
    }
    paramJSONSerializer.write("false");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/BooleanCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */