package com.growingio.android.sdk.circle.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.growingio.android.sdk.circle.f;
import com.growingio.android.sdk.collection.AppState;
import com.growingio.android.sdk.models.c;
import com.growingio.android.sdk.models.c.a;
import com.growingio.android.sdk.utils.ThreadUtils;
import java.util.ArrayList;
import java.util.HashMap;

public class e
  extends f
{
  private int a;
  private int[] b;
  private final int c = 100;
  private final int d = 150;
  private final int e = 75;
  private final int f = 75;
  private final int g = 256;
  private final int h = 200;
  private final int i = 15;
  private Bitmap j;
  private c[] k;
  private ArrayList<b> l = new ArrayList();
  private ArrayList<b> m = new ArrayList();
  @SuppressLint({"UseSparseArrays"})
  private HashMap<Integer, Bitmap> n = new HashMap();
  private ArrayList<View> o = new ArrayList();
  private Context p;
  private Runnable q = new Runnable()
  {
    public void run()
    {
      e.a(e.this);
      e.b(e.this);
      int i = 0;
      while (i <= 100)
      {
        e.a(e.this, i);
        i += 1;
      }
    }
  };
  private Runnable r = new Runnable()
  {
    public void run()
    {
      e.c(e.this);
      ThreadUtils.a(e.d(e.this), 15L);
    }
  };
  
  @TargetApi(11)
  public e(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private int a(int paramInt)
  {
    if (this.a == 0) {
      return 50;
    }
    return paramInt * 100 / this.a;
  }
  
  private Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    int i4 = paramBitmap.getWidth();
    int i5 = paramBitmap.getHeight();
    int i6 = i4 * i5;
    int[] arrayOfInt = new int[i6];
    paramBitmap.getPixels(arrayOfInt, 0, i4, 0, 0, i4, i5);
    int i1 = 0;
    if (i1 < i6)
    {
      int i3 = (int)((arrayOfInt[i1] >> 24 & 0xFF) * paramFloat);
      if (i3 > 200) {}
      for (int i2 = 200;; i2 = i3)
      {
        arrayOfInt[i1] = (i2 << 24 | this.b[i3] & 0xFFFFFF);
        i1 += 1;
        break;
      }
    }
    paramBitmap.setPixels(arrayOfInt, 0, i4, 0, 0, i4, i5);
    return paramBitmap;
  }
  
  private Bitmap a(b paramb)
  {
    return (Bitmap)this.n.get(Integer.valueOf(a(paramb.b)));
  }
  
  private void a(Context paramContext)
  {
    this.p = paramContext;
    setBackgroundColor(855638016);
    new Thread(this.q).start();
    ThreadUtils.a(this.r, 15L);
  }
  
  private void a(View paramView)
  {
    this.o.add(paramView);
    addView(paramView);
  }
  
  private void b(int paramInt)
  {
    float f1 = paramInt / 100.0F;
    if (!this.n.containsKey(Integer.valueOf(paramInt))) {
      this.n.put(Integer.valueOf(paramInt), a(Bitmap.createBitmap(this.j), f1 * 0.6F + 0.4F));
    }
  }
  
  private void b(View paramView)
  {
    this.o.remove(paramView);
    removeView(paramView);
  }
  
  private void d()
  {
    int i2 = 0;
    this.m.clear();
    this.m.addAll(this.l);
    int i3 = this.m.size();
    Object localObject1 = new Object();
    int i1 = 0;
    Object localObject2;
    while (i1 < i3)
    {
      localObject2 = (b)this.m.get(i1);
      if (((b)localObject2).e == null)
      {
        Bitmap localBitmap = a((b)localObject2);
        if (localBitmap != null)
        {
          ((b)localObject2).a(this.p, localBitmap);
          a(((b)localObject2).e);
        }
      }
      if (((b)localObject2).e.getParent() == null) {
        a(((b)localObject2).e);
      }
      if ((((b)localObject2).e != null) && (((b)localObject2).c()))
      {
        ((b)localObject2).b();
        ((b)localObject2).e.setTag(84159249, localObject1);
      }
      i1 += 1;
    }
    i1 = this.o.size();
    if (i2 < i1)
    {
      localObject2 = (View)this.o.get(i2);
      if (((View)localObject2).getTag(84159249) == localObject1) {
        break label219;
      }
      b((View)localObject2);
      i2 -= 1;
      i1 -= 1;
    }
    label219:
    for (;;)
    {
      i2 += 1;
      break;
      return;
    }
  }
  
  private void e()
  {
    this.a = 0;
    int i3 = this.k.length;
    int i1 = 0;
    while (i1 < i3)
    {
      c.a[] arrayOfa = this.k[i1].c();
      int i4 = arrayOfa.length;
      int i2 = 0;
      while (i2 < i4)
      {
        int i5 = arrayOfa[i2].b();
        if (i5 > this.a) {
          this.a = i5;
        }
        i2 += 1;
      }
      i1 += 1;
    }
  }
  
  private void f()
  {
    Bitmap localBitmap = Bitmap.createBitmap(256, 1, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    localPaint.setShader(new LinearGradient(0.0F, 0.0F, 256.0F, 1.0F, new int[] { -16776961, -16711936, 65280, -65536 }, new float[] { 0.25F, 0.55F, 0.85F, 1.0F }, localTileMode));
    localCanvas.drawLine(0.0F, 0.0F, 256.0F, 1.0F, localPaint);
    localCanvas.save(31);
    localCanvas.restore();
    this.b = new int['Ā'];
    localBitmap.getPixels(this.b, 0, 256, 0, 0, 256, 1);
  }
  
  private void g()
  {
    Object localObject1 = Shader.TileMode.CLAMP;
    Object localObject2 = new RadialGradient(75.0F, 75.0F, 75.0F, new int[] { -16777216, -16777216, 0 }, new float[] { 0.0F, 0.15F, 1.0F }, (Shader.TileMode)localObject1);
    localObject1 = new Paint();
    ((Paint)localObject1).setAntiAlias(true);
    ((Paint)localObject1).setStyle(Paint.Style.FILL);
    ((Paint)localObject1).setShader((Shader)localObject2);
    localObject2 = new RectF(0.0F, 0.0F, 150.0F, 150.0F);
    this.j = Bitmap.createBitmap(150, 150, Bitmap.Config.ARGB_8888);
    new Canvas(this.j).drawOval((RectF)localObject2, (Paint)localObject1);
  }
  
  public void a()
  {
    setVisibility(0);
  }
  
  public void a(ArrayList<b> paramArrayList)
  {
    this.l.clear();
    this.l.addAll(paramArrayList);
  }
  
  public void a(c[] paramArrayOfc)
  {
    this.k = paramArrayOfc;
    e();
    if (paramArrayOfc.length == 0) {
      Toast.makeText(AppState.l().i(), "当前页面尚无热图数据", 0).show();
    }
  }
  
  public void b()
  {
    setVisibility(8);
  }
  
  public void c()
  {
    this.k = new c[0];
    this.l.clear();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/circle/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */