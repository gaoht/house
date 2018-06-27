package org.ksoap2.transport;

import java.io.IOException;

public class HttpResponseException
  extends IOException
{
  private int statusCode;
  
  public HttpResponseException(int paramInt)
  {
    this.statusCode = paramInt;
  }
  
  public HttpResponseException(String paramString, int paramInt)
  {
    super(paramString);
    this.statusCode = paramInt;
  }
  
  public HttpResponseException(String paramString, Throwable paramThrowable, int paramInt)
  {
    super(paramString, paramThrowable);
    this.statusCode = paramInt;
  }
  
  public HttpResponseException(Throwable paramThrowable, int paramInt)
  {
    super(paramThrowable);
    this.statusCode = paramInt;
  }
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/ksoap2/transport/HttpResponseException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */