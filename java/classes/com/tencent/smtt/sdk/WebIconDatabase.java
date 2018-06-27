package com.tencent.smtt.sdk;

import android.content.ContentResolver;
import android.graphics.Bitmap;

@Deprecated
public class WebIconDatabase
{
  private static WebIconDatabase a;
  
  private static WebIconDatabase a()
  {
    try
    {
      if (a == null) {
        a = new WebIconDatabase();
      }
      WebIconDatabase localWebIconDatabase = a;
      return localWebIconDatabase;
    }
    finally {}
  }
  
  public static WebIconDatabase getInstance()
  {
    return a();
  }
  
  public void bulkRequestIconForPageUrl(ContentResolver paramContentResolver, String paramString, a parama) {}
  
  public void close()
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c()))
    {
      localbg.d().m();
      return;
    }
    android.webkit.WebIconDatabase.getInstance().close();
  }
  
  public void open(String paramString)
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c()))
    {
      localbg.d().b(paramString);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().open(paramString);
  }
  
  public void releaseIconForPageUrl(String paramString)
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c()))
    {
      localbg.d().d(paramString);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().releaseIconForPageUrl(paramString);
  }
  
  public void removeAllIcons()
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c()))
    {
      localbg.d().l();
      return;
    }
    android.webkit.WebIconDatabase.getInstance().removeAllIcons();
  }
  
  public void requestIconForPageUrl(String paramString, a parama)
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c()))
    {
      localbg.d().a(paramString, new ay(this, parama));
      return;
    }
    android.webkit.WebIconDatabase.getInstance().requestIconForPageUrl(paramString, new az(this, parama));
  }
  
  public void retainIconForPageUrl(String paramString)
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c()))
    {
      localbg.d().c(paramString);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().retainIconForPageUrl(paramString);
  }
  
  @Deprecated
  public static abstract interface a
  {
    public abstract void a(String paramString, Bitmap paramBitmap);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/tencent/smtt/sdk/WebIconDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */