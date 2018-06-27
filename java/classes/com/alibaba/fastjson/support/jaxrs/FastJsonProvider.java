package com.alibaba.fastjson.support.jaxrs;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Consumes({"*/*"})
@Produces({"*/*"})
@Provider
public class FastJsonProvider
  implements MessageBodyReader<Object>, MessageBodyWriter<Object>
{
  @Deprecated
  protected Charset charset = IOUtils.UTF8;
  private Class<?>[] clazzes = null;
  @Deprecated
  protected String dateFormat;
  private FastJsonConfig fastJsonConfig = new FastJsonConfig();
  @Deprecated
  protected SerializerFeature[] features = new SerializerFeature[0];
  @Deprecated
  protected SerializeFilter[] filters = new SerializeFilter[0];
  private boolean pretty;
  
  public FastJsonProvider() {}
  
  @Deprecated
  public FastJsonProvider(String paramString)
  {
    this.fastJsonConfig.setCharset(Charset.forName(paramString));
  }
  
  public FastJsonProvider(Class<?>[] paramArrayOfClass)
  {
    this.clazzes = paramArrayOfClass;
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
  
  public long getSize(Object paramObject, Class<?> paramClass, Type paramType, Annotation[] paramArrayOfAnnotation, MediaType paramMediaType)
  {
    return -1L;
  }
  
  protected boolean hasMatchingMediaType(MediaType paramMediaType)
  {
    if (paramMediaType != null) {
      paramMediaType = paramMediaType.getSubtype();
    }
    return ("json".equalsIgnoreCase(paramMediaType)) || (paramMediaType.endsWith("+json")) || ("javascript".equals(paramMediaType)) || ("x-javascript".equals(paramMediaType)) || ("x-json".equals(paramMediaType)) || ("x-www-form-urlencoded".equalsIgnoreCase(paramMediaType)) || (paramMediaType.endsWith("x-www-form-urlencoded"));
  }
  
  public boolean isReadable(Class<?> paramClass, Type paramType, Annotation[] paramArrayOfAnnotation, MediaType paramMediaType)
  {
    if (!hasMatchingMediaType(paramMediaType)) {
      return false;
    }
    return isValidType(paramClass, paramArrayOfAnnotation);
  }
  
  protected boolean isValidType(Class<?> paramClass, Annotation[] paramArrayOfAnnotation)
  {
    if (paramClass == null) {}
    for (;;)
    {
      return false;
      if (this.clazzes == null) {
        break;
      }
      paramArrayOfAnnotation = this.clazzes;
      int j = paramArrayOfAnnotation.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfAnnotation[i] == paramClass) {
          return true;
        }
        i += 1;
      }
    }
    return true;
  }
  
  public boolean isWriteable(Class<?> paramClass, Type paramType, Annotation[] paramArrayOfAnnotation, MediaType paramMediaType)
  {
    if (!hasMatchingMediaType(paramMediaType)) {
      return false;
    }
    return isValidType(paramClass, paramArrayOfAnnotation);
  }
  
  public Object readFrom(Class<Object> paramClass, Type paramType, Annotation[] paramArrayOfAnnotation, MediaType paramMediaType, MultivaluedMap<String, String> paramMultivaluedMap, InputStream paramInputStream)
    throws IOException, WebApplicationException
  {
    return a.parseObject(paramInputStream, this.fastJsonConfig.getCharset(), paramType, this.fastJsonConfig.getFeatures());
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
  
  public FastJsonProvider setPretty(boolean paramBoolean)
  {
    this.pretty = paramBoolean;
    return this;
  }
  
  public void writeTo(Object paramObject, Class<?> paramClass, Type paramType, Annotation[] paramArrayOfAnnotation, MediaType paramMediaType, MultivaluedMap<String, Object> paramMultivaluedMap, OutputStream paramOutputStream)
    throws IOException, WebApplicationException
  {
    paramClass = this.fastJsonConfig.getSerializerFeatures();
    if (this.pretty)
    {
      if (paramClass != null) {
        break label100;
      }
      paramClass = new SerializerFeature[1];
      paramClass[0] = SerializerFeature.PrettyFormat;
    }
    for (;;)
    {
      this.fastJsonConfig.setSerializerFeatures(paramClass);
      paramMultivaluedMap.add("Content-Length", Integer.valueOf(a.writeJSONString(paramOutputStream, this.fastJsonConfig.getCharset(), paramObject, this.fastJsonConfig.getSerializeConfig(), this.fastJsonConfig.getSerializeFilters(), this.fastJsonConfig.getDateFormat(), a.g, this.fastJsonConfig.getSerializerFeatures())));
      paramOutputStream.flush();
      return;
      label100:
      paramType = new ArrayList(Arrays.asList(paramClass));
      paramType.add(SerializerFeature.PrettyFormat);
      paramClass = (SerializerFeature[])paramType.toArray(paramClass);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/support/jaxrs/FastJsonProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */