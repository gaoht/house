package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

public class BigDecimalCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final BigDecimalCodec instance = new BigDecimalCodec();
  
  public static <T> T deserialze(DefaultJSONParser paramDefaultJSONParser)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.lexer;
    if (localJSONLexer.token() == 2)
    {
      paramDefaultJSONParser = localJSONLexer.decimalValue();
      localJSONLexer.nextToken(16);
      return paramDefaultJSONParser;
    }
    if (localJSONLexer.token() == 3)
    {
      paramDefaultJSONParser = localJSONLexer.decimalValue();
      localJSONLexer.nextToken(16);
      return paramDefaultJSONParser;
    }
    paramDefaultJSONParser = paramDefaultJSONParser.parse();
    if (paramDefaultJSONParser == null) {
      return null;
    }
    return TypeUtils.castToBigDecimal(paramDefaultJSONParser);
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
    paramObject2 = paramJSONSerializer.out;
    if (paramObject1 == null)
    {
      ((SerializeWriter)paramObject2).writeNull(SerializerFeature.WriteNullNumberAsZero);
      return;
    }
    paramObject1 = (BigDecimal)paramObject1;
    if (((SerializeWriter)paramObject2).isEnabled(SerializerFeature.WriteBigDecimalAsPlain)) {}
    for (paramJSONSerializer = ((BigDecimal)paramObject1).toPlainString();; paramJSONSerializer = ((BigDecimal)paramObject1).toString())
    {
      ((SerializeWriter)paramObject2).write(paramJSONSerializer);
      if ((!((SerializeWriter)paramObject2).isEnabled(SerializerFeature.WriteClassName)) || (paramType == BigDecimal.class) || (((BigDecimal)paramObject1).scale() != 0)) {
        break;
      }
      ((SerializeWriter)paramObject2).write(46);
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/BigDecimalCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */