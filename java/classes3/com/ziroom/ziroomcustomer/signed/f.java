package com.ziroom.ziroomcustomer.signed;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.google.c.a;
import com.google.c.a.b;
import com.google.c.i;
import com.google.c.q;
import java.util.Hashtable;

public final class f
{
  public static Bitmap createQRCode(String paramString, int paramInt)
    throws q
  {
    new Hashtable().put(com.google.c.f.b, "utf-8");
    Object localObject = new i().encode(paramString, a.l, paramInt, paramInt);
    int j = ((b)localObject).getWidth();
    int k = ((b)localObject).getHeight();
    paramString = new int[j * k];
    paramInt = 0;
    while (paramInt < k)
    {
      int i = 0;
      if (i < j)
      {
        if (((b)localObject).get(i, paramInt)) {
          paramString[(paramInt * j + i)] = -16777216;
        }
        for (;;)
        {
          i += 1;
          break;
          paramString[(paramInt * j + i)] = -1;
        }
      }
      paramInt += 1;
    }
    localObject = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_8888);
    ((Bitmap)localObject).setPixels(paramString, 0, j, 0, 0, j, k);
    return (Bitmap)localObject;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */