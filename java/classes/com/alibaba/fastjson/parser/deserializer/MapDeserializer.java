package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.d;
import com.alibaba.fastjson.e;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MapDeserializer
  implements ObjectDeserializer
{
  public static MapDeserializer instance = new MapDeserializer();
  
  public static Object parseMap(DefaultJSONParser paramDefaultJSONParser, Map<Object, Object> paramMap, Type paramType1, Type paramType2, Object paramObject)
  {
    Object localObject1 = null;
    JSONLexer localJSONLexer = paramDefaultJSONParser.lexer;
    if ((localJSONLexer.token() != 12) && (localJSONLexer.token() != 16)) {
      throw new d("syntax error, expect {, actual " + localJSONLexer.tokenName());
    }
    ObjectDeserializer localObjectDeserializer1 = paramDefaultJSONParser.getConfig().getDeserializer(paramType1);
    ObjectDeserializer localObjectDeserializer2 = paramDefaultJSONParser.getConfig().getDeserializer(paramType2);
    localJSONLexer.nextToken(localObjectDeserializer1.getFastMatchToken());
    paramObject = paramDefaultJSONParser.getContext();
    for (;;)
    {
      try
      {
        if (localJSONLexer.token() == 13)
        {
          localJSONLexer.nextToken(16);
          return paramMap;
        }
        if ((localJSONLexer.token() != 4) || (!localJSONLexer.isRef()) || (localJSONLexer.isEnabled(Feature.DisableSpecialKeyDetect))) {
          break label367;
        }
        localJSONLexer.nextTokenWithColon(4);
        if (localJSONLexer.token() != 4) {
          break label314;
        }
        paramMap = localJSONLexer.stringVal();
        if ("..".equals(paramMap))
        {
          paramMap = ((ParseContext)paramObject).parent.object;
          localJSONLexer.nextToken(13);
          if (localJSONLexer.token() == 13) {
            break label350;
          }
          throw new d("illegal ref");
        }
      }
      finally
      {
        paramDefaultJSONParser.setContext((ParseContext)paramObject);
      }
      if ("$".equals(paramMap))
      {
        for (paramMap = (Map<Object, Object>)paramObject; paramMap.parent != null; paramMap = paramMap.parent) {}
        paramMap = paramMap.object;
      }
      else
      {
        paramDefaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask((ParseContext)paramObject, paramMap));
        paramDefaultJSONParser.setResolveStatus(1);
        paramMap = (Map<Object, Object>)localObject1;
        continue;
        label314:
        throw new d("illegal ref, " + JSONToken.name(localJSONLexer.token()));
        label350:
        localJSONLexer.nextToken(16);
        paramDefaultJSONParser.setContext((ParseContext)paramObject);
        return paramMap;
        label367:
        if ((paramMap.size() == 0) && (localJSONLexer.token() == 4) && (a.c.equals(localJSONLexer.stringVal())) && (!localJSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)))
        {
          localJSONLexer.nextTokenWithColon(4);
          localJSONLexer.nextToken(16);
          if (localJSONLexer.token() == 13)
          {
            localJSONLexer.nextToken();
            paramDefaultJSONParser.setContext((ParseContext)paramObject);
            return paramMap;
          }
          localJSONLexer.nextToken(localObjectDeserializer1.getFastMatchToken());
        }
        Object localObject2 = localObjectDeserializer1.deserialze(paramDefaultJSONParser, paramType1, null);
        if (localJSONLexer.token() != 17) {
          throw new d("syntax error, expect :, actual " + localJSONLexer.token());
        }
        localJSONLexer.nextToken(localObjectDeserializer2.getFastMatchToken());
        Object localObject3 = localObjectDeserializer2.deserialze(paramDefaultJSONParser, paramType2, localObject2);
        paramDefaultJSONParser.checkMapResolve(paramMap, localObject2);
        paramMap.put(localObject2, localObject3);
        if (localJSONLexer.token() == 16) {
          localJSONLexer.nextToken(localObjectDeserializer1.getFastMatchToken());
        }
      }
    }
  }
  
  public static Map parseMap(DefaultJSONParser paramDefaultJSONParser, Map<String, Object> paramMap, Type paramType, Object paramObject)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.lexer;
    if (localJSONLexer.token() != 12) {
      throw new d("syntax error, expect {, actual " + localJSONLexer.token());
    }
    ParseContext localParseContext = paramDefaultJSONParser.getContext();
    int j = 0;
    for (;;)
    {
      int i;
      int k;
      Object localObject1;
      try
      {
        localJSONLexer.skipWhitespace();
        i = localJSONLexer.getCurrent();
        k = i;
        if (localJSONLexer.isEnabled(Feature.AllowArbitraryCommas))
        {
          k = i;
          if (i == 44)
          {
            localJSONLexer.next();
            localJSONLexer.skipWhitespace();
            i = localJSONLexer.getCurrent();
            continue;
          }
        }
        if (k == 34)
        {
          localObject1 = localJSONLexer.scanSymbol(paramDefaultJSONParser.getSymbolTable(), '"');
          localJSONLexer.skipWhitespace();
          if (localJSONLexer.getCurrent() == ':') {
            break label452;
          }
          throw new d("expect ':' at " + localJSONLexer.pos());
        }
      }
      finally
      {
        paramDefaultJSONParser.setContext(localParseContext);
      }
      if (k == 125)
      {
        localJSONLexer.next();
        localJSONLexer.resetStringPosition();
        localJSONLexer.nextToken(16);
        paramDefaultJSONParser.setContext(localParseContext);
        return paramMap;
      }
      if (k == 39)
      {
        if (!localJSONLexer.isEnabled(Feature.AllowSingleQuotes)) {
          throw new d("syntax error");
        }
        localObject1 = localJSONLexer.scanSymbol(paramDefaultJSONParser.getSymbolTable(), '\'');
        localJSONLexer.skipWhitespace();
        if (localJSONLexer.getCurrent() != ':') {
          throw new d("expect ':' at " + localJSONLexer.pos());
        }
      }
      else
      {
        if (!localJSONLexer.isEnabled(Feature.AllowUnQuotedFieldNames)) {
          throw new d("syntax error");
        }
        localObject1 = localJSONLexer.scanSymbolUnQuoted(paramDefaultJSONParser.getSymbolTable());
        localJSONLexer.skipWhitespace();
        char c = localJSONLexer.getCurrent();
        if (c != ':') {
          throw new d("expect ':' at " + localJSONLexer.pos() + ", actual " + c);
        }
      }
      label452:
      localJSONLexer.next();
      localJSONLexer.skipWhitespace();
      localJSONLexer.getCurrent();
      localJSONLexer.resetStringPosition();
      if ((localObject1 == a.c) && (!localJSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)))
      {
        localObject1 = TypeUtils.loadClass(localJSONLexer.scanSymbol(paramDefaultJSONParser.getSymbolTable(), '"'), paramDefaultJSONParser.getConfig().getDefaultClassLoader());
        if (Map.class.isAssignableFrom((Class)localObject1))
        {
          localJSONLexer.nextToken(16);
          if (localJSONLexer.token() == 13)
          {
            localJSONLexer.nextToken(16);
            paramDefaultJSONParser.setContext(localParseContext);
            return paramMap;
          }
        }
        else
        {
          paramMap = paramDefaultJSONParser.getConfig().getDeserializer((Type)localObject1);
          localJSONLexer.nextToken(16);
          paramDefaultJSONParser.setResolveStatus(2);
          if ((localParseContext != null) && (!(paramObject instanceof Integer))) {
            paramDefaultJSONParser.popContext();
          }
          paramMap = (Map)paramMap.deserialze(paramDefaultJSONParser, (Type)localObject1, paramObject);
          paramDefaultJSONParser.setContext(localParseContext);
          return paramMap;
        }
      }
      else
      {
        localJSONLexer.nextToken();
        if (j != 0) {
          paramDefaultJSONParser.setContext(localParseContext);
        }
        Object localObject2;
        if (localJSONLexer.token() == 8)
        {
          localObject2 = null;
          localJSONLexer.nextToken();
        }
        for (;;)
        {
          paramMap.put(localObject1, localObject2);
          paramDefaultJSONParser.checkMapResolve(paramMap, localObject1);
          paramDefaultJSONParser.setContext(localParseContext, localObject2, localObject1);
          paramDefaultJSONParser.setContext(localParseContext);
          i = localJSONLexer.token();
          if ((i != 20) && (i != 15)) {
            break;
          }
          paramDefaultJSONParser.setContext(localParseContext);
          return paramMap;
          localObject2 = paramDefaultJSONParser.parseObject(paramType, localObject1);
        }
        if (i == 13)
        {
          localJSONLexer.nextToken();
          paramDefaultJSONParser.setContext(localParseContext);
          return paramMap;
        }
      }
      j += 1;
    }
  }
  
  protected Map<Object, Object> createMap(Type paramType)
  {
    if (paramType == Properties.class) {
      return new Properties();
    }
    if (paramType == Hashtable.class) {
      return new Hashtable();
    }
    if (paramType == IdentityHashMap.class) {
      return new IdentityHashMap();
    }
    if ((paramType == SortedMap.class) || (paramType == TreeMap.class)) {
      return new TreeMap();
    }
    if ((paramType == ConcurrentMap.class) || (paramType == ConcurrentHashMap.class)) {
      return new ConcurrentHashMap();
    }
    if ((paramType == Map.class) || (paramType == HashMap.class)) {
      return new HashMap();
    }
    if (paramType == LinkedHashMap.class) {
      return new LinkedHashMap();
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = (ParameterizedType)paramType;
      localObject = paramType.getRawType();
      if (EnumMap.class.equals(localObject)) {
        return new EnumMap((Class)paramType.getActualTypeArguments()[0]);
      }
      return createMap((Type)localObject);
    }
    Object localObject = (Class)paramType;
    if (((Class)localObject).isInterface()) {
      throw new d("unsupport type " + paramType);
    }
    try
    {
      localObject = (Map)((Class)localObject).newInstance();
      return (Map<Object, Object>)localObject;
    }
    catch (Exception localException)
    {
      throw new d("unsupport type " + paramType, localException);
    }
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    if ((paramType == e.class) && (paramDefaultJSONParser.getFieldTypeResolver() == null)) {
      return paramDefaultJSONParser.parseObject();
    }
    Object localObject = paramDefaultJSONParser.lexer;
    if (((JSONLexer)localObject).token() == 8)
    {
      ((JSONLexer)localObject).nextToken(16);
      return null;
    }
    Map localMap = createMap(paramType);
    localObject = paramDefaultJSONParser.getContext();
    try
    {
      paramDefaultJSONParser.setContext((ParseContext)localObject, localMap, paramObject);
      paramType = deserialze(paramDefaultJSONParser, paramType, paramObject, localMap);
      return paramType;
    }
    finally
    {
      paramDefaultJSONParser.setContext((ParseContext)localObject);
    }
  }
  
  protected Object deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject, Map paramMap)
  {
    if ((paramType instanceof ParameterizedType))
    {
      Object localObject = (ParameterizedType)paramType;
      paramType = localObject.getActualTypeArguments()[0];
      localObject = localObject.getActualTypeArguments()[1];
      if (String.class == paramType) {
        return parseMap(paramDefaultJSONParser, paramMap, (Type)localObject, paramObject);
      }
      return parseMap(paramDefaultJSONParser, paramMap, paramType, (Type)localObject, paramObject);
    }
    return paramDefaultJSONParser.parseObject(paramMap, paramObject);
  }
  
  public int getFastMatchToken()
  {
    return 12;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/MapDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */