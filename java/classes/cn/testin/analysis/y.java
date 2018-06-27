package cn.testin.analysis;

import java.util.concurrent.ScheduledFuture;

class y
{
  private OnExpUpdateListener b;
  private ScheduledFuture c;
  private Runnable d = new z(this);
  
  private y(u paramu, OnExpUpdateListener paramOnExpUpdateListener, int paramInt)
  {
    this.b = paramOnExpUpdateListener;
    if ((paramOnExpUpdateListener != null) && (paramInt > 0)) {
      this.c = aw.a(this.d, paramInt);
    }
  }
  
  private void a()
  {
    aw.a(this.c, false);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */