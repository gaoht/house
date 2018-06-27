package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.e;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapSerializer
  extends SerializeFilterable
  implements ObjectSerializer
{
  public static MapSerializer instance = new MapSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt)
    throws IOException
  {
    SerializeWriter localSerializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null)
    {
      localSerializeWriter.writeNull();
      return;
    }
    Map localMap = (Map)paramObject1;
    if (paramJSONSerializer.containsReference(paramObject1))
    {
      paramJSONSerializer.writeReference(paramObject1);
      return;
    }
    SerialContext localSerialContext = paramJSONSerializer.context;
    paramJSONSerializer.setContext(localSerialContext, paramObject1, paramObject2, 0);
    for (;;)
    {
      Object localObject2;
      int i;
      try
      {
        localSerializeWriter.write(123);
        paramJSONSerializer.incrementIndent();
        paramType = null;
        localObject1 = null;
        int j = 1;
        paramInt = j;
        if (localSerializeWriter.isEnabled(SerializerFeature.WriteClassName))
        {
          paramObject2 = paramJSONSerializer.config.typeKey;
          localObject2 = localMap.getClass();
          if (((localObject2 != e.class) && (localObject2 != HashMap.class) && (localObject2 != LinkedHashMap.class)) || (!localMap.containsKey(paramObject2))) {
            break label1192;
          }
          i = 1;
          paramInt = j;
          if (i == 0)
          {
            localSerializeWriter.writeFieldName((String)paramObject2);
            localSerializeWriter.writeString(paramObject1.getClass().getName());
            paramInt = 0;
          }
        }
        Iterator localIterator = localMap.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break label1137;
        }
        paramObject2 = (Map.Entry)localIterator.next();
        localObject3 = ((Map.Entry)paramObject2).getValue();
        paramObject2 = ((Map.Entry)paramObject2).getKey();
        localObject2 = paramJSONSerializer.propertyPreFilters;
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          if ((paramObject2 == null) || ((paramObject2 instanceof String))) {
            if (!applyName(paramJSONSerializer, paramObject1, (String)paramObject2)) {
              continue;
            }
          }
        }
        else
        {
          localObject2 = this.propertyPreFilters;
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            if ((paramObject2 != null) && (!(paramObject2 instanceof String))) {
              continue;
            }
            if (!applyName(paramJSONSerializer, paramObject1, (String)paramObject2)) {
              continue;
            }
          }
          localObject2 = paramJSONSerializer.propertyFilters;
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            if ((paramObject2 != null) && (!(paramObject2 instanceof String))) {
              continue;
            }
            if (!apply(paramJSONSerializer, paramObject1, (String)paramObject2, localObject3)) {
              continue;
            }
          }
          localObject2 = this.propertyFilters;
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            if ((paramObject2 != null) && (!(paramObject2 instanceof String))) {
              continue;
            }
            if (!apply(paramJSONSerializer, paramObject1, (String)paramObject2, localObject3)) {
              continue;
            }
          }
          localObject2 = paramJSONSerializer.nameFilters;
          if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
            break label1189;
          }
          if ((paramObject2 != null) && (!(paramObject2 instanceof String))) {
            continue;
          }
          paramObject2 = processKey(paramJSONSerializer, paramObject1, (String)paramObject2, localObject3);
          localObject2 = this.nameFilters;
          if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
            break label1183;
          }
          if ((paramObject2 != null) && (!(paramObject2 instanceof String))) {
            continue;
          }
          localObject2 = processKey(paramJSONSerializer, paramObject1, (String)paramObject2, localObject3);
          paramObject2 = paramJSONSerializer.valueFilters;
          List localList = this.contextValueFilters;
          if ((paramObject2 == null) || (((List)paramObject2).size() <= 0))
          {
            paramObject2 = localObject3;
            if (localList != null)
            {
              paramObject2 = localObject3;
              if (localList.size() <= 0) {}
            }
          }
          else
          {
            if ((localObject2 != null) && (!(localObject2 instanceof String))) {
              continue;
            }
            paramObject2 = processValue(paramJSONSerializer, null, paramObject1, (String)localObject2, localObject3);
          }
          localObject3 = this.valueFilters;
          localList = this.contextValueFilters;
          if (((localObject3 == null) || (((List)localObject3).size() <= 0)) && ((localList == null) || (localList.size() <= 0))) {
            break label1180;
          }
          if ((localObject2 != null) && (!(localObject2 instanceof String))) {
            continue;
          }
          paramObject2 = processValue(paramJSONSerializer, null, paramObject1, (String)localObject2, paramObject2);
          if ((paramObject2 == null) && (!localSerializeWriter.isEnabled(SerializerFeature.WRITE_MAP_NULL_FEATURES))) {
            continue;
          }
          if (!(localObject2 instanceof String)) {
            continue;
          }
          localObject3 = (String)localObject2;
          if (paramInt == 0) {
            localSerializeWriter.write(44);
          }
          if (localSerializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
            paramJSONSerializer.println();
          }
          localSerializeWriter.writeFieldName((String)localObject3, true);
          if (paramObject2 != null) {
            break label1074;
          }
          localSerializeWriter.writeNull();
          paramInt = 0;
          continue;
        }
        if (((!paramObject2.getClass().isPrimitive()) && (!(paramObject2 instanceof Number))) || (applyName(paramJSONSerializer, paramObject1, a.toJSONString(paramObject2)))) {
          continue;
        }
        continue;
        if (((!paramObject2.getClass().isPrimitive()) && (!(paramObject2 instanceof Number))) || (applyName(paramJSONSerializer, paramObject1, a.toJSONString(paramObject2)))) {
          continue;
        }
        continue;
        if (((!paramObject2.getClass().isPrimitive()) && (!(paramObject2 instanceof Number))) || (apply(paramJSONSerializer, paramObject1, a.toJSONString(paramObject2), localObject3))) {
          continue;
        }
        continue;
        if (((!paramObject2.getClass().isPrimitive()) && (!(paramObject2 instanceof Number))) || (apply(paramJSONSerializer, paramObject1, a.toJSONString(paramObject2), localObject3))) {
          continue;
        }
        continue;
        if ((!paramObject2.getClass().isPrimitive()) && (!(paramObject2 instanceof Number))) {
          break label1189;
        }
        paramObject2 = processKey(paramJSONSerializer, paramObject1, a.toJSONString(paramObject2), localObject3);
        continue;
        if ((!paramObject2.getClass().isPrimitive()) && (!(paramObject2 instanceof Number))) {
          break label1183;
        }
        localObject2 = processKey(paramJSONSerializer, paramObject1, a.toJSONString(paramObject2), localObject3);
        continue;
        if (!localObject2.getClass().isPrimitive())
        {
          paramObject2 = localObject3;
          if (!(localObject2 instanceof Number)) {
            continue;
          }
        }
        paramObject2 = processValue(paramJSONSerializer, null, paramObject1, a.toJSONString(localObject2), localObject3);
        continue;
        if ((!localObject2.getClass().isPrimitive()) && (!(localObject2 instanceof Number))) {
          break label1180;
        }
        paramObject2 = processValue(paramJSONSerializer, null, paramObject1, a.toJSONString(localObject2), paramObject2);
        continue;
        continue;
        if (paramInt == 0) {
          localSerializeWriter.write(44);
        }
        if ((localSerializeWriter.isEnabled(SerializerFeature.BrowserCompatible)) || (localSerializeWriter.isEnabled(SerializerFeature.WriteNonStringKeyAsString)) || (localSerializeWriter.isEnabled(SerializerFeature.BrowserSecure)))
        {
          paramJSONSerializer.write(a.toJSONString(localObject2));
          localSerializeWriter.write(58);
          continue;
        }
        paramJSONSerializer.write(localObject2);
      }
      finally
      {
        paramJSONSerializer.context = localSerialContext;
      }
      continue;
      label1074:
      Object localObject3 = paramObject2.getClass();
      if (localObject3 == paramType)
      {
        ((ObjectSerializer)localObject1).write(paramJSONSerializer, paramObject2, localObject2, null, 0);
        paramObject2 = localObject1;
      }
      else
      {
        localObject1 = paramJSONSerializer.getObjectWriter((Class)localObject3);
        ((ObjectSerializer)localObject1).write(paramJSONSerializer, paramObject2, localObject2, null, 0);
        paramType = (Type)localObject3;
        paramObject2 = localObject1;
        break label1198;
        label1137:
        paramJSONSerializer.context = localSerialContext;
        paramJSONSerializer.decrementIdent();
        if ((localSerializeWriter.isEnabled(SerializerFeature.PrettyFormat)) && (localMap.size() > 0)) {
          paramJSONSerializer.println();
        }
        localSerializeWriter.write(125);
        return;
        label1180:
        continue;
        label1183:
        localObject2 = paramObject2;
        continue;
        label1189:
        continue;
        label1192:
        i = 0;
        continue;
      }
      label1198:
      paramInt = 0;
      Object localObject1 = paramObject2;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/MapSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */