package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.IOUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class CalendarCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final CalendarCodec instance = new CalendarCodec();
  private DatatypeFactory dateFactory;
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    paramObject = DateCodec.instance.deserialze(paramDefaultJSONParser, paramType, paramObject);
    if ((paramObject instanceof Calendar)) {
      return (T)paramObject;
    }
    paramObject = (Date)paramObject;
    if (paramObject == null) {
      return null;
    }
    paramDefaultJSONParser = paramDefaultJSONParser.lexer;
    paramDefaultJSONParser = Calendar.getInstance(paramDefaultJSONParser.getTimeZone(), paramDefaultJSONParser.getLocale());
    paramDefaultJSONParser.setTime((Date)paramObject);
    if (paramType == XMLGregorianCalendar.class)
    {
      if (this.dateFactory == null) {}
      try
      {
        this.dateFactory = DatatypeFactory.newInstance();
        return this.dateFactory.newXMLGregorianCalendar((GregorianCalendar)paramDefaultJSONParser);
      }
      catch (DatatypeConfigurationException paramDefaultJSONParser)
      {
        throw new IllegalStateException("Could not obtain an instance of DatatypeFactory.", paramDefaultJSONParser);
      }
    }
    return paramDefaultJSONParser;
  }
  
  public int getFastMatchToken()
  {
    return 2;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt)
    throws IOException
  {
    paramObject2 = paramJSONSerializer.out;
    if (paramObject1 == null)
    {
      ((SerializeWriter)paramObject2).writeNull();
      return;
    }
    char c;
    label53:
    int i;
    int j;
    int k;
    int m;
    int n;
    if ((paramObject1 instanceof XMLGregorianCalendar))
    {
      paramObject1 = ((XMLGregorianCalendar)paramObject1).toGregorianCalendar();
      if (!((SerializeWriter)paramObject2).isEnabled(SerializerFeature.UseISO8601DateFormat)) {
        break label412;
      }
      if (!((SerializeWriter)paramObject2).isEnabled(SerializerFeature.UseSingleQuotes)) {
        break label226;
      }
      c = '\'';
      ((SerializeWriter)paramObject2).append(c);
      paramInt = ((Calendar)paramObject1).get(1);
      i = ((Calendar)paramObject1).get(2) + 1;
      j = ((Calendar)paramObject1).get(5);
      k = ((Calendar)paramObject1).get(11);
      m = ((Calendar)paramObject1).get(12);
      n = ((Calendar)paramObject1).get(13);
      int i1 = ((Calendar)paramObject1).get(14);
      if (i1 == 0) {
        break label233;
      }
      paramJSONSerializer = "0000-00-00T00:00:00.000".toCharArray();
      IOUtils.getChars(i1, 23, paramJSONSerializer);
      IOUtils.getChars(n, 19, paramJSONSerializer);
      IOUtils.getChars(m, 16, paramJSONSerializer);
      IOUtils.getChars(k, 13, paramJSONSerializer);
      IOUtils.getChars(j, 10, paramJSONSerializer);
      IOUtils.getChars(i, 7, paramJSONSerializer);
      IOUtils.getChars(paramInt, 4, paramJSONSerializer);
      label181:
      ((SerializeWriter)paramObject2).write(paramJSONSerializer);
      paramInt = ((Calendar)paramObject1).getTimeZone().getRawOffset() / 3600000;
      if (paramInt != 0) {
        break label336;
      }
      ((SerializeWriter)paramObject2).append("Z");
    }
    for (;;)
    {
      ((SerializeWriter)paramObject2).append(c);
      return;
      paramObject1 = (Calendar)paramObject1;
      break;
      label226:
      c = '"';
      break label53;
      label233:
      if ((n == 0) && (m == 0) && (k == 0))
      {
        paramJSONSerializer = "0000-00-00".toCharArray();
        IOUtils.getChars(j, 10, paramJSONSerializer);
        IOUtils.getChars(i, 7, paramJSONSerializer);
        IOUtils.getChars(paramInt, 4, paramJSONSerializer);
        break label181;
      }
      paramJSONSerializer = "0000-00-00T00:00:00".toCharArray();
      IOUtils.getChars(n, 19, paramJSONSerializer);
      IOUtils.getChars(m, 16, paramJSONSerializer);
      IOUtils.getChars(k, 13, paramJSONSerializer);
      IOUtils.getChars(j, 10, paramJSONSerializer);
      IOUtils.getChars(i, 7, paramJSONSerializer);
      IOUtils.getChars(paramInt, 4, paramJSONSerializer);
      break label181;
      label336:
      if (paramInt > 0) {
        ((SerializeWriter)paramObject2).append("+").append(String.format("%02d", new Object[] { Integer.valueOf(paramInt) })).append(":00");
      } else {
        ((SerializeWriter)paramObject2).append("-").append(String.format("%02d", new Object[] { Integer.valueOf(-paramInt) })).append(":00");
      }
    }
    label412:
    paramJSONSerializer.write(((Calendar)paramObject1).getTime());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/CalendarCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */