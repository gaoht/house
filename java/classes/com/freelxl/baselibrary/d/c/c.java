package com.freelxl.baselibrary.d.c;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public abstract class c<T>
  implements Callback
{
  private com.freelxl.baselibrary.d.f.a<T> a;
  
  public c(com.freelxl.baselibrary.d.f.a<T> parama)
  {
    if (parama == null) {
      throw new IllegalArgumentException("Parser can't be null");
    }
    this.a = parama;
  }
  
  public abstract void onFailure(Throwable paramThrowable);
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    onFailure(paramIOException);
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    try
    {
      paramCall = this.a.parseResponse(paramResponse);
      int i = this.a.getCode();
      if (paramResponse.isSuccessful())
      {
        onSuccess(i, paramCall);
        return;
      }
      onFailure(new com.freelxl.baselibrary.d.d.a(i));
      return;
    }
    catch (Exception paramCall)
    {
      onFailure(paramCall);
    }
  }
  
  public abstract void onSuccess(int paramInt, T paramT);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/d/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */