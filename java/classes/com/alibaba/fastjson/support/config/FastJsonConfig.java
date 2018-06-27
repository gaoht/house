package com.alibaba.fastjson.support.config;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.IOUtils;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FastJsonConfig
{
  private Charset charset = IOUtils.UTF8;
  private Map<Class<?>, SerializeFilter> classSerializeFilters;
  private String dateFormat;
  private Feature[] features = new Feature[0];
  private ParserConfig parserConfig = ParserConfig.getGlobalInstance();
  private SerializeConfig serializeConfig = SerializeConfig.getGlobalInstance();
  private SerializeFilter[] serializeFilters = new SerializeFilter[0];
  private SerializerFeature[] serializerFeatures = new SerializerFeature[0];
  
  public Charset getCharset()
  {
    return this.charset;
  }
  
  public Map<Class<?>, SerializeFilter> getClassSerializeFilters()
  {
    return this.classSerializeFilters;
  }
  
  public String getDateFormat()
  {
    return this.dateFormat;
  }
  
  public Feature[] getFeatures()
  {
    return this.features;
  }
  
  public ParserConfig getParserConfig()
  {
    return this.parserConfig;
  }
  
  public SerializeConfig getSerializeConfig()
  {
    return this.serializeConfig;
  }
  
  public SerializeFilter[] getSerializeFilters()
  {
    return this.serializeFilters;
  }
  
  public SerializerFeature[] getSerializerFeatures()
  {
    return this.serializerFeatures;
  }
  
  public void setCharset(Charset paramCharset)
  {
    this.charset = paramCharset;
  }
  
  public void setClassSerializeFilters(Map<Class<?>, SerializeFilter> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      this.serializeConfig.addFilter((Class)localEntry.getKey(), (SerializeFilter)localEntry.getValue());
    }
    this.classSerializeFilters = paramMap;
  }
  
  public void setDateFormat(String paramString)
  {
    this.dateFormat = paramString;
  }
  
  public void setFeatures(Feature... paramVarArgs)
  {
    this.features = paramVarArgs;
  }
  
  public void setParserConfig(ParserConfig paramParserConfig)
  {
    this.parserConfig = paramParserConfig;
  }
  
  public void setSerializeConfig(SerializeConfig paramSerializeConfig)
  {
    this.serializeConfig = paramSerializeConfig;
  }
  
  public void setSerializeFilters(SerializeFilter... paramVarArgs)
  {
    this.serializeFilters = paramVarArgs;
  }
  
  public void setSerializerFeatures(SerializerFeature... paramVarArgs)
  {
    this.serializerFeatures = paramVarArgs;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/support/config/FastJsonConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */