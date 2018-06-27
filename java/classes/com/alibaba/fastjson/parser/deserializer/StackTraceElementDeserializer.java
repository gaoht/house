package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.d;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import java.lang.reflect.Type;

public class StackTraceElementDeserializer
  implements ObjectDeserializer
{
  public static final StackTraceElementDeserializer instance = new StackTraceElementDeserializer();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.lexer;
    if (localJSONLexer.token() == 8)
    {
      localJSONLexer.nextToken();
      return null;
    }
    if ((localJSONLexer.token() != 12) && (localJSONLexer.token() != 16)) {
      throw new d("syntax error: " + JSONToken.name(localJSONLexer.token()));
    }
    Object localObject3 = null;
    Object localObject2 = null;
    Type localType = null;
    int j = 0;
    Object localObject1;
    int i;
    label150:
    do
    {
      paramType = localJSONLexer.scanSymbol(paramDefaultJSONParser.getSymbolTable());
      if (paramType != null) {
        break;
      }
      if (localJSONLexer.token() == 13)
      {
        localJSONLexer.nextToken(16);
        localObject1 = localObject3;
        paramObject = localObject2;
        paramType = localType;
        i = j;
        return new StackTraceElement((String)localObject1, (String)paramObject, paramType, i);
      }
    } while ((localJSONLexer.token() == 16) && (localJSONLexer.isEnabled(Feature.AllowArbitraryCommas)));
    localJSONLexer.nextTokenWithColon(4);
    if ("className".equals(paramType)) {
      if (localJSONLexer.token() == 8)
      {
        localObject1 = null;
        paramObject = localObject2;
        paramType = localType;
        i = j;
      }
    }
    for (;;)
    {
      j = i;
      localType = paramType;
      localObject2 = paramObject;
      localObject3 = localObject1;
      if (localJSONLexer.token() != 13) {
        break;
      }
      localJSONLexer.nextToken(16);
      break label150;
      if (localJSONLexer.token() == 4)
      {
        localObject1 = localJSONLexer.stringVal();
        i = j;
        paramType = localType;
        paramObject = localObject2;
      }
      else
      {
        throw new d("syntax error");
        if ("methodName".equals(paramType))
        {
          if (localJSONLexer.token() == 8)
          {
            paramObject = null;
            i = j;
            paramType = localType;
            localObject1 = localObject3;
          }
          else if (localJSONLexer.token() == 4)
          {
            paramObject = localJSONLexer.stringVal();
            i = j;
            paramType = localType;
            localObject1 = localObject3;
          }
          else
          {
            throw new d("syntax error");
          }
        }
        else if ("fileName".equals(paramType))
        {
          if (localJSONLexer.token() == 8)
          {
            paramType = null;
            i = j;
            paramObject = localObject2;
            localObject1 = localObject3;
          }
          else if (localJSONLexer.token() == 4)
          {
            paramType = localJSONLexer.stringVal();
            i = j;
            paramObject = localObject2;
            localObject1 = localObject3;
          }
          else
          {
            throw new d("syntax error");
          }
        }
        else if ("lineNumber".equals(paramType))
        {
          if (localJSONLexer.token() == 8)
          {
            i = 0;
            paramType = localType;
            paramObject = localObject2;
            localObject1 = localObject3;
          }
          else if (localJSONLexer.token() == 2)
          {
            i = localJSONLexer.intValue();
            paramType = localType;
            paramObject = localObject2;
            localObject1 = localObject3;
          }
          else
          {
            throw new d("syntax error");
          }
        }
        else if ("nativeMethod".equals(paramType))
        {
          if (localJSONLexer.token() == 8)
          {
            localJSONLexer.nextToken(16);
            i = j;
            paramType = localType;
            paramObject = localObject2;
            localObject1 = localObject3;
          }
          else if (localJSONLexer.token() == 6)
          {
            localJSONLexer.nextToken(16);
            i = j;
            paramType = localType;
            paramObject = localObject2;
            localObject1 = localObject3;
          }
          else if (localJSONLexer.token() == 7)
          {
            localJSONLexer.nextToken(16);
            i = j;
            paramType = localType;
            paramObject = localObject2;
            localObject1 = localObject3;
          }
          else
          {
            throw new d("syntax error");
          }
        }
        else if (paramType == a.c)
        {
          if (localJSONLexer.token() == 4)
          {
            String str = localJSONLexer.stringVal();
            i = j;
            paramType = localType;
            paramObject = localObject2;
            localObject1 = localObject3;
            if (!str.equals("java.lang.StackTraceElement")) {
              throw new d("syntax error : " + str);
            }
          }
          else
          {
            i = j;
            paramType = localType;
            paramObject = localObject2;
            localObject1 = localObject3;
            if (localJSONLexer.token() != 8) {
              throw new d("syntax error");
            }
          }
        }
        else if ("moduleName".equals(paramType))
        {
          i = j;
          paramType = localType;
          paramObject = localObject2;
          localObject1 = localObject3;
          if (localJSONLexer.token() != 8) {
            if (localJSONLexer.token() == 4)
            {
              localJSONLexer.stringVal();
              i = j;
              paramType = localType;
              paramObject = localObject2;
              localObject1 = localObject3;
            }
            else
            {
              throw new d("syntax error");
            }
          }
        }
        else
        {
          if (!"moduleVersion".equals(paramType)) {
            break label962;
          }
          i = j;
          paramType = localType;
          paramObject = localObject2;
          localObject1 = localObject3;
          if (localJSONLexer.token() != 8)
          {
            if (localJSONLexer.token() != 4) {
              break label952;
            }
            localJSONLexer.stringVal();
            i = j;
            paramType = localType;
            paramObject = localObject2;
            localObject1 = localObject3;
          }
        }
      }
    }
    label952:
    throw new d("syntax error");
    label962:
    throw new d("syntax error : " + paramType);
  }
  
  public int getFastMatchToken()
  {
    return 12;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/StackTraceElementDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */