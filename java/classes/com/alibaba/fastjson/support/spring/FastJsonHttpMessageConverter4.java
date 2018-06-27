package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

public class FastJsonHttpMessageConverter4
  extends AbstractGenericHttpMessageConverter<Object>
{
  private FastJsonConfig fastJsonConfig = new FastJsonConfig();
  
  public FastJsonHttpMessageConverter4()
  {
    super(MediaType.ALL);
  }
  
  public FastJsonConfig getFastJsonConfig()
  {
    return this.fastJsonConfig;
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
  
  public void setFastJsonConfig(FastJsonConfig paramFastJsonConfig)
  {
    this.fastJsonConfig = paramFastJsonConfig;
  }
  
  protected boolean supports(Class<?> paramClass)
  {
    return true;
  }
  
  protected void writeInternal(Object paramObject, Type paramType, HttpOutputMessage paramHttpOutputMessage)
    throws IOException, HttpMessageNotWritableException
  {
    paramType = paramHttpOutputMessage.getHeaders();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramType.setContentLength(a.writeJSONString(localByteArrayOutputStream, this.fastJsonConfig.getCharset(), paramObject, this.fastJsonConfig.getSerializeConfig(), this.fastJsonConfig.getSerializeFilters(), this.fastJsonConfig.getDateFormat(), a.g, this.fastJsonConfig.getSerializerFeatures()));
    localByteArrayOutputStream.writeTo(paramHttpOutputMessage.getBody());
    localByteArrayOutputStream.close();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/support/spring/FastJsonHttpMessageConverter4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */