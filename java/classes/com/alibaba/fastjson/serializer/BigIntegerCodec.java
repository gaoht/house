package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigInteger;

public class BigIntegerCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final BigIntegerCodec instance = new BigIntegerCodec();
  
  public static <T> T deserialze(DefaultJSONParser paramDefaultJSONParser)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.lexer;
    if (localJSONLexer.token() == 2)
    {
      paramDefaultJSONParser = localJSONLexer.numberString();
      localJSONLexer.nextToken(16);
      return new BigInteger(paramDefaultJSONParser);
    }
    paramDefaultJSONParser = paramDefaultJSONParser.parse();
    if (paramDefaultJSONParser == null) {
      return null;
    }
    return TypeUtils.castToBigInteger(paramDefaultJSONParser);
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    return (T)deserialze(paramDefaultJSONParser);
  }
  
  public int getFastMatchToken()
  {
    return 2;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt)
    throws IOException
  {
    paramJSONSerializer = paramJSONSerializer.out;
    if (paramObject1 == null)
    {
      paramJSONSerializer.writeNull(SerializerFeature.WriteNullNumberAsZero);
      return;
    }
    paramJSONSerializer.write(((BigInteger)paramObject1).toString());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/BigIntegerCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */