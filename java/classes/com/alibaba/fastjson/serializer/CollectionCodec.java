package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.b;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class CollectionCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final CollectionCodec instance = new CollectionCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    if (paramDefaultJSONParser.lexer.token() == 8)
    {
      paramDefaultJSONParser.lexer.nextToken(16);
      return null;
    }
    if (paramType == b.class)
    {
      paramType = new b();
      paramDefaultJSONParser.parseArray(paramType);
      return paramType;
    }
    Collection localCollection = TypeUtils.createCollection(paramType);
    paramDefaultJSONParser.parseArray(TypeUtils.getCollectionItemType(paramType), localCollection, paramObject);
    return localCollection;
  }
  
  public int getFastMatchToken()
  {
    return 14;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt)
    throws IOException
  {
    SerializeWriter localSerializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null)
    {
      localSerializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
      return;
    }
    Type localType = null;
    if (localSerializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
      localType = TypeUtils.getCollectionItemType(paramType);
    }
    Object localObject = (Collection)paramObject1;
    paramType = paramJSONSerializer.context;
    paramJSONSerializer.setContext(paramType, paramObject1, paramObject2, 0);
    if (localSerializeWriter.isEnabled(SerializerFeature.WriteClassName))
    {
      if (HashSet.class != localObject.getClass()) {
        break label160;
      }
      localSerializeWriter.append("Set");
    }
    for (;;)
    {
      int i;
      try
      {
        localSerializeWriter.append('[');
        paramObject1 = ((Collection)localObject).iterator();
        paramInt = 0;
        if (((Iterator)paramObject1).hasNext())
        {
          paramObject2 = ((Iterator)paramObject1).next();
          i = paramInt + 1;
          if (paramInt != 0) {
            localSerializeWriter.append(',');
          }
          if (paramObject2 == null)
          {
            localSerializeWriter.writeNull();
            paramInt = i;
            continue;
            label160:
            if (TreeSet.class != localObject.getClass()) {
              continue;
            }
            localSerializeWriter.append("TreeSet");
            continue;
          }
          localObject = paramObject2.getClass();
          if (localObject == Integer.class)
          {
            localSerializeWriter.writeInt(((Integer)paramObject2).intValue());
            paramInt = i;
            continue;
          }
          if (localObject == Long.class)
          {
            localSerializeWriter.writeLong(((Long)paramObject2).longValue());
            if (localSerializeWriter.isEnabled(SerializerFeature.WriteClassName))
            {
              localSerializeWriter.write(76);
              paramInt = i;
            }
          }
          else
          {
            paramJSONSerializer.getObjectWriter((Class)localObject).write(paramJSONSerializer, paramObject2, Integer.valueOf(i - 1), localType, 0);
            paramInt = i;
            continue;
          }
        }
        else
        {
          localSerializeWriter.append(']');
          return;
        }
      }
      finally
      {
        paramJSONSerializer.context = paramType;
      }
      paramInt = i;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/CollectionCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */