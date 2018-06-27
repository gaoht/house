package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.d;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigDecimal;

public class NumberDeserializer
  implements ObjectDeserializer
{
  public static final NumberDeserializer instance = new NumberDeserializer();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.lexer;
    if (localJSONLexer.token() == 2) {
      if ((paramType == Double.TYPE) || (paramType == Double.class))
      {
        paramDefaultJSONParser = localJSONLexer.numberString();
        localJSONLexer.nextToken(16);
        paramDefaultJSONParser = Double.valueOf(Double.parseDouble(paramDefaultJSONParser));
      }
    }
    do
    {
      return paramDefaultJSONParser;
      long l = localJSONLexer.longValue();
      localJSONLexer.nextToken(16);
      if ((paramType == Short.TYPE) || (paramType == Short.class))
      {
        if ((l > 32767L) || (l < -32768L)) {
          throw new d("short overflow : " + l);
        }
        return Short.valueOf((short)(int)l);
      }
      if ((paramType == Byte.TYPE) || (paramType == Byte.class))
      {
        if ((l > 127L) || (l < -128L)) {
          throw new d("short overflow : " + l);
        }
        return Byte.valueOf((byte)(int)l);
      }
      if ((l >= -2147483648L) && (l <= 2147483647L)) {
        return Integer.valueOf((int)l);
      }
      return Long.valueOf(l);
      if (localJSONLexer.token() != 3) {
        break label350;
      }
      if ((paramType == Double.TYPE) || (paramType == Double.class))
      {
        paramDefaultJSONParser = localJSONLexer.numberString();
        localJSONLexer.nextToken(16);
        return Double.valueOf(Double.parseDouble(paramDefaultJSONParser));
      }
      paramObject = localJSONLexer.decimalValue();
      localJSONLexer.nextToken(16);
      if ((paramType == Short.TYPE) || (paramType == Short.class)) {
        return Short.valueOf(((BigDecimal)paramObject).shortValue());
      }
      if (paramType == Byte.TYPE) {
        break;
      }
      paramDefaultJSONParser = (DefaultJSONParser)paramObject;
    } while (paramType != Byte.class);
    return Byte.valueOf(((BigDecimal)paramObject).byteValue());
    label350:
    paramDefaultJSONParser = paramDefaultJSONParser.parse();
    if (paramDefaultJSONParser == null) {
      return null;
    }
    if ((paramType == Double.TYPE) || (paramType == Double.class)) {
      return TypeUtils.castToDouble(paramDefaultJSONParser);
    }
    if ((paramType == Short.TYPE) || (paramType == Short.class)) {
      return TypeUtils.castToShort(paramDefaultJSONParser);
    }
    if ((paramType == Byte.TYPE) || (paramType == Byte.class)) {
      return TypeUtils.castToByte(paramDefaultJSONParser);
    }
    return TypeUtils.castToBigDecimal(paramDefaultJSONParser);
  }
  
  public int getFastMatchToken()
  {
    return 2;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/NumberDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */