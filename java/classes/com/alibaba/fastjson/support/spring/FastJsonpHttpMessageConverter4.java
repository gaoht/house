package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.util.IOUtils;
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

public class FastJsonpHttpMessageConverter4
  extends AbstractGenericHttpMessageConverter<Object>
{
  private static final byte[] JSONP_FUNCTION_PREFIX_BYTES = "/**/".getBytes(IOUtils.UTF8);
  private static final byte[] JSONP_FUNCTION_SUFFIX_BYTES = ");".getBytes(IOUtils.UTF8);
  private FastJsonConfig fastJsonConfig = new FastJsonConfig();
  
  public FastJsonpHttpMessageConverter4()
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
    HttpHeaders localHttpHeaders = paramHttpOutputMessage.getHeaders();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = writePrefix(localByteArrayOutputStream, paramObject);
    if ((paramObject instanceof MappingFastJsonValue)) {}
    for (paramType = ((MappingFastJsonValue)paramObject).getValue();; paramType = (Type)paramObject)
    {
      localHttpHeaders.setContentLength(a.writeJSONString(localByteArrayOutputStream, this.fastJsonConfig.getCharset(), paramType, this.fastJsonConfig.getSerializeConfig(), this.fastJsonConfig.getSerializeFilters(), this.fastJsonConfig.getDateFormat(), a.g, this.fastJsonConfig.getSerializerFeatures()) + i + writeSuffix(localByteArrayOutputStream, paramObject));
      localByteArrayOutputStream.writeTo(paramHttpOutputMessage.getBody());
      localByteArrayOutputStream.close();
      return;
    }
  }
  
  protected int writePrefix(ByteArrayOutputStream paramByteArrayOutputStream, Object paramObject)
    throws IOException
  {
    if ((paramObject instanceof MappingFastJsonValue)) {}
    for (paramObject = ((MappingFastJsonValue)paramObject).getJsonpFunction();; paramObject = null)
    {
      int i = 0;
      if (paramObject != null)
      {
        paramByteArrayOutputStream.write(JSONP_FUNCTION_PREFIX_BYTES);
        paramObject = ((String)paramObject + "(").getBytes(IOUtils.UTF8);
        paramByteArrayOutputStream.write((byte[])paramObject);
        i = JSONP_FUNCTION_PREFIX_BYTES.length;
        i = 0 + (paramObject.length + i);
      }
      return i;
    }
  }
  
  protected int writeSuffix(ByteArrayOutputStream paramByteArrayOutputStream, Object paramObject)
    throws IOException
  {
    if ((paramObject instanceof MappingFastJsonValue)) {}
    for (paramObject = ((MappingFastJsonValue)paramObject).getJsonpFunction();; paramObject = null)
    {
      int i = 0;
      if (paramObject != null)
      {
        paramByteArrayOutputStream.write(JSONP_FUNCTION_SUFFIX_BYTES);
        i = 0 + JSONP_FUNCTION_SUFFIX_BYTES.length;
      }
      return i;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/support/spring/FastJsonpHttpMessageConverter4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */