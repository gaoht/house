package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.e;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;

public class JSONLibDataFormatSerializer
  implements ObjectSerializer
{
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt)
    throws IOException
  {
    if (paramObject1 == null)
    {
      paramJSONSerializer.out.writeNull();
      return;
    }
    paramObject1 = (Date)paramObject1;
    paramObject2 = new e();
    ((e)paramObject2).put("date", Integer.valueOf(((Date)paramObject1).getDate()));
    ((e)paramObject2).put("day", Integer.valueOf(((Date)paramObject1).getDay()));
    ((e)paramObject2).put("hours", Integer.valueOf(((Date)paramObject1).getHours()));
    ((e)paramObject2).put("minutes", Integer.valueOf(((Date)paramObject1).getMinutes()));
    ((e)paramObject2).put("month", Integer.valueOf(((Date)paramObject1).getMonth()));
    ((e)paramObject2).put("seconds", Integer.valueOf(((Date)paramObject1).getSeconds()));
    ((e)paramObject2).put("time", Long.valueOf(((Date)paramObject1).getTime()));
    ((e)paramObject2).put("timezoneOffset", Integer.valueOf(((Date)paramObject1).getTimezoneOffset()));
    ((e)paramObject2).put("year", Integer.valueOf(((Date)paramObject1).getYear()));
    paramJSONSerializer.write(paramObject2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/JSONLibDataFormatSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */