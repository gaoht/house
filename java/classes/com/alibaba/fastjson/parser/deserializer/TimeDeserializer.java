package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.d;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONScanner;
import java.lang.reflect.Type;
import java.sql.Time;
import java.util.Calendar;

public class TimeDeserializer
  implements ObjectDeserializer
{
  public static final TimeDeserializer instance = new TimeDeserializer();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    int k = 0;
    paramType = paramDefaultJSONParser.lexer;
    long l;
    if (paramType.token() == 16)
    {
      paramType.nextToken(4);
      if (paramType.token() != 4) {
        throw new d("syntax error");
      }
      paramType.nextTokenWithColon(2);
      if (paramType.token() != 2) {
        throw new d("syntax error");
      }
      l = paramType.longValue();
      paramType.nextToken(13);
      if (paramType.token() != 13) {
        throw new d("syntax error");
      }
      paramType.nextToken(16);
      paramDefaultJSONParser = new Time(l);
    }
    do
    {
      return paramDefaultJSONParser;
      paramType = paramDefaultJSONParser.parse();
      if (paramType == null) {
        return null;
      }
      paramDefaultJSONParser = paramType;
    } while ((paramType instanceof Time));
    if ((paramType instanceof Number)) {
      return new Time(((Number)paramType).longValue());
    }
    int i;
    if ((paramType instanceof String))
    {
      paramDefaultJSONParser = (String)paramType;
      if (paramDefaultJSONParser.length() == 0) {
        return null;
      }
      paramType = new JSONScanner(paramDefaultJSONParser);
      if (paramType.scanISO8601DateIfMatch())
      {
        l = paramType.getCalendar().getTimeInMillis();
        paramType.close();
        return new Time(l);
      }
      i = 0;
      label235:
      if (i >= paramDefaultJSONParser.length()) {
        break label316;
      }
      int m = paramDefaultJSONParser.charAt(i);
      j = k;
      if (m >= 48) {
        if (m <= 57) {
          break label288;
        }
      }
    }
    label288:
    label316:
    for (int j = k;; j = 1)
    {
      if (j == 0)
      {
        paramType.close();
        return Time.valueOf(paramDefaultJSONParser);
        i += 1;
        break label235;
      }
      l = Long.parseLong(paramDefaultJSONParser);
      break;
      throw new d("parse error");
    }
  }
  
  public int getFastMatchToken()
  {
    return 2;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/TimeDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */