package com.airbnb.lottie;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.graphics.Path.Op;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.List;

@TargetApi(19)
class bc
  implements bg
{
  private final Path a = new Path();
  private final Path b = new Path();
  private final Path c = new Path();
  private final String d;
  private final List<bg> e = new ArrayList();
  private final bb f;
  
  bc(bb parambb)
  {
    if (Build.VERSION.SDK_INT < 19) {
      throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
    }
    this.d = parambb.getName();
    this.f = parambb;
  }
  
  private void a()
  {
    int i = 0;
    while (i < this.e.size())
    {
      this.c.addPath(((bg)this.e.get(i)).getPath());
      i += 1;
    }
  }
  
  @TargetApi(19)
  private void a(Path.Op paramOp)
  {
    int k = 0;
    this.b.reset();
    this.a.reset();
    int i = this.e.size() - 1;
    List localList;
    Path localPath;
    while (i >= 1)
    {
      localbg = (bg)this.e.get(i);
      if ((localbg instanceof y))
      {
        localList = ((y)localbg).a();
        int j = localList.size() - 1;
        while (j >= 0)
        {
          localPath = ((bg)localList.get(j)).getPath();
          localPath.transform(((y)localbg).b());
          this.b.addPath(localPath);
          j -= 1;
        }
      }
      this.b.addPath(localbg.getPath());
      i -= 1;
    }
    bg localbg = (bg)this.e.get(0);
    if ((localbg instanceof y))
    {
      localList = ((y)localbg).a();
      i = k;
      while (i < localList.size())
      {
        localPath = ((bg)localList.get(i)).getPath();
        localPath.transform(((y)localbg).b());
        this.a.addPath(localPath);
        i += 1;
      }
    }
    this.a.set(localbg.getPath());
    this.c.op(this.a, this.b, paramOp);
  }
  
  void a(x paramx)
  {
    if ((paramx instanceof bg)) {
      this.e.add((bg)paramx);
    }
  }
  
  public String getName()
  {
    return this.d;
  }
  
  public Path getPath()
  {
    this.c.reset();
    switch (1.a[this.f.a().ordinal()])
    {
    }
    for (;;)
    {
      return this.c;
      a();
      continue;
      a(Path.Op.UNION);
      continue;
      a(Path.Op.REVERSE_DIFFERENCE);
      continue;
      a(Path.Op.INTERSECT);
      continue;
      a(Path.Op.XOR);
    }
  }
  
  public void setContents(List<x> paramList1, List<x> paramList2)
  {
    int i = 0;
    while (i < this.e.size())
    {
      ((bg)this.e.get(i)).setContents(paramList1, paramList2);
      i += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */