package cn.testin.analysis;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class r
{
  protected Context a;
  private Executor b;
  
  public r(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.b == null) {
      this.b = Executors.newFixedThreadPool(1);
    }
    this.b.execute(paramRunnable);
  }
  
  protected void a(String paramString1, String paramString2, af paramaf)
  {
    a(paramString1, paramString2, paramaf, true);
  }
  
  protected void a(String paramString1, String paramString2, af paramaf, boolean paramBoolean)
  {
    paramString1 = new ag(paramString1, paramString2, paramaf);
    paramString1.a(paramBoolean);
    a(paramString1);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */