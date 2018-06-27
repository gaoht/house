package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class FloatCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static FloatCodec instance = new FloatCodec();
  private NumberFormat decimalFormat;
  
  public FloatCodec() {}
  
  public FloatCodec(String paramString)
  {
    this(new DecimalFormat(paramString));
  }
  
  public FloatCodec(DecimalFormat paramDecimalFormat)
  {
    this.decimalFormat = paramDecimalFormat;
  }
  
  public static <T> T deserialze(DefaultJSONParser paramDefaultJSONParser)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.lexer;
    if (localJSONLexer.token() == 2)
    {
      paramDefaultJSONParser = localJSONLexer.numberString();
      localJSONLexer.nextToken(16);
      return Float.valueOf(Float.parseFloat(paramDefaultJSONParser));
    }
    if (localJSONLexer.token() == 3)
    {
      float f = localJSONLexer.floatValue();
      localJSONLexer.nextToken(16);
      return Float.valueOf(f);
    }
    paramDefaultJSONParser = paramDefaultJSONParser.parse();
    if (paramDefaultJSONParser == null) {
      return null;
    }
    return TypeUtils.castToFloat(paramDefaultJSONParser);
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    return (T)deserialze(paramDefaultJSONParser);
  }
  
  public int getFastMatchToken()
  {
    return 2;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt)
    throws IOException
  {
    paramJSONSerializer = paramJSONSerializer.out;
    if (paramObject1 == null)
    {
      paramJSONSerializer.writeNull(SerializerFeature.WriteNullNumberAsZero);
      return;
    }
    float f = ((Float)paramObject1).floatValue();
    if (this.decimalFormat != null)
    {
      paramJSONSerializer.write(this.decimalFormat.format(f));
      return;
    }
    paramJSONSerializer.writeFloat(f, true);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/FloatCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */