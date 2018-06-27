package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.d;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

public class CharArrayCodec
  implements ObjectDeserializer
{
  public static <T> T deserialze(DefaultJSONParser paramDefaultJSONParser)
  {
    Object localObject1 = paramDefaultJSONParser.lexer;
    if (((JSONLexer)localObject1).token() == 4)
    {
      paramDefaultJSONParser = ((JSONLexer)localObject1).stringVal();
      ((JSONLexer)localObject1).nextToken(16);
      return paramDefaultJSONParser.toCharArray();
    }
    if (((JSONLexer)localObject1).token() == 2)
    {
      paramDefaultJSONParser = ((JSONLexer)localObject1).integerValue();
      ((JSONLexer)localObject1).nextToken(16);
      return paramDefaultJSONParser.toString().toCharArray();
    }
    paramDefaultJSONParser = paramDefaultJSONParser.parse();
    if ((paramDefaultJSONParser instanceof String)) {
      return ((String)paramDefaultJSONParser).toCharArray();
    }
    if ((paramDefaultJSONParser instanceof Collection))
    {
      localObject1 = ((Collection)paramDefaultJSONParser).iterator();
      Object localObject2;
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = ((Iterator)localObject1).next();
      } while ((!(localObject2 instanceof String)) || (((String)localObject2).length() == 1));
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        throw new d("can not cast to char[]");
      }
      if (paramDefaultJSONParser == null) {
        return null;
      }
      return a.toJSONString(paramDefaultJSONParser).toCharArray();
    }
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    return (T)deserialze(paramDefaultJSONParser);
  }
  
  public int getFastMatchToken()
  {
    return 4;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/CharArrayCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */