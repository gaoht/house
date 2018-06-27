package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.util.IOUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.GenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

public class FastJsonHttpMessageConverter
  extends AbstractHttpMessageConverter<Object>
  implements GenericHttpMessageConverter<Object>
{
  @Deprecated
  protected Charset charset = IOUtils.UTF8;
  @Deprecated
  protected String dateFormat;
  private FastJsonConfig fastJsonConfig = new FastJsonConfig();
  @Deprecated
  protected SerializerFeature[] features = new SerializerFeature[0];
  @Deprecated
  protected SerializeFilter[] filters = new SerializeFilter[0];
  
  public FastJsonHttpMessageConverter()
  {
    super(MediaType.ALL);
  }
  
  @Deprecated
  public void addSerializeFilter(SerializeFilter paramSerializeFilter)
  {
    if (paramSerializeFilter == null) {
      return;
    }
    int i = this.fastJsonConfig.getSerializeFilters().length;
    SerializeFilter[] arrayOfSerializeFilter = new SerializeFilter[i + 1];
    System.arraycopy(this.fastJsonConfig.getSerializeFilters(), 0, arrayOfSerializeFilter, 0, i);
    arrayOfSerializeFilter[(arrayOfSerializeFilter.length - 1)] = paramSerializeFilter;
    this.fastJsonConfig.setSerializeFilters(arrayOfSerializeFilter);
  }
  
  public boolean canRead(Type paramType, Class<?> paramClass, MediaType paramMediaType)
  {
    return super.canRead(paramClass, paramMediaType);
  }
  
  public boolean canWrite(Type paramType, Class<?> paramClass, MediaType paramMediaType)
  {
    return super.canWrite(paramClass, paramMediaType);
  }
  
  @Deprecated
  public Charset getCharset()
  {
    return this.fastJsonConfig.getCharset();
  }
  
  @Deprecated
  public String getDateFormat()
  {
    return this.fastJsonConfig.getDateFormat();
  }
  
  public FastJsonConfig getFastJsonConfig()
  {
    return this.fastJsonConfig;
  }
  
  @Deprecated
  public SerializerFeature[] getFeatures()
  {
    return this.fastJsonConfig.getSerializerFeatures();
  }
  
  @Deprecated
  public SerializeFilter[] getFilters()
  {
    return this.fastJsonConfig.getSerializeFilters();
  }
  
  public Object read(Type paramType, Class<?> paramClass, HttpInputMessage paramHttpInputMessage)
    throws IOException, HttpMessageNotReadableException
  {
    return a.parseObject(paramHttpInputMessage.getBody(), this.fastJsonConfig.getCharset(), paramType, this.fastJsonConfig.getFeatures());
  }
  
  protected Object readInternal(Class<? extends Object> paramClass, HttpInputMessage paramHttpInputMessage)
    throws IOException, HttpMessageNotReadableException
  {
    return a.parseObject(paramHttpInputMessage.getBody(), this.fastJsonConfig.getCharset(), paramClass, this.fastJsonConfig.getFeatures());
  }
  
  @Deprecated
  public void setCharset(Charset paramCharset)
  {
    this.fastJsonConfig.setCharset(paramCharset);
  }
  
  @Deprecated
  public void setDateFormat(String paramString)
  {
    this.fastJsonConfig.setDateFormat(paramString);
  }
  
  public void setFastJsonConfig(FastJsonConfig paramFastJsonConfig)
  {
    this.fastJsonConfig = paramFastJsonConfig;
  }
  
  @Deprecated
  public void setFeatures(SerializerFeature... paramVarArgs)
  {
    this.fastJsonConfig.setSerializerFeatures(paramVarArgs);
  }
  
  @Deprecated
  public void setFilters(SerializeFilter... paramVarArgs)
  {
    this.fastJsonConfig.setSerializeFilters(paramVarArgs);
  }
  
  protected boolean supports(Class<?> paramClass)
  {
    return true;
  }
  
  public void write(Object paramObject, Type paramType, MediaType paramMediaType, HttpOutputMessage paramHttpOutputMessage)
    throws IOException, HttpMessageNotWritableException
  {
    HttpHeaders localHttpHeaders = paramHttpOutputMessage.getHeaders();
    if (localHttpHeaders.getContentType() == null)
    {
      if ((paramMediaType != null) && (!paramMediaType.isWildcardType()))
      {
        paramType = paramMediaType;
        if (!paramMediaType.isWildcardSubtype()) {}
      }
      else
      {
        paramType = getDefaultContentType(paramObject);
      }
      if (paramType != null) {
        localHttpHeaders.setContentType(paramType);
      }
    }
    if (localHttpHeaders.getContentLength() == -1L)
    {
      paramType = getContentLength(paramObject, localHttpHeaders.getContentType());
      if (paramType != null) {
        localHttpHeaders.setContentLength(paramType.longValue());
      }
    }
    writeInternal(paramObject, paramHttpOutputMessage);
    paramHttpOutputMessage.getBody().flush();
  }
  
  protected void writeInternal(Object paramObject, HttpOutputMessage paramHttpOutputMessage)
    throws IOException, HttpMessageNotWritableException
  {
    HttpHeaders localHttpHeaders = paramHttpOutputMessage.getHeaders();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    localHttpHeaders.setContentLength(a.writeJSONString(localByteArrayOutputStream, this.fastJsonConfig.getCharset(), paramObject, this.fastJsonConfig.getSerializeConfig(), this.fastJsonConfig.getSerializeFilters(), this.fastJsonConfig.getDateFormat(), a.g, this.fastJsonConfig.getSerializerFeatures()));
    localByteArrayOutputStream.writeTo(paramHttpOutputMessage.getBody());
    localByteArrayOutputStream.close();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/support/spring/FastJsonHttpMessageConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */