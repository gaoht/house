package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;

public class DoubleSerializer
  implements ObjectSerializer
{
  public static final DoubleSerializer instance = new DoubleSerializer();
  private DecimalFormat decimalFormat = null;
  
  public DoubleSerializer() {}
  
  public DoubleSerializer(String paramString)
  {
    this(new DecimalFormat(paramString));
  }
  
  public DoubleSerializer(DecimalFormat paramDecimalFormat)
  {
    this.decimalFormat = paramDecimalFormat;
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
    double d = ((Double)paramObject1).doubleValue();
    if ((Double.isNaN(d)) || (Double.isInfinite(d)))
    {
      paramJSONSerializer.writeNull();
      return;
    }
    if (this.decimalFormat == null)
    {
      paramJSONSerializer.writeDouble(d, true);
      return;
    }
    paramJSONSerializer.write(this.decimalFormat.format(d));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/DoubleSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */