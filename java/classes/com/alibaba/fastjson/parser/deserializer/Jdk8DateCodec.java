package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.ContextObjectSerializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

public class Jdk8DateCodec
  extends ContextObjectDeserializer
  implements ObjectDeserializer, ContextObjectSerializer, ObjectSerializer
{
  private static final DateTimeFormatter ISO_FIXED_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());
  private static final DateTimeFormatter defaultFormatter;
  private static final String defaultPatttern = "yyyy-MM-dd HH:mm:ss";
  private static final DateTimeFormatter formatter_d10_cn;
  private static final DateTimeFormatter formatter_d10_de;
  private static final DateTimeFormatter formatter_d10_eur;
  private static final DateTimeFormatter formatter_d10_in;
  private static final DateTimeFormatter formatter_d10_kr;
  private static final DateTimeFormatter formatter_d10_tw;
  private static final DateTimeFormatter formatter_d10_us;
  private static final DateTimeFormatter formatter_d8;
  private static final DateTimeFormatter formatter_dt19_cn;
  private static final DateTimeFormatter formatter_dt19_cn_1;
  private static final DateTimeFormatter formatter_dt19_de;
  private static final DateTimeFormatter formatter_dt19_eur;
  private static final DateTimeFormatter formatter_dt19_in;
  private static final DateTimeFormatter formatter_dt19_kr;
  private static final DateTimeFormatter formatter_dt19_tw;
  private static final DateTimeFormatter formatter_dt19_us;
  private static final DateTimeFormatter formatter_iso8601 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
  private static final String formatter_iso8601_pattern = "yyyy-MM-dd'T'HH:mm:ss";
  public static final Jdk8DateCodec instance = new Jdk8DateCodec();
  
  static
  {
    defaultFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    formatter_dt19_tw = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    formatter_dt19_cn = DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm:ss");
    formatter_dt19_cn_1 = DateTimeFormatter.ofPattern("yyyy年M月d日 H时m分s秒");
    formatter_dt19_kr = DateTimeFormatter.ofPattern("yyyy년M월d일 HH:mm:ss");
    formatter_dt19_us = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
    formatter_dt19_eur = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    formatter_dt19_de = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    formatter_dt19_in = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    formatter_d8 = DateTimeFormatter.ofPattern("yyyyMMdd");
    formatter_d10_tw = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    formatter_d10_cn = DateTimeFormatter.ofPattern("yyyy年M月d日");
    formatter_d10_kr = DateTimeFormatter.ofPattern("yyyy년M월d일");
    formatter_d10_us = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    formatter_d10_eur = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    formatter_d10_de = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    formatter_d10_in = DateTimeFormatter.ofPattern("dd-MM-yyyy");
  }
  
  private void write(SerializeWriter paramSerializeWriter, TemporalAccessor paramTemporalAccessor, String paramString)
  {
    if (paramString == "yyyy-MM-dd'T'HH:mm:ss") {}
    for (paramString = formatter_iso8601;; paramString = DateTimeFormatter.ofPattern(paramString))
    {
      paramSerializeWriter.writeString(paramString.format(paramTemporalAccessor));
      return;
    }
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject, String paramString, int paramInt)
  {
    paramDefaultJSONParser = paramDefaultJSONParser.lexer;
    if (paramDefaultJSONParser.token() == 4)
    {
      paramObject = paramDefaultJSONParser.stringVal();
      paramDefaultJSONParser.nextToken();
      if (paramString == null) {
        break label296;
      }
      if ("yyyy-MM-dd HH:mm:ss".equals(paramString)) {
        paramDefaultJSONParser = defaultFormatter;
      }
    }
    for (;;)
    {
      if (paramType == LocalDateTime.class)
      {
        if ((((String)paramObject).length() == 10) || (((String)paramObject).length() == 8))
        {
          return LocalDateTime.of(parseLocalDate((String)paramObject, paramString, paramDefaultJSONParser), LocalTime.MIN);
          paramDefaultJSONParser = DateTimeFormatter.ofPattern(paramString);
        }
        else
        {
          return parseDateTime((String)paramObject, paramDefaultJSONParser);
        }
      }
      else
      {
        if (paramType == LocalDate.class)
        {
          if (((String)paramObject).length() == 23)
          {
            paramDefaultJSONParser = LocalDateTime.parse((CharSequence)paramObject);
            return LocalDate.of(paramDefaultJSONParser.getYear(), paramDefaultJSONParser.getMonthValue(), paramDefaultJSONParser.getDayOfMonth());
          }
          return parseLocalDate((String)paramObject, paramString, paramDefaultJSONParser);
        }
        if (paramType == LocalTime.class)
        {
          if (((String)paramObject).length() == 23)
          {
            paramDefaultJSONParser = LocalDateTime.parse((CharSequence)paramObject);
            return LocalTime.of(paramDefaultJSONParser.getHour(), paramDefaultJSONParser.getMinute(), paramDefaultJSONParser.getSecond(), paramDefaultJSONParser.getNano());
          }
          return LocalTime.parse((CharSequence)paramObject);
        }
        if (paramType == ZonedDateTime.class)
        {
          paramType = paramDefaultJSONParser;
          if (paramDefaultJSONParser == defaultFormatter) {
            paramType = ISO_FIXED_FORMAT;
          }
          return parseZonedDateTime((String)paramObject, paramType);
        }
        if (paramType == OffsetDateTime.class) {
          return OffsetDateTime.parse((CharSequence)paramObject);
        }
        if (paramType == OffsetTime.class) {
          return OffsetTime.parse((CharSequence)paramObject);
        }
        if (paramType == ZoneId.class) {
          return ZoneId.of((String)paramObject);
        }
        if (paramType == Period.class) {
          return Period.parse((CharSequence)paramObject);
        }
        if (paramType == Duration.class) {
          return Duration.parse((CharSequence)paramObject);
        }
        if (paramType == Instant.class)
        {
          return Instant.parse((CharSequence)paramObject);
          throw new UnsupportedOperationException();
        }
        return null;
        label296:
        paramDefaultJSONParser = null;
      }
    }
  }
  
  public int getFastMatchToken()
  {
    return 4;
  }
  
  protected LocalDateTime parseDateTime(String paramString, DateTimeFormatter paramDateTimeFormatter)
  {
    Object localObject = paramDateTimeFormatter;
    DateTimeFormatter localDateTimeFormatter;
    int i;
    int j;
    int k;
    int m;
    int n;
    if (paramDateTimeFormatter == null)
    {
      localDateTimeFormatter = paramDateTimeFormatter;
      if (paramString.length() == 19)
      {
        i = paramString.charAt(4);
        j = paramString.charAt(7);
        k = paramString.charAt(10);
        m = paramString.charAt(13);
        n = paramString.charAt(16);
        localDateTimeFormatter = paramDateTimeFormatter;
        if (m == 58)
        {
          localDateTimeFormatter = paramDateTimeFormatter;
          if (n == 58)
          {
            if ((i != 45) || (j != 45)) {
              break label177;
            }
            if (k != 84) {
              break label159;
            }
            localDateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
          }
        }
      }
      localObject = localDateTimeFormatter;
      if (paramString.length() >= 17)
      {
        i = paramString.charAt(4);
        if (i != 24180) {
          break label439;
        }
        if (paramString.charAt(paramString.length() - 1) != '秒') {
          break label431;
        }
        localObject = formatter_dt19_cn_1;
      }
    }
    for (;;)
    {
      if (localObject != null) {
        break label458;
      }
      return LocalDateTime.parse(paramString);
      label159:
      localDateTimeFormatter = paramDateTimeFormatter;
      if (k != 32) {
        break;
      }
      localDateTimeFormatter = defaultFormatter;
      break;
      label177:
      if ((i == 45) && (j == 45))
      {
        localDateTimeFormatter = defaultFormatter;
        break;
      }
      if ((i == 47) && (j == 47))
      {
        localDateTimeFormatter = formatter_dt19_tw;
        break;
      }
      j = paramString.charAt(0);
      k = paramString.charAt(1);
      m = paramString.charAt(2);
      n = paramString.charAt(3);
      int i1 = paramString.charAt(5);
      if ((m == 47) && (i1 == 47))
      {
        if ((j - 48) * 10 + (k - 48) > 12)
        {
          localDateTimeFormatter = formatter_dt19_eur;
          break;
        }
        if (i - 48 + (n - 48) * 10 > 12)
        {
          localDateTimeFormatter = formatter_dt19_us;
          break;
        }
        localObject = Locale.getDefault().getCountry();
        if (((String)localObject).equals("US"))
        {
          localDateTimeFormatter = formatter_dt19_us;
          break;
        }
        if (!((String)localObject).equals("BR"))
        {
          localDateTimeFormatter = paramDateTimeFormatter;
          if (!((String)localObject).equals("AU")) {
            break;
          }
        }
        localDateTimeFormatter = formatter_dt19_eur;
        break;
      }
      if ((m == 46) && (i1 == 46))
      {
        localDateTimeFormatter = formatter_dt19_de;
        break;
      }
      localDateTimeFormatter = paramDateTimeFormatter;
      if (m != 45) {
        break;
      }
      localDateTimeFormatter = paramDateTimeFormatter;
      if (i1 != 45) {
        break;
      }
      localDateTimeFormatter = formatter_dt19_in;
      break;
      label431:
      localObject = formatter_dt19_cn;
      continue;
      label439:
      localObject = localDateTimeFormatter;
      if (i == 45380) {
        localObject = formatter_dt19_kr;
      }
    }
    label458:
    return LocalDateTime.parse(paramString, (DateTimeFormatter)localObject);
  }
  
  protected LocalDate parseLocalDate(String paramString1, String paramString2, DateTimeFormatter paramDateTimeFormatter)
  {
    Object localObject = paramDateTimeFormatter;
    int i;
    int m;
    int n;
    int i1;
    if (paramDateTimeFormatter == null)
    {
      if (paramString1.length() == 8) {
        paramDateTimeFormatter = formatter_d8;
      }
      paramString2 = paramDateTimeFormatter;
      if (paramString1.length() == 10)
      {
        i = paramString1.charAt(4);
        int j = paramString1.charAt(7);
        localObject = paramDateTimeFormatter;
        if (i == 47)
        {
          localObject = paramDateTimeFormatter;
          if (j == 47) {
            localObject = formatter_d10_tw;
          }
        }
        j = paramString1.charAt(0);
        int k = paramString1.charAt(1);
        m = paramString1.charAt(2);
        n = paramString1.charAt(3);
        i1 = paramString1.charAt(5);
        if ((m != 47) || (i1 != 47)) {
          break label265;
        }
        if ((j - 48) * 10 + (k - 48) <= 12) {
          break label185;
        }
        paramString2 = formatter_d10_eur;
      }
      localObject = paramString2;
      if (paramString1.length() >= 9)
      {
        i = paramString1.charAt(4);
        if (i != 24180) {
          break label313;
        }
        localObject = formatter_d10_cn;
      }
    }
    for (;;)
    {
      if (localObject != null) {
        break label332;
      }
      return LocalDate.parse(paramString1);
      label185:
      if (i - 48 + (n - 48) * 10 > 12)
      {
        paramString2 = formatter_d10_us;
        break;
      }
      paramDateTimeFormatter = Locale.getDefault().getCountry();
      if (paramDateTimeFormatter.equals("US"))
      {
        paramString2 = formatter_d10_us;
        break;
      }
      if (!paramDateTimeFormatter.equals("BR"))
      {
        paramString2 = (String)localObject;
        if (!paramDateTimeFormatter.equals("AU")) {
          break;
        }
      }
      paramString2 = formatter_d10_eur;
      break;
      label265:
      if ((m == 46) && (i1 == 46))
      {
        paramString2 = formatter_d10_de;
        break;
      }
      paramString2 = (String)localObject;
      if (m != 45) {
        break;
      }
      paramString2 = (String)localObject;
      if (i1 != 45) {
        break;
      }
      paramString2 = formatter_d10_in;
      break;
      label313:
      localObject = paramString2;
      if (i == 45380) {
        localObject = formatter_d10_kr;
      }
    }
    label332:
    return LocalDate.parse(paramString1, (DateTimeFormatter)localObject);
  }
  
  protected ZonedDateTime parseZonedDateTime(String paramString, DateTimeFormatter paramDateTimeFormatter)
  {
    Object localObject = paramDateTimeFormatter;
    DateTimeFormatter localDateTimeFormatter;
    int i;
    int j;
    int k;
    int m;
    int n;
    if (paramDateTimeFormatter == null)
    {
      localDateTimeFormatter = paramDateTimeFormatter;
      if (paramString.length() == 19)
      {
        i = paramString.charAt(4);
        j = paramString.charAt(7);
        k = paramString.charAt(10);
        m = paramString.charAt(13);
        n = paramString.charAt(16);
        localDateTimeFormatter = paramDateTimeFormatter;
        if (m == 58)
        {
          localDateTimeFormatter = paramDateTimeFormatter;
          if (n == 58)
          {
            if ((i != 45) || (j != 45)) {
              break label177;
            }
            if (k != 84) {
              break label159;
            }
            localDateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
          }
        }
      }
      localObject = localDateTimeFormatter;
      if (paramString.length() >= 17)
      {
        i = paramString.charAt(4);
        if (i != 24180) {
          break label439;
        }
        if (paramString.charAt(paramString.length() - 1) != '秒') {
          break label431;
        }
        localObject = formatter_dt19_cn_1;
      }
    }
    for (;;)
    {
      if (localObject != null) {
        break label458;
      }
      return ZonedDateTime.parse(paramString);
      label159:
      localDateTimeFormatter = paramDateTimeFormatter;
      if (k != 32) {
        break;
      }
      localDateTimeFormatter = defaultFormatter;
      break;
      label177:
      if ((i == 45) && (j == 45))
      {
        localDateTimeFormatter = defaultFormatter;
        break;
      }
      if ((i == 47) && (j == 47))
      {
        localDateTimeFormatter = formatter_dt19_tw;
        break;
      }
      j = paramString.charAt(0);
      k = paramString.charAt(1);
      m = paramString.charAt(2);
      n = paramString.charAt(3);
      int i1 = paramString.charAt(5);
      if ((m == 47) && (i1 == 47))
      {
        if ((j - 48) * 10 + (k - 48) > 12)
        {
          localDateTimeFormatter = formatter_dt19_eur;
          break;
        }
        if (i - 48 + (n - 48) * 10 > 12)
        {
          localDateTimeFormatter = formatter_dt19_us;
          break;
        }
        localObject = Locale.getDefault().getCountry();
        if (((String)localObject).equals("US"))
        {
          localDateTimeFormatter = formatter_dt19_us;
          break;
        }
        if (!((String)localObject).equals("BR"))
        {
          localDateTimeFormatter = paramDateTimeFormatter;
          if (!((String)localObject).equals("AU")) {
            break;
          }
        }
        localDateTimeFormatter = formatter_dt19_eur;
        break;
      }
      if ((m == 46) && (i1 == 46))
      {
        localDateTimeFormatter = formatter_dt19_de;
        break;
      }
      localDateTimeFormatter = paramDateTimeFormatter;
      if (m != 45) {
        break;
      }
      localDateTimeFormatter = paramDateTimeFormatter;
      if (i1 != 45) {
        break;
      }
      localDateTimeFormatter = formatter_dt19_in;
      break;
      label431:
      localObject = formatter_dt19_cn;
      continue;
      label439:
      localObject = localDateTimeFormatter;
      if (i == 45380) {
        localObject = formatter_dt19_kr;
      }
    }
    label458:
    return ZonedDateTime.parse(paramString, (DateTimeFormatter)localObject);
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject, BeanContext paramBeanContext)
    throws IOException
  {
    paramJSONSerializer = paramJSONSerializer.out;
    paramBeanContext = paramBeanContext.getFormat();
    write(paramJSONSerializer, (TemporalAccessor)paramObject, paramBeanContext);
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
    paramObject2 = paramType;
    if (paramType == null) {
      paramObject2 = paramObject1.getClass();
    }
    if (paramObject2 == LocalDateTime.class)
    {
      int i = SerializerFeature.UseISO8601DateFormat.getMask();
      paramType = (LocalDateTime)paramObject1;
      paramObject2 = paramJSONSerializer.getDateFormatPattern();
      if (((paramObject2 == null) && ((i & paramInt) != 0)) || (paramJSONSerializer.isEnabled(SerializerFeature.UseISO8601DateFormat))) {
        paramObject2 = "yyyy-MM-dd'T'HH:mm:ss";
      }
      if ((paramType.getNano() == 0) || (paramObject2 != null))
      {
        paramJSONSerializer = (JSONSerializer)paramObject2;
        if (paramObject2 == null) {
          paramJSONSerializer = a.e;
        }
        write(localSerializeWriter, paramType, paramJSONSerializer);
        return;
      }
      localSerializeWriter.writeString(paramObject1.toString());
      return;
    }
    localSerializeWriter.writeString(paramObject1.toString());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/Jdk8DateCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */