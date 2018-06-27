package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;

public class StringCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static StringCodec instance = new StringCodec();
  
  public static <T> T deserialze(DefaultJSONParser paramDefaultJSONParser)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if (localJSONLexer.token() == 4)
    {
      paramDefaultJSONParser = localJSONLexer.stringVal();
      localJSONLexer.nextToken(16);
      return paramDefaultJSONParser;
    }
    if (localJSONLexer.token() == 2)
    {
      paramDefaultJSONParser = localJSONLexer.numberString();
      localJSONLexer.nextToken(16);
      return paramDefaultJSONParser;
    }
    paramDefaultJSONParser = paramDefaultJSONParser.parse();
    if (paramDefaultJSONParser == null) {
      return null;
    }
    return paramDefaultJSONParser.toString();
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    paramObject = null;
    if (paramType == StringBuffer.class)
    {
      paramType = paramDefaultJSONParser.lexer;
      if (paramType.token() == 4)
      {
        paramDefaultJSONParser = paramType.stringVal();
        paramType.nextToken(16);
        paramDefaultJSONParser = new StringBuffer(paramDefaultJSONParser);
      }
    }
    do
    {
      do
      {
        return paramDefaultJSONParser;
        paramType = paramDefaultJSONParser.parse();
        paramDefaultJSONParser = (DefaultJSONParser)paramObject;
      } while (paramType == null);
      return new StringBuffer(paramType.toString());
      if (paramType != StringBuilder.class) {
        break;
      }
      paramType = paramDefaultJSONParser.lexer;
      if (paramType.token() == 4)
      {
        paramDefaultJSONParser = paramType.stringVal();
        paramType.nextToken(16);
        return new StringBuilder(paramDefaultJSONParser);
      }
      paramType = paramDefaultJSONParser.parse();
      paramDefaultJSONParser = (DefaultJSONParser)paramObject;
    } while (paramType == null);
    return new StringBuilder(paramType.toString());
    return (T)deserialze(paramDefaultJSONParser);
  }
  
  public int getFastMatchToken()
  {
    return 4;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt)
    throws IOException
  {
    write(paramJSONSerializer, (String)paramObject1);
  }
  
  public void write(JSONSerializer paramJSONSerializer, String paramString)
  {
    paramJSONSerializer = paramJSONSerializer.out;
    if (paramString == null)
    {
      paramJSONSerializer.writeNull(SerializerFeature.WriteNullStringAsEmpty);
      return;
    }
    paramJSONSerializer.writeString(paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/StringCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */