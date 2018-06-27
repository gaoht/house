package com.freelxl.baselibrary.d.c;

import android.os.Handler;
import android.os.Looper;

public abstract class b
{
  private static Handler a = new Handler(Looper.getMainLooper());
  
  public void onOKProgress(final long paramLong1, long paramLong2)
  {
    a.post(new Runnable()
    {
      public void run()
      {
        b.this.onProgress(paramLong1, this.b);
      }
    });
  }
  
  public abstract void onProgress(long paramLong1, long paramLong2);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/d/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */