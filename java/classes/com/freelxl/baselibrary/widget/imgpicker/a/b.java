package com.freelxl.baselibrary.widget.imgpicker.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.c.a.a.a;
import com.c.a.a.c;
import java.io.IOException;
import java.io.OutputStream;

public class b
  implements a
{
  private final int a = 67108864;
  private final int b = 1;
  private com.c.a.a c;
  
  public b(Context paramContext)
  {
    try
    {
      this.c = com.c.a.a.open(paramContext.getExternalFilesDir(null), 1, 1, 67108864L);
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public Bitmap get(String paramString)
  {
    if (this.c != null) {
      try
      {
        paramString = this.c.get(paramString);
        if (paramString != null)
        {
          paramString = BitmapFactory.decodeStream(paramString.getInputStream(0));
          return paramString;
        }
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public void put(String paramString, Bitmap paramBitmap)
  {
    if (this.c != null) {
      try
      {
        paramString = this.c.edit(paramString);
        if (paramString != null)
        {
          OutputStream localOutputStream = paramString.newOutputStream(0);
          if (!paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localOutputStream)) {
            break label51;
          }
          paramString.commit();
        }
        for (;;)
        {
          this.c.flush();
          return;
          label51:
          paramString.abort();
        }
        return;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/widget/imgpicker/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */