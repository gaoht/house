package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.d;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONScanner;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;

public class SqlDateDeserializer
  extends AbstractDateDeserializer
  implements ObjectDeserializer
{
  public static final SqlDateDeserializer instance = new SqlDateDeserializer();
  public static final SqlDateDeserializer instance_timestamp = new SqlDateDeserializer(true);
  private boolean timestamp = false;
  
  public SqlDateDeserializer() {}
  
  public SqlDateDeserializer(boolean paramBoolean)
  {
    this.timestamp = true;
  }
  
  protected <T> T cast(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2)
  {
    Object localObject = null;
    if (this.timestamp) {
      paramType = castTimestamp(paramDefaultJSONParser, paramType, paramObject1, paramObject2);
    }
    do
    {
      do
      {
        return paramType;
        paramType = (Type)localObject;
      } while (paramObject2 == null);
      if ((paramObject2 instanceof java.util.Date)) {
        return new java.sql.Date(((java.util.Date)paramObject2).getTime());
      }
      if ((paramObject2 instanceof Number)) {
        return new java.sql.Date(((Number)paramObject2).longValue());
      }
      if (!(paramObject2 instanceof String)) {
        break;
      }
      paramObject1 = (String)paramObject2;
      paramType = (Type)localObject;
    } while (((String)paramObject1).length() == 0);
    paramType = new JSONScanner((String)paramObject1);
    try
    {
      long l;
      if (paramType.scanISO8601DateIfMatch()) {
        l = paramType.getCalendar().getTimeInMillis();
      }
      for (;;)
      {
        return new java.sql.Date(l);
        paramDefaultJSONParser = paramDefaultJSONParser.getDateFormat();
        try
        {
          paramDefaultJSONParser = new java.sql.Date(paramDefaultJSONParser.parse((String)paramObject1).getTime());
          return paramDefaultJSONParser;
        }
        catch (ParseException paramDefaultJSONParser)
        {
          l = Long.parseLong((String)paramObject1);
        }
      }
      throw new d("parse error : " + paramObject2);
    }
    finally
    {
      paramType.close();
    }
  }
  
  protected <T> T castTimestamp(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2)
  {
    if (paramObject2 == null) {}
    do
    {
      return null;
      if ((paramObject2 instanceof java.util.Date)) {
        return new Timestamp(((java.util.Date)paramObject2).getTime());
      }
      if ((paramObject2 instanceof Number)) {
        return new Timestamp(((Number)paramObject2).longValue());
      }
      if (!(paramObject2 instanceof String)) {
        break;
      }
      paramObject1 = (String)paramObject2;
    } while (((String)paramObject1).length() == 0);
    paramType = new JSONScanner((String)paramObject1);
    try
    {
      long l;
      if (paramType.scanISO8601DateIfMatch()) {
        l = paramType.getCalendar().getTimeInMillis();
      }
      for (;;)
      {
        return new Timestamp(l);
        paramDefaultJSONParser = paramDefaultJSONParser.getDateFormat();
        try
        {
          paramDefaultJSONParser = new Timestamp(paramDefaultJSONParser.parse((String)paramObject1).getTime());
          return paramDefaultJSONParser;
        }
        catch (ParseException paramDefaultJSONParser)
        {
          l = Long.parseLong((String)paramObject1);
        }
      }
      throw new d("parse error");
    }
    finally
    {
      paramType.close();
    }
  }
  
  public int getFastMatchToken()
  {
    return 2;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/SqlDateDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */