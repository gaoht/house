package com.airbnb.lottie;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable.Callback;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class an
{
  private final Context a;
  private String b;
  private ao c;
  private final Map<String, ay> d;
  private final Map<String, Bitmap> e = new HashMap();
  
  an(Drawable.Callback paramCallback, String paramString, ao paramao, Map<String, ay> paramMap)
  {
    this.b = paramString;
    if ((!TextUtils.isEmpty(paramString)) && (this.b.charAt(this.b.length() - 1) != '/')) {
      this.b += '/';
    }
    if (!(paramCallback instanceof View))
    {
      Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
      this.d = new HashMap();
      this.a = null;
      return;
    }
    this.a = ((View)paramCallback).getContext();
    this.d = paramMap;
    a(paramao);
  }
  
  Bitmap a(String paramString)
  {
    Object localObject2 = (Bitmap)this.e.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = (ay)this.d.get(paramString);
      if (localObject1 != null) {
        break label42;
      }
      localObject1 = null;
    }
    label42:
    do
    {
      return (Bitmap)localObject1;
      if (this.c == null) {
        break;
      }
      localObject2 = this.c.fetchBitmap((ay)localObject1);
      localObject1 = localObject2;
    } while (localObject2 == null);
    this.e.put(paramString, localObject2);
    return (Bitmap)localObject2;
    try
    {
      if (TextUtils.isEmpty(this.b)) {
        throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
      }
    }
    catch (IOException paramString)
    {
      Log.w("LOTTIE", "Unable to open asset.", paramString);
      return null;
    }
    localObject1 = this.a.getAssets().open(this.b + ((ay)localObject1).getFileName());
    localObject2 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject2).inScaled = true;
    ((BitmapFactory.Options)localObject2).inDensity = 160;
    localObject1 = BitmapFactory.decodeStream((InputStream)localObject1, null, (BitmapFactory.Options)localObject2);
    this.e.put(paramString, localObject1);
    return (Bitmap)localObject1;
  }
  
  Bitmap a(String paramString, Bitmap paramBitmap)
  {
    return (Bitmap)this.e.put(paramString, paramBitmap);
  }
  
  void a()
  {
    Iterator localIterator = this.e.entrySet().iterator();
    while (localIterator.hasNext())
    {
      ((Bitmap)((Map.Entry)localIterator.next()).getValue()).recycle();
      localIterator.remove();
    }
  }
  
  void a(ao paramao)
  {
    this.c = paramao;
  }
  
  boolean a(Context paramContext)
  {
    return ((paramContext == null) && (this.a == null)) || ((paramContext != null) && (this.a.equals(paramContext)));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */