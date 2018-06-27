package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.d;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.deserializer.AbstractDateDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateCodec
  extends AbstractDateDeserializer
  implements ObjectDeserializer, ObjectSerializer
{
  public static final DateCodec instance = new DateCodec();
  
  protected <T> T cast(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2)
  {
    if (paramObject2 == null) {
      paramObject1 = null;
    }
    do
    {
      return (T)paramObject1;
      paramObject1 = paramObject2;
    } while ((paramObject2 instanceof Date));
    if ((paramObject2 instanceof Number)) {
      return new Date(((Number)paramObject2).longValue());
    }
    if ((paramObject2 instanceof String))
    {
      paramObject1 = (String)paramObject2;
      if (((String)paramObject1).length() == 0) {
        return null;
      }
      paramObject2 = new JSONScanner((String)paramObject1);
      try
      {
        if (((JSONScanner)paramObject2).scanISO8601DateIfMatch(false))
        {
          paramDefaultJSONParser = ((JSONScanner)paramObject2).getCalendar();
          if (paramType == Calendar.class)
          {
            ((JSONScanner)paramObject2).close();
            return paramDefaultJSONParser;
          }
          paramDefaultJSONParser = paramDefaultJSONParser.getTime();
          ((JSONScanner)paramObject2).close();
          return paramDefaultJSONParser;
        }
        ((JSONScanner)paramObject2).close();
        if (((String)paramObject1).length() == paramDefaultJSONParser.getDateFomartPattern().length()) {
          paramDefaultJSONParser = paramDefaultJSONParser.getDateFormat();
        }
        paramDefaultJSONParser = (DefaultJSONParser)paramObject1;
      }
      finally
      {
        try
        {
          paramDefaultJSONParser = paramDefaultJSONParser.parse((String)paramObject1);
          return paramDefaultJSONParser;
        }
        catch (ParseException paramDefaultJSONParser) {}
        paramDefaultJSONParser = finally;
        ((JSONScanner)paramObject2).close();
      }
      if (((String)paramObject1).startsWith("/Date("))
      {
        paramDefaultJSONParser = (DefaultJSONParser)paramObject1;
        if (((String)paramObject1).endsWith(")/")) {
          paramDefaultJSONParser = ((String)paramObject1).substring(6, ((String)paramObject1).length() - 2);
        }
      }
      return new Date(Long.parseLong(paramDefaultJSONParser));
    }
    throw new d("parse error");
  }
  
  public int getFastMatchToken()
  {
    return 2;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt)
    throws IOException
  {
    SerializeWriter localSerializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null)
    {
      localSerializeWriter.writeNull();
      return;
    }
    if ((paramObject1 instanceof Date)) {}
    for (paramObject2 = (Date)paramObject1; localSerializeWriter.isEnabled(SerializerFeature.WriteDateUseDateFormat); paramObject2 = TypeUtils.castToDate(paramObject1))
    {
      paramType = paramJSONSerializer.getDateFormat();
      paramObject1 = paramType;
      if (paramType == null)
      {
        paramObject1 = new SimpleDateFormat(a.e, paramJSONSerializer.locale);
        ((DateFormat)paramObject1).setTimeZone(paramJSONSerializer.timeZone);
      }
      localSerializeWriter.writeString(((DateFormat)paramObject1).format((Date)paramObject2));
      return;
    }
    if ((localSerializeWriter.isEnabled(SerializerFeature.WriteClassName)) && (paramObject1.getClass() != paramType))
    {
      if (paramObject1.getClass() == Date.class)
      {
        localSerializeWriter.write("new Date(");
        localSerializeWriter.writeLong(((Date)paramObject1).getTime());
        localSerializeWriter.write(41);
        return;
      }
      localSerializeWriter.write(123);
      localSerializeWriter.writeFieldName(a.c);
      paramJSONSerializer.write(paramObject1.getClass().getName());
      localSerializeWriter.writeFieldValue(',', "val", ((Date)paramObject1).getTime());
      localSerializeWriter.write(125);
      return;
    }
    long l = ((Date)paramObject2).getTime();
    if (localSerializeWriter.isEnabled(SerializerFeature.UseISO8601DateFormat))
    {
      int i;
      int j;
      int k;
      int m;
      int n;
      int i1;
      if (localSerializeWriter.isEnabled(SerializerFeature.UseSingleQuotes))
      {
        paramInt = 39;
        localSerializeWriter.write(paramInt);
        paramObject1 = Calendar.getInstance(paramJSONSerializer.timeZone, paramJSONSerializer.locale);
        ((Calendar)paramObject1).setTimeInMillis(l);
        i = ((Calendar)paramObject1).get(1);
        j = ((Calendar)paramObject1).get(2) + 1;
        k = ((Calendar)paramObject1).get(5);
        m = ((Calendar)paramObject1).get(11);
        n = ((Calendar)paramObject1).get(12);
        i1 = ((Calendar)paramObject1).get(13);
        int i2 = ((Calendar)paramObject1).get(14);
        if (i2 == 0) {
          break label424;
        }
        paramJSONSerializer = "0000-00-00T00:00:00.000".toCharArray();
        IOUtils.getChars(i2, 23, paramJSONSerializer);
        IOUtils.getChars(i1, 19, paramJSONSerializer);
        IOUtils.getChars(n, 16, paramJSONSerializer);
        IOUtils.getChars(m, 13, paramJSONSerializer);
        IOUtils.getChars(k, 10, paramJSONSerializer);
        IOUtils.getChars(j, 7, paramJSONSerializer);
        IOUtils.getChars(i, 4, paramJSONSerializer);
      }
      for (;;)
      {
        localSerializeWriter.write(paramJSONSerializer);
        i = ((Calendar)paramObject1).getTimeZone().getRawOffset() / 3600000;
        if (i != 0) {
          break label527;
        }
        localSerializeWriter.write(90);
        localSerializeWriter.write(paramInt);
        return;
        paramInt = 34;
        break;
        label424:
        if ((i1 == 0) && (n == 0) && (m == 0))
        {
          paramJSONSerializer = "0000-00-00".toCharArray();
          IOUtils.getChars(k, 10, paramJSONSerializer);
          IOUtils.getChars(j, 7, paramJSONSerializer);
          IOUtils.getChars(i, 4, paramJSONSerializer);
        }
        else
        {
          paramJSONSerializer = "0000-00-00T00:00:00".toCharArray();
          IOUtils.getChars(i1, 19, paramJSONSerializer);
          IOUtils.getChars(n, 16, paramJSONSerializer);
          IOUtils.getChars(m, 13, paramJSONSerializer);
          IOUtils.getChars(k, 10, paramJSONSerializer);
          IOUtils.getChars(j, 7, paramJSONSerializer);
          IOUtils.getChars(i, 4, paramJSONSerializer);
        }
      }
      label527:
      if (i > 0) {
        localSerializeWriter.append('+').append(String.format("%02d", new Object[] { Integer.valueOf(i) }));
      }
      for (;;)
      {
        localSerializeWriter.append(":00");
        break;
        localSerializeWriter.append('-').append(String.format("%02d", new Object[] { Integer.valueOf(-i) }));
      }
    }
    localSerializeWriter.writeLong(l);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/DateCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */