package c.a.b.e;

import c.a.b.d.b;
import c.a.b.d.c;

public abstract class e
  extends g
{
  public e(a.a parama)
  {
    super(parama);
  }
  
  public void c()
    throws b
  {
    if (!e()) {
      throw new c("Control frame cant have fin==false set");
    }
    if (f()) {
      throw new c("Control frame cant have rsv1==true set");
    }
    if (g()) {
      throw new c("Control frame cant have rsv2==true set");
    }
    if (h()) {
      throw new c("Control frame cant have rsv3==true set");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/c/a/b/e/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */