package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.socket.sockjs.frame.AbstractSockJsMessageCodec;

public class FastjsonSockJsMessageCodec
  extends AbstractSockJsMessageCodec
{
  protected char[] applyJsonQuoting(String paramString)
  {
    SerializeWriter localSerializeWriter = new SerializeWriter();
    try
    {
      new JSONSerializer(localSerializeWriter).write(paramString);
      paramString = localSerializeWriter.toCharArrayForSpringWebSocket();
      return paramString;
    }
    finally
    {
      localSerializeWriter.close();
    }
  }
  
  public String[] decode(String paramString)
    throws IOException
  {
    return (String[])a.parseObject(paramString, String[].class);
  }
  
  public String[] decodeInputStream(InputStream paramInputStream)
    throws IOException
  {
    return (String[])a.parseObject(paramInputStream, String[].class, new Feature[0]);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/support/spring/FastjsonSockJsMessageCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */