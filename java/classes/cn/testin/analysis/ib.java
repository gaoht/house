package cn.testin.analysis;

public final class ib
{
  private final boolean a;
  
  ib(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void a(gc[] paramArrayOfgc)
  {
    if ((!this.a) || (paramArrayOfgc == null) || (paramArrayOfgc.length < 3)) {
      return;
    }
    gc localgc = paramArrayOfgc[0];
    paramArrayOfgc[0] = paramArrayOfgc[2];
    paramArrayOfgc[2] = localgc;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/ib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */