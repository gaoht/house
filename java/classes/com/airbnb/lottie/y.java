package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class y
  implements aa, bg, n.a
{
  private static final String a = y.class.getSimpleName();
  private final Matrix b = new Matrix();
  private final Path c = new Path();
  private final RectF d = new RectF();
  private final String e;
  private final List<x> f = new ArrayList();
  private final ax g;
  private List<bg> h;
  private cf i;
  
  y(ax paramax, o paramo, bu parambu)
  {
    this.e = parambu.getName();
    this.g = paramax;
    parambu = parambu.a();
    if (parambu.isEmpty()) {}
    for (;;)
    {
      return;
      Object localObject = parambu.get(parambu.size() - 1);
      if ((localObject instanceof j))
      {
        this.i = ((j)localObject).createAnimation();
        this.i.a(paramo);
        this.i.a(this);
      }
      int j = 0;
      if (j < parambu.size())
      {
        localObject = parambu.get(j);
        if ((localObject instanceof bt)) {
          this.f.add(new ad(paramax, paramo, (bt)localObject));
        }
        for (;;)
        {
          j += 1;
          break;
          if ((localObject instanceof ai)) {
            this.f.add(new aj(paramax, paramo, (ai)localObject));
          } else if ((localObject instanceof by)) {
            this.f.add(new ce(paramax, paramo, (by)localObject));
          } else if ((localObject instanceof ak)) {
            this.f.add(new al(paramax, paramo, (ak)localObject));
          } else if ((localObject instanceof bu)) {
            this.f.add(new y(paramax, paramo, (bu)localObject));
          } else if ((localObject instanceof bo)) {
            this.f.add(new bn(paramax, paramo, (bo)localObject));
          } else if ((localObject instanceof s)) {
            this.f.add(new ab(paramax, paramo, (s)localObject));
          } else if ((localObject instanceof bx)) {
            this.f.add(new br(paramax, paramo, (bx)localObject));
          } else if ((localObject instanceof bm)) {
            this.f.add(new bl(paramax, paramo, (bm)localObject));
          } else if ((localObject instanceof bz)) {
            this.f.add(new cg(paramo, (bz)localObject));
          } else if ((localObject instanceof bb)) {
            if (paramax.a()) {
              this.f.add(new bc((bb)localObject));
            } else {
              Log.w(a, "Animation contains merge paths but they are disabled.");
            }
          }
        }
      }
      paramo = new ArrayList();
      paramax = null;
      j = this.f.size() - 1;
      while (j >= 0)
      {
        parambu = (x)this.f.get(j);
        if ((parambu instanceof bc)) {
          paramax = (bc)parambu;
        }
        if ((paramax != null) && (parambu != paramax))
        {
          paramax.a(parambu);
          paramo.add(parambu);
        }
        j -= 1;
      }
      paramax = this.f.iterator();
      while (paramax.hasNext()) {
        if (paramo.contains((x)paramax.next())) {
          paramax.remove();
        }
      }
    }
  }
  
  List<bg> a()
  {
    if (this.h == null)
    {
      this.h = new ArrayList();
      int j = 0;
      while (j < this.f.size())
      {
        x localx = (x)this.f.get(j);
        if ((localx instanceof bg)) {
          this.h.add((bg)localx);
        }
        j += 1;
      }
    }
    return this.h;
  }
  
  public void addColorFilter(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    int j = 0;
    if (j < this.f.size())
    {
      x localx = (x)this.f.get(j);
      aa localaa;
      if ((localx instanceof aa))
      {
        localaa = (aa)localx;
        if ((paramString2 != null) && (!paramString2.equals(localx.getName()))) {
          break label85;
        }
        localaa.addColorFilter(paramString1, null, paramColorFilter);
      }
      for (;;)
      {
        j += 1;
        break;
        label85:
        localaa.addColorFilter(paramString1, paramString2, paramColorFilter);
      }
    }
  }
  
  Matrix b()
  {
    if (this.i != null) {
      return this.i.b();
    }
    this.b.reset();
    return this.b;
  }
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    this.b.set(paramMatrix);
    int j = paramInt;
    if (this.i != null)
    {
      this.b.preConcat(this.i.b());
      j = (int)(((Integer)this.i.a().getValue()).intValue() / 100.0F * paramInt / 255.0F * 255.0F);
    }
    paramInt = this.f.size() - 1;
    while (paramInt >= 0)
    {
      paramMatrix = this.f.get(paramInt);
      if ((paramMatrix instanceof aa)) {
        ((aa)paramMatrix).draw(paramCanvas, this.b, j);
      }
      paramInt -= 1;
    }
  }
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix)
  {
    this.b.set(paramMatrix);
    if (this.i != null) {
      this.b.preConcat(this.i.b());
    }
    this.d.set(0.0F, 0.0F, 0.0F, 0.0F);
    int j = this.f.size() - 1;
    if (j >= 0)
    {
      paramMatrix = (x)this.f.get(j);
      if ((paramMatrix instanceof aa))
      {
        ((aa)paramMatrix).getBounds(this.d, this.b);
        if (!paramRectF.isEmpty()) {
          break label117;
        }
        paramRectF.set(this.d);
      }
      for (;;)
      {
        j -= 1;
        break;
        label117:
        paramRectF.set(Math.min(paramRectF.left, this.d.left), Math.min(paramRectF.top, this.d.top), Math.max(paramRectF.right, this.d.right), Math.max(paramRectF.bottom, this.d.bottom));
      }
    }
  }
  
  public String getName()
  {
    return this.e;
  }
  
  public Path getPath()
  {
    this.b.reset();
    if (this.i != null) {
      this.b.set(this.i.b());
    }
    this.c.reset();
    int j = this.f.size() - 1;
    while (j >= 0)
    {
      x localx = (x)this.f.get(j);
      if ((localx instanceof bg)) {
        this.c.addPath(((bg)localx).getPath(), this.b);
      }
      j -= 1;
    }
    return this.c;
  }
  
  public void onValueChanged()
  {
    this.g.invalidateSelf();
  }
  
  public void setContents(List<x> paramList1, List<x> paramList2)
  {
    paramList2 = new ArrayList(paramList1.size() + this.f.size());
    paramList2.addAll(paramList1);
    int j = this.f.size() - 1;
    while (j >= 0)
    {
      paramList1 = (x)this.f.get(j);
      paramList1.setContents(paramList2, this.f.subList(0, j));
      paramList2.add(paramList1);
      j -= 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */