package com.ziroom.ziroomcustomer.ziroomstation.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;
import com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.a;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;

public class f
{
  private static f c;
  public Handler a = new Handler();
  public final String b = getClass().getSimpleName();
  private Context d;
  private int e;
  private int f;
  private HashMap<String, SoftReference<Bitmap>> g = new HashMap();
  
  public f(Context paramContext)
  {
    if (paramContext.getApplicationContext() != null) {}
    for (this.d = paramContext.getApplicationContext();; this.d = paramContext)
    {
      new DisplayMetrics();
      paramContext = this.d.getResources().getDisplayMetrics();
      this.e = paramContext.widthPixels;
      this.f = paramContext.heightPixels;
      return;
    }
  }
  
  private void a(ImageView paramImageView)
  {
    paramImageView.setBackgroundResource(2130837781);
  }
  
  private void a(ImageView paramImageView, Bitmap paramBitmap, String paramString)
  {
    int i = a.readPictureDegree(paramString);
    Bitmap localBitmap = paramBitmap;
    if (Math.abs(i) > 0) {
      localBitmap = a.rotaingImageView(i, paramBitmap);
    }
    if ((paramImageView != null) && (localBitmap != null) && (paramString != null))
    {
      paramImageView.setImageBitmap(localBitmap);
      paramImageView.setTag(paramString);
    }
  }
  
  public static f getInstance(Context paramContext)
  {
    if (c == null) {}
    try
    {
      c = new f(paramContext);
      return c;
    }
    finally {}
  }
  
  public Bitmap compressImg(String paramString, boolean paramBoolean)
    throws IOException
  {
    BufferedInputStream localBufferedInputStream = new BufferedInputStream(new FileInputStream(new File(paramString)));
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeStream(localBufferedInputStream, null, localOptions);
    localBufferedInputStream.close();
    int i;
    if (paramBoolean)
    {
      i = 0;
      for (;;)
      {
        if ((localOptions.outWidth >> i <= 256) && (localOptions.outHeight >> i <= 256))
        {
          paramString = new BufferedInputStream(new FileInputStream(new File(paramString)));
          localOptions.inSampleSize = ((int)Math.pow(2.0D, i));
          localOptions.inJustDecodeBounds = false;
          return BitmapFactory.decodeStream(paramString, null, localOptions);
        }
        i += 1;
      }
    }
    for (;;)
    {
      i += 1;
      while ((localOptions.outWidth >> i <= this.e) && (localOptions.outHeight >> i <= this.f))
      {
        paramString = new BufferedInputStream(new FileInputStream(new File(paramString)));
        localOptions.inSampleSize = ((int)Math.pow(2.0D, i));
        localOptions.inJustDecodeBounds = false;
        return BitmapFactory.decodeStream(paramString, null, localOptions);
        i = 0;
      }
    }
  }
  
  public void displayBmp(ImageView paramImageView, String paramString1, String paramString2)
  {
    displayBmp(paramImageView, paramString1, paramString2, true);
  }
  
  public void displayBmp(final ImageView paramImageView, final String paramString1, final String paramString2, final boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      Log.e(this.b, "no paths pass in");
    }
    while ((paramImageView.getTag() != null) && (paramImageView.getTag().equals(paramString2))) {
      return;
    }
    a(paramImageView);
    final String str;
    label63:
    HashMap localHashMap;
    if ((!TextUtils.isEmpty(paramString1)) && (paramBoolean))
    {
      str = paramString1;
      paramImageView.setTag(str);
      localHashMap = this.g;
      if (!paramBoolean) {
        break label205;
      }
      localObject = str + 256 + 256;
      label109:
      if (!localHashMap.containsKey(localObject)) {
        break label219;
      }
      localHashMap = this.g;
      if (!paramBoolean) {
        break label212;
      }
    }
    label205:
    label212:
    for (Object localObject = str + 256 + 256;; localObject = str)
    {
      localObject = (Bitmap)((SoftReference)localHashMap.get(localObject)).get();
      if (localObject == null) {
        break label219;
      }
      a(paramImageView, (Bitmap)localObject, str);
      return;
      if (TextUtils.isEmpty(paramString2)) {
        break;
      }
      str = paramString2;
      break label63;
      localObject = str;
      break label109;
    }
    label219:
    paramImageView.setImageBitmap(null);
    new Thread()
    {
      Bitmap a;
      
      public void run()
      {
        try
        {
          if ((str != null) && (str.equals(paramString1))) {
            this.a = BitmapFactory.decodeFile(str);
          }
          if (this.a == null) {
            this.a = f.this.compressImg(paramString2, paramBoolean);
          }
        }
        catch (Exception localException)
        {
          f localf;
          String str;
          label136:
          for (;;) {}
        }
        if (this.a != null)
        {
          localf = f.this;
          if (!paramBoolean) {
            break label136;
          }
        }
        for (str = str + 256 + 256;; str = str)
        {
          localf.put(str, this.a);
          f.this.a.post(new Runnable()
          {
            public void run()
            {
              f.a(f.this, f.1.this.f, f.1.this.a, f.1.this.b);
            }
          });
          return;
        }
      }
    }.start();
  }
  
  public void put(String paramString, Bitmap paramBitmap)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramBitmap != null)) {
      this.g.put(paramString, new SoftReference(paramBitmap));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/utils/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */