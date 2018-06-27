package com.ziroom.ziroomcustomer.minsu.d;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.Window;
import com.ziroom.ziroomcustomer.minsu.f.c;
import com.ziroom.ziroomcustomer.minsu.f.h;

public class a
{
  private static a a;
  private Bitmap b;
  private a c;
  
  private Bitmap a()
  {
    try
    {
      Bitmap localBitmap = this.b;
      return localBitmap;
    }
    finally
    {
      this.b = null;
    }
  }
  
  private void a(Bitmap paramBitmap)
  {
    this.b = paramBitmap;
  }
  
  public static a getInstance()
  {
    if (a == null) {
      a = new a();
    }
    return a;
  }
  
  public void doBlurInBack(final Activity paramActivity, Bitmap paramBitmap)
  {
    new AsyncTask()
    {
      protected Void a(Bitmap[] paramAnonymousArrayOfBitmap)
      {
        a.a(a.this, h.getBlurBitmap(paramAnonymousArrayOfBitmap[0], paramActivity.getWindow().getDecorView()));
        if (a.a(a.this) != null) {
          a.a(a.this).onBlured(a.b(a.this));
        }
        return null;
      }
    }.execute(new Bitmap[] { paramBitmap });
  }
  
  public void setBlurCb(a parama)
  {
    if (c.isNull(this.b))
    {
      this.c = parama;
      return;
    }
    parama.onBlured(a());
  }
  
  public static abstract interface a
  {
    public abstract void onBlured(Bitmap paramBitmap);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */