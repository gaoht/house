package com.alibaba.fastjson.support.spring;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class FastJsonpResponseBodyAdvice
  implements ResponseBodyAdvice<Object>
{
  private static final Pattern CALLBACK_PARAM_PATTERN = Pattern.compile("[0-9A-Za-z_\\.]*");
  private final String[] jsonpQueryParamNames;
  
  public FastJsonpResponseBodyAdvice(String... paramVarArgs)
  {
    if (!ObjectUtils.isEmpty(paramVarArgs)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.isTrue(bool, "At least one query param name is required");
      this.jsonpQueryParamNames = paramVarArgs;
      return;
    }
  }
  
  public Object beforeBodyWrite(Object paramObject, MethodParameter paramMethodParameter, MediaType paramMediaType, Class<? extends HttpMessageConverter<?>> paramClass, ServerHttpRequest paramServerHttpRequest, ServerHttpResponse paramServerHttpResponse)
  {
    paramObject = getOrCreateContainer(paramObject);
    beforeBodyWriteInternal((MappingFastJsonValue)paramObject, paramMediaType, paramMethodParameter, paramServerHttpRequest, paramServerHttpResponse);
    return paramObject;
  }
  
  public void beforeBodyWriteInternal(MappingFastJsonValue paramMappingFastJsonValue, MediaType paramMediaType, MethodParameter paramMethodParameter, ServerHttpRequest paramServerHttpRequest, ServerHttpResponse paramServerHttpResponse)
  {
    HttpServletRequest localHttpServletRequest = ((ServletServerHttpRequest)paramServerHttpRequest).getServletRequest();
    String[] arrayOfString = this.jsonpQueryParamNames;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramMethodParameter = localHttpServletRequest.getParameter(arrayOfString[i]);
      if ((paramMethodParameter == null) || (!isValidJsonpQueryParam(paramMethodParameter)))
      {
        i += 1;
      }
      else
      {
        paramMediaType = getContentType(paramMediaType, paramServerHttpRequest, paramServerHttpResponse);
        paramServerHttpResponse.getHeaders().setContentType(paramMediaType);
        paramMappingFastJsonValue.setJsonpFunction(paramMethodParameter);
      }
    }
  }
  
  protected MediaType getContentType(MediaType paramMediaType, ServerHttpRequest paramServerHttpRequest, ServerHttpResponse paramServerHttpResponse)
  {
    return new MediaType("application", "javascript");
  }
  
  protected MappingFastJsonValue getOrCreateContainer(Object paramObject)
  {
    if ((paramObject instanceof MappingFastJsonValue)) {
      return (MappingFastJsonValue)paramObject;
    }
    return new MappingFastJsonValue(paramObject);
  }
  
  protected boolean isValidJsonpQueryParam(String paramString)
  {
    return CALLBACK_PARAM_PATTERN.matcher(paramString).matches();
  }
  
  public boolean supports(MethodParameter paramMethodParameter, Class<? extends HttpMessageConverter<?>> paramClass)
  {
    return FastJsonpHttpMessageConverter4.class.isAssignableFrom(paramClass);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/support/spring/FastJsonpResponseBodyAdvice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */