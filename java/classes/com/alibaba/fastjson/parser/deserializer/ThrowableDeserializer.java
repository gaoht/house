package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.d;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class ThrowableDeserializer
  extends JavaBeanDeserializer
{
  public ThrowableDeserializer(ParserConfig paramParserConfig, Class<?> paramClass)
  {
    super(paramParserConfig, paramClass, paramClass);
  }
  
  private Throwable createException(String paramString, Throwable paramThrowable, Class<?> paramClass)
    throws Exception
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Constructor[] arrayOfConstructor = paramClass.getConstructors();
    int j = arrayOfConstructor.length;
    int i = 0;
    Object localObject3 = null;
    paramClass = (Class<?>)localObject2;
    Object localObject4;
    if (i < j)
    {
      localObject2 = arrayOfConstructor[i];
      localObject4 = ((Constructor)localObject2).getParameterTypes();
      if (localObject4.length == 0)
      {
        paramClass = (Class<?>)localObject1;
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      i += 1;
      localObject2 = localObject1;
      localObject1 = paramClass;
      paramClass = (Class<?>)localObject2;
      break;
      if ((localObject4.length == 1) && (localObject4[0] == String.class))
      {
        localObject1 = paramClass;
        paramClass = (Class<?>)localObject2;
      }
      else if ((localObject4.length == 2) && (localObject4[0] == String.class) && (localObject4[1] == Throwable.class))
      {
        localObject4 = paramClass;
        localObject3 = localObject2;
        paramClass = (Class<?>)localObject1;
        localObject1 = localObject4;
        continue;
        if (localObject3 != null) {
          return (Throwable)((Constructor)localObject3).newInstance(new Object[] { paramString, paramThrowable });
        }
        if (localObject1 != null) {
          return (Throwable)((Constructor)localObject1).newInstance(new Object[] { paramString });
        }
        if (paramClass != null) {
          return (Throwable)paramClass.newInstance(new Object[0]);
        }
        return null;
      }
      else
      {
        localObject2 = paramClass;
        paramClass = (Class<?>)localObject1;
        localObject1 = localObject2;
      }
    }
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.lexer;
    if (localJSONLexer.token() == 8)
    {
      localJSONLexer.nextToken();
      paramObject = null;
      return (T)paramObject;
    }
    if (paramDefaultJSONParser.getResolveStatus() == 2)
    {
      paramDefaultJSONParser.setResolveStatus(0);
      label42:
      paramObject = null;
      if ((paramType == null) || (!(paramType instanceof Class))) {
        break label546;
      }
      paramType = (Class)paramType;
      if (!Throwable.class.isAssignableFrom(paramType)) {
        break label546;
      }
    }
    for (;;)
    {
      Object localObject2 = null;
      Object localObject3 = null;
      HashMap localHashMap = new HashMap();
      Object localObject1 = paramType;
      paramType = (Type)localObject3;
      label90:
      localObject3 = localJSONLexer.scanSymbol(paramDefaultJSONParser.getSymbolTable());
      if (localObject3 == null) {
        if (localJSONLexer.token() == 13)
        {
          localJSONLexer.nextToken(16);
          localObject3 = paramObject;
          paramObject = localObject2;
          if (localObject1 != null) {
            break label501;
          }
          paramDefaultJSONParser = new Exception((String)paramObject, (Throwable)localObject3);
        }
      }
      for (;;)
      {
        paramObject = paramDefaultJSONParser;
        if (paramType == null) {
          break;
        }
        paramDefaultJSONParser.setStackTrace(paramType);
        return paramDefaultJSONParser;
        if (localJSONLexer.token() == 12) {
          break label42;
        }
        throw new d("syntax error");
        if ((localJSONLexer.token() == 16) && (localJSONLexer.isEnabled(Feature.AllowArbitraryCommas))) {
          break label90;
        }
        localJSONLexer.nextTokenWithColon(4);
        if (a.c.equals(localObject3)) {
          if (localJSONLexer.token() == 4)
          {
            localObject1 = TypeUtils.loadClass(localJSONLexer.stringVal(), paramDefaultJSONParser.getConfig().getDefaultClassLoader());
            localJSONLexer.nextToken(16);
            localObject3 = localObject2;
            localObject2 = paramObject;
            paramObject = localObject3;
          }
        }
        for (;;)
        {
          if (localJSONLexer.token() != 13) {
            break label488;
          }
          localJSONLexer.nextToken(16);
          localObject3 = localObject2;
          break;
          throw new d("syntax error");
          if ("message".equals(localObject3))
          {
            if (localJSONLexer.token() == 8) {}
            for (localObject2 = null;; localObject2 = localJSONLexer.stringVal())
            {
              localJSONLexer.nextToken();
              localObject3 = paramObject;
              paramObject = localObject2;
              localObject2 = localObject3;
              break;
              if (localJSONLexer.token() != 4) {
                break label385;
              }
            }
            label385:
            throw new d("syntax error");
          }
          if ("cause".equals(localObject3))
          {
            localObject3 = (Throwable)deserialze(paramDefaultJSONParser, null, "cause");
            paramObject = localObject2;
            localObject2 = localObject3;
          }
          else if ("stackTrace".equals(localObject3))
          {
            paramType = (StackTraceElement[])paramDefaultJSONParser.parseObject(StackTraceElement[].class);
            localObject3 = paramObject;
            paramObject = localObject2;
            localObject2 = localObject3;
          }
          else
          {
            localHashMap.put(localObject3, paramDefaultJSONParser.parse());
            localObject3 = paramObject;
            paramObject = localObject2;
            localObject2 = localObject3;
          }
        }
        label488:
        localObject3 = localObject2;
        localObject2 = paramObject;
        paramObject = localObject3;
        break label90;
        try
        {
          label501:
          localObject1 = createException((String)paramObject, (Throwable)localObject3, (Class)localObject1);
          paramDefaultJSONParser = (DefaultJSONParser)localObject1;
          if (localObject1 == null) {
            paramDefaultJSONParser = new Exception((String)paramObject, (Throwable)localObject3);
          }
        }
        catch (Exception paramDefaultJSONParser)
        {
          throw new d("create instance error", paramDefaultJSONParser);
        }
      }
      label546:
      paramType = null;
    }
  }
  
  public int getFastMatchToken()
  {
    return 12;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/ThrowableDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */