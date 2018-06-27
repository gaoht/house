package cn.testin.analysis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class fv
  implements fy
{
  private Map<fs, ?> a;
  private fy[] b;
  
  private ga b(fq paramfq)
  {
    if (this.b != null)
    {
      fy[] arrayOffy = this.b;
      int j = arrayOffy.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOffy[i];
        try
        {
          localObject = ((fy)localObject).a(paramfq, this.a);
          return (ga)localObject;
        }
        catch (fz localfz)
        {
          i += 1;
        }
      }
    }
    throw fw.a();
  }
  
  public ga a(fq paramfq)
  {
    if (this.b == null) {
      a(null);
    }
    return b(paramfq);
  }
  
  public ga a(fq paramfq, Map<fs, ?> paramMap)
  {
    a(paramMap);
    return b(paramfq);
  }
  
  public void a()
  {
    if (this.b != null)
    {
      fy[] arrayOffy = this.b;
      int j = arrayOffy.length;
      int i = 0;
      while (i < j)
      {
        arrayOffy[i].a();
        i += 1;
      }
    }
  }
  
  public void a(Map<fs, ?> paramMap)
  {
    this.a = paramMap;
    if (paramMap == null) {}
    for (paramMap = null;; paramMap = (Collection)paramMap.get(fs.c))
    {
      ArrayList localArrayList = new ArrayList();
      if ((paramMap != null) && (paramMap.contains(fo.a))) {
        localArrayList.add(new hj());
      }
      if (localArrayList.isEmpty()) {
        localArrayList.add(new hj());
      }
      this.b = ((fy[])localArrayList.toArray(new fy[localArrayList.size()]));
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/fv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */