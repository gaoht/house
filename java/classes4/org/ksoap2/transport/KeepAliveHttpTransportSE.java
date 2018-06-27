package org.ksoap2.transport;

import java.io.IOException;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.xmlpull.v1.XmlPullParserException;

public class KeepAliveHttpTransportSE
  extends HttpTransportSE
{
  public KeepAliveHttpTransportSE(String paramString)
  {
    super(null, paramString);
  }
  
  public KeepAliveHttpTransportSE(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  public KeepAliveHttpTransportSE(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString, paramInt1);
  }
  
  public KeepAliveHttpTransportSE(Proxy paramProxy, String paramString)
  {
    super(paramProxy, paramString);
  }
  
  public KeepAliveHttpTransportSE(Proxy paramProxy, String paramString, int paramInt)
  {
    super(paramProxy, paramString, paramInt);
  }
  
  public KeepAliveHttpTransportSE(Proxy paramProxy, String paramString, int paramInt1, int paramInt2)
  {
    super(paramProxy, paramString, paramInt1);
  }
  
  public List call(String paramString, SoapEnvelope paramSoapEnvelope, List paramList)
    throws IOException, XmlPullParserException
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    paramList = getHeader((List)localObject, "Connection");
    if (paramList == null) {
      ((List)localObject).add(new HeaderProperty("Connection", "keep-alive"));
    }
    for (;;)
    {
      return super.call(paramString, paramSoapEnvelope, (List)localObject);
      paramList.setValue("keep-alive");
    }
  }
  
  protected HeaderProperty getHeader(List paramList, String paramString)
  {
    if (paramList != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        HeaderProperty localHeaderProperty = (HeaderProperty)paramList.get(i);
        if (paramString.equals(localHeaderProperty.getKey())) {
          return localHeaderProperty;
        }
        i += 1;
      }
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/ksoap2/transport/KeepAliveHttpTransportSE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */