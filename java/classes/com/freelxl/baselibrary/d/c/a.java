package com.freelxl.baselibrary.d.c;

import android.os.Handler;
import android.os.Looper;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public abstract class a<T>
  implements Callback
{
  protected static Handler a = new Handler(Looper.getMainLooper());
  private com.freelxl.baselibrary.d.f.a<T> b;
  
  public a(com.freelxl.baselibrary.d.f.a<T> parama)
  {
    if (parama == null) {
      throw new IllegalArgumentException("Parser can't be null");
    }
    this.b = parama;
  }
  
  public abstract void onFailure(Throwable paramThrowable);
  
  public void onFailure(Call paramCall, final IOException paramIOException)
  {
    a.post(new Runnable()
    {
      public void run()
      {
        a.this.onFailure(paramIOException);
      }
    });
  }
  
  public void onResponse(final Call paramCall, Response paramResponse)
  {
    try
    {
      paramCall = this.b.parseResponse(paramResponse);
      final int i = this.b.getCode();
      if (paramResponse.isSuccessful())
      {
        a.post(new Runnable()
        {
          public void run()
          {
            a.this.onSuccess(i, paramCall);
          }
        });
        return;
      }
      a.post(new Runnable()
      {
        public void run()
        {
          a.this.onFailure(new com.freelxl.baselibrary.d.d.a(i));
        }
      });
      return;
    }
    catch (Exception paramCall)
    {
      a.post(new Runnable()
      {
        public void run()
        {
          a.this.onFailure(paramCall);
        }
      });
    }
  }
  
  public void onStart() {}
  
  public abstract void onSuccess(int paramInt, T paramT);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/d/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */