package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.util.IOUtils;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.view.AbstractView;

public class FastJsonJsonView
  extends AbstractView
{
  public static final String DEFAULT_CONTENT_TYPE = "application/json;charset=UTF-8";
  @Deprecated
  protected Charset charset = IOUtils.UTF8;
  @Deprecated
  protected String dateFormat;
  private boolean disableCaching = true;
  private boolean extractValueFromSingleKeyModel = false;
  private FastJsonConfig fastJsonConfig = new FastJsonConfig();
  @Deprecated
  protected SerializerFeature[] features = new SerializerFeature[0];
  @Deprecated
  protected SerializeFilter[] filters = new SerializeFilter[0];
  private Set<String> renderedAttributes;
  private boolean updateContentLength = true;
  
  public FastJsonJsonView()
  {
    setContentType("application/json;charset=UTF-8");
    setExposePathVariables(false);
  }
  
  protected Object filterModel(Map<String, Object> paramMap)
  {
    HashMap localHashMap = new HashMap(paramMap.size());
    if (!CollectionUtils.isEmpty(this.renderedAttributes)) {}
    for (Set localSet = this.renderedAttributes;; localSet = paramMap.keySet())
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if ((!(localEntry.getValue() instanceof BindingResult)) && (localSet.contains(localEntry.getKey()))) {
          localHashMap.put(localEntry.getKey(), localEntry.getValue());
        }
      }
    }
    if ((this.extractValueFromSingleKeyModel) && (localHashMap.size() == 1))
    {
      paramMap = localHashMap.entrySet().iterator();
      if (paramMap.hasNext()) {
        return ((Map.Entry)paramMap.next()).getValue();
      }
    }
    return localHashMap;
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
  
  public boolean isExtractValueFromSingleKeyModel()
  {
    return this.extractValueFromSingleKeyModel;
  }
  
  protected void prepareResponse(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
  {
    setResponseContentType(paramHttpServletRequest, paramHttpServletResponse);
    paramHttpServletResponse.setCharacterEncoding(this.fastJsonConfig.getCharset().name());
    if (this.disableCaching)
    {
      paramHttpServletResponse.addHeader("Pragma", "no-cache");
      paramHttpServletResponse.addHeader("Cache-Control", "no-cache, no-store, max-age=0");
      paramHttpServletResponse.addDateHeader("Expires", 1L);
    }
  }
  
  protected void renderMergedOutputModel(Map<String, Object> paramMap, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws Exception
  {
    paramHttpServletRequest = filterModel(paramMap);
    paramMap = new ByteArrayOutputStream();
    int i = a.writeJSONString(paramMap, this.fastJsonConfig.getCharset(), paramHttpServletRequest, this.fastJsonConfig.getSerializeConfig(), this.fastJsonConfig.getSerializeFilters(), this.fastJsonConfig.getDateFormat(), a.g, this.fastJsonConfig.getSerializerFeatures());
    if (this.updateContentLength) {
      paramHttpServletResponse.setContentLength(i);
    }
    paramHttpServletRequest = paramHttpServletResponse.getOutputStream();
    paramMap.writeTo(paramHttpServletRequest);
    paramMap.close();
    paramHttpServletRequest.flush();
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
  
  public void setDisableCaching(boolean paramBoolean)
  {
    this.disableCaching = paramBoolean;
  }
  
  public void setExtractValueFromSingleKeyModel(boolean paramBoolean)
  {
    this.extractValueFromSingleKeyModel = paramBoolean;
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
  
  public void setRenderedAttributes(Set<String> paramSet)
  {
    this.renderedAttributes = paramSet;
  }
  
  @Deprecated
  public void setSerializerFeature(SerializerFeature... paramVarArgs)
  {
    this.fastJsonConfig.setSerializerFeatures(paramVarArgs);
  }
  
  public void setUpdateContentLength(boolean paramBoolean)
  {
    this.updateContentLength = paramBoolean;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/support/spring/FastJsonJsonView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */