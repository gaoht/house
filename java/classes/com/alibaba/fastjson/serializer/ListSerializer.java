package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

public final class ListSerializer
  implements ObjectSerializer
{
  public static final ListSerializer instance = new ListSerializer();
  
  public final void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt)
    throws IOException
  {
    boolean bool = paramJSONSerializer.out.isEnabled(SerializerFeature.WriteClassName);
    SerializeWriter localSerializeWriter = paramJSONSerializer.out;
    Type localType = null;
    if (bool) {
      localType = TypeUtils.getCollectionItemType(paramType);
    }
    if (paramObject1 == null)
    {
      localSerializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
      return;
    }
    Object localObject1 = (List)paramObject1;
    if (((List)localObject1).size() == 0)
    {
      localSerializeWriter.append("[]");
      return;
    }
    paramType = paramJSONSerializer.context;
    paramJSONSerializer.setContext(paramType, paramObject1, paramObject2, 0);
    Object localObject2;
    Object localObject3;
    try
    {
      if (!localSerializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
        break label271;
      }
      localSerializeWriter.append('[');
      paramJSONSerializer.incrementIndent();
      localObject1 = ((List)localObject1).iterator();
      paramInt = 0;
      if (!((Iterator)localObject1).hasNext()) {
        break label248;
      }
      localObject2 = ((Iterator)localObject1).next();
      if (paramInt != 0) {
        localSerializeWriter.append(',');
      }
      paramJSONSerializer.println();
      if (localObject2 != null) {
        if (paramJSONSerializer.containsReference(localObject2))
        {
          paramJSONSerializer.writeReference(localObject2);
        }
        else
        {
          localObject3 = paramJSONSerializer.getObjectWriter(localObject2.getClass());
          paramJSONSerializer.context = new SerialContext(paramType, paramObject1, paramObject2, 0, 0);
          ((ObjectSerializer)localObject3).write(paramJSONSerializer, localObject2, Integer.valueOf(paramInt), localType, 0);
        }
      }
    }
    finally
    {
      paramJSONSerializer.context = paramType;
    }
    paramJSONSerializer.out.writeNull();
    break label503;
    label248:
    paramJSONSerializer.decrementIdent();
    paramJSONSerializer.println();
    localSerializeWriter.append(']');
    paramJSONSerializer.context = paramType;
    return;
    label271:
    localSerializeWriter.append('[');
    int i = ((List)localObject1).size();
    paramInt = 0;
    for (;;)
    {
      if (paramInt < i)
      {
        localObject2 = ((List)localObject1).get(paramInt);
        if (paramInt != 0) {
          localSerializeWriter.append(',');
        }
        if (localObject2 == null)
        {
          localSerializeWriter.append("null");
        }
        else
        {
          localObject3 = localObject2.getClass();
          if (localObject3 == Integer.class)
          {
            localSerializeWriter.writeInt(((Integer)localObject2).intValue());
          }
          else if (localObject3 == Long.class)
          {
            long l = ((Long)localObject2).longValue();
            if (bool)
            {
              localSerializeWriter.writeLong(l);
              localSerializeWriter.write(76);
            }
            else
            {
              localSerializeWriter.writeLong(l);
            }
          }
          else
          {
            if (!localSerializeWriter.disableCircularReferenceDetect) {
              paramJSONSerializer.context = new SerialContext(paramType, paramObject1, paramObject2, 0, 0);
            }
            if (paramJSONSerializer.containsReference(localObject2)) {
              paramJSONSerializer.writeReference(localObject2);
            } else {
              paramJSONSerializer.getObjectWriter(localObject2.getClass()).write(paramJSONSerializer, localObject2, Integer.valueOf(paramInt), localType, 0);
            }
          }
        }
      }
      else
      {
        localSerializeWriter.append(']');
        paramJSONSerializer.context = paramType;
        return;
        label503:
        paramInt += 1;
        break;
      }
      paramInt += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/ListSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */