package com.superrtc.mediamanager;

import com.superrtc.sdk.g;

public class b
{
  public static class a
  {
    public a.a a;
    public String b;
    
    public static a newError(a.a parama, String paramString)
    {
      a locala = new a();
      locala.b = paramString;
      locala.a = parama;
      return locala;
    }
  }
  
  public static abstract interface b
  {
    public abstract void onDone(Object paramObject, b.a parama);
  }
  
  public static class c
  {
    public String a;
    public String b;
    public String c;
    
    public c(String paramString1, String paramString2, String paramString3)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
    }
  }
  
  public static class d
  {
    public String a;
    public g b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/mediamanager/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */