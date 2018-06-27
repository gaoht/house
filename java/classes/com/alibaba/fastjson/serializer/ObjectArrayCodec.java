package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.b;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collection;

public class ObjectArrayCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final ObjectArrayCodec instance = new ObjectArrayCodec();
  
  private <T> T toObjectArray(DefaultJSONParser paramDefaultJSONParser, Class<?> paramClass, b paramb)
  {
    if (paramb == null) {
      return null;
    }
    int m = paramb.size();
    Object localObject3 = Array.newInstance(paramClass, m);
    int i = 0;
    Object localObject2;
    while (i < m)
    {
      localObject2 = paramb.get(i);
      if (localObject2 == paramb)
      {
        Array.set(localObject3, i, localObject3);
        i += 1;
      }
      else
      {
        if (paramClass.isArray())
        {
          if (paramClass.isInstance(localObject2)) {}
          for (localObject1 = localObject2;; localObject1 = toObjectArray(paramDefaultJSONParser, paramClass, (b)localObject2))
          {
            Array.set(localObject3, i, localObject1);
            break;
          }
        }
        if (!(localObject2 instanceof b)) {
          break label236;
        }
        localObject1 = (b)localObject2;
        int n = ((b)localObject1).size();
        int j = 0;
        int k = 0;
        while (j < n)
        {
          if (((b)localObject1).get(j) == paramb)
          {
            ((b)localObject1).set(i, localObject3);
            k = 1;
          }
          j += 1;
        }
        if (k == 0) {
          break label236;
        }
      }
    }
    label236:
    for (Object localObject1 = ((b)localObject1).toArray();; localObject1 = null)
    {
      if (localObject1 == null) {
        localObject1 = TypeUtils.cast(localObject2, paramClass, paramDefaultJSONParser.getConfig());
      }
      for (;;)
      {
        Array.set(localObject3, i, localObject1);
        break;
        paramb.setRelatedArray(localObject3);
        paramb.setComponentType(paramClass);
        return (T)localObject3;
      }
    }
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    int i = 0;
    Object localObject = paramDefaultJSONParser.lexer;
    if (((JSONLexer)localObject).token() == 8)
    {
      ((JSONLexer)localObject).nextToken(16);
      return null;
    }
    if (((JSONLexer)localObject).token() == 4)
    {
      paramDefaultJSONParser = ((JSONLexer)localObject).bytesValue();
      ((JSONLexer)localObject).nextToken(16);
      return paramDefaultJSONParser;
    }
    if ((paramType instanceof GenericArrayType))
    {
      paramType = ((GenericArrayType)paramType).getGenericComponentType();
      if ((paramType instanceof TypeVariable))
      {
        localObject = (TypeVariable)paramType;
        paramType = paramDefaultJSONParser.getContext().type;
        if ((paramType instanceof ParameterizedType))
        {
          ParameterizedType localParameterizedType = (ParameterizedType)paramType;
          paramType = localParameterizedType.getRawType();
          if (!(paramType instanceof Class)) {
            break label269;
          }
          TypeVariable[] arrayOfTypeVariable = ((Class)paramType).getTypeParameters();
          paramType = null;
          while (i < arrayOfTypeVariable.length)
          {
            if (arrayOfTypeVariable[i].getName().equals(((TypeVariable)localObject).getName())) {
              paramType = localParameterizedType.getActualTypeArguments()[i];
            }
            i += 1;
          }
        }
      }
    }
    for (;;)
    {
      if ((paramType instanceof Class)) {
        paramType = (Class)paramType;
      }
      for (;;)
      {
        localObject = new b();
        paramDefaultJSONParser.parseArray(paramType, (Collection)localObject, paramObject);
        return (T)toObjectArray(paramDefaultJSONParser, paramType, (b)localObject);
        paramType = Object.class;
        continue;
        paramType = TypeUtils.getClass(localObject.getBounds()[0]);
        continue;
        paramType = TypeUtils.getClass(paramType);
        continue;
        paramType = ((Class)paramType).getComponentType();
      }
      label269:
      paramType = null;
    }
  }
  
  public int getFastMatchToken()
  {
    return 14;
  }
  
  public final void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt)
    throws IOException
  {
    SerializeWriter localSerializeWriter = paramJSONSerializer.out;
    Object[] arrayOfObject = (Object[])paramObject1;
    if (paramObject1 == null)
    {
      localSerializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
      return;
    }
    int i = arrayOfObject.length;
    int j = i - 1;
    if (j == -1)
    {
      localSerializeWriter.append("[]");
      return;
    }
    SerialContext localSerialContext = paramJSONSerializer.context;
    paramJSONSerializer.setContext(localSerialContext, paramObject1, paramObject2, 0);
    paramObject1 = null;
    for (;;)
    {
      Object localObject;
      try
      {
        localSerializeWriter.append('[');
        if (localSerializeWriter.isEnabled(SerializerFeature.PrettyFormat))
        {
          paramJSONSerializer.incrementIndent();
          paramJSONSerializer.println();
          paramInt = 0;
          if (paramInt < i)
          {
            if (paramInt != 0)
            {
              localSerializeWriter.write(44);
              paramJSONSerializer.println();
            }
            paramJSONSerializer.write(arrayOfObject[paramInt]);
            paramInt += 1;
            continue;
          }
          paramJSONSerializer.decrementIdent();
          paramJSONSerializer.println();
          localSerializeWriter.write(93);
          return;
        }
        paramInt = 0;
        paramObject2 = null;
        if (paramInt >= j) {
          break label287;
        }
        localObject = arrayOfObject[paramInt];
        if (localObject == null)
        {
          localSerializeWriter.append("null,");
        }
        else if (paramJSONSerializer.containsReference(localObject))
        {
          paramJSONSerializer.writeReference(localObject);
          localSerializeWriter.append(',');
        }
      }
      finally
      {
        paramJSONSerializer.context = localSerialContext;
      }
      paramType = localObject.getClass();
      if (paramType == paramObject1)
      {
        ((ObjectSerializer)paramObject2).write(paramJSONSerializer, localObject, null, null, 0);
      }
      else
      {
        paramObject2 = paramJSONSerializer.getObjectWriter(paramType);
        ((ObjectSerializer)paramObject2).write(paramJSONSerializer, localObject, null, null, 0);
        paramObject1 = paramType;
        continue;
        label287:
        paramObject1 = arrayOfObject[j];
        if (paramObject1 == null)
        {
          localSerializeWriter.append("null]");
          paramJSONSerializer.context = localSerialContext;
          return;
        }
        if (paramJSONSerializer.containsReference(paramObject1)) {
          paramJSONSerializer.writeReference(paramObject1);
        }
        for (;;)
        {
          localSerializeWriter.append(']');
          break;
          paramJSONSerializer.writeWithFieldName(paramObject1, Integer.valueOf(j));
        }
        paramInt += 1;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/ObjectArrayCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */