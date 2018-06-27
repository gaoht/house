package com.superrtc.sdk;

import com.superrtc.call.y;

public class g
{
  final y a;
  public String b;
  private boolean c = true;
  
  public g(VideoView paramVideoView, String paramString)
  {
    a("VideoViewRenderer");
    this.b = paramString;
    this.a = new y(paramVideoView, null);
    if (this.b == null) {
      this.b = "";
    }
    this.a.setReadyCallback(new Runnable()
    {
      public void run()
      {
        try
        {
          g.a(g.this, "view ready");
          g.a(g.this, true);
          return;
        }
        finally {}
      }
    });
  }
  
  private void a(String paramString)
  {
    a.i("VR", "<D><" + this.b + "> " + paramString);
  }
  
  protected y a()
  {
    return this.a;
  }
  
  public void dispose()
  {
    this.a.dispose();
  }
  
  public boolean getRenderEnabled()
  {
    return this.a.getRenderEnable();
  }
  
  public boolean isViewReady()
  {
    try
    {
      boolean bool = this.c;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setRenderEnable(boolean paramBoolean)
  {
    this.a.setRenderEnable(paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/sdk/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */