package com.superrtc.mediamanager;

import android.view.View;

public class d
{
  protected String a = "AndroidNormal";
  protected boolean b = false;
  protected boolean c = false;
  protected String d = "";
  protected boolean e = false;
  protected int f = 320;
  protected int g = 240;
  protected View h = null;
  protected a.c i = a.c.a;
  protected boolean j = false;
  
  public static d initAudioMixConfig()
  {
    d locald = new d();
    locald.setPubType(a.c.c);
    locald.setName("AndroidAudioMix");
    locald.setMute(false);
    locald.setVideoOff(true);
    return locald;
  }
  
  public static d initDesktopConfig()
  {
    d locald = new d();
    locald.setPubType(a.c.b);
    locald.setName("AndroidDesktop");
    locald.setExternalVideoSource(true);
    locald.setMute(true);
    locald.setVideoOff(false);
    return locald;
  }
  
  public static d initNormalConfig()
  {
    d locald = new d();
    locald.setPubType(a.c.a);
    locald.setName("AndroidNormal");
    return locald;
  }
  
  public String getExtension()
  {
    return this.d;
  }
  
  public String getName()
  {
    return this.a;
  }
  
  public a.c getPubType()
  {
    return this.i;
  }
  
  public View getPubView()
  {
    return this.h;
  }
  
  public int getVheight()
  {
    return this.g;
  }
  
  public int getVwidth()
  {
    return this.f;
  }
  
  public boolean isExternalVideoSource()
  {
    return this.j;
  }
  
  public boolean isMute()
  {
    return this.c;
  }
  
  public boolean isUseBackCamera()
  {
    return this.e;
  }
  
  public boolean isVideoOff()
  {
    return this.b;
  }
  
  public void setExtension(String paramString)
  {
    this.d = paramString;
  }
  
  public void setExternalVideoSource(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setName(String paramString)
  {
    this.a = paramString;
  }
  
  public void setPubType(a.c paramc)
  {
    this.i = paramc;
  }
  
  public void setPubView(View paramView)
  {
    this.h = paramView;
  }
  
  public void setUseBackCamera(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setVheight(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setVideoOff(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setVwidth(int paramInt)
  {
    this.f = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/mediamanager/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */