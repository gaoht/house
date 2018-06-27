package android.support.transition;

import android.os.IBinder;

class ba
  implements bc
{
  private final IBinder a;
  
  ba(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof ba)) && (((ba)paramObject).a.equals(this.a));
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */