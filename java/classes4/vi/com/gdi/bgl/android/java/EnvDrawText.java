package vi.com.gdi.bgl.android.java;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.util.SparseArray;
import com.baidu.platform.comapi.util.f;

public class EnvDrawText
{
  private static final String a = EnvDrawText.class.getSimpleName();
  public static boolean bBmpChange;
  public static Bitmap bmp;
  public static int[] buffer = null;
  public static Canvas canvasTemp;
  public static SparseArray<a> fontCache = null;
  public static int iWordHightMax;
  public static int iWordWidthMax;
  public static Paint pt = null;
  
  static
  {
    iWordWidthMax = 0;
    iWordHightMax = 0;
    bBmpChange = false;
    bmp = null;
    canvasTemp = null;
  }
  
  public static int[] drawText(String paramString, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Object localObject;
    for (;;)
    {
      try
      {
        if (pt == null)
        {
          pt = new Paint();
          localObject = f.f();
          i = paramInt2;
          if (localObject == null) {
            break label1270;
          }
          i = paramInt2;
          if (!((String)localObject).equals("vivo X3L")) {
            break label1270;
          }
          i = 0;
          break label1270;
          localObject = Typeface.create(Typeface.DEFAULT, 0);
          pt.setTypeface((Typeface)localObject);
          pt.setSubpixelText(true);
          pt.setAntiAlias(true);
          if ((i != 0) && (fontCache != null))
          {
            localObject = (a)fontCache.get(i);
            if (localObject != null) {
              pt.setTypeface(((a)localObject).a);
            }
          }
          pt.setTextSize(paramInt1);
          paramInt2 = paramString.indexOf('\\', 0);
          if (paramInt2 != -1) {
            break;
          }
          localObject = pt.getFontMetrics();
          paramInt2 = (int)pt.measureText(paramString);
          paramInt1 = (int)Math.ceil(((Paint.FontMetrics)localObject).descent - ((Paint.FontMetrics)localObject).ascent);
          paramArrayOfInt[0] = paramInt2;
          paramArrayOfInt[1] = paramInt1;
          paramInt2 = (int)Math.pow(2.0D, (int)Math.ceil(Math.log(paramInt2) / Math.log(2.0D)));
          paramInt1 = (int)Math.pow(2.0D, (int)Math.ceil(Math.log(paramInt1) / Math.log(2.0D)));
          if ((iWordWidthMax < paramInt2) || (iWordHightMax < paramInt1))
          {
            bBmpChange = true;
            iWordWidthMax = paramInt2;
            iWordHightMax = paramInt1;
          }
          paramArrayOfInt[2] = iWordWidthMax;
          paramArrayOfInt[3] = iWordHightMax;
          if (bBmpChange != true) {
            break label575;
          }
          if ((bmp != null) && (!bmp.isRecycled())) {
            bmp.recycle();
          }
          bmp = Bitmap.createBitmap(iWordWidthMax, iWordHightMax, Bitmap.Config.ARGB_8888);
          if (canvasTemp == null) {
            canvasTemp = new Canvas();
          }
          canvasTemp.setBitmap(bmp);
          if ((0xFF000000 & paramInt5) != 0) {
            break label585;
          }
          canvasTemp.drawColor(33554431);
          if (paramInt6 != 0)
          {
            pt.setStrokeWidth(paramInt6);
            pt.setStrokeCap(Paint.Cap.ROUND);
            pt.setStrokeJoin(Paint.Join.ROUND);
            pt.setStyle(Paint.Style.STROKE);
            pt.setColor(paramInt4);
            canvasTemp.drawText(paramString, 0.0F, 0.0F - ((Paint.FontMetrics)localObject).ascent, pt);
          }
          pt.setStyle(Paint.Style.FILL);
          pt.setColor(paramInt3);
          canvasTemp.drawText(paramString, 0.0F, 0.0F - ((Paint.FontMetrics)localObject).ascent, pt);
          label461:
          paramInt1 = iWordWidthMax;
          paramInt2 = iWordHightMax;
          if (bBmpChange == true) {
            buffer = new int[paramInt1 * paramInt2];
          }
          bmp.getPixels(buffer, 0, iWordWidthMax, 0, 0, iWordWidthMax, iWordHightMax);
          bBmpChange = false;
          paramString = buffer;
          return paramString;
        }
        pt.reset();
        continue;
        localObject = Typeface.create(Typeface.DEFAULT, 1);
      }
      finally {}
      pt.setTypeface((Typeface)localObject);
      continue;
      localObject = Typeface.create(Typeface.DEFAULT, 2);
      pt.setTypeface((Typeface)localObject);
      continue;
      label575:
      bmp.eraseColor(0);
      continue;
      label585:
      canvasTemp.drawColor(paramInt5);
    }
    paramInt1 = (int)pt.measureText(paramString.substring(0, paramInt2));
    int i = paramInt2 + 1;
    paramInt2 = 2;
    int j = paramString.indexOf('\\', i);
    if (j > 0)
    {
      i = (int)pt.measureText(paramString.substring(i, j));
      if (i <= paramInt1) {
        break label1312;
      }
      paramInt1 = i;
    }
    else
    {
      j = paramInt1;
      if (i != paramString.length())
      {
        i = (int)pt.measureText(paramString.substring(i, paramString.length()));
        j = paramInt1;
        if (i > paramInt1) {
          j = i;
        }
      }
      localObject = pt.getFontMetrics();
      i = (int)Math.ceil(((Paint.FontMetrics)localObject).descent - ((Paint.FontMetrics)localObject).ascent);
      paramInt1 = i * paramInt2;
      paramArrayOfInt[0] = j;
      paramArrayOfInt[1] = paramInt1;
      paramInt2 = (int)Math.pow(2.0D, (int)Math.ceil(Math.log(j) / Math.log(2.0D)));
      paramInt1 = (int)Math.pow(2.0D, (int)Math.ceil(Math.log(paramInt1) / Math.log(2.0D)));
      if ((iWordWidthMax < paramInt2) || (iWordHightMax < paramInt1))
      {
        bBmpChange = true;
        iWordWidthMax = paramInt2;
        iWordHightMax = paramInt1;
      }
      paramArrayOfInt[2] = iWordWidthMax;
      paramArrayOfInt[3] = iWordHightMax;
      if (bBmpChange == true)
      {
        if ((bmp != null) && (!bmp.isRecycled())) {
          bmp.recycle();
        }
        bmp = Bitmap.createBitmap(iWordWidthMax, iWordHightMax, Bitmap.Config.ARGB_8888);
        if (canvasTemp == null) {
          canvasTemp = new Canvas();
        }
        canvasTemp.setBitmap(bmp);
        label902:
        if ((0xFF000000 & paramInt5) != 0) {
          break label1105;
        }
        canvasTemp.drawColor(33554431);
        break label1315;
      }
    }
    for (;;)
    {
      paramInt5 = paramString.indexOf('\\', paramInt2);
      if (paramInt5 > 0)
      {
        String str = paramString.substring(paramInt2, paramInt5);
        j = (int)pt.measureText(str);
        paramInt2 = paramInt5 + 1;
        if (paramInt6 != 0)
        {
          pt.setStrokeWidth(paramInt6);
          pt.setStrokeCap(Paint.Cap.ROUND);
          pt.setStrokeJoin(Paint.Join.ROUND);
          pt.setStyle(Paint.Style.STROKE);
          pt.setColor(paramInt4);
          canvasTemp.drawText(str, (paramArrayOfInt[0] - j) / 2, paramInt1 * i - ((Paint.FontMetrics)localObject).ascent, pt);
        }
        pt.setStyle(Paint.Style.FILL);
        pt.setColor(paramInt3);
        canvasTemp.drawText(str, (paramArrayOfInt[0] - j) / 2, paramInt1 * i - ((Paint.FontMetrics)localObject).ascent, pt);
        paramInt1 += 1;
        continue;
        bmp.eraseColor(0);
        break label902;
        label1105:
        canvasTemp.drawColor(paramInt5);
        break label1315;
      }
      if (paramInt2 == paramString.length()) {
        break label461;
      }
      paramString = paramString.substring(paramInt2, paramString.length());
      paramInt2 = (int)pt.measureText(paramString);
      if (paramInt6 != 0)
      {
        pt.setStrokeWidth(paramInt6);
        pt.setStrokeCap(Paint.Cap.ROUND);
        pt.setStrokeJoin(Paint.Join.ROUND);
        pt.setStyle(Paint.Style.STROKE);
        pt.setColor(paramInt4);
        canvasTemp.drawText(paramString, (paramArrayOfInt[0] - paramInt2) / 2, paramInt1 * i - ((Paint.FontMetrics)localObject).ascent, pt);
      }
      pt.setStyle(Paint.Style.FILL);
      pt.setColor(paramInt3);
      canvasTemp.drawText(paramString, (paramArrayOfInt[0] - paramInt2) / 2, paramInt1 * i - ((Paint.FontMetrics)localObject).ascent, pt);
      break label461;
      label1270:
      switch (i)
      {
      }
      break;
      label1312:
      for (;;)
      {
        paramInt2 += 1;
        i = j + 1;
        break;
      }
      label1315:
      paramInt2 = 0;
      paramInt1 = 0;
    }
  }
  
  public static short[] getTextSize(String paramString, int paramInt1, int paramInt2)
  {
    int i = paramString.length();
    Object localObject;
    if (i == 0)
    {
      localObject = null;
      return (short[])localObject;
    }
    Paint localPaint = new Paint();
    localPaint.setSubpixelText(true);
    localPaint.setAntiAlias(true);
    localPaint.setTextSize(paramInt1);
    switch (paramInt2)
    {
    default: 
      localPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
    }
    for (;;)
    {
      short[] arrayOfShort = new short[i];
      paramInt1 = 0;
      for (;;)
      {
        localObject = arrayOfShort;
        if (paramInt1 >= i) {
          break;
        }
        arrayOfShort[paramInt1] = ((short)(int)localPaint.measureText(paramString.substring(0, paramInt1 + 1)));
        paramInt1 += 1;
      }
      localPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
      continue;
      localPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 2));
    }
  }
  
  public static void registFontCache(int paramInt, Typeface paramTypeface)
  {
    if ((paramInt == 0) || (paramTypeface == null)) {}
    for (;;)
    {
      return;
      a locala;
      try
      {
        if (fontCache == null) {
          fontCache = new SparseArray();
        }
        locala = (a)fontCache.get(paramInt);
        if (locala == null)
        {
          locala = new a();
          locala.a = paramTypeface;
          locala.b += 1;
          fontCache.put(paramInt, locala);
          continue;
        }
      }
      finally {}
      locala.b += 1;
    }
  }
  
  /* Error */
  public static void removeFontCache(int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 48	vi/com/gdi/bgl/android/java/EnvDrawText:fontCache	Landroid/util/SparseArray;
    //   6: iload_0
    //   7: invokevirtual 97	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   10: checkcast 99	vi/com/gdi/bgl/android/java/a
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +7 -> 22
    //   18: ldc 2
    //   20: monitorexit
    //   21: return
    //   22: aload_1
    //   23: aload_1
    //   24: getfield 241	vi/com/gdi/bgl/android/java/a:b	I
    //   27: iconst_1
    //   28: isub
    //   29: putfield 241	vi/com/gdi/bgl/android/java/a:b	I
    //   32: aload_1
    //   33: getfield 241	vi/com/gdi/bgl/android/java/a:b	I
    //   36: ifne -18 -> 18
    //   39: getstatic 48	vi/com/gdi/bgl/android/java/EnvDrawText:fontCache	Landroid/util/SparseArray;
    //   42: iload_0
    //   43: invokevirtual 249	android/util/SparseArray:remove	(I)V
    //   46: goto -28 -> 18
    //   49: astore_1
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramInt	int
    //   13	20	1	locala	a
    //   49	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	14	49	finally
    //   22	46	49	finally
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/vi/com/gdi/bgl/android/java/EnvDrawText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */