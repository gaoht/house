package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.d;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

public class DefaultFieldDeserializer
  extends FieldDeserializer
{
  protected ObjectDeserializer fieldValueDeserilizer;
  
  public DefaultFieldDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, FieldInfo paramFieldInfo)
  {
    super(paramClass, paramFieldInfo);
  }
  
  public int getFastMatchToken()
  {
    if (this.fieldValueDeserilizer != null) {
      return this.fieldValueDeserilizer.getFastMatchToken();
    }
    return 2;
  }
  
  public ObjectDeserializer getFieldValueDeserilizer(ParserConfig paramParserConfig)
  {
    if (this.fieldValueDeserilizer == null)
    {
      JSONField localJSONField = this.fieldInfo.getAnnotation();
      if ((localJSONField == null) || (localJSONField.deserializeUsing() == Void.class)) {
        break label65;
      }
      paramParserConfig = localJSONField.deserializeUsing();
    }
    for (;;)
    {
      try
      {
        this.fieldValueDeserilizer = ((ObjectDeserializer)paramParserConfig.newInstance());
        return this.fieldValueDeserilizer;
      }
      catch (Exception paramParserConfig)
      {
        throw new d("create deserializeUsing ObjectDeserializer error", paramParserConfig);
      }
      label65:
      this.fieldValueDeserilizer = paramParserConfig.getDeserializer(this.fieldInfo.fieldClass, this.fieldInfo.fieldType);
    }
  }
  
  public void parseField(DefaultJSONParser paramDefaultJSONParser, Object paramObject, Type paramType, Map<String, Object> paramMap)
  {
    if (this.fieldValueDeserilizer == null) {
      getFieldValueDeserilizer(paramDefaultJSONParser.getConfig());
    }
    Type localType = this.fieldInfo.fieldType;
    Object localObject = localType;
    if ((paramType instanceof ParameterizedType))
    {
      localObject = paramDefaultJSONParser.getContext();
      if (localObject != null) {
        ((ParseContext)localObject).type = paramType;
      }
      localObject = FieldInfo.getFieldType(this.clazz, paramType, localType);
      this.fieldValueDeserilizer = paramDefaultJSONParser.getConfig().getDeserializer((Type)localObject);
    }
    if ((this.fieldValueDeserilizer instanceof JavaBeanDeserializer)) {
      paramType = ((JavaBeanDeserializer)this.fieldValueDeserilizer).deserialze(paramDefaultJSONParser, (Type)localObject, this.fieldInfo.name, this.fieldInfo.parserFeatures);
    }
    while (paramDefaultJSONParser.getResolveStatus() == 1)
    {
      paramObject = paramDefaultJSONParser.getLastResolveTask();
      ((DefaultJSONParser.ResolveTask)paramObject).fieldDeserializer = this;
      ((DefaultJSONParser.ResolveTask)paramObject).ownerContext = paramDefaultJSONParser.getContext();
      paramDefaultJSONParser.setResolveStatus(0);
      return;
      if ((this.fieldInfo.format != null) && ((this.fieldValueDeserilizer instanceof ContextObjectDeserializer))) {
        paramType = ((ContextObjectDeserializer)this.fieldValueDeserilizer).deserialze(paramDefaultJSONParser, (Type)localObject, this.fieldInfo.name, this.fieldInfo.format, this.fieldInfo.parserFeatures);
      } else {
        paramType = this.fieldValueDeserilizer.deserialze(paramDefaultJSONParser, (Type)localObject, this.fieldInfo.name);
      }
    }
    if (paramObject == null)
    {
      paramMap.put(this.fieldInfo.name, paramType);
      return;
    }
    setValue(paramObject, paramType);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/DefaultFieldDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */