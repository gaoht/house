package com.unionpay.mobile.android.resource;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.NinePatchDrawable;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.j;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class c
{
  private static c c = null;
  private HashMap<Integer, WeakReference<Drawable.ConstantState>> a = new HashMap();
  private Context b = null;
  
  private c(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static c a(Context paramContext)
  {
    if (c == null) {
      c = new c(paramContext);
    }
    return c;
  }
  
  public final Drawable a(int paramInt)
  {
    return a(paramInt, -1, -1);
  }
  
  public final Drawable a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < 0)
    {
      localObject1 = null;
      return (Drawable)localObject1;
    }
    Object localObject1 = (WeakReference)this.a.get(Integer.valueOf(paramInt1));
    if (localObject1 != null)
    {
      localObject1 = (Drawable.ConstantState)((WeakReference)localObject1).get();
      if (localObject1 != null) {
        return ((Drawable.ConstantState)localObject1).newDrawable();
      }
      this.a.remove(Integer.valueOf(paramInt1));
    }
    int j = paramInt1 / 1000 * 1000;
    int i = paramInt1 - j;
    label119:
    Object localObject4;
    label165:
    long l;
    switch (j)
    {
    default: 
      localObject1 = null;
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject3 = a.class.getClassLoader().getResourceAsStream("assets/data.bin");
        localObject4 = new DataInputStream((InputStream)localObject3);
        j = paramInt1 - 1000;
        i = j * 8;
        l = i;
      }
      break;
    }
    for (;;)
    {
      try
      {
        l = ((DataInputStream)localObject4).skip(l);
        if (l < i)
        {
          i = (int)(i - l);
          break label165;
          j = b.e[i];
          localObject1 = b.d[i];
          localObject3 = b.b[i];
          localObject4 = b.c[i];
          localObject1 = g.a(j, (int[])localObject1, (float[])localObject3, localObject4[0], localObject4[1], localObject4[2], localObject4[3]);
          break label119;
          localObject1 = b.a[i];
          localObject1 = g.a(a(localObject1[0], paramInt2, paramInt3), a(localObject1[1], paramInt2, paramInt3), a(localObject1[2], paramInt2, paramInt3), a(localObject1[3], paramInt2, paramInt3));
          break label119;
          localObject1 = g.a(b.f[i], b.g[i], b.h[i]);
          break label119;
        }
        i = ((DataInputStream)localObject4).readInt();
        int k = ((DataInputStream)localObject4).readInt();
        i -= j * 8 + 8;
        l = ((DataInputStream)localObject4).skip(i);
        if (l < i)
        {
          i = (int)(i - l);
          continue;
        }
        ((DataInputStream)localObject4).mark(k);
        localObject1 = BitmapFactory.decodeStream((InputStream)localObject4);
        localObject5 = new Rect();
        if (((Bitmap)localObject1).getNinePatchChunk() != null) {
          continue;
        }
        if ((-1 == paramInt3) || (-1 == paramInt2)) {
          continue;
        }
        localObject5 = Bitmap.createScaledBitmap((Bitmap)localObject1, paramInt2, paramInt3, true);
        if (localObject5 != localObject1) {
          ((Bitmap)localObject1).recycle();
        }
        localObject1 = new BitmapDrawable(this.b.getResources(), (Bitmap)localObject5);
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        localObject3 = null;
        continue;
        if ((-1 == paramInt2) || (-1 != paramInt3)) {
          continue;
        }
        Object localObject5 = Bitmap.createScaledBitmap(localIOException, paramInt2, (int)(localIOException.getHeight() / localIOException.getWidth() * paramInt2), true);
        if (localObject5 == localIOException) {
          continue;
        }
        localIOException.recycle();
        Object localObject2 = new BitmapDrawable(this.b.getResources(), (Bitmap)localObject5);
        continue;
        localObject2 = new BitmapDrawable(this.b.getResources(), (Bitmap)localObject2);
        continue;
        localObject2 = new NinePatchDrawable(this.b.getResources(), (Bitmap)localObject2, ((Bitmap)localObject2).getNinePatchChunk(), (Rect)localObject5, null);
        continue;
      }
      ((DataInputStream)localObject4).close();
      ((InputStream)localObject3).close();
      localObject3 = localObject1;
      localObject1 = localObject3;
      if (localObject3 == null) {
        break;
      }
      this.a.put(Integer.valueOf(paramInt1), new WeakReference(((Drawable)localObject3).getConstantState()));
      return (Drawable)localObject3;
      if ((-1 == paramInt3) || (-1 != paramInt2)) {
        continue;
      }
      paramInt2 = (int)(((Bitmap)localObject1).getWidth() / ((Bitmap)localObject1).getHeight() * paramInt3);
      j.a("img", "w=" + paramInt2 + ",h=" + paramInt3);
      localObject5 = Bitmap.createScaledBitmap((Bitmap)localObject1, paramInt2, paramInt3, true);
      if (localObject5 != localObject1) {
        ((Bitmap)localObject1).recycle();
      }
      localObject1 = new BitmapDrawable(this.b.getResources(), (Bitmap)localObject5);
    }
  }
  
  public final void a()
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Drawable.ConstantState)((WeakReference)localIterator.next()).get();
      if (localObject != null)
      {
        localObject = ((Drawable.ConstantState)localObject).newDrawable();
        if ((localObject instanceof BitmapDrawable)) {
          ((BitmapDrawable)localObject).getBitmap().recycle();
        }
      }
    }
    this.a.clear();
    c = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/resource/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */