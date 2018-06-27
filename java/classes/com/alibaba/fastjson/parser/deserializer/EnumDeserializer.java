package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.d;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import java.lang.reflect.Type;
import java.util.Arrays;

public class EnumDeserializer
  implements ObjectDeserializer
{
  private final Class<?> enumClass;
  protected long[] enumNameHashCodes;
  protected final Enum[] enums;
  protected final Enum[] ordinalEnums;
  
  public EnumDeserializer(Class<?> paramClass)
  {
    this.enumClass = paramClass;
    this.ordinalEnums = ((Enum[])paramClass.getEnumConstants());
    paramClass = new long[this.ordinalEnums.length];
    this.enumNameHashCodes = new long[this.ordinalEnums.length];
    int i = 0;
    int j;
    while (i < this.ordinalEnums.length)
    {
      String str = this.ordinalEnums[i].name();
      long l = -2128831035L;
      j = 0;
      while (j < str.length())
      {
        l = (l ^ str.charAt(j)) * 16777619L;
        j += 1;
      }
      paramClass[i] = l;
      this.enumNameHashCodes[i] = l;
      i += 1;
    }
    Arrays.sort(this.enumNameHashCodes);
    this.enums = new Enum[this.ordinalEnums.length];
    i = 0;
    if (i < this.enumNameHashCodes.length)
    {
      j = 0;
      for (;;)
      {
        if (j < paramClass.length)
        {
          if (this.enumNameHashCodes[i] == paramClass[j]) {
            this.enums[i] = this.ordinalEnums[j];
          }
        }
        else
        {
          i += 1;
          break;
        }
        j += 1;
      }
    }
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    try
    {
      paramType = paramDefaultJSONParser.lexer;
      i = paramType.token();
      if (i == 2)
      {
        i = paramType.intValue();
        paramType.nextToken(16);
        if ((i < 0) || (i > this.ordinalEnums.length)) {
          throw new d("parse enum " + this.enumClass.getName() + " error, value : " + i);
        }
      }
    }
    catch (d paramDefaultJSONParser)
    {
      int i;
      throw paramDefaultJSONParser;
      return this.ordinalEnums[i];
      if (i == 4)
      {
        paramDefaultJSONParser = paramType.stringVal();
        paramType.nextToken(16);
        if (paramDefaultJSONParser.length() == 0) {
          break label219;
        }
        return Enum.valueOf(this.enumClass, paramDefaultJSONParser);
      }
      if (i == 8)
      {
        paramType.nextToken(16);
        return null;
      }
    }
    catch (Exception paramDefaultJSONParser)
    {
      throw new d(paramDefaultJSONParser.getMessage(), paramDefaultJSONParser);
    }
    paramDefaultJSONParser = paramDefaultJSONParser.parse();
    throw new d("parse enum " + this.enumClass.getName() + " error, value : " + paramDefaultJSONParser);
    label219:
    return null;
  }
  
  public Enum getEnumByHashCode(long paramLong)
  {
    if (this.enums == null) {}
    int i;
    do
    {
      return null;
      i = Arrays.binarySearch(this.enumNameHashCodes, paramLong);
    } while (i < 0);
    return this.enums[i];
  }
  
  public int getFastMatchToken()
  {
    return 2;
  }
  
  public Enum<?> valueOf(int paramInt)
  {
    return this.ordinalEnums[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/EnumDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */