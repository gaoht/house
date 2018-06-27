package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.b;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public class AtomicCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final AtomicCodec instance = new AtomicCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    int j = 0;
    int i = 0;
    if (paramDefaultJSONParser.lexer.token() == 8)
    {
      paramDefaultJSONParser.lexer.nextToken(16);
      return null;
    }
    paramObject = new b();
    paramDefaultJSONParser.parseArray((Collection)paramObject);
    if (paramType == AtomicIntegerArray.class)
    {
      paramDefaultJSONParser = new AtomicIntegerArray(((b)paramObject).size());
      while (i < ((b)paramObject).size())
      {
        paramDefaultJSONParser.set(i, ((b)paramObject).getInteger(i).intValue());
        i += 1;
      }
      return paramDefaultJSONParser;
    }
    paramDefaultJSONParser = new AtomicLongArray(((b)paramObject).size());
    i = j;
    while (i < ((b)paramObject).size())
    {
      paramDefaultJSONParser.set(i, ((b)paramObject).getLong(i).longValue());
      i += 1;
    }
    return paramDefaultJSONParser;
  }
  
  public int getFastMatchToken()
  {
    return 14;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt)
    throws IOException
  {
    int i = 0;
    paramInt = 0;
    paramObject2 = paramJSONSerializer.out;
    if ((paramObject1 instanceof AtomicInteger))
    {
      ((SerializeWriter)paramObject2).writeInt(((AtomicInteger)paramObject1).get());
      return;
    }
    if ((paramObject1 instanceof AtomicLong))
    {
      ((SerializeWriter)paramObject2).writeLong(((AtomicLong)paramObject1).get());
      return;
    }
    if ((paramObject1 instanceof AtomicBoolean))
    {
      if (((AtomicBoolean)paramObject1).get()) {}
      for (paramJSONSerializer = "true";; paramJSONSerializer = "false")
      {
        ((SerializeWriter)paramObject2).append(paramJSONSerializer);
        return;
      }
    }
    if (paramObject1 == null)
    {
      ((SerializeWriter)paramObject2).writeNull(SerializerFeature.WriteNullListAsEmpty);
      return;
    }
    if ((paramObject1 instanceof AtomicIntegerArray))
    {
      paramJSONSerializer = (AtomicIntegerArray)paramObject1;
      i = paramJSONSerializer.length();
      ((SerializeWriter)paramObject2).write(91);
      while (paramInt < i)
      {
        j = paramJSONSerializer.get(paramInt);
        if (paramInt != 0) {
          ((SerializeWriter)paramObject2).write(44);
        }
        ((SerializeWriter)paramObject2).writeInt(j);
        paramInt += 1;
      }
      ((SerializeWriter)paramObject2).write(93);
      return;
    }
    paramJSONSerializer = (AtomicLongArray)paramObject1;
    int j = paramJSONSerializer.length();
    ((SerializeWriter)paramObject2).write(91);
    paramInt = i;
    while (paramInt < j)
    {
      long l = paramJSONSerializer.get(paramInt);
      if (paramInt != 0) {
        ((SerializeWriter)paramObject2).write(44);
      }
      ((SerializeWriter)paramObject2).writeLong(l);
      paramInt += 1;
    }
    ((SerializeWriter)paramObject2).write(93);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/AtomicCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */