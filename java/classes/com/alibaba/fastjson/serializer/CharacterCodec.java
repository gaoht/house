package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;

public class CharacterCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final CharacterCodec instance = new CharacterCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    paramDefaultJSONParser = paramDefaultJSONParser.parse();
    if (paramDefaultJSONParser == null) {
      return null;
    }
    return TypeUtils.castToChar(paramDefaultJSONParser);
  }
  
  public int getFastMatchToken()
  {
    return 4;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt)
    throws IOException
  {
    paramJSONSerializer = paramJSONSerializer.out;
    paramObject1 = (Character)paramObject1;
    if (paramObject1 == null)
    {
      paramJSONSerializer.writeString("");
      return;
    }
    if (((Character)paramObject1).charValue() == 0)
    {
      paramJSONSerializer.writeString("\000");
      return;
    }
    paramJSONSerializer.writeString(((Character)paramObject1).toString());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/CharacterCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */